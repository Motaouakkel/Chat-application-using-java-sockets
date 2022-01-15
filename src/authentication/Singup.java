package authentication;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import chatScreen.ChatScreen;
import usersManagement.IUserImpDAO;
import usersManagement.User;

import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.ButtonGroup;
import javax.swing.DebugGraphics;
import java.awt.Point;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class Singup extends JFrame {

	private JPanel contentPane;
	private JTextField TFUsername;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField TFEmail;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					Singup frame = new Singup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Singup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 916, 464);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setFocusCycleRoot(true);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setName("");
		contentPane.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		contentPane.setBounds(new Rectangle(10, 0, 0, 0));
		contentPane.setBackground(UIManager.getColor("InternalFrame.resizeIconHighlight"));
		contentPane.setBorder(new LineBorder(UIManager.getColor("Panel.foreground"), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/bgLogin.jpg")));
		lblNewLabel.setBounds(2, 2, 341, 460);
		contentPane.add(lblNewLabel);
		
		JLabel lblX = new JLabel("");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//JOptionPane.showMessageDialog(null,"hi");
				int rep = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit?","Quit chat",JOptionPane.YES_NO_OPTION);
				if(rep==0)//si le bouton cliqué est "oui"
				     System.exit(0);
			}
		});
		lblX.setVerticalAlignment(SwingConstants.TOP);
		lblX.setIcon(new ImageIcon(Login.class.getResource("/images/x_btn.png")));
		lblX.setBounds(867, 11, 39, 41);
		contentPane.add(lblX);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblUsername.setForeground(SystemColor.textHighlight);
		lblUsername.setBounds(405, 121, 218, 33);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(SystemColor.textHighlight);
		lblPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblPassword.setBounds(406, 209, 218, 33);
		contentPane.add(lblPassword);
		
		TFUsername = new JTextField();
		TFUsername.setOpaque(false);
		TFUsername.setMargin(new Insets(10, 10, 10, 10));
		TFUsername.setInheritsPopupMenu(true);
		TFUsername.setIgnoreRepaint(true);
		TFUsername.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		TFUsername.setHorizontalAlignment(SwingConstants.LEFT);
		TFUsername.setName("");
		TFUsername.setForeground(Color.LIGHT_GRAY);
		
		TFUsername.setSelectedTextColor(Color.LIGHT_GRAY);
		TFUsername.setBounds(new Rectangle(10, 10, 0, 0));
		TFUsername.setAlignmentX(Component.RIGHT_ALIGNMENT);
		TFUsername.setBackground(UIManager.getColor("Button.light"));
		TFUsername.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		TFUsername.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		TFUsername.setBounds(405, 152, 207, 28);
		contentPane.add(TFUsername);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.LIGHT_GRAY);
		passwordField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		passwordField.setOpaque(false);
		passwordField.setBounds(406, 239, 207, 28);
		contentPane.add(passwordField);
		
		
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(SystemColor.textHighlight);
		lblConfirmPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblConfirmPassword.setBounds(634, 209, 218, 33);
		contentPane.add(lblConfirmPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setOpaque(false);
		passwordField_1.setForeground(Color.LIGHT_GRAY);
		passwordField_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		passwordField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		passwordField_1.setBounds(633, 244, 207, 23);
		contentPane.add(passwordField_1);
		
		JRadioButton RBGenderF = new JRadioButton("Female"); 
		RBGenderF.setContentAreaFilled(false);
		RBGenderF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		RBGenderF.setForeground(SystemColor.textHighlight);
		RBGenderF.setBounds(405, 298, 109, 23);
		contentPane.add(RBGenderF);
		
		JRadioButton RBGenderM = new JRadioButton("Male");
		RBGenderM.setContentAreaFilled(false);
		RBGenderM.setForeground(SystemColor.textHighlight);
		RBGenderM.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		RBGenderM.setBounds(516, 298, 109, 23);
		contentPane.add(RBGenderM);
		
		ButtonGroup gender = new ButtonGroup(); 
		gender.add(RBGenderM);
		gender.add(RBGenderF);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(SystemColor.textHighlight);
		lblEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblEmail.setBounds(632, 121, 218, 33);
		contentPane.add(lblEmail);
		
		TFEmail = new JTextField();
		TFEmail.setSelectedTextColor(Color.LIGHT_GRAY);
		TFEmail.setOpaque(false);
		TFEmail.setName("");
		TFEmail.setMargin(new Insets(10, 10, 10, 10));
		TFEmail.setInheritsPopupMenu(true);
		TFEmail.setIgnoreRepaint(true);
		TFEmail.setHorizontalAlignment(SwingConstants.LEFT);
		TFEmail.setForeground(Color.LIGHT_GRAY);
		TFEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		TFEmail.setBounds(new Rectangle(10, 10, 0, 0));
		TFEmail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		TFEmail.setBackground(SystemColor.controlHighlight);
		TFEmail.setAlignmentX(1.0f);
		TFEmail.setBounds(632, 152, 207, 28);
		contentPane.add(TFEmail);
		
		
		
		
		JButton btnSIGNIN = new JButton("SIGN IN");
		btnSIGNIN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(e.getSource() == btnSIGNIN ) {
					btnSIGNIN.setBackground(new Color(105, 105, 105));
				} 
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(e.getSource() == btnSIGNIN ) {
					btnSIGNIN.setBackground(SystemColor.textHighlight);
				}
			}
		});
		btnSIGNIN.setBorder(null);
		btnSIGNIN.setForeground(SystemColor.text);
		btnSIGNIN.setBackground(SystemColor.textHighlight);
		btnSIGNIN.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		btnSIGNIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSIGNIN) {
					Login login = new Login();
					login.setVisible(true);
					setVisible(false);
					
				}
			}
		});
		btnSIGNIN.setBounds(696, 364, 154, 49);
		contentPane.add(btnSIGNIN);
		
		JButton btnSIGNUP = new JButton("SIGN UP");
		btnSIGNUP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(e.getSource() == btnSIGNUP ) {
					btnSIGNUP.setBackground(new Color(105, 105, 105));
				}
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(e.getSource() == btnSIGNUP ) {
					btnSIGNUP.setBackground(new Color(143, 188, 143));
				}
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				IUserImpDAO control = new IUserImpDAO();
				String username = TFUsername.getText();
				String email = TFEmail.getText();
				String password = passwordField.getText();
				String gender=null ;
				
				if(RBGenderM.isSelected())
					gender = "Male";
				if(RBGenderF.isSelected())
					gender = "Female";
				if(!control.emailTaken(email)) {
					/*int userId, String username, String email, String password, String gender, String dateRegistration,
					String lastLogin, int isOnline*/
					User u = new User(1,username,email,password,gender,null,null,1);
					control.addUser(u);
					u=control.getUser(email);
					control.changeStatus(u.getUserId(), 1);
					ChatScreen chatScreen = new ChatScreen(u);
					chatScreen.setVisible(true);
					chatScreen.listenForMesagges();
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null,
						    "Email has already been taken.",
						    "Sing up error",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSIGNUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSIGNUP.setForeground(Color.WHITE);
		btnSIGNUP.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		btnSIGNUP.setBorder(null);
		btnSIGNUP.setBackground(new Color(143, 188, 143));
		btnSIGNUP.setBounds(461, 364, 154, 49);
		contentPane.add(btnSIGNUP);
		
		JLabel lblNewLabel_1 = new JLabel("SING UP");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("Berlin Sans FB", Font.BOLD, 40));
		lblNewLabel_1.setBounds(546, 28, 185, 49);
		contentPane.add(lblNewLabel_1);
		
		
		
		
		JCheckBox CBCondition = new JCheckBox("By creating an account ");
		CBCondition.setBackground(SystemColor.textHighlight);
		CBCondition.setContentAreaFilled(false);
		CBCondition.setSelected(true);
		CBCondition.setFont(new Font("Berlin Sans FB", Font.BOLD, 15));
		CBCondition.setBounds(683, 288, 207, 33);
		contentPane.add(CBCondition);
		
		JLabel lblNewLabel_2 = new JLabel("You agree to the terms and conditions");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(693, 316, 213, 25);
		contentPane.add(lblNewLabel_2);
	}
}
