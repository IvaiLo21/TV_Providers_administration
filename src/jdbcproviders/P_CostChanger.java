package jdbcproviders;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class P_CostChanger extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblCostChanger;

	public P_CostChanger(String name, boolean b) {
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
					String pstr = textField.getText();
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/tv_provider_administration", "root", "student1");

					java.sql.CallableStatement myStmt = null;
					if (b) {
						myStmt = con.prepareCall("{call increase_cost_of_services(?, ?)}");
						System.out.println("Calling stored procedure Increase_cost_of_services('" + name + "', " + pstr
								+ "%" + ")");
					} else {
						myStmt = con.prepareCall("{call decrease_cost_of_services(?, ?)}");
						System.out.println("Calling stored procedure.  decrease_cost_of_services('" + name + "', "
								+ pstr + "%" + ")");
					}
					myStmt.setString(1, name);
					myStmt.setString(2, pstr);
					myStmt.execute();
					System.out.println("Finished calling stored procedure");
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}

			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnSearch.setBackground(new Color(240, 240, 240));
		btnSearch.setBounds(438, 127, 170, 59);
		contentPane.add(btnSearch);

		lblCostChanger = new JLabel("Enter %:");
		lblCostChanger.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCostChanger.setBounds(45, 37, 326, 67);
		contentPane.add(lblCostChanger);
	}

}