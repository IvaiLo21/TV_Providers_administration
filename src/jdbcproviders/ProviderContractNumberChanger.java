package jdbcproviders;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ProviderContractNumberChanger extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblContrDetails;

	public ProviderContractNumberChanger(String name) {
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
			boolean exists = false;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String pstr = textField.getText();
					Connection con = (Connection) DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/tv_provider_administration", "root", "student1");

					PreparedStatement st = (PreparedStatement) con
							.prepareStatement("Update providers set contract_number=? where name_of_provider=?");
					try {
						st.setString(1, pstr);
						st.setString(2, name);
					} catch (SQLIntegrityConstraintViolationException Excp) {
						Component frame = null;
						exists = true;
						JOptionPane.showMessageDialog(frame, "Found " + Excp.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					if (exists != true)
						st.executeUpdate();

					JOptionPane.showMessageDialog(btnSearch, "Contract Number has been successfully changed");
					System.out.println("Update Contract Number of " + name);
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});

		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnSearch.setBackground(new Color(240, 240, 240));
		btnSearch.setBounds(438, 127, 170, 59);
		contentPane.add(btnSearch);

		lblContrDetails = new JLabel("Enter New Contract Number(15):");
		lblContrDetails.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblContrDetails.setBounds(45, 37, 461, 67);
		contentPane.add(lblContrDetails);
	}
}