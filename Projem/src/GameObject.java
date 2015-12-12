

import java.awt.image.BufferedImage;

public abstract class GameObject {
	protected BufferedImage image;
	protected Vector2D position;
	protected float collideRadius;
	public float getCollideRadius() {
		return collideRadius;
	}
	public GameObject(String imagePath, float x, float y, float collideRadius) {
		super();
		this.image = ImageReader.readPNGImage(imagePath);
		position = new Vector2D(x,y);
		this.collideRadius = collideRadius;
	}
	public BufferedImage getImage() {
		return image;
	}
	public Vector2D getPosition() {
		return position;
	}
	
	public boolean doesCollide(GameObject g) {
		//System.out.println(collideRadius+g.getCollideRadius());
		if(position.distance(g.getPosition())<collideRadius+g.getCollideRadius()){
			return true;
		}
		return false;
	}
	
	
	public abstract void updatePosition(float timePased);
	public abstract void collided(GameObject g);
}

