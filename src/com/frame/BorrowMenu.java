package com.frame;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import com.data.Reader;
import com.frame.panel.borrow.BorrowBook;
import com.frame.panel.borrow.PresentBorrow;
import com.frame.panel.borrow.ShowAllBook;
import com.sqlservice.DriveSQL;

public class BorrowMenu extends JTabbedPane{
	
	private DriveSQL sql;
	private Reader user;
	
	public BorrowMenu(DriveSQL sql,Reader user){
		this.sql = sql;	
		this.user=user;
		this.setTabPlacement(JTabbedPane.LEFT);
		
		initialize();
	}
	
	public void initialize(){
		
		this.addTab(null,new ImageIcon("tipImage\\borrowTip1.png"),new BorrowBook(sql,user),"图书借阅");
		this.addTab(null,new ImageIcon("tipImage\\borrowtip2.png"),new ShowAllBook(sql),"查看所有图书");
		this.addTab(null,new ImageIcon("tipImage\\borrowtip2.png"),new PresentBorrow(sql,user),"当前借阅图书");
		
	}
}
