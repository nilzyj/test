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
		setTitle("定制树");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("企业人事管理系统");

		DefaultMutableTreeNode nodeFirstA = new DefaultMutableTreeNode("人事管理");
		nodeFirstA.add(new DefaultMutableTreeNode("账套管理"));
		nodeFirstA.add(new DefaultMutableTreeNode("考勤管理"));
		nodeFirstA.add(new DefaultMutableTreeNode("奖惩管理"));
		nodeFirstA.add(new DefaultMutableTreeNode("培训管理"));
		root.add(nodeFirstA);

		DefaultMutableTreeNode nodeFirstB = new DefaultMutableTreeNode("待遇管理");
		nodeFirstB.add(new DefaultMutableTreeNode("帐套管理"));
		nodeFirstB.add(new DefaultMutableTreeNode("人员设置"));
		nodeFirstB.add(new DefaultMutableTreeNode("待遇报表"));
		root.add(nodeFirstB);

		DefaultMutableTreeNode nodeFirstC = new DefaultMutableTreeNode("系统维护");
		nodeFirstC.add(new DefaultMutableTreeNode("企业架构"));
		nodeFirstC.add(new DefaultMutableTreeNode("基本资料"));
		nodeFirstC.add(new DefaultMutableTreeNode("系统初始化"));
		root.add(nodeFirstC);

		tree = new JTree(root);
		tree.setRootVisible(false);// 不显示树的根节点
		tree.setRowHeight(20);// 树节点的行高为20像素
		tree.setFont(new Font("宋体", Font.BOLD, 14));// 设置树结点的字体
		tree.putClientProperty("JTree.lineStyle", "None");// 节点间不采用连接线
		DefaultTreeCellRenderer treeCellRenderer = (DefaultTreeCellRenderer) tree
				.getCellRenderer();// 获得树节点的绘制对象
		treeCellRenderer.setLeafIcon(null);// 设置叶子节点不采用图标
		treeCellRenderer.setClosedIcon(null);// 设置节点折叠时不采用图标
		treeCellRenderer.setOpenIcon(null);// 设置节点展开时不采用图标
		Enumeration enumeration = root.preorderEnumeration(); // 按前序遍历所有树节点
		while (enumeration.hasMoreElements()) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumeration
					.nextElement();
			if (!node.isLeaf()) {// 判断是否为叶子节点
				TreePath path = new TreePath(node.getPath());// 创建该节点的路径
				tree.expandPath(path);// 如果不是则展开该节点
			}
		}
		getContentPane().add(tree, BorderLayout.CENTER);
		//
	}

}
