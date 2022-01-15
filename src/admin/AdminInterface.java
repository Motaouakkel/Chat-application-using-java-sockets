package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminInterface extends JFrame {

	private JPanel contentPane;
	
	private ListUsersPanel listUsers;
	private AddUserPanel addUser;
	private DeleteUserPanel deleteUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminInterface frame = new AdminInterface();
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
	public AdminInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(230, 80, 928, 557);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setLocationRelativeTo(null);// ?????
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(2, 2, 299, 553);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(AdminInterface.class.getResource("/images/logo_admin.png")));
		lblLogo.setBounds(50, 11, 201, 201);
		panel.add(lblLogo);
		
		addUser = new AddUserPanel();
		
		deleteUser = new DeleteUserPanel();
		
		listUsers = new ListUsersPanel();
		
		
		
		
		
		
		
		
		JPanel UsersListPanel = new JPanel();
		UsersListPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(e.getSource() == UsersListPanel )
					UsersListPanel.setBackground(new Color(0, 200, 200));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(e.getSource() == UsersListPanel )
					UsersListPanel.setBackground(new Color(60, 179, 113));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				changePane(listUsers);
			}
		});
		UsersListPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 153)));
		UsersListPanel.setBackground(new Color(60, 179, 113));
		UsersListPanel.setForeground(SystemColor.text);
		UsersListPanel.setBounds(0, 230, 299, 54);
		panel.add(UsersListPanel);
		UsersListPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminInterface.class.getResource("/images/usersList.png")));
		lblNewLabel.setBounds(5, 3, 42, 45);
		UsersListPanel.add(lblNewLabel);
		
		JLabel userListLBL = new JLabel("Users List");
		userListLBL.setForeground(new Color(0, 102, 153));
		userListLBL.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		userListLBL.setBackground(new Color(0, 102, 153));
		userListLBL.setBounds(77, 11, 180, 37);
		UsersListPanel.add(userListLBL);
		
		JPanel addUserPanel = new JPanel();
		addUserPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(e.getSource() == addUserPanel )
					addUserPanel.setBackground(new Color(0, 200, 200));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(e.getSource() == addUserPanel )
					addUserPanel.setBackground(new Color(60, 179, 113));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				changePane(addUser);
			}
		});
		
		addUserPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 153)));
		addUserPanel.setBackground(new Color(60, 179, 113));
		addUserPanel.setForeground(SystemColor.text);
		addUserPanel.setBounds(0, 289, 299, 54);
		panel.add(addUserPanel);
		addUserPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AdminInterface.class.getResource("/images/addUser.png")));
		lblNewLabel_1.setBounds(5, 3, 55, 49);
		addUserPanel.add(lblNewLabel_1);
		
		JLabel addUserLBL = new JLabel("Add User");
		addUserLBL.setForeground(new Color(0, 102, 153));
		addUserLBL.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		addUserLBL.setBackground(new Color(0, 102, 153));
		addUserLBL.setBounds(77, 11, 180, 37);
		addUserPanel.add(addUserLBL);
		
		JPanel LogoutPanel = new JPanel();
		LogoutPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(e.getSource() == LogoutPanel )
					LogoutPanel.setBackground(new Color(0, 200, 200));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(e.getSource() == LogoutPanel )
					LogoutPanel.setBackground(new Color(60, 179, 113));
			}
			public void mouseClicked(MouseEvent e) {
				//JOptionPane.showMessageDialog(null,"hi");
				int rep = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Leave",JOptionPane.YES_NO_OPTION);
				if(rep==0)//si le bouton cliqué est "oui"
				     System.exit(0);
			}
		});
		LogoutPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 153)));
		LogoutPanel.setBackground(new Color(60, 179, 113));
		LogoutPanel.setForeground(SystemColor.text);
		LogoutPanel.setBounds(0, 348, 299, 54);
		panel.add(LogoutPanel);
		LogoutPanel.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(AdminInterface.class.getResource("/images/logout.png")));
		lblNewLabel_1_2.setBounds(0, 3, 51, 46);
		LogoutPanel.add(lblNewLabel_1_2);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setForeground(new Color(0, 102, 153));
		lblLogout.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		lblLogout.setBackground(new Color(0, 102, 153));
		lblLogout.setBounds(77, 11, 180, 37);
		LogoutPanel.add(lblLogout);
		
		JLabel exitLBL = new JLabel("");
		exitLBL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//JOptionPane.showMessageDialog(null,"hi");
				int rep = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Leave",JOptionPane.YES_NO_OPTION);
				if(rep==0)//si le bouton cliqué est "oui"
				     System.exit(0);
			}
		});
		exitLBL.setIcon(new ImageIcon(AdminInterface.class.getResource("/images/exit.png")));
		exitLBL.setBounds(890, 5, 32, 32);
		contentPane.add(exitLBL);
		
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBounds(301, 58, 624, 498);
		contentPane.add(MainPanel);
		MainPanel.setLayout(null);
		
		MainPanel.add(addUser); 
		MainPanel.add(listUsers);
		MainPanel.add(deleteUser);
		changePane(listUsers);
		
		JLabel lblNewLabel_2 = new JLabel("Admin interface");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(539, 2, 183, 55);
		contentPane.add(lblNewLabel_2);
		
	}
	public void changePane(JPanel panel) {
		
		addUser.setVisible(false);
		listUsers.setVisible(false);
		deleteUser.setVisible(false);
		
		panel.setVisible(true);
	}
}
