package jdbcproviders;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class ProviderHomeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ProviderHomeUI(String userSes1) {
		setTitle("Admin_Home_Page");

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// LOGOUT
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
				if (a == JOptionPane.YES_OPTION) {
					dispose();
					ProviderLoginUI obj = new ProviderLoginUI();
					obj.setTitle("Provider Login");
					obj.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(750, 470, 240, 80);
		contentPane.add(btnNewButton);

		// PASSWORD CHANGER
		JButton btnChngPassword = new JButton("Change Password\r\n");
		btnChngPassword.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnChngPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProviderPassChanger obj = new ProviderPassChanger(userSes1);
				obj.setTitle("Change Password");
				obj.setVisible(true);

			}
		});
		btnChngPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnChngPassword.setBounds(20, 257, 372, 80);
		contentPane.add(btnChngPassword);

		// INCREASE SERVICE COST
		JButton btnIncrease = new JButton("Increase S Cost");
		btnIncrease.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnIncrease.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProviderIncDcr obj = new ProviderIncDcr(userSes1, true);
				obj.setTitle("Increase Service Cost");
				obj.setVisible(true);

			}
		});
		btnIncrease.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnIncrease.setBounds(475, 257, 250, 80);
		contentPane.add(btnIncrease);

		// DECREASE SERVICE COST
		JButton btnDecrease = new JButton("Decrease S cost");
		btnDecrease.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnDecrease.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProviderIncDcr obj = new ProviderIncDcr(userSes1, false);
				obj.setTitle("Decrease Service Cost");
				obj.setVisible(true);

			}
		});
		btnDecrease.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnDecrease.setBounds(750, 257, 240, 80);
		contentPane.add(btnDecrease);

		// CHANGE USERNAME
		JButton btnChangeUsername = new JButton("Change Username");
		btnChangeUsername.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ProviderNameChanger obj = new ProviderNameChanger(userSes1);
				obj.setTitle("Change Username");
				obj.setVisible(true);

			}
		});
		btnChangeUsername.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnChangeUsername.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnChangeUsername.setBounds(20, 130, 372, 80);
		contentPane.add(btnChangeUsername);

		// CHANGE SERVICE COST
		JButton btnChangeaddSCost = new JButton("Change/Add Service Cost");
		btnChangeaddSCost.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProviderServiceChanger obj = new ProviderServiceChanger(userSes1);
				obj.setTitle("Change/Add Service Cost");
				obj.setVisible(true);

			}
		});
		btnChangeaddSCost.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnChangeaddSCost.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnChangeaddSCost.setBounds(475, 130, 515, 80);
		contentPane.add(btnChangeaddSCost);

		// CHANGE CONTRACT NUMBER
		JButton btnChangeaddContractNumber = new JButton("Change/Add Contract Number");
		btnChangeaddContractNumber.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProviderContractNumberChanger obj = new ProviderContractNumberChanger(userSes1);
				obj.setTitle("Change/Add Contract Number");
				obj.setVisible(true);

			}
		});
		btnChangeaddContractNumber.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnChangeaddContractNumber.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnChangeaddContractNumber.setBounds(21, 379, 371, 80);
		contentPane.add(btnChangeaddContractNumber);

		// PAGE LABEL
		JLabel lblPageLabel = new JLabel("Provider Home Page");
		lblPageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPageLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPageLabel.setBounds(10, 10, 980, 60);
		contentPane.add(lblPageLabel);

		// CHANGE CONTRACT DATE
		JButton btnChangeaddContractExpiry = new JButton("Change/Add Contract Expiry Date");
		btnChangeaddContractExpiry.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProviderExpiryDateChanger obj = new ProviderExpiryDateChanger(userSes1);
				obj.setTitle("Change/Add Expiry Date");
				obj.setVisible(true);

			}
		});
		btnChangeaddContractExpiry.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnChangeaddContractExpiry.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnChangeaddContractExpiry.setBounds(475, 361, 515, 80);
		contentPane.add(btnChangeaddContractExpiry);
	}
}