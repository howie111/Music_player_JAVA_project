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

import customLayout.*;

/*-----------------------------------------------------------------------------------
 * 	Proxy Pattern (add some operations to the objects of class OpenHandler)
 ------------------------------------------------------------------------------------*/
public class OpenHandlerProxy extends ButtonsHandler{
	
	private OpenHandler openHandler;
	
	public OpenHandlerProxy(MainFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(openHandler == null){
			openHandler = new OpenHandler(mainFrame);
		}
		openHandler.Operation1();
		
		if(select_filename.equals(filename))
			return;
		else
			openHandler.Operation2();	
	}	
}
