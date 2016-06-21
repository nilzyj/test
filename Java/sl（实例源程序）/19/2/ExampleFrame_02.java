import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ExampleFrame_02 extends JFrame {

	private JPanel cardPanel;// ����Ƭ���ֹ�������������

	private CardLayout cardLayout;// ��Ƭ���ֹ���������

	public static void main(String args[]) {
		ExampleFrame_02 frame = new ExampleFrame_02();
		frame.setVisible(true);
	}

	public ExampleFrame_02() {
		super();
		setTitle("ʹ�ÿ�Ƭ���ֹ�����");
		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cardLayout = new CardLayout();// ����һ����Ƭ���ֹ���������
		cardPanel = new JPanel(cardLayout);// ����һ������Ƭ���ֹ�������������
		getContentPane().add(cardPanel, BorderLayout.CENTER);// ��ӵ������м�

		String[] labelNames = { "��ƬA", "��ƬB", "��ƬC" };
		for (int i = 0; i < labelNames.length; i++) {
			final JLabel label = new JLabel(labelNames[i]);// ��������Ƭ�ı�ǩ����
			label.setHorizontalAlignment(SwingConstants.CENTER);// ���ñ�ǩ�ı���λ��
			label.setFont(new Font("", Font.BOLD, 16));// ���ñ�ǩ�ı�������
			label.setForeground(new Color(255, 0, 0));// ���ñ�ǩ�ı�����ɫ
			cardPanel.add(label, labelNames[i]);// �����Ƭ���ֹ��������������ӿ�Ƭ
		}

		final JPanel buttonPanel = new JPanel();// ����һ����ť���
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);// ��ӵ������·�

		String[] buttonNames = { "��һ��", "ǰһ��", "��ƬA", "��ƬB", "��ƬC", "��һ��",
				"���һ��" };
		for (int i = 0; i < buttonNames.length; i++) {
			final JButton button = new JButton(buttonNames[i]);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String buttonText = button.getText();
					if (buttonText.equals("��һ��"))
						cardLayout.first(cardPanel);// ��ʾ��һ����Ƭ
					else if (buttonText.equals("ǰһ��"))
						cardLayout.previous(cardPanel);// ��ʾ��һ����Ƭ
					else if (buttonText.equals("��ƬA"))
						cardLayout.show(cardPanel, "��ƬA");// ��ʾ��ƬA
					else if (buttonText.equals("��ƬB"))
						cardLayout.show(cardPanel, "��ƬB");// ��ʾ��ƬB
					else if (buttonText.equals("��ƬC"))
						cardLayout.show(cardPanel, "��ƬC");// ��ʾ��ƬC
					else if (buttonText.equals("��һ��"))
						cardLayout.next(cardPanel);// ��ʾ��һ����Ƭ
					else
						cardLayout.last(cardPanel);// ��ʾ���һ����Ƭ
				}
			});
			buttonPanel.add(button);
		}
		//
	}

}
