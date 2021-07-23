package papots.admin.dashboard.transaction.input;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.function.Supplier;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import papots.admin.main.dashboard.MainFrame;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;


import net.proteanit.sql.DbUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ListSelectionModel;





public class TransactionInput extends JPanel {
	
	private int transaction_no = 7;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Dashboard that owns the panel
	 */
	protected MainFrame mainFrame;
	private JTable tblproducts;
	private JComboBox cmbSupplier; 
	protected JTable order;
	private int intQty = 0;
	private float fltPrice = 0;
	
	protected JButton btnSubmit;
	
	//for reference
	private String transaction;
	private String supplier;
	private float grand_total = 0;
	
	
	String getTransaction() {
		return transaction;
	}


	void setTransaction(String transaction) {
		this.transaction = transaction;
	}


	String getSupplier() {
		return supplier;
	}


	void setSupplier(String supplier) {
		this.supplier = supplier;
	}


	float getGrand_total() {
		return grand_total;
	}


	void setGrand_total(float grand_total) {
		this.grand_total = grand_total;
	}

	
	
	int getIntQty() {
		return intQty;
	}


	void setIntQty(int intQty) {
		this.intQty = intQty;
	}


	float getFltPrice() {
		return fltPrice;
	}


	void setFltPrice(float fltPrice) {
		this.fltPrice = fltPrice;
	}

	Connection objCon;
	

	/**
	 * Create the panel.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public TransactionInput() throws SQLException, ClassNotFoundException {
		
		try {
			createconn();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//CONNECT ORDER DETAILS TO THIS FORM
		OrderDetails objOrder = new OrderDetails();
		objOrder.objInput = this;
		
		
		
		setBackground(new Color(255, 204, 204));
		setMinimumSize(new Dimension(750, 10));
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
		
	
		
		
		//add table 
		tblproducts = new JTable();
		tblproducts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblproducts.setFillsViewportHeight(true);
		tblproducts.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		
		
		
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
		
		order = new JTable();
		order.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product ID", "QTY", "Unit Price", "Total Price"
			}
		));
		order.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		order.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		
		
		cmbSupplier = new JComboBox();
		cmbSupplier.setBounds(0, 317, 300, 25);
		jpnlTransactionCheckout.add(cmbSupplier);
		
		//ADD DATA TO THE COMBO BOX 
		FillCombo();
		supplier = (String) cmbSupplier.getSelectedItem();
		
		btnSubmit = new JButton("Submit Form");
		btnSubmit.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnSubmit.setBounds(103, 353, 101, 23);
		jpnlTransactionCheckout.add(btnSubmit);
		
		JLabel lblNewLabel_3 = new JLabel("Supplier");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_3.setBounds(0, 293, 68, 25);
		jpnlTransactionCheckout.add(lblNewLabel_3);
		
		JLabel lblnametotal = new JLabel("TOTAL:");
		lblnametotal.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblnametotal.setBounds(0, 227, 135, 25);
		jpnlTransactionCheckout.add(lblnametotal);
		
		JLabel lblTotal = new JLabel("");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTotal.setBounds(103, 227, 168, 25);
		jpnlTransactionCheckout.add(lblTotal);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		jpnlTransactionCheckout.add(scrollPane_1);
		scrollPane_1.setViewportView(order);
		scrollPane_1.setBounds(0, 25, 300, 193);
		
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
		
		DlgAsk objDlg = new DlgAsk();
		objDlg.objInput = this;
		
		//ADD DATA TO THE PRODUCT TABLE
		
			//Create a Statement object that will allow us to do operation
        	Statement objstmt = objCon.createStatement();
        
        	String query = "SELECT * from products";
        	ResultSet rs = objstmt.executeQuery(query);
        	tblproducts.setModel(DbUtils.resultSetToTableModel(rs));
        	objstmt.close();
        	rs.close();
        

        //ADD SCROLL PANE TO PRODUCTS TABLE
    		JScrollPane scrollPane = new JScrollPane();
    		jpnlProductsTable.add(scrollPane, "name_351323148101700");
    		scrollPane.setViewportView(tblproducts);
    		
    	//SET BUTTON SUBMIT FORM TO DISABLED
    		 btnSubmit.setEnabled(false);
    		
    		
    	//SHOW DIALOG FOR QUANTITY AND PRICE UPON SELECTING ROW
    		
    		ListSelectionModel model = tblproducts.getSelectionModel();
    		model.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					
					if(e.getValueIsAdjusting())
						return;	//Check if it is being modified!
		      		
					objDlg.setVisible(true);
					btnSubmit.setEnabled(true);
					
					//ADDING ROW IN ORDER TABLE
					if(intQty != 0 || fltPrice != 0.00) { 
						
					 DefaultTableModel Ordermodel = (DefaultTableModel)order.getModel();
					 int selectedRowIndex = tblproducts.getSelectedRow();
					 float total = intQty*fltPrice;
					 Ordermodel.addRow(new Object[] {(tblproducts.getValueAt(selectedRowIndex, 0)), intQty, fltPrice, total} );
					 
					 grand_total+=total;
					 lblTotal.setText(Float.toString(grand_total));
					}
					
					
				}
    
    		});
    		
    		
    		
    		//FUNCTIONALITY FOR SUBMIT FORM BUTTON
    		
    		//add action listener to submit
    		btnSubmit.addActionListener(new ActionListener() {
    			 public void actionPerformed(ActionEvent evt) {
    	                
    						
    						try {
    							
    							//SUPPLY COST PRICE
    							Date d = new Date();
    							int Year = d.getYear() + 1900;
    							String no = String.format("%04d", transaction_no);
    							transaction = Year + "-" + no;
    							
    							int row = order.getRowCount();
    							
    							for (int j = 0; j  < row; j++) {
    								
    								String Prod_ID = (String)order.getValueAt(j, 0);
    								int intQTY = (int) order.getValueAt(j, 1);
    								float fltprice = (float) order.getValueAt(j, 2);
    								float fltTotal = (float) order.getValueAt(j, 3);
    								
    								
    								//ADD TO THE DATABASE
    								
    								//Create a Statement object that will allow us to do operation
    				                Statement objstmt = objCon.createStatement();
    				                
    				                //Create the statement that will manipulate data
    				                String strOp = "INSERT INTO supplycostprice(transaction_no,product_id,product_qty,unit_price,total_prod_price) VALUES ('"+transaction+"', '"+Prod_ID+"', '"+intQTY+"', '"+fltprice+"', '"+fltTotal+"')";
    				                
    				                //insert into the database
    				                objstmt.execute(strOp);
    				                objstmt.close();
    							}
    							DefaultTableModel model = (DefaultTableModel) order.getModel();
    							model.setRowCount(0);
    							objOrder.setVisible(true); btnSubmit.setEnabled(false);
						        lblTotal.setText("");
						        ++transaction_no;
						        
    							
    							
    							
    						} catch (Exception ex) {
    							JOptionPane.showMessageDialog(null, "Invalid Input. Please Try Again");
    							DefaultTableModel model = (DefaultTableModel) order.getModel();
    							model.setRowCount(0);
    							objOrder.setVisible(true); btnSubmit.setEnabled(false);
						        lblTotal.setText("");
    						}
    						
    						}
    	            
    			 
    		
    		    });
    		
    		
    		
    		
	}//public TransactionInput() throws SQLException
	
	
	
	
	void createconn() throws ClassNotFoundException{
	    try {
	        
	            //load the driver
	           Class.forName("com.mysql.cj.jdbc.Driver");
	           
	           //connect to the database
	           objCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/papot-db", "root", "haycab99");
	           
	           
	    }catch(SQLException ex) {
	    	JOptionPane.showMessageDialog(null,ex);
	    }
	
	}
	
	 
	 //ADD DATA IN SUPPLIER COMBO BOX
	 
	 private void FillCombo() {
		
		 try {
			//Create a Statement object that will allow us to do operation
	         Statement objstmt = objCon.createStatement();
	         
	         //Create the statement that will manipulate data
	         String query = "SELECT supplier_id FROM supplier";
	         
	        ResultSet rs = objstmt.executeQuery(query);
	 		
	        while(rs.next()) {
	        	String name = rs.getString(1);
				cmbSupplier.addItem(name);
	        }
	       
	 		objstmt.close();
	 		rs.close();
	         
	         
		 }catch(SQLException ex) {
		    	JOptionPane.showMessageDialog(null,ex);
		    }
		 
	 }
}
