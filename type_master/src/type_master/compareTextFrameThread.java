package type_master;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JTextField;
import javax.swing.JTextPane;

public class compareTextFrameThread extends JPanel implements Runnable{
	private JPanel pnlTheStatus;
	public JTextField txtEqualStatus;
	
	public String boolStatus="not equal";
	
	private Thread compareThread;
	private String theOriginalText;
	private String theRecopyText;
	private boolean isTextEqual=false;
	/**
	 * Create the panel.
	 */
	public compareTextFrameThread() {
		setBackground(Color.decode("#fb6828"));
		setLayout(null);
		
		pnlTheStatus = new JPanel();
		pnlTheStatus.setBackground(Color.decode("#fb6828"));
		pnlTheStatus.setBounds(6, 0, 174, 36);
		add(pnlTheStatus);
		pnlTheStatus.setLayout(null);
		setPreferredSize(new Dimension(174, 36));
		
		txtEqualStatus = new JTextField();
		txtEqualStatus.setText("Comparison Status");
		txtEqualStatus.setBounds(0, 0, 168, 36);
		pnlTheStatus.add(txtEqualStatus);
		txtEqualStatus.setColumns(10);

	}
	public void paintComponenet(Graphics g) {
		Graphics2D g1=(Graphics2D) g;
		super.paintComponent(g);
		
		txtEqualStatus.setText(boolStatus);
	}
	public void setRecopyText(JTextPane txtRecopy) {
		theRecopyText=txtRecopy.getText();
	}
	public void setOriginalText(JTextPane txtOriginal) {
		this.theOriginalText=txtOriginal.getText();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isTextEqual==false) {
			System.out.println("HERE: "+theOriginalText);
			System.out.println("the recopy= "+theRecopyText);
			if(theOriginalText.equals(theRecopyText)) {
				//JOptionPane.showMessageDialog(null, "equals");
				isTextEqual=true;
				boolStatus="equal";
				//System.out.println("EQUAL");
			}
			//System.out.println("not equal");
			//System.out.println(theOriginalText+" not equal because "+mf1.txtRecopyText.getText());
			try {
				Thread.sleep(100);
				txtEqualStatus.setText(boolStatus);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		repaint();
	}
	public void start() {
		System.out.println("Starting compare text");
		if (compareThread == null) {
			compareThread = new Thread (this);
			compareThread.start (); 
		}
	}

}
