package type_master;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import stopWatch.stopWatch;
import stopWatch.stopWatchPanel;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

public class mainFrame extends JFrame {

	private JPanel contentPane;
	public JTextPane txtOriginalText;
	private int clickNum;
	public JTextPane txtRecopyText;
	private JPanel pnlStatus;
	private JPanel pnlTimer;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
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
	public mainFrame() {
		setTitle("Speed typer");
		clickNum=1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 549, 347);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtOriginalText = new JTextPane(); 
		txtOriginalText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtOriginalText.setText(null);
			}
		});
		txtOriginalText.setText("Click & enter the text you want to recopy");
		txtOriginalText.setBounds(6, 6, 537, 131);
		panel.add(txtOriginalText);
	
		txtRecopyText = new JTextPane();
		txtRecopyText.setText("Click & re type the text above as fast as you can");
		
		//compareTextThread ctt1=new compareTextThread();
		compareTextFrameThread ctt1=new compareTextFrameThread();
		//stopWatch stw=new stopWatch();
		
		stopWatchPanel stw=new stopWatchPanel();
		
		megaThread mg1=new megaThread();
		txtRecopyText.addMouseListener(new MouseAdapter() {
			//@Override
			/*public void mouseClicked(MouseEvent e) {
				if(clickNum==1) {
					//timerFrameThread tf1=new timerFrameThread();
					//tf1.start();
					
					//stw.main(null);
					stw.start();
					clickNum++;
					ctt1.txtEqualStatus.setText("not equal");
					ctt1.setOriginalText(txtOriginalText);
					ctt1.setRecopyText(txtRecopyText);
					ctt1.start();
					
					mg1.setFirstThread(ctt1);
					mg1.setSecondThread(stw);
					
					mg1.start();
					
				}
				
			}*/
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRecopyText.setText(null);
			}
		});
		
		
		txtRecopyText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				ctt1.setRecopyText(txtRecopyText);
				
				//JOptionPane.showMessageDialog(null, ctt1.txtEqualStatus.getText());
				if(ctt1.txtEqualStatus.getText()=="equal") {
					JOptionPane.showMessageDialog(null, "Equals");
					stw.isEqual=true;
					//stw.stop();
				
					JOptionPane.showMessageDialog(null, "here");
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				ctt1.setRecopyText(txtRecopyText);
				if(clickNum==1) {
					//timerFrameThread tf1=new timerFrameThread();
					//tf1.start();
					
					//stw.main(null);
					stw.start();
					clickNum++;
					ctt1.txtEqualStatus.setText("not equal");
					ctt1.setOriginalText(txtOriginalText);
					ctt1.setRecopyText(txtRecopyText);
					ctt1.start();
					
					mg1.setFirstThread(ctt1);
					mg1.setSecondThread(stw);
					
					mg1.start();
					
				}
				mg1.setFirstThread(ctt1);
				mg1.setSecondThread(stw);
				//if(ctt1.txtEqualStatus.getText()=="equal") {
					//JOptionPane.showMessageDialog(null, "Equals");
					//stw.isEqual=true;
					//stw.stop();
					//JOptionPane.showMessageDialog(null, "here");
				//}
			}
		});
		txtRecopyText.setBounds(6, 198, 537, 131);
		panel.add(txtRecopyText);
		
		pnlStatus = new JPanel();
		pnlStatus.setBackground(Color.decode("#fb6828"));
		pnlStatus.setBounds(6, 145, 174, 46);
		panel.add(pnlStatus);
		
		pnlStatus.add(ctt1);
		
		pnlTimer = new JPanel();
		pnlTimer.setBackground(Color.decode("#fb6828"));
		pnlTimer.setBounds(369, 145, 174, 46);
		panel.add(pnlTimer);
		
		pnlTimer.add(stw);
	}
}
