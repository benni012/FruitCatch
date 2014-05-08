package eu.misselwitz;

import org.newdawn.slick.*;
import java.util.ArrayList;

class Cherry extends Fruit {
	public Cherry() {
		try {
			img = new Image("../res/Cherry.png");
			img.setFilter(Image.FILTER_NEAREST);
			width = img.getWidth();
			height = img.getHeight();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}