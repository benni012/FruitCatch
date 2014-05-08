package eu.misselwitz;

import org.newdawn.slick.*;
import java.util.ArrayList;

class Pear extends Fruit {
	public Pear() {
		try {
			img = new Image("../res/Pear.png");
			img.setFilter(Image.FILTER_NEAREST);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}