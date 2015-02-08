package spelmotorn;

import java.awt.event.*;
import java.util.*;

public class Loader {
	protected HashMap<Integer, ArrayList<GameObject>> objekten = new HashMap<Integer, ArrayList<GameObject>>(); //Mapen med levlarna, där integer står för vilken level, och ArrayListan är alla objekten
	private Renderare render;
	private Fysikmotor physic;
	private int levelNr; //vilken position i ArrayListen den nuvarande leveln är, kanske inte behövs
	private KeyboardInput keys;
	private AnimatedSprite player;
	
	Loader(Renderare render, Fysikmotor physic, KeyboardInput keys){ //Ska ta emot alla spelmotorsdelar här. Jag bara påbörjade med mina delar
		this.render = render;
		this.physic = physic; 
		this.keys = keys;
		render.addKeyListener(new Listener());
	}
	
	class Listener extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			int key = e.getKeyCode();
			if(player != null){
				keys.callFunction(key, player);
			}
			keys.callFunction(key, Loader.this);
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

}
