package type_master;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;

public class timerFrameThread extends JFrame implements Runnable{

	private JPanel contentPane;
	public JTextField txtTimer;
	
	private Thread timerThread;
	int initialTime=0;
	private JPanel mainPanel;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					timerFrameThread frame = new timerFrameThread();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public timerFrameThread() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 450, 278);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		txtTimer = new JTextField();
		txtTimer.setText("0");
		txtTimer.setBounds(83, 78, 130, 26);
		mainPanel.add(txtTimer);
		txtTimer.setColumns(10);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true) {
					// TODO Auto-generated method stub
					initialTime=initialTime+1;
					System.out.println(initialTime);
					txtTimer.setText("a");
			try {
				Thread.sleep(1000);	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public int getTimer() {
		return initialTime;
	}
	public void start() {
		System.out.println("Starting thread timer");
		try {
			timerFrameThread frame = new timerFrameThread();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (timerThread == null) {
			timerThread = new Thread (this);
			timerThread.start (); 
		}
	}
}
