

public class Main {

	public static void main(String[] args) {
		MenuPanel welcomeScreen=new MenuPanel();
		MainFrame frame=new MainFrame(welcomeScreen,"The Hungry Beast");
		welcomeScreen.setFrame(frame);

	}

}
