package spelmotorn;
import javax.swing.*;

import java.awt.*;

public class Sprite extends GameObject{
	private static final long serialVersionUID = 7805504552767123047L;
	protected ImageIcon background;
	protected int drawOrder;
	protected int offsetX = 0; 
	protected int offsetY = 0;//offsetX och offsetY �r koordinaterna bilden ska flyttas med. w st�r f�r width, och h f�r height. bildNr �r vilken bild som ska vissas. drawOrder �r vilken prioritet bilden ska ritas med (t.ex, en bakgrund ska ritas f�rst, s� den har drawOrder '0')
		
	Sprite(int x, int y, int w, int h, int drawOrder){
		super(x, y, w, h);
		this.drawOrder = drawOrder;
		setLayout(null);
		setBounds(x,y,w, h);
		Dimension d = new Dimension(w, h);
		setPreferredSize(d);
		setMinimumSize(d);
		setMaximumSize(d);
		
	}
	
	public void addBackground(String filePath){
		background = new ImageIcon(filePath);
		
	}
	
	public int getDrawOrder() {
		return drawOrder;
	}
	
	
	
	public void changeX(int x){
		this.offsetX = x+offsetX-x;
	}
	
	public void changeY(int y){
		this.offsetY = y+offsetY-y;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		System.out.print("ritades");
		if(background != null){
			g.drawImage(background.getImage(), x+offsetX, y+offsetY, x+w, y+h, this);
		}
	}
	
	
}
