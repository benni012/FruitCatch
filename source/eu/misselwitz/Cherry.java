package eu.misselwitz;

import org.newdawn.slick.*;
import java.util.ArrayList;

class Cherry extends Fruit {
	public Cherry() {
		try {
			img = new Image("../res/Cherry.png");
			img.setFilter(Image.FILTER_NEAREST);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}