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

public class rstaff extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rstaff frame = new rstaff();
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
	public rstaff() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 784);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Color clr1 = new Color(17, 97, 122);
		getContentPane().setBackground(clr1);
		contentPane.setLayout(null);
		
		JLabel l31 = new JLabel("");
		l31.setBackground(Color.LIGHT_GRAY);
		l31.setForeground(Color.BLACK);
		l31.setFont(new Font("Segoe UI Light", Font.PLAIN, 22));
		l31.setBounds(197, 474, 219, 45);
		contentPane.add(l31);
		
		JLabel l1 = new JLabel("");
		l1.setBackground(Color.LIGHT_GRAY);
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Segoe UI Light", Font.BOLD, 28));
		l1.setBounds(197, 416, 219, 45);
		contentPane.add(l1);
		
		JLabel l3 = new JLabel("");
		l3.setBackground(Color.LIGHT_GRAY);
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Segoe UI Light", Font.PLAIN, 28));
		l3.setBounds(197, 532, 219, 45);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("");
		l4.setBackground(Color.LIGHT_GRAY);
		l4.setForeground(Color.BLACK);
		l4.setFont(new Font("Segoe UI Light", Font.PLAIN, 28));
		l4.setBounds(197, 588, 219, 45);
		contentPane.add(l4);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ipshita\\Desktop\\REXPY\\bg2logo.JPG"));
		label.setBounds(187, 23, 131, 126);
		contentPane.add(label);
		
		JLabel lblSignUp = new JLabel("STAFF DETAILS ");
		lblSignUp.setForeground(Color.WHITE);
		lblSignUp.setFont(new Font("Linux Biolinum G", Font.PLAIN, 39));
		lblSignUp.setBounds(132, 215, 300, 66);
		contentPane.add(lblSignUp);
		
		JLabel lblFirstName = new JLabel("Enter staff ID :");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblFirstName.setBounds(88, 300, 139, 45);
		contentPane.add(lblFirstName);
		
		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setBounds(281, 311, 124, 30);
		contentPane.add(tf1);
		
		JLabel lblLastName = new JLabel("Name:");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblLastName.setBounds(88, 414, 139, 45);
		contentPane.add(lblLastName);
		
		JLabel lblPassword = new JLabel("Station:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblPassword.setBounds(88, 472, 124, 45);
		contentPane.add(lblPassword);
	
		
		JLabel lblRexpy = new JLabel("REXPY");
		lblRexpy.setForeground(Color.WHITE);
		lblRexpy.setFont(new Font("Linux Biolinum G", Font.BOLD, 37));
		lblRexpy.setBounds(197, 151, 139, 66);
		contentPane.add(lblRexpy);
		
		JLabel lblAge = new JLabel("Contact:");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblAge.setBounds(88, 588, 95, 45);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Position:");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblGender.setBounds(86, 530, 86, 45);
		contentPane.add(lblGender);
		
		JButton btnSignUp = new JButton("VIEW");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				    globals.pid =Integer.parseInt(tf1.getText());
				    
				    	Class.forName("java.sql.Driver");
				    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rexpy","root","rabbit99");
				    	Statement stmt=conn.createStatement();
				    	String q="select fname, lname, stationid, position, contact from pstaff where pid='"+globals.pid+"';";
						 ResultSet rs=stmt.executeQuery(q);
						 if (rs.next()) {
						 l1.setText(rs.getString(1)+" "+rs.getString(2));
						 l3.setText(rs.getString(4));
						 l4.setText(rs.getString(5));
						 
						 globals.pstationid=rs.getString(3);
						 		Statement stmt1=conn.createStatement();
						 		String q1="select name from pstation where stationid='"+globals.pstationid+"';";
						 		ResultSet rs1=stmt.executeQuery(q1);
						 		
						 		if(rs1.next()) {
						 			l31.setText(rs1.getString(1));
						 		}
						 		rs1.close();
								stmt1.close();
						 }
				rs.close();
				stmt.close();
				conn.close();
				    }
				  catch(Exception el)
				  {
				      JOptionPane.showMessageDialog(null,el.getMessage());
				  }
				
			}			
		});
		
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		btnSignUp.setBackground(Color.BLACK);
		btnSignUp.setBounds(188, 646, 170, 43);
		contentPane.add(btnSignUp);
		
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
		button.setBounds(208, 691, 139, 33);
		contentPane.add(button);
	}

}
