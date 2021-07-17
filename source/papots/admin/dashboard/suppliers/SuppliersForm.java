package papots.admin.dashboard.suppliers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import papots.admin.main.dashboard.MainFrame;

public class SuppliersForm extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField jtxtfldSupplierID;
	private JTextField jtxtfldSupplierName;
	private JTextField jtxtfldSupplierAddress;
	
	/**
	 * Dashboard that owns the panel
	 */
	protected MainFrame mainFrame;

	/**
	 * Create the panel.
	 */
	public SuppliersForm() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel jpnlSuppilersHeader = new JPanel();
		jpnlSuppilersHeader.setMaximumSize(new Dimension(32767, 3000));
		jpnlSuppilersHeader.setBackground(new Color(255, 204, 204));
		add(jpnlSuppilersHeader);
		GridBagLayout gbl_jpnlSuppilersHeader = new GridBagLayout();
		gbl_jpnlSuppilersHeader.columnWidths = new int[]{0, 0, 0};
		gbl_jpnlSuppilersHeader.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_jpnlSuppilersHeader.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_jpnlSuppilersHeader.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpnlSuppilersHeader.setLayout(gbl_jpnlSuppilersHeader);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setMinimumSize(new Dimension(0, 50));
		verticalStrut_1.setPreferredSize(new Dimension(0, 50));
		verticalStrut_1.setSize(new Dimension(0, 50));
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 0;
		jpnlSuppilersHeader.add(verticalStrut_1, gbc_verticalStrut_1);
		
		JLabel jlblHeaderTitle = new JLabel("Suppliers Form");
		jlblHeaderTitle.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		GridBagConstraints gbc_jlblHeaderTitle = new GridBagConstraints();
		gbc_jlblHeaderTitle.anchor = GridBagConstraints.WEST;
		gbc_jlblHeaderTitle.insets = new Insets(0, 0, 5, 0);
		gbc_jlblHeaderTitle.gridx = 1;
		gbc_jlblHeaderTitle.gridy = 1;
		jpnlSuppilersHeader.add(jlblHeaderTitle, gbc_jlblHeaderTitle);
		
		JLabel lblNewLabel = new JLabel("Please complete the form before submitting.");
		lblNewLabel.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		jpnlSuppilersHeader.add(lblNewLabel, gbc_lblNewLabel);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setMinimumSize(new Dimension(0, 8));
		verticalStrut.setMaximumSize(new Dimension(32767, 8));
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 3;
		jpnlSuppilersHeader.add(verticalStrut, gbc_verticalStrut);
		
		JPanel jpnlSuppliersForm = new JPanel();
		jpnlSuppliersForm.setMinimumSize(new Dimension(10, 200));
		jpnlSuppliersForm.setBackground(new Color(255, 204, 204));
		add(jpnlSuppliersForm);
		GridBagLayout gbl_jpnlSuppliersForm = new GridBagLayout();
		gbl_jpnlSuppliersForm.columnWidths = new int[]{0, 0, 375, 0};
		gbl_jpnlSuppliersForm.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_jpnlSuppliersForm.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_jpnlSuppliersForm.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpnlSuppliersForm.setLayout(gbl_jpnlSuppliersForm);
		
		JLabel jlblSuppID = new JLabel("Supplier ID:");
		jlblSuppID.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_jlblSuppID = new GridBagConstraints();
		gbc_jlblSuppID.insets = new Insets(0, 0, 5, 5);
		gbc_jlblSuppID.anchor = GridBagConstraints.EAST;
		gbc_jlblSuppID.gridx = 1;
		gbc_jlblSuppID.gridy = 1;
		jpnlSuppliersForm.add(jlblSuppID, gbc_jlblSuppID);
		
		jtxtfldSupplierID = new JTextField();
		jtxtfldSupplierID.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_jtxtfldSupplierID = new GridBagConstraints();
		gbc_jtxtfldSupplierID.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldSupplierID.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldSupplierID.gridx = 2;
		gbc_jtxtfldSupplierID.gridy = 1;
		jpnlSuppliersForm.add(jtxtfldSupplierID, gbc_jtxtfldSupplierID);
		jtxtfldSupplierID.setColumns(10);
		
		JLabel jlblSuppName = new JLabel("Supplier Name:");
		jlblSuppName.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_jlblSuppName = new GridBagConstraints();
		gbc_jlblSuppName.anchor = GridBagConstraints.EAST;
		gbc_jlblSuppName.insets = new Insets(0, 0, 5, 5);
		gbc_jlblSuppName.gridx = 1;
		gbc_jlblSuppName.gridy = 2;
		jpnlSuppliersForm.add(jlblSuppName, gbc_jlblSuppName);
		
		jtxtfldSupplierName = new JTextField();
		jtxtfldSupplierName.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_jtxtfldSupplierName = new GridBagConstraints();
		gbc_jtxtfldSupplierName.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldSupplierName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldSupplierName.gridx = 2;
		gbc_jtxtfldSupplierName.gridy = 2;
		jpnlSuppliersForm.add(jtxtfldSupplierName, gbc_jtxtfldSupplierName);
		jtxtfldSupplierName.setColumns(10);
		
		JLabel jlblSuppAddress = new JLabel("Supplier Address:");
		jlblSuppAddress.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_jlblSuppAddress = new GridBagConstraints();
		gbc_jlblSuppAddress.anchor = GridBagConstraints.EAST;
		gbc_jlblSuppAddress.insets = new Insets(0, 0, 5, 5);
		gbc_jlblSuppAddress.gridx = 1;
		gbc_jlblSuppAddress.gridy = 3;
		jpnlSuppliersForm.add(jlblSuppAddress, gbc_jlblSuppAddress);
		
		jtxtfldSupplierAddress = new JTextField();
		jtxtfldSupplierAddress.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_jtxtfldSupplierAddress = new GridBagConstraints();
		gbc_jtxtfldSupplierAddress.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldSupplierAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldSupplierAddress.gridx = 2;
		gbc_jtxtfldSupplierAddress.gridy = 3;
		jpnlSuppliersForm.add(jtxtfldSupplierAddress, gbc_jtxtfldSupplierAddress);
		jtxtfldSupplierAddress.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 5;
		jpnlSuppliersForm.add(btnNewButton, gbc_btnNewButton);

	}

}
