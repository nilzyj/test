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

	private DefaultTableModel tableModel;// ������ģ�Ͷ���

	private JTable table;// ���������

	private JTextField aTextField;

	private JTextField bTextField;

	public static void main(String args[]) {
		ExampleFrame_06 frame = new ExampleFrame_06();
		frame.setVisible(true);
	}

	public ExampleFrame_06() {
		super();
		setTitle("ά�����ģ��");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		String[] columnNames = { "A", "B" };// ��������������
		String[][] tableValues = { { "A1", "B1" }, { "A2", "B2" },
				{ "A3", "B3" } };// ��������������

		tableModel = new DefaultTableModel(tableValues, columnNames);// ����ָ����������ͱ�����ݵı��ģ��

		table = new JTable(tableModel);// ����ָ�����ģ�͵ı��
		table.setRowSorter(new TableRowSorter(tableModel));// ���ñ���������
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// ���ñ���ѡ��ģʽΪ��ѡ
		table.addMouseListener(new MouseAdapter() {// Ϊ����������¼�������
			public void mouseClicked(MouseEvent e) {// �����˵���¼�
				int selectedRow = table.getSelectedRow();// ��ñ�ѡ���е�����
				Object oa = tableModel.getValueAt(selectedRow, 0);// �ӱ��ģ���л��ָ����Ԫ���ֵ
				Object ob = tableModel.getValueAt(selectedRow, 1);// �ӱ��ģ���л��ָ����Ԫ���ֵ
				aTextField.setText(oa.toString());// ��ֵ��ֵ���ı���
				bTextField.setText(ob.toString());// ��ֵ��ֵ���ı���
			}
		});
		scrollPane.setViewportView(table);

		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		panel.add(new JLabel("A��"));

		aTextField = new JTextField("A4", 10);
		panel.add(aTextField);

		panel.add(new JLabel("B��"));

		bTextField = new JTextField("B4", 10);
		panel.add(bTextField);

		final JButton addButton = new JButton("���");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] rowValues = { aTextField.getText(),
						bTextField.getText() };// �������������
				tableModel.addRow(rowValues);// ����ģ�������һ��
				int rowCount = table.getRowCount() + 1;
				aTextField.setText("A" + rowCount);
				bTextField.setText("B" + rowCount);
			}
		});
		panel.add(addButton);

		final JButton updButton = new JButton("�޸�");
		updButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();// ��ñ�ѡ���е�����
				if (selectedRow != -1) {// �ж��Ƿ���ڱ�ѡ����
					tableModel.setValueAt(aTextField.getText(), selectedRow, 0);// �޸ı��ģ�͵��е�ָ��ֵ
					tableModel.setValueAt(bTextField.getText(), selectedRow, 1);// �޸ı��ģ�͵��е�ָ��ֵ
				}
			}
		});
		panel.add(updButton);

		final JButton delButton = new JButton("ɾ��");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();// ��ñ�ѡ���е�����
				if (selectedRow != -1)// �ж��Ƿ���ڱ�ѡ����
					tableModel.removeRow(selectedRow);// �ӱ��ģ�͵���ɾ��ָ����
			}
		});
		panel.add(delButton);
		//
	}

}
