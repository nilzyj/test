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
		setTitle("ʹ�õ��ɲ��ֹ�����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SpringLayout springLayout = new SpringLayout();// �������ɲ��ֹ���������
		Container contentPane = getContentPane();// ��ô�����������
		contentPane.setLayout(springLayout);// �����������޸�Ϊ���õ��ɲ��ֹ�����

		JLabel topicLabel = new JLabel("���⣺");
		contentPane.add(topicLabel);
		springLayout.putConstraint(SpringLayout.NORTH, topicLabel, 5,
				SpringLayout.NORTH, contentPane);// �����ǩ���ࡪ��>��������
		springLayout.putConstraint(SpringLayout.WEST, topicLabel, 5,
				SpringLayout.WEST, contentPane);// �����ǩ���ࡪ��>��������

		JTextField topicTextField = new JTextField();
		contentPane.add(topicTextField);
		springLayout.putConstraint(SpringLayout.NORTH, topicTextField, 5,
				SpringLayout.NORTH, contentPane);// �����ı��򱱲ࡪ��>��������
		springLayout.putConstraint(SpringLayout.WEST, topicTextField, 5,
				SpringLayout.EAST, topicLabel);// �����ı������ࡪ��>�����ǩ����
		springLayout.putConstraint(SpringLayout.EAST, topicTextField, -5,
				SpringLayout.EAST, contentPane);// �����ı��򶫲ࡪ��>��������

		JLabel contentLabel = new JLabel("���ݣ�");
		contentPane.add(contentLabel);
		springLayout.putConstraint(SpringLayout.NORTH, contentLabel, 5,
				SpringLayout.SOUTH, topicTextField);// ���ݱ�ǩ���ࡪ��>�����ı����ϲ�
		springLayout.putConstraint(SpringLayout.WEST, contentLabel, 5,
				SpringLayout.WEST, contentPane);// ���ݱ�ǩ���ࡪ��>��������

		JScrollPane contentScrollPane = new JScrollPane();
		contentScrollPane.setViewportView(new JTextArea());
		contentPane.add(contentScrollPane);
		springLayout.putConstraint(SpringLayout.NORTH, contentScrollPane, 5,
				SpringLayout.SOUTH, topicTextField);// ������山�ࡪ��>�����ı����ϲ�
		springLayout.putConstraint(SpringLayout.WEST, contentScrollPane, 5,
				SpringLayout.EAST, contentLabel);// ����������ࡪ��>���ݱ�ǩ����
		springLayout.putConstraint(SpringLayout.EAST, contentScrollPane, -5,
				SpringLayout.EAST, contentPane);// ������嶫�ࡪ��>��������

		JButton resetButton = new JButton("���");
		contentPane.add(resetButton);
		springLayout.putConstraint(SpringLayout.SOUTH, resetButton, -5,
				SpringLayout.SOUTH, contentPane);// ����ա���ť�ϲࡪ��>�����ϲ�

		JButton submitButton = new JButton("ȷ��");
		contentPane.add(submitButton);
		springLayout.putConstraint(SpringLayout.SOUTH, submitButton, -5,
				SpringLayout.SOUTH, contentPane);// ��ȷ������ť�ϲࡪ��>�����ϲ�
		springLayout.putConstraint(SpringLayout.EAST, submitButton, -5,
				SpringLayout.EAST, contentPane);// ��ȷ������ť���ࡪ��>��������
		springLayout.putConstraint(SpringLayout.SOUTH, contentScrollPane, -5,
				SpringLayout.NORTH, submitButton);// ��������ϲࡪ��>��ȷ������ť����
		springLayout.putConstraint(SpringLayout.EAST, resetButton, -5,
				SpringLayout.WEST, submitButton);// ����ա���ť���ࡪ��>��ȷ������ť����
		//
	}

}
