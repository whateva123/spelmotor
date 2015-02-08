package spelmotorn;
import java.awt.event.KeyEvent;
import java.io.*;

import javax.swing.*;

public class Testaren{
	
	public static void playerAction(AnimatedSprite spr) {
		spr.changeX(100);
		
	}
	
	public static void main(String[] args) {
		Renderare renderer = new Renderare(800, 800, "test");
		Fysikmotor fysik = new Fysikmotor(100);
		KeyboardInput tangentbord = new KeyboardInput();
		Runner gameLoop = new Runner();
		Loader lvl1 = new Loader(renderer, fysik, tangentbord, gameLoop);
		AnimatedSprite spr = new AnimatedSprite(0, 0, 800, 800, 0, 1);
		AnimatedSprite spr2 = new AnimatedSprite(0, 0, 400, 400, 1, 1);
		spr.addBackground("Images/Sad4.png");
		spr.setGravity(false);
		spr2.newCollisionBody(0, 0, 10, 0, 10);
		spr2.addPicture("C:/Users/SwedishDude/Desktop/DesktopStuff/Hi/PiratePie.png");
		
		lvl1.setPlayer(spr2);
		
		if(fysik.checkCollision(spr, spr2)){
			System.out.print("True");
		}else{
			System.out.println("false");
		}
		
		lvl1.addObject(1, spr2);
		lvl1.addObject(1, spr);
		lvl1.setLevel(1);
		lvl1.renderLevel();
		
		fysik.applyGravity(spr2);
		
		//spr2.changeX(100);
		//spr2.changeY(100);
	
		
		tangentbord.addPlayerKeybinding(KeyEvent.VK_SPACE, Testaren::playerAction);
		tangentbord.callFunction(KeyEvent.VK_SPACE, spr2);
		
		//lvl1.startGame();
		boolean quit = false;
		while(!quit){
			//kolla efter inputs
			//uppdatera världen
			//Generera världen
		}

	}


}
