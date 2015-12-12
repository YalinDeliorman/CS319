import java.awt.Graphics;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.image.BufferedImage;

	import javax.swing.JButton;
	import javax.swing.JPanel;
	public class SelectModePanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private MainFrame frame;
		private BufferedImage img;
		private boolean ifTime;
		public SelectModePanel(MainFrame frame) {
			setLocation(0,0);
			setSize(800,500);
			setLayout(null);
			this.frame=frame;
			img=ImageReader.readPNGImage("Images//select gmode.png");
			JButton backButton = new JButton("BACK");
			backButton.setLocation(20,450);
			backButton.setSize(80,30);
			backButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					menu();
				}
			});
			JButton playButton = new JButton("PLAY");
			playButton.setLocation(465,340);
			playButton.setSize(196,100);
			playButton.setEnabled(false);
			playButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					run();
				}
			});
			JButton timeButton = new JButton("VERSUS TIME");
			timeButton.setLocation(100,150);
			timeButton.setSize(440,50);
			timeButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					playButton.setEnabled(true);
					setIfTime(true);
				}
			});
			JButton creatureButton = new JButton("VERSUS CREATURES");
			creatureButton.setLocation(100,210);
			creatureButton.setSize(680,55);
			creatureButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					playButton.setEnabled(true);
					setIfTime(false);
				}
			});
			add(backButton);
			add(timeButton);
			add(creatureButton);
			add(playButton);
		}
		public boolean getIfTime(){
			return ifTime;
		}
		public void setIfTime(boolean b){
			ifTime=b;
		}
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(img,0,0,getWidth(),getHeight(),null);
		}
		public void menu(){
			frame.backToMenu();
		}
	
	public void run(){
		frame.play(ifTime);
	}
	
}