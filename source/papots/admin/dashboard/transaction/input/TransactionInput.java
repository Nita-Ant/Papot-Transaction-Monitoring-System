package papots.admin.dashboard.transaction.input;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class TransactionInput extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TransactionInput() {
		setBackground(new Color(255, 204, 204));
		setMinimumSize(new Dimension(540, 10));
		setMaximumSize(new Dimension(540, 32767));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel jpnlTransactionsHeader = new JPanel();
		jpnlTransactionsHeader.setMinimumSize(new Dimension(10, 100));
		jpnlTransactionsHeader.setMaximumSize(new Dimension(50000, 100));
		jpnlTransactionsHeader.setBackground(new Color(255, 204, 255));
		add(jpnlTransactionsHeader);
		GridBagLayout gbl_jpnlTransactionsHeader = new GridBagLayout();
		gbl_jpnlTransactionsHeader.columnWidths = new int[]{0, 0, 0};
		gbl_jpnlTransactionsHeader.rowHeights = new int[]{0, 23, 0, 0};
		gbl_jpnlTransactionsHeader.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_jpnlTransactionsHeader.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpnlTransactionsHeader.setLayout(gbl_jpnlTransactionsHeader);
		
		JLabel lblNewLabel = new JLabel("Transactions Form");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		jpnlTransactionsHeader.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		lblNewLabel.setForeground(Color.BLACK);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the necessary attirbutes before submitting the form.");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		jpnlTransactionsHeader.add(lblNewLabel_1, gbc_lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Segoe UI Semilight", Font.ITALIC, 12));
		
		JPanel jpnlTransactionsForm = new JPanel();
		jpnlTransactionsForm.setMaximumSize(new Dimension(32767, 1000));
		jpnlTransactionsForm.setBackground(new Color(255, 204, 204));
		add(jpnlTransactionsForm);
		jpnlTransactionsForm.setLayout(new BoxLayout(jpnlTransactionsForm, BoxLayout.X_AXIS));
		
		

	}
}
