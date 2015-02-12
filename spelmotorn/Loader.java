package spelmotorn;

import java.awt.event.*;
import java.util.*;

public class Loader {
	protected HashMap<Integer, ArrayList<GameObject>> objekten = new HashMap<Integer, ArrayList<GameObject>>(); //Mapen med levlarna, där integer står för vilken level, och ArrayListan är alla objekten
	private Renderare render;
	private Fysikmotor physic; //hann ej till fullo utveckla denna, då det saknar en metod som "aktiverar" fysikmotorn. 
	private int levelNr; //vilken position i ArrayListen den nuvarande leveln är, kanske inte behövs
	private KeyboardInput keys;
	private AnimatedSprite player;
	private Runner gameLoop; //denna är ganska onödig än så länge, men kommer utvecklas senare
	
	Loader(Renderare render, Fysikmotor physic, KeyboardInput keys, Runner gameLoop){
		this.render = render;
		this.physic = physic; 
		this.keys = keys;
		this.gameLoop = gameLoop;
		gameLoop.addRenderer(render);
		render.window.addKeyListener(new Listener());
	}
	
	class Listener extends KeyAdapter{ //lyssnaren av tangenttryck
		public void keyPressed(KeyEvent e){
			int key = e.getKeyCode();
			boolean changed = false;
			if(player != null){
				changed = keys.callFunction(key, player);
			}
			if(keys.callFunction(key, Loader.this) || changed){
				render.window.repaint();
			}
		}
	}
	
	void addObject(int lvl, GameObject spriten){
		if(objekten.get(lvl) == null){
			objekten.put(lvl, new ArrayList<GameObject>());
		}
		else{
			if(spriten instanceof Sprite){
				if(((Sprite) spriten).getDrawOrder() <= objekten.get(lvl).size()){
					objekten.get(lvl).add(((Sprite) spriten).getDrawOrder(), spriten);
					return;
				}
			}
		}
		objekten.get(lvl).add(spriten);
	}
	
	void setLevel(int lvl){ //behövs kontroller
		levelNr = lvl;
	}
	
	void setPlayer(AnimatedSprite player){
		this.player = player;
	}
	
	void renderLevel(){
		render.renderLevel(objekten.get(levelNr));
	}
	
	void repaintLevel(){
		render.repaint();
	}

	void startGame(){
		gameLoop.start();
	}
	
}
