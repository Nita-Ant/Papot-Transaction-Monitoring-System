package papots.admin.dashboard.transaction.input;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class TransactionInput extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TransactionInput() {
		setBackground(new Color(255, 204, 204));
		setMinimumSize(new Dimension(540, 10));
		setMaximumSize(new Dimension(540, 32767));
		setLayout(null);
		
		JLabel lblTransactions = new JLabel("TRANSACTIONS");
		lblTransactions.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		lblTransactions.setBounds(20, 11, 228, 26);
		add(lblTransactions);
		
		table = new JTable();
		table.setBounds(20, 48, 266, 466);
		add(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(296, 93, 346, 233);
		add(panel);

	}
}
