package pomperKeyListen;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class pomperstyle {
	int x;
	int y;
	int straal;
	Color kleur;
	
	pomperstyle() {
		Random rnd = new Random();
		this.x = rnd.nextInt(500)+100;
		this.y = rnd.nextInt(500)+100;
		this.straal = rnd.nextInt(20)+10;
		this.kleur = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(this.kleur);
		g.fillOval(this.x, this.y, this.straal, this.straal);
	}
}
