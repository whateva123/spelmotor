package spelmotorn;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Sprite extends GameObject{
	private static final long serialVersionUID = 7805504552767123047L;
	protected BufferedImage background = null;
	protected int drawOrder;
	private String backgroundPath;
	/*
 * offsetX och offsetY är koordinaterna bilden ska flyttas med. w står för width, och h för height. bildNr är vilken bild som ska vissas.
 * drawOrder är vilken prioritet bilden ska ritas med (t.ex, en bakgrund ska ritas först, så den har drawOrder '0') 
 */
	
	protected int magnitudeX = 0; //kraft som spriten rör sig i
	protected int magnitudeY = 0; //kraft som spriten rör sig i
	protected boolean gravitySensitive = true;
	
	Sprite(int x, int y, int w, int h, int drawOrder, int ID){
		super(x, y, w, h, ID);
		if(drawOrder < 0){
			throw new IllegalArgumentException("drawOrder kan inte vara negativ");
		}
		this.drawOrder = drawOrder;
		setLayout(null);
		setBounds(x,y,w, h);
		Dimension d = new Dimension(w, h);
		setPreferredSize(d);
		setMinimumSize(d);
		setMaximumSize(d);
		
	}
	
	public void addBackground(String filePath){
		try {
			background = ImageIO.read(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getDrawOrder() {
		return drawOrder;
	}
	
	public void addForce(int forceX, int forceY){
		magnitudeX += forceX;
		magnitudeY += forceY;
	}

	public void normalizeMomentum(int amountX, int amountY){
		if(magnitudeX >= 0+amountX || magnitudeX <= 0+amountX){
			magnitudeX += amountX;
		}else{
			magnitudeX = 0;
		}
		
		if(magnitudeY >= 0+amountY || magnitudeY <= 0+amountY){
			magnitudeY += amountY;
		}else{
			magnitudeX = 0;
		}
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
		if(background != null){
			g.drawImage(background, x+offsetX+magnitudeX, y+offsetY+magnitudeY, x+w, y+h, null);
		}
	}
	
	
}
