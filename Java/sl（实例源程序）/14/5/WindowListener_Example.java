import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class WindowListener_Example extends JFrame {

	public static void main(String args[]) {
		WindowListener_Example frame = new WindowListener_Example();
		frame.setVisible(true);
	}

	public WindowListener_Example() {
		super();
		addWindowListener(new MyWindowListener());// Ϊ������������¼�������
		setTitle("�������������¼�");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//
	}

	private class MyWindowListener implements WindowListener {
		public void windowActivated(WindowEvent e) {// ���屻����ʱ����
			System.out.println("���ڱ����");
		}

		public void windowOpened(WindowEvent e) {// ���屻��ʱ����
			System.out.println("���ڱ��򿪣�");
		}

		public void windowIconified(WindowEvent e) {// ���屻ͼ�껯ʱ����
			System.out.println("���ڱ�ͼ�껯��");
		}

		public void windowDeiconified(WindowEvent e) {// ���屻��ͼ�껯ʱ����
			System.out.println("���ڱ���ͼ�껯��");
		}

		public void windowClosing(WindowEvent e) {// ���彫Ҫ���ر�ʱ����
			System.out.println("���ڽ�Ҫ���رգ�");
		}

		public void windowDeactivated(WindowEvent e) {// ���岻�ٴ��ڼ���״̬ʱ����
			System.out.println("���ڲ��ٴ��ڼ���״̬��");
		}

		public void windowClosed(WindowEvent e) {// �����Ѿ����ر�ʱ����
			System.out.println("�����Ѿ����رգ�");
		}
	}

}
