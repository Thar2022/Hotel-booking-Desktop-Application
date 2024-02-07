import java.awt.EventQueue;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Result;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class pagelogin extends JFrame {

//	private Image img_logo = new  ImageIcon(pagelogin.class.getResource("res/hotel (2).png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
//	private Image img_user = new  ImageIcon(pagelogin.class.getResource("res/hotel (2).png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
//	private Image img_pass = new  ImageIcon(pagelogin.class.getResource("res/hotel (2).png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
//	private Image img_login = new  ImageIcon(pagelogin.class.getResource("res/hotel (2).png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
//	private Image img_regis = new  ImageIcon(pagelogin.class.getResource("res/hotel (2).png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textusername;
	private JTextField textpassword;
	private JPanel panel_2;
	private JLabel lblLogin;
	private JPanel panel_3;
	private JLabel lblRegister;
	private JLabel lblIconLogo;
	private JLabel lbllogin;
	private JLabel lblpass;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pagelogin frame = new pagelogin();
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
	public pagelogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(497, 187, 250, 40);
		contentPane.add(panel);
		panel.setLayout(null);

		textusername = new JTextField();
		textusername.setBorder(null);
		textusername.setFont(new Font("Arial Black", Font.BOLD, 11));
		textusername.setText("Username");
		textusername.setBounds(10, 11, 180, 20);
		panel.add(textusername);
		textusername.setColumns(10);

		lbllogin = new JLabel("");
		lbllogin.setIcon(new ImageIcon(pagelogin.class.getResource("/res/businessman.png")));
		lbllogin.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogin.setBounds(200, 0, 40, 40);
		panel.add(lbllogin);

		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBounds(497, 238, 250, 40);
		contentPane.add(panel_1);

		textpassword = new JTextField();
		textpassword.setBorder(null);
		textpassword.setFont(new Font("Arial Black", Font.BOLD, 11));
		textpassword.setText("Password");
		textpassword.setColumns(10);
		textpassword.setBounds(10, 11, 180, 20);
		panel_1.add(textpassword);

		lblpass = new JLabel("");
		lblpass.setIcon(new ImageIcon(pagelogin.class.getResource("/res/lock.png")));
		lblpass.setHorizontalAlignment(SwingConstants.CENTER);
		lblpass.setBounds(200, 0, 40, 40);
		panel_1.add(lblpass);

		panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (loginuser()) {
					loginClicked();
				} else {
					JOptionPane.showMessageDialog(null, "INVALID PASSWORD");

				}
			}
		});

		panel_2.setBackground(new Color(47, 79, 79));
		panel_2.setBounds(497, 309, 250, 45);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		lblLogin = new JLabel("Login");

		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setFont(new Font("Arial Black", Font.BOLD, 17));
		lblLogin.setBounds(103, 0, 59, 45);
		panel_2.add(lblLogin);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(pagelogin.class.getResource("/res/key.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(54, 0, 59, 45);
		panel_2.add(lblNewLabel);

		panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				regisClicked();
				 

			}
		});
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(47, 79, 79));
		panel_3.setBounds(497, 370, 250, 45);
		contentPane.add(panel_3);

		lblRegister = new JLabel("Register");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setFont(new Font("Arial Black", Font.BOLD, 17));
		lblRegister.setBounds(93, 0, 98, 45);
		panel_3.add(lblRegister);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(pagelogin.class.getResource("/res/regis.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(54, 0, 59, 45);
		panel_3.add(lblNewLabel_1);

		lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setIcon(new ImageIcon(pagelogin.class.getResource("/res/hotel (2).png")));
		lblIconLogo.setBounds(552, 29, 147, 134);
		contentPane.add(lblIconLogo);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(47, 79, 79));
		panel_4.setBounds(0, 0, 457, 461);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(pagelogin.class.getResource("/res/key (1).png")));
		lblNewLabel_3.setBounds(271, 243, 176, 180);
		panel_4.add(lblNewLabel_3);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(pagelogin.class.getResource("/res/ac.png")));
		lblNewLabel_2.setBounds(94, 66, 285, 277);
		panel_4.add(lblNewLabel_2);

	}

	public boolean loginuser() {
		try {
			String name = textusername.getText();
			String pass = textpassword.getText();
			DBconnect db = new DBconnect();
			ResultSet rs = null;
			String sql = String.format("SELECT * FROM password WHERE username = '%s' AND password = '%s'", name, pass);
			rs = db.getConnect(sql);
			return rs.next();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	public void loginClicked() {
		new pageadmin_home().setVisible(true);
		this.dispose();
	}
	public void regisClicked() {
		new pageregister().setVisible(true);
		this.dispose();
	}

}