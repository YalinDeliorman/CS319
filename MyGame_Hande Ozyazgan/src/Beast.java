

public class Beast 
{
	public double beastHealth;
	public Vector2D position;
	
	public Beast(float x, float y) 
	{
		position = new Vector2D(x,y);
		beastHealth = 100;
	}
	
	public void left()
	{
		position.setX(position.getX()-(float)1.5);
		if(position.getX()<0)
			position.setX(0);
	}
	public void right()
	{
		position.setX(position.getX()+(float)1.5);
		if(position.getX()>775)
			position.setX(775);
	}
	

}
