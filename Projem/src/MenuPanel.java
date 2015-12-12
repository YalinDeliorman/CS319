
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;



public class MenuPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainFrame frame;
	private BufferedImage img;
	public MenuPanel(){
		setLocation(0,0);
		setSize(800,500);
		setLayout(null);
		img=ImageReader.readPNGImage("Images//main.png");
		JButton newGameButton=new JButton("PLAY GAME");
		JButton settingsButton=new JButton("SETTINGS");
		JButton highscoreButton=new JButton("HIGHSCORES");
		JButton tutorialButton=new JButton("TUTORIAL");
		JButton creditButton=new JButton("CREDITS");
		
		newGameButton.setSize(330,50);
		newGameButton.setLocation(140,130);
		
		settingsButton.setSize(300,50);
		settingsButton.setLocation(140,185);
		
		highscoreButton.setSize(390,50);
		highscoreButton.setLocation(140,240);
		
		tutorialButton.setSize(310,50);
		tutorialButton.setLocation(140,295);
		
		creditButton.setSize(300,50);
		creditButton.setLocation(140,355);
		
		newGameButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				startGame();
			}
		});
		settingsButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				settingScreen();
			}
		});
		highscoreButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				highscoreScreen();
			}
		});
		tutorialButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tutorialScreen();
			}

		});
		creditButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				creditScreen();
			}

		});
		add(newGameButton);
		add(settingsButton);
		add(highscoreButton);
		add(tutorialButton);
		add(creditButton);
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img,0,0,getWidth(),getHeight(),null);
	}
	public void startGame(){
		frame.startGame();
	}
	public void highscoreScreen(){
		frame.highscores();
	}
	public void tutorialScreen(){
		frame.tutorial();
	}
	public void creditScreen(){
		frame.credits();
	}
	public void settingScreen(){
		frame.settings();
	}
}
