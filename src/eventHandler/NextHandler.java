/*
 * @authors 
 * Zhenxin Zhao 
 * Haoyu Wang
 * 
 * all copyright reserved.
 * 
 */

package eventHandler;

import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;

import customLayout.MainFrame;

/*
 * Handle the case when click the Button "Next"
 */
public class NextHandler extends NLHandler_Template {
	public NextHandler(MainFrame mainFrame){
		this.mainFrame = mainFrame;
	}

	@Override
	public void Operation2(){
		
		if(vectorPlay.size()>2 || vectorPlay.size()==2){
            if(j == vectorPlay.size()-1){
        		filename = vectorPlay.get(0).toString();
            }else {
        		filename = vectorPlay.get(j+1).toString();
            }
              		
            if (player != null)   
            	player.close();   
            try {   
            	player = Manager.createPlayer(new MediaLocator("file:" + filename));   
     
            } catch (java.io.IOException e2) {   
            	System.out.println(e2);   
            	return;   
            } catch (NoPlayerException e2) {   
            	System.out.println("Cannot find the player");   
        	   	return;   
            }
            //set the controller listener
            player.addControllerListener(playerController);  
            player.realize();
       	   	player.start();
       	   	mainFrame.labelFileName.setText("Currently Playing: " + filename);
    	} else {
    		return;
    	}
	}
}
