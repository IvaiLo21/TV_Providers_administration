package jdbcproviders;

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

public class ProviderServiceChanger extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblEnterServiceCost;

	public ProviderServiceChanger(String name) {
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

					JdbcProviderServices service = new JdbcProviderServices();
					service.jdbcCostServices(input, name);

					JOptionPane.showMessageDialog(btnSearch, "The Service Cost has been successfully changed");
					System.out.println("update service cost of " + name);
					dispose();
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});

		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnSearch.setBackground(new Color(240, 240, 240));
		btnSearch.setBounds(438, 127, 170, 59);
		contentPane.add(btnSearch);

		lblEnterServiceCost = new JLabel("Enter Service Cost:");
		lblEnterServiceCost.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEnterServiceCost.setBounds(45, 37, 326, 67);
		contentPane.add(lblEnterServiceCost);
	}
}