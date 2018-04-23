package type_master;


import javax.swing.JOptionPane;

import stopWatch.stopWatchPanel;

public class megaThread implements Runnable{
	compareTextFrameThread t1;
	stopWatchPanel t2;
	public Thread megaThread;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(null, t1.txtEqualStatus.getText());
		while(true) {
			try {
				Thread.sleep(100);
				if(t1.txtEqualStatus.getText().equals("equal")) {
					//JOptionPane.showMessageDialog(null, t1.txtEqualStatus.getText());
					t2.isEqual=true;
					t2.stop();
					//JOptionPane.showMessageDialog(null, "mega hi");
				}
				else {
					//do nothing
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	public void setFirstThread(compareTextFrameThread ctt1) {
		// TODO Auto-generated method stub
		t1=ctt1;
	}

	public void setSecondThread(stopWatchPanel stw) {
		// TODO Auto-generated method stub
		t2=stw;
	}
	public void start() {
		if (megaThread == null) {
			megaThread = new Thread (this);
			megaThread.start (); 
		}
	}

}
