/*
 * @authors 
 * Zhenxin Zhao 
 * Haoyu Wang
 * 
 * all copyright reserved.
 * 
 */

package windowHandler;

import java.awt.event.*;

import customLayout.MainFrame;

/*---------------------------------------------------------------------------------------------
 * 	Adapter Pattern (used to handle the case of closing window)
 ----------------------------------------------------------------------------------------------*/
public class WindowHandler extends WindowAdapter{
		
	private MainFrame mainFrame;
	
	public WindowHandler(MainFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	
    //use the adapter to realize the close of window      
	@Override
	public void windowClosing(WindowEvent e) {  
        System.out.println("Program Exit");
        //call the method dispose of the JFrame to implement event of closing window  
        mainFrame.dispose();
    }  
		
	@Override
    public void windowClosed(WindowEvent e) { 
        System.exit(0);   
    }    

}
