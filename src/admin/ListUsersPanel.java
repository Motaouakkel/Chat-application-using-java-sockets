package admin;

import java.awt.Font;
import java.awt.SystemColor;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument.Iterator;

import usersManagement.IUserImpDAO;
import usersManagement.User;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListUsersPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
public ListUsersPanel() {
		
		setLayout(null);
		this.setBounds(0, 0, 622, 496);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 602, 441);
		add(scrollPane);
		
		table = new JTable();
		table.setOpaque(false);
		table.setForeground(Color.GRAY);
		table.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User ID", "Username", "Email", "Last login", "Status"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(57);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(81);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(140);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(95);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(78);
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refrechTable( model);
			}
		});
		
		    
		
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		btnNewButton.setBounds(491, 10, 121, 23);
		add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete User");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int column = 0;
				int row = -1; 
				row = table.getSelectedRow();
				String value = table.getModel().getValueAt(row, column).toString();
				String username = table.getModel().getValueAt(row, 1).toString();
				int userID = Integer.parseInt(value);
				IUserImpDAO control = new IUserImpDAO();
				
				int rep = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete user ("+username+") ?","Delete User",JOptionPane.YES_NO_OPTION);
				if(rep==0)
					control.dropUser(userID);
				if(row == -1) 
					JOptionPane.showMessageDialog(null,"No user has been selected.","Selecte user",JOptionPane.WARNING_MESSAGE); 
				refrechTable( model);
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		btnDelete.setBackground(SystemColor.textHighlight);
		btnDelete.setBounds(345, 10, 121, 23);
		add(btnDelete);
		setVisible(true);
		
		
		refrechTable( model);
	}
	private void refrechTable(DefaultTableModel model) {
		model.setRowCount(0);
		IUserImpDAO control = new IUserImpDAO();
		List<User> lu = control.getUsers();
		java.util.Iterator<User> it = lu.iterator();
		while(it.hasNext()) {
			User u = it.next();
			String status = "Offline";
			if(u.isOnline()==1) status = "Online";
			model.addRow(new Object[]{u.getUserId(), u.getUsername(), u.getEmail(),  u.getLastLogin(), status});
		}
	}
}
