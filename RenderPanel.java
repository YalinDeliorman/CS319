
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class RenderPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private ArrayList<GameObject> objects;
	private BufferedImage backgroundImage;
	private String timeLabel;
	private JProgressBar progressBar;
	public RenderPanel(MainFrame frame){
		setLocation(0,0);
		setSize(1000,500);
		setLayout(null);
		backgroundImage=ImageReader.readPNGImage("Images//arkaplan.jpg");
		objects = new ArrayList<GameObject>();
		timeLabel="00:00:00";
		progressBar = new JProgressBar();
		progressBar.setBounds(800, 53, 146, 20);
		add(progressBar);
		updateProgBar(100);
		JLabel lblHealth = new JLabel("Health");
		lblHealth.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblHealth.setBounds(800, 35, 61, 16);
		lblHealth.setForeground(Color.red);
		add(lblHealth);
	}
	public ArrayList<GameObject> getGameObjects(){
		return objects;
	}
	public void setGameObjects(ArrayList<GameObject> object){
		this.objects=object;
	}
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g.clearRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.white);
		
		g.drawImage(backgroundImage, 0, 0, null); 
		g.setFont(new Font("TimesRoman",Font.BOLD,30));
		g.drawString(timeLabel, 850, 30);
		
		
		for (int i = 0; i < objects.size(); i++) {
			
			GameObject gobj = objects.get(i);

			int height = gobj.getImage().getHeight();
			int width = gobj.getImage().getWidth();
			
			g.drawImage(gobj.getImage(), (int)(gobj.getPosition().getX() - (width / 2)), 
					(int)(getHeight() - (gobj.getPosition().getY() + (height / 2))), null); 
		}
	}
	public void updateProgBar(int newValue) {
		progressBar.setValue(newValue);
		if(progressBar.getValue() <= 25)
			progressBar.setForeground(Color.RED);
		else if(progressBar.getValue() <= 70)
			progressBar.setForeground(Color.YELLOW);
		else 
			progressBar.setForeground(Color.GREEN);
		
	}
	public void getFormattedTime(int mili){
		int milisecond=mili%1000;
		milisecond=milisecond/10;
		mili=mili/1000;
		int second=mili%60;
		mili=mili/60;
		int minute=mili%60;
		timeLabel= minute+":"+second+":"+milisecond;
	}
}
