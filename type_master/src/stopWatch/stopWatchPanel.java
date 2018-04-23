package stopWatch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class stopWatchPanel extends JPanel implements Runnable{
	public JTextField txtTimer;
	Thread thread1 = null;
	public boolean isEqual=false;
	/**
	 * Create the panel.
	 */
	public int theTimer=0;
	public stopWatchPanel() {
		setLayout(null);
		
		txtTimer = new JTextField();
		txtTimer.setText("Timer");
		txtTimer.setBounds(0, 0, 174, 36);
		setPreferredSize(new Dimension(174, 36));
		add(txtTimer);
		txtTimer.setColumns(10);
		this.setBackground(Color.decode("#fb6828"));

	}
	public void paintComponenet(Graphics g) {
		Graphics2D g1=(Graphics2D) g;
		super.paintComponent(g);
		
		txtTimer.setText(Integer.toString(theTimer));
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isEqual==false) {
			//if(isEqual==false) {
				try {
			        Thread.sleep(100);
			        theTimer=theTimer+1;
			        txtTimer.setText(Integer.toString(theTimer*100)+" ms");
			        System.out.println(theTimer);
			      } catch (InterruptedException e) {
			      }
			//}
			//else if(isEqual==true) {
				
			//}
		      
		      repaint();
		}
		//JOptionPane.showMessageDialog(null, "out");
		    //thread1 = null;
	}
	public void stop() {
		isEqual=true;
		//thread1 = null;
		//Thread.interrupted();
		//return theTimer;
		//JOptionPane.showMessageDialog(null, "stoping timer");
	}
	  public void start() {
		    if (thread1 == null) {
		      thread1 = new Thread(this);
		      thread1.start();
		    }
		  }

}
