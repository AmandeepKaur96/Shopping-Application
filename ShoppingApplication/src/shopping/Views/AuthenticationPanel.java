package shopping.Views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import shopping.Controllers.AuthController;
import shopping.Models.User;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AuthenticationPanel extends JFrame {
	private JPanel contentPane;
	private JLabel userLabel;
	private JTextField userTextField;
	private JLabel passwordLabel;
	private JTextField passwordTextField;
	private JButton submitButton;
	private AuthController controller;
	
	public AuthenticationPanel() {
		super("Authentication View");
		this.setupBasicComponents();
		this.setupContentPane();
		this.addBasicComponentsToContentPane();
		this.addListeners();
		
		this.setMinimumSize(new Dimension(225, this.getMinimumSize().height));		
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	private void setupContentPane() {
		this.contentPane = (JPanel) getContentPane();
		this.contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		this.contentPane.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
	}
	
	private void setupBasicComponents() {
		this.userLabel = new JLabel("User");
		this.userLabel.setAlignmentX(0.5f);
		this.userLabel.setPreferredSize(new Dimension(200, 20));
		
		this.userTextField = new JTextField();
		this.userTextField.setAlignmentX(0.5f);
		this.userTextField.setPreferredSize(new Dimension(200, 20));
		
		this.passwordLabel = new JLabel("Password");
		this.passwordLabel.setAlignmentX(0.5f);
		this.passwordLabel.setPreferredSize(new Dimension(200, 20));
		
		this.passwordTextField = new JTextField();
		this.passwordTextField.setAlignmentX(0.5f);
		this.passwordTextField.setPreferredSize(new Dimension(200, 20));
		
		this.submitButton = new JButton("Submit");
		this.submitButton.setAlignmentX(0.5f);
	}
	
	private void addBasicComponentsToContentPane() {
		this.contentPane.add(this.userLabel);	
		this.contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		this.contentPane.add(this.userTextField);
		this.contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		this.contentPane.add(this.passwordLabel);
		this.contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		this.contentPane.add(this.passwordTextField);
		this.contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		this.contentPane.add(this.submitButton);
	}
	
	private void addListeners() {
		this.submitButton.addActionListener((ActionEvent e) -> {
			User user = new User(this.userTextField.getText(), 
									this.passwordTextField.getText());
			
			if(user.authenticateUser()) {
				this.setVisible(false);
				MasterPanel mainWindow = new MasterPanel();
				mainWindow.setVisible(true);
			}
		});
	}
}
