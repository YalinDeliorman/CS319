import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
public class GameDynamicsEngine extends Thread implements KeyListener{
	private ArrayList <GameObject> objects;
	private RenderPanel rp;
	private boolean started; 
	private Beast beast;
	private MainFrame frame;
	private Vector2D newGobjPos;
	private boolean shootBlock=false;
	private int time=0;
	private boolean gameMode;
	private boolean goOn=true;
	public GameDynamicsEngine(MainFrame frame,RenderPanel rp, boolean gameMode){
		this.newGobjPos=null;
		this.gameMode=gameMode;
		this.frame=frame;
		started=false;
		objects=new ArrayList<GameObject>();
		beast=new Beast("Images//chewy base.png", 500,70);
		this.rp=rp;
		objects.add(beast);
	}
	@Override
	public void run(){
		started=true;
		while(started){
			try {
				Thread.sleep(20);
				time+=20;
				rp.getFormattedTime(time);
				if(!gameMode && time%500==0){
					createEnemy(0.5f);
					createFood(0.3f);
					rp.updateProgBar(beast.getHealth());

				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			updatePos(20);
			checkCollision();
			rp.setGameObjects(objects);
			
			rp.repaint();
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {//esc ise ��k
		if (e.getKeyCode()==27) {
			goOn = false;
			menu();
		}
		else if(e.getKeyCode()==32){//space ise ate� et
			if(!shootBlock){
				shoot();
				shootBlock=true;
			}	
		}	
		else if(SettingPanel.controls){
			 if(e.getKeyCode()==39){//sa�a git
				
				beast.translateX(20);
			}
			else if(e.getKeyCode()==37){//sola git
				
				beast.translateX(-20);
			}
		}
		else if(!SettingPanel.controls){
			if(e.getKeyCode()==68){//sa�a git
				
				beast.translateX(20);
			}
			else if(e.getKeyCode()==65){//sola git
				
				beast.translateX(-20);
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==32){//space ise ate� et
				shootBlock=false;
		}	
	}
	@Override
	public void keyTyped(KeyEvent e) {
	
	}
	public void menu(){
		frame.backToMenu();
		}
	public void shoot(){
		objects.add(new Bullet(beast.getPosition().getX(), beast.getPosition().getY()+50));
	}
	public void updatePos(float timePassed){
		ArrayList<GameObject> toRemove=new ArrayList<>();
		for(GameObject go: objects){
			go.updatePosition(timePassed);
			if(go.getPosition().getX()>frame.getWidth()+100){
				toRemove.add(go);
			}
			else if(go.getPosition().getY()>frame.getHeight()+100){
				toRemove.add(go);
			}
			else if(go.getPosition().getX()<-100){
				toRemove.add(go);
			}
			else if(go.getPosition().getY()<-100){
				toRemove.add(go);
			}
		}
		for(GameObject gob: toRemove){
			objects.remove(gob);
		}
	}
	public void createEnemy(float probability){
		if(probability>Math.random()){
			if(Math.random()<0.33f){
				objects.add(new DavidDavenport((float)Math.random()*800,500));
			}
			else if(Math.random()<0.33f)
				objects.add(new OkanTekman((float)Math.random()*800,500));
			
			else if(Math.random()<0.33f)
				objects.add(new WillSawyer((float)Math.random()*800,500));
		}
	}
	public void createFood(float probability){
		if(probability>Math.random()){
			if(Math.random()<0.55f){
				objects.add(new Meat((float)Math.random()*800,500));
			}
	    else if(Math.random()<0.10f)
			objects.add(new Sugar((float)Math.random()*800,500));
			
			else if(Math.random()<0.33f)
				objects.add(new Vegetable((float)Math.random()*800,500));
		}
	}

	
	public void checkCollision(){
		for(int i=0;i<objects.size(); i++){
			for(int j=0; j<objects.size(); j++){
				if(i!=j){
					if(objects.get(i).doesCollide(objects.get(j))){					
						objects.get(i).collided(objects.get(j));
						if(objects.get(i) instanceof Creature){
							objects.remove(i);
							j=0;
						}
						else if(objects.get(j) instanceof Creature){
							objects.remove(j);
							j--;
						}
						if(objects.get(i) instanceof Food){
							objects.remove(i);
							j=0;
						}
						else if(objects.get(j) instanceof Food){
							objects.remove(j);
							j--;
						}
						if(beast.getHealth()<=0){
							frame.gameOver(time/1000);
						}
					}
				}
			}
		}		
	}
}
	