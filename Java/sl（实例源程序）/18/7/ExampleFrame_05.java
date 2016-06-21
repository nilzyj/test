import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ExampleFrame_05 extends JFrame {

	public static void main(String args[]) {
		ExampleFrame_05 frame = new ExampleFrame_05();
		frame.setVisible(true);
	}

	public ExampleFrame_05() {
		super();
		setTitle("���ģ������");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		String[] columnNames = { "A", "B" };// ��������������
		String[][] tableValues = { { "A1", "B1" }, { "A2", "B2" },
				{ "A3", "B3" } };// ��������������

		DefaultTableModel tableModel = new DefaultTableModel(tableValues,
				columnNames);// ����ָ����������ͱ�����ݵı��ģ��

		JTable table = new JTable(tableModel);// ����ָ�����ģ�͵ı��
		table.setRowSorter(new TableRowSorter(tableModel));// ���ñ���������
		scrollPane.setViewportView(table);
		//
	}

}
