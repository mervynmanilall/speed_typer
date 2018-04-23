package stopWatch;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;

public class stopWatch extends JFrame {

	private JPanel contentPane;
	public JPanel mainPanel;
	private JPanel panel;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stopWatch frame = new stopWatch();
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
	public stopWatch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.PINK);
		mainPanel.setBounds(0, 0, 450, 209);
		contentPane.add(mainPanel);
		//mainPanel.setLayout(null);
		
		stopWatchPanel stwp=new stopWatchPanel();
		mainPanel.add(stwp);
		
		panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(27, 221, 379, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(45, 6, 130, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		stwp.start();
	}
}
