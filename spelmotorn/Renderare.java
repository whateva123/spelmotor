package spelmotorn;
import javax.swing.*;

import java.util.*;

import spelmotorn.*;

public class Renderare extends JFrame{
	
	ArrayList<Loader> levels = new ArrayList<Loader>(); //olika levlar renderaren kan rendera fr�n
	int levelNr; //vilken position i ArrayListen den nuvarande leveln �r
	
	public Renderare(int x, int y, int w, int h){ //x, y �r koordinaterna f�nstret ska skapas p�. w �r f�nstrets 'width', h �r f�nstrets 'height'
		
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
