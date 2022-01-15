package admin;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DeleteUserPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	/**
	 * Create the panel.
	 */
	public DeleteUserPanel() {
		
		setLayout(null);
		this.setBounds(0, 0, 622, 496);
		setVisible(true);
		JLabel lblNewLabel = new JLabel("Delete User ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBounds(216, 201, 259, 117);
		add(lblNewLabel);
	}
}
