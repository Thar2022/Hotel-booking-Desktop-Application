import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.Date;

public class pageadmin_profit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMonthly;
	private JTextField txtMonthlyIncome;
	private JTextField textDaily;
	private JTextField txtDailyIncome;
	private JTextField textWeekly;
	private JTextField txtWeeklyIncome;
	private JTextField textTotal;
	private JTextField txtTotalIncome;
	private JTextField textRooms;
	private JTextField txtRooms;
	private JTextField textCustomers;
	private JTextField txtCustomers;
	private DBconnect db;
	private String date ; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pageadmin_profit frame = new pageadmin_profit();
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
	public pageadmin_profit() {
		setDate();
		menu();

		 page();
		
	}
	
	public void page() {
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(229, 11, 545, 440);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(37, 46, 210, 100);
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(192, 192, 192));
		panel_1.add(panel_2_1);

		textMonthly = new JTextField();
		textMonthly.setText("      "+getIncome("month")+" $");
		textMonthly.setColumns(10);
		textMonthly.setBounds(34, 37, 130, 45);
		panel_2_1.add(textMonthly);

		txtMonthlyIncome = new JTextField();
		txtMonthlyIncome.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonthlyIncome.setText("Monthly income");
		txtMonthlyIncome.setForeground(new Color(255, 255, 255));
		txtMonthlyIncome.setFont(new Font("Arial Black", Font.PLAIN, 16));
		txtMonthlyIncome.setColumns(10);
		txtMonthlyIncome.setBackground(new Color(47, 79, 79));
		txtMonthlyIncome.setBounds(0, 0, 210, 26);
		panel_2_1.add(txtMonthlyIncome);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(new Color(192, 192, 192));
		panel_2_1_1.setBounds(303, 46, 197, 100);
		panel_1.add(panel_2_1_1);

		textDaily = new JTextField();
		textDaily.setText("       "+getIncome("day")+" $");
		textDaily.setColumns(10);
		textDaily.setBounds(28, 37, 130, 45);
		panel_2_1_1.add(textDaily);

		txtDailyIncome = new JTextField();
		txtDailyIncome.setHorizontalAlignment(SwingConstants.CENTER);
		txtDailyIncome.setText("Daily income");
		txtDailyIncome.setForeground(new Color(255, 255, 255));
		txtDailyIncome.setFont(new Font("Arial Black", Font.PLAIN, 16));
		txtDailyIncome.setColumns(10);
		txtDailyIncome.setBackground(new Color(47, 79, 79));
		txtDailyIncome.setBounds(0, 0, 197, 26);
		panel_2_1_1.add(txtDailyIncome);

		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBackground(new Color(192, 192, 192));
		panel_2_1_2.setBounds(37, 173, 210, 100);
		panel_1.add(panel_2_1_2);

		textWeekly = new JTextField();
		textWeekly.setText("       "+getIncome("week")+" $");
		textWeekly.setColumns(10);
		textWeekly.setBounds(30, 40, 130, 45);
		panel_2_1_2.add(textWeekly);

		txtWeeklyIncome = new JTextField();
		txtWeeklyIncome.setHorizontalAlignment(SwingConstants.CENTER);
		txtWeeklyIncome.setText("Weekly income");
		txtWeeklyIncome.setForeground(new Color(255, 255, 255));
		txtWeeklyIncome.setFont(new Font("Arial Black", Font.PLAIN, 16));
		txtWeeklyIncome.setColumns(10);
		txtWeeklyIncome.setBackground(new Color(47, 79, 79));
		txtWeeklyIncome.setBounds(0, 0, 210, 26);
		panel_2_1_2.add(txtWeeklyIncome);

		JPanel panel_2_1_3 = new JPanel();
		panel_2_1_3.setLayout(null);
		panel_2_1_3.setBackground(new Color(192, 192, 192));
		panel_2_1_3.setBounds(303, 173, 197, 100);
		panel_1.add(panel_2_1_3);

		textTotal = new JTextField();
		textTotal.setText("      "+getIncome("total")+" $");
		textTotal.setColumns(10);
		textTotal.setBounds(30, 40, 130, 45);
		panel_2_1_3.add(textTotal);

		txtTotalIncome = new JTextField();
		txtTotalIncome.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalIncome.setText("Total income");
		txtTotalIncome.setForeground(new Color(255, 255, 255));
		txtTotalIncome.setFont(new Font("Arial Black", Font.PLAIN, 16));
		txtTotalIncome.setColumns(10);
		txtTotalIncome.setBackground(new Color(47, 79, 79));
		txtTotalIncome.setBounds(0, 0, 197, 26);
		panel_2_1_3.add(txtTotalIncome);

		JPanel panel_2_1_4 = new JPanel();
		panel_2_1_4.setLayout(null);
		panel_2_1_4.setBackground(new Color(192, 192, 192));
		panel_2_1_4.setBounds(37, 302, 210, 100);
		panel_1.add(panel_2_1_4);

		textRooms = new JTextField();
		textRooms.setText("            "+getCountKey("rooms"));
		textRooms.setColumns(10);
		textRooms.setBounds(30, 40, 130, 45);
		panel_2_1_4.add(textRooms);

		txtRooms = new JTextField();
		txtRooms.setHorizontalAlignment(SwingConstants.CENTER);
		txtRooms.setText("Rooms");
		txtRooms.setForeground(new Color(255, 255, 255));
		txtRooms.setFont(new Font("Arial Black", Font.PLAIN, 16));
		txtRooms.setColumns(10);
		txtRooms.setBackground(new Color(47, 79, 79));
		txtRooms.setBounds(0, 0, 210, 26);
		panel_2_1_4.add(txtRooms);

		JPanel panel_2_1_5 = new JPanel();
		panel_2_1_5.setLayout(null);
		panel_2_1_5.setBackground(new Color(192, 192, 192));
		panel_2_1_5.setBounds(303, 302, 197, 100);
		panel_1.add(panel_2_1_5);

		textCustomers = new JTextField();
		textCustomers.setText("            "+getCountKey("customers"));
		textCustomers.setColumns(10);
		textCustomers.setBounds(30, 40, 130, 45);
		panel_2_1_5.add(textCustomers);

		txtCustomers = new JTextField();
		txtCustomers.setHorizontalAlignment(SwingConstants.CENTER);
		txtCustomers.setText("Customers");
		txtCustomers.setForeground(Color.WHITE);
		txtCustomers.setFont(new Font("Arial Black", Font.PLAIN, 16));
		txtCustomers.setColumns(10);
		txtCustomers.setBackground(new Color(47, 79, 79));
		txtCustomers.setBounds(0, 0, 197, 26);
		panel_2_1_5.add(txtCustomers);
	}
	
	public int getCountKey(String key) {
		db = new DBconnect();
		ResultSet rs = db.getConnect(String.format(   "SELECT count(*) FROM  %s",key));
		try {
			if (rs.next()) {
				  
				return  rs.getInt("count(*)");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	public int getIncome(String key) {
		db = new DBconnect();
		ResultSet rs = null;
		String sql =null;
		if(key.equals("day")) {
			sql = String.format(   "SELECT sum( price*(DATEDIFF(checkoutDate,bookingDate)+1)) as sumPrice FROM booking NATURAL JOIN rooms WHERE bookingDate =  '%s' ;",date);
			 
			
		}
		if(key.equals("week")) {
			 sql =  "SELECT SUM(price*(DATEDIFF(checkoutDate,bookingDate)+1)) AS sumPrice  FROM booking NATURAL JOIN rooms WHERE bookingDate BETWEEN ADDDATE('"+date+"', INTERVAL (1-(WEEKDAY('"+date+"')+2)"+"%"+"7) DAY) AND ADDDATE('"+date+"', INTERVAL (7-(WEEKDAY('"+date+"')+2)"+"%"+"7) DAY)" ;
		 
		}	
		if(key.equals("total")) {
			sql = String.format(   "SELECT  sum( price*(DATEDIFF(checkoutDate,bookingDate)+1)) as sumPrice FROM booking NATURAL JOIN rooms");
			 
		 
		}
		if(key.equals("month")) {
			sql = String.format(   "SELECT SUM(price*(DATEDIFF(checkoutDate,bookingDate)+1)) AS sumPrice   FROM booking NATURAL JOIN rooms WHERE bookingDate BETWEEN DATE_FORMAT('%s', %s)  AND LAST_DAY('%s')",date,"'%Y-%m-01'",date);
			 System.out.println(sql);
		}
		rs = db.getConnect(sql);
		try {
			if (rs.next()) {
				int x = rs.getInt("sumPrice");
				//System.out.println(x);
				return  x;
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return 0;
	}
	public void setDate() {
		db = new DBconnect();
		ResultSet rs = db.getConnect("select current_date()");
		try {
			if (rs.next()) {
				 
				date = rs.getString("current_date()");
				 //date = "2023-11-21";
				
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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
