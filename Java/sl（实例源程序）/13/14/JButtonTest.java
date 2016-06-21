package com.mingrisoft;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.*;

public class JButtonTest extends JFrame {
	public JButtonTest() {
		URL url = JButtonTest.class.getResource("imageButtoo.jpg");
		Icon icon = new ImageIcon(url);
		setLayout(new GridLayout(3, 2, 5, 5)); // �������񲼾ֹ�����
		Container c = getContentPane(); // ��������
		for (int i = 1; i <= 5; i++) {
			// ������ť��ͬʱ���ð�ť������ͼ��
			JButton J = new JButton("��ť" + i, icon);
			c.add(J); // ����������Ӱ�ť
			if (i % 2 == 0) {
				J.setEnabled(false); // ��������һЩ��ť������
			}
		}
		JButton jb = new JButton(); // ʵ����һ��û��������ͼƬ�İ�ť
		jb.setMaximumSize(new Dimension(90, 30)); // ���ð�ť��ͼƬ��ͬ��С
		jb.setIcon(icon); // Ϊ��ť����ͼ��
		jb.setHideActionText(true);
		jb.setToolTipText("ͼƬ��ť"); // ���ð�ť��ʾΪ����
		jb.setBorderPainted(false); // ���ð�ť�߽粻��ʾ
		c.add(jb); // ����ť��ӵ�������
		setTitle("������������ͼƬ�İ�ť");
		setSize(350, 150);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	public static void main(String args[]) {
		new JButtonTest();
	}
}
