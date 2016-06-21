package com.lw;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Shrewmouse extends JFrame implements Runnable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 8752899717443325480L;
    private JLabel[] mouses; // �����ʾ����ı�ǩ����
    private ImageIcon imgMouse; // ����ͼƬ����
    
    /**
     * Launch the application
     * 
     * @param args
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Shrewmouse frame = new Shrewmouse();
                    frame.setVisible(true);
                    new Thread(frame).start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame
     */
    public Shrewmouse() {
        super();
        setResizable(false); // ��ֹ���������С
        getContentPane().setLayout(null); // ���岻ʹ�ò��ֹ�����
        setTitle("���״������Ϸ"); // ���ô������
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ��ʼ������ͼƬ����
        ImageIcon img = new ImageIcon(getClass().getResource("background.jpg"));
        // ��ʼ������ͼƬ����
        imgMouse = new ImageIcon(getClass().getResource("mouse.png"));
        mouses = new JLabel[6]; // ������ʾ����ı�ǩ����
        for (int i = 0; i < 6; i++) { // ��������
            mouses[i] = new JLabel(); // ��ʼ��ÿһ������Ԫ��
            // ���ñ�ǩ�����ͼƬ��ͬ��С
            mouses[i].setSize(imgMouse.getIconWidth(), imgMouse.getIconHeight());
            mouses[i].addMouseListener(new MouseAdapter() { // Ϊ��ǩ�������¼�����������
                        /**
                         * ������굥���¼��ķ���
                         */
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            Object source = e.getSource(); // ��ȡ�¼�Դ���������ǩ
                            if (source instanceof JLabel) { // ����¼�Դ�Ǳ�ǩ���
                                JLabel mouse = (JLabel) source; // ǿ��ת��ΪJLabel��ǩ
                                mouse.setIcon(null); // ȡ����ǩͼ��
                            }
                        }
                    });
            getContentPane().add(mouses[i]); // �����ʾ����ı�ǩ������
        }
        
        mouses[0].setLocation(253, 300); // ����ÿ����ǩ��λ��
        mouses[1].setLocation(333, 250);
        mouses[2].setLocation(388, 296);
        mouses[3].setLocation(362, 364);
        mouses[4].setLocation(189, 353);
        mouses[5].setLocation(240, 409);
        
        final JLabel backLabel = new JLabel(); // ������ʾ�����ı�ǩ
        // ���ñ�ǩ�뱳��ͼƬ��ͬ��С
        backLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        // ���ô�����Ʊ���ͼƬ��С
        setBounds(100, 100, img.getIconWidth(), img.getIconHeight() + 30);
        backLabel.setIcon(img); // ��ӱ�������ǩ
        getContentPane().add(backLabel); // ��ӱ�����ǩ������
    }
    
    /**
     * �̵߳ĺ��ķ���
     */
    public void run() {
        while (true) { // ʹ������ѭ��
            try {
                Thread.sleep(1000); // ʹ�߳�����1��
                int index = (int) (Math.random() * 6); // ��������ĵ�������
                if (mouses[index].getIcon() == null) // ��������ǩû������ͼƬ
                    mouses[index].setIcon(imgMouse); // Ϊ�ñ�ǩ��ӵ���ͼƬ
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
