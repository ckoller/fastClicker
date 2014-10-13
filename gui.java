import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class gui{
	JFrame frame = new JFrame("Button event");
	JButton button = new JButton("Start/Stop");
	JTextField clicks = new JTextField("#clicks");
	JTextField clicksPerSec = new JTextField("ms/click");
	JTextField keyPressed = new JTextField("key pressed");
	JTextField trigger = new JTextField("trigger");
	String pressed = "stopped";
	gui.Evt.keypresser keypresserThread;
	int keycode;

	public gui(){
		button.addActionListener(new Evt());
		keyPressed.addKeyListener(new MyKeyListener());
		GridLayout experimentLayout = new GridLayout(0,1);
		frame.setLayout(experimentLayout);
		frame.add(clicks);
		frame.add(clicksPerSec);
		frame.add(keyPressed);
		frame.add(trigger);
		frame.add(button);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new gui();
			}
		});
	}
	private class Evt implements ActionListener{
		int int_clicks;
		
		public void actionPerformed(ActionEvent arg0) {
			int_clicks = Integer.parseInt(clicks.getText());
			int int_CPS = Integer.parseInt(clicksPerSec.getText());
			
			if(pressed.equals("stopped")){
				pressed = "start";
				button.setBackground(Color.RED);
				keypresserThread = new keypresser(int_CPS);
			}else{
				keypresserThread.cancel();
			}	
		}

		public class keypresser{
			Timer timer;
			int amount;
			public keypresser(int seconds){
				timer = new Timer();
				timer.schedule(new keypress(), 0, seconds * 10);
			}
			class keypress extends TimerTask{
				public void run(){
					Robot r;
					try {
						r = new Robot();
						r.keyPress(keycode);
						r.keyRelease(keycode);
					} catch (AWTException e) {
						e.printStackTrace();
					}		
					amount ++;
					System.out.println(amount);
					if(amount>=int_clicks){
						keypresserThread.cancel();
						timer.cancel();}
				}
			}
			public boolean cancel(){
				button.setBackground(Color.WHITE);
				pressed = "stopped";
				timer.cancel();
				return true;
			}
		}
	}
	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent evt) {
			if (evt.getKeyChar() == 'a' && evt.getKeyCode() == KeyEvent.VK_A) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'b' && evt.getKeyCode() == KeyEvent.VK_B) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'c' && evt.getKeyCode() == KeyEvent.VK_C) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'd' && evt.getKeyCode() == KeyEvent.VK_D) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'e' && evt.getKeyCode() == KeyEvent.VK_E) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'f' && evt.getKeyCode() == KeyEvent.VK_F) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'g' && evt.getKeyCode() == KeyEvent.VK_G) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'h' && evt.getKeyCode() == KeyEvent.VK_H) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'i' && evt.getKeyCode() == KeyEvent.VK_I) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'j' && evt.getKeyCode() == KeyEvent.VK_J) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'k' && evt.getKeyCode() == KeyEvent.VK_K) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'l' && evt.getKeyCode() == KeyEvent.VK_L) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'm' && evt.getKeyCode() == KeyEvent.VK_M) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'n' && evt.getKeyCode() == KeyEvent.VK_N) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'o' && evt.getKeyCode() == KeyEvent.VK_O) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'p' && evt.getKeyCode() == KeyEvent.VK_P) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'q' && evt.getKeyCode() == KeyEvent.VK_Q) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'r' && evt.getKeyCode() == KeyEvent.VK_R) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 's' && evt.getKeyCode() == KeyEvent.VK_S) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 't' && evt.getKeyCode() == KeyEvent.VK_T) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'u' && evt.getKeyCode() == KeyEvent.VK_U) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'v' && evt.getKeyCode() == KeyEvent.VK_V) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'w' && evt.getKeyCode() == KeyEvent.VK_W) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'y' && evt.getKeyCode() == KeyEvent.VK_Y) {
				keycode = evt.getKeyCode();
			}if (evt.getKeyChar() == 'z' && evt.getKeyCode() == KeyEvent.VK_Z) {
				keycode = evt.getKeyCode();
			}
		}	
	}
}