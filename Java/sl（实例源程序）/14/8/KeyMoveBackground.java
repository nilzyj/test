package com.lw;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyMoveBackground extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -4152939803706413827L;
    private JLabel label; // ����ͼƬ�ı�ǩ
    private ImageIcon icon;
    private ImageIcon glassImg;
    
    /**
     * Launch the application
     * 
     * @param args
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    KeyMoveBackground frame = new KeyMoveBackground();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame
     */
    public KeyMoveBackground() {
        super();
        setResizable(false); // ��ֹ���������С
        getContentPane().setLayout(null); // ���ÿղ���
        setTitle("������ƶ�����"); // ���ô������
        setBounds(100, 100, 500, 375);// ���ô���λ�úʹ�С
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ô����˳�ʱ����
        label = new JLabel(); // ������ǩ���
        icon = new ImageIcon(getClass().getResource("background.jpg"));
        glassImg = new ImageIcon(getClass().getResource("glass.png"));
        label.setIcon(icon); // ���ñ�ǩʹ�ñ���ͼ��
        label.setSize(icon.getIconWidth(), icon.getIconHeight());// ʹ��ǩ��ͼ��ͬ����С
        label.setLocation(0, 0);// ���ñ�ǩĬ��λ��
        addKeyListener(new KeyAdapter() { // Ϊ������Ӱ����¼�����������
            public void keyPressed(final KeyEvent e) {
                do_label_keyPressed(e); // �����¼�������
            }
        });
        getContentPane().add(label); // ��ӱ�����ǩ������
        JLabel glassLabel = new JLabel(glassImg); // ����ȡ�����ǩ
        JPanel glassPane = new JPanel(new BorderLayout());
        glassPane.add(glassLabel, BorderLayout.CENTER); // ���ȡ�����ǩ���������
        glassPane.setOpaque(false); // ʹ���͸��
        setGlassPane(glassPane); // ���ô���ʹ�ò������
        getGlassPane().setVisible(true); // ��ʾ�������
        
    }
    
    /**
     * ������ǩ����İ��������¼�������
     * 
     * @param e
     */
    protected void do_label_keyPressed(final KeyEvent e) {
        int code = e.getKeyCode(); // ��ȡ��������
        Point location = label.getLocation(); // ��ȡ��ǩ���λ��
        int step = 30; // �ƶ��ٶ�
        switch (code) {
            case KeyEvent.VK_RIGHT: // ��������������ҷ����
                if (location.x > (getWidth() - label.getWidth())) // �ڲ�������Ļ�����
                    label.setLocation(location.x - step, location.y); // �����ƶ���ǩ
                break;
            case KeyEvent.VK_LEFT: // ����ǰ��������������
                if (location.x < 0) // �ڲ�������Ļ�����
                    label.setLocation(location.x + step, location.y); // �����ƶ���ǩ
                break;
            case KeyEvent.VK_DOWN: // ����ǰ����������·����
                if (location.y > (getHeight() - label.getHeight())) // �ڲ�������Ļ�����
                    label.setLocation(location.x, location.y - step); // �����ƶ���ǩ
                break;
            case KeyEvent.VK_UP: // ����ǰ����������Ϸ����
                if (location.y < 0) { // �ڲ�������Ļ�����
                    label.setLocation(location.x, location.y + step); // �����ƶ���ǩ
                }
                break;
            default:
                break;
        }
    }
}
