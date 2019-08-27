import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class index extends JFrame {

	private JPanel contentPane;
	private JTextField tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index frame = new index();
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
	public index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{125, 116, 0};
		gbl_contentPane.rowHeights = new int[]{35, 22, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		tf = new JTextField();
		GridBagConstraints gbc_tf = new GridBagConstraints();
		gbc_tf.insets = new Insets(0, 0, 5, 0);
		gbc_tf.anchor = GridBagConstraints.WEST;
		gbc_tf.gridx = 1;
		gbc_tf.gridy = 1;
		contentPane.add(tf, gbc_tf);
		tf.setColumns(10);
		
		JButton btnTester = new JButton("TESTER");
		GridBagConstraints gbc_btnTester = new GridBagConstraints();
		gbc_btnTester.insets = new Insets(0, 0, 5, 0);
		gbc_btnTester.gridx = 1;
		gbc_btnTester.gridy = 3;
		contentPane.add(btnTester, gbc_btnTester);
		
		JLabel jLbl = new JLabel("New label");
		GridBagConstraints gbc_jLbl = new GridBagConstraints();
		gbc_jLbl.gridheight = 2;
		gbc_jLbl.gridx = 1;
		gbc_jLbl.gridy = 5;
		contentPane.add(jLbl, gbc_jLbl);
		
		btnTester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("java.sql.Driver");
					 Connection c=DriverManager.getConnection("jdbc:mysql://localhost/rexpy","root","rabbit99");
					Statement stmt=c.createStatement();
					String a=tf.getText();
					String q="select city from cities where ccode='"+a+"';";
					String b="";
					 ResultSet rs=stmt.executeQuery(q);
					 if (rs.next()){
					     b=rs.getString(1);
					 }
					 else
					 {jLbl.setText("Login Failed. Try Again."); }
					 //jLbl.setText(b);
					rs.close();
					stmt.close();
					c.close();
					       } 
					  catch(Exception ets)
					  {   
					      jLbl.setText("Error");
					  }
			}
		});

	}

}
