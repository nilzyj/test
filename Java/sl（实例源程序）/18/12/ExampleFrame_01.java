import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ExampleFrame_01 extends JFrame {

	public static void main(String args[]) {
		ExampleFrame_01 frame = new ExampleFrame_01();
		frame.setVisible(true);
	}

	public ExampleFrame_01() {
		super();
		setTitle("�򵥵���");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("���ڵ�");// �������ڵ�
		DefaultMutableTreeNode nodeFirst = new DefaultMutableTreeNode("һ���ӽڵ�A");// ����һ���ڵ�
		root.add(nodeFirst);// ��һ���ڵ���ӵ����ڵ�
		DefaultMutableTreeNode nodeSecond = new DefaultMutableTreeNode("�����ӽڵ�",
				false);// �������������ӽڵ�Ķ����ڵ�
		nodeFirst.add(nodeSecond);// �������ڵ���ӵ�һ���ڵ�
		root.add(new DefaultMutableTreeNode("һ���ӽڵ�B"));// ����һ���ڵ�

		JTree treeRoot = new JTree(root);// ���ø��ڵ�ֱ�Ӵ�����
		getContentPane().add(treeRoot, BorderLayout.WEST);

		DefaultTreeModel treeModelDefault = new DefaultTreeModel(root);// ���ø��ڵ㴴����ģ�ͣ�����Ĭ�ϵ��жϷ�ʽ

		JTree treeDefault = new JTree(treeModelDefault);// ������ģ�ʹ�����
		getContentPane().add(treeDefault, BorderLayout.CENTER);

		DefaultTreeModel treeModelPointed = new DefaultTreeModel(root, true);// ���ø��ڵ㴴����ģ�ͣ������÷�Ĭ�ϵ��жϷ�ʽ

		JTree treePointed = new JTree(treeModelPointed);// ������ģ�ʹ�����
		getContentPane().add(treePointed, BorderLayout.EAST);
		//
	}

}
