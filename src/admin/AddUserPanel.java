package admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import usersManagement.IUserImpDAO;
import usersManagement.User;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddUserPanel extends JPanel {
	private JTextField TFUsername;
	private JTextField TFEmail;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public AddUserPanel() {
		
		setLayout(null);//625, 
		this.setBounds(0, 0, 622, 496);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblUsername.setBounds(36, 30, 137, 24);
		add(lblUsername);
		
		TFUsername = new JTextField();
		TFUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TFUsername.setCaretColor(Color.GRAY);
		TFUsername.setForeground(Color.GRAY);
		TFUsername.setOpaque(false);
		TFUsername.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.GRAY));
		TFUsername.setBounds(36, 65, 534, 24);
		add(TFUsername);
		TFUsername.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblEmail.setBounds(36, 110, 137, 24);
		add(lblEmail);
		
		TFEmail = new JTextField();
		TFEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TFEmail.setCaretColor(Color.GRAY);
		TFEmail.setOpaque(false);
		TFEmail.setForeground(Color.GRAY);
		TFEmail.setColumns(10);
		TFEmail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.GRAY));
		TFEmail.setBounds(36, 145, 534, 24);
		add(TFEmail);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setCaretColor(Color.GRAY);
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.GRAY));
		passwordField.setOpaque(false);
		passwordField.setBounds(36, 226, 534, 29);
		add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblPassword.setBounds(36, 191, 137, 24);
		add(lblPassword);
		
		JRadioButton RBFemale = new JRadioButton("Female");
		buttonGroup.add(RBFemale);
		RBFemale.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		RBFemale.setBounds(329, 294, 109, 23);
		add(RBFemale);
		
		JRadioButton RBMale = new JRadioButton("Male");
		buttonGroup.add(RBMale);
		RBMale.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		RBMale.setBounds(195, 294, 109, 23);
		add(RBMale);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblGender.setBounds(36, 294, 137, 24);
		add(lblGender);
		
		JButton AddButton = new JButton("Add User");
		AddButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IUserImpDAO control = new IUserImpDAO();
				String username = TFUsername.getText();
				String email = TFEmail.getText();
				String password = passwordField.getText();
				String gender = "";
				
				if(!control.emailTaken(email)) {
					if(RBMale.isSelected()) {
						gender = "Male";
					}
					if(RBFemale.isSelected()) {
						gender = "Female";
					}
					//int userId, String username, String email, String password, String gender, String dateRegistration,
					//String lastLogin, int isOnline
					User u = new User(1,username,email,password,gender,null,null,1);
					control.addUser(u);
					TFUsername.setText("");
					TFEmail.setText("");
					passwordField.setText("");
					buttonGroup.clearSelection();
				}else {
					JOptionPane.showMessageDialog(null,
						    "Email has already been taken.",
						    "Add user",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		AddButton.setForeground(SystemColor.text);
		AddButton.setBackground(SystemColor.textHighlight);
		AddButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		AddButton.setBounds(84, 360, 159, 42);
		add(AddButton);
		
		JButton ResetButton = new JButton("Reset");
		ResetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TFUsername.setText("");
				TFEmail.setText("");
				passwordField.setText("");
				buttonGroup.clearSelection();
			}
		});
		ResetButton.setForeground(Color.WHITE);
		ResetButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		ResetButton.setBackground(SystemColor.textHighlight);
		ResetButton.setBounds(344, 360, 159, 42);
		add(ResetButton);
		setVisible(true);
	}
}
