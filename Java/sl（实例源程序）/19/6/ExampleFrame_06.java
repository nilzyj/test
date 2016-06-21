import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.SpringLayout.Constraints;

public class ExampleFrame_06 extends JFrame {

	public static void main(String args[]) {
		ExampleFrame_06 frame = new ExampleFrame_06();
		frame.setVisible(true);
	}

	public ExampleFrame_06() {
		super();
		setTitle("���õ��ɿ��������С");
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

		Spring widthSP = Spring.constant(60, 300, 600);// ����һ������
		Spring heightST = Spring.constant(60);// ����һ��֧��
		Constraints lButtonCons = springLayout.getConstraints(lButton);// ��á���ťL����Constraints����
		lButtonCons.setWidth(widthSP);// ���ÿ��������ȵĵ���
		lButtonCons.setHeight(heightST);// ���ÿ�������߶ȵ�֧��
		Constraints rButtonCons = springLayout.getConstraints(rButton);// ��á���ťR����Constraints����
		rButtonCons.setWidth(widthSP);// ���ÿ��������ȵĵ���
		rButtonCons.setHeight(heightST);// ���ÿ�������߶ȵ�֧��
		//
	}
}
