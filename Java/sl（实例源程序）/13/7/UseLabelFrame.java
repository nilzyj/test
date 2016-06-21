package com.mingrisoft;
import java.awt.BorderLayout;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class UseLabelFrame extends JFrame {
	public UseLabelFrame() {
		super();									// 调用父类的构造方法
		setTitle("使用标签组件");				// 设置窗体标题
		setBounds(100, 100, 330, 200);				// 设置窗体的显示位置和大小
		// 设置窗体的默认关闭方式为关闭并退出应用程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JLabel label = new JLabel();			// 创建标签组件
		label.setText("这是一幅美丽的山水照片：");		// 设置标签的标题
		getContentPane().add(label, BorderLayout.NORTH);			// 将标签添加到窗体的北部（即上部）位置
		URL url = UseLabelFrame.class.getResource("picture.jpg");	// 获得图片的URL
		Icon icon = new ImageIcon(url);		// 创建图标
		final JLabel label_1 = new JLabel();			// 创建标签组件
		label_1.setIcon(icon);		// 设置标签的图标
		getContentPane().add(label_1, BorderLayout.CENTER);			// 将标签添加到窗体的中部位置
	}
	public static void main(String[] args) {
		// 创建窗体对象
		UseLabelFrame frame = new UseLabelFrame();
		frame.setVisible(true);				// 显示窗体
	}
}
