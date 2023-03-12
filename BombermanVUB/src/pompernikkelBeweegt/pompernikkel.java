package pompernikkelBeweegt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

public class pompernikkel implements ActionListener {
	
	int x;
	int y;
	int straal;
	Color color;
	
	pompernikkel() {
		// We maken de bal eerst
		Random rnd = new Random();
		this.x = rnd.nextInt(500)+100;
		this.y = rnd.nextInt(500)+100;
		this.straal = rnd.nextInt(20)+20;
		this.color = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
	}

	public void update() {
		// TODO Auto-generated method stub
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(this.color);
		g.fillOval(this.x, this.y, this.straal, this.straal);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
