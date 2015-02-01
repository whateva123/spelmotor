package spelmotorn;

import java.util.*;

public class Loader {
	protected ArrayList<Sprite> objekten = new ArrayList<Sprite>();
	
	Loader(){
		
	}
	
	void addObject(Sprite spriten){
		objekten.add(spriten.getDrawOrder(), spriten);
	}

}
