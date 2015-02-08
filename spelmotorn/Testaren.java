package spelmotorn;
import java.io.*;

import javax.swing.*;

public class Testaren{

	public static void main(String[] args) {
		Renderare renderer = new Renderare(800, 800, "test");
		Fysikmotor fysik = new Fysikmotor(0);
		KeyboardInput tangentbord = new KeyboardInput();
		Loader lvl1 = new Loader(renderer, fysik, tangentbord);
		AnimatedSprite spr = new AnimatedSprite(0, 0, 800, 800, 0);
		AnimatedSprite spr2 = new AnimatedSprite(0, 0, 400, 400, 1);
		CollisionBody body = new CollisionBody();
		body.addRect(0, 10, 0, 10);
		spr.addBackground("Images/Sad4.png");
		spr2.addPicture("C:/Users/SwedishDude/Desktop/DesktopStuff/Hi/PiratePie.png", body);
		
		if(fysik.checkCollision(spr, spr2)){
			System.out.print("True");
		}else{
			System.out.print("false");
		}
		/*
		lvl1.addObject(spr2);
		lvl1.addObject(spr);
		renderer.addLevel(lvl1);
		renderer.renderLevel();
		spr2.setX(spr2.getX()+100);
		spr2.setY(spr2.getY()+100);
		*/
		
		boolean quit = false;
		while(!quit){
			//kolla efter inputs
			//uppdatera världen
			//Generera världen
		}

	}

}
