

public class Beast extends GameObject
{
	public int beastHealth;
	
	public Beast(String imagePath, float x, float y) 
	{
		super(imagePath, x,y, 20);
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

	public void translateX(float xDif){
		position.setX(position.getX()+xDif);
	}

	@Override
	public void updatePosition(float timePased) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collided(GameObject g) {
		if(g instanceof Creature){
			beastHealth-=((Creature)g).getDamage();
			System.out.println(beastHealth);
		}
		
		if(g instanceof Food){
			beastHealth+=((Food)g).getFoodHealth(); 
			System.out.println(beastHealth);
		}
		
	}

	public int getHealth() {
		// TODO Auto-generated method stub
		return beastHealth;
	}
	

}
