package papots.admin.dashboard.transaction.input;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class DlgAsk extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtQty;
	private JTextField txtPrice;
	protected TransactionInput objInput;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public DlgAsk() {
		
		//SETTING THE DIALOG
		this.setModal(true);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);	
		
		setBounds(100, 100, 396, 325);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblQty = new JLabel("Quantity:");
		lblQty.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel = new JLabel("Unit Price:\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		txtQty = new JTextField();
		txtQty.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtQty.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPrice.setColumns(10);
		
		JButton btnAdd = new JButton("OK");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		//SET THE INT AND QTY
		btnAdd.addActionListener(new ActionListener() {
		
		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				//check if it fits the constraints
				
				
					if ((Integer.parseInt(txtQty.getText()) > 0 && Integer.parseInt(txtQty.getText()) <= 9999) ||  (Float.parseFloat(txtPrice.getText()) >= 0.01 && Float.parseFloat(txtPrice.getText()) <= 9999.70)) {
						objInput.setIntQty(Integer.parseInt(txtQty.getText()));
						objInput.setFltPrice(Float.parseFloat(txtPrice.getText()));
						dispose();
						txtQty.setText("");
						txtPrice.setText("");
						
					}else {
						JOptionPane.showMessageDialog(null, "Invalid Input . Please try again");
					}
				}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblQty)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtQty, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(60, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(301, Short.MAX_VALUE)
					.addComponent(btnAdd)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(84)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQty, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtQty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(btnAdd)
					.addGap(26))
		);
		contentPanel.setLayout(gl_contentPanel);
		
			        
		
		
	}

	
	
}
