package spelmotorn;
import javax.swing.*;

import java.awt.*;
import java.util.*;


public class Renderare extends JFrame{
	JPanel panel = new JPanel();
	private static final long serialVersionUID = -6811903705524486530L;


	public Renderare(int w, int h, String str){ //w är fönstrets 'width', h är fönstrets 'height'
		super("str");
		if(w < 0 || h < 0){
			throw new IllegalArgumentException("Bredden elr längden kan inte vara negativ");
		}
		setMinimumSize(new Dimension(w, h));
		setMaximumSize(new Dimension(w, h));
		setPreferredSize(new Dimension(w, h));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(w, h);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout());
		pack();
		setVisible(true);
	}
	
	public void paintWorld(ArrayList<GameObject> levels){
		for(GameObject spr : levels){
			spr.paintComponents(panel.getGraphics());
		}
	}
	
	
	public void renderLevel(ArrayList<GameObject> levels){ //ska rendera den nuvarande leveln. Ska bara kallas en gång per level. todo tar bort gamla leveln från fönstret
		for(GameObject spr : levels){
			System.out.print("Sprite");
			panel.add(spr, BorderLayout.CENTER);
			setComponentZOrder(spr, 0);
			revalidate();
			panel.repaint();
		}
	}
}
