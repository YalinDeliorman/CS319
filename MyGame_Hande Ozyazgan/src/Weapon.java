public abstract class Weapon 
{
	protected double power;
	public Vector2D location;
	
	public Weapon(float x, float y) 
	{
		location = new Vector2D(x,y);
	}

}
