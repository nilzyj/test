import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ExampleFrame_06 extends JFrame {

	private DefaultTableModel tableModel;// 定义表格模型对象

	private JTable table;// 定义表格对象

	private JTextField aTextField;

	private JTextField bTextField;

	public static void main(String args[]) {
		ExampleFrame_06 frame = new ExampleFrame_06();
		frame.setVisible(true);
	}

	public ExampleFrame_06() {
		super();
		setTitle("维护表格模型");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		String[] columnNames = { "A", "B" };// 定义表格列名数组
		String[][] tableValues = { { "A1", "B1" }, { "A2", "B2" },
				{ "A3", "B3" } };// 定义表格数据数组

		tableModel = new DefaultTableModel(tableValues, columnNames);// 创建指定表格列名和表格数据的表格模型

		table = new JTable(tableModel);// 创建指定表格模型的表格
		table.setRowSorter(new TableRowSorter(tableModel));// 设置表格的排序器
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 设置表格的选择模式为单选
		table.addMouseListener(new MouseAdapter() {// 为表格添加鼠标事件监听器
			public void mouseClicked(MouseEvent e) {// 发生了点击事件
				int selectedRow = table.getSelectedRow();// 获得被选中行的索引
				Object oa = tableModel.getValueAt(selectedRow, 0);// 从表格模型中获得指定单元格的值
				Object ob = tableModel.getValueAt(selectedRow, 1);// 从表格模型中获得指定单元格的值
				aTextField.setText(oa.toString());// 将值赋值给文本框
				bTextField.setText(ob.toString());// 将值赋值给文本框
			}
		});
		scrollPane.setViewportView(table);

		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		panel.add(new JLabel("A："));

		aTextField = new JTextField("A4", 10);
		panel.add(aTextField);

		panel.add(new JLabel("B："));

		bTextField = new JTextField("B4", 10);
		panel.add(bTextField);

		final JButton addButton = new JButton("添加");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] rowValues = { aTextField.getText(),
						bTextField.getText() };// 创建表格行数组
				tableModel.addRow(rowValues);// 向表格模型中添加一行
				int rowCount = table.getRowCount() + 1;
				aTextField.setText("A" + rowCount);
				bTextField.setText("B" + rowCount);
			}
		});
		panel.add(addButton);

		final JButton updButton = new JButton("修改");
		updButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();// 获得被选中行的索引
				if (selectedRow != -1) {// 判断是否存在被选中行
					tableModel.setValueAt(aTextField.getText(), selectedRow, 0);// 修改表格模型当中的指定值
					tableModel.setValueAt(bTextField.getText(), selectedRow, 1);// 修改表格模型当中的指定值
				}
			}
		});
		panel.add(updButton);

		final JButton delButton = new JButton("删除");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();// 获得被选中行的索引
				if (selectedRow != -1)// 判断是否存在被选中行
					tableModel.removeRow(selectedRow);// 从表格模型当中删除指定行
			}
		});
		panel.add(delButton);
		//
	}

}
