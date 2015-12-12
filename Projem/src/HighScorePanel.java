
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;



public class HighScorePanel extends JPanel implements Observer
{
	private MainFrame frame;
	private static final long serialVersionUID = 1L;
	private JButton back;
	private JTable scoreTable;
	private JLabel observedScore, observedRank;
	private int totalNo;
	private BufferedImage img;
	private HighScoreManager scores;

	public HighScorePanel(MainFrame frame )
	{
		setLocation(0,0);
		setSize(800,500);
		setLayout(null);
		this.frame=frame;
		img=ImageReader.readPNGImage("Images//arkaplan.jpg");
		
		scores = new HighScoreManager();
		
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
		JLabel title = new JLabel( "High Scores");
		title.setFont( new Font( "Tahoma", Font.BOLD, 28));
		title.setForeground( new Color( 255, 0, 0));
		title.setBounds( 350, 55, 293, 94);
		add( title);
		
		
		
		scoreTable = new JTable( 10, 2);
		scoreTable.setBounds( 280, 200, 300, 100);
		scoreTable.setSize( 300, 160);
		scoreTable.setBackground( Color.GREEN);
		scoreTable.setEnabled( false);
		add( scoreTable);
		
		for (int i = 0; i < scoreTable.getRowCount(); i++)
		{
			scoreTable.setValueAt( "-", i, 0);
			scoreTable.setValueAt( "-", i, 1);
		}
		
		observedScore = new JLabel();
		observedScore.setBounds( 300, 400, 100, 20);
		add( observedScore);
		
		observedRank = new JLabel();
		observedRank.setBounds( 450, 400, 200, 20);
		add( observedRank);
	}
	
	public void setScoreTable()
	{
		for (int i = 0; i < totalNo; i++)
		{
			if (scores == null)
				break;
			else
			{
				//scoreTable.setValueAt( scores.getHighScore(), i, 0);
				//scoreTable.setValueAt( scores.getHighScore(), i, 1);
			}
		}
		
		for (int i = totalNo; i < scoreTable.getRowCount(); i++)
		{
			scoreTable.setValueAt( "-", i, 0);
			scoreTable.setValueAt( "-", i, 1);
		}
	}
	
	public void setTotalNo( int totalNo)
	{
		this.totalNo = totalNo;
	}

	@Override
	public void update( Observable o, Object arg1)
	{
		
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

