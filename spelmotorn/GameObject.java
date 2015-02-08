package spelmotorn;

import java.util.HashMap;
import java.util.function.Consumer;

import javax.swing.JComponent;

public class GameObject extends JComponent{
	private static final long serialVersionUID = -6232733248821165116L; //Jag måste kolla vad detta är
	protected final int x, y, w, h; //x och y är koordinaterna bilden ska ritas på.
	protected int offsetX = 0; 
	protected int offsetY = 0;
	protected final int ID; 
	private HashMap<Integer, Consumer<GameObject>> reactions = new HashMap<Integer, Consumer<GameObject>>();
	
	
	public GameObject(int x, int y, int w, int h, int ID){
		if(w < 0 || h < 0){
			throw new IllegalArgumentException("Bredden elr längden kan inte vara negativ");
		}
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.ID = ID;
	}
	
	public void addReaction(int ID, Consumer<GameObject> action){
		reactions.put(ID, action);
	}
	
	public boolean react(int ID){
		if(reactions.get(ID) == null){
			return false;
		}
		reactions.get(ID).accept(this);
		return true;
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
		this.offsetX = offsetX+x;
	}
	
	public void changeY(int y){
		this.offsetY = offsetY+y;
	}
	
}
