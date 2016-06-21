

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class MTreeComboBox extends JPanel {

	private JTextField textField;

	private DefaultMutableTreeNode root;

	public MTreeComboBox(DefaultMutableTreeNode root, int column,
			final double percentOfHeightInWidth) {
		super();
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setHgap(0);
		setLayout(flowLayout);

		this.root = root;

		textField = new JTextField();
		textField.setColumns(column);
		add(textField);

		final JButton button = new JButton();
		button.setText("...");
		button.setMargin(new Insets(0, 4, 0, 4));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dimension preferredSize = textField.getPreferredSize();
				Point locationOnScreen = textField.getLocationOnScreen();
				int x = (int) locationOnScreen.getX();
				int y = (int) (locationOnScreen.getY() + preferredSize
						.getHeight());
				int width = (int) preferredSize.getWidth();
				int height = (int) (width * percentOfHeightInWidth);
				JRootPane rootPane = textField.getRootPane();
				Point rootPaneLocationOnScreen = rootPane.getLocationOnScreen();
				if (height > rootPaneLocationOnScreen.getY()
						+ rootPane.getHeight() - y) {
					y = (int) (locationOnScreen.getY() - height);
				}
				ListDialog listDialog = new ListDialog();
				listDialog.setBounds(x, y, width, height);
				listDialog.setVisible(true);
			}
		});
		add(button);
		//
	}

	private class ListDialog extends JDialog {

		private JTree tree;

		public ListDialog() {
			super();
			setModal(true);
			setUndecorated(true);

			final JScrollPane scrollPane = new JScrollPane();
			getContentPane().add(scrollPane, BorderLayout.CENTER);

			tree = new JTree(root);
			DefaultTreeCellRenderer treeCellRenderer = new DefaultTreeCellRenderer();
			treeCellRenderer.setClosedIcon(null);
			treeCellRenderer.setOpenIcon(null);
			treeCellRenderer.setLeafIcon(null);
			tree.setCellRenderer(treeCellRenderer);
			tree.addTreeSelectionListener(new TreeSelectionListener() {
				public void valueChanged(TreeSelectionEvent e) {
					textField.setText(tree.getLastSelectedPathComponent()
							.toString());
					dispose();
				}
			});
			scrollPane.setViewportView(tree);
			//
		}

	}

}
