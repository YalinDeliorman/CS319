public class Vector2D 
{
	
	private float x;
	private float y;
	
	public Vector2D(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public Vector2D scale(float value){
		return new Vector2D(x*value, y*value); 
	}
	
	public Vector2D sum(Vector2D vector){
		return new Vector2D(vector.getX()+x, vector.getY()+y);
	}
	
	public void normalize(){
		x=x/magnitude();
		y=y/magnitude();
	}
	
	public Vector2D normalized(){
		return new Vector2D(x/magnitude(),y/magnitude());
	}
	
	public float magnitude(){
		return (float)Math.sqrt(x*x+y*y);
	}
	
	public float dotProduct(Vector2D vector){
		return this.x*vector.getX()+this.y*vector.getY();
	}
	
	public Vector2D getProjection(Vector2D vector){
		return vector.scale((float)(dotProduct(vector)/(Math.pow(vector.magnitude(), 2))));
	}
	
	public Vector2D substract(Vector2D vector){
		return new Vector2D(this.x-vector.getX(), this.y-vector.getY());
	}
	
	public float distance(Vector2D vector){
		return (float)(Math.sqrt(Math.pow(this.x-vector.getX(),2)+Math.pow(this.y-vector.getY(),2)));
	}
	public String toString(){
		return "x: "+getX()+"\ty: "+y;
	}
	
	public float crossProduct(Vector2D vector){
		
		return getX()*vector.getY()-vector.getX()*getY();
	}
	public void setX(float x){
		this.x=x;
	}
	public void setY(float y){
		this.y=y;
	}
	
}