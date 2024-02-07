import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.ResultsetRow;
import com.mysql.cj.xdevapi.Result;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pageregister extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtConfrimpassword;
	private JTextField txtEmail;
	private DBconnect db;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pageregister frame = new pageregister();
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
	public pageregister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_Username = new JPanel();
		panel_Username.setBackground(Color.WHITE);
		panel_Username.setBounds(506, 158, 250, 40);
		contentPane.add(panel_Username);
		panel_Username.setLayout(null);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Arial Black", Font.PLAIN, 11));
		txtUsername.setText("Username");
		txtUsername.setBounds(10, 11, 200, 20);
		panel_Username.add(txtUsername);
		txtUsername.setColumns(10);

		JPanel panel_Pass_1 = new JPanel();
		panel_Pass_1.setLayout(null);
		panel_Pass_1.setBackground(Color.WHITE);
		panel_Pass_1.setBounds(506, 209, 250, 40);
		contentPane.add(panel_Pass_1);

		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Arial Black", Font.PLAIN, 11));
		txtPassword.setText("Password");
		txtPassword.setColumns(10);
		txtPassword.setBounds(10, 11, 200, 20);
		panel_Pass_1.add(txtPassword);

		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(517, 38, 216, 50);
		contentPane.add(lblNewLabel);

		JPanel panel_Pass_2 = new JPanel();
		panel_Pass_2.setLayout(null);
		panel_Pass_2.setBackground(Color.WHITE);
		panel_Pass_2.setBounds(506, 260, 250, 40);
		contentPane.add(panel_Pass_2);

		txtConfrimpassword = new JTextField();
		txtConfrimpassword.setText("ConfrimPassword");
		txtConfrimpassword.setFont(new Font("Arial Black", Font.PLAIN, 11));
		txtConfrimpassword.setColumns(10);
		txtConfrimpassword.setBounds(10, 11, 200, 20);
		panel_Pass_2.add(txtConfrimpassword);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(47, 79, 79));
		panel_4.setBounds(0, 0, 457, 461);
		contentPane.add(panel_4);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(pageregister.class.getResource("/res/key (1).png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(271, 243, 176, 180);
		panel_4.add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(pageregister.class.getResource("/res/register.png")));
		// lblNewLabel_2.setIcon(new
		// ImageIcon(pageregister.class.getResource("/res/register.png")));
		lblNewLabel_2.setBounds(94, 66, 285, 277);
		panel_4.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		// lblNewLabel_4.setIcon(new
		// ImageIcon(pageregister.class.getResource("/res/add-friend1.png")));
		lblNewLabel_4.setBounds(580, 11, 98, 83);
		contentPane.add(lblNewLabel_4);

		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				regisClicked();
			}
		});
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(47, 79, 79));
		panel_2.setBounds(506, 330, 250, 45);
		contentPane.add(panel_2);

		JLabel lblRegis = new JLabel("Regis");
		lblRegis.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegis.setForeground(Color.WHITE);
		lblRegis.setFont(new Font("Arial Black", Font.BOLD, 17));
		lblRegis.setBounds(103, 0, 59, 45);
		panel_2.add(lblRegis);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(54, 0, 59, 45);
		panel_2.add(lblNewLabel_1);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				backClicked();
			}
		});
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(47, 79, 79));
		panel_2_1.setBounds(506, 386, 250, 45);
		contentPane.add(panel_2_1);

		JLabel lblBack = new JLabel("Back");
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("Arial Black", Font.BOLD, 17));
		lblBack.setBounds(103, 0, 59, 45);
		panel_2_1.add(lblBack);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(54, 0, 59, 45);
		panel_2_1.add(lblNewLabel_5);

		JPanel panel_Mail = new JPanel();
		panel_Mail.setLayout(null);
		panel_Mail.setBackground(Color.WHITE);
		panel_Mail.setBounds(506, 107, 250, 40);
		contentPane.add(panel_Mail);

		txtEmail = new JTextField();
		txtEmail.setText("E-Mail");
		txtEmail.setFont(new Font("Arial Black", Font.PLAIN, 11));
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 11, 200, 20);
		panel_Mail.add(txtEmail);
	}

	public void regisClicked() {
		String [] str = {txtEmail.getText(), txtUsername.getText(),txtPassword.getText(), txtConfrimpassword.getText()};
//		String email = txtEmail.getText();
//		String user = txtUsername.getText();
//		String  pass = txtPassword.getText();
//		String passConfrim = txtConfrimpassword.getText();
		boolean check = true;
		for(String str_:str) {
			if(str_.equals("")) {
				JOptionPane.showMessageDialog(null, "PLEASE ENTER EVERY BOX");
				check = false;
				break;
			}
		}
		if(!str[2].equals(str[3]) && check) {
			JOptionPane.showMessageDialog(null, "PASSWORD DON'T MATCH");
			check = false;
		}
		if(check) {
			db = new DBconnect();
			db.getUpdate(String.format("INSERT INTO password(username, password, e_mail) VALUES('%s', '%s', '%s')",str[1],str[2],str[0]));
			
			JOptionPane.showMessageDialog(null, "FINISH");
			new pagelogin().setVisible(true);
			this.dispose();
		}
		 
	}

	public void backClicked() {
		new pagelogin().setVisible(true);
		this.dispose();
	}

}
