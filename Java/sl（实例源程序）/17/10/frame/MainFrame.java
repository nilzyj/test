package com.frame;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dao.StuDao;
import com.model.Students;
import com.model.UpDateNumber;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private StuDao dao = new StuDao();
	JScrollPane scrollPane = new JScrollPane();
	private DefaultTableModel defaultModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 576, 417);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel messageLabel = new JLabel("\u5B66\u751F\u4FE1\u606F");
		messageLabel.setFont(new Font("��������", Font.PLAIN, 16));
		messageLabel.setBounds(149, 26, 108, 34);
		panel.add(messageLabel);

		scrollPane.setBounds(33, 70, 346, 204);
		panel.add(scrollPane);

		selecttable();
		JButton deleteButton = new JButton("ɾ��");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_deleteButton_actionPerformed(arg0);
			}
		});
		deleteButton.setBounds(209, 284, 73, 23);
		panel.add(deleteButton);

		JButton closeButton = new JButton("�ر�");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_button_1_actionPerformed(arg0);
			}
		});
		closeButton.setBounds(292, 284, 73, 23);
		panel.add(closeButton);

		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
			}
		});
		button.setBounds(126, 284, 73, 23);
		panel.add(button);

		JButton button_1 = new JButton("\u6DFB\u52A0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addstu(e);
			}
		});
		button_1.setBounds(43, 284, 73, 23);
		panel.add(button_1);
	}

	public void selecttable() {
		table = new JTable();

		defaultModel = (DefaultTableModel) table.getModel();// ��ñ��ģ��
		defaultModel.setRowCount(0);// ��ձ��ģ���е�����

		defaultModel.setColumnIdentifiers(new Object[] { "ѧ��", "����", "�Ա�",
				"����", "�༶" });// �����ͷ

		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(defaultModel);// ���ñ��ģ��
		List list = dao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			Students stu = (Students) list.get(i);
			defaultModel.addRow(new Object[] { stu.getId(), stu.getSname(),
					stu.getSex(), stu.getAge(), stu.getSclass() });
		}
		scrollPane.setViewportView(table);
	}

	// ɾ����ť�ĵ����¼�
	protected void do_deleteButton_actionPerformed(ActionEvent arg0) {
		int row = table.getSelectedRow();
		if (row == -1) { // ����û�û��ѡ���κ��У��������ʾ
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫɾ����ѧ��", "",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (row >= 0) {
			int n = JOptionPane.showConfirmDialog(getContentPane(), "ȷ��ɾ����",
					"ɾ���Ի���", JOptionPane.YES_NO_CANCEL_OPTION);
			if (n == JOptionPane.YES_OPTION) { // ����û�ȷ����Ϣ
				dao.deleteStu(Integer.parseInt(table.getValueAt(row, 0)
						.toString()));
			}
			selecttable();
		}

	}

	// �رհ�ť�ĵ����¼�
	protected void do_button_1_actionPerformed(ActionEvent arg0) {
		int n = JOptionPane.showConfirmDialog(getContentPane(), "ȷ�Ϲر���",
				"�رնԻ���", JOptionPane.YES_NO_CANCEL_OPTION);
		if (n == JOptionPane.YES_OPTION) { // ����û�ȷ����Ϣ
			System.exit(0);
		}
	}

	protected void addstu(ActionEvent arg0) {// ��Ӱ�ť�ĵ����¼�
		InsertStuFrame insert = new InsertStuFrame();
		insert.setVisible(true);
		selecttable();
	}
	// �޸İ�ť�ĵ����¼�
	protected void do_button_actionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		if (row == -1) { // ����û�û��ѡ���κ��У��������ʾ
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�޸ĵ�ѧ��", "",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		UpDateNumber up = new UpDateNumber();
		up.setNumber(Integer.parseInt(table.getValueAt(row, 0).toString()));
		UpdateStuFrame uf=new UpdateStuFrame();
		uf.setVisible(true);
		selecttable();
	}
}
