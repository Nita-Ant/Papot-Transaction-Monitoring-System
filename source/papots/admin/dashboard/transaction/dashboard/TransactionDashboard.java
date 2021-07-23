package papots.admin.dashboard.transaction.dashboard;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

public class TransactionDashboard extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblPendingOrders;
	private JTable tblOnHandOrders;
	
	Connection objConn; 

	/**
	 * Create the panel.
	 */
	public TransactionDashboard() {
		setBackground(new Color(255, 204, 204));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel jpnlTitleHEader = new JPanel();
		jpnlTitleHEader.setMinimumSize(new Dimension(10, 100));
		jpnlTitleHEader.setMaximumSize(new Dimension(32767, 100));
		jpnlTitleHEader.setBackground(new Color(255, 204, 204));
		add(jpnlTitleHEader);
		GridBagLayout gbl_jpnlTitleHEader = new GridBagLayout();
		gbl_jpnlTitleHEader.columnWidths = new int[]{0, 0, 0};
		gbl_jpnlTitleHEader.rowHeights = new int[]{0, 0, 0, 0};
		gbl_jpnlTitleHEader.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_jpnlTitleHEader.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpnlTitleHEader.setLayout(gbl_jpnlTitleHEader);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 0;
		jpnlTitleHEader.add(verticalStrut, gbc_verticalStrut);
		
		JLabel lblNewLabel = new JLabel("Transaction Status Dashboard\r\n");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		jpnlTitleHEader.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Checks the transaction status");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		jpnlTitleHEader.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 500));
		panel.setBackground(new Color(255, 204, 204));
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 43, 498, 128);
		panel.add(scrollPane);
		
		tblPendingOrders = new JTable();
		scrollPane.setViewportView(tblPendingOrders);
		
		JLabel lblNewLabel_2 = new JLabel("Pending Orders");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblNewLabel_2.setBounds(0, 11, 204, 36);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("On Hand Orders");
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setBounds(262, 182, 236, 30);
		panel.add(lblNewLabel_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 216, 498, 146);
		panel.add(scrollPane_1);
		
		tblOnHandOrders = new JTable();
		scrollPane_1.setViewportView(tblOnHandOrders);
		
		//Database connection 
		
		try {
			// initialize database connection
			createconn();

		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		JButton jbtnRefreshPendingTable = new JButton("Refresh");
		jbtnRefreshPendingTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		jbtnRefreshPendingTable.setBounds(407, 11, 89, 23);
		jbtnRefreshPendingTable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Action Listener for refresh Button for Pending Orders
				try {
					Statement objStmt = objConn.createStatement();
					
					String strQuery = "SELECT transaction_no, order_date, supplier_id, mode_of_delivery, grand_total"
										+ "FROM transaction"
										+ "WHERE order_status = '0';";
					
					ResultSet rsPendingTable = objStmt.executeQuery(strQuery);
					tblPendingOrders.setModel(DbUtils.resultSetToTableModel(rsPendingTable));
					
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		panel.add(jbtnRefreshPendingTable);
		
		JButton jbtnRefreshOHOrders = new JButton("Refresh");
		jbtnRefreshOHOrders.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		jbtnRefreshOHOrders.setBounds(0, 182, 89, 23);
		jbtnRefreshOHOrders.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Action Listener for refresh Button for On Hand Orders
				try {
					Statement objStmt = objConn.createStatement();
					
					String strQuery = "SELECT transaction_no, order_date, supplier_id, mode_of_delivery, grand_total"
										+ "FROM transaction"
										+ "WHERE order_status = '1';";
					
					ResultSet rsOHOrdersTable = objStmt.executeQuery(strQuery);
					tblOnHandOrders.setModel(DbUtils.resultSetToTableModel(rsOHOrdersTable));
					
					// Close connections 
					rsOHOrdersTable.close();
					objStmt.close();
					
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		panel.add(jbtnRefreshOHOrders);

	}
	
	void createconn() throws ClassNotFoundException{
	    try {

	            //load the driver
	           Class.forName("com.mysql.cj.jdbc.Driver");

	           //connect to the database
	           objConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/papot-db", "root", "haycab99");


	    }catch(SQLException ex) {
	    	JOptionPane.showMessageDialog(null,ex);
	    }

	}
}
