package com.frame.panel.seting;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.assistclass.FixAssistData;
import com.assistclass.MyFunction;
import com.assistclass.SearchAssist;
import com.constant.Constant;
import com.data.Book;
import com.data.Reader;
import com.sqlservice.DriveSQL;

public class ReaderManager extends JPanel {
	
	private SearchAssist search;
	private ImageIcon background;
	private Book bookmsg;
	private FixAssistData result;
	private DriveSQL sql;
	private JLabel back;
	private JLabel tip;
	private MyFunction function;

	public ReaderManager(DriveSQL sql){
		this.setLayout(null);
		this.sql = sql;
		
		function = new MyFunction();
		
		background = new ImageIcon("image1\\background.png");
		back = new JLabel(background);
		back.setBounds(0, -2, background.getIconWidth(), background.getIconHeight());

		search = new SearchAssist(sql,Constant.READER_MANAGER);
		search.setBounds(150, 25, Constant.SEARCH_WIDTH, Constant.SEARCH_HEIGHT);

		this.add(search);
		
		new Thread(new Runnable(){
			public void run() {
				while(true){
					if(search.isClick()){
						if(search.getReader() != null){
							result = new FixAssistData(sql,search.getReader(),Constant.READER_MANAGER);
							result.setBounds(0, 0, 750, 430);
							addShowResultMenu();
							addSearch();
						}else{
							JOptionPane.showMessageDialog(null, Constant.SEARCH_RESULT_NULL_TIP,"错误......", JOptionPane.ERROR_MESSAGE);		
						}
						search.setClick(false);
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
		this.add(search);
		search.updateUI();
		this.add(back);
	}
}
