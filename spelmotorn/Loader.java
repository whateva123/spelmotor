package spelmotorn;

import java.util.*;

public class Loader {
	protected HashMap<Integer, ArrayList<GameObject>> objekten = new HashMap<Integer, ArrayList<GameObject>>();
	private Renderare render;
	private Fysikmotor physic;
	private int levelNr; //vilken position i ArrayListen den nuvarande leveln �r
	
	Loader(Renderare render, Fysikmotor physic){ //Ska ta emot alla spelmotorsdelar h�r. Jag bara p�b�rjade med mina delar
		this.render = render;
		this.physic = physic; 
	}
	
	void addObject(int lvl, GameObject spriten){
		if(objekten.get(lvl) == null){
			objekten.put(lvl, new ArrayList<GameObject>());
			objekten.get(lvl).add(spriten);
			return;
		}
		else{
			if(spriten instanceof Sprite || spriten instanceof AnimatedSprite){
				if(((Sprite) spriten).getDrawOrder() <= objekten.get(lvl).size()){
					objekten.get(lvl).add(((Sprite) spriten).getDrawOrder(), spriten);
					return;
				}
			}
			objekten.get(lvl).add(spriten);
			return;
		}

	}
	
	void setLevel(int lvl){ //beh�vs kontroller
		levelNr = lvl;
	}

}
