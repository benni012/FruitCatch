package eu.misselwitz;

import org.newdawn.slick.*;
import java.util.ArrayList;

class Basket {
	float x = 1024 / 2;
	float y = 768 - 70;
	Image img;
	byte dir;
	int width = 97;
	int height = 45;
	int hp = 6;
	final float SCALE = 1.5f;

	int speed = 5;

	public Basket() {
		try {
			img = new Image("../res/Basket.png");
			img.setFilter(Image.FILTER_NEAREST);
		} catch(SlickException e) {
			e.printStackTrace();
		}
	}

	public void render(GameContainer container, Graphics g) throws SlickException{
		img.draw(x, y, SCALE);
	}

	public void update(GameContainer container, int delta) throws SlickException{
		Input input = container.getInput();
		dir = 0;

		if (input.isKeyDown(Input.KEY_LEFT)) {
			dir = -1;
		}else if (input.isKeyDown(Input.KEY_RIGHT)) {
			dir = +1;
		}

		if (dir == +1) {
			if (isValidPosForBasket(x + speed, y)) {
				x += speed;
			}
		} else if (dir == -1) {
			if (isValidPosForBasket(x - speed, y)) {
				x -= speed;
			}
		}
	}

	boolean isValidPos(float x, float y) {
		if (x >= 0 && y >= 0 && x <= 1024 && y <= 768) {
			return true;
		}
		return false;
	}

	boolean isValidPosForBasket(float x, float y) {
		if (isValidPos(x, y) && isValidPos(x + width * SCALE, y)) {
			return true;
		}
		return false;
	}

	public void hurt(int damage) {
		hp -= damage;
	}
}