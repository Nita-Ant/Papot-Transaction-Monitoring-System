package papots.admin.main.dashboard;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.Color;

public class PapotsDashboard extends JFrame {

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
		setTitle("Papot's Dashboard");
		setMinimumSize(new Dimension(800, 450));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 503);
		jpnlContentPane = new JPanel();
		jpnlContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jpnlContentPane);
		jpnlContentPane.setLayout(new BoxLayout(jpnlContentPane, BoxLayout.X_AXIS));
		
		JPanel jpnlSideBar = new JPanel();
		jpnlSideBar.setMinimumSize(new Dimension(225, 10));
		jpnlSideBar.setMaximumSize(new Dimension(225, 32767));
		jpnlSideBar.setBackground(Color.PINK);
		jpnlContentPane.add(jpnlSideBar);
		jpnlSideBar.setLayout(new BoxLayout(jpnlSideBar, BoxLayout.Y_AXIS));
	}

}
