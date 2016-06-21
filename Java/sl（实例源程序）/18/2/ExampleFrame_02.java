package com.mingrisoft;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class ExampleFrame_02 extends JFrame {

	public static void main(String args[]) {
		ExampleFrame_02 frame = new ExampleFrame_02();
		frame.setVisible(true);
	}

	public ExampleFrame_02() {
		super();
		setTitle("�������ɹ����ı��");
		setBounds(100, 100, 240, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Vector columnNameV = new Vector();// ��������������
		columnNameV.add("A");// �������
		columnNameV.add("B");// �������
		Vector tableValueV = new Vector();// ��������������
		for (int row = 1; row < 6; row++) {
			Vector rowV = new Vector();// ������������
			rowV.add("A" + row);// ��ӵ�Ԫ������
			rowV.add("B" + row);// ��ӵ�Ԫ������
			tableValueV.add(rowV);// �������������ӵ��������������
		}

		JTable table = new JTable(tableValueV, columnNameV);// ����ָ����������ͱ�����ݵı��
		getContentPane().add(table, BorderLayout.CENTER);// �������ӵ��߽粼�ֵ��м�

//		JTableHeader tableHeader = table.getTableHeader();// ��ñ��ͷ����
//		getContentPane().add(tableHeader, BorderLayout.NORTH);// �����ͷ��ӵ��߽粼�ֵ��Ϸ�
		//
	}

}

