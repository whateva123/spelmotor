package spelmotorn;

import javax.swing.JComponent;

public class GameObject extends JComponent{
	private static final long serialVersionUID = -6232733248821165116L; //Jag m�ste kolla vad detta �r
	protected final int x, y, w, h; //x och y �r koordinaterna bilden ska ritas p�.
	
	public GameObject(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
}
