package spelmotorn;
import java.io.*;

import javax.swing.*;

public class Testaren{

	public static void main(String[] args) {
		Renderare renderer = new Renderare(800, 800, "test");
		Loader lvl1 = new Loader();
		Sprite spr = new Sprite(0, 0, 800, 800, 0);
		Sprite spr2 = new Sprite(0, 0, 400, 400, 1);
		spr.addPicture("Images/Sad4.png");
		spr2.addPicture("C:/Users/SwedishDude/Desktop/DesktopStuff/Hi/PiratePie.png");
		lvl1.addObject(spr2);
		lvl1.addObject(spr);
		renderer.addLevel(lvl1);
		renderer.renderLevel();
		
		boolean quit = false;
		while(!quit){
			//kolla efter inputs
			//uppdatera världen
			//Generera världen
		}

	}

}
