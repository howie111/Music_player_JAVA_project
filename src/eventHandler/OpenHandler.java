/*
 * @authors 
 * Zhenxin Zhao 
 * Haoyu Wang
 * 
 * all copyright reserved.
 * 
 */

package eventHandler;

import java.awt.*;
import java.awt.event.*;
import javax.media.*;

import customLayout.*;

/*
 * Handle the case when click the Button "Open"
 */
public class OpenHandler extends ButtonsHandler{
	
	public OpenHandler(MainFrame mainFrame){
		this.mainFrame = mainFrame;
		playerController = new PlayerController(mainFrame);
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		Operation1();
		Operation2();		
	}	
	
	
	public void Operation1(){
		FileDialog fd = new FileDialog(mainFrame, "Open Media Files", FileDialog.LOAD);  
        fd.setVisible(true);   

        //If the user give up to choose the file,then just return  
        if (fd.getFile() == null)   
            return;   

        //Save the name and path of selected file and use it later  
        //At the same time, it will set the current path of the file   
        select_filename = fd.getDirectory() + fd.getFile();   
        
        boolean j = false;
        for(int i=0; i<vectorPlay.size(); i++){
        	//prevent to add the same files to the playlist
        	if(vectorPlay.get(i).toString().equals(select_filename)){
        		j = true;
        		break;
        	}
        }
        
        if(j == false){
        	vectorPlay.add(select_filename);  //Add names to the vector
        	//Display the names in the vector to the JList
        	mainFrame.listPlay.setListData(vectorPlay); 
        } 
	}
	
	
	public void Operation2(){
        
        filename = select_filename;
        
        //If there is an existing player,close it and create a new one later  
        //when create the player, exceptions should be caught
        if(player != null)
        	player.close();
        try {   
            player = Manager.createPlayer(new MediaLocator("file:" + filename));  
        } catch (java.io.IOException e2) {   
            System.out.println(e2);   
            return;   
        } catch (NoPlayerException e2) {   
            System.out.println("can not find the player.");   
            return;   
        }   
        if (player == null) {   
            System.out.println("can not create player.");   
            return;   
        }
        
        //set the controller listener
        player.addControllerListener(playerController);   
        player.prefetch();
        
        mainFrame.first = false;
	}
}
