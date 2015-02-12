package spelmotorn;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class AnimatedSprite extends Sprite{

	private static final long serialVersionUID = 2435106591864541981L;
	protected int bildNr = -1; //v�ljer vilken bild bland bilderna som ska ritas
	private ArrayList<BufferedImage> bilder = new ArrayList<BufferedImage>(); //samling av bilder
	private HashMap<Integer, CollisionBody> collisionBodies = new HashMap<Integer, CollisionBody>(); //Map med collisionbodies
	
	AnimatedSprite(int x, int y, int w, int h, int drawOrder, int ID) {
		super(x, y, w, h, drawOrder, ID);
		
	}
	
	private class CollisionBody { //in�slad klass f�r skapandet av collisionsbodies
		
		private class rectangle{ //�n in�slad klass, inuti den in�slade klassen som h�ller v�rldena man beh�ver f�r rektangeln
			private int minX, maxX, minY, maxY;
			rectangle(int minX, int maxX, int minY, int maxY){
				this.minX = minX;
				this.maxX = maxX;
				this.minY = minY;
				this.maxY = maxY;
			}
			
			public int getMinX(){
				return minX;
			}
			
			public int getMaxX(){
				return maxX;
			}
			
			public int getMinY(){
				return minY;
			}
			
			public int getMaxY(){
				return maxY;
			}
		} //slut p� den inre, inre klassen
		
		
		ArrayList<rectangle> body = new ArrayList<rectangle>(); //sj�lva listan med rektanglar som tillsamans utg�r collisionbodien
		
		CollisionBody(int minX, int maxX, int minY, int maxY){
			body.add(new rectangle(minX, maxX, minY, maxY));
		}
		
		public void addRect(int minX, int maxX, int minY, int maxY){
			body.add(new rectangle(minX, maxX, minY, maxY));
		}
		
		public int getMinX(int index){ //index �r vilken rectangel i collisionbody som ska anv�ndas
			if(body.get(index) == null){
				throw new IndexOutOfBoundsException("Det finns inte s� h�r m�nga bilder i denna sprite");
			}
			return body.get(index).getMinX();
		}
		
		public int getMaxX(int index){
			if(body.get(index) == null){
				throw new IndexOutOfBoundsException("Det finns inte s� h�r m�nga bilder i denna sprite");
			}
			return body.get(index).getMaxX();
		}
		
		public int getMinY(int index){
			if(body.get(index) == null){
				throw new IndexOutOfBoundsException("Det finns inte s� h�r m�nga bilder i denna sprite");
			}
			return body.get(index).getMinY();
		}
		
		public int getMaxY(int index){
			if(body.get(index) == null){
				throw new IndexOutOfBoundsException("Det finns inte s� h�r m�nga bilder i denna sprite");
			}
			return body.get(index).getMaxY();
		}
		
		
	} //Slutet p� den inre klassen
	
	
	public void newCollisionBody(int frame, int minX, int maxX, int minY, int maxY){
		collisionBodies.put(frame, new CollisionBody(minX, maxX, minY, maxY));
	}
	
	public void addRect(int frame, int minX, int maxX, int minY, int maxY){ //l�gger till en rectangel till en collisionbody
		if(collisionBodies.get(frame) == null){
			throw new IndexOutOfBoundsException("Det finns inte s� m�nga collisionBodies");
		}
		collisionBodies.get(frame).addRect(minX, maxX, minY, maxY);
	}
	
	public int getBodySize(){
		return collisionBodies.get(bildNr).body.size();
	}
	
	public void addPicture(String filePath){ //man m�ste ha skapat en collisionBody innan man kan l�ga till en bild
		if(collisionBodies.get(bilder.size()) == null){
			throw new IndexOutOfBoundsException("Det finns inte en collisionBody f�r denna bild �n. Skapa en s�dan f�rst genom att kalla p� \"newCollisionBody\"");
		}
		BufferedImage image = null;
		try {
			image = ImageIO.read(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		bilder.add(image);
		if(bilder.size() == 1){
			bildNr = 0;
		}
	}
	
	
	public int getX(int index){
		if(bildNr < 0){
			return x+offsetX;
		}
		return offsetX+collisionBodies.get(bildNr).getMinX(index);
	}
	
	public int getY(int index){
		if(bildNr < 0){
			return y+offsetY;
		}
		return offsetY+collisionBodies.get(bildNr).getMinY(index);
	}
	
	public int getMaxX(int index){
		if(bildNr < 0){
			return x+offsetX+w;
		}
		return offsetX+collisionBodies.get(bildNr).getMaxX(index);
	}
	
	public int getMaxY(int index){
		if(bildNr < 0){
			return y+offsetY+w;
		}
		return offsetY+collisionBodies.get(bildNr).getMaxY(index);
	}

	
	public void setNr(int nr){
		if(nr< 0 || nr >= bilder.size()){
			throw new IndexOutOfBoundsException("Det finns inte s� h�r m�nga bilder i denna sprite");
		}
		bildNr = nr;
	}
	
	public int getNr(){
		return bildNr;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		if(background != null){
			g.drawImage(background, x+offsetX+magnitudeX, y+offsetY+magnitudeY, x+w, y+h, this);
		}
		if(bildNr != -1){
			g.drawImage(bilder.get(bildNr), x+offsetX+magnitudeX, y+offsetY+magnitudeY, x+w, y+h, this);
		}
	}	
	
}
