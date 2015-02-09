package spelmotorn;

import java.util.function.Consumer;
import java.util.*;
/*
 * addKeyListener(new KeyboardInputs) skall l�ggas till d�r spelet k�rs. dvs antingen loadern eller renderare.
 */

public class KeyboardInput{
	
	private HashMap<Integer, Consumer<AnimatedSprite>> controller = new HashMap<Integer, Consumer<AnimatedSprite>>(); //anv�nds f�r att r�ra spelarspriten
	
	private HashMap<Integer, Consumer<Loader>> keyboard = new HashMap<Integer, Consumer<Loader>>(); //anv�nds f�r generella tangenttryckningar

	
	KeyboardInput(){
		
	}
	
	void addPlayerKeybinding(int key, Consumer<AnimatedSprite> action){
		controller.put(key, action);
	}
	
	void addOtherKeybinding(int key, Consumer<Loader> action){
		keyboard.put(key, action);
	}
	
	boolean callFunction(int key, AnimatedSprite player){
		if(controller.get(key) == null){
			return false;
		}
		controller.get(key).accept(player);
		return true;
	}
	
	boolean callFunction(int key, Loader player){
		if(keyboard.get(key) == null){
			return false;
		}
		keyboard.get(key).accept(player);
		return true;
	}
	
}
