package pompernikkelBeweegt;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game extends JPanel implements ActionListener{
	// constructor van class game
	JButton bUP;
	JButton bDOWN;
	JButton bRIGHT;
	JButton bLEFT;
	JButton bUP2;
	JButton bDOWN2;
	JButton bRIGHT2;
	JButton bLEFT2;
	pompernikkel pomper;
	pompernikkel pomper2;
	
	public Game() {
		pomper = new pompernikkel();
		pomper2 = new pompernikkel();
		bUP = new JButton("UP");
		bDOWN = new JButton("DOWN");
		bRIGHT = new JButton("RIGHT");
		bLEFT = new JButton("LEFT");
		bUP2 = new JButton("UP2");
		bDOWN2 = new JButton("DOWN2");
		bRIGHT2 = new JButton("RIGHT2");
		bLEFT2 = new JButton("LEFT2");
		bUP.addActionListener(this);
		bDOWN.addActionListener(this);
		bRIGHT.addActionListener(this);
		bLEFT.addActionListener(this);
		bUP2.addActionListener(this);
		bDOWN2.addActionListener(this);
		bRIGHT2.addActionListener(this);
		bLEFT2.addActionListener(this);
		
		this.add(bUP);
		this.add(bDOWN);
		this.add(bRIGHT);
		this.add(bLEFT);
		this.add(bUP2);
		this.add(bDOWN2);
		this.add(bRIGHT2);
		this.add(bLEFT2);
		
		Timer T = new Timer();
		T.scheduleAtFixedRate(new updateTimerTask(), 0, 20);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(750, 750);
		f.setTitle("pompernikkel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel player = new Game();
        f.add(player);
        f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==bUP) {
			System.out.println("bUP");
			pomper.y -= 10;
		}
		else if (e.getSource()==bDOWN) {
            //do something
			System.out.println("bDOWN");
			pomper.y += 10;
        }
		else if (e.getSource()==bLEFT) {
            //do something
			System.out.println("bLEFT");
			pomper.x -= 10;
        }
		else if (e.getSource()==bRIGHT) {
            //do something
			System.out.println("bRIGHT");
			pomper.x += 10;
        }
		if (e.getSource()==bUP2) {
			System.out.println("bUP2");
			pomper2.y -= 10;
		}
		else if (e.getSource()==bDOWN2) {
            //do something
			System.out.println("bDOWN2");
			pomper2.y += 10;
        }
		else if (e.getSource()==bLEFT2) {
            //do something
			System.out.println("bLEFT2");
			pomper2.x -= 10;
        }
		else if (e.getSource()==bRIGHT2) {
            //do something
			System.out.println("bRIGHT2");
			pomper2.x += 10;
        }
	}
	
	@Override
	public void addNotify() {
		super.addNotify();
		this.requestFocusInWindow();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		pomper.draw(g);
		pomper2.draw(g);
	}
	
	class updateTimerTask extends TimerTask {
		@Override
		public void run() {
			pomper.update();
			pomper2.update();
		repaint();
		}
	}
	
}
