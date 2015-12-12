import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
	
public class HighScoreManager
{
	private int[] hsPoints;
    private String[] hsNames;
    private String filename = "highscores.txt";
    private String playerName;
    FileReader fileReader;
    BufferedReader bufferedReader;
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    
    public HighScoreManager()
    {
    	hsPoints = new int[10];
    	hsNames = new String[10];
    	getHighscores();
    }
     
    public void getHighscores()
    {	       				 
    	String line = "1";
    	
    	try
    	{
    		fileReader = new FileReader(filename);
    		bufferedReader = new BufferedReader(fileReader);
    		
    		for(int i=0; i<20; i++)
    		{
 				line = bufferedReader.readLine();
 		
    			if(i%2==0)
    				hsPoints[i/2] = Integer.parseInt(line);
    			else
    				hsNames[i/2] = line;
    		}   
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace(System.out);
    	}		 	
    }
    
    public void writeHighscore(int points)
    {
    	int x = checkHighscore(points);
    	
    	if(x>-1)
    	{
    		playerName = JOptionPane.showInputDialog(null, points+" points!\nEnter your name");
        	
        	if(playerName==null)
        		playerName = "Player";
        	
        	for(int i=9; i>x; i--)
        	{
        		hsNames[i] = hsNames[i-1];
        		hsPoints[i] = hsPoints[i-1];
        	}
        	
        	hsNames[x] = playerName;
        	hsPoints[x] = points;
        	
        	try
    		{
    			fileWriter = new FileWriter(filename);
    			bufferedWriter = new BufferedWriter(fileWriter);    	
        
				for(int i=0; i<20; i++)
				{
					if (i%2==0)
						bufferedWriter.write(hsPoints[i/2]+"");
					else
						bufferedWriter.write(hsNames[i/2]);
						
					bufferedWriter.newLine();
				}
       			bufferedWriter.close();
    		}
    		catch(IOException e)
    		{
    			e.printStackTrace(System.out);
    		}
    	}    
    }
    
    public int getScoreAt(int position)
    {
    	return hsPoints[position];
    }
    
    public String getNameAt(int position)
    {
    	return hsNames[position];
    }
    
    private int checkHighscore(int points)
    {
    	for(int i=0; i<10; i++)
    	{
    		if(points >= hsPoints[i])
    			return i;
    	}
    	return -1;
    }
    
     
}	
	