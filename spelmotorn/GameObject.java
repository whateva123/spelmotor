package spelmotorn;

import javax.swing.JComponent;

public class GameObject extends JComponent{
	private static final long serialVersionUID = -6232733248821165116L; //Jag måste kolla vad detta är
	protected final int x, y, w, h; //x och y är koordinaterna bilden ska ritas på.
	protected int offsetX = 0; 
	protected int offsetY = 0;
	
	
	public GameObject(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public int getX(){
		return x+offsetX;
	}
	
	public int getY(){
		return y+offsetY;
	}
	
	public int getMaxX(){
		return x+offsetX+w;
	}
	
	public int getMaxY(){
		return y+offsetY+h;
	}
	
	public void changeX(int x){
		this.offsetX = x+offsetX-x;
	}
	
	public void changeY(int y){
		this.offsetY = y+offsetY-y;
	}
	
}
