package com.wsy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TestThread extends JFrame {

	JPanel jPanel1 = new JPanel();

	//XYLayout xYLayout1 = new XYLayout();

	JButton startButton = new JButton();

	JButton stopButton = new JButton();

	MyThread thread = null;

	public TestThread() {

	try {

	jbInit();

	}

	catch(Exception e) {

	e.printStackTrace();

	}}

	private void jbInit() throws Exception {

	// jPanel1.setLayout(xYLayout1);

	startButton.setText("start");

	startButton.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {

	startButton_actionPerformed(e);

	}

	});

	stopButton.setText("stop");

	stopButton.addActionListener(new java.awt.event.ActionListener() {

	public void actionPerformed(ActionEvent e) {

	stopButton_actionPerformed(e);

	}

	});

	this.getContentPane().add(jPanel1, BorderLayout.CENTER);

	jPanel1.add(startButton);
	startButton.setBounds(36, 105, 82, 30);

	jPanel1.add(stopButton);
	stopButton.setBounds(160, 108, 100, 31);
	}

	void startButton_actionPerformed(ActionEvent e) {

	if(thread != null) thread.stop();

	thread = new MyThread();

	thread.start();

	}

	void stopButton_actionPerformed(ActionEvent e) {

	if(thread != null) thread.stop();

	thread = null;

	}

	public static void main(String[] args){
		TestThread test = new TestThread();

		test.setSize(300,400);

		test.show();

	}

	private class MyThread extends Thread{
		public MyThread(){
		}

	

	public void run(){

		while(true){
			try{
				sleep(200);
		}catch(InterruptedException e){}
	
			System.out.println("this is a test!");
	
		}
	}
	}
}


