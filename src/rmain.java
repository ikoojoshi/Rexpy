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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class rmain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rmain frame = new rmain();
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
	public rmain() {
		//globals global = new globals();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 549);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.inactiveCaption);
		menuBar.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("About REXPY");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new about().setVisible(true);
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
		label.setBounds(377, 13, 131, 126);
		contentPane.add(label);
		
		JLabel lbl2 = new JLabel("Welcome to REXPY,");
		lbl2.setForeground(Color.WHITE);
		lbl2.setFont(new Font("Segoe UI Semilight", Font.BOLD, 26));
		lbl2.setBounds(27, 46, 254, 66);
		contentPane.add(lbl2);
		
		JLabel lbl1 = new JLabel("");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setForeground(Color.WHITE);
		lbl1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 26));
		lbl1.setBounds(27, 105, 254, 66);
		contentPane.add(lbl1);
		lbl1.setText(""+globals.ufname+" "+globals.ulname);
		
		
		
		JButton btnRegisterAComplaint = new JButton("REGISTER A COMPLAINT");
		btnRegisterAComplaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new rcomplaint().setVisible(true);
			    dispose();
			}
		});
		btnRegisterAComplaint.setForeground(Color.WHITE);
		btnRegisterAComplaint.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		btnRegisterAComplaint.setBackground(Color.BLACK);
		btnRegisterAComplaint.setBounds(81, 193, 346, 43);
		contentPane.add(btnRegisterAComplaint);
		
		JButton btnViewRecords = new JButton("VIEW RECORDS");
		btnViewRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new rrec().setVisible(true);
			    dispose();
			}
		});
		btnViewRecords.setForeground(Color.WHITE);
		btnViewRecords.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		btnViewRecords.setBackground(Color.BLACK);
		btnViewRecords.setBounds(81, 249, 346, 43);
		contentPane.add(btnViewRecords);
		
		JButton btnViewComplaints = new JButton("VIEW COMPLAINTS");
		btnViewComplaints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new rcom().setVisible(true);
			    dispose();				
			}
		});
		btnViewComplaints.setForeground(Color.WHITE);
		btnViewComplaints.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		btnViewComplaints.setBackground(Color.BLACK);
		btnViewComplaints.setBounds(81, 305, 346, 43);
		contentPane.add(btnViewComplaints);
		
		JButton btnStations = new JButton("VIEW STAFF");
		btnStations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new rstaff().setVisible(true);
			    dispose();			
			}
		});
		btnStations.setForeground(Color.WHITE);
		btnStations.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		btnStations.setBackground(Color.BLACK);
		btnStations.setBounds(81, 384, 346, 43);
		contentPane.add(btnStations);
	}
}
