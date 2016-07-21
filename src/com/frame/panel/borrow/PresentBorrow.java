package com.frame.panel.borrow;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.assistclass.DeleteAssist;
import com.constant.Constant;
import com.data.BorrowBookTableModel;
import com.data.Reader;
import com.sqlservice.DriveSQL;

public class PresentBorrow extends JPanel {
	
	private JTable bookTable;	
	private BorrowBookTableModel bookModel;
	private DeleteAssist isClick;
	private DriveSQL sql;
	private Reader user;
	private boolean isgetborrow=true;
	
	public PresentBorrow(DriveSQL sql,Reader user){
		this.sql = sql;
		this.user=user;
				
		bookModel = new BorrowBookTableModel(sql,user);
		bookTable = new JTable(bookModel);
		
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(bookTable),BorderLayout.CENTER);
//		new Thread(new Runnable(){
//			public void run(){
//				while(true){					
					bookModel.showAllBook();
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			}}
//		}).start();
			
		
		bookTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		bookTable.setRowHeight(30);
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		bookTable.setDefaultRenderer(Object.class, tcr);		
		
		TableColumnModel tcm =  bookTable.getColumnModel();
		for(int i=0;i<tcm.getColumnCount();i++){
			TableColumn tc = tcm.getColumn(i);	
			tc.setMinWidth(Constant.TABLE_COLUM_WIDTH[i]);
			tc.setPreferredWidth(Constant.TABLE_COLUM_WIDTH[i]);			
		}			
	}	
}
