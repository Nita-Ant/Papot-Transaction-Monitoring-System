package papots.admin.dashboard.transaction.input;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import papots.admin.main.dashboard.MainFrame;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class TransactionInput extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Dashboard that owns the panel
	 */
	protected MainFrame mainFrame;
	private JTable table;
	private JTable table_1;

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
		jpnlTransactionsHeader.setBackground(new Color(255, 204, 204));
		add(jpnlTransactionsHeader);
		GridBagLayout gbl_jpnlTransactionsHeader = new GridBagLayout();
		gbl_jpnlTransactionsHeader.columnWidths = new int[]{0, 0};
		gbl_jpnlTransactionsHeader.rowHeights = new int[]{0, 23, 0, 10, 0};
		gbl_jpnlTransactionsHeader.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_jpnlTransactionsHeader.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpnlTransactionsHeader.setLayout(gbl_jpnlTransactionsHeader);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0, 15));
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.fill = GridBagConstraints.BOTH;
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 0;
		jpnlTransactionsHeader.add(verticalStrut, gbc_verticalStrut);
		
		JLabel lblNewLabel = new JLabel("Transactions Form");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		jpnlTransactionsHeader.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.BLACK);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the necessary attirbutes before submitting the form.");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		jpnlTransactionsHeader.add(lblNewLabel_1, gbc_lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Segoe UI Semilight", Font.ITALIC, 12));
		
		Component verticalGlue = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue = new GridBagConstraints();
		gbc_verticalGlue.fill = GridBagConstraints.VERTICAL;
		gbc_verticalGlue.gridx = 0;
		gbc_verticalGlue.gridy = 3;
		jpnlTransactionsHeader.add(verticalGlue, gbc_verticalGlue);
		
		JPanel jpnlTransactionsForm = new JPanel();
		jpnlTransactionsForm.setMaximumSize(new Dimension(32767, 1000));
		jpnlTransactionsForm.setBackground(new Color(255, 204, 204));
		add(jpnlTransactionsForm);
		jpnlTransactionsForm.setLayout(new BoxLayout(jpnlTransactionsForm, BoxLayout.X_AXIS));
		
		JPanel jpnlProductsTable = new JPanel();
		jpnlProductsTable.setPreferredSize(new Dimension(35, 10));
		jpnlProductsTable.setMinimumSize(new Dimension(25, 10));
		jpnlProductsTable.setMaximumSize(new Dimension(35000, 32767));
		jpnlProductsTable.setBackground(new Color(255, 204, 204));
		jpnlTransactionsForm.add(jpnlProductsTable);
		jpnlProductsTable.setLayout(new CardLayout(0, 0));
		
		table = new JTable();
		jpnlProductsTable.add(table, "name_71879449788400");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setPreferredSize(new Dimension(5, 0));
		horizontalStrut_1.setMinimumSize(new Dimension(5, 0));
		horizontalStrut_1.setMaximumSize(new Dimension(5, 32767));
		jpnlTransactionsForm.add(horizontalStrut_1);
		
		JPanel jpnlTransactionCheckout = new JPanel();
		jpnlTransactionCheckout.setAlignmentX(Component.LEFT_ALIGNMENT);
		jpnlTransactionCheckout.setPreferredSize(new Dimension(300, 100));
		jpnlTransactionCheckout.setMinimumSize(new Dimension(350, 10000));
		jpnlTransactionCheckout.setMaximumSize(new Dimension(350, 32767));
		jpnlTransactionCheckout.setBackground(new Color(255, 204, 204));
		jpnlTransactionsForm.add(jpnlTransactionCheckout);
		jpnlTransactionCheckout.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Transaction Order/s");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_2.setBounds(145, 0, 155, 25);
		jpnlTransactionCheckout.add(lblNewLabel_2);
		
		table_1 = new JTable();
		table_1.setBounds(0, 23, 300, 193);
		jpnlTransactionCheckout.add(table_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(0, 269, 300, 25);
		jpnlTransactionCheckout.add(comboBox);
		
		JButton btnNewButton = new JButton("Submit Form");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton.setBounds(103, 348, 101, 23);
		jpnlTransactionCheckout.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Supplier");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_3.setBounds(0, 240, 68, 25);
		jpnlTransactionCheckout.add(lblNewLabel_3);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setPreferredSize(new Dimension(10, 0));
		horizontalStrut.setMaximumSize(new Dimension(10, 32767));
		horizontalStrut.setMinimumSize(new Dimension(10, 0));
		jpnlTransactionsForm.add(horizontalStrut);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setMaximumSize(new Dimension(32767, 10));
		verticalStrut_1.setMinimumSize(new Dimension(0, 10));
		verticalStrut_1.setPreferredSize(new Dimension(0, 10));
		add(verticalStrut_1);
		
		

	}
}
