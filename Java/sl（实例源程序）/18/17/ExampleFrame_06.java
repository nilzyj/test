import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class ExampleFrame_06 extends JFrame {

	private JTree tree;

	public static void main(String args[]) {
		ExampleFrame_06 frame = new ExampleFrame_06();
		frame.setVisible(true);
	}

	public ExampleFrame_06() {
		super();
		setTitle("����չ���ڵ��¼�");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("��ϰ���");

		DefaultMutableTreeNode nodeA = new DefaultMutableTreeNode("����칫��");
		root.add(nodeA);

		DefaultMutableTreeNode nodeB = new DefaultMutableTreeNode("���²�");
		root.add(nodeB);

		DefaultMutableTreeNode nodeC = new DefaultMutableTreeNode("������");
		root.add(nodeC);
		nodeC.add(new DefaultMutableTreeNode("����ά����"));
		nodeC.add(new DefaultMutableTreeNode("Ӧ�ÿ�����"));

		DefaultMutableTreeNode nodeD = new DefaultMutableTreeNode("����");
		root.add(nodeD);
		nodeD.add(new DefaultMutableTreeNode("�������"));
		nodeD.add(new DefaultMutableTreeNode("���ڿ�����"));

		DefaultMutableTreeNode nodeE = new DefaultMutableTreeNode("�ƹ㲿");
		root.add(nodeE);

		tree = new JTree(root);
		tree.addTreeWillExpandListener(new TreeWillExpandListener() {// �������ڵ㽫Ҫ��չ�����۵����¼�
			public void treeWillCollapse(TreeExpansionEvent e) {// ���ڵ㽫Ҫ���۵�ʱ����
				TreePath path = e.getPath();// ��ý�Ҫ���۵��ڵ��·��
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
						.getLastPathComponent();// ��ý�Ҫ���۵��Ľڵ�
				System.out.println("�ڵ㡰" + node + "����Ҫ���۵���");
			}

			public void treeWillExpand(TreeExpansionEvent e) {// ���ڵ㽫Ҫ��չ��ʱ����
				TreePath path = e.getPath();// ��ý�Ҫ��չ���ڵ��·��
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
						.getLastPathComponent();// ��ý�Ҫ��չ���Ľڵ�
				System.out.println("�ڵ㡰" + node + "����Ҫ��չ����");
			}
		});
		tree.addTreeExpansionListener(new TreeExpansionListener() {// �������ڵ��Ѿ���չ�����۵����¼�
			public void treeCollapsed(TreeExpansionEvent e) {// ���ڵ��Ѿ��۵�ʱ����
				TreePath path = e.getPath();// ����Ѿ����۵��ڵ��·��
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
						.getLastPathComponent();// ����Ѿ����۵��Ľڵ�
				System.out.println("�ڵ㡰" + node + "���Ѿ����۵���");
				System.out.println();
			}

			public void treeExpanded(TreeExpansionEvent e) {// ���ڵ��Ѿ���չ��ʱ����
				TreePath path = e.getPath();// ����Ѿ���չ���ڵ��·��
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
						.getLastPathComponent();// ����Ѿ���չ���Ľڵ�
				System.out.println("�ڵ㡰" + node + "���Ѿ���չ����");
				System.out.println();
			}
		});
		getContentPane().add(tree, BorderLayout.CENTER);
		//
	}

}
