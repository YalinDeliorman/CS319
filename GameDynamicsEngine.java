import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
public class GameDynamicsEngine extends Thread implements KeyListener{
	private ArrayList <GameObject> objects;
	private RenderPanel rp;
	private boolean started; 
	private Beast beast;
	private MainFrame frame;
	private boolean shootBlock=false;
	private int time=0;
	private boolean gameMode;
	private boolean goOn=true;
	private int weaponType;
	public GameDynamicsEngine(MainFrame frame,RenderPanel rp, boolean gameMode){
		this.gameMode=gameMode;
		this.frame=frame;
		started=false;
		objects=new ArrayList<GameObject>();
		beast=new Beast("Images\\chewy base.png", 500,70);
		this.rp=rp;
		objects.add(beast);
		weaponType=0;
	}
	@Override
	public void run(){
		started=true;
		while(started){
			try {
				Thread.sleep(20);
				time+=20;
				rp.getFormattedTime(time);
				rp.updateProgBar(beast.getHealth());
				if(time%500==0){
					createFood(0.3f);
					if(!gameMode){
						createEnemy(0.5f);
					}	
				}
				if(time%2000==0){
					beast.setHealth(beast.getHealth()-20);
				}
				if(time%60000==0){
					upgradeWeapon();
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
	public void keyPressed(KeyEvent e) {//esc ise çýk
		if (e.getKeyCode()==27) {
			goOn = false;
			menu();
		}
		else if(e.getKeyCode()==32){//space ise ateþ et
			if(!shootBlock){
				shoot();
				shootBlock=true;
			}	
		}	
		else if(SettingPanel.controls){
			 if(e.getKeyCode()==39){//saða git
				
				beast.translateX(20);
			}
			else if(e.getKeyCode()==37){//sola git
				
				beast.translateX(-20);
			}
		}
		else if(!SettingPanel.controls){
			if(e.getKeyCode()==68){//saða git
				
				beast.translateX(20);
			}
			else if(e.getKeyCode()==65){//sola git
				
				beast.translateX(-20);
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==32){//space ise ateþ et
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
		if(weaponType==0)
			objects.add(new Wood(beast.getPosition().getX(), beast.getPosition().getY()+50));
		else if(weaponType==1)
			objects.add(new Bullet(beast.getPosition().getX(), beast.getPosition().getY()+50));
		else if(weaponType==2)
			objects.add(new LaserGun(beast.getPosition().getX(), beast.getPosition().getY()+50));
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
			else if(Math.random()<0.66f)
				objects.add(new OkanTekman((float)Math.random()*800,500));
			
			else
				objects.add(new WillSawyer((float)Math.random()*800,500));
		}
	}
	public void createFood(float probability){
		if(probability>Math.random()){
			if(Math.random()<0.33f){
				objects.add(new Meat((float)Math.random()*800,500));
			}
			else if(Math.random()<0.66f)
				objects.add(new Sugar((float)Math.random()*800,500));
			
			else 
				objects.add(new Vegetable((float)Math.random()*800,500));
		}
	}
	public void checkCollision(){
		for(int i=0;i<objects.size(); i++){
			for(int j=0; j<objects.size(); j++){
				if(i!=j){
					if(objects.get(i).doesCollide(objects.get(j))){
						objects.get(i).collided(objects.get(j));
						objects.get(j).collided(objects.get(i));
						if(objects.get(i) instanceof Weapon){
							objects.remove(i);
							j=0;
						}
						else if(objects.get(j) instanceof Weapon){
							objects.remove(j);
							j--;
						}
						else if(objects.get(i) instanceof Beast && 
								objects.get(j) instanceof Creature){
							objects.remove(j);
							j--;
						}
						else if(objects.get(j) instanceof Beast && 
								objects.get(i) instanceof Creature){
							objects.remove(i);
							j=0;
						}
						else if(objects.get(i) instanceof Beast && 
								objects.get(j) instanceof Food){
							if(((Food)objects.get(j)).getEnable()){
								objects.remove(j);
								j--;
							}
							
						}
						else if(objects.get(j) instanceof Beast && 
								objects.get(i) instanceof Creature){
							if(((Food)objects.get(i)).getEnable()){
								objects.remove(i);
								j=0;
							}
							
						}
						if(beast.getHealth()<=0){
							frame.gameOver(time/1000);
							started=false;
						}
					}
				}
			}
		}		
	}
	public void upgradeWeapon(){
		if(weaponType<2){
			weaponType++;
		}
	}
}