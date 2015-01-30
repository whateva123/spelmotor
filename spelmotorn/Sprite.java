package spelmotorn;
import java.util.*;

public class Sprite {
	private ArrayList<bildformatet> bilder = new ArrayList<bildformatet>(); //vi måste komma fram till en lösning för "bildformatet". Kanske skapa en ny klass?
	int x, y, bildNr, drawOrder; //x och y är koordinaterna bilden ska ritas på. bildNr är vilken bild som ska vissas. drawOrder är vilken prioritet bilden ska ritas med (t.ex, en bakgrund ska ritas först, så den har drawOrder '0')

	
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
