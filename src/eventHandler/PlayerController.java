/*
 * @authors 
 * Zhenxin Zhao 
 * Haoyu Wang
 * 
 * all copyright reserved.
 * 
 */

package eventHandler;

import javax.media.*;

import customLayout.MainFrame;

/*
 * Implements the interface ControllerListener, used to control MediaPlayer
 */
public class PlayerController extends EventHandler implements ControllerListener{
	
	public PlayerController(MainFrame mainFrame){
		this.mainFrame = mainFrame;
	}
		
	@Override
	public void controllerUpdate(ControllerEvent e){
		
		if(e instanceof EndOfMediaEvent){
			
			//When finishing playing, set the pointer of playing to the beginning
			player.setMediaTime(new Time(0));
			
			//When set loopOne, the player will be restarted
			if(mainFrame.loopOne){
				player.start();
				mainFrame.labelFileName.setText("Currently Playing: "+ filename);
			}
			
			//Handle the case of loop all the music on the playlist
			else if(mainFrame.loopAll){
				
				int j=0;

	            for(int i=0; i<vectorPlay.size(); i++){
	                if(vectorPlay.get(i).toString().equals(filename)){
	                	j = i;
	                }
	            }
	                
	            if(vectorPlay.size()>2 || vectorPlay.size()==2){
	                if(j == vectorPlay.size()-1){
	            		filename = vectorPlay.get(0).toString();
	                }else {
	            		filename = vectorPlay.get(j+1).toString();
	                }
	                if(player !=null)
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
	           	   	mainFrame.labelFileName.setText("Currently Playing: "+ filename);
	            } else {
	            	player.start();
	            	mainFrame.labelFileName.setText("Currently Playing: "+ filename);
	            }
			}
            else {
    			mainFrame.labelFileName.setText("Playing Ends, Please Choose A Music To Play");	
            }
			
			return;
		}
		
		//When PrefetchCompleteEvent happened, call start() to restart the player
        if (e instanceof PrefetchCompleteEvent){  
            player.start();
            mainFrame.labelFileName.setText("Currently Playing: " + filename);
            return;   
        }  
	}
}
