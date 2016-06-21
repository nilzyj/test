import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class KeyEvent_Example extends JFrame { // 继承窗体类JFrame
	public static void main(String args[]) {
		KeyEvent_Example frame = new KeyEvent_Example();
		frame.setVisible(true); // 设置窗体可见，默认为不可见
	}

	public KeyEvent_Example() {
		super(); // 继承父类的构造方法
		setTitle("键盘事件示例"); // 设置窗体的标题
		setBounds(100, 100, 500, 375); // 设置窗体的显示位置及大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗体关闭按钮的动作为退出

		final JLabel label = new JLabel();
		label.setText("备注：");
		getContentPane().add(label, BorderLayout.WEST);

		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		JTextArea textArea = new JTextArea();
		textArea.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) { // 按键被按下时被触发
				String keyText = KeyEvent.getKeyText(e.getKeyCode()); // 获得描述keyCode的标签
				if (e.isActionKey()) { // 判断按下的是否为动作键
					System.out.println("您按下的是动作键“" + keyText + "”");
				} else {
					System.out.print("您按下的是非动作键“" + keyText + "”");
					int keyCode = e.getKeyCode(); // 获得与此事件中的键相关联的字符
					switch (keyCode) {
					case KeyEvent.VK_CONTROL: // 判断按下的是否为Ctrl键
						System.out.print("，Ctrl键被按下");
						break;
					case KeyEvent.VK_ALT: // 判断按下的是否为Alt键
						System.out.print("，Alt键被按下");
						break;
					case KeyEvent.VK_SHIFT: // 判断按下的是否为Shift键
						System.out.print("，Shift键被按下");
						break;
					}
					System.out.println();
				}
			}

			public void keyTyped(KeyEvent e) { // 发生击键事件时被触发
				System.out.println("此次输入的是“" + e.getKeyChar() + "”");// 获得输入的字符
			}

			public void keyReleased(KeyEvent e) { // 按键被释放时被触发
				String keyText = KeyEvent.getKeyText(e.getKeyCode()); // 获得描述keyCode的标签
				System.out.println("您释放的是“" + keyText + "”键");
				System.out.println();
			}
		});
		textArea.setLineWrap(true);
		textArea.setRows(3);
		textArea.setColumns(15);
		scrollPane.setViewportView(textArea);
		//
	}

}
