import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class frame2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2 frame = new frame2();
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
	public frame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Color clr1 = new Color(17, 97, 122);
		getContentPane().setBackground(clr1);     
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(33, 28, 131, 126);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ipshita\\Desktop\\REXPY\\bg2logo.JPG"));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("REXPY");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(219, 50, 153, 66);
		lblNewLabel_1.setFont(new Font("Linux Biolinum G", Font.BOLD, 43));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("SIGN IN");   
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new reglogin().setVisible(true);
			    dispose();
			}
		});
		btnNewButton.setBounds(317, 434, 165, 43);
		

		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		contentPane.add(btnNewButton);
		
		JTextArea txtrRexpyIsAn = new JTextArea();
		txtrRexpyIsAn.setBackground(SystemColor.inactiveCaption);
		txtrRexpyIsAn.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
		txtrRexpyIsAn.setWrapStyleWord(true);
		txtrRexpyIsAn.setLineWrap(true);
		txtrRexpyIsAn.setEditable(false);
		txtrRexpyIsAn.setText("REXPY is an online portal for e-complaints which registers all kinds of complaints related to one's safety and well being in our society. ");
		txtrRexpyIsAn.setBounds(23, 180, 475, 79);
		contentPane.add(txtrRexpyIsAn);
		
		JTextArea txtrTillDateRexpy = new JTextArea();
		txtrTillDateRexpy.setBackground(SystemColor.inactiveCaption);
		txtrTillDateRexpy.setWrapStyleWord(true);
		txtrTillDateRexpy.setText("Till date,\r\nREXPY has solved about 1000+ cases, \r\nhas about 2500 fines registered\r\nwith over 3000 users. ");
		txtrTillDateRexpy.setLineWrap(true);
		txtrTillDateRexpy.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
		txtrTillDateRexpy.setEditable(false);
		txtrTillDateRexpy.setBounds(24, 362, 239, 135);
		contentPane.add(txtrTillDateRexpy);
		
		JTextArea txtrOneCanAlso = new JTextArea();
		txtrOneCanAlso.setWrapStyleWord(true);
		txtrOneCanAlso.setText(" One can also complain over telephone using the helpline number + 900 99xxxxx.");
		txtrOneCanAlso.setLineWrap(true);
		txtrOneCanAlso.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
		txtrOneCanAlso.setEditable(false);
		txtrOneCanAlso.setBackground(SystemColor.inactiveCaption);
		txtrOneCanAlso.setBounds(24, 277, 475, 52);
		contentPane.add(txtrOneCanAlso);
		
		JLabel lblClickHereTo = new JLabel("Click here to log in!");
		lblClickHereTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblClickHereTo.setForeground(Color.WHITE);
		lblClickHereTo.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 19));
		lblClickHereTo.setBounds(294, 388, 204, 33);
		contentPane.add(lblClickHereTo);
	}
}
