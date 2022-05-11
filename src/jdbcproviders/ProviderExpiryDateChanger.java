package jdbcproviders;

import java.awt.Color;
import java.awt.Component;
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

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

public class ProviderExpiryDateChanger extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblContrDetails;

	public ProviderExpiryDateChanger(String name) {
		setBounds(450, 360, 1024, 234);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 34));
		textField.setBounds(516, 35, 466, 67);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnSearch = new JButton("Enter");

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String input = textField.getText();

					JdbcProviderServices service = new JdbcProviderServices();
					service.jdbcEDateServices(input, name);

					JOptionPane.showMessageDialog(btnSearch, "Contract Date has been successfully changed");
					System.out.println("Update Contract Expiry Date of " + name);
					dispose();
				} catch (MysqlDataTruncation Excp) {
					Component frame = null;
					JOptionPane.showMessageDialog(frame, Excp.getMessage() + " Should be like this : YY-MM-DD", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});

		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnSearch.setBackground(new Color(240, 240, 240));
		btnSearch.setBounds(438, 127, 170, 59);
		contentPane.add(btnSearch);

		lblContrDetails = new JLabel("Enter Expiry Date(YY-MM-DD):");
		lblContrDetails.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblContrDetails.setBounds(45, 37, 461, 67);
		contentPane.add(lblContrDetails);
	}
}