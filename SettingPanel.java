	import java.awt.Graphics;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.image.BufferedImage;

	import javax.swing.JButton;
	import javax.swing.JPanel;



	public class SettingPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private MainFrame frame;
		private BufferedImage img;
		public static int color;
		public static boolean controls=true;
		public boolean getControls() {
			return controls;
		}

		public void setControls(boolean controls) {
			this.controls = controls;
		}
		

		public SettingPanel(MainFrame frame) {
			setLocation(0,0);
			setSize(800,500);
			setLayout(null);
			this.frame=frame;
			controls=true;
			img=ImageReader.readPNGImage("Images//settings.png");
			
			JButton backButton = new JButton("BACK");
			backButton.setLocation(20,450);
			backButton.setSize(80,30);
			color=1;
			backButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					menu();
				}
				
			});
			add(backButton);
			
			JButton wa_button = new JButton("1");
			wa_button.setBounds(171, 360, 65, 19);
			wa_button.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					setControls(false);
				}
				
			});
			add(wa_button);
			
			JButton rl_button = new JButton("2");
			rl_button.setBounds(342, 360, 55, 19);
			rl_button.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					setControls(true);
				}
				
			});
			add(rl_button);
			
			JButton greenCreature = new JButton("Green");
			greenCreature.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color=3;
				}
				
			});
			greenCreature.setBounds(109, 233, 72, 29);
			add(greenCreature);
			
			
			JButton darkCreature = new JButton("Dark");
			darkCreature.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color=2;
				}
			});
			darkCreature.setBounds(257, 233, 80, 29);
			add(darkCreature);
			
			
			JButton defaultCreature = new JButton("Default");
			defaultCreature.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color=1;
				}
			});
			defaultCreature.setBounds(413, 233, 80, 29);
			add(defaultCreature);
			
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


