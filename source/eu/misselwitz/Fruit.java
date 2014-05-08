package eu.misselwitz;

import org.newdawn.slick.*;
import java.util.ArrayList;

abstract class Fruit {
	float x, y;
	int speed = 2;
	Image img;
	int width;
	int height;
	final float SCALE = 5f;

	boolean dead = false;
	boolean hurt = false;

	public Fruit() {
		x = (float) Math.random() * 919;
	}

	public void update(GameContainer container, int delta) throws SlickException{
		if (y <= 768) {
			y += speed;
		} else {
			dead = true;
			hurt = true;
		}
	}

	public void render(GameContainer container, Graphics g) throws SlickException{
		img.draw(x, y, SCALE);
	}
}