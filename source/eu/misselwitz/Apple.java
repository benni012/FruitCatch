package eu.misselwitz;

import org.newdawn.slick.*;
import java.util.ArrayList;

class Apple extends Fruit {
	public Apple() {
		try {
			img = new Image("../res/Apple.png");
			img.setFilter(Image.FILTER_NEAREST);
			width = img.getWidth();
			height = img.getHeight();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}