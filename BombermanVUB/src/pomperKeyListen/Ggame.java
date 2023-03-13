package pomperKeyListen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ggame extends JLabel implements KeyListener{
	// hoofd klasse --> main, constructor, keylistener, updateTimerTask, paintcomponent, addnotify, 
	
	pomperstyle pomper;
	pomperstyle pomper2;
	
	Ggame() {
		//constructor --> wat moet er op onze jlabel komen, bal, buttons, ...
		pomper = new pomperstyle();
		pomper2 = new pomperstyle();
		Timer t = new Timer();
		t.scheduleAtFixedRate(new updateTimerTask(), 0, 20);
		this.addKeyListener(this);
	}
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(750, 750);
		f.getContentPane().setBackground(Color.DARK_GRAY);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new Ggame();
		f.add(label);
		f.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		pomper.draw(g);
		pomper2.draw(g);
	}
	
	class updateTimerTask extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			pomper.update();
			pomper2.update();
		repaint();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addNotify() {
		super.addNotify();
		this.requestFocusInWindow();
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			pomper.y -= 10;
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			pomper.y += 10;
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			pomper.x += 10;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			pomper.x -= 10;
		}
		if(e.getKeyCode() == KeyEvent.VK_Z) {
			pomper2.y -= 10;
		} else if(e.getKeyCode() == KeyEvent.VK_S) {
			pomper2.y += 10;
		} else if(e.getKeyCode() == KeyEvent.VK_D) {
			pomper2.x += 10;
		} else if(e.getKeyCode() == KeyEvent.VK_Q) {
			pomper2.x -= 10;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
