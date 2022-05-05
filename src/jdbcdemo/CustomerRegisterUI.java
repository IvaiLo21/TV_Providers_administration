package jdbcdemo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class CustomerRegisterUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField UsertextField;
	private JTextField AddresstextField;
	private JPasswordField passwordField;
	private JButton MainMenuBtn;
	private JButton LoginBtn;
	private JButton RegisterBtn;
	private JPanel contentPane;

	public CustomerRegisterUI() {
		setTitle("Customer_Reg_App");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setBounds(423, 13, 273, 93);
		contentPane.add(lblNewLabel);

		UsertextField = new JTextField();
		UsertextField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		UsertextField.setBounds(481, 116, 281, 68);
		contentPane.add(UsertextField);
		UsertextField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		passwordField.setBounds(481, 201, 281, 68);
		contentPane.add(passwordField);

		AddresstextField = new JTextField();
		AddresstextField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		AddresstextField.setBounds(481, 292, 281, 68);
		contentPane.add(AddresstextField);
		AddresstextField.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBackground(Color.BLACK);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblUsername.setBounds(250, 124, 193, 52);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBackground(Color.CYAN);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblPassword.setBounds(250, 209, 193, 52);
		contentPane.add(lblPassword);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setBackground(Color.CYAN);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblAddress.setBounds(250, 300, 193, 52);
		contentPane.add(lblAddress);

		// REGISTER
		RegisterBtn = new JButton("Register");
		RegisterBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String userName = UsertextField.getText();
				@SuppressWarnings("deprecation")
				String passWord = passwordField.getText();
				String address = AddresstextField.getText();
				boolean exists = false;

				try {
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/tv_provider_administration", "root", "student1");

					PreparedStatement st = connection.prepareStatement(
							"insert into customers" + "(customer_name, customer_pass, address)" + " values (?, ?, ?)");
					try {
						st.setString(1, userName);
						st.setString(2, passWord);
						st.setString(3, address);
						st.executeUpdate();
					} catch (SQLIntegrityConstraintViolationException Excp) {
						Component frame = null;
						exists = true;
						JOptionPane.showMessageDialog(frame, "Found " + Excp.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}

					if (exists != true) {
						dispose();
						CustomerHomeUI ah = new CustomerHomeUI(userName);
						ah.setTitle("Welcome" + " " + userName);
						ah.setVisible(true);
						JOptionPane.showMessageDialog(MainMenuBtn, "You successfully registered");
					}

				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});

		RegisterBtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		RegisterBtn.setBounds(250, 400, 162, 73);
		contentPane.add(RegisterBtn);

		// LOGIN
		LoginBtn = new JButton("Go To Login");
		LoginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				CustomerLoginUI c = new CustomerLoginUI();
				c.setTitle("Welcome back to the Login Menu");
				c.setVisible(true);
			}
		});
		LoginBtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		LoginBtn.setBounds(459, 400, 250, 73);
		contentPane.add(LoginBtn);

		// MAIN MENU
		MainMenuBtn = new JButton("Main Menu");
		MainMenuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				driverdemo.Login d = new driverdemo.Login();
				d.setTitle("Welcome back to the main menu");
				d.setVisible(true);
			}
		});
		MainMenuBtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		MainMenuBtn.setBounds(750, 400, 162, 73);
		contentPane.add(MainMenuBtn);
	}
}