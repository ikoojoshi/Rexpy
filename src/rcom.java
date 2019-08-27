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

public class rcom extends JFrame {
	
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rcom frame = new rcom();
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
	public rcom() {
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
		table.getColumnModel().getColumn(0).setPreferredWidth(34);
		table.getColumnModel().getColumn(1).setPreferredWidth(72);
		table.getColumnModel().getColumn(2).setPreferredWidth(88);
		table.getColumnModel().getColumn(3).setPreferredWidth(104);
		table.getColumnModel().getColumn(4).setPreferredWidth(204);
		table.getColumnModel().getColumn(5).setPreferredWidth(56);
		
		
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
		
		JButton btnView = new JButton("VIEW ");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//lolololol
				   DefaultTableModel dm = (DefaultTableModel) table.getModel();
				   dm.getDataVector().removeAllElements();
				        try {
				Class.forName("java.sql.Driver");
				 Connection c=DriverManager.getConnection("jdbc:mysql://localhost/rexpy","root","rabbit99");
				Statement stmt=c.createStatement();
				String q="select cid, type, cdate, ctime, remark, pid from complaints where userid="+globals.userid+";";//=507440503;";
				 ResultSet rs=stmt.executeQuery(q);
				 int count=1;
				while(rs.next())

				    {count++;
				        dm.addRow( new Object[] {rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
				    }
				 
				rs.close();
				stmt.close();
				c.close();
				        }

				  catch(Exception e)
				  {
				      JOptionPane.showMessageDialog(null,e.getMessage());
				  }  //lololol

				
			}
		});
		btnView.setForeground(Color.WHITE);
		btnView.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		btnView.setBackground(Color.BLACK);
		btnView.setBounds(205, 381, 124, 43);
		contentPane.add(btnView);
		
		JLabel lblRexpyRecords = new JLabel("REXPY COMPLAINTS");
		lblRexpyRecords.setForeground(Color.WHITE);
		lblRexpyRecords.setFont(new Font("Linux Biolinum G", Font.BOLD, 37));
		lblRexpyRecords.setBounds(92, 152, 398, 66);
		contentPane.add(lblRexpyRecords);
		
		JLabel lblRNo = new JLabel("C ID");
		lblRNo.setForeground(Color.WHITE);
		lblRNo.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblRNo.setBounds(12, 248, 43, 33);
		contentPane.add(lblRNo);
		
		JLabel lblRName = new JLabel("Type");
		lblRName.setForeground(Color.WHITE);
		lblRName.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblRName.setBounds(67, 248, 43, 33);
		contentPane.add(lblRName);
		
		JLabel lblStaff = new JLabel("Date");
		lblStaff.setForeground(Color.WHITE);
		lblStaff.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblStaff.setBounds(135, 248, 57, 33);
		contentPane.add(lblStaff);
		
		JLabel lblDate = new JLabel("Time");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblDate.setBounds(220, 248, 69, 33);
		contentPane.add(lblDate);
		
		JLabel lblDetails = new JLabel("Remark");
		lblDetails.setForeground(Color.WHITE);
		lblDetails.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblDetails.setBounds(350, 248, 69, 33);
		contentPane.add(lblDetails);
		
		JLabel lblFine = new JLabel("Staff ID");
		lblFine.setForeground(Color.WHITE);
		lblFine.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblFine.setBounds(451, 248, 57, 33);
		contentPane.add(lblFine);
		
		JButton btnViewStatus = new JButton("VIEW STATUS");
		btnViewStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new rstatus().setVisible(true); 
				dispose();
			}
		});
		btnViewStatus.setForeground(Color.WHITE);
		btnViewStatus.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		btnViewStatus.setBackground(Color.BLACK);
		btnViewStatus.setBounds(198, 429, 139, 33);
		contentPane.add(btnViewStatus);
	}
}
