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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import admin.AdminInterface;
import chatScreen.ChatScreen;
import dbConnection.DBConn;
import usersManagement.IUserImpDAO;
import usersManagement.User;

import java.awt.Component;
import java.awt.Rectangle;
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

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField TFEmail;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { 
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

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 916, 464);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
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
				int rep = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Leave",JOptionPane.YES_NO_OPTION);
				if(rep==0)//si le bouton cliqué est "oui"
				     System.exit(0);
			}
		});
		lblX.setVerticalAlignment(SwingConstants.TOP);
		lblX.setIcon(new ImageIcon(Login.class.getResource("/images/x_btn.png")));
		lblX.setBounds(867, 11, 39, 41);
		contentPane.add(lblX);
		
		JLabel lblUsername = new JLabel("Email");
		lblUsername.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblUsername.setForeground(SystemColor.textHighlight);
		lblUsername.setBounds(405, 121, 218, 33);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(SystemColor.textHighlight);
		lblPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblPassword.setBounds(405, 226, 218, 33);
		contentPane.add(lblPassword);
		
		TFEmail = new JTextField();
		TFEmail.setOpaque(false);
		TFEmail.setMargin(new Insets(10, 10, 10, 10));
		TFEmail.setInheritsPopupMenu(true);
		TFEmail.setIgnoreRepaint(true);
		TFEmail.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		TFEmail.setHorizontalAlignment(SwingConstants.LEFT);
		TFEmail.setName("");
		TFEmail.setForeground(Color.LIGHT_GRAY);
		
		TFEmail.setSelectedTextColor(Color.LIGHT_GRAY);
		TFEmail.setBounds(new Rectangle(10, 10, 0, 0));
		TFEmail.setAlignmentX(Component.RIGHT_ALIGNMENT);
		TFEmail.setBackground(UIManager.getColor("Button.light"));
		TFEmail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		TFEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		TFEmail.setBounds(405, 153, 457, 41);
		contentPane.add(TFEmail);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.LIGHT_GRAY);
		passwordField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		passwordField.setOpaque(false);
		passwordField.setBounds(405, 257, 457, 41);
		contentPane.add(passwordField);
		
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
				IUserImpDAO constrol = new IUserImpDAO();
				if(constrol.isExist(TFEmail.getText(), passwordField.getText()) && !TFEmail.getText().toLowerCase().equals("admin") ) {
					User u = constrol.getUser(TFEmail.getText());
					constrol.changeStatus(u.getUserId(), 1);
					constrol.updateLastLogin(u.getUserId());
					ChatScreen chatScreen = new ChatScreen(u);
					chatScreen.setVisible(true);
					chatScreen.listenForMesagges();
					setVisible(false);
				}else {
					if(TFEmail.getText().toLowerCase().equals("admin")&& passwordField.getText().equals("admin")) {
						//code here 
						AdminInterface admin = new AdminInterface();
						admin.setVisible(true);
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null,
							    "Username or password incorrect.",
							    "Login error",
							    JOptionPane.ERROR_MESSAGE);
						TFEmail.setText("");
						passwordField.setText("");
					}
				}
			}
		});
		btnSIGNIN.setBounds(441, 348, 154, 49);
		contentPane.add(btnSIGNIN);
		
		JButton btnSIGNUP = new JButton("SIGN UP");
		btnSIGNUP.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
				if(e.getSource() == btnSIGNUP ){
					btnSIGNUP.setBackground(new Color(105, 105, 105));
				}
				
			} 
			@Override
			public void mouseExited(MouseEvent e) {
				if(e.getSource() == btnSIGNUP ) {
					btnSIGNUP.setBackground(new Color(143, 188, 143));
				}
				
			}
		});
		btnSIGNUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSIGNUP) {
					Singup singup = new Singup();
					singup.setVisible(true);
					setVisible(false);
					
				}
			}
		});
		btnSIGNUP.setForeground(Color.WHITE);
		btnSIGNUP.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		btnSIGNUP.setBorder(null);
		btnSIGNUP.setBackground(new Color(143, 188, 143));
		btnSIGNUP.setBounds(692, 348, 154, 49);
		contentPane.add(btnSIGNUP);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("Berlin Sans FB", Font.BOLD, 40));
		lblNewLabel_1.setBounds(565, 35, 154, 49);
		contentPane.add(lblNewLabel_1);
	}
}
