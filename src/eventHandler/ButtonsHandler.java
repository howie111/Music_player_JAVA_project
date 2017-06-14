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
import java.util.Vector;
import customLayout.*;
import javax.media.*;

/*---------------------------------------------------------------------------------------------
 * 	Command Pattern (implements the interface java.awt.event.ActionListener)
 ----------------------------------------------------------------------------------------------*/
 /* Used to handle the normal buttons*/
public class ButtonsHandler extends EventHandler implements ActionListener{
		
	public ButtonsHandler(){}
	
	public ButtonsHandler(MainFrame mainFrame){
		this.mainFrame = mainFrame;
		vectorPlay = new Vector<String>();
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
        if (e.getActionCommand().equals("Play")) { 
        	
        	if(player != null){
        		player.start();
        		mainFrame.labelFileName.setText("Currently Playing: "+ filename);
        	}
            return;   
        } 
        
        if (e.getActionCommand().equals("Pause")) {
        	
    		if(player != null){
    			player.stop();
    			mainFrame.labelFileName.setText("The Music Is Paused");
    		} 
            return;   
        } 
        
        if (e.getActionCommand().equals("Stop")) {   
       
            if (player != null) {   
                player.stop();   
                player.setMediaTime(new Time(0));
                mainFrame.labelFileName.setText("The Music Is Stopped");
            }   
            return;
        }        
        
        if (e.getActionCommand().equals("Remove")) {   
        	
    		if(mainFrame.listPlay.getSelectedIndex()>=0){
    			
    			//When remove the music that is currently being played, the music should stop
    			if(mainFrame.listPlay.getSelectedValue().toString().equals(filename)){
    				player.close();
                    mainFrame.labelFileName.setText("The Currently Playing Music Has Been Removed");
                    filename = "No Music"; //ensure that the music has been deleted
    			}
    			
    			vectorPlay.removeElementAt(mainFrame.listPlay.getSelectedIndex());
    			mainFrame.listPlay.setListData(vectorPlay);
    		}  
            return;   
        }  
        
        if (e.getActionCommand().equals("Exit")) {
        	
        	System.out.println("Program Exit");
        	System.exit(0); 
        } 
        
	}
}
