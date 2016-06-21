import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

public class WindowStateListener_Example extends JFrame {

	public static void main(String args[]) {
		WindowStateListener_Example frame = new WindowStateListener_Example();
		frame.setVisible(true);
	}

	public WindowStateListener_Example() {
		super();
		addWindowStateListener(new MyWindowStateListener());// Ϊ�������״̬�¼�������
		setTitle("������״̬�¼�");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//
	}

	private class MyWindowStateListener implements WindowStateListener {
		public void windowStateChanged(WindowEvent e) {
			int oldState = e.getOldState();// ��ô�����ǰ��״̬
			int newState = e.getNewState();// ��ô������ڵ�״̬

			String from = "";// ��ʶ������ǰ״̬�������ַ���
			String to = "";// ��ʶ��������״̬�������ַ���

			switch (oldState) {// �жϴ�̨��ǰ��״̬
			case Frame.NORMAL:// ���崦��������
				from = "������";
				break;
			case Frame.MAXIMIZED_BOTH:// ���崦�����
				from = "���";
				break;
			default:// ���崦��ͼ�껯
				from = "ͼ�껯";
			}

			switch (newState) {// �жϴ�̨���ڵ�״̬
			case Frame.NORMAL:// ���崦��������
				to = "������";
				break;
			case Frame.MAXIMIZED_BOTH:// ���崦�����
				to = "���";
				break;
			default:// ���崦��ͼ�껯
				to = "ͼ�껯";
			}

			System.out.println(from + "����>" + to);
		}
	}

}
