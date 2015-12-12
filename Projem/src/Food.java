public class Food extends GameObject
{
	protected int foodHealth;
	protected int enable;
	
	public int getFoodHealth() {
		return foodHealth;
	}
	
	public Food(String imagepath, float x, float y) 
	{
		super(imagepath,x,y, 20);
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
