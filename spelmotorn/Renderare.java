package spelmotorn;
import javax.swing.*;
import java.awt.*;
import java.util.*;

import spelmotorn.*;

public class Renderare extends Canvas{
	
	ArrayList<Loader> levels = new ArrayList<Loader>(); //olika levlar renderaren kan rendera från
	int levelNr; //vilken position i ArrayListen den nuvarande leveln är
	JFrame window;
	
	public Renderare(int w, int h, String str){ //w är fönstrets 'width', h är fönstrets 'height'
		setMinimumSize(new Dimension(w, h));
		setMaximumSize(new Dimension(w, h));
		setPreferredSize(new Dimension(w, h));
		window = new JFrame(str);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(w, h);
		window.setLayout(new BorderLayout());
		window.add(this, BorderLayout.CENTER);
		window.pack();
		window.setVisible(true);
	}
	
	void addLevel(Loader level){
		levels.add(level);
		if(levels.size()== 1){
			levelNr = 0;
		}
	}
	
	public void renderLevel(){ //ska rendera den nuvarande leveln
		/*for(Sprite spr : levels.get(levelNr).objekten){
			System.out.print("Sprite");
			add(spr, BorderLayout.CENTER);
			validate();
			repaint();
		}*/
	}
}
