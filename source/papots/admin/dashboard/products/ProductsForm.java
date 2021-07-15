package papots.admin.dashboard.products;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ProductsForm extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField jtxtfldProductID;
	private JTextField jtxtfldProductName;

	/**
	 * Create the panel.
	 */
	public ProductsForm() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel jpnlProductsHeader = new JPanel();
		jpnlProductsHeader.setMinimumSize(new Dimension(10, 1000));
		jpnlProductsHeader.setMaximumSize(new Dimension(32767, 1800));
		jpnlProductsHeader.setBackground(new Color(255, 204, 255));
		add(jpnlProductsHeader);
		GridBagLayout gbl_jpnlProductsHeader = new GridBagLayout();
		gbl_jpnlProductsHeader.columnWidths = new int[]{18, 0, 0};
		gbl_jpnlProductsHeader.rowHeights = new int[]{0, 0, 0, 0};
		gbl_jpnlProductsHeader.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_jpnlProductsHeader.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpnlProductsHeader.setLayout(gbl_jpnlProductsHeader);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 0;
		jpnlProductsHeader.add(verticalStrut, gbc_verticalStrut);
		
		JLabel jlblTitleHeader = new JLabel("Products Form");
		jlblTitleHeader.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		GridBagConstraints gbc_jlblTitleHeader = new GridBagConstraints();
		gbc_jlblTitleHeader.anchor = GridBagConstraints.WEST;
		gbc_jlblTitleHeader.insets = new Insets(0, 0, 5, 0);
		gbc_jlblTitleHeader.gridx = 1;
		gbc_jlblTitleHeader.gridy = 1;
		jpnlProductsHeader.add(jlblTitleHeader, gbc_jlblTitleHeader);
		
		JLabel lblNewLabel = new JLabel("Please input the necessary attributes before submitting the form");
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.ITALIC, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		jpnlProductsHeader.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel jpnlProductsForm = new JPanel();
		jpnlProductsForm.setMaximumSize(new Dimension(32767, 1800));
		jpnlProductsForm.setBackground(new Color(255, 204, 204));
		add(jpnlProductsForm);
		GridBagLayout gbl_jpnlProductsForm = new GridBagLayout();
		gbl_jpnlProductsForm.columnWidths = new int[]{0, 0, 316, 0};
		gbl_jpnlProductsForm.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_jpnlProductsForm.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_jpnlProductsForm.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		jpnlProductsForm.setLayout(gbl_jpnlProductsForm);
		
		JLabel jlblProdID = new JLabel("Product ID:");
		jlblProdID.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_jlblProdID = new GridBagConstraints();
		gbc_jlblProdID.anchor = GridBagConstraints.EAST;
		gbc_jlblProdID.insets = new Insets(0, 0, 5, 5);
		gbc_jlblProdID.gridx = 1;
		gbc_jlblProdID.gridy = 1;
		jpnlProductsForm.add(jlblProdID, gbc_jlblProdID);
		
		jtxtfldProductID = new JTextField();
		jtxtfldProductID.setFont(new Font("Segoe UI", Font.BOLD, 11));
		GridBagConstraints gbc_jtxtfldProductID = new GridBagConstraints();
		gbc_jtxtfldProductID.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldProductID.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldProductID.gridx = 2;
		gbc_jtxtfldProductID.gridy = 1;
		jpnlProductsForm.add(jtxtfldProductID, gbc_jtxtfldProductID);
		jtxtfldProductID.setColumns(10);
		
		JLabel jlblProdName = new JLabel("Product Name:");
		jlblProdName.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_jlblProdName = new GridBagConstraints();
		gbc_jlblProdName.anchor = GridBagConstraints.EAST;
		gbc_jlblProdName.insets = new Insets(0, 0, 5, 5);
		gbc_jlblProdName.gridx = 1;
		gbc_jlblProdName.gridy = 2;
		jpnlProductsForm.add(jlblProdName, gbc_jlblProdName);
		
		jtxtfldProductName = new JTextField();
		jtxtfldProductName.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_jtxtfldProductName = new GridBagConstraints();
		gbc_jtxtfldProductName.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldProductName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldProductName.gridx = 2;
		gbc_jtxtfldProductName.gridy = 2;
		jpnlProductsForm.add(jtxtfldProductName, gbc_jtxtfldProductName);
		jtxtfldProductName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Product Type:");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 3;
		jpnlProductsForm.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JComboBox jcmbbxProductType = new JComboBox();
		GridBagConstraints gbc_jcmbbxProductType = new GridBagConstraints();
		gbc_jcmbbxProductType.insets = new Insets(0, 0, 5, 0);
		gbc_jcmbbxProductType.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcmbbxProductType.gridx = 2;
		gbc_jcmbbxProductType.gridy = 3;
		jpnlProductsForm.add(jcmbbxProductType, gbc_jcmbbxProductType);
		
		JLabel lblNewLabel_4 = new JLabel("Product Description:");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 4;
		jpnlProductsForm.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JPanel jpnlProductDescription = new JPanel();
		jpnlProductDescription.setBackground(new Color(255, 204, 204));
		add(jpnlProductDescription);
		jpnlProductDescription.setLayout(null);
		
		JTextPane jtxtpnProductDescription = new JTextPane();
		jtxtpnProductDescription.setFont(new Font("Segoe UI", Font.BOLD, 12));
		jtxtpnProductDescription.setBounds(31, 0, 429, 189);
		jpnlProductDescription.add(jtxtpnProductDescription);
		
		JPanel jpnlButtons = new JPanel();
		jpnlButtons.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		jpnlButtons.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jpnlButtons.setBackground(new Color(255, 204, 204));
		jpnlButtons.setMaximumSize(new Dimension(32767, 1500));
		add(jpnlButtons);
		jpnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Submit Product");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		jpnlButtons.add(btnNewButton);

	}
}
