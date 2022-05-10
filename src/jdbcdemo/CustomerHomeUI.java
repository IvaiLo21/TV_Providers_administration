package jdbcdemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CustomerHomeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public CustomerHomeUI(String userSes) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// LOGOUT
		JButton LogoutBtn = new JButton("Logout");
		LogoutBtn.setForeground(new Color(0, 0, 0));
		LogoutBtn.setBackground(UIManager.getColor("Button.disabledForeground"));
		LogoutBtn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		LogoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int action = JOptionPane.showConfirmDialog(LogoutBtn, "Are you sure?");
				if (action == JOptionPane.YES_OPTION) {
					dispose();
					CustomerLoginUI obj = new CustomerLoginUI();
					obj.setTitle("Customer Login");
					obj.setVisible(true);
				}
			}
		});
		LogoutBtn.setBounds(790, 490, 200, 60);
		contentPane.add(LogoutBtn);

		// CHANGE USERNAME
		JButton ChngUserBtn = new JButton("Change Username");
		ChngUserBtn.setBackground(UIManager.getColor("Button.disabledForeground"));
		ChngUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerNameChanger obj = new CustomerNameChanger(userSes);
				obj.setTitle("Change Username");
				obj.setVisible(true);

			}
		});
		ChngUserBtn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ChngUserBtn.setBackground(SystemColor.textInactiveText);
		ChngUserBtn.setBounds(10, 102, 335, 88);
		contentPane.add(ChngUserBtn);

		// CHANGE PASSWORD
		JButton CPassBtn = new JButton("Change Password\r\n");
		CPassBtn.setBackground(UIManager.getColor("Button.disabledForeground"));
		CPassBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerPassChanger obj = new CustomerPassChanger(userSes);
				obj.setTitle("Change Password");
				obj.setVisible(true);

			}
		});
		CPassBtn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		CPassBtn.setBounds(10, 260, 335, 88);
		contentPane.add(CPassBtn);

		// CHANGE ADDRESS
		JButton ChngAddressBtn = new JButton("Change Address");
		ChngAddressBtn.setBackground(UIManager.getColor("Button.background"));
		ChngAddressBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerAddressChanger obj = new CustomerAddressChanger(userSes);
				obj.setTitle("Change Address");
				obj.setVisible(true);

			}
		});
		ChngAddressBtn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ChngAddressBtn.setBackground(SystemColor.textInactiveText);
		ChngAddressBtn.setBounds(10, 397, 335, 88);
		contentPane.add(ChngAddressBtn);

		// CHANGE PACKAGE
		JButton btnChoosechangePack = new JButton("Choose/Change Pack");
		btnChoosechangePack.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnChoosechangePack.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnChoosechangePack.setBounds(675, 102, 315, 88);
		contentPane.add(btnChoosechangePack);

		// CHOOSE PROVIDER
		JButton btnChooseProvider = new JButton("Choose Provider");
		btnChooseProvider.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnChooseProvider.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnChooseProvider.setBounds(675, 260, 315, 88);
		contentPane.add(btnChooseProvider);

		JLabel lblNewLabel = new JLabel("Customer Home Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(10, 10, 980, 82);
		contentPane.add(lblNewLabel);
	}
}