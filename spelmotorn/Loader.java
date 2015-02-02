package spelmotorn;

import java.util.*;

public class Loader {
	protected ArrayList<Sprite> objekten = new ArrayList<Sprite>();
	
	Loader(){
		
	}
	
	void addObject(Sprite spriten){
		if(spriten.getDrawOrder() <= objekten.size()){
			System.out.println("nånstans");
			objekten.add(spriten.getDrawOrder(), spriten);
		}else{
			System.out.println("sist");
			objekten.add(spriten);
		}
	}

}
