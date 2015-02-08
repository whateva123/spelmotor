package spelmotorn;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;


public class AnimatedSprite extends Sprite{

	private static final long serialVersionUID = 2435106591864541981L;
	protected int bildNr = -1;
	private ArrayList<ImageIcon> bilder = new ArrayList<ImageIcon>();
	private HashMap<Integer, CollisionBody> collisionBodies = new HashMap<Integer, CollisionBody>();
	
	AnimatedSprite(int x, int y, int w, int h, int drawOrder) {
		super(x, y, w, h, drawOrder);
		
	}
	
	private class CollisionBody {
		
		private class rectangle{
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
		}
		
		
		ArrayList<rectangle> body = new ArrayList<rectangle>();
		
		CollisionBody(int minX, int maxX, int minY, int maxY){
			body.add(new rectangle(minX, maxX, minY, maxY));
		}
		
		public void addRect(int minX, int maxX, int minY, int maxY){
			body.add(new rectangle(minX, maxX, minY, maxY));
		}
		
		public int getMinX(int index){ //de fyra metoderna nedan beh�ver felkontroller
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
		
		
	}
	
	
	public void newCollisionBody(int frame, int minX, int maxX, int minY, int maxY){
		collisionBodies.put(frame, new CollisionBody(minX, maxX, minY, maxY));
	}
	
	public void addPicture(String filePath, CollisionBody body){
		bilder.add(new ImageIcon(filePath));
		if(bilder.size() == 1){
			bildNr = 0;
		}
		addCollisionBody(bilder.size()-1, body);
	}
	
	private void addCollisionBody(int frame, CollisionBody body){
		collisionBodies.put(frame, body);
	}
	
	public int getX(int index){
		if(drawOrder < 0){
			return x+offsetX;
		}
		return offsetX+collisionBodies.get(drawOrder).getMinX(index);
	}
	
	public int getY(int index){
		if(drawOrder < 0){
			return y+offsetY;
		}
		return offsetY+collisionBodies.get(drawOrder).getMinY(index);
	}
	
	public int getMaxX(int index){
		if(drawOrder < 0){
			return x+offsetX+w;
		}
		return offsetX+collisionBodies.get(drawOrder).getMaxX(index);
	}
	
	public int getMaxY(int index){
		if(drawOrder < 0){
			return y+offsetY+w;
		}
		return offsetY+collisionBodies.get(drawOrder).getMaxY(index);
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
		System.out.print("ritades");
		if(background != null){
			g.drawImage(background.getImage(), x+offsetX, y+offsetY, x+w, y+h, this);
		}
		if(bildNr != -1){
			g.drawImage(bilder.get(bildNr).getImage(), x+offsetX, y+offsetY, x+w, y+h, this);
		}
	}	
	
}
