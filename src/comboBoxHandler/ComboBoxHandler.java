/*
 * @authors 
 * Zhenxin Zhao 
 * Haoyu Wang
 * 
 * all copyright reserved.
 * 
 */

package comboBoxHandler;

import java.awt.event.*;
import customLayout.*;

/*---------------------------------------------------------------------------------------------
 * 	Command Pattern (implements the interface java.awt.event.ActionListener)
 ----------------------------------------------------------------------------------------------*/
public class ComboBoxHandler implements ActionListener{

	MainFrame mainFrame = null;
	private int index;
	
	public ComboBoxHandler(MainFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == mainFrame.comboBox)
			 index = mainFrame.comboBox.getSelectedIndex();
		switch (index){
		case 0:
			mainFrame.loopOne = false;
			mainFrame.loopAll = false;
			break;
		case 1:
			mainFrame.loopOne = true;
			mainFrame.loopAll = false;
			break;
		case 2:
			mainFrame.loopOne = false;
			mainFrame.loopAll = true;
			break;
		}
	}
}
