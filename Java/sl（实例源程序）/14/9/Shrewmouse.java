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
    private JLabel[] mouses; // 存放显示地鼠的标签数组
    private ImageIcon imgMouse; // 地鼠图片对象
    
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
        setResizable(false); // 禁止调整窗体大小
        getContentPane().setLayout(null); // 窗体不使用布局管理器
        setTitle("简易打地鼠游戏"); // 设置窗体标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 初始化背景图片对象
        ImageIcon img = new ImageIcon(getClass().getResource("background.jpg"));
        // 初始化地鼠图片对象
        imgMouse = new ImageIcon(getClass().getResource("mouse.png"));
        mouses = new JLabel[6]; // 创建显示地鼠的标签数组
        for (int i = 0; i < 6; i++) { // 遍历数组
            mouses[i] = new JLabel(); // 初始化每一个数组元素
            // 设置标签与地鼠图片相同大小
            mouses[i].setSize(imgMouse.getIconWidth(), imgMouse.getIconHeight());
            mouses[i].addMouseListener(new MouseAdapter() { // 为标签添加鼠标事件监听适配器
                        /**
                         * 处理鼠标单击事件的方法
                         */
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            Object source = e.getSource(); // 获取事件源，即地鼠标签
                            if (source instanceof JLabel) { // 如果事件源是标签组件
                                JLabel mouse = (JLabel) source; // 强制转换为JLabel标签
                                mouse.setIcon(null); // 取消标签图标
                            }
                        }
                    });
            getContentPane().add(mouses[i]); // 添加显示地鼠的标签到窗体
        }
        
        mouses[0].setLocation(253, 300); // 设置每个标签的位置
        mouses[1].setLocation(333, 250);
        mouses[2].setLocation(388, 296);
        mouses[3].setLocation(362, 364);
        mouses[4].setLocation(189, 353);
        mouses[5].setLocation(240, 409);
        
        final JLabel backLabel = new JLabel(); // 创建显示背景的标签
        // 设置标签与背景图片相同大小
        backLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        // 设置窗体近似背景图片大小
        setBounds(100, 100, img.getIconWidth(), img.getIconHeight() + 30);
        backLabel.setIcon(img); // 添加背景到标签
        getContentPane().add(backLabel); // 添加背景标签到窗体
    }
    
    /**
     * 线程的核心方法
     */
    public void run() {
        while (true) { // 使用无限循环
            try {
                Thread.sleep(1000); // 使线程休眠1秒
                int index = (int) (Math.random() * 6); // 生成随机的地鼠索引
                if (mouses[index].getIcon() == null) // 如果地鼠标签没有设置图片
                    mouses[index].setIcon(imgMouse); // 为该标签添加地鼠图片
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
