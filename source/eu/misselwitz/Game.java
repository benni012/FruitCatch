package eu.misselwitz;

import org.newdawn.slick.*;
import java.util.ArrayList;

class Game {
	Basket basket;
	ArrayList<Fruit> fruits = new ArrayList<>();
	Image bgImg;
	int time = 0;
	int score = 0;
	int speed = 1;
	boolean disabled = false;

	Image heart_full;
	Image heart_half;

	java.awt.Font tFont1 = new java.awt.Font("Consolas", java.awt.Font.PLAIN, 24);
	TrueTypeFont font1;

	java.awt.Font tFont2 = new java.awt.Font("Consolas", java.awt.Font.PLAIN, 48);
	TrueTypeFont font2;

	public void init(GameContainer container) {
		basket = new Basket();

		try {
			bgImg = new Image("../res/Background.png");
			bgImg.setFilter(Image.FILTER_NEAREST);

			heart_full = new Image("../res/heart_full.png");
			heart_full.setFilter(Image.FILTER_NEAREST);

			heart_half = new Image("../res/heart_half.png");
			heart_half.setFilter(Image.FILTER_NEAREST);
		} catch(SlickException e) {
			e.printStackTrace();
		}

		font1 = new TrueTypeFont(tFont1, true);
		font2 = new TrueTypeFont(tFont2, true);
	}

	public void render(GameContainer container, Graphics g) throws SlickException{
		g.setColor(Color.white);

		bgImg.draw(0, 0, 5.12f);

		
		//Draw the heart containers
		if (basket.hp % 2 == 0) {
			for (int i = 0; i < basket.hp; i+=2) {
				heart_full.draw(890 + (21 * 2 * (i / 2)), 10, 2f);
			}
		} else{
			int i = 0;
			while (i < basket.hp - 2) {
				heart_full.draw(890 + (21 * 2 * (i / 2)), 10, 2f);
				i+=2;
			}
			heart_half.draw(890 + (21 * 2 * (i / 2)), 10, 2f);
		}

		g.setFont(font1);
		g.drawString("Score:" + score, 10, 30);

		g.drawString("Speed:" + speed, 10, 60);

		if (disabled) {
			g.drawString("Press R to try again!", 400, 400);
			g.setFont(font2);
			g.setColor(Color.red);
			g.drawString("You died.", 410, 330);
		}

		for (Fruit fruit : fruits) {
			fruit.render(container, g);
		}
		
		basket.render(container, g);
	}

	public void update(GameContainer container, int delta) throws SlickException{
		if(!disabled){
			speed = (int) Math.floor(score / 150) + 1;
			if (speed > 10) {
				speed = 10;
			}

			for (Fruit fruit : fruits) {
				fruit.speed = 2 + speed;
			}

			basket.speed = 5 + speed;

			checkForCollisions();

			time += delta;

			// Generate the Fruits (Every 3 seconds)
			if (time >= 3000) {
				time = 0;
				switch ((int) Math.ceil(Math.random() * 4)) {
					case 1:
						fruits.add(new Apple());
						break;
					case 2:
						fruits.add(new Pear());
						break;
					case 3:
						fruits.add(new Cherry());
						break;
					case 4:
						fruits.add(new Pinecone());
						break;
				}
			}

			basket.update(container, delta);

			for (Fruit fruit : fruits) {
				fruit.update(container, delta);
			}

			for (int i = 0; i < fruits.size(); i++) {
				if (fruits.get(i).hurt) {
					basket.hurt(1);
				}

				if(fruits.get(i).dead) {
					fruits.remove(i);
				}
			}

			if (basket.hp <= 0) {
				disabled = true;
			}
		}
	}

	public void keyPressed(int key, char c){
		if (disabled && c == 'r') {
			restart();
		}
	}

	private void checkForCollisions() {
		for (Fruit fruit : fruits) {
			if (basket.y + (basket.height - 10) * basket.SCALE <= fruit.y + fruit.height * fruit.SCALE &&
				fruit.x <= basket.x + basket.width * basket.SCALE &&
				fruit.x + fruit.width * fruit.SCALE >= basket.x
				) 
			{
				if (fruit instanceof Pinecone) {
					basket.hurt(2);
				} else {
					//Calculate the score using the speed-based multiplicator
					score += (10 * (((float) speed) / 10 + 0.9));
				}
				fruit.dead = true;
			}
		}
	}

	private void restart() {
		basket = new Basket();
		fruits = new ArrayList<Fruit>();
		score = 0;
		speed = 1;
		disabled = false;
	}
}