package papots.admin.dashboard.transaction.input;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;

public class DeliveryDetails extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMOD;
	private JTextField txtShipFee;
	protected TransactionInput objInput;
	protected OrderDetails objOrder;
	Connection objCon;

	
	public DeliveryDetails() throws ClassNotFoundException {
		setBounds(100, 100, 452, 326);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblMOD = new JLabel("Date Received:");
		lblMOD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblReceived = new JLabel("Mode of Delivery:");
		lblReceived.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblShipfee = new JLabel("Shipping Fee:");
		lblShipfee.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JDateChooser calReceived = new JDateChooser();
		
		txtMOD = new JTextField();
		txtMOD.setColumns(10);
		
		txtShipFee = new JTextField();
		txtShipFee.setColumns(10);
		
		JButton btnOK = new JButton("OK");
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblShipfee)
						.addComponent(lblReceived)
						.addComponent(lblMOD))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtMOD)
						.addComponent(calReceived, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtShipFee, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(357, Short.MAX_VALUE)
					.addComponent(btnOK)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(calReceived, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblMOD, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(29)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblReceived)
						.addComponent(txtMOD, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblShipfee)
						.addComponent(txtShipFee, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(btnOK)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		
		//CREATE CONNECTION
		createconn();
				
		
		//add action listener to btnOK
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					int OrderStatus = 1;
					
					//format Date
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(calReceived.getDate());
					
					
					//CHECKING OF VALIDATION OF DATES
					
		            if (date.compareTo(objOrder.getDate()) < 0) {
		                JOptionPane.showMessageDialog(null, "Invalid Date. Please try again");
		                calReceived.setDate(null);
				        txtShipFee.setText("");
				        txtMOD.setText("");
		            } else {
		            	//GET THE SHIP_FEE
						float ShipFee = Float.parseFloat(txtShipFee.getText());
						
						//GET MOD
						String MOD = txtMOD.getText();
						
						//GET GRAND TOTAL
						float grand_total = objInput.getGrand_total() + ShipFee;
						
						//ADD TO THE DATABASE		
						//Create a Statement object that will allow us to do operation
						Statement objstmt = objCon.createStatement();
				                
				        //Create the statement that will manipulate data
				        String strOp = "INSERT INTO transaction(transaction_no,order_date, supplier_id, mode_of_delivery,order_status,date_received,subtotal,ship_fee,grand_total) VALUES ('"+objInput.getTransaction()+"','"+ objOrder.getDate()
				        +"','"+objInput.getSupplier()+"', '"+MOD+"','"+OrderStatus+"', '"+date+"','"+objInput.getGrand_total()+"', '"+ShipFee+"', '"+grand_total+"')";
				              
				        //insert into the database
				        objstmt.execute(strOp);
				        objstmt.close();
				        
				        JOptionPane.showMessageDialog(null,"Successfully Added");
				        calReceived.setDate(null);
				        txtShipFee.setText("");
				        txtMOD.setText("");
				        dispose();
				        objInput.setGrand_total(0);
		            }
					
					
					
					

						
					
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
				}
				
			}
		});
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setModal(true);
	
	}
	void createconn() throws ClassNotFoundException{
	    try {
	        
	            //load the driver
	           Class.forName("com.mysql.cj.jdbc.Driver");
	           
	           //connect to the database
	           objCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/papot-db", "root", "haycab99");
	           
	           
	    }catch(SQLException ex) {
	    	JOptionPane.showMessageDialog(null,"Invalid input. Please try again.");
	    }
	
	}
}
