public abstract class Weapon extends GameObject
{
	protected int power;
	
	public Weapon(String imagepath, float x, float y) 
	{
		super(imagepath,x,y, 20);
	}
	@Override
	public void updatePosition(float timePassed){
		position=position.sum(new Vector2D(0,0.5f).scale(timePassed));
	}
	public void collided(GameObject g) {
		if(g instanceof Food){
			((Food)g).setDamage(power);
		}
		
	}

}
