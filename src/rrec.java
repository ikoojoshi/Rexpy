import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class rrec extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rrec frame = new rrec();
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
	public rrec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 586);
		
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
		label.setBounds(198, 13, 131, 126);
		contentPane.add(label);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"R. No.", "R. Name", "Staff ID", "Date", "Details", "Fine"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(51);
		table.getColumnModel().getColumn(1).setPreferredWidth(91);
		table.getColumnModel().getColumn(2).setPreferredWidth(49);
		table.getColumnModel().getColumn(3).setPreferredWidth(160);
		table.getColumnModel().getColumn(4).setPreferredWidth(172);
		table.getColumnModel().getColumn(5).setPreferredWidth(64);
		
		
		table.setBounds(12, 280, 508, 80);
		contentPane.add(table);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new rmain().setVisible(true); 
				dispose();

			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		button.setBackground(Color.BLACK);
		button.setBounds(198, 464, 139, 33);
		contentPane.add(button);
		
		JLabel lbl = new JLabel("REXPY RECORDS");
		lbl.setForeground(Color.WHITE);
		lbl.setFont(new Font("Linux Biolinum G", Font.BOLD, 37));
		lbl.setBounds(116, 148, 303, 66);
		contentPane.add(lbl);
		
		JLabel lblRNo = new JLabel("R. No.");
		lblRNo.setForeground(Color.WHITE);
		lblRNo.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblRNo.setBounds(12, 248, 43, 33);
		contentPane.add(lblRNo);
		
		JLabel lblRName = new JLabel("R. Name");
		lblRName.setForeground(Color.WHITE);
		lblRName.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblRName.setBounds(58, 248, 69, 33);
		contentPane.add(lblRName);
		
		JLabel lblStaff = new JLabel("StaffID");
		lblStaff.setForeground(Color.WHITE);
		lblStaff.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblStaff.setBounds(135, 248, 57, 33);
		contentPane.add(lblStaff);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblDate.setBounds(220, 248, 69, 33);
		contentPane.add(lblDate);
		
		JLabel lblDetails = new JLabel("Details");
		lblDetails.setForeground(Color.WHITE);
		lblDetails.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblDetails.setBounds(350, 248, 69, 33);
		contentPane.add(lblDetails);
		
		JLabel lblFine = new JLabel("Fine");
		lblFine.setForeground(Color.WHITE);
		lblFine.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblFine.setBounds(465, 248, 43, 33);
		contentPane.add(lblFine);
		
		JButton finalbtn = new JButton("VIEW ");
		finalbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel dm = (DefaultTableModel) table.getModel();
				   dm.getDataVector().removeAllElements();
				        try {
				Class.forName("java.sql.Driver");
				 Connection c=DriverManager.getConnection("jdbc:mysql://localhost/rexpy","root","rabbit99");
				Statement stmt=c.createStatement();
				String q="select rno, rname, pid, time, info, fine from records where aadhar="+globals.aadhar+";";
				 ResultSet rs=stmt.executeQuery(q);
				 lbl.setText("Okay");
				while(rs.next()) {
				        dm.addRow( new Object[] {rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
				    }
				 
				rs.close();
				stmt.close();
				c.close();
				        }

				  catch(Exception e)
				  {
				      JOptionPane.showMessageDialog(null,e.getMessage());
				  }  
				
				
			}
		});
		finalbtn.setForeground(Color.WHITE);
		finalbtn.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		finalbtn.setBackground(Color.BLACK);
		finalbtn.setBounds(177, 408, 180, 43);
		contentPane.add(finalbtn);
		
		
	}
}
