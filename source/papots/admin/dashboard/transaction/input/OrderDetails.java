package papots.admin.dashboard.transaction.input;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;

public class OrderDetails extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OrderDetails dialog = new OrderDetails();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OrderDetails() {
		setBounds(100, 100, 439, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblorderdate = new JLabel("Order Date:\r\n");
		lblorderdate.setFont(new Font("Tahoma", Font.PLAIN, 25));
		JLabel lblStatus = new JLabel("Order Status:\r\n");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JRadioButton rdbtnOnHand = new JRadioButton("On-Hand");
		rdbtnOnHand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JRadioButton rdbtnPending = new JRadioButton("Pending");
		rdbtnPending.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JDateChooser calOrder = new JDateChooser();
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
							.addComponent(rdbtnPending, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addComponent(calOrder, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(37, Short.MAX_VALUE))
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
					.addContainerGap(64, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
