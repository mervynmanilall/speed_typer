package type_master;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class compareTextThread implements Runnable{
	
	private Thread compareThread;
	private String theOriginalText;
	private String theRecopyText;
	private boolean isTextEqual=false;
	
	public compareTextThread() {
		// TODO Auto-generated constructor stub
	}
	//newly added. this is the cause of our problem
	public void setRecopyText(JTextPane txtRecopy) {
		theRecopyText=txtRecopy.getText();
	}
	public void setOriginalText(JTextPane txtOriginal) {
		this.theOriginalText=txtOriginal.getText();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//mainFrame mf1=new mainFrame();
		while(isTextEqual==false) {
			System.out.println("HERE: "+theOriginalText);
			System.out.println("the recopy= "+theRecopyText);
			if(theOriginalText.equals(theRecopyText)) {
				JOptionPane.showMessageDialog(null, "equals");
				isTextEqual=true;
				System.out.println("EQUAL");
			}
			//System.out.println("not equal");
			//System.out.println(theOriginalText+" not equal because "+mf1.txtRecopyText.getText());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void start() {
		System.out.println("Starting compare text");
		if (compareThread == null) {
			compareThread = new Thread (this);
			compareThread.start (); 
		}
	}

}
