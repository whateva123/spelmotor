package spelmotorn;

public class Fysikmotor {

	private int gravity;
	
	public Fysikmotor(int gravity){
		this.gravity = gravity;
	}
	
	public boolean checkCollision(GameObject obj1, GameObject obj2){
		if(obj1.getX() > obj2.getMaxX() || obj1.getMaxX() < obj2.getX() || obj1.getY() > obj2.getMaxY() || obj1.getMaxY() < obj2.getY()){
			return false;
		}
		
		boolean isobj1 = false;
		boolean isobj2 = false;
		if(obj1 instanceof AnimatedSprite){
			AnimatedSprite anobj = (AnimatedSprite)obj1;
			if(anobj.getNr() > -1){
				isobj1 = true;
			}
		}
		
		if(obj2 instanceof AnimatedSprite){
			AnimatedSprite anobj = (AnimatedSprite)obj2;
			if(anobj.getNr() > -1){
				isobj2 = true;
			}
		}
		
		
		if(isobj1 && isobj2){
			return checkAnimatedCollision((AnimatedSprite)obj1, (AnimatedSprite)obj2);
		}
		
		if(isobj1 && !isobj2){
			return checkAnimatedCollision((AnimatedSprite)obj1, obj2);
		}
		
		if(!isobj1 && isobj2){
			return checkAnimatedCollision((AnimatedSprite)obj2, obj1);
		}
		
		return true;
	}
	
	private boolean checkAnimatedCollision(AnimatedSprite obj1, AnimatedSprite obj2){ //beöhvs kontroller
		for(int x = 0; x < obj1.getBodySize(); x++){
			for(int y = 0; y < obj2.getBodySize(); y++){
				if(!(obj1.getX(x) > obj2.getMaxX(y) || obj1.getMaxX(x) > obj2.getX(y) || obj1.getY(x) > obj2.getMaxY(y) || obj1.getMaxY(x) > obj2.getY(y))){
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean checkAnimatedCollision(AnimatedSprite obj1, GameObject obj2){
		for(int x = 0; x < obj1.getBodySize(); x++){
			if(!(obj1.getX(x) > obj2.getMaxX() || obj1.getMaxX(x) > obj2.getX() || obj1.getY(x) > obj2.getMaxY() || obj1.getMaxY(x) > obj2.getY())){
				return true;
			}
		}
		return false;
	}
	
	public void applyGravity(Sprite spr){
		spr.addForce(0, gravity);
	}
	
}
