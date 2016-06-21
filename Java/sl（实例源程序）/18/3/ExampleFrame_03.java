package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class ExampleFrame_03 extends JFrame {
	public static void main(String args[]) {
		ExampleFrame_03 frame = new ExampleFrame_03();
		frame.setVisible(true);
	}
	public ExampleFrame_03() {
		super();
		setTitle("������");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		String[] columnNames = { "A", "B", "C", "D", "E", "F", "G" };
		Vector columnNameV = new Vector();
		for (int column = 0; column < columnNames.length; column++) {
			columnNameV.add(columnNames[column]);
		}
		Vector tableValueV = new Vector();
		for (int row = 1; row < 21; row++) {
			Vector rowV = new Vector();
			for (int column = 0; column < columnNames.length; column++) {
				rowV.add(columnNames[column] + row);
			}
			tableValueV.add(rowV);
		}
		JTable table = new MTable(tableValueV, columnNameV);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	//�رձ���е��Զ���������
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		//ѡ��ģʽΪ��ѡ
		table.setSelectionBackground(Color.YELLOW);		//��ѡ���еı���ɫΪ��ɫ
		table.setSelectionForeground(Color.RED);			//��ѡ���е�ǰ��ɫ��������ɫ��Ϊ��ɫ
		table.setRowHeight(30);							//�����и�Ϊ30����
		scrollPane.setViewportView(table);
	}
	private class MTable extends JTable {					//ʵ���Լ��ı����
		public MTable(Vector rowData, Vector columnNames) {
			super(rowData, columnNames);
		}
		@Override
		public JTableHeader getTableHeader() {				//������ͷ
			JTableHeader tableHeader = super.getTableHeader();				//��ñ��ͷ����
			tableHeader.setReorderingAllowed(false);		//���ñ���в�������
			DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableHeader
					.getDefaultRenderer(); 				//��ñ��ͷ�ĵ�Ԫ�����
			hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);		//��������������ʾ
			return tableHeader;
		}
		@Override
		public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {	//���嵥Ԫ��
			DefaultTableCellRenderer cr = (DefaultTableCellRenderer) super
					.getDefaultRenderer(columnClass); 	//��ñ��ĵ�Ԫ�����
			cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER); //���õ�Ԫ�����ݾ�����ʾ
			return cr;
		}
		@Override
		public boolean isCellEditable(int row, int column) {	//��񲻿ɱ༭
			return false;
		}
	}
}

