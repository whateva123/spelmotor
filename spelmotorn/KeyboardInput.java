package spelmotorn;

import java.awt.event.*;
import java.util.function.Consumer;
import java.util.*;
/*
 * addKeyListener(new KeyboardInputs) skall läggas till där spelet körs. dvs antingen loadern eller renderare.
 */

public class KeyboardInput{
	
	private HashMap<Integer, Consumer<AnimatedSprite>> controller = new HashMap<Integer, Consumer<AnimatedSprite>>();
	
	private HashMap<Integer, Consumer<Loader>> keyboard = new HashMap<Integer, Consumer<Loader>>();

/*	public void keyPressed(KeyEvent e){
		int keys = e.getKeyCode();
		if(keys == KeyEvent.VK_A)
			//ChangeX - 2;
		if(keys = KeyEvent.VK_D)
			//ChangeX + 2;
		if(keys = KeyEvent.VK_W)
			//ChangeY + 2;
		if(keys = KeyEvent.VK_S)
			//ChangeY - 2;
		if(keys = KeyEvent.VK_SPACE)
			//Jump
			//jumpSoundMethod()
	}
	*/
	
	KeyboardInput(){
		
	}
	
	void addPlayerKeybinding(int key, Consumer<AnimatedSprite> action){
		controller.put(key, action);
	}
	
	void addOtherKeybinding(int key, Consumer<Loader> action){
		keyboard.put(key, action);
	}
	
	void callFunction(int key, AnimatedSprite player){
		if(controller.get(key) == null){
			return;
		}
		controller.get(key).accept(player);
		
	}
	
	void callFunction(int key, Loader player){
		if(keyboard.get(key) == null){
			return;
		}
		keyboard.get(key).accept(player);
		
	}
	
/*
 * För att skapa metod som lyssnar på vilken tagnet man tycker är det bara lägga till en if-sats.
 * KeyEvent.VK_A -> returnerar en int som representerar tagnenten i unicode. Dvs. KeyEvent.VK_A -> 56.
 * Man kan också skriva det som:
 * 
 * if (e.getKeyCode() == KeyEvent.VK_A)
 *  ChangeX(-2);
 *  
 */
	
	
	
	
}
