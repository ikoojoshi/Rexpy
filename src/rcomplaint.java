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

public class rcomplaint extends JFrame {

	private JPanel contentPane;
	private JTextField l2;
	private JTextField l3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rcomplaint frame = new rcomplaint();
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
	public rcomplaint() {
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
		
		JLabel lblSignUp = new JLabel("REGISTER YOUR COMPLAINT HERE");
		lblSignUp.setForeground(Color.WHITE);
		lblSignUp.setFont(new Font("Linux Biolinum G", Font.BOLD, 23));
		lblSignUp.setBounds(70, 218, 407, 66);
		contentPane.add(lblSignUp);
		
		JLabel lblLastName = new JLabel("Type of Complaint :");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblLastName.setBounds(52, 326, 197, 45);
		contentPane.add(lblLastName);
		
		JLabel lblUserId = new JLabel("Information :");
		lblUserId.setForeground(Color.WHITE);
		lblUserId.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblUserId.setBounds(62, 384, 139, 45);
		contentPane.add(lblUserId);
		
		l2 = new JTextField();
		l2.setColumns(10);
		l2.setBounds(261, 337, 195, 30);
		contentPane.add(l2);
		
		l3 = new JTextField();
		l3.setColumns(10);
		l3.setBounds(213, 395, 250, 30);
		contentPane.add(l3);
	
		
		JLabel lbl = new JLabel("REXPY");
		lbl.setForeground(Color.WHITE);
		lbl.setFont(new Font("Linux Biolinum G", Font.BOLD, 37));
		lbl.setBounds(213, 167, 139, 66);
		contentPane.add(lbl);
		
		JButton btnSignUp = new JButton("DONE");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
				    //globals.cid =Integer.parseInt(l1.getText());
				    globals.type =l2.getText();
				    globals.remark=l3.getText();
				    int comp=0;
				   
				    	Class.forName("java.sql.Driver");
				    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rexpy","root","rabbit99");
				    	
				    	String quer="select comp, rec from c;";
				    	Statement stmt1=conn.createStatement();
				    	ResultSet rs1=stmt1.executeQuery(quer);
						if (rs1.next())
						 {
						comp=rs1.getInt(1)+1;
						 }
				    	String query="INSERT INTO complaints VALUES("+comp+",'"+globals.userid+"',' "+globals.type+"', current_date(), current_time(), '"+globals.remark+"', NULL);";
				    	//String query="INSERT INTO complaints VALUES(4,'"+globals.userid+"','"+globals.type+"', current_date(), current_time(), '"+globals.remark+"', NULL);";
						Statement stmt=conn.createStatement();
						stmt.executeUpdate(query);
				
				String q="update c set comp="+comp+";";
		    	Statement stmt2=conn.createStatement();
		    	stmt2.executeUpdate(q);
		    	
				JOptionPane.showMessageDialog(null,"Complaint Registered.");
				dispose();
				new rmain().setVisible(true);
				stmt1.close();
				stmt2.close();
				rs1.close();
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
		btnSignUp.setBounds(161, 474, 238, 43);
		contentPane.add(btnSignUp);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(81, 442, 56, 16);
		contentPane.add(label_1);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new rmain().setVisible(true);
			    dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		button.setBackground(Color.BLACK);
		button.setBounds(205, 530, 139, 33);
		contentPane.add(button);
		


		
	}
}
