package spelmotorn;
import javax.swing.*;
import java.awt.*;
import java.util.*;

import spelmotorn.*;

public class Renderare extends JFrame{
	
	ArrayList<Loader> levels = new ArrayList<Loader>(); //olika levlar renderaren kan rendera fr�n
	int levelNr; //vilken position i ArrayListen den nuvarande leveln �r

	
	public Renderare(int w, int h, String str){ //w �r f�nstrets 'width', h �r f�nstrets 'height'
		super("str");
		setMinimumSize(new Dimension(w, h));
		setMaximumSize(new Dimension(w, h));
		setPreferredSize(new Dimension(w, h));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(w, h);
		setLayout(new BorderLayout());
		pack();
		setVisible(true);
	}
	
	void addLevel(Loader level){
		levels.add(level);
		if(levels.size()== 1){
			levelNr = 0;
		}
	}
	
	public void renderLevel(){ //ska rendera den nuvarande leveln. Ska bara kallas en g�ng per level. todo tar bort gamla leveln fr�n f�nstret
		for(Sprite spr : levels.get(levelNr).objekten){
			System.out.print("Sprite");
			add(spr, BorderLayout.CENTER);
			setComponentZOrder(spr, 0);
			validate();
			repaint();
		}
	}
}
