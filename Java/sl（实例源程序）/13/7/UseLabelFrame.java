package com.mingrisoft;
import java.awt.BorderLayout;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class UseLabelFrame extends JFrame {
	public UseLabelFrame() {
		super();									// ���ø���Ĺ��췽��
		setTitle("ʹ�ñ�ǩ���");				// ���ô������
		setBounds(100, 100, 330, 200);				// ���ô������ʾλ�úʹ�С
		// ���ô����Ĭ�Ϲرշ�ʽΪ�رղ��˳�Ӧ�ó���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JLabel label = new JLabel();			// ������ǩ���
		label.setText("����һ��������ɽˮ��Ƭ��");		// ���ñ�ǩ�ı���
		getContentPane().add(label, BorderLayout.NORTH);			// ����ǩ��ӵ�����ı��������ϲ���λ��
		URL url = UseLabelFrame.class.getResource("picture.jpg");	// ���ͼƬ��URL
		Icon icon = new ImageIcon(url);		// ����ͼ��
		final JLabel label_1 = new JLabel();			// ������ǩ���
		label_1.setIcon(icon);		// ���ñ�ǩ��ͼ��
		getContentPane().add(label_1, BorderLayout.CENTER);			// ����ǩ��ӵ�������в�λ��
	}
	public static void main(String[] args) {
		// �����������
		UseLabelFrame frame = new UseLabelFrame();
		frame.setVisible(true);				// ��ʾ����
	}
}
