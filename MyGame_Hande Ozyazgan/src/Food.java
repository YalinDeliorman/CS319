public abstract class Food 
{
	protected double foodHealth;
	protected Vector2D location;
	
	public Food(float x, float y) 
	{
		location = new Vector2D(x,y);
	}

}
