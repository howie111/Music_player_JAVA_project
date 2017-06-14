/*
 * @authors 
 * Zhenxin Zhao 
 * Haoyu Wang
 * 
 * all copyright reserved.
 * 
 */

package eventHandler;

import java.util.*;
import javax.media.*;
import customLayout.MainFrame;

/* The super class of all the classes in this package*/
public abstract class EventHandler {
	
	MainFrame mainFrame = null;
	public static Player player = null;
	protected static String filename = null;
	protected static String select_filename = null;
	protected static Vector<String> vectorPlay = null;
	protected static PlayerController playerController = null;
	
	public String getFileName(){
		return filename;
	}
	
	public Vector<String> getPlaylist(){
		return vectorPlay;
	}
	
}
