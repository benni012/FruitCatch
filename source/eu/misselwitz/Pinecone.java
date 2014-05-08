package eu.misselwitz;

import org.newdawn.slick.*;
import java.util.ArrayList;

class Pinecone extends Fruit {
	public Pinecone() {
		try {
			img = new Image("../res/Pinecone.png");
			img.setFilter(Image.FILTER_NEAREST);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void update(GameContainer container, int delta) throws SlickException{
		if (y <= 768) {
			y += speed;
		} else {
			dead = true;
		}
	}
}