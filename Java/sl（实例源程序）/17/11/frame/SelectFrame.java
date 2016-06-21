package com.frame;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dao.UserDao;
import com.util.UserUtil;
import com.util.Users;


public class SelectFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JScrollPane scrollPane = new JScrollPane();
	private DefaultTableModel defaultModel;
	UserDao dao=new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectFrame frame = new SelectFrame();
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
	public SelectFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 265, 258);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel messageLabel = new JLabel("\u7528\u6237\u4FE1\u606F");
		messageLabel.setFont(new Font("��������", Font.PLAIN, 16));
		messageLabel.setBounds(98, 10, 108, 34);
		panel.add(messageLabel);

		scrollPane.setBounds(21, 54, 222, 155);
		panel.add(scrollPane);

		selecttable();
		
if(UserUtil.getNumber()==1){
JButton deleteButton = new JButton("ɾ��");
deleteButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		do_deleteButton_actionPerformed(arg0);
	}
});
		deleteButton.setBounds(63, 219, 73, 23);
		panel.add(deleteButton);
		}
		JButton closeButton = new JButton("�ر�");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_button_1_actionPerformed(arg0);
			}
		});
		closeButton.setBounds(154, 219, 73, 23);
		panel.add(closeButton);
	}

	public void selecttable() {
		table = new JTable();

		defaultModel = (DefaultTableModel) table.getModel();// ��ñ��ģ��
		defaultModel.setRowCount(0);// ��ձ��ģ���е�����

		defaultModel.setColumnIdentifiers(new Object[] { "id", "�û���", "����"});// �����ͷ

		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(defaultModel);// ���ñ��ģ��
		List<Users> list = dao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			Users us = (Users) list.get(i);
			defaultModel.addRow(new Object[] { us.getId(), us.getUsername(),
					us.getPassword()});
		}
		scrollPane.setViewportView(table);
	}

	// ɾ����ť�ĵ����¼�
	protected void do_deleteButton_actionPerformed(ActionEvent arg0) {
		int row = table.getSelectedRow();
		if (row == -1) { // ����û�û��ѡ���κ��У��������ʾ
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫɾ�����û�", "",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		if (row >= 0) {
			int n = JOptionPane.showConfirmDialog(getContentPane(), "ȷ��ɾ����",
					"ɾ���Ի���", JOptionPane.YES_NO_CANCEL_OPTION);
			if (n == JOptionPane.YES_OPTION) { // ����û�ȷ����Ϣ
				dao.deleteUser(Integer.parseInt(table.getValueAt(row, 0)
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
}
