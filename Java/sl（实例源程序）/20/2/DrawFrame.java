package com.lzw;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
public class DrawFrame extends JFrame {
	public DrawFrame() {
		super();
		initialize();// ���ó�ʼ������
	}
	// ��ʼ������
	private void initialize() {
		this.setSize(300, 200);// ���ô����С
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ô���ر�ģʽ
		add(new CanvasPanel());// ���ô������Ϊ��ͼ������
		this.setTitle("��ͼʵ��2");// ���ô������
	}
	public static void main(String[] args) {
		new DrawFrame().setVisible(true);
	}
	class CanvasPanel extends JPanel {
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			Shape[] shapes = new Shape[4];
			shapes[0] = new Ellipse2D.Double(5, 5, 100, 100);
			shapes[1] = new Rectangle2D.Double(110, 5, 100, 100);
			shapes[2] = new Rectangle2D.Double(15, 15, 80, 80);
			shapes[3] = new Ellipse2D.Double(120, 15, 80, 80);
			for (Shape shape : shapes) {
				Rectangle2D bounds = shape.getBounds2D();
				if (bounds.getWidth() == 80)
					g2.fill(shape);
				else
					g2.draw(shape);
			}
		}
	}
}
