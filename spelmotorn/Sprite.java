package spelmotorn;
import javax.swing.*;

import java.awt.*;

public class Sprite extends GameObject{
	private static final long serialVersionUID = 7805504552767123047L;
	protected ImageIcon background;
	protected int drawOrder;
//offsetX och offsetY �r koordinaterna bilden ska flyttas med. w st�r f�r width, och h f�r height. bildNr �r vilken bild som ska vissas. drawOrder �r vilken prioritet bilden ska ritas med (t.ex, en bakgrund ska ritas f�rst, s� den har drawOrder '0')
	
	protected int magnitudeX = 0; //kraft som spriten r�r sig i
	protected int magnitudeY = 0; //kraft som spriten r�r sig i
	protected boolean gravitySensitive = true;
	
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
	
	public void addForce(int forceX, int forceY){
		magnitudeX += forceX;
		magnitudeY += forceY;
	}

	public int getMagnitudeY(){
		return magnitudeY;
	}
	
	public int getMagnitudeX(){
		return magnitudeX;
	}
	
	
	public void setGravity(boolean onoroff){
		gravitySensitive = onoroff;
	}
	
	public boolean getGravity(){
		return gravitySensitive;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		System.out.print("ritades");
		if(background != null){
			g.drawImage(background.getImage(), x+offsetX, y+offsetY, x+w, y+h, this);
		}
	}
	
	
}
