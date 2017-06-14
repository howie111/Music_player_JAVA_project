/*
 * @authors 
 * Zhenxin Zhao 
 * Haoyu Wang
 * 
 * all copyright reserved.
 * 
 */

package customLayout;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7274294003117494486L;
	
	/*The components of the mainFrame*/
	public JPanel buttons1 = new JPanel();
	public JPanel buttons2 = new JPanel();
	public JPanel playlist = new JPanel();
	public JComboBox<String> comboBox = new JComboBox<String>();
	public JList<String> listPlay;
	public JLabel labelFileName;
	
	/*variable first used to control the welcome interface*/
	public boolean first = true;
	
	/*variable loopOne used to control the mode of loopOne
	 *variable loopAll used to control the mode of loopAll*/
	public boolean loopOne = false, loopAll = false;
	
/*-------------------------------------------------------------------------------------------
	Singleton Pattern (Ensure just one object of this class in the whole system)
---------------------------------------------------------------------------------------------*/
	private volatile static MainFrame mainFrame = null;
  
	private MainFrame(){
		super("MyPlayer - ENGI9874 Project");
		
		listPlay = new JList<String>();
		labelFileName = new JLabel("Please Open A Music");
		
		SetLayout();
		
		//Set the parameters of the mainFrame
		setSize(500, 510);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static MainFrame getInstance(){
		if(mainFrame == null){
			synchronized(MainFrame.class){
				if(mainFrame == null){
					mainFrame = new MainFrame();
				}
			}
		}
		return mainFrame;
	}
/*-------------------------------------------------------------------------------------------
 * ------------------------------------------------------------------------------------------*/	
	
	/*the method SetLayout used to set the mainFrame*/
	public void SetLayout(){
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		AbstractFactory bf1 = new Buttons1Factory();
		AbstractFactory bf2 = new Buttons2Factory();
		AbstractFactory cf = new ComboBoxFactory();
			
		for(int i=0; i<bf1.count(); i++){
			JButton button = new JButton(bf1.getName(i));
			button.setFont(new Font("Sans", Font.BOLD, 14));
			buttons1.add(button);
		}
		c.add(buttons1);
		
		for(int i=0; i<cf.count(); i++){
			comboBox.addItem(cf.getName(i));
			comboBox.setFont(new Font("Sans", Font.BOLD, 14));
		}
		c.add(comboBox);
		
		labelFileName.setForeground(Color.MAGENTA);
		c.add(labelFileName);
		
		listPlay = new JList<String>();
		listPlay.setVisibleRowCount(7);
		listPlay.setFixedCellHeight(50);
		listPlay.setFixedCellWidth(400);
		listPlay.setBackground(Color.MAGENTA);
		listPlay.setForeground(Color.WHITE);
		listPlay.setSelectionForeground(Color.RED);
		playlist.add(listPlay);
		c.add(new JScrollPane(listPlay));
		
		for(int i=0; i<bf2.count(); i++){
			JButton button = new JButton(bf2.getName(i));
			button.setFont(new Font("Sans", Font.BOLD, 14));
			buttons2.add(button);
		}
		c.add(buttons2);

	}		
	
	/*Prevent the flashing of the frame
	 * When drag the window, the frame will be repaint*/
		@Override
		public void update(Graphics g){
			paint(g);
		}
		
		@Override
		public void paint(Graphics g){
			super.paint(g);
			
			if(first){
				/*realize the welcome interface*/   
		          int w = getSize().width;   
		          int h = getSize().height;    
		          Font f = new Font("DialogInput", Font.BOLD, 25);   
		          g.setFont(f);   
		          FontMetrics fm = g.getFontMetrics();   
		          int swidth = fm.stringWidth(" Wellcome To MyPlayer ");   
		          g.setColor(Color.WHITE);   
		          g.drawString("Wellcome To MyPlayer", (w-swidth)/2, (h+getInsets().top)/2);    
			}
		}	  
}
