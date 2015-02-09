package spelmotorn;

import java.util.function.Consumer;
import java.util.*;
/*
 * addKeyListener(new KeyboardInputs) skall läggas till där spelet körs. dvs antingen loadern eller renderare.
 */

public class KeyboardInput{
	
	private HashMap<Integer, Consumer<AnimatedSprite>> controller = new HashMap<Integer, Consumer<AnimatedSprite>>(); //används för att röra spelarspriten
	
	private HashMap<Integer, Consumer<Loader>> keyboard = new HashMap<Integer, Consumer<Loader>>(); //används för generella tangenttryckningar

	
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
