package spelmotorn;
import java.util.*;

import javax.swing.*;

import java.awt.*;

public class Sprite extends JComponent{
	private static final long serialVersionUID = 1L; //m�ste kolla vad detta �r
	private ArrayList<ImageIcon> bilder = new ArrayList<ImageIcon>();
	int x, y, w, h, bildNr, drawOrder; //x och y �r koordinaterna bilden ska ritas p�. w st�r f�r width, och h f�r height. bildNr �r vilken bild som ska vissas. drawOrder �r vilken prioritet bilden ska ritas med (t.ex, en bakgrund ska ritas f�rst, s� den har drawOrder '0')
		
	Sprite(int x, int y, int w, int h, int drawOrder){
		this.x = x;
		this.y = y;
		this.drawOrder = drawOrder;
		setLayout(null);
		Dimension d = new Dimension(w, h);
		setPreferredSize(d);
		setMinimumSize(d);
		setMaximumSize(d);
		
	}
	
	public void addPicture(String filePath){
		bilder.add(new ImageIcon(filePath));
		if(bilder.size() == 1){
			bildNr = 0;
		}
		
	}
	
	public int getDrawOrder() {
		return drawOrder;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		System.out.print("ritades");
		g.drawImage(bilder.get(bildNr).getImage(), getWidth(), getHeight(), this);
	}
	
	
}
