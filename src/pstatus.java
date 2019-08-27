import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import signup2.Globals;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class pstatus extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pstatus frame = new pstatus();
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
	public pstatus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Color clr1 = new Color(17, 97, 122);
		getContentPane().setBackground(clr1);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ipshita\\Desktop\\REXPY\\bg2logo.JPG"));
		label.setBounds(336, 28, 131, 126);
		contentPane.add(label);
		
		JLabel lblSignUp = new JLabel("UPDATE STATUS");
		lblSignUp.setForeground(Color.WHITE);
		lblSignUp.setFont(new Font("Linux Biolinum G", Font.PLAIN, 31));
		lblSignUp.setBounds(22, 28, 251, 66);
		contentPane.add(lblSignUp);
		
		JLabel lblFirstName = new JLabel("Complaint Number :");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblFirstName.setBounds(12, 109, 186, 45);
		contentPane.add(lblFirstName);
		
		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setBounds(12, 167, 195, 30);
		contentPane.add(tf1);
		
		JLabel lblLastName = new JLabel("Status :");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblLastName.setBounds(52, 438, 83, 45);
		contentPane.add(lblLastName);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(142, 449, 334, 30);
		contentPane.add(tf2);
	
		
		JLabel lbl = new JLabel("REXPY");
		lbl.setForeground(Color.WHITE);
		lbl.setFont(new Font("Linux Biolinum G", Font.BOLD, 37));
		lbl.setBounds(346, 151, 139, 66);
		contentPane.add(lbl);
		
		JButton btnSignUp = new JButton("VIEW STATUS");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int cid1=Integer.parseInt(tf1.getText());
				   DefaultTableModel dm = (DefaultTableModel) table.getModel();
				   dm.getDataVector().removeAllElements();
				        try {
				Class.forName("java.sql.Driver");
				 Connection c=DriverManager.getConnection("jdbc:mysql://localhost/rexpy","root","rabbit99");
				Statement stmt=c.createStatement();
				String q="select  status.remarks from complaints, status where status.cid=complaints.cid and status.cid="+cid1+";";//=507440503;";
				 ResultSet rs=stmt.executeQuery(q);
				 int count=0;
				while(rs.next()) {
					if(count==0) {
						count++;
						//lbl1.setText("Complaint handled by staff ID "+rs.getString(2));
						
					}
				        dm.addRow( new Object[] {rs.getString(1)});
				}
				rs.close();
				stmt.close();
				c.close();
				        }

				  catch(Exception o)
				  {
				      JOptionPane.showMessageDialog(null,o.getMessage());
				  }
				        
				/*
				try {
				    globals.cid =Integer.parseInt(l1.getText());
				    globals.type =l2.getText();
				    globals.remark=l3.getText();
				   
				  
				    	Class.forName("java.sql.Driver");
				    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rexpy","root","rabbit99");
				    	String query="INSERT INTO complaints VALUES("+globals.cid+","+globals.userid+",' "+globals.type+"', current_date(), current_time(), '"+globals.remark+"', NULL);";
				    	Statement stmt=conn.createStatement();
				stmt.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Complaint Registered.");
				dispose();
				new rmain().setVisible(true); 
				stmt.close();
				conn.close();
				    }
				  catch(Exception el)
				  {
				      JOptionPane.showMessageDialog(null,el.getMessage());
				  }
				*/
			}
			
			
		});
		
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		btnSignUp.setBackground(Color.BLACK);
		btnSignUp.setBounds(145, 230, 238, 43);
		contentPane.add(btnSignUp);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(81, 442, 56, 16);
		contentPane.add(label_1);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new pmain().setVisible(true);
			    dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		button.setBackground(Color.BLACK);
		button.setBounds(213, 549, 139, 33);
		contentPane.add(button);
		
		JButton btnUpdateStatus = new JButton("UPDATE STATUS");
		btnUpdateStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				    globals.cid =Integer.parseInt(tf1.getText());
				    globals.sremark=tf2.getText();
				   
				    	Class.forName("java.sql.Driver");
				    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rexpy","root","rabbit99");
				    	String query="INSERT INTO status VALUES("+globals.pid+","+globals.cid+",' "+globals.sremark+"');";
				    	Statement stmt=conn.createStatement();
				stmt.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Status Registered.");
				stmt.close();
				conn.close();
				    }
				  catch(Exception el)
				  {
				      JOptionPane.showMessageDialog(null,el.getMessage());
				  }
				
				
			}
		});
		btnUpdateStatus.setForeground(Color.WHITE);
		btnUpdateStatus.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		btnUpdateStatus.setBackground(Color.BLACK);
		btnUpdateStatus.setBounds(160, 492, 223, 43);
		contentPane.add(btnUpdateStatus);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setFillsViewportHeight(true);
		table.setBounds(12, 286, 508, 129);
		contentPane.add(table);
		


		
	}
}
