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
		setTitle("ʹ�õ��ɺ�֧��");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		Spring vST = Spring.constant(20);// ����һ��֧��
		Spring hSP = Spring.constant(20, 100, 500);// ����һ������

		JButton lButton = new JButton("��ťL");
		getContentPane().add(lButton);
		springLayout.putConstraint(SpringLayout.NORTH, lButton, vST,
				SpringLayout.NORTH, getContentPane());// ����ťL�����ࡪ��>��������
		springLayout.putConstraint(SpringLayout.WEST, lButton, hSP,
				SpringLayout.WEST, getContentPane());// ����ťL�����ࡪ��>��������

		JButton rButton = new JButton("��ťR");
		getContentPane().add(rButton);
		springLayout.putConstraint(SpringLayout.NORTH, rButton, 0,
				SpringLayout.NORTH, lButton);// ����ťR�����ࡪ��>����ťR������
		springLayout.putConstraint(SpringLayout.WEST, rButton, Spring.scale(
				hSP, 2), SpringLayout.EAST, lButton);// ����ťR�����ࡪ��>����ťL������
		springLayout.putConstraint(SpringLayout.EAST, getContentPane(), hSP,
				SpringLayout.EAST, rButton);// �������ࡪ��>����ťR������
		//
	}

}
