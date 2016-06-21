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

	private JTable table;// ����һ��������

	private DefaultTableModel tableModel;// ����һ�����ģ�Ͷ���

	private JTextField aTextField;

	private JTextField bTextField;

	public static void main(String args[]) {
		TableModelEvent_Example frame = new TableModelEvent_Example();
		frame.setVisible(true);
	}

	public TableModelEvent_Example() {
		super();
		setTitle("���ģ���¼�ʾ��");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		String[] columnNames = { "A", "B" };
		String[][] rowValues = { { "A1", "B1" }, { "A2", "B2" },
				{ "A3", "B3" }, { "A4", "B4" } };
		tableModel = new DefaultTableModel(rowValues, columnNames);// �������ģ�Ͷ���
		tableModel.addTableModelListener(new TableModelListener() {// Ϊ���ģ������¼�������
			public void tableChanged(TableModelEvent e) {
				int type = e.getType();// ����¼�������
				int row = e.getFirstRow() + 1;// ��ô����˴��¼��ı��������
				int column = e.getColumn() + 1;// ��ô����˴��¼��ı��������
				if (type == TableModelEvent.INSERT) {// �ж��Ƿ��в����д���
					System.out.print("�˴��¼��� ���� �д�����");
					System.out.println("�˴β�����ǵ� " + row + " �У�");
				} else if (type == TableModelEvent.UPDATE) {// �ж��Ƿ����޸��д���
					System.out.print("�˴��¼��� �޸� �д�����");
					System.out.println("�˴��޸ĵ��ǵ� " + row + " �е� " + column
							+ " �У�");
				} else if (type == TableModelEvent.DELETE) {// �ж��Ƿ���ɾ���д���
					System.out.print("�˴��¼��� ɾ�� �д�����");
					System.out.println("�˴�ɾ�����ǵ� " + row + " �У�");
				} else {
					System.out.println("�˴��¼��� ����ԭ�� ������");
				}
			}
		});

		table = new JTable(tableModel);// ���ñ��ģ�Ͷ��󴴽�������
		scrollPane.setViewportView(table);

		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		final JLabel aLabel = new JLabel("A��");
		panel.add(aLabel);

		aTextField = new JTextField(15);
		panel.add(aTextField);

		final JLabel bLabel = new JLabel("B��");
		panel.add(bLabel);

		bTextField = new JTextField(15);
		panel.add(bTextField);

		final JButton addButton = new JButton("���");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] rowValues = { aTextField.getText(),
						aTextField.getText() };
				tableModel.addRow(rowValues);// ����ģ�������һ��
				aTextField.setText(null);
				bTextField.setText(null);
			}
		});
		panel.add(addButton);

		final JButton delButton = new JButton("ɾ��");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selectedRows = table.getSelectedRows();// ��ñ���е�ѡ����
				for (int row = 0; row < selectedRows.length; row++) {
					tableModel.removeRow(selectedRows[row] - row);// �ӱ��ģ�����Ƴ�����е�ѡ����
				}
			}
		});
		panel.add(delButton);
		//
	}
}
