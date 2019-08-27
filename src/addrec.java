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

public class addrec extends JFrame {

	private JPanel contentPane;
	private JTextField l1;
	private JTextField l2;
	private JTextField l3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addrec frame = new addrec();
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
	public addrec() {
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
		label.setBounds(213, 28, 131, 126);
		contentPane.add(label);
		
		JLabel lblSignUp = new JLabel("ADD A NEW RECORD");
		lblSignUp.setForeground(Color.WHITE);
		lblSignUp.setFont(new Font("Linux Biolinum G", Font.PLAIN, 27));
		lblSignUp.setBounds(142, 218, 293, 66);
		contentPane.add(lblSignUp);
		
		JLabel lblFirstName = new JLabel("Aadhar Number :");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblFirstName.setBounds(81, 297, 165, 45);
		contentPane.add(lblFirstName);
		
		l1 = new JTextField();
		l1.setColumns(10);
		l1.setBounds(258, 308, 195, 30);
		contentPane.add(l1);
		
		JLabel lblLastName = new JLabel("Type : ");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblLastName.setBounds(81, 355, 77, 45);
		contentPane.add(lblLastName);
		
		JLabel lblUserId = new JLabel("Information :");
		lblUserId.setForeground(Color.WHITE);
		lblUserId.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblUserId.setBounds(59, 417, 139, 45);
		contentPane.add(lblUserId);
		
		l2 = new JTextField();
		l2.setColumns(10);
		l2.setBounds(258, 366, 195, 30);
		contentPane.add(l2);
		
		l3 = new JTextField();
		l3.setColumns(10);
		l3.setBounds(203, 428, 250, 30);
		contentPane.add(l3);
	
		
		JLabel lblRexpy = new JLabel("REXPY");
		lblRexpy.setForeground(Color.WHITE);
		lblRexpy.setFont(new Font("Linux Biolinum G", Font.BOLD, 37));
		lblRexpy.setBounds(213, 167, 139, 66);
		contentPane.add(lblRexpy);
		
		JButton btnSignUp = new JButton("ADD RECORD");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
						int rec=0;
				    	Class.forName("java.sql.Driver");
				    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rexpy","root","rabbit99");
				    	String quer="select comp, rec from c;";
				    	Statement stmt1=conn.createStatement();
				    	ResultSet rs1=stmt1.executeQuery(quer);
						if (rs1.next())
						 {
						//com=rs1.getInt(1)+1;
						rec=rs1.getInt(2)+1;}
						long adh=Long.parseLong(l1.getText());
						String type=l2.getText();
						String info=l3.getText();
												
				    	String query="INSERT INTO records VALUES('"+rec+"','"+type+"', "+adh+", "+ globals.pid+ ",  sysdate(), '"+info+"', 'Not Paid');";
				    	Statement stmt=conn.createStatement();
				    	stmt.executeUpdate(query);
				    	
				    	String q="update c set rec="+rec+";";
				    	Statement stmt2=conn.createStatement();
				    	stmt2.executeUpdate(q);
				    	
				JOptionPane.showMessageDialog(null,"Record Registered.");
				
				rs1.close();
				stmt1.close();
				stmt2.close();
				stmt.close();
				conn.close();
				dispose();
				new prec().setVisible(true); 
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
		btnSignUp.setBounds(159, 494, 238, 43);
		contentPane.add(btnSignUp);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(81, 442, 56, 16);
		contentPane.add(label_1);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new prec().setVisible(true);
			    dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		button.setBackground(Color.BLACK);
		button.setBounds(213, 549, 139, 33);
		contentPane.add(button);
		


		
	}
}
