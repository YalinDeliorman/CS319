import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private JPanel currentPanel;
	private GameDynamicsEngine gde;
	public MainFrame(JPanel currentPanel,String title){
		super(title);
		setLocation(50,50);
		setSize(1000,600);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.currentPanel=currentPanel;
		add(currentPanel);
		setVisible(true);
	}
	public void startGame(){
		remove(currentPanel);
		currentPanel=new SelectModePanel(this);
		add(currentPanel);
		repaint();
		
	}
	public void highscores(){
		remove(currentPanel);
		currentPanel=new HighScorePanel(this);
		add(currentPanel);
		repaint();
		
	}
	public void tutorial(){			
		remove(currentPanel);
		currentPanel=new TutorialPanel(this);
		add(currentPanel);
		repaint();
		
	}
	public void credits(){
		remove(currentPanel);
		currentPanel=new CreditPanel(this);
		add(currentPanel);
		repaint();
		
	}
	public void settings(){
		remove(currentPanel);
		currentPanel=new SettingPanel(this);
		add(currentPanel);
		repaint();
		
	}
	public void backToMenu(){
		
			removeKeyListener(gde);
			remove(currentPanel);
			currentPanel=new MenuPanel();
			((MenuPanel)currentPanel).setFrame(this);
			add(currentPanel);
			repaint();
		
	}
	public void play(boolean gameMode){
		
		remove(currentPanel);
		currentPanel=new RenderPanel(this);
		gde=new GameDynamicsEngine(this,(RenderPanel)currentPanel, gameMode);
		addKeyListener((KeyListener)(gde));
		this.requestFocusInWindow();
		add(currentPanel);
		gde.start();
		repaint();
	}
	public void gameOver(int score){
		removeKeyListener(gde);
		remove(currentPanel);
		currentPanel=new GameOverPanel(this,score);
		add(currentPanel);
		repaint();
	
	}
	
}
