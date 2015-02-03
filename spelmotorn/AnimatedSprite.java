package spelmotorn;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class AnimatedSprite extends Sprite{

	private static final long serialVersionUID = 2435106591864541981L;
	protected int bildNr = -1;
	private ArrayList<ImageIcon> bilder = new ArrayList<ImageIcon>();
	
	AnimatedSprite(int x, int y, int w, int h, int drawOrder) {
		super(x, y, w, h, drawOrder);
		
	}
	
	public void addPicture(String filePath){
		bilder.add(new ImageIcon(filePath));
		if(bilder.size() == 1){
			bildNr = 0;
		}
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		System.out.print("ritades");
		if(background != null){
			g.drawImage(background.getImage(), x+offsetX, y+offsetY, x+w, y+h, this);
		}
		if(bildNr != -1){
			g.drawImage(bilder.get(bildNr).getImage(), x+offsetX, y+offsetY, x+w, y+h, this);
		}
	}	
	
}
