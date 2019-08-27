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
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class regsignup extends JFrame {

	private JPanel contentPane;
	private JTextField fn;
	private JTextField ln;
	private JTextField uid;
	private JTextField email;
	private JTextField dt;
	private JTextField uno;
	private JTextField contact;
	private JTextField pwd;
	private JTextField cpwd;
	private JTextField age;
	private JTextField gender;
	private JTextField aadhar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regsignup frame = new regsignup();
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
	public regsignup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 784);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Color clr1 = new Color(17, 97, 122);
		getContentPane().setBackground(clr1);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ipshita\\Desktop\\REXPY\\bg2logo.JPG"));
		label.setBounds(12, 26, 131, 126);
		contentPane.add(label);
		
		JLabel lblSignUp = new JLabel("SIGN UP");
		lblSignUp.setForeground(Color.WHITE);
		lblSignUp.setFont(new Font("Linux Biolinum G", Font.BOLD, 37));
		lblSignUp.setBounds(240, 86, 177, 66);
		contentPane.add(lblSignUp);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblFirstName.setBounds(62, 177, 139, 45);
		contentPane.add(lblFirstName);
		
		fn = new JTextField();
		fn.setColumns(10);
		fn.setBounds(213, 188, 219, 30);
		contentPane.add(fn);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblLastName.setBounds(62, 218, 139, 45);
		contentPane.add(lblLastName);
		
		JLabel lblUserId = new JLabel("User ID : ");
		lblUserId.setForeground(Color.WHITE);
		lblUserId.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblUserId.setBounds(62, 262, 139, 45);
		contentPane.add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblPassword.setBounds(62, 307, 139, 45);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPwd = new JLabel("Confirm Pwd :");
		lblConfirmPwd.setForeground(Color.WHITE);
		lblConfirmPwd.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblConfirmPwd.setBounds(62, 354, 139, 45);
		contentPane.add(lblConfirmPwd);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblEmail.setBounds(62, 396, 139, 45);
		contentPane.add(lblEmail);
		
		ln = new JTextField();
		ln.setColumns(10);
		ln.setBounds(213, 233, 219, 30);
		contentPane.add(ln);
		
		uid = new JTextField();
		uid.setColumns(10);
		uid.setBounds(213, 277, 219, 30);
		contentPane.add(uid);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(213, 407, 219, 30);
		contentPane.add(email);
		
		JLabel lblDate = new JLabel("Date (YYYY-MM-DD) :");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblDate.setBounds(62, 524, 210, 45);
		contentPane.add(lblDate);
		
		dt = new JTextField();
		dt.setColumns(10);
		dt.setBounds(282, 539, 150, 30);
		contentPane.add(dt);
		
		JLabel lblUserNumber = new JLabel("User Number : ");
		lblUserNumber.setForeground(Color.WHITE);
		lblUserNumber.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblUserNumber.setBounds(62, 566, 159, 45);
		contentPane.add(lblUserNumber);
		
		uno = new JTextField();
		uno.setColumns(10);
		uno.setBounds(282, 581, 150, 30);
		contentPane.add(uno);
	
		
		JLabel lblRexpy = new JLabel("REXPY");
		lblRexpy.setForeground(Color.WHITE);
		lblRexpy.setFont(new Font("Linux Biolinum G", Font.BOLD, 37));
		lblRexpy.setBounds(249, 26, 139, 66);
		contentPane.add(lblRexpy);
		pwd = new JTextField();
		pwd.setColumns(10);
		pwd.setBounds(213, 322, 219, 30);
		contentPane.add(pwd);
		
		cpwd = new JTextField();
		cpwd.setColumns(10);
		cpwd.setBounds(213, 364, 219, 30);
		contentPane.add(cpwd);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(161, 633, 50, 30);
		contentPane.add(age);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblAge.setBounds(62, 622, 66, 45);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblGender.setBounds(266, 622, 86, 45);
		contentPane.add(lblGender);
		
		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(380, 633, 50, 30);
		contentPane.add(gender);
		
		aadhar = new JTextField();
		aadhar.setColumns(10);
		aadhar.setBounds(213, 493, 219, 30);
		contentPane.add(aadhar);
		
		JLabel label_1 = new JLabel("Aadhar :");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		label_1.setBounds(62, 482, 139, 45);
		contentPane.add(label_1);

		
		JLabel lblAadhar = new JLabel("Contact :");
		lblAadhar.setForeground(Color.WHITE);
		lblAadhar.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblAadhar.setBounds(62, 441, 139, 45);
		contentPane.add(lblAadhar);
		
		contact = new JTextField();
		contact.setColumns(10);
		contact.setBounds(213, 450, 219, 30);
		contentPane.add(contact);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
				    globals.ufname =fn.getText();
				    globals.ulname =ln.getText();
				    globals.aadhar=Long.parseLong(aadhar.getText());
				    globals.ucontact=Long.parseLong(contact.getText());
				    globals.uid=uid.getText();
				    globals.age=Integer.parseInt(age.getText());
				    globals.gender=gender.getText();
				    globals.upassword=pwd.getText();
				    globals.userid=Long.parseLong(uno.getText());
				    globals.uemail=email.getText();
				    globals.udob =dt.getText();
				    
				   String confirmpwd=cpwd.getText();
				    if (confirmpwd.equals(globals.upassword)){ 
				    	Class.forName("java.sql.Driver");
				    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rexpy","root","rabbit99");
				    	String query="INSERT INTO user VALUES('"+globals.userid+"','"+globals.aadhar+"','"+globals.ufname+"','"+globals.ulname+"'," + globals.age + " ,'" +globals.gender+"', " +globals.ucontact +",'"+ globals.upassword + "', '"+globals.uemail+"', '"+ globals.udob+"', '"+globals.uid+ " ');";
				    	Statement stmt=conn.createStatement();
				stmt.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Account Created");
				dispose();
				new rmain().setVisible(true); 

				stmt.close();
				conn.close();
				    }
				    else {
				    	JOptionPane.showMessageDialog(null,"Passwords don't match.");
				    }
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
		btnSignUp.setBounds(211, 681, 221, 43);
		contentPane.add(btnSignUp);
		


		
	}

}
