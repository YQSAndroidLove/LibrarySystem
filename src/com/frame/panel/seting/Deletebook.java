package com.frame.panel.seting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.assistclass.DeleteAssist;
import com.assistclass.SearchAssist;
import com.constant.Constant;
import com.data.Book;
import com.sqlservice.DriveSQL;

public class Deletebook extends JPanel{
	private SearchAssist searchmenu;
	private ImageIcon background;
	private JLabel back;
	private JPanel panel;
	private JButton ok;
	private Book book;
	private DeleteAssist result;
	private boolean isRepaint=false;
	private DriveSQL sql;

	public Deletebook(DriveSQL sql){
		this.sql = sql;
		this.setLayout(null);
		background = new ImageIcon("image1\\background.png");
	    back = new JLabel(background);
		back.setBounds(1, 1, background.getIconWidth(), background.getIconHeight());

		searchmenu = new SearchAssist(sql,Constant.SEARCH_SEARCH_BOOK);
		searchmenu.setBounds(150, 30,Constant.SEARCH_WIDTH,Constant.SEARCH_HEIGHT);

		this.add(searchmenu);
		
		new Thread(new Runnable(){
			public void run() {
				while(true){
					if(searchmenu.isClick()){
						if(isRepaint){
							removemenu();
							}
						if(searchmenu.getBook() != null){
							result = new DeleteAssist(sql,null,searchmenu.getBook(),Constant.BOOK_DELETE);
							result.setBounds(12, 90, 670, 300);
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
