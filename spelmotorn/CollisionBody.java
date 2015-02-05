package spelmotorn;

import java.util.ArrayList;

public class CollisionBody {
	
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
	
	CollisionBody(){
		
	}
	
	public void addRect(int minX, int maxX, int minY, int maxY){
		body.add(new rectangle(minX, maxX, minY, maxY));
	}
	
	public int getMinX(int index){ //de fyra metoderna nedan behöver felkontroller
		if(body.get(index) == null){
			throw new IndexOutOfBoundsException("Det finns inte så här många bilder i denna sprite");
		}
		return body.get(index).getMinX();
	}
	
	public int getMaxX(int index){
		if(body.get(index) == null){
			throw new IndexOutOfBoundsException("Det finns inte så här många bilder i denna sprite");
		}
		return body.get(index).getMaxX();
	}
	
	public int getMinY(int index){
		if(body.get(index) == null){
			throw new IndexOutOfBoundsException("Det finns inte så här många bilder i denna sprite");
		}
		return body.get(index).getMinY();
	}
	
	public int getMaxY(int index){
		if(body.get(index) == null){
			throw new IndexOutOfBoundsException("Det finns inte så här många bilder i denna sprite");
		}
		return body.get(index).getMaxY();
	}
	
	
}
