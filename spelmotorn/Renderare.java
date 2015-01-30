package spelmotorn;
import javax.swing.*;

import java.util.*;

import spelmotorn.*;

public class Renderare extends JFrame{
	
	ArrayList<Loader> levels = new ArrayList<Loader>(); //olika levlar renderaren kan rendera från
	int levelNr; //vilken position i ArrayListen den nuvarande leveln är
	
	public Renderare(int x, int y, int w, int h){ //x, y är koordinaterna fönstret ska skapas på. w är fönstrets 'width', h är fönstrets 'height'
		
	}
	
	void addLevel(Loader level){
		levels.add(level);
		if(levels.size()== 1){
			levelNr = 0;
		}
	}
	
	void renderLevel{ //ska rendera den nuvarande leveln
		
	}
}
