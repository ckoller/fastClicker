package keypresser;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

public class keypresser extends TimerTask{
	
	public void run() {
		Robot r;

		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_F);
		    r.keyRelease(KeyEvent.VK_F);
		} catch (AWTException e) {
		
			e.printStackTrace();
		}		
}
	
	
public static void main(String[] args){
	       Timer timer = new Timer();
	       timer.schedule(new keypresser(), 0, 5000);	
	}
}
	