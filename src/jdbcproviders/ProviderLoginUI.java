package jdbcproviders;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import jdbcdemo.CustomerRegisterUI;

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
		setTitle("AdminLogin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(false);
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
					Connection connection = (Connection) DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/tv_provider_administration", "root", "student1");

					PreparedStatement st = (PreparedStatement) connection.prepareStatement(
							"Select name_of_provider, provider_pass from providers where name_of_provider=? and provider_pass=?");

					st.setString(1, userName);
					st.setString(2, passWord);
					ResultSet rs = st.executeQuery();

					if (rs.next()) {
						dispose();
						ProviderHomeUI ah = new ProviderHomeUI(userName);
						ah.setTitle("Welcome" + " " + userName);
						ah.setVisible(true);
						JOptionPane.showMessageDialog(RegisterBtn, "You have successfully logged in as admin");
					} else {
						JOptionPane.showMessageDialog(RegisterBtn, "Wrong Username & Password");
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
				driverdemo.Login d = new driverdemo.Login();
				d.setTitle("Welcome back to the main menu");
				d.setVisible(true);
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
				CustomerRegisterUI c = new CustomerRegisterUI();
				c.setTitle("Welcome to registration");
				c.setVisible(true);
			}
		});
		RegisterBtn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		RegisterBtn.setBounds(534, 392, 162, 73);
		contentPane.add(RegisterBtn);
	}
}