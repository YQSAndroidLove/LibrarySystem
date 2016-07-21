package com.frame;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import com.data.Reader;
import com.frame.panel.seting.AddBook;
import com.frame.panel.seting.BackStageManager;
import com.frame.panel.seting.Deletebook;
import com.frame.panel.seting.ReaderManager;
import com.frame.panel.seting.UpdateBook;
import com.sqlservice.DriveSQL;

public class SettingMenu  extends JTabbedPane{
	
	private DriveSQL sql;
	
	public SettingMenu(DriveSQL sql){
		
		this.sql = sql;
		initialize();
		
		this.setTabPlacement(JTabbedPane.LEFT);
	}
	
	public void initialize(){
		
		
		this.addTab(null,new ImageIcon("tipImage\\addBook.png"),new AddBook(sql),"���ͼ��");
		this.addTab(null,new ImageIcon("tipImage\\fixBook.png"),new UpdateBook(sql),"�޸�ͼ����Ϣ");
		this.addTab(null,new ImageIcon("tipImage\\deleteBook.png"),new UpdateBook(sql),"ɾ��ͼ��");
		this.addTab(null,new ImageIcon("tipImage\\logout.png"),new ReaderManager(sql),"ע���û�");		
		this.addTab(null,new ImageIcon("tipImage\\sql.png"),new BackStageManager(this.sql),"���ݿ��̨����");	
		
	}
}
