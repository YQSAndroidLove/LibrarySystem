package com.assistclass;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.constant.Constant;
import com.data.Book;
import com.data.Reader;
import com.sqlservice.DriveSQL;

public class SearchAssist extends JPanel {

	public String bookmsg;
	private JTextField text;
	private JButton btn;
	private DriveSQL sql;
	private int type;
	private String strSql;
	
	private Book book = null;
	private Reader reader = null;
	private boolean isClick = false;

	public SearchAssist(DriveSQL sql,int type) {
		this.sql = sql;
		this.type = type;

		text = new JTextField();
		btn = new JButton("ËÑË÷");
		this.setLayout(new BorderLayout());
		add(text, BorderLayout.CENTER);
		add(btn, BorderLayout.EAST);
		btn.addActionListener(new ActionListenerImp());
		text.addKeyListener(new KeyOwnListener());
	}

	public String getsearch() {
		if (!text.getText().isEmpty()) {
			return text.getText();
		}
		return null;
	}

	private class ActionListenerImp implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btn){
				if(getsearch()==null){
					JOptionPane.showMessageDialog(null, "ËÑË÷¿ò²»ÄÜÎª¿Õ!", "´íÎó......",
							JOptionPane.ERROR_MESSAGE);
				}else{
				search();
				isClick = true;
			}}
		}
	}
	
	private class KeyOwnListener extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode() == 10){
				if(getsearch()==null){
					JOptionPane.showMessageDialog(null, "ËÑË÷¿ò²»ÄÜÎª¿Õ!", "´íÎó......",
							JOptionPane.ERROR_MESSAGE);
				}else{
				search();
				isClick = true;
				
			}}
		}
	}
	
	public void search(){
		if(type == Constant.READER_MANAGER){
			strSql = "select * from Reader where readerNumber='" + getsearch() + "';";
			reader = sql.getReaderMsg(strSql);
		}else{
			strSql = "select * from book where bookName='" + getsearch() + "';";
			book = sql.getBook(strSql);
		}
	}
	

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public boolean isClick() {
		return isClick;
	}

	public void setClick(boolean isClick) {
		this.isClick = isClick;
	}
	
}
