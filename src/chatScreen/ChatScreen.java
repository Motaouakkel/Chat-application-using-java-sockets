package chatScreen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Rectangle;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import msgManagement.Msg;
import usersManagement.IUserImpDAO;
import usersManagement.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JScrollBar;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.GridBagLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class ChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private User user;
	private JTextArea listMessages;
	private JTextField tf_msg;
	private JLabel SendButton;
	private Socket socket;
	private ObjectOutputStream write ;
	private ObjectInputStream read;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ChatScreen(User user) {
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(380, 20, 907, 680);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Left_Panel = new JPanel();
		Left_Panel.setBackground(SystemColor.controlHighlight);
		Left_Panel.setBounds(0, 0, 345, 680);
		contentPane.add(Left_Panel);
		Left_Panel.setLayout(null);
		
		textField = new JTextField();
		textField.setForeground(SystemColor.controlShadow);
		textField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		textField.setOpaque(false);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.controlShadow));
		textField.setBounds(21, 11, 270, 35);
		Left_Panel.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblSerch = new JLabel("");
		lblSerch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource() == lblSerch) {
					//inst
				}
			}
		});
		lblSerch.setIcon(new ImageIcon(ChatScreen.class.getResource("/images/kindpng_2961646.png")));
		lblSerch.setBounds(290, 11, 34, 35);
		Left_Panel.add(lblSerch);
		
		JLabel Users = new JLabel("Online users");
		Users.setForeground(SystemColor.textHighlight);
		Users.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		Users.setBounds(107, 56, 134, 41);
		Left_Panel.add(Users);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 96, 314, 573);
		Left_Panel.add(scrollPane);
		//recupere la liste des utilisateur en ligne 
		IUserImpDAO control = new IUserImpDAO();
		List<User> lu = control.getOnlineUsers();
		Iterator it = lu.iterator();
		String[] names = new String[100]; 
		int i = 0;
		while(it.hasNext()) {
			User u = ((User) it.next());
			String username = u.getUsername();
			String email = u.getEmail();
			if(!username.equals(user.getUsername())) {
				names[i] = username;
			}
			i++;
		}
		JList list = new JList();
		list.setBorder(null);
		list.setBackground(SystemColor.control);
		list.setForeground(Color.GRAY);
		list.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		list.setModel(new AbstractListModel() {
			String[] values = names;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		//ajouter un scrollPane pour la liste des utilisateurs en ligne
		scrollPane.setViewportView(list);
		
		JLabel refreshIcon = new JLabel("");
		refreshIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IUserImpDAO control = new IUserImpDAO();
				List<User> lu = control.getOnlineUsers();
				Iterator it = lu.iterator();
				String[] names = new String[100]; 
				int i = 0;
				while(it.hasNext()) {
					User u = ((User) it.next());
					String username = u.getUsername();
					String email = u.getEmail();
					if(!username.equals(user.getUsername())) {
						names[i] = username.toUpperCase();
					}
					i++;
				}
				list.setModel(new AbstractListModel() {
					
					String[] values = names;
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
			}
		});
		refreshIcon.setIcon(new ImageIcon(ChatScreen.class.getResource("/images/refresh.png")));
		refreshIcon.setBounds(304, 66, 31, 31);
		Left_Panel.add(refreshIcon);
		
		//DefaultListModel<JPanel> model = new DefaultListModel<>();
		//model.addElement(generateJPanel());
		//model.addElement(generateJPanel());
		//model.addElement(generateJPanel());
		//model.addElement(generateJPanel());
		
		
		
	

		
		
		
		JPanel Right_panel = new JPanel();
		Right_panel.setBackground(SystemColor.controlHighlight);
		Right_panel.setBounds(346, 0, 561, 680);
		contentPane.add(Right_panel);
		Right_panel.setLayout(null);
		
		JPanel NavbarPanel = new JPanel();
		NavbarPanel.setBorder(null);
		NavbarPanel.setBackground(SystemColor.controlHighlight);
		NavbarPanel.setBounds(0, 0, 559, 47);
		Right_panel.add(NavbarPanel);
		NavbarPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rep = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Leave",JOptionPane.YES_NO_OPTION);
				if(rep==0){
					//si le bouton cliqué est "oui"
					control.changeStatus(user.getUserId(), 0);
					System.exit(0);
				}
				     
			}
		});
		lblNewLabel.setIcon(new ImageIcon(ChatScreen.class.getResource("/images/exit.png")));
		lblNewLabel.setBounds(515, 10, 34, 25);
		NavbarPanel.add(lblNewLabel);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(ChatScreen.class.getResource("/images/logo_chatScreen.png")));
		lblLogo.setBounds(10, 5, 57, 42);
		NavbarPanel.add(lblLogo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ChatScreen.class.getResource("/images/phone.png")));
		lblNewLabel_1.setBounds(457, 8, 34, 31);
		NavbarPanel.add(lblNewLabel_1);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setForeground(SystemColor.textHighlight);
		lblUsername.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblUsername.setBounds(77, 33, 255, 14);
		lblUsername.setText(user.getUsername());
		NavbarPanel.add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(SystemColor.textHighlight);
		lblEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblEmail.setBounds(77, 5, 319, 26);
		lblEmail.setText(user.getEmail());
		NavbarPanel.add(lblEmail);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		scrollPane_1.setBounds(10, 58, 541, 565);
		Right_panel.add(scrollPane_1);
		
		 listMessages = new JTextArea();
		 listMessages.setForeground(SystemColor.controlDkShadow);
		 listMessages.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		scrollPane_1.setViewportView(listMessages);
		
		
		//MatteBorder : définir border 
		tf_msg = new JTextField();
		tf_msg.setBackground(SystemColor.text);
		tf_msg.setBorder(new MatteBorder(1, 1, 1, 0, (Color) SystemColor.textHighlight));
		tf_msg.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		tf_msg.setBounds(10, 624, 499, 45);
		Right_panel.add(tf_msg);
		tf_msg.setColumns(10);
		
		
		SendButton = new JLabel("");
		SendButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tf_msg.getText()!="") {
					//int msgId, String contentMsg, int userId, String sender
					Msg msg = new Msg(1,tf_msg.getText(),user.getUserId(),user.getUsername());
					sendMessage(msg);
					tf_msg.setText("");
				}
			}
		});
		SendButton.setBorder(new MatteBorder(1, 0, 1, 1, (Color) SystemColor.textHighlight));
		SendButton.setOpaque(true);
		SendButton.setForeground(SystemColor.text);
		SendButton.setBackground(SystemColor.text);
		SendButton.setIcon(new ImageIcon(ChatScreen.class.getResource("/images/sendMsg.png")));
		SendButton.setBounds(509, 624, 42, 45);
		Right_panel.add(SendButton);
		
		
		 
		
		
		// socket 
		
		try {
			this.socket = new Socket("localhost", 1234);
			this.read = new ObjectInputStream(socket.getInputStream());
			this.write = new ObjectOutputStream(socket.getOutputStream());
			Msg msg = new Msg(1,"",user.getUserId(),user.getUsername());
			sendMessage(msg);
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// HERE
	}
	
	private JPanel generateJPanel(){
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 514, 315, 41);

		
		JLabel lblNewLabel_3 = new JLabel("Text");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_3);
		
		return panel_1;
	}
	
	public void sendMessage(Msg msg) {
		try {
			 write.writeObject(msg);
			 write.flush();
		 }catch(IOException e) {
			 CloseAll(socket,read,write);
		 }
	}
	
	public void listenForMesagges() {
		new Thread(new Runnable() {
			public void run() {
				Msg msg;
				while(socket.isConnected()) {
					try {
						msg = (Msg) read.readObject();
						
						// here you cane add message to chat screen
						String msgToShow = msg.getSender()+" : "+msg.getContentMsg();
						//System.out.println(msgToShow);
						listMessages.setText(listMessages.getText().trim()+"\n"+msgToShow);
						
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						//CloseAll(socket, read, write);
					}
				}
			}
		}).start();
	}
	
	public void CloseAll(Socket socket,ObjectInputStream read,ObjectOutputStream write) {
		try {
			if(this.read != null) {
				read.close();
			}
			if(this.write != null) {
				write.close();
			}
			if(this.socket != null) {
				socket.close();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		/**/EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IUserImpDAO ob = new IUserImpDAO();
					
					User u = ob.getUser(316);
					ChatScreen frame = new ChatScreen(u);
					frame.setVisible(true);
					frame.listenForMesagges();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
