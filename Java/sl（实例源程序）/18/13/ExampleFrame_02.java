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
		setTitle("处理选中节点事件");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("本地磁盘（D：）");// 创建树的跟节点

		DefaultMutableTreeNode nodeA = new DefaultMutableTreeNode("图片");// 创建树的一级子节点
		root.add(nodeA);// 将一级子结点添加到跟结点
		nodeA.add(new DefaultMutableTreeNode("千山——世博园旅游"));// 向一级子节点添加二级子节点
		DefaultMutableTreeNode nodeAB = new DefaultMutableTreeNode("凤凰山——大鹿岛旅游");// 创建树的二级子节点
		nodeA.add(nodeAB);// 将二级子节点添加到一级子节点
		nodeAB.add(new DefaultMutableTreeNode("大浪淘沙.GIF", false));// 向二级子节点添加叶子节点
		nodeAB.add(new DefaultMutableTreeNode("辽阔的大海.JPG", false));// 向二级子节点添加叶子节点

		root.add(new DefaultMutableTreeNode("音乐"));// 向根节点添加一级子节点

		DefaultTreeModel treeModel = new DefaultTreeModel(root, true);// 通过树的根节点创建树模型

		tree = new JTree(treeModel);// 通过树模型创建树
		TreeSelectionModel treeSelectionModel = tree.getSelectionModel();// 获得树的选择模型
		treeSelectionModel
				.setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);// 设置树的选择模式为连选
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				if (!tree.isSelectionEmpty()) {// 查看是否存在被选中的节点
					TreePath[] selectionPaths = tree.getSelectionPaths();// 获得所有被选中节点的路径
					for (int i = 0; i < selectionPaths.length; i++) {
						TreePath treePath = selectionPaths[i];// 获得被选中节点的路径
						Object[] path = treePath.getPath();// 以Object数组的形式返回该路径中所有节点的对象
						for (int j = 0; j < path.length; j++) {
							DefaultMutableTreeNode node = (DefaultMutableTreeNode) path[j];// 获得节点
							System.out.print(node.getUserObject()
									+ (j == (path.length - 1) ? "" : "-->"));// 输出节点标签
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
