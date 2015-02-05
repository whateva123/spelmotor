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
			if(anobj.getBody(anobj.getNr()) != null){
				isobj1 = true;
			}
		}
		
		if(obj2 instanceof AnimatedSprite){
			AnimatedSprite anobj = (AnimatedSprite)obj2;
			if(anobj.getBody(anobj.getNr()) != null){
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
		CollisionBody bod1 = obj1.getBody(obj1.getNr());
		CollisionBody bod2 = obj2.getBody(obj2.getNr());
		for(int x = 0; x < bod1.body.size(); x++){
			for(int y = 0; y < bod2.body.size(); y++){
				if(!(bod1.getMinX(x) > bod2.getMaxX(y) || bod1.getMaxX(x) > bod2.getMinX(y) || bod1.getMinY(x) > bod2.getMaxY(y) || bod1.getMaxY(x) > bod2.getMinY(y))){
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean checkAnimatedCollision(AnimatedSprite obj1, GameObject obj2){
		CollisionBody bod1 = obj1.getBody(obj1.getNr());
		for(int x = 0; x < bod1.body.size(); x++){
			if(!(bod1.getMinX(x) > obj2.getMaxX() || bod1.getMaxX(x) > obj2.getX() || bod1.getMinY(x) > obj2.getMaxY() || bod1.getMaxY(x) > obj2.getY())){
				return true;
			}
		}
		return false;
	}
	
	public void applyGravity(Sprite spr){
		spr.addForce(0, gravity);
	}
	
}
