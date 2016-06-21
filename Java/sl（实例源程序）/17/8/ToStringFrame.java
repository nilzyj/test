package com.mingrisoft;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ToStringFrame extends JFrame {

	private JPanel contentPane;
	JCheckBox checkBox, checkBox_1, checkBox_2, checkBox_3;
	private JTextField userNameTextField;
	private JCheckBox checkBox_4;
	private JCheckBox checkBox_5;
	StringBuffer buff = new StringBuffer();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ToStringFrame frame = new ToStringFrame();
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
	public ToStringFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("将爱好以字符串的形式保存到数据库中");
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 380, 222);
		contentPane.add(panel);
		panel.setLayout(null);
		checkBox = new JCheckBox("旅游");
		checkBox.setBounds(119, 72, 63, 23);
		panel.add(checkBox);
		checkBox_1 = new JCheckBox("看书");
		checkBox_1.setBounds(184, 72, 63, 23);
		panel.add(checkBox_1);
		checkBox_2 = new JCheckBox("上网");
		checkBox_2.setBounds(119, 115, 63, 23);
		panel.add(checkBox_2);
		checkBox_3 = new JCheckBox("音乐");
		checkBox_3.setBounds(259, 72, 103, 23);
		panel.add(checkBox_3);
		checkBox_4 = new JCheckBox("羽毛球");
		checkBox_4.setBounds(184, 115, 74, 23);
		panel.add(checkBox_4);
		checkBox_5 = new JCheckBox("乒乓球");
		checkBox_5.setBounds(259, 115, 74, 23);
		panel.add(checkBox_5);
		JButton insertButton = new JButton("保存");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_button_actionPerformed(arg0);
			}
		});
		insertButton.setBounds(162, 165, 63, 23);
		panel.add(insertButton);
		JLabel nameLabel = new JLabel("用户名：");
		nameLabel.setBounds(62, 32, 54, 15);
		panel.add(nameLabel);
		userNameTextField = new JTextField();
		userNameTextField.setBounds(123, 29, 190, 21);
		panel.add(userNameTextField);
		userNameTextField.setColumns(10);
		JLabel loveLabel = new JLabel("爱好：");
		loveLabel.setBounds(72, 76, 54, 15);
		panel.add(loveLabel);

	
	}

	protected void do_button_actionPerformed(ActionEvent arg0) {
		if (checkBox.isSelected()) {
			buff.append(checkBox.getText() + "、");
		}
		if (checkBox_1.isSelected()) {
			buff.append(checkBox_1.getText() + "、");
		}
		if (checkBox_2.isSelected()) {
			buff.append(checkBox_2.getText() + "、");
		}
		if (checkBox_3.isSelected()) {
			buff.append(checkBox_3.getText() + "、");
		}
		if (checkBox_4.isSelected()) {
			buff.append(checkBox_4.getText() + "、");
		}
		if (checkBox_5.isSelected()) {
			buff.append(checkBox_5.getText() + "、");
		}
		String strLoves = buff.toString();
		InsertString insertString = new InsertString();
		String name = userNameTextField.getText();
		insertString.insertUsers(name, strLoves);
		JOptionPane.showMessageDialog(getContentPane(), "数据添加成功！", "信息提示框",
				JOptionPane.WARNING_MESSAGE);
	}

}
