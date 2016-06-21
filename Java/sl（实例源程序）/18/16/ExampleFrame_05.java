import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class ExampleFrame_05 extends JFrame {

	private JTextField textField;

	private DefaultTreeModel treeModel;

	private JTree tree;

	public static void main(String args[]) {
		ExampleFrame_05 frame = new ExampleFrame_05();
		frame.setVisible(true);
	}

	public ExampleFrame_05() {
		super();
		setTitle("ά����ҵ�ܹ�");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

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

		treeModel = new DefaultTreeModel(root, true);

		tree = new JTree(treeModel);
		tree.setSelectionPath(new TreePath(root));
		scrollPane.setViewportView(tree);

		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		final JLabel label = new JLabel();
		label.setText("���ƣ�");
		panel.add(label);

		textField = new JTextField();
		textField.setColumns(8);
		textField.setText("����");
		panel.add(textField);

		final JButton addButton = new JButton("���");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(
						textField.getText());// ��������ӽڵ�
				TreePath selectionPath = tree.getSelectionPath();// ���ѡ�еĸ��ڵ�·��
				DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) selectionPath
						.getLastPathComponent();// ���ѡ�еĸ��ڵ�
				treeModel.insertNodeInto(node, parentNode, parentNode
						.getChildCount());// ����ڵ㵽�����ӽڵ�֮��
				TreePath path = selectionPath.pathByAddingChild(node);// �������ӽڵ��·��
				if (!tree.isVisible(path))
					tree.makeVisible(path);// ����ýڵ㲻�ɼ�������ɼ�
			}
		});
		panel.add(addButton);

		final JButton updButton = new JButton("�޸�");
		updButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TreePath selectionPath = tree.getSelectionPath();// ���ѡ�е����޸Ľڵ��·��
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) selectionPath
						.getLastPathComponent();// ���ѡ�е����޸Ľڵ�
				node.setUserObject(textField.getText());// �޸Ľڵ���û���ǩ
				treeModel.nodeChanged(node);// ֪ͨ��ģ�͸ýڵ��Ѿ����޸�
				tree.setSelectionPath(selectionPath);// ѡ�б��޸ĵĽڵ�
			}
		});
		panel.add(updButton);

		final JButton delButton = new JButton("ɾ��");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
						.getLastSelectedPathComponent();// ���ѡ�е���ɾ���ڵ�
				if (!node.isRoot()) {// �鿴��ɾ���Ľڵ��Ƿ�Ϊ���ڵ㣬���ڵ㲻����ɾ��
					DefaultMutableTreeNode nextSelectedNode = node
							.getNextSibling();// �����һ���ֵܽڵ㣬�Ա�ѡ��
					if (nextSelectedNode == null)// �鿴�Ƿ�����ֵܽڵ�
						nextSelectedNode = (DefaultMutableTreeNode) node
								.getParent();// �����������ѡ���丸�ڵ�
					treeModel.removeNodeFromParent(node);// ɾ���ڵ�
					tree.setSelectionPath(new TreePath(nextSelectedNode
							.getPath()));// ѡ�нڵ�
				}
			}
		});
		panel.add(delButton);
		//
	}
}
