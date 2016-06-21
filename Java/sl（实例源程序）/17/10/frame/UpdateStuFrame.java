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
import com.model.UpDateNumber;

public class UpdateStuFrame extends JDialog {

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
	StuDao dao = new StuDao();
	int id=UpDateNumber.getN();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStuFrame frame = new UpdateStuFrame();
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
	public UpdateStuFrame() {
    	setModal(true);
		setResizable(false);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
        setBounds(100, 100, 329, 380);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("添加学生信息");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 325, 356);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel nameLabel = new JLabel("姓名：");
        nameLabel.setBounds(29, 64, 45, 15);
        panel.add(nameLabel);
        
        sname = new JTextField();
        sname.setBounds(84, 61, 194, 21);
        panel.add(sname);
        sname.setColumns(10);
        
        JLabel sexLabel = new JLabel("性别：");
        sexLabel.setBounds(29, 110, 45, 15);
        panel.add(sexLabel);
        
        age = new JTextField();
        age.setBounds(204, 107, 66, 21);
        panel.add(age);
        age.setColumns(10);
        
        String[] sex = new String[] { "男", "女" };
        sexComboBox = new JComboBox(sex);
        sexComboBox.setBounds(84, 107, 55, 21);
        panel.add(sexComboBox);
        
        JLabel ageLabel = new JLabel("年龄：");
        ageLabel.setBounds(149, 110, 45, 15);
        panel.add(ageLabel);
        
        JLabel deptLabel = new JLabel("\u73ED\u7EA7\uFF1A");
        deptLabel.setBounds(29, 241, 45, 15);
        panel.add(deptLabel);
        
        
        checkBox = new JCheckBox("旅游");						// 添加复选框
    	checkBox.setBounds(84, 155, 63, 23);
    	panel.add(checkBox);	
    	checkBox_1 = new JCheckBox("看书");					// 添加复选框
    	checkBox_1.setBounds(149, 155, 63, 23);
    	panel.add(checkBox_1);
    	checkBox_2 = new JCheckBox("上网");					// 添加复选框
    	checkBox_2.setBounds(84, 191, 63, 23);
    	panel.add(checkBox_2);
    	checkBox_3 = new JCheckBox("音乐");					// 添加复选框
    	checkBox_3.setBounds(214, 155, 103, 23);
    	panel.add(checkBox_3);
    	checkBox_4 = new JCheckBox("羽毛球");					// 添加复选框
    	checkBox_4.setBounds(149, 191, 66, 23);
    	panel.add(checkBox_4);
    	checkBox_5 = new JCheckBox("乒乓球");						// 添加复选框
    	checkBox_5.setBounds(214, 191, 74, 23);
    	panel.add(checkBox_5);

        
        sclass = new JTextField();
        sclass.setBounds(84, 238, 194, 21);
        panel.add(sclass);
        sclass.setColumns(10);
        
        JButton insertButton = new JButton("\u4FEE\u6539");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_insertButton_actionPerformed(arg0);
            }
        });
        insertButton.setBounds(84, 306, 66, 23);
        panel.add(insertButton);
        
        JButton closeButton = new JButton("关闭");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_closeButton_actionPerformed(arg0);
            }
        });
        closeButton.setBounds(160, 306, 66, 23);
        panel.add(closeButton);
        
        JLabel label = new JLabel("\u7231\u597D\uFF1A");
        label.setBounds(29, 159, 54, 15);
        panel.add(label);
        
        JLabel label_1 = new JLabel("\u5B66\u53F7\uFF1A");
        label_1.setBounds(29, 28, 45, 15);
        panel.add(label_1);
        
        JLabel stuid = new JLabel(UpDateNumber.getN()+"");
        stuid.setBounds(84, 28, 84, 15);
        panel.add(stuid);
        
        // 获得要修改的学生信息
    	
    	Students stu=dao.getOne(id);
    	sname.setText(stu.getSname());
    	age.setText(stu.getAge()+"");
    	sclass.setText(stu.getSclass());
    	String[] hy=stu.getHobby().split("、");
    	if(hy.length>0){
    		for(int i=0;i<hy.length;i++){			// 为爱好赋值
    			if(hy[i].equals("旅游")){
    				checkBox.setSelected(true);
    			}
    			if(hy[i].equals("看书")){
    				checkBox_1.setSelected(true);
    			}
    			if(hy[i].equals("上网")){
    				checkBox_2.setSelected(true);
    			}
    			if(hy[i].equals("音乐")){
    				checkBox_3.setSelected(true);
    			}
    			if(hy[i].equals("羽毛球")){
    				checkBox_4.setSelected(true);
    			}
    			if(hy[i].equals("乒乓球")){
    				checkBox_5.setSelected(true);
    			}
    		}
    	}
    	if("男".equals(stu.getSex())){				// 为性别赋值
    		sexComboBox.setSelectedIndex(0);
    	}else{
    		sexComboBox.setSelectedIndex(1);
    	}
    	
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
		if (!(sname.getText().equals("")) && (!sclass.getText().equals(""))
				&& (!age.getText().equals(""))) {
			dao.updateusers(stu,id);

			JOptionPane.showMessageDialog(getContentPane(), "数据修改成功！", "信息提示框",
					JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(getContentPane(), "请将信息添加完整！",
					"信息提示框", JOptionPane.WARNING_MESSAGE);
		}

	}
}
