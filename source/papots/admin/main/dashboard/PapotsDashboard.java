package papots.admin.main.dashboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PapotsDashboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JPanel jpnlContentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PapotsDashboard frame = new PapotsDashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PapotsDashboard() {
		setResizable(false);
		setTitle("Papot's Dashboard");
		setMinimumSize(new Dimension(800, 450));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 492);
		jpnlContentPane = new JPanel();
		jpnlContentPane.setBackground(new Color(255, 204, 204));
		jpnlContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jpnlContentPane);
		jpnlContentPane.setLayout(new BoxLayout(jpnlContentPane, BoxLayout.X_AXIS));
		
		JPanel jpnlSideBar = new JPanel();
		jpnlSideBar.setMinimumSize(new Dimension(250, 10));
		jpnlSideBar.setMaximumSize(new Dimension(250, 32767));
		jpnlSideBar.setBackground(Color.PINK);
		jpnlContentPane.add(jpnlSideBar);
		jpnlSideBar.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Papot's Toy Club");
		lblNewLabel.setBounds(10, 21, 113, 20);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jpnlSideBar.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dashboard");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 78, 141, 26);
		jpnlSideBar.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("The");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 52, 89, 26);
		jpnlSideBar.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Main Menu");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_3.setBounds(10, 163, 78, 14);
		jpnlSideBar.add(lblNewLabel_3);
		
		JButton jbtnMonitoring = new JButton("Monitoring Dashboard");
		jbtnMonitoring.setBorder(null);
		jbtnMonitoring.setBackground(Color.PINK);
		jbtnMonitoring.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnMonitoring.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jbtnMonitoring.setForeground(new Color(255, 255, 255));
		jbtnMonitoring.setBounds(10, 188, 230, 23);
		jpnlSideBar.add(jbtnMonitoring);
		
		JButton jbtnTransactionInput = new JButton("Transaction Input");
		jbtnTransactionInput.setBorder(null);
		jbtnTransactionInput.setBackground(Color.PINK);
		jbtnTransactionInput.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnTransactionInput.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jbtnTransactionInput.setForeground(new Color(255, 255, 255));
		jbtnTransactionInput.setBounds(10, 222, 230, 23);
		jpnlSideBar.add(jbtnTransactionInput);
		
		JButton jbtnProducts = new JButton("Products");
		jbtnProducts.setBorder(null);
		jbtnProducts.setBackground(Color.PINK);
		jbtnProducts.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnProducts.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jbtnProducts.setForeground(new Color(255, 255, 255));
		jbtnProducts.setBounds(10, 256, 230, 23);
		jpnlSideBar.add(jbtnProducts);
		
		JButton jbtnSuppliers = new JButton("Suppliers");
		jbtnSuppliers.setBorder(null);
		jbtnSuppliers.setBackground(Color.PINK);
		jbtnSuppliers.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnSuppliers.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jbtnSuppliers.setForeground(new Color(255, 255, 255));
		jbtnSuppliers.setBounds(10, 290, 230, 23);
		jpnlSideBar.add(jbtnSuppliers);
		
		JButton jbtnExit = new JButton("Exit");
		jbtnExit.setHorizontalAlignment(SwingConstants.RIGHT);
		jbtnExit.setBorder(null);
		jbtnExit.setBackground(Color.PINK);
		jbtnExit.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jbtnExit.setForeground(new Color(255, 255, 255));
		jbtnExit.setBounds(151, 420, 89, 23);
		jpnlSideBar.add(jbtnExit);
		
		JLabel lblNewLabel_4 = new JLabel("Hello, admin!");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Segoe UI Light", Font.ITALIC, 11));
		lblNewLabel_4.setBounds(10, 106, 131, 14);
		jpnlSideBar.add(lblNewLabel_4);
	}
}
