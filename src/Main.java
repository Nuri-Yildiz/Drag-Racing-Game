import javax.swing.JFrame;

public class Main extends JFrame {
	public Main(String string) {
		super(string);
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main pist1 = new Main("Prove Your Shifting Skills");
		
		pist1.setResizable(false);
		pist1.setFocusable(false);
		
		pist1.setSize(1920,480);
		pist1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Game game = new Game();
		
		game.requestFocus();
		
		game.addKeyListener(game);
		game.setFocusable(true);
		game.setFocusTraversalKeysEnabled(false); //klavye iþlemlerini anlamasý için gerekli olan komutlardan biri
        pist1.add(game);
        
        pist1.setVisible(true);
	}

}
