package jdbcproviders;

import java.awt.Color;
import java.awt.Font;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;*/
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProviderLoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton RegisterBtn;
	private JButton LoginBtn;
	private JButton MainMenuBtn;
	private JPanel contentPane;

	public ProviderLoginUI() {
		setResizable(false);
		setTitle("AdminLogin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		lblNewLabel.setBounds(423, 13, 273, 93);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField.setBounds(481, 170, 281, 68);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		passwordField.setBounds(481, 286, 281, 68);
		contentPane.add(passwordField);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBackground(Color.BLACK);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblUsername.setBounds(250, 166, 193, 52);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBackground(Color.CYAN);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblPassword.setBounds(250, 286, 193, 52);
		contentPane.add(lblPassword);

		LoginBtn = new JButton("Login");
		LoginBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String userName = textField.getText();
				@SuppressWarnings("deprecation")
				String passWord = passwordField.getText();
				try {
					JdbcProviderServices service = new JdbcProviderServices();
					service.jdbcProvLogin(userName, passWord);
					if (service.jdbcProvLogin(userName, passWord) != false) {
						dispose();
						ProviderHomeUI obj = new ProviderHomeUI(userName);
						obj.setTitle("Welcome" + " " + userName);
						obj.setVisible(true);
						JOptionPane.showMessageDialog(LoginBtn, "You have successfully logged in as Admin/Provider");
					} else {
						JOptionPane.showMessageDialog(LoginBtn, "Wrong Username or Password");
					}

				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});

		LoginBtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		LoginBtn.setBounds(341, 392, 162, 73);
		contentPane.add(LoginBtn);

		MainMenuBtn = new JButton("Main Menu");
		MainMenuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				driverdemo.Login obj = new driverdemo.Login();
				obj.setTitle("Welcome back to the main menu");
				obj.setVisible(true);
			}
		});
		MainMenuBtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		MainMenuBtn.setBounds(720, 392, 162, 73);
		contentPane.add(MainMenuBtn);

		RegisterBtn = new JButton("Register");
		RegisterBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				ProviderRegisterUI obj = new ProviderRegisterUI();
				obj.setTitle("Welcome to registration");
				obj.setVisible(true);
			}
		});
		RegisterBtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		RegisterBtn.setBounds(534, 392, 162, 73);
		contentPane.add(RegisterBtn);
	}
}