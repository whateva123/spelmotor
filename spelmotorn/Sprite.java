package spelmotorn;
import java.util.*;

public class Sprite {
	private ArrayList<bildformatet> bilder = new ArrayList<bildformatet>(); //vi m�ste komma fram till en l�sning f�r "bildformatet". Kanske skapa en ny klass?
	int x, y, bildNr, drawOrder; //x och y �r koordinaterna bilden ska ritas p�. bildNr �r vilken bild som ska vissas. drawOrder �r vilken prioritet bilden ska ritas med (t.ex, en bakgrund ska ritas f�rst, s� den har drawOrder '0')

	
	Sprite(int x, int y, int drawOrder){
		this.x = x;
		this.y = y;
		this.drawOrder = drawOrder;
	}
	
	public void addPicture(String filePath){
		
	}
	
	public int getDrawOrder() {
		return drawOrder;
	}
	
	
	
}
