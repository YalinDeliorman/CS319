
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;



public class GameOverPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainFrame frame;
	private BufferedImage img;
	private JTextField textField;
	private JTextField textField_1;
	
	public GameOverPanel(MainFrame frame, int score) {
		setLocation(0,0);
		setSize(800,500);
		setLayout(null);
		this.frame=frame;
		img=ImageReader.readPNGImage("Images//arkaplan.jpg");
		JButton backButton = new JButton("BACK");
		backButton.setLocation(20,450);
		backButton.setSize(80,30);
		backButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				menu();
			}
			
		});
		add(backButton);
		
		JLabel lblYourScore = new JLabel("Your Score");
		lblYourScore.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblYourScore.setBounds(267, 49, 102, 16);
		add(lblYourScore);
		
		textField = new JTextField();
		textField.setBounds(256, 77, 134, 28);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPleaseEnterYour = new JLabel("Please Enter Your Name:");
		lblPleaseEnterYour.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPleaseEnterYour.setBounds(78, 177, 175, 16);
		add(lblPleaseEnterYour);
		
		textField_1 = new JTextField();
		textField_1.setBounds(256, 172, 134, 28);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnEnter.setBounds(387, 172, 80, 29);
		add(btnEnter);
		
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
