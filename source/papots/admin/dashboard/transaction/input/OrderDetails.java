package papots.admin.dashboard.transaction.input;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;
import java.util.Date;



public class OrderDetails extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected TransactionInput objInput;
	protected DeliveryDetails objDet; 
	Connection objCon;
	
	//for reference
	private String date;
	String getDate() {
		return date;
	}

	void setDate(String date) {
		this.date = date;
	}

	String getStatus() {
		return status;
	}

	void setStatus(String status) {
		this.status = status;
	}

	private String status;


	/**
	 * Create the dialog.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public OrderDetails() throws SQLException, ClassNotFoundException {
		
		
		//CONNECT DELIVERY DETAILS TO THIS DIALOG
		DeliveryDetails objDetails = new DeliveryDetails();
		objDetails.objOrder = this;
		
		
		setBounds(100, 100, 478, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblorderdate = new JLabel("Order Date:\r\n");
		lblorderdate.setFont(new Font("Tahoma", Font.PLAIN, 25));
		JLabel lblStatus = new JLabel("Order Status:\r\n");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JRadioButton rdbtnOnHand = new JRadioButton("On-Hand");
		rdbtnOnHand.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JRadioButton rdbtnPending = new JRadioButton("Pending");
		rdbtnPending.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JDateChooser calOrder = new JDateChooser();
		
		JButton btnOK = new JButton("OK");
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblorderdate)
						.addComponent(lblStatus))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(rdbtnOnHand)
							.addGap(18)
							.addComponent(rdbtnPending, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addComponent(calOrder, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(58, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(377, Short.MAX_VALUE)
					.addComponent(btnOK)
					.addGap(39))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(calOrder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblorderdate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(43)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStatus)
						.addComponent(rdbtnOnHand)
						.addComponent(rdbtnPending, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addComponent(btnOK)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		
		
		ButtonGroup btStatus = new ButtonGroup();
		btStatus.add(rdbtnOnHand);
		btStatus.add(rdbtnPending);
		
		//CREATE CONNECTION
		createconn();
		
		
		//add action listener to submit
				btnOK.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						try {
							//format Date
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							date = sdf.format(calOrder.getDate());
							
							//get the selected radio button
							status = btStatus.getSelection().getActionCommand();
							
							
							// TODO Auto-generated method stub
							if(rdbtnOnHand.isSelected()) {
								
								
								dispose();
								
								
								//CONNECT DELIVERY DETAILS TO THIS TRANSACTIONINPUT
								objDet = new DeliveryDetails();
								objDet.objInput = objInput;
								objDet.objOrder = OrderDetails.this;
								
								objDet.setVisible(true);
								
							}else if (rdbtnPending.isSelected()){
					
								int OrderStatus = 0;
								
	        					//ADD TO THE DATABASE
	        							
								//Create a Statement object that will allow us to do operation
								Statement objstmt = objCon.createStatement();
	        			                
	        			        //Create the statement that will manipulate data
	        			        String strOp = "INSERT INTO transaction(transaction_no,order_date, supplier_id, order_status,subtotal) VALUES ('"+objInput.getTransaction()+"','"+ date +"','"+objInput.getSupplier()+"', '"+OrderStatus+"', '"+objInput.getGrand_total()+"')";
	        			              
	        			        //insert into the database
	        			        objstmt.execute(strOp);
	        			        objstmt.close();
	        			        
	        			        JOptionPane.showMessageDialog(null,"Successfully Added");
	        			        calOrder.setDate(null);
	        			        btStatus.clearSelection();
	        			        dispose();
	        			        objInput.setGrand_total(0);
	   
							}
							
							calOrder.setDate(null);
        			        btStatus.clearSelection();
        			        dispose();
        			        objInput.setGrand_total(0);
   
								
							
						}catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Invalid input. Please Try Again");
						}
						
					}
				});
						
			
		
		
		
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setLocationRelativeTo(null);
		
		
	
	}
	
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
}
