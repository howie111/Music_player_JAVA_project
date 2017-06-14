/*
 * @authors 
 * Zhenxin Zhao 
 * Haoyu Wang
 * 
 * all copyright reserved.
 * 
 */

package eventHandler;

import java.awt.event.*;

import javax.media.*;

import customLayout.MainFrame;

/*-------------------------------------------------------------------------------------------------
 * 	Command Pattern (implements the interface of java.awt.event.MouseListener)
 --------------------------------------------------------------------------------------------------*/ 
/* used to handler clicking of mouse on the playlist*/
public class PlayListHandler extends EventHandler implements MouseListener{
	
	public PlayListHandler(MainFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void mouseClicked(MouseEvent	e)	{

		if (e.getClickCount() == 2)	{ 
			String str = (String) mainFrame.listPlay.getSelectedValue();
			//If str is null, do nothing; Otherwise, display the selected song
			if (str	== null) {
				return;
			}
			filename = str;
			
			if(player != null)
				player.close();
			
	        try {   
	            player = Manager.createPlayer(new MediaLocator("file:" + filename));   
	   
	        } catch (java.io.IOException e2) {   
	            System.out.println(e2);   
	            return;   
	        } catch (NoPlayerException e2) {   
	            System.out.println("cannot find the music");   
	            return;   
	        } 
	        //set the controller listener
	        player.addControllerListener(playerController); 
			player.realize();	 
			player.start();	
			mainFrame.labelFileName.setText("Currently Playing: " + filename);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
