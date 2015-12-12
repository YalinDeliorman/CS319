

public class Beast extends GameObject
{
	public int beastHealth;
	
	public Beast(String imagePath, float x, float y) 
	{
		super(imagePath, x,y, 20);
		beastHealth = 100;
		
	}
	
	public void translateX(float xDif){
		float updatePos=position.getX()+xDif;
		if(updatePos<40){
			updatePos=40;
		}
		else if(updatePos>920){
			updatePos=920;
		}
		position.setX(updatePos);
	}

	@Override
	public void updatePosition(float timePased) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collided(GameObject g) {
		if(g instanceof Creature){
			beastHealth-=((Creature)g).getDamage();
			//System.out.println(beastHealth);
		}
		if(g instanceof Food){
			
			beastHealth+=((Food)g).getIncrease();
			if(beastHealth>100){
				beastHealth=100;
			}
		}
		
	}

	public int getHealth() {
		// TODO Auto-generated method stub
		return beastHealth;
	}

	public void setHealth(int i) {
		beastHealth=i;
		
	}
	

}
