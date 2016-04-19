package PracticeProgramDraft;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.beans.*;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

public class LoginPage extends JFrame {

	private JButton Login = new JButton("Login");
	private JTextField username = new JTextField("");
	private JPasswordField password = new JPasswordField("");
	private JLabel userLabel = new JLabel("Username:");
	private JLabel passLabel = new JLabel("Password:");

	public LoginPage() {

		super("Login Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(50, 50, 250, 200);
		setVisible(true);
		setLayout(null);

		// Set Locations and Sizes of UI elements
		userLabel.setBounds(50, 55, 75, 10);
		passLabel.setBounds(50, 80, 75, 10);
		username.setBounds(125, 50, 75, 20);
		password.setBounds(125, 75, 75, 20);
		Login.setBounds(85, 110, 80, 25);

		// Add UI elements to the Frame
		add(userLabel);
		add(passLabel);
		add(username);
		add(password);
		add(Login);

		// Added Functionality of Login Button
		Login.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				//changes text to change username and password.
                                if(username.getText().equalsIgnoreCase("admin") && password.getText().equalsIgnoreCase("admin"))
                                {
                                    setVisible(false);
                                    new HomePage();
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"The input Username and Password are incorrect.","Incorrect Input",JOptionPane.WARNING_MESSAGE);
                                }
                                                             
                                }
		});
	}
}
