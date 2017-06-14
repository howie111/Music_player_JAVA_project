/*
 * @authors 
 * Zhenxin Zhao 
 * Haoyu Wang
 * 
 * all copyright reserved.
 * 
 */

package customLayout;

/*---------------------------------------------------------------------------------------------
 	Factory Pattern Method
 ----------------------------------------------------------------------------------------------*/
public abstract class AbstractFactory {
	
	protected String[] Name;
	
	public int count(){
		return Name.length;
	}
	
	public String getName(int i){
		return Name[i];
	}

}
