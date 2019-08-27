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
import javax.swing.JTextField;

public class rstatus extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tf1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rstatus frame = new rstatus();
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
	public rstatus() {
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
		
		JLabel lbl1 = new JLabel("");
		lbl1.setForeground(Color.WHITE);
		lbl1.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		lbl1.setBounds(22, 361, 488, 45);
		contentPane.add(lbl1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ipshita\\Desktop\\REXPY\\bg2logo.JPG"));
		label.setBounds(61, 13, 131, 126);
		contentPane.add(label);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"R. No."
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(380);
		
		
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
				int cid1=Integer.parseInt(tf1.getText());
				   DefaultTableModel dm = (DefaultTableModel) table.getModel();
				   dm.getDataVector().removeAllElements();
				        try {
				Class.forName("java.sql.Driver");
				 Connection c=DriverManager.getConnection("jdbc:mysql://localhost/rexpy","root","rabbit99");
				Statement stmt=c.createStatement();
				String q="select  status.remarks, status.pid from complaints, status where status.cid=complaints.cid and status.cid="+cid1+";";//=507440503;";
				 ResultSet rs=stmt.executeQuery(q);
				 int count=0;
				while(rs.next()) {
					if(count==0) {
						count++;
						lbl1.setText("Complaint handled by staff ID "+rs.getString(2));
						
					}
				        dm.addRow( new Object[] {rs.getString(1)});
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
		btnView.setBounds(172, 408, 180, 43);
		contentPane.add(btnView);
		
		JLabel lblRexpyRecords = new JLabel("REXPY");
		lblRexpyRecords.setForeground(Color.WHITE);
		lblRexpyRecords.setFont(new Font("Linux Biolinum G", Font.BOLD, 37));
		lblRexpyRecords.setBounds(259, 30, 171, 66);
		contentPane.add(lblRexpyRecords);
		
		JLabel lblDetails = new JLabel("Status");
		lblDetails.setForeground(Color.WHITE);
		lblDetails.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		lblDetails.setBounds(205, 246, 69, 33);
		contentPane.add(lblDetails);
		
		JLabel lblViewStatus = new JLabel("VIEW STATUS");
		lblViewStatus.setForeground(Color.WHITE);
		lblViewStatus.setFont(new Font("Linux Biolinum G", Font.BOLD, 30));
		lblViewStatus.setBounds(220, 90, 217, 66);
		contentPane.add(lblViewStatus);
		
		tf1 = new JTextField();
		tf1.setBounds(305, 185, 116, 37);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JLabel lblEnterComplaintId = new JLabel("Enter Complaint ID :");
		lblEnterComplaintId.setForeground(Color.WHITE);
		lblEnterComplaintId.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblEnterComplaintId.setBounds(43, 177, 217, 45);
		contentPane.add(lblEnterComplaintId);
		
		
	}
}
