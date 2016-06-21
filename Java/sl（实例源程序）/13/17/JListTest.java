package com.mingrisoft;

import java.awt.*;

import javax.swing.*;

public class JListTest extends JFrame {
	public JListTest() {
		Container cp = getContentPane();
		
		cp.setLayout(null);
		JList jl = new JList(new MyListModel());
		JScrollPane js = new JScrollPane(jl);
		js.setBounds(10, 10, 100, 100);
		cp.add(js);
		setTitle("�����������ʹ�����б��");
		setSize(200, 150);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String args[]) {
		new JListTest();
	}
}
class MyListModel extends AbstractListModel {
	private String[] contents = { "�б�1", "�б�2", "�б�3", "�б�4", "�б�5", "�б�6" };
	
	public Object getElementAt(int x) {
		if (x < contents.length)
			return contents[x++];
		else
			return null;
	}
	public int getSize() {
		return contents.length;
	}
}
