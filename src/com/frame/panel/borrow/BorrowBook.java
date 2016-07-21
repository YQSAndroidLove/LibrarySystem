package com.frame.panel.borrow;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.assistclass.DeleteAssist;
import com.assistclass.SearchAssist;
import com.assistclass.ShowSearchResult;
import com.constant.Constant;
import com.data.Reader;
import com.sqlservice.DriveSQL;

public class BorrowBook extends JPanel{
	
	private DriveSQL sql;
	private SearchAssist searchmenu;
	private DeleteAssist result;
	private boolean isRepaint=false;
	
	private ImageIcon background;
	private JLabel back;
	private Reader user;
	
	public BorrowBook(DriveSQL sql,Reader user){
		this.sql = sql;
		this.user=user;
		this.setLayout(null);

		background = new ImageIcon("image1\\background.png");
	    back = new JLabel(background);
		back.setBounds(1, 1, background.getIconWidth(), background.getIconHeight());

		searchmenu = new SearchAssist(sql,Constant.SEARCH_SEARCH_BOOK);
		searchmenu.setBounds(180, 40,Constant.SEARCH_WIDTH,Constant.SEARCH_HEIGHT);

		this.add(searchmenu);
		
		new Thread(new Runnable(){
			public void run() {
				while(true){
					if(searchmenu.isClick()){
						if(isRepaint){
							removemenu();
						}
						if(searchmenu.getBook() != null){
							result = new DeleteAssist(sql,user,searchmenu.getBook(),Constant.BOOK_BORROW);
							result.setBounds(15, 90, 660, 320);
							addShowResultMenu();
							addSearch();
							isRepaint=true;
						}else{
						JOptionPane.showMessageDialog(null, Constant.SEARCH_RESULT_NULL_TIP,"错误......", JOptionPane.ERROR_MESSAGE);		
						}
						searchmenu.setClick(false);
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}			
		}).start();		
		
		this.add(back);
	}
	public void addShowResultMenu(){                              //动态添加组件	
		this.add(result);	
		result.updateUI();		
	}	
	
	public void addSearch(){
		this.add(searchmenu);
		searchmenu.updateUI();
		this.add(back);
	}
	public void removemenu(){
		this.remove(result);
	}
}
