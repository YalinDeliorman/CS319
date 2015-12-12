import java.awt.image.BufferedImage;

public abstract class Food extends GameObject
{
	protected int foodHealth;
	protected boolean enable;
	protected BufferedImage secondImg;
	protected int secondImgCounter;
	protected boolean onSecondImg;
	protected int hInc;
	public int getFoodHealth() {
		return foodHealth;
	}
	
	public Food(String imagepath,String image2path, float x, float y) 
	{
		super(imagepath,x,y, 20);
		secondImg=ImageReader.readPNGImage(image2path);
		secondImgCounter=0;
		onSecondImg=false;
		enable=false;
	}

	@Override
	public void updatePosition(float timePassed) {
		position=position.sum(new Vector2D(0,-0.3f).scale(timePassed));	
	}
	
	@Override
	public void collided(GameObject g) {
		// TODO Auto-generated method stub	
	}

	public void setDamage(int i) {
		foodHealth-=i;
		if(foodHealth<=0){
			enable=true;
		}
		
	}
	@Override
	public BufferedImage getImage(){
		if(!enable){
			return super.getImage();
		}
		else{
			secondImgCounter++;
			if(secondImgCounter==15){
				secondImgCounter=0;
				onSecondImg=!onSecondImg;
			}
			if(onSecondImg){
				return secondImg;
			}
			else{
				return super.getImage();
			}
		}
	}

	public int getIncrease(){
		return hInc;
	}

	public boolean getEnable() {
		// TODO Auto-generated method stub
		return enable;
	}
}
