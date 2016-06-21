package com.mingrisoft;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class RegistDemo extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7774133711807576073L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField pwd1;
    private JPasswordField pwd2;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegistDemo frame = new RegistDemo();
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
    public RegistDemo() {
        setTitle("\u65B0\u7528\u6237\u6CE8\u518C");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 330, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(4, 1, 5, 5));
        
        JPanel panel1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel1.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        contentPane.add(panel1);
        
        JLabel label1 = new JLabel("\u7528  \u6237  \u540D\uFF1A");
        panel1.add(label1);
        
        textField = new JTextField();
        panel1.add(textField);
        textField.setColumns(15);
        
        JButton button1 = new JButton("\u9A8C\u8BC1");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button1_actionPerformed(e);
            }
        });
        panel1.add(button1);
        
        JPanel panel2 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel2.getLayout();
        flowLayout_1.setAlignment(FlowLayout.LEFT);
        contentPane.add(panel2);
        
        JLabel label2 = new JLabel("\u8F93\u5165\u5BC6\u7801\uFF1A");
        panel2.add(label2);
        
        pwd1 = new JPasswordField();
        pwd1.setColumns(18);
        panel2.add(pwd1);
        
        JPanel panel3 = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) panel3.getLayout();
        flowLayout_2.setAlignment(FlowLayout.LEFT);
        contentPane.add(panel3);
        
        JLabel label3 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
        panel3.add(label3);
        
        pwd2 = new JPasswordField();
        pwd2.setColumns(18);
        panel3.add(pwd2);
        
        JPanel panel4 = new JPanel();
        contentPane.add(panel4);
        
        JButton button2 = new JButton("\u63D0\u4EA4");
        button2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		do_button2_actionPerformed(e);
        	}
        });
        panel4.add(button2);
        
        JButton button3 = new JButton("\u91CD\u7F6E");
        panel4.add(button3);
    }
    
    protected void do_button1_actionPerformed(ActionEvent e) {
        String name = textField.getText();// 获得用户输入的用户名
        if (name.isEmpty()) {// 如果用户名为空则进行提示
            JOptionPane.showMessageDialog(this, "请输入用户名！", null, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String sql = "select * from tb_users where username = '" + name + "';";
        ResultSet rs = DBHelper.query(sql);// 查询表格中包含该用户名的记录
        try {
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "还可以注册！", null, JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                JOptionPane.showMessageDialog(this, "用户名冲突！", null, JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
	protected void do_button2_actionPerformed(ActionEvent e) {
		if(pwd1.getText().equals(pwd2.getText())){
			DBHelper dbh=new DBHelper();
			dbh.adduser(textField.getText(), pwd1.getText());
		}
	}
}
