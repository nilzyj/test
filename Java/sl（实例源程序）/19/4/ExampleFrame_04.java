import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class ExampleFrame_04 extends JFrame {

	public static void main(String args[]) {
		ExampleFrame_04 frame = new ExampleFrame_04();
		frame.setVisible(true);
	}

	public ExampleFrame_04() {
		super();
		setBounds(100, 100, 500, 375);
		setTitle("使用弹簧布局管理器");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SpringLayout springLayout = new SpringLayout();// 创建弹簧布局管理器对象
		Container contentPane = getContentPane();// 获得窗体容器对象
		contentPane.setLayout(springLayout);// 将窗体容器修改为采用弹簧布局管理器

		JLabel topicLabel = new JLabel("主题：");
		contentPane.add(topicLabel);
		springLayout.putConstraint(SpringLayout.NORTH, topicLabel, 5,
				SpringLayout.NORTH, contentPane);// 主题标签北侧——>容器北侧
		springLayout.putConstraint(SpringLayout.WEST, topicLabel, 5,
				SpringLayout.WEST, contentPane);// 主题标签西侧——>容器西侧

		JTextField topicTextField = new JTextField();
		contentPane.add(topicTextField);
		springLayout.putConstraint(SpringLayout.NORTH, topicTextField, 5,
				SpringLayout.NORTH, contentPane);// 主题文本框北侧——>容器北侧
		springLayout.putConstraint(SpringLayout.WEST, topicTextField, 5,
				SpringLayout.EAST, topicLabel);// 主题文本框西侧——>主题标签东侧
		springLayout.putConstraint(SpringLayout.EAST, topicTextField, -5,
				SpringLayout.EAST, contentPane);// 主题文本框东侧——>容器东侧

		JLabel contentLabel = new JLabel("内容：");
		contentPane.add(contentLabel);
		springLayout.putConstraint(SpringLayout.NORTH, contentLabel, 5,
				SpringLayout.SOUTH, topicTextField);// 内容标签北侧——>主题文本框南侧
		springLayout.putConstraint(SpringLayout.WEST, contentLabel, 5,
				SpringLayout.WEST, contentPane);// 内容标签西侧——>容器西侧

		JScrollPane contentScrollPane = new JScrollPane();
		contentScrollPane.setViewportView(new JTextArea());
		contentPane.add(contentScrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, contentScrollPane, 5,
				SpringLayout.SOUTH, topicTextField);// 滚动面板北侧——>主题文本框南侧
		springLayout.putConstraint(SpringLayout.WEST, contentScrollPane, 5,
				SpringLayout.EAST, contentLabel);// 滚动面板西侧——>内容标签东侧
		springLayout.putConstraint(SpringLayout.EAST, contentScrollPane, -5,
				SpringLayout.EAST, contentPane);// 滚动面板东侧——>容器东侧

		JButton resetButton = new JButton("清空");
		contentPane.add(resetButton);
		springLayout.putConstraint(SpringLayout.SOUTH, resetButton, -5,
				SpringLayout.SOUTH, contentPane);// “清空”按钮南侧——>容器南侧

		JButton submitButton = new JButton("确定");
		contentPane.add(submitButton);
		springLayout.putConstraint(SpringLayout.SOUTH, submitButton, -5,
				SpringLayout.SOUTH, contentPane);// “确定”按钮南侧——>容器南侧
		springLayout.putConstraint(SpringLayout.EAST, submitButton, -5,
				SpringLayout.EAST, contentPane);// “确定”按钮东侧——>容器东侧
		springLayout.putConstraint(SpringLayout.SOUTH, contentScrollPane, -5,
				SpringLayout.NORTH, submitButton);// 滚动面板南侧——>“确定”按钮北侧
		springLayout.putConstraint(SpringLayout.EAST, resetButton, -5,
				SpringLayout.WEST, submitButton);// “清空”按钮东侧——>“确定”按钮西侧
		//
	}

}
