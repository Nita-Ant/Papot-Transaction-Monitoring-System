package papots.admin.main.dashboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import javax.swing.Box;


public class MainFrame extends JFrame {

	/**
	 * Default to ignore other faults
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel jpnlContentPane;
	
	/**
	 * The current shown panel (to the right)
	 */
	private JPanel jpnlCurrentShownPanel;
	
	// Declaration of the panels that will be used in the display 
	/**
	 * Products Form Panel of the module
	 */
	protected papots.admin.dashboard.products.ProductsForm productsForm; 
	
	/**
	 *Suppliers Form Panel of the module
	 */
	protected papots.admin.dashboard.suppliers.SuppliersForm suppliersForm;
	
	/**
	 * Transaction Input Form Panel of the module
	 */
	protected papots.admin.dashboard.transaction.input.TransactionInput transactionInput; 
	
	/**
	 * Transaction Dashboard Panel of the module
	 */
	protected papots.admin.dashboard.transaction.dashboard.TransactionDashboard  transactionDashboard; 
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public MainFrame() throws SQLException, ClassNotFoundException {
		setResizable(false);
		setTitle("Papot's Dashboard");
		setMinimumSize(new Dimension(1200, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 532);
		
		//Main Content Pane Properties 
		jpnlContentPane = new JPanel();
		jpnlContentPane.setBackground(new Color(255, 204, 204));
		jpnlContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jpnlContentPane);
		jpnlContentPane.setLayout(new BoxLayout(jpnlContentPane, BoxLayout.X_AXIS));
		
		// Left Sidebar 
		Sidebar sideBar = new Sidebar();
		sideBar.setMainFrame(this);
		jpnlContentPane.add(sideBar);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		jpnlContentPane.add(horizontalStrut);
		
		
		// Create the DashBoard Panel
		transactionDashboard = new papots.admin.dashboard.transaction.dashboard.TransactionDashboard();
		// Create the Transaction Form Panel
		transactionInput = new papots.admin.dashboard.transaction.input.TransactionInput();
		// Create the Products Form Panel
		productsForm = new papots.admin.dashboard.products.ProductsForm();
		// Create the Suppliers Form Panel 
		suppliersForm = new papots.admin.dashboard.suppliers.SuppliersForm();
	}
	
	/**
	 * Shows the Products Form Panel
	 */
	public void showProductsForm() {
		/**
		 * DO NOTHING if it still 
		 * the Transaction Input Form is showing in the display panel
		 * ELSE 
		 * remove the other displaying content
		 */
		if(jpnlCurrentShownPanel==productsForm)
			return;
		else if (jpnlCurrentShownPanel != null) {
			jpnlContentPane.remove(jpnlCurrentShownPanel);
			revalidate();
		}
		
		// Set the current shown panel to transactionInput panel
		jpnlCurrentShownPanel = productsForm;
		// Add the transactionInput panel to the content pane 
		jpnlContentPane.add(productsForm);
		//Redraw the frame
		revalidate();
		repaint();
	}
	
	/**
	 * Shows the Suppliers Form Panel
	 */
	public void showSuppliersForm() {
		
		if(jpnlCurrentShownPanel==suppliersForm)
			return;
		else if (jpnlCurrentShownPanel != null) {
			jpnlContentPane.remove(jpnlCurrentShownPanel);
			revalidate();
		}
		
		
		jpnlCurrentShownPanel = suppliersForm;
		jpnlContentPane.add(suppliersForm);
		revalidate();
		repaint();
	}
	
	
	/**
	 * Shows the Transactions Form Panel
	 */
	public void showTransactionsForm() {
		
		if(jpnlCurrentShownPanel==transactionInput)
			return;
		else if (jpnlCurrentShownPanel != null) {
			jpnlContentPane.remove(jpnlCurrentShownPanel);
			revalidate();
		}
		
		
		jpnlCurrentShownPanel = transactionInput;
		jpnlContentPane.add(transactionInput);
		revalidate();
		repaint();
	}
	
	/**
	 * Shows the Transactions Dashboard Panel
	 */
	public void showTransactionsDashboard() {
		
		if(jpnlCurrentShownPanel==transactionDashboard)
			return;
		else if (jpnlCurrentShownPanel != null) {
			jpnlContentPane.remove(jpnlCurrentShownPanel);
			revalidate();
		}
		
		
		jpnlCurrentShownPanel = transactionDashboard;
		jpnlContentPane.add(transactionDashboard);
		revalidate();
		repaint();
	}
}
