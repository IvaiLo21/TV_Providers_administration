package driverdemo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setResizable(false);
		setTitle("TVM_App");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// CUSTOMER LOGIN
		JButton CLoginButton = new JButton("Customer Login");
		CLoginButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CLoginButton.setSize(250, 55);
		CLoginButton.setLocation(35, 95);
		CLoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				jdbcdemo.CustomerLoginUI obj = new jdbcdemo.CustomerLoginUI();
				obj.setTitle("Welcome Customer");
				obj.setVisible(true);
				JOptionPane.showMessageDialog(CLoginButton, "You have successfully choosen to log as a Customer");
			}
		});
		contentPane.add(CLoginButton);

		// PROVIDER LOGIN
		JButton PLoginBtn = new JButton("Provider Login");
		PLoginBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PLoginBtn.setSize(250, 55);
		PLoginBtn.setLocation(400, 95);
		PLoginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				jdbcproviders.ProviderLoginUI obj = new jdbcproviders.ProviderLoginUI();
				obj.setTitle("Welcome Admin");
				obj.setVisible(true);
				JOptionPane.showMessageDialog(PLoginBtn, "You have successfully choosen to log as an Admin");
			}
		});
		contentPane.add(PLoginBtn);

		// LABEL
		JLabel lblNewLabel = new JLabel("Welcome! :)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setSize(686, 42);
		lblNewLabel.setLocation(0, 0);
		lblNewLabel.setBackground(UIManager.getColor("Button.disabledForeground"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		// CUSTOMER REGISTER
		JButton CRegisterButton = new JButton("Customer Register");
		CRegisterButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CRegisterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				jdbcdemo.CustomerRegisterUI obj = new jdbcdemo.CustomerRegisterUI();
				obj.setTitle("Welcome Customer");
				obj.setVisible(true);
				JOptionPane.showMessageDialog(CRegisterButton,
						"You have successfully choosen to register as a User/Customer");
			}
		});
		CRegisterButton.setBounds(35, 273, 250, 55);
		contentPane.add(CRegisterButton);

		// PROVIDER REGISTER
		JButton PRegisterBtn = new JButton("Provider Register");
		PRegisterBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PRegisterBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				jdbcproviders.ProviderRegisterUI obj = new jdbcproviders.ProviderRegisterUI();
				obj.setTitle("Welcome Provider");
				obj.setVisible(true);
				JOptionPane.showMessageDialog(PRegisterBtn,
						"You have successfully choosen to register as a Admin/Provider");
			}
		});
		PRegisterBtn.setBounds(400, 273, 256, 55);
		contentPane.add(PRegisterBtn);

	}

}
