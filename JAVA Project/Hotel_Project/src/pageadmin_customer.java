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
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

public class pageadmin_customer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textPhone;
	private JTextField textAddress;
	private JTextField textSearch;
	private JTextField textName;
	private JTable table;
	private DefaultTableModel model;
	private JComboBox selectGender;
	private DBconnect db;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pageadmin_customer frame = new pageadmin_customer();
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
	public pageadmin_customer() {
		menu();

		page();
	}

	public void  page() {
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(229, 11, 545, 439);
		contentPane.add(panel_1);

		JPanel panel_report = new JPanel();
		panel_report.setLayout(null);
		panel_report.setBackground(Color.LIGHT_GRAY);
		panel_report.setBounds(10, 11, 525, 373);
		panel_1.add(panel_report);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(26, 202, 475, 160);
		panel_report.add(scrollPane);

		table = new JTable();
	 
		scrollPane.setViewportView(table);
		String sql = "SELECT * FROM customers";
		setTable(sql);

		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(131, 57, 119, 20);
		panel_report.add(textPhone);

		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(131, 150, 119, 20);
		panel_report.add(textAddress);

		JLabel lblNewLabel_2_1_1 = new JLabel("Phone");
		lblNewLabel_2_1_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_2_1_1.setBounds(65, 60, 56, 14);
		panel_report.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("Gender");
		lblNewLabel_2_1_2.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_2_1_2.setBounds(65, 91, 56, 14);
		panel_report.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_2_1_3 = new JLabel("Date Of Birth");
		lblNewLabel_2_1_3.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_2_1_3.setBounds(50, 125, 89, 14);
		panel_report.add(lblNewLabel_2_1_3);

		JLabel lblNewLabel_2_1_4 = new JLabel("Address");
		lblNewLabel_2_1_4.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_2_1_4.setBounds(65, 153, 74, 14);
		panel_report.add(lblNewLabel_2_1_4);

		textSearch = new JTextField();
		textSearch.setColumns(10);
		textSearch.setBounds(316, 106, 185, 20);
		panel_report.add(textSearch);

		JPanel panel_Search = new JPanel();
		panel_Search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String seach = textSearch.getText();
				String sql = String.format("SELECT * FROM customers WHERE "); 
				List<String> strSearch = new ArrayList(Arrays.asList("name","phone","address","dateOfBirth","gender"));
				for(String str: strSearch) {
					sql+=str+" LIKE '"+seach+"%"+"' " +"OR ";
				}
				String newsql = sql.substring(0,sql.length()-3);
				 
				System.out.println(newsql); 

				setTable(newsql);
				
			}
		});
		panel_Search.setBackground(new Color(47, 79, 79));
		panel_Search.setBounds(316, 137, 89, 33);
		panel_report.add(panel_Search);

		JLabel lblNewLabel_2_1_5 = new JLabel("Search");
		lblNewLabel_2_1_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_5.setBackground(new Color(255, 255, 255));
		lblNewLabel_2_1_5.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel_Search.add(lblNewLabel_2_1_5);

		JPanel panel_Refresh = new JPanel();
		panel_Refresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			refresh();
			}
		});
		panel_Refresh.setBackground(new Color(47, 79, 79));
		panel_Refresh.setBounds(415, 137, 89, 33);
		panel_report.add(panel_Refresh);

		JLabel lblNewLabel_2_1_6 = new JLabel("Refresh");
		lblNewLabel_2_1_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_6.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel_Refresh.add(lblNewLabel_2_1_6);

		selectGender = new JComboBox();
		selectGender.setBounds(131, 86, 119, 22);
		panel_report.add(selectGender);
		addComboBox(selectGender, "SELECT name FROM gender", "name");

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(131, 119, 119, 20);
		panel_report.add(dateChooser);

		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(131, 26, 119, 20);
		panel_report.add(textName);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Name");
		lblNewLabel_2_1_1_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_2_1_1_1.setBounds(65, 29, 56, 14);
		panel_report.add(lblNewLabel_2_1_1_1);

		JPanel panel_Delete = new JPanel();
		panel_Delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int indexRow = table.getSelectedRow(); 
				String phone =  model.getValueAt(indexRow, 2).toString();
				String sql = String.format(
						"DELETE FROM customers WHERE phone = '%s'",phone);

				db = new DBconnect();
				db.getUpdate(sql);
				refresh();
				
				
				
				
			}
		});
		panel_Delete.setBackground(new Color(47, 79, 79));
		panel_Delete.setBounds(108, 395, 89, 33);
		panel_1.add(panel_Delete);

		JLabel lblNewLabel_2_1 = new JLabel("Delete");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		panel_Delete.add(lblNewLabel_2_1);

		JPanel panel_Edit = new JPanel();
		panel_Edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				int indexRow = table.getSelectedRow(); 
				String phoneSelect =  model.getValueAt(indexRow, 2).toString();
				String name = textName.getText();
				String phone = textPhone.getText();
				String gender = selectGender.getSelectedItem().toString();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
				String date = dateFormat.format(   dateChooser.getDate());
				String address = textAddress.getText();
				String sql = String.format(
						"UPDATE customers SET name = '%s', phone = '%s',  gender = '%s', address = '%s', dateOfBirth = '%s' WHERE phone  = '%s'",name,phone,gender,address,date,phoneSelect  );

				db = new DBconnect();
				db.getUpdate(sql);
				refresh();
				
				
				
				
				
			}
		});
		panel_Edit.setBackground(new Color(47, 79, 79));
		panel_Edit.setBounds(241, 395, 89, 33);
		panel_1.add(panel_Edit);

		JLabel lblNewLabel_2_2 = new JLabel("Edit");
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setFont(new Font("Arial Black", Font.PLAIN, 18));
		panel_Edit.add(lblNewLabel_2_2);

		JPanel panel_Add = new JPanel();
		panel_Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(dateChooser.getDate().toString());
				String name = textName.getText();
				String phone = textPhone.getText();
				String gender = selectGender.getSelectedItem().toString();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
				String date = dateFormat.format(   dateChooser.getDate());
				String address = textAddress.getText();
				String sql = String.format(
						"INSERT INTO customers(name,phone, gender,address, dateOfBirth) VALUES('%s','%s','%s','%s', '%s')",
						name, phone, gender, address, date);
				System.out.println(sql);

				db = new DBconnect();
				db.getUpdate(sql);

				refresh();

			}
		});
		panel_Add.setBackground(new Color(47, 79, 79));
		panel_Add.setBounds(369, 395, 89, 33);
		panel_1.add(panel_Add);

		JLabel lblNewLabel_2_3 = new JLabel("Add");
		lblNewLabel_2_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_3.setFont(new Font("Arial Black", Font.PLAIN, 18));
		panel_Add.add(lblNewLabel_2_3);
	}
	public void refresh() {
		textName.setText("");
		textPhone.setText("");
		textAddress.setText("");
		textSearch.setText("");
		selectGender.setSelectedIndex(0);
		String sql = "SELECT * FROM customers";
		setTable(sql);

	}

	public void setTable(String sql) {
		String[] colname = { "CusIndex", "CusName", "CusPhone", "CusGender", "CusAddress", "CusDob" };
		model = new DefaultTableModel(colname, 0);
		try {
			db = new DBconnect();
			ResultSet rs = db.getConnect(sql);
			int index = 0;
			while (rs.next()) {
				index++;
				//String idCustomers = Integer.toString(rs.getInt("idCustomers"));
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String dateOfBirth = rs.getDate("dateOfBirth").toString() ;

				String[] row = { Integer.toString(index), name, phone, gender, address, dateOfBirth };
				//System.out.println(row[5]);
				model.addRow(row);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		table.setModel(model);
		 

	}

	public void addComboBox(JComboBox comboBox, String sql, String artribute) {
		try {
			db = new DBconnect();
			ResultSet rs = db.getConnect(sql);
			while (rs.next()) {

				comboBox.addItem(rs.getString(artribute));

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
