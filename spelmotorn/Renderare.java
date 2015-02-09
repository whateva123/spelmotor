package spelmotorn;
import javax.swing.*;

import java.awt.*;
import java.util.*;


public class Renderare extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6811903705524486530L;


	public Renderare(int w, int h, String str){ //w �r f�nstrets 'width', h �r f�nstrets 'height'
		super("str");
		if(w < 0 || h < 0){
			throw new IllegalArgumentException("Bredden elr l�ngden kan inte vara negativ");
		}
		setMinimumSize(new Dimension(w, h));
		setMaximumSize(new Dimension(w, h));
		setPreferredSize(new Dimension(w, h));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(w, h);
		setLayout(new BorderLayout());
		pack();
		setVisible(true);
	}
	
	
	public void renderLevel(ArrayList<GameObject> levels){ //ska rendera den nuvarande leveln. Ska bara kallas en g�ng per level. todo tar bort gamla leveln fr�n f�nstret
		for(GameObject spr : levels){
			System.out.print("Sprite");
			add(spr, BorderLayout.CENTER);
			setComponentZOrder(spr, 0);
			validate();
			repaint();
		}
	}
}
