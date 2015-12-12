


	import java.awt.Color;
	import java.awt.Font;
	import java.awt.Graphics;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.image.BufferedImage;

	import javax.swing.JButton;
	import javax.swing.JPanel;



	public class HighscorePanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private MainFrame frame;
		private BufferedImage img;
		private HighscoreManager highscores;
		public HighscorePanel(MainFrame frame) {
			setLocation(0,0);
			setSize(800,500);
			setLayout(null);
			this.frame=frame;
			img=ImageReader.readPNGImage("Images//arkaplan.jpg");
			JButton backButton = new JButton("BACK");
			highscores=new HighscoreManager();
			backButton.setLocation(20,465);
			backButton.setSize(80,30);
			backButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					menu();
				}
				
			});
			add(backButton);
			
		}
		
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(img,0,0,getWidth(),getHeight(),null);
			g.setColor(Color.pink);
			g.setFont(new Font("TimesRoman",Font.BOLD,30));
			g.drawString("HIGHSCORES", 300, 50);
			for(int i=0; i<10; i++){
				String name=highscores.getNameAt(i);
				g.drawString(name +"        "+highscores.getScoreAt(i), 100, 150+30*i);
			}
		}
		public void menu(){
			frame.backToMenu();
		}
	}