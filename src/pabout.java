import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pabout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pabout frame = new pabout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public pabout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 672);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.inactiveCaption);
		menuBar.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("About REXPY");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new pabout().setVisible(true);
			    dispose();
			}
		});
		mntmNewMenuItem.setBackground(SystemColor.inactiveCaption);
		mntmNewMenuItem.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Manage Account");
		mntmNewMenuItem_1.setBackground(SystemColor.inactiveCaption);
		mntmNewMenuItem_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Color clr1 = new Color(17, 97, 122);
		getContentPane().setBackground(clr1);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ipshita\\Desktop\\REXPY\\bg2logo.JPG"));
		label.setBounds(189, 13, 131, 126);
		contentPane.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setText("REXPY is an online portal for e-complaints which registers all kinds of complaints related to one's safety and well being in our society. ");
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
		textArea.setEditable(false);
		textArea.setBackground(SystemColor.inactiveCaption);
		textArea.setBounds(26, 233, 475, 79);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setWrapStyleWord(true);
		textArea_1.setText(" One can also complain over telephone using the helpline number + 900 99xxxxx.");
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
		textArea_1.setEditable(false);
		textArea_1.setBackground(SystemColor.inactiveCaptionBorder);
		textArea_1.setBounds(26, 339, 475, 52);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setWrapStyleWord(true);
		textArea_2.setText("Till date,\r\nREXPY has solved about 1000+ cases, \r\nhas about 2500 fines registered\r\nwith over 3000 users. ");
		textArea_2.setLineWrap(true);
		textArea_2.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
		textArea_2.setEditable(false);
		textArea_2.setBackground(SystemColor.inactiveCaption);
		textArea_2.setBounds(26, 425, 475, 100);
		contentPane.add(textArea_2);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new pmain().setVisible(true);
			    dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(189, 550, 139, 33);
		contentPane.add(btnBack);
		
		JLabel lblAboutRexpy = new JLabel("ABOUT REXPY");
		lblAboutRexpy.setForeground(Color.WHITE);
		lblAboutRexpy.setFont(new Font("Linux Biolinum G", Font.BOLD, 30));
		lblAboutRexpy.setBounds(154, 152, 232, 66);
		contentPane.add(lblAboutRexpy);
	}
}
