package papots.admin.main.dashboard;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Sidebar panel of the whole application.
 * @author Elmer M. Cuenca
 *
 */

public class Sidebar extends JPanel {
	
	/**
	 * Default Serial Version UID (for serializability, not important, placed to remove warnings)
	 */
	private static final long serialVersionUID = 1L;
  
	private MainFrame mainFrame;

	/**
	 * Create the panel.
	 */
	public Sidebar() {
		setPreferredSize(new Dimension(250, 480));
		
		setMinimumSize(new Dimension(250, 10));
		setMaximumSize(new Dimension(250, 32767));
		setBackground(Color.PINK);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Papot's Toy Club");
		lblNewLabel.setBounds(10, 23, 113, 20);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("System");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 69, 141, 26);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Monitoring");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 43, 141, 26);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Main Menu");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_3.setBounds(10, 163, 78, 14);
		add(lblNewLabel_3);
		/* END OF Left Sidebar */
		
		/**
		 * jbtnMonitoring - button for showing the main dashboard
		 * NOTE: This feature is not live yet  
		 * -- @author Elmer M. Cuenca*/
		JButton jbtnMonitoring = new JButton("Monitoring Dashboard");
		jbtnMonitoring.setBorder(null);
		jbtnMonitoring.setBackground(Color.PINK);
		jbtnMonitoring.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnMonitoring.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jbtnMonitoring.setForeground(new Color(255, 255, 255));
		jbtnMonitoring.setBounds(10, 188, 230, 23);
		//Action Listener Code for Transaction Dashboard Status
				jbtnMonitoring.addActionListener(event -> {
					mainFrame.showTransactionsDashboard();
				});
		add(jbtnMonitoring);
		/* END OF jbtnMonitroing */
		
		/**
		 * jbtnTransactionInput - button for showing the Transaction Input Form panel
		 * 
		 */
		JButton jbtnTransactionInput = new JButton("Transaction Input");
		jbtnTransactionInput.setBorder(null);
		jbtnTransactionInput.setBackground(Color.PINK);
		jbtnTransactionInput.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnTransactionInput.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jbtnTransactionInput.setForeground(new Color(255, 255, 255));
		jbtnTransactionInput.setBounds(10, 222, 230, 23);
		
		//Action Listener Code for Transaction Input 
		jbtnTransactionInput.addActionListener(event -> {
			try {
				mainFrame.showTransactionsForm();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		add(jbtnTransactionInput);
		/* END OF jbtnTransactionInput */
		
		/*
		 * jbtnProducts - button for the Products form.
		 */
		JButton jbtnProducts = new JButton("Products");
		jbtnProducts.setBorder(null);
		jbtnProducts.setBackground(Color.PINK);
		jbtnProducts.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnProducts.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jbtnProducts.setForeground(new Color(255, 255, 255));
		jbtnProducts.setBounds(10, 256, 230, 23);
		// Action Listener for jbtnProducts 
		jbtnProducts.addActionListener(event -> {
			mainFrame.showProductsForm();
		});
		add(jbtnProducts);
		/* END OF jbtnProducst */
		
		JButton jbtnSuppliers = new JButton("Suppliers");
		jbtnSuppliers.setBorder(null);
		jbtnSuppliers.setBackground(Color.PINK);
		jbtnSuppliers.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnSuppliers.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jbtnSuppliers.setForeground(new Color(255, 255, 255));
		jbtnSuppliers.setBounds(10, 290, 230, 23);
		// Action Listener for jbtnProducts 
		jbtnSuppliers.addActionListener(event -> {
					mainFrame.showSuppliersForm();
		});
		add(jbtnSuppliers);
		
		JButton jbtnExit = new JButton("Exit");
		jbtnExit.setHorizontalAlignment(SwingConstants.RIGHT);
		jbtnExit.setBorder(null);
		jbtnExit.setBackground(Color.PINK);
		jbtnExit.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jbtnExit.setForeground(new Color(255, 255, 255));
		jbtnExit.setBounds(151, 446, 89, 23);
		add(jbtnExit);
		
		JLabel lblNewLabel_4 = new JLabel("Hello, admin!");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Segoe UI Light", Font.ITALIC, 11));
		lblNewLabel_4.setBounds(10, 106, 131, 14);
		add(lblNewLabel_4);
		
		Component hsMidMargin = Box.createHorizontalStrut(20);
		hsMidMargin.setMinimumSize(new Dimension(10, 0));
		hsMidMargin.setMaximumSize(new Dimension(10, 32767));
		add(hsMidMargin);

	}
	
	
	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
}
