import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class reglogin extends JFrame  {
	
	private JPanel contentPane;
	private JTextField usernameTF;
	private JTextField pwdTF;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reglogin frame = new reglogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		class rand{
			void main() {
				;
			}
		}
		
		
	}

	/**
	 * Create the frame.
	 */
	public  reglogin() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Color clr1 = new Color(17, 97, 122);
		getContentPane().setBackground(clr1);
		
		JLabel lblLogin = new JLabel("LOG IN TO REXPY");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Linux Biolinum G", Font.BOLD, 37));
		lblLogin.setBounds(177, 68, 323, 66);
		contentPane.add(lblLogin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ipshita\\Desktop\\REXPY\\bg4logo.JPG"));
		label.setBounds(22, 32, 131, 126);
		contentPane.add(label);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblUsername.setBounds(89, 188, 139, 66);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblPassword.setBounds(89, 257, 139, 66);
		contentPane.add(lblPassword);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(229, 205, 124, 40);
		contentPane.add(usernameTF);
		usernameTF.setColumns(10);
		
		
		pwdTF = new JTextField();
		pwdTF.setColumns(10);
		pwdTF.setBounds(229, 274, 124, 40);
		//((JPasswordField) pwdTF).setEchoChar('*');
		contentPane.add(pwdTF);
		
		
		JCheckBox cb1 = new JCheckBox("  Staff");
		cb1.setFont(new Font("Segoe UI Light", Font.PLAIN, 17));
		cb1.setHorizontalAlignment(SwingConstants.CENTER);
		cb1.setBounds(341, 379, 86, 25);
		contentPane.add(cb1);
		
		
		JButton btnLogIn = new JButton("LOG IN ");
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(cb1.isSelected()) {
					
					try {
						int m=1;
						int done=0;
						Class.forName("java.sql.Driver");
						 Connection c=DriverManager.getConnection("jdbc:mysql://localhost/rexpy","root","rabbit99");
						Statement stmt=c.createStatement();
						globals.pid=Integer.parseInt(usernameTF.getText());
						globals.ppassword=pwdTF.getText();
						String q="select * from pstaff where pid='"+globals.pid+"'and password='"+globals.ppassword+"';";
						 ResultSet rs=stmt.executeQuery(q);
						 if (rs.next()){
						 globals.pfname=rs.getString(2);
						 globals.plname=rs.getString(3);
						 globals.pstationid=rs.getString(4);
						 globals.pposition=rs.getString(5);
						 globals.paddress=rs.getString(6);
						 globals.pdob=rs.getString(8);
						 m=0;
						 globals.a=1;
						 done=1;}
						 else if(m==5) {
							 JOptionPane.showMessageDialog(null,"You've crossed the maximum number of attempts possible. Try again later.");
						 }
						 else if(done==0){
							 m++;
							 JOptionPane.showMessageDialog(null,"Login Failed. Try Again.");
						 }
						rs.close();
						stmt.close();
						c.close();
						new pmain().setVisible(true); 
						dispose();
						 
						       } 
						  catch(Exception et)
						  {   
						      JOptionPane.showMessageDialog(null,"Connection Failed.");
						  }
					
					
				} 
				
				else {
				try {
					int n=1;
					int done=0;
					Class.forName("java.sql.Driver");
					 Connection c=DriverManager.getConnection("jdbc:mysql://localhost/rexpy","root","rabbit99");
					Statement stmt=c.createStatement();
					globals.uid=usernameTF.getText();
					globals.upassword=pwdTF.getText();
					String q="select * from user where uid='"+globals.uid+"'and password='"+globals.upassword+"';";
					 ResultSet rs=stmt.executeQuery(q);
					 if (rs.next())
					 {
						 
						 
					 globals.userid=rs.getLong(1);
					 globals.aadhar=rs.getLong(2);
					 globals.ufname=rs.getString(3);
					 usernameTF.setText(globals.ufname);
					 globals.ulname=rs.getString(4);
					 globals.age=rs.getInt(5);
					 globals.gender=rs.getString(6);
					 globals.ucontact=rs.getLong(7);
					 globals.uemail=rs.getString(9);
					 globals.udob=rs.getString(10);
					 n=0;
					 
					 new rmain().setVisible(true); 
					 done=1;
					 globals.a=0;}
					 else if(n==5) {
						 JOptionPane.showMessageDialog(null,"You've crossed the maximum number of attempts possible. Try again later.");
					 }
					 else if(done==0){
						 n++;
						 JOptionPane.showMessageDialog(null,"Login Failed. Try Again.");
					 }
					 
					 
					rs.close();
					stmt.close();
					c.close();
					       } 
					  catch(Exception et)
					  {   
					      JOptionPane.showMessageDialog(null,"Connection Failed.");
					  }
				
				dispose();
				}
				// new rmain().setVisible(true); 
				 
				
				//rand(uf1, uf1);
			}
			
		});
		/*btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				globals.check1=1;
				if(cb1.isSelected()) {
					
					try {
						int m=1;
						int done=0;
						Class.forName("java.sql.Driver");
						 Connection c=DriverManager.getConnection("jdbc:mysql://localhost/rexpy","root","rabbit99");
						Statement stmt=c.createStatement();
						globals.pid=Integer.parseInt(usernameTF.getText());
						globals.ppassword=pwdTF.getText();
						String q="select * from pstaff where pid='"+globals.pid+"'and password='"+globals.ppassword+"';";
						 ResultSet rs=stmt.executeQuery(q);
						 if (rs.next())
						 {
							 dispose();
						 new rmain().setVisible(true); 
							 
						 globals.pfname=rs.getString(2);
						 globals.plname=rs.getString(3);
						 globals.pstationid=rs.getString(4);
						 globals.pposition=rs.getString(5);
						 globals.paddress=rs.getString(6);
						 globals.pdob=rs.getString(8);
						 m=0;
						 globals.a=1;
						 done=1;}
						 else if(m==5) {
							 JOptionPane.showMessageDialog(null,"You've crossed the maximum number of attempts possible. Try again later.");
						 }
						 else if(done==0){
							 m++;
							 JOptionPane.showMessageDialog(null,"Login Failed. Try Again.");
						 }
						 

						rs.close();
						stmt.close();
						c.close();
						       } 
						  catch(Exception et)
						  {   
						      JOptionPane.showMessageDialog(null,"Connection Failed.");
						  }
				
				}
				else {
					
					try {
						int n=1;
						int done=0;
						Class.forName("java.sql.Driver");
						 Connection c=DriverManager.getConnection("jdbc:mysql://localhost/rexpy","root","rabbit99");
						Statement stmt=c.createStatement();
						globals.uid=usernameTF.getText();
						globals.upassword=pwdTF.getText();
						String q="select * from user where uid='"+globals.uid+"'and password='"+globals.upassword+"';";
						 ResultSet rs=stmt.executeQuery(q);
						 usernameTF.setText("LOL");
						 if (rs.next())
						 {
							 //dispose();
						 new rmain().setVisible(true); 
							 
						 glob.userid=rs.getLong(1);
						 globals.aadhar=rs.getLong(2);
						 glob.ufname=rs.getString(3);
						 usernameTF.setText(glob.ufname);
						 glob.ulname=rs.getString(4);
						 globals.age=rs.getInt(5);
						 globals.gender=rs.getString(6);
						 globals.ucontact=rs.getLong(7);
						 globals.uemail=rs.getString(9);
						 globals.udob=rs.getString(10);
						 n=0;
						 pwdTF.setText(glob.ufname);
						 done=1;
						 globals.a=0;
						 uf1=rs.getString(3);
						 ul1=rs.getString(4);
						System.out.print("lol");
						System.out.println(""+globals.udob);}
						 else if(n==5) {
							 JOptionPane.showMessageDialog(null,"You've crossed the maximum number of attempts possible. Try again later.");
						 }
						 else if(done==0){
							 n++;
							 JOptionPane.showMessageDialog(null,"Login Failed. Try Again.");
						 }
						 

						rs.close();
						stmt.close();
						c.close();
						       } 
						  catch(Exception et)
						  {   
						      JOptionPane.showMessageDialog(null,"Connection Failed.");
						  }
					
				}
				
			
				
				System.out.println("idekk  "+glob.ufname);
				System.out.println("onetwo  "+globals.ucontact);
			}
			
			
		});
		*/
		
		
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		btnLogIn.setBackground(Color.BLACK);
		btnLogIn.setBounds(109, 367, 165, 43);
		contentPane.add(btnLogIn);
		
		JLabel lblNewLabel = new JLabel("_Click here to create a new account_\r\n");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new regsignup().setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 19));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(18, 461, 515, 33);
		contentPane.add(lblNewLabel);
		
		
	}
	
	
//}

 /*void rand(String a, String b) {
	globals.ufname=a;
	globals.ulname=b;
	System.out.print("FINAL "+a+"    "+ b);
	dispose();
	 new rmain().setVisible(true); 
}*/
}

