package jdbcdemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CustomerNameChanger extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblEnterNewUsername;

	public CustomerNameChanger(String name) {
		setBounds(450, 360, 1024, 234);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 34));
		textField.setBounds(373, 35, 609, 67);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnSearch = new JButton("Enter");

		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					String input = textField.getText();

					JdbcCustomerServices service = new JdbcCustomerServices();
					service.jdbcUsernameServices(input, name);

					CustomerHomeUI obj = new CustomerHomeUI(input);
					obj.setTitle("Welcome" + " " + input);
					obj.setVisible(true);
					dispose();
					JOptionPane.showMessageDialog(btnSearch, "Name has been successfully changed");
					System.out.println("update customer name of " + input);

				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});

		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnSearch.setBackground(new Color(240, 240, 240));
		btnSearch.setBounds(438, 127, 170, 59);
		contentPane.add(btnSearch);

		lblEnterNewUsername = new JLabel("Enter New Username:");
		lblEnterNewUsername.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEnterNewUsername.setBounds(45, 37, 326, 67);
		contentPane.add(lblEnterNewUsername);
	}
}