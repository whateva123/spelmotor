package spelmotorn;

import java.awt.event.*;


/*
 * addKeyListener(new KeyboardInputs) skall läggas till där spelet körs. dvs antingen loadern eller renderare.
 */

public class KeyboardInput extends KeyAdapter{

	public void keyPressed(KeyEvent e){
		int keys = e.getKeyCode();
		if(keys == KeyEvent.VK_A)
			//ChangeX - 2;
		if(keys = KeyEvent.VK_D)
			//ChangeX + 2;
		if(keys = KeyEvent.VK_W)
			//ChangeY + 2;
		if(keys = KeyEvent.VK_S)
			//ChangeY - 2;
		if(keys = KeyEvent.VK_SPACE)
			//Jump
			//jumpSoundMethod()
	}
	
/*
 * För att skapa metod som lyssnar på vilken tagnet man tycker är det bara lägga till en if-sats.
 * KeyEvent.VK_A -> returnerar en int som representerar tagnenten i unicode. Dvs. KeyEvent.VK_A -> 56.
 * Man kan också skriva det som:
 * 
 * if (e.getKeyCode() == KeyEvent.VK_A)
 *  ChangeX(-2);
 *  
 */
	
	
}
