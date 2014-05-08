package eu.misselwitz;

import org.newdawn.slick.*;
import java.io.File;

class FruitCatch extends BasicGame{
	Game game = new Game();

	public FruitCatch(){
		super("FruitCatch");
	}

	public static void main(String[] args) {
		System.setProperty("java.library.path", "../library");
		System.setProperty("org.lwjgl.librarypath", new File("../library/natives").getAbsolutePath());
		try{
			AppGameContainer app = new AppGameContainer(new FruitCatch());
			app.setDisplayMode(1024, 768, false);
			app.setTargetFrameRate(60);
			app.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException{
		game.init(container);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException{
		game.render(container, g);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException{
		game.update(container, delta);
	}

	public void keyPressed(int key, char c){
		game.keyPressed(key, c);
	}
}