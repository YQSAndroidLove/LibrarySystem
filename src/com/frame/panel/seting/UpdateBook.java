package com.frame.panel.seting;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.assistclass.SearchAssist;
import com.assistclass.ShowSearchResult;
import com.constant.Constant;
import com.data.Book;
import com.sqlservice.DriveSQL;

public class UpdateBook extends JPanel {

	private SearchAssist searchmenu;
	private ImageIcon background;
	private JLabel back;
	private JPanel panel;
	private Book book;
	private ShowSearchResult result;
	private boolean isRepaint=false;
	private DriveSQL sql;

	public UpdateBook(DriveSQL sql) {
		this.sql = sql;
		this.setLayout(null);

		background = new ImageIcon("image1\\background.png");
	    back = new JLabel(background);
		back.setBounds(1, 1, background.getIconWidth(), background.getIconHeight());

		searchmenu = new SearchAssist(sql,Constant.SEARCH_SEARCH_BOOK);
		searchmenu.setBounds(150, 40,Constant.SEARCH_WIDTH,Constant.SEARCH_HEIGHT);

		this.add(searchmenu);
		
		new Thread(new Runnable(){
			public void run() {
				while(true){
					if(searchmenu.isClick()){
						if(isRepaint){
							removemenu();
							}
						if(searchmenu.getBook() != null){
							result = new ShowSearchResult(sql,searchmenu.getBook(),Constant.BOOK_UPDATE);
							result.setBounds(12, 90, 670, 320);
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
