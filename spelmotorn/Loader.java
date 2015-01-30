package spelmotorn;

import java.util.*;

public class Loader {
	private TreeMap<Integer, Sprite> objekten = new TreeMap<Integer, Sprite>();
	
	Loader(){
		
	}
	
	void addObjekt(Sprite spriten){
		objekten.put(spriten.getDrawOrder(), spriten);
	}

}
