/*
 * @authors 
 * Zhenxin Zhao 
 * Haoyu Wang
 * 
 * all copyright reserved.
 * 
 */

package myPlayer;

import java.awt.Component;

import javax.swing.JButton;

import customLayout.*;
import eventHandler.*;
import windowHandler.*;
import comboBoxHandler.*;

/*
 * Link all the classes together to realize the music player
 */
public class MyPlayer {
	
	private MainFrame mainFrame;
	private ButtonsHandler buttonsHandler;
	private PlayListHandler playListHandler;
	private WindowHandler windowHandler;
	private ComboBoxHandler comboBoxHandler;
	private OpenHandlerProxy openHandlerProxy;
	private NLHandler_Template nextHandler;
	private NLHandler_Template lastHandler;
	
	public MyPlayer(){
		mainFrame = MainFrame.getInstance();
		buttonsHandler = new ButtonsHandler(mainFrame);
		playListHandler = new PlayListHandler(mainFrame);
		windowHandler = new WindowHandler(mainFrame);
		openHandlerProxy = new OpenHandlerProxy(mainFrame);
		comboBoxHandler = new ComboBoxHandler(mainFrame);
		nextHandler = new NextHandler(mainFrame);
		lastHandler = new LastHandler(mainFrame);
		
		AddListener();
	}
	
	/*
	 * Add listeners to the buttons, comboBox, and playList
	 */
	public void AddListener(){		
		mainFrame.addWindowListener(windowHandler);
		mainFrame.listPlay.addMouseListener(playListHandler);	
		mainFrame.comboBox.addActionListener(comboBoxHandler);
		
		for(int i=0; i<mainFrame.buttons1.getComponentCount();i++){
			Component comp = mainFrame.buttons1.getComponent(i);
			if(comp instanceof JButton){
				JButton btn = (JButton)comp;
				btn.addActionListener(buttonsHandler);
			}
		}
		
		for(int i=0; i<mainFrame.buttons2.getComponentCount();i++){
			Component comp = mainFrame.buttons2.getComponent(i);
			if(comp instanceof JButton){
				JButton btn = (JButton)comp;
				if(btn.getText()=="Open")
					btn.addActionListener(openHandlerProxy);
				else if(btn.getText()=="Next")
					btn.addActionListener(nextHandler);
				else if(btn.getText()=="Last")
					btn.addActionListener(lastHandler);
				else
					btn.addActionListener(buttonsHandler);
			}
		}
	}
	
  public static void main(String[] args) { 
	new MyPlayer();
  }
	
}
	

