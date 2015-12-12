

	import java.awt.Graphics;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.image.BufferedImage;

	import javax.swing.JButton;
	import javax.swing.JPanel;



	public class TutorialPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private MainFrame frame;
		private BufferedImage img;
		public TutorialPanel(MainFrame frame) {
			setLocation(0,0);
			setSize(800,500);
			setLayout(null);
			this.frame=frame;
			img=ImageReader.readPNGImage("Images//tutorial.png");
			JButton backButton = new JButton("BACK");
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
		}
		public void menu(){
			frame.backToMenu();
		}
	}