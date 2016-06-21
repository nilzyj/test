package com.mingrisoft;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyClien extends JFrame { // ������̳�JFrame��
    private PrintWriter writer; // ����PrintWriter�����
    Socket socket; // ����Socket����
    private JTextArea ta = new JTextArea(); // ����JtextArea����
    private JTextField tf = new JTextField(); // ����JtextField����
    Container cc; // ����Container����
    
    public MyClien(String title) { // ���췽��
        super(title); // ���ø���Ĺ��췽��
        cc = this.getContentPane(); // ʵ��������
        cc.add(ta, "North"); // ���ı�����ڴ�����ϲ�
        cc.add(tf, "South"); // ���ı�����ڴ�����²�
        tf.addActionListener(new ActionListener() { // ���¼�
                    public void actionPerformed(ActionEvent e) {
                        writer.println(tf.getText()); // ���ı�������Ϣд����
                        ta.append(tf.getText() + '\n'); // ���ı�������Ϣ��ʾ���ı�����
                        tf.setText(" "); // ���ı������
                    }
                });
    }
    
    private void connect() { // �����׽��ַ���
        ta.append("��������\n"); // �ı�������ʾ��Ϣ
        try { // ��׽�쳣
            socket = new Socket("192.168.1.131", 8998); // ʵ����Socket����
            writer = new PrintWriter(socket.getOutputStream(), true);
            ta.append("�������\n"); // �ı�������ʾ��Ϣ
        } catch (Exception e) {
            e.printStackTrace(); // ����쳣��Ϣ
        }
    }
    
    public static void main(String[] args) { // ������
        MyClien clien = new MyClien("�������������"); // ������������
        clien.setBounds(300,260,340,220); // ���ô���λ�úʹ�С
        clien.setVisible(true); // ��������ʾ
        clien.connect(); // �������ӷ���
    }
}
