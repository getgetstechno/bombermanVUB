package pong1D;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {
	int x;
	int y;
	double vx;
	double vy;
	int straal;
	Color color;
	private static final double PERIODE = 0.5;
	
	
	Ball() {
		Random rnd = new Random();
		this.x = rnd.nextInt(500)+100;
		this.vx = (Math.cos(rnd.nextDouble()*2*Math.PI))*10+1;
		//System.out.println("vx :" + this.vx);
		this.y = rnd.nextInt(500)+100;
		this.vy = (Math.cos(rnd.nextDouble()*2*Math.PI))*10+1;
		//System.out.println("vy :" + this.vy);
		this.color = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
		this.straal = rnd.nextInt(5)+5;
	}
	
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillOval(this.x, this.y, this.straal, this.straal);
	}
	
	void update() {
		if(this.x > 600) {
			this.vx = -1*this.vx;
		} else if (this.x < 100) {
			this.vx = -1*this.vx;
		} 
		if(this.y > 600) {
			this.vy = -1*this.vy;
		} else if (this.y < 100) {
			this.vy = -1*this.vy;
		}
		this.x += (int) (this.vx*PERIODE);
		this.y += (int) (this.vy*PERIODE);
	}
	
}
