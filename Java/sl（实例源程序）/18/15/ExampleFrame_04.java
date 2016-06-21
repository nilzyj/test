import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

public class ExampleFrame_04 extends JFrame {

	private JTree tree;

	public static void main(String args[]) {
		ExampleFrame_04 frame = new ExampleFrame_04();
		frame.setVisible(true);
	}

	public ExampleFrame_04() {
		super();
		setTitle("������");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("��ҵ���¹���ϵͳ");

		DefaultMutableTreeNode nodeFirstA = new DefaultMutableTreeNode("���¹���");
		nodeFirstA.add(new DefaultMutableTreeNode("���׹���"));
		nodeFirstA.add(new DefaultMutableTreeNode("���ڹ���"));
		nodeFirstA.add(new DefaultMutableTreeNode("���͹���"));
		nodeFirstA.add(new DefaultMutableTreeNode("��ѵ����"));
		root.add(nodeFirstA);

		DefaultMutableTreeNode nodeFirstB = new DefaultMutableTreeNode("��������");
		nodeFirstB.add(new DefaultMutableTreeNode("���׹���"));
		nodeFirstB.add(new DefaultMutableTreeNode("��Ա����"));
		nodeFirstB.add(new DefaultMutableTreeNode("��������"));
		root.add(nodeFirstB);

		DefaultMutableTreeNode nodeFirstC = new DefaultMutableTreeNode("ϵͳά��");
		nodeFirstC.add(new DefaultMutableTreeNode("��ҵ�ܹ�"));
		nodeFirstC.add(new DefaultMutableTreeNode("��������"));
		nodeFirstC.add(new DefaultMutableTreeNode("ϵͳ��ʼ��"));
		root.add(nodeFirstC);

		tree = new JTree(root);
		tree.setRootVisible(false);// ����ʾ���ĸ��ڵ�
		tree.setRowHeight(20);// ���ڵ���и�Ϊ20����
		tree.setFont(new Font("����", Font.BOLD, 14));// ��������������
		tree.putClientProperty("JTree.lineStyle", "None");// �ڵ�䲻����������
		DefaultTreeCellRenderer treeCellRenderer = (DefaultTreeCellRenderer) tree
				.getCellRenderer();// ������ڵ�Ļ��ƶ���
		treeCellRenderer.setLeafIcon(null);// ����Ҷ�ӽڵ㲻����ͼ��
		treeCellRenderer.setClosedIcon(null);// ���ýڵ��۵�ʱ������ͼ��
		treeCellRenderer.setOpenIcon(null);// ���ýڵ�չ��ʱ������ͼ��
		Enumeration enumeration = root.preorderEnumeration(); // ��ǰ������������ڵ�
		while (enumeration.hasMoreElements()) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumeration
					.nextElement();
			if (!node.isLeaf()) {// �ж��Ƿ�ΪҶ�ӽڵ�
				TreePath path = new TreePath(node.getPath());// �����ýڵ��·��
				tree.expandPath(path);// ���������չ���ýڵ�
			}
		}
		getContentPane().add(tree, BorderLayout.CENTER);
		//
	}

}
