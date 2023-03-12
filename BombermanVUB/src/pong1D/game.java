package pong1D;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class game extends JPanel implements KeyListener, ActionListener{

	ArrayList<Ball> balls = new ArrayList<Ball>();
	private int aantal = -1;
	JTextField textField;
	JLabel label;
	JButton button;
	
	public game() {
		/*
		for(long i = 0; i < 1; i++) {
			balls.add(new Ball());
		}
		*/
		button = new JButton("add balls");
        textField = new JTextField(4);
        label = new JLabel("0 ballen");
        button.addActionListener(this);
        this.add(new JLabel("Afstand tussen de lijnen"));
        this.add(textField);
        this.add(label);
        this.add(button);
		Timer T = new Timer();
		T.scheduleAtFixedRate(new updateTimerTask(), 0, 20);
		this.addKeyListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
        try {
            aantal = Integer.parseInt(textField.getText());
            if (aantal <= 0)
                    throw new ArithmeticException();
            for(int i=1;i<=aantal;i++) {
            	balls.add(new Ball());
            }
        }
        catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "De input moet een getal zijn",
                    "Foute ingave", JOptionPane.ERROR_MESSAGE);
        }
        catch(ArithmeticException ex) {
            JOptionPane.showMessageDialog(null, "Het getal moet groter dan 0 zijn",
                    "Foute ingave", JOptionPane.ERROR_MESSAGE);
        }

    }
	
	class updateTimerTask extends TimerTask {
		@Override
		public void run() {
			for (Ball ball: balls) {
				ball.update();
			}
		repaint();
		get_number_of_balls();
		}
	}
	
	void get_number_of_balls() {
		String aantal_ballen = String.valueOf(balls.size());
		label.setText(aantal_ballen);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i=0;i<balls.size();i++) {
			balls.get(i).draw(g);
		}
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(750, 750);
		f.setTitle("pong game in 1d");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel ballPanel = new game();
        f.add(ballPanel);
        f.setVisible(true);
	}
	
	@Override
	public void addNotify() {
		super.addNotify();
		this.requestFocusInWindow();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			balls.add(new Ball());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
