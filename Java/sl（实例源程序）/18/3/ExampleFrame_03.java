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
		setTitle("定义表格");
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
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	//关闭表格列的自动调整功能
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		//选择模式为单选
		table.setSelectionBackground(Color.YELLOW);		//被选择行的背景色为黄色
		table.setSelectionForeground(Color.RED);			//被选择行的前景色（文字颜色）为红色
		table.setRowHeight(30);							//表格的行高为30像素
		scrollPane.setViewportView(table);
	}
	private class MTable extends JTable {					//实现自己的表格类
		public MTable(Vector rowData, Vector columnNames) {
			super(rowData, columnNames);
		}
		@Override
		public JTableHeader getTableHeader() {				//定义表格头
			JTableHeader tableHeader = super.getTableHeader();				//获得表格头对象
			tableHeader.setReorderingAllowed(false);		//设置表格列不可重排
			DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableHeader
					.getDefaultRenderer(); 				//获得表格头的单元格对象
			hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);		//设置列名居中显示
			return tableHeader;
		}
		@Override
		public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {	//定义单元格
			DefaultTableCellRenderer cr = (DefaultTableCellRenderer) super
					.getDefaultRenderer(columnClass); 	//获得表格的单元格对象
			cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER); //设置单元格内容居中显示
			return cr;
		}
		@Override
		public boolean isCellEditable(int row, int column) {	//表格不可编辑
			return false;
		}
	}
}

