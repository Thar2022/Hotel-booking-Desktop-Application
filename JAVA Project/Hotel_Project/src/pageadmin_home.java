import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pageadmin_home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pageadmin_home frame = new pageadmin_home();
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
	public pageadmin_home() {
		 menu();
		 page();
		
	}
	public void menu() {
		System.out.println("constructor page home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(0, 0, 219, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblRoomhub = new JLabel("Roomhub");
		lblRoomhub.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoomhub.setForeground(new Color(255, 255, 255));
		lblRoomhub.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblRoomhub.setBounds(48, 101, 133, 42);
		panel.add(lblRoomhub);
		
		JLabel lbllogopage2 = new JLabel("");
		lbllogopage2.setIcon(new ImageIcon(page1.class.getResource("/res/hotel (4).png")));
		lbllogopage2.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogopage2.setBounds(74, 0, 81, 114);
		panel.add(lbllogopage2);
		
		JPanel panel_booking = new JPanel();
		panel_booking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			bookingClicked();
			}
		});
		panel_booking.setBackground(new Color(47, 79, 79));
		panel_booking.setBounds(0, 247, 219, 42);
		panel.add(panel_booking);
		panel_booking.setLayout(null);
		
		JLabel lblSearch = new JLabel("BOOKING");
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblSearch.setBounds(82, 11, 70, 20);
		panel_booking.add(lblSearch);
		
		JLabel lblprofit_1_1 = new JLabel("");
		lblprofit_1_1.setIcon(new ImageIcon(pageadmin_profit.class.getResource("/res/booking.png")));
		lblprofit_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblprofit_1_1.setBounds(36, 0, 46, 42);
		panel_booking.add(lblprofit_1_1);
		
		JPanel panel_room = new JPanel();
		panel_room.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				roomClicked() ;
				 
			}

			
		});
		 
		panel_room.setBackground(new Color(47, 79, 79));
		panel_room.setBounds(0, 194, 219, 42);
		panel.add(panel_room);
		panel_room.setLayout(null);
		
		JLabel lblroomdetail = new JLabel("");
		lblroomdetail.setIcon(new ImageIcon(page1.class.getResource("/res/info.png")));
		lblroomdetail.setHorizontalAlignment(SwingConstants.CENTER);
		lblroomdetail.setBounds(47, 0, 46, 42);
		panel_room.add(lblroomdetail);
		
		JLabel lblRoom = new JLabel("ROOM");
		 
		lblRoom.setForeground(new Color(255, 255, 255));
		lblRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoom.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblRoom.setBounds(79, 11, 70, 20);
		panel_room.add(lblRoom);
		
		JPanel panel_profit = new JPanel();
		panel_profit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			profitClicked();
			}
		});
		panel_profit.setBackground(new Color(47, 79, 79));
		panel_profit.setBounds(0, 355, 219, 42);
		panel.add(panel_profit);
		panel_profit.setLayout(null);
		
		JLabel lblprofit = new JLabel("");
		lblprofit.setIcon(new ImageIcon(page1.class.getResource("/res/gross-profit.png")));
		lblprofit.setHorizontalAlignment(SwingConstants.CENTER);
		lblprofit.setBounds(47, 0, 46, 42);
		panel_profit.add(lblprofit);
		
		JLabel lblProfit = new JLabel("PROFIT");
		lblProfit.setForeground(Color.WHITE);
		lblProfit.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfit.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblProfit.setBounds(83, 11, 70, 20);
		panel_profit.add(lblProfit);
		
		JPanel panel_home = new JPanel();
		panel_home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homeClicked();
			}
		});
		panel_home.setBackground(new Color(47, 79, 79));
		panel_home.setBounds(0, 141, 219, 42);
		panel.add(panel_home);
		panel_home.setLayout(null);
		
		JLabel lblhome = new JLabel("");
		lblhome.setIcon(new ImageIcon(page1.class.getResource("/res/home.png")));
		lblhome.setHorizontalAlignment(SwingConstants.CENTER);
		lblhome.setBounds(47, 0, 46, 42);
		panel_home.add(lblhome);
		
		JLabel lblNewLabel = new JLabel("HOME");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel.setBounds(79, 11, 70, 20);
		panel_home.add(lblNewLabel);
		
		JPanel panel_singout = new JPanel();
		panel_singout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				singoutClicked();
			}
		});
		panel_singout.setBackground(new Color(47, 79, 79));
		panel_singout.setBounds(0, 408, 219, 42);
		panel.add(panel_singout);
		panel_singout.setLayout(null);
		
		JLabel lblsingout = new JLabel("");
		lblsingout.setIcon(new ImageIcon(page1.class.getResource("/res/logout.png")));
		lblsingout.setHorizontalAlignment(SwingConstants.CENTER);
		lblsingout.setBounds(47, 0, 46, 42);
		panel_singout.add(lblsingout);
		
		JLabel lblSingout = new JLabel("SINGOUT");
		lblSingout.setForeground(Color.WHITE);
		lblSingout.setHorizontalAlignment(SwingConstants.CENTER);
		lblSingout.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblSingout.setBounds(89, 11, 70, 20);
		panel_singout.add(lblSingout);
		
		JPanel panel_customer = new JPanel();
		panel_customer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				customerClicked();
			}
		});
		panel_customer.setLayout(null);
		panel_customer.setBackground(new Color(47, 79, 79));
		panel_customer.setBounds(0, 302, 219, 42);
		panel.add(panel_customer);
		
		JLabel lblprofit_1 = new JLabel("");
		lblprofit_1.setIcon(new ImageIcon(pageadmin_profit.class.getResource("/res/customer.png")));
		lblprofit_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblprofit_1.setBounds(27, 0, 46, 42);
		panel_customer.add(lblprofit_1);
		
		JLabel lblCustomer = new JLabel("CUSTOMER");
		lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomer.setForeground(Color.WHITE);
		lblCustomer.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblCustomer.setBounds(75, 11, 85, 20);
		panel_customer.add(lblCustomer);
	}
	
	public void page() {
		System.out.println("page home");
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(47, 79, 79));
		
		panel_1.setBounds(229, 11, 545, 439);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(pageadmin_home.class.getResource("/res/etiquette.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(75, 151, 397, 277);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 525, 417);
		panel_1.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(pageadmin_home.class.getResource("/res/welcome-back (3).png")));
	}
	
	public void homeClicked() {
		new pageadmin_home().setVisible(true);
		this.dispose();
	}
	public void roomClicked() {
		new pageadmin_room().setVisible(true);
		this.dispose();
	}
	public void bookingClicked() {
		new pageadmin_booking().setVisible(true);
		this.dispose();
	}
	public void customerClicked() {
		new pageadmin_customer().setVisible(true);
		this.dispose();
	}
	public void profitClicked() {
		new pageadmin_profit().setVisible(true);
		this.dispose();
	}
	public void singoutClicked() {
		new pagelogin().setVisible(true);
		this.dispose();
	}
}
