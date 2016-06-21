import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class ExampleFrame_05 extends JFrame {

	public static void main(String args[]) {
		ExampleFrame_05 frame = new ExampleFrame_05();
		frame.setVisible(true);
	}

	public ExampleFrame_05() {
		super();
		setTitle("使用弹簧和支柱");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		Spring vST = Spring.constant(20);// 创建一个支柱
		Spring hSP = Spring.constant(20, 100, 500);// 创建一个弹簧

		JButton lButton = new JButton("按钮L");
		getContentPane().add(lButton);
		springLayout.putConstraint(SpringLayout.NORTH, lButton, vST,
				SpringLayout.NORTH, getContentPane());// “按钮L”北侧——>容器北侧
		springLayout.putConstraint(SpringLayout.WEST, lButton, hSP,
				SpringLayout.WEST, getContentPane());// “按钮L”西侧——>容器西侧

		JButton rButton = new JButton("按钮R");
		getContentPane().add(rButton);
		springLayout.putConstraint(SpringLayout.NORTH, rButton, 0,
				SpringLayout.NORTH, lButton);// “按钮R”北侧——>“按钮R”北侧
		springLayout.putConstraint(SpringLayout.WEST, rButton, Spring.scale(
				hSP, 2), SpringLayout.EAST, lButton);// “按钮R”西侧——>“按钮L”东侧
		springLayout.putConstraint(SpringLayout.EAST, getContentPane(), hSP,
				SpringLayout.EAST, rButton);// 容器东侧——>“按钮R”东侧
		//
	}

}
