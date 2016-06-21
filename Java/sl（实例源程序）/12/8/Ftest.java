
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.*;
public class Ftest extends JFrame{

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JTextArea jTextArea = null;

	private JPanel controlPanel = null;

	private JButton openButton = null;

	private JButton closeButton = null;

	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
		}
		return jTextArea;
	}

	/**
	 * This method initializes controlPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getControlPanel() {
		if (controlPanel == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setVgap(1);
			controlPanel = new JPanel();
			controlPanel.setLayout(flowLayout);
			controlPanel.add(getOpenButton(), null);
			controlPanel.add(getCloseButton(), null);
		}
		return controlPanel;
	}

	/**
	 * This method initializes openButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getOpenButton() {
		if (openButton == null) {
			openButton = new JButton();
			openButton.setText("写入文本");
			openButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					File file = new File("D:/work.txt");
					try {
						FileWriter out = new FileWriter(file);
						String s = jTextArea.getText();
						out.write(s);
						out.close();
						} catch (Exception e1) {
					 	e1.printStackTrace();
					}
				}
			});
		}
		return openButton;
	}

	/**
	 * This method initializes closeButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCloseButton() {
		if (closeButton == null) {
			closeButton = new JButton();
			closeButton.setText("读取文本");
			closeButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					File file = new File("D:/work.txt");
					try {
						FileReader in = new FileReader(file);
					    char byt[] = new char[1024];
					    int len = in.read(byt);
					    jTextArea.setText(new String (byt,0,len));
					    in.close();
						} catch (Exception e1) {
					 	e1.printStackTrace();
					}
				}
			});
		}
		return closeButton;
	}
	
	public Ftest() {
		super();
		initialize();
	}

	
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJTextArea(), BorderLayout.CENTER);
			jContentPane.add(getControlPanel(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}
		public static void main(String[] args) {
		// TODO 自动生成方法存根
		
				Ftest thisClass = new Ftest();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}


	
	}
