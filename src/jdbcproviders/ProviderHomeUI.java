package jdbcproviders;

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
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class ProviderHomeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ProviderHomeUI(String userSes1) {
		setTitle("Admin_Home_Page");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			public void actionPerformed(ActionEvent e) {
				ProviderPassChanger a = new ProviderPassChanger(userSes1);
				a.setTitle("Change Password");
				a.setVisible(true);

			}
		});
		btnChngPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnChngPassword.setBounds(20, 257, 372, 80);
		contentPane.add(btnChngPassword);

		// INCREASE SERVICE COST
		JButton btnIncrease = new JButton("Increase S Cost");
		btnIncrease.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnIncrease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P_CostChanger b = new P_CostChanger(userSes1, true);
				b.setTitle("Increase Service Cost");
				b.setVisible(true);

			}
		});
		btnIncrease.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnIncrease.setBounds(475, 257, 250, 80);
		contentPane.add(btnIncrease);

		// DECREASE SERVICE COST
		JButton btnDecrease = new JButton("Decrease S cost");
		btnDecrease.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnDecrease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P_CostChanger c = new P_CostChanger(userSes1, false);
				c.setTitle("Decrease Service Cost");
				c.setVisible(true);

			}
		});
		btnDecrease.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnDecrease.setBounds(750, 257, 240, 80);
		contentPane.add(btnDecrease);

		// CHANGE USERNAME
		JButton btnChangeUsername = new JButton("Change Username");
		btnChangeUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProviderPassChanger d = new ProviderPassChanger(userSes1);
				d.setTitle("Change Password");
				d.setVisible(true);

			}
		});
		btnChangeUsername.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnChangeUsername.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnChangeUsername.setBounds(20, 130, 372, 80);
		contentPane.add(btnChangeUsername);

		// CHANGE SERVICE COST
		JButton btnChangeaddSCost = new JButton("Change/Add Service Cost");
		btnChangeaddSCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProviderServiceChanger f = new ProviderServiceChanger(userSes1);
				f.setTitle("Change/Add Service Cost");
				f.setVisible(true);

			}
		});
		btnChangeaddSCost.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnChangeaddSCost.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnChangeaddSCost.setBounds(475, 130, 515, 80);
		contentPane.add(btnChangeaddSCost);

		// CHANGE CONTRACT NUMBER
		JButton btnChangeaddContractNumber = new JButton("Change/Add Contract Number");
		btnChangeaddContractNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProviderContractNumberChanger j = new ProviderContractNumberChanger(userSes1);
				j.setTitle("Change/Add Contract Number");
				j.setVisible(true);

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
			public void actionPerformed(ActionEvent e) {
				ProviderExpiryDateChanger k = new ProviderExpiryDateChanger(userSes1);
				k.setTitle("Change/Add Expiry Date");
				k.setVisible(true);

			}
		});
		btnChangeaddContractExpiry.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnChangeaddContractExpiry.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnChangeaddContractExpiry.setBounds(475, 361, 515, 80);
		contentPane.add(btnChangeaddContractExpiry);
	}
}