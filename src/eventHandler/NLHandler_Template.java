/*
 * @authors 
 * Zhenxin Zhao 
 * Haoyu Wang
 * 
 * all copyright reserved.
 * 
 */

package eventHandler;

import java.awt.event.ActionEvent;
import customLayout.MainFrame;

/*--------------------------------------------------------------------------------------------
 * 	Template Pattern (because the algorithms of NextHandler and LastHandler is similar)
 --------------------------------------------------------------------------------------------*/
public abstract class NLHandler_Template extends ButtonsHandler {
	
	protected static int j = 0;
	
	public NLHandler_Template(){}
	
	public NLHandler_Template(MainFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	
	public void Operation1(){
		
        for(int i=0; i<vectorPlay.size(); i++){
            if(vectorPlay.get(i).toString().equals(filename)){
            	j = i;
            }
        }
	}	
	public abstract void Operation2();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Operation1();
		Operation2();
	}
}
