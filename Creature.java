
public class Creature extends GameObject {
	
	protected int damage;
	public int getDamage() {
		return damage;
	}


	public Creature(String imagePath, float x, float y) {
		super(imagePath, x, y, 20);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void updatePosition(float timePassed) {
		position=position.sum(new Vector2D(0,-0.3f).scale(timePassed));
		
	}


	@Override
	public void collided(GameObject g) {
		// TODO Auto-generated method stub
		
	}

}
