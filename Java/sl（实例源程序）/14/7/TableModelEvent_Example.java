import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class TableModelEvent_Example extends JFrame {

	private JTable table;// 声明一个表格对象

	private DefaultTableModel tableModel;// 声明一个表格模型对象

	private JTextField aTextField;

	private JTextField bTextField;

	public static void main(String args[]) {
		TableModelEvent_Example frame = new TableModelEvent_Example();
		frame.setVisible(true);
	}

	public TableModelEvent_Example() {
		super();
		setTitle("表格模型事件示例");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		String[] columnNames = { "A", "B" };
		String[][] rowValues = { { "A1", "B1" }, { "A2", "B2" },
				{ "A3", "B3" }, { "A4", "B4" } };
		tableModel = new DefaultTableModel(rowValues, columnNames);// 创建表格模型对象
		tableModel.addTableModelListener(new TableModelListener() {// 为表格模型添加事件监听器
			public void tableChanged(TableModelEvent e) {
				int type = e.getType();// 获得事件的类型
				int row = e.getFirstRow() + 1;// 获得触发此次事件的表格行索引
				int column = e.getColumn() + 1;// 获得触发此次事件的表格列索引
				if (type == TableModelEvent.INSERT) {// 判断是否有插入行触发
					System.out.print("此次事件由 插入 行触发，");
					System.out.println("此次插入的是第 " + row + " 行！");
				} else if (type == TableModelEvent.UPDATE) {// 判断是否有修改行触发
					System.out.print("此次事件由 修改 行触发，");
					System.out.println("此次修改的是第 " + row + " 行第 " + column
							+ " 列！");
				} else if (type == TableModelEvent.DELETE) {// 判断是否有删除行触发
					System.out.print("此次事件由 删除 行触发，");
					System.out.println("此次删除的是第 " + row + " 行！");
				} else {
					System.out.println("此次事件由 其他原因 触发！");
				}
			}
		});

		table = new JTable(tableModel);// 利用表格模型对象创建表格对象
		scrollPane.setViewportView(table);

		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		final JLabel aLabel = new JLabel("A：");
		panel.add(aLabel);

		aTextField = new JTextField(15);
		panel.add(aTextField);

		final JLabel bLabel = new JLabel("B：");
		panel.add(bLabel);

		bTextField = new JTextField(15);
		panel.add(bTextField);

		final JButton addButton = new JButton("添加");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] rowValues = { aTextField.getText(),
						aTextField.getText() };
				tableModel.addRow(rowValues);// 向表格模型中添加一行
				aTextField.setText(null);
				bTextField.setText(null);
			}
		});
		panel.add(addButton);

		final JButton delButton = new JButton("删除");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selectedRows = table.getSelectedRows();// 获得表格中的选中行
				for (int row = 0; row < selectedRows.length; row++) {
					tableModel.removeRow(selectedRows[row] - row);// 从表格模型中移除表格中的选中行
				}
			}
		});
		panel.add(delButton);
		//
	}
}
