package com.wsy;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Commnicate extends JFrame{

	Thread t1;
	Thread t2;
	private int count=0;
	final JProgressBar progressBar = new JProgressBar();
	public static void main(String[] args) {
		init(new Commnicate(),150,100);

	}
	public Commnicate() {
		super();
		progressBar.setStringPainted(true);
		getContentPane().add(progressBar, BorderLayout.NORTH);	
deValue();
addValue();
t1.start();
t2.start();
//		final JPanel panel = new JPanel();
//		getContentPane().add(panel, BorderLayout.CENTER);
//
//		final JButton buttona = new JButton();
//		buttona.setText("����");
//		panel.add(buttona);
//		buttona.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent arg0) {
//				addValue();
//			}
//		});
//
//		final JButton buttonb = new JButton();
//		buttonb.setText("����");
//		buttonb.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				deValue();
//			}
//		});
//		panel.add(buttonb);
	}
	public void addValue(){
		t1=new Thread(new Runnable(){
			public void run(){
				while(true){
					if(count>=100){
						System.out.println("����������,�����̵߳ȴ�");
						break;
					}
					if (count == 0) {
						progressBar.setValue(count += 100);
						System.out.println("�������ĵ�ǰֵΪ��"+count);
						synchronized (t2) {
							System.out.println("����������ֵ�����Խ��еݼ�����");
							t2.notify();
						}
					}
					
					try{
						Thread.currentThread().sleep(100);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		});
		//t1.start();

	}
	public void deValue(){
		t2=new Thread(new Runnable(){
			public void run(){
				while (true) {
					if(count==0){
						synchronized (this) {
							try {
								wait();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
					progressBar.setValue(--count);
					System.out.println("�������ĵ�ǰֵΪ��" + count);
					try {
						Thread.currentThread().sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}

					
				}
			}
		});
		//t2.start();
	}
	public static void init(JFrame frame,int width,int height){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
}
