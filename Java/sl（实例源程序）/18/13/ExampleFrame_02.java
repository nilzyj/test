import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class ExampleFrame_02 extends JFrame {

	private JTree tree;

	public static void main(String args[]) {
		ExampleFrame_02 frame = new ExampleFrame_02();
		frame.setVisible(true);
	}

	public ExampleFrame_02() {
		super();
		setTitle("����ѡ�нڵ��¼�");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("���ش��̣�D����");// �������ĸ��ڵ�

		DefaultMutableTreeNode nodeA = new DefaultMutableTreeNode("ͼƬ");// ��������һ���ӽڵ�
		root.add(nodeA);// ��һ���ӽ����ӵ������
		nodeA.add(new DefaultMutableTreeNode("ǧɽ��������԰����"));// ��һ���ӽڵ���Ӷ����ӽڵ�
		DefaultMutableTreeNode nodeAB = new DefaultMutableTreeNode("���ɽ������¹������");// �������Ķ����ӽڵ�
		nodeA.add(nodeAB);// �������ӽڵ���ӵ�һ���ӽڵ�
		nodeAB.add(new DefaultMutableTreeNode("������ɳ.GIF", false));// ������ӽڵ����Ҷ�ӽڵ�
		nodeAB.add(new DefaultMutableTreeNode("�����Ĵ�.JPG", false));// ������ӽڵ����Ҷ�ӽڵ�

		root.add(new DefaultMutableTreeNode("����"));// ����ڵ����һ���ӽڵ�

		DefaultTreeModel treeModel = new DefaultTreeModel(root, true);// ͨ�����ĸ��ڵ㴴����ģ��

		tree = new JTree(treeModel);// ͨ����ģ�ʹ�����
		TreeSelectionModel treeSelectionModel = tree.getSelectionModel();// �������ѡ��ģ��
		treeSelectionModel
				.setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);// ��������ѡ��ģʽΪ��ѡ
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				if (!tree.isSelectionEmpty()) {// �鿴�Ƿ���ڱ�ѡ�еĽڵ�
					TreePath[] selectionPaths = tree.getSelectionPaths();// ������б�ѡ�нڵ��·��
					for (int i = 0; i < selectionPaths.length; i++) {
						TreePath treePath = selectionPaths[i];// ��ñ�ѡ�нڵ��·��
						Object[] path = treePath.getPath();// ��Object�������ʽ���ظ�·�������нڵ�Ķ���
						for (int j = 0; j < path.length; j++) {
							DefaultMutableTreeNode node = (DefaultMutableTreeNode) path[j];// ��ýڵ�
							System.out.print(node.getUserObject()
									+ (j == (path.length - 1) ? "" : "-->"));// ����ڵ��ǩ
						}
						System.out.println();
					}
					System.out.println();
				}
			}
		});
		getContentPane().add(tree, BorderLayout.CENTER);
		//
	}
}
