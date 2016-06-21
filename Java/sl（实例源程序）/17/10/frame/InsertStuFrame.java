package com.frame;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dao.StuDao;
import com.model.Students;

public class InsertStuFrame extends JDialog {
    
    private JPanel contentPane;
    private JTextField sname;
    private JTextField age;
    private JTextField sclass;
    private JComboBox sexComboBox;
    
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
                    InsertStuFrame frame = new InsertStuFrame();
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
    public InsertStuFrame() {
    	setModal(true);
		setResizable(false);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
        setBounds(100, 100, 331, 363);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("添加学生信息");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 324, 338);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel nameLabel = new JLabel("姓名：");
        nameLabel.setBounds(29, 24, 45, 15);
        panel.add(nameLabel);
        
        sname = new JTextField();
        sname.setBounds(84, 21, 194, 21);
        panel.add(sname);
        sname.setColumns(10);
        
        JLabel sexLabel = new JLabel("性别：");
        sexLabel.setBounds(29, 58, 45, 15);
        panel.add(sexLabel);
        
        age = new JTextField();
        age.setBounds(214, 52, 66, 21);
        panel.add(age);
        age.setColumns(10);
        
        String[] sex = new String[] { "男", "女" };
        sexComboBox = new JComboBox(sex);
        sexComboBox.setBounds(84, 52, 55, 21);
        panel.add(sexComboBox);
        
        JLabel ageLabel = new JLabel("年龄：");
        ageLabel.setBounds(159, 58, 45, 15);
        panel.add(ageLabel);
        
        JLabel deptLabel = new JLabel("\u73ED\u7EA7\uFF1A");
        deptLabel.setBounds(29, 198, 45, 15);
        panel.add(deptLabel);
        
        
        checkBox = new JCheckBox("旅游");						// 添加复选框
    	checkBox.setBounds(84, 106, 63, 23);
    	panel.add(checkBox);	
    	checkBox_1 = new JCheckBox("看书");					// 添加复选框
    	checkBox_1.setBounds(149, 106, 63, 23);
    	panel.add(checkBox_1);
    	checkBox_2 = new JCheckBox("上网");					// 添加复选框
    	checkBox_2.setBounds(84, 143, 63, 23);
    	panel.add(checkBox_2);
    	checkBox_3 = new JCheckBox("音乐");					// 添加复选框
    	checkBox_3.setBounds(214, 106, 103, 23);
    	panel.add(checkBox_3);
    	checkBox_4 = new JCheckBox("羽毛球");					// 添加复选框
    	checkBox_4.setBounds(149, 143, 66, 23);
    	panel.add(checkBox_4);
    	checkBox_5 = new JCheckBox("乒乓球");						// 添加复选框
    	checkBox_5.setBounds(214, 143, 74, 23);
    	panel.add(checkBox_5);

        
        sclass = new JTextField();
        sclass.setBounds(84, 195, 194, 21);
        panel.add(sclass);
        sclass.setColumns(10);
        
        JButton insertButton = new JButton("添加");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_insertButton_actionPerformed(arg0);
            }
        });
        insertButton.setBounds(84, 281, 66, 23);
        panel.add(insertButton);
        
        JButton closeButton = new JButton("关闭");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_closeButton_actionPerformed(arg0);
            }
        });
        closeButton.setBounds(159, 281, 66, 23);
        panel.add(closeButton);
        
        JLabel label = new JLabel("\u7231\u597D\uFF1A");
        label.setBounds(29, 110, 54, 15);
        panel.add(label);
    }
    
    // 关闭按钮的单击事件
    protected void do_closeButton_actionPerformed(ActionEvent arg0) {
    	this.setVisible(false);
    }
    
    // 添加按钮的单击事件
    protected void do_insertButton_actionPerformed(ActionEvent arg0) {
        StuDao dao = new StuDao();
        Students stu = new Students();
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
        stu.setSname(sname.getText());
        stu.setSex(sexComboBox.getSelectedItem().toString());
        stu.setAge(Integer.parseInt(age.getText()));
        stu.setSclass(sclass.getText());
        stu.setHobby(strLoves);
        if (!(sname.getText().equals(""))
                && (!sclass.getText().equals(""))
                && (!age.getText().equals(""))) {
            dao.addusers(stu);
            
            JOptionPane.showMessageDialog(getContentPane(), "数据添加成功！", "信息提示框",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(getContentPane(), "请将信息添加完整！",
                    "信息提示框", JOptionPane.WARNING_MESSAGE);
        }
    }
}
