package com.mingrisoft;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ExampleFrame_01 extends JFrame {
	public static void main(String args[]) {
		ExampleFrame_01 frame = new ExampleFrame_01();
		frame.setVisible(true);
	}
	public ExampleFrame_01() {
		super();
		setTitle("�������Թ����ı��");
		setBounds(100, 100, 240, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[] columnNames = { "A", "B" };					//��������������
		String[][] tableValues = { { "A1", "B1" }, { "A2", "B2" },
				{ "A3", "B3" }, { "A4", "B4" }, { "A5", "B5" } };	//��������������
		JTable table = new JTable(tableValues, columnNames);	//����ָ�����������ݵı��
		JScrollPane scrollPane = new JScrollPane(table);			//������ʾ���Ĺ������
		getContentPane().add(scrollPane, BorderLayout.CENTER);	//�����������ӵ��߽粼�ֵ��м�
	}
}

