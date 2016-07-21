package com.assistclass;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.constant.Constant;
import com.data.Book;
import com.data.Reader;
import com.sqlservice.DriveSQL;

public class DeleteAssist extends JPanel{

	private DriveSQL sql;
	private Reader user;
	private ImageIcon tip;
	private JPanel panel1, panel2;
	private JLabel label[],blank;

	private JButton ok,borrow;
	private MyFunction function;
	private Book book=null;
	private int type;
	private int bookcount;
	private int addcount;
	private boolean isBorrowClick=false;

	public DeleteAssist(DriveSQL sql,Reader user,Book book,int type) {
		
		this.type = type;
		this.sql = sql;
		this.book=book;
		this.user=user;
		this.setLayout(new BorderLayout());
		this.setOpaque(false);

		function = new MyFunction();

		initialize();
	}

	public void initialize() {		
		tip = new ImageIcon("tipImage\\fixTip.png");

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		label = new JLabel[Constant.TABLE_HEAD.length];

		panel1.setLayout(new GridLayout(6, 2, 10, 10));
		panel1.setOpaque(false);
        
		ok=new JButton("确定删除");
		ok.setSize(100, 30);
		ok.addActionListener(new ActionListenerImp());
		borrow =new JButton("借阅");
		borrow.setSize(100, 30);
		borrow.addActionListener(new ActionListenerImp());
		
		String obj;
		for (int i = 0; i <= 10; i++) {
			obj = null;
			switch (i) {
			case 0:
				obj = " " + book.getBookNumber();
				break;
			case 1:
				obj = " " + book.getBookName();
				break;
			case 2:
				obj = " " + book.getBookType();
				break;
			case 3:
				obj = " " + book.getBookAuthor();
				break;
			case 4:
				obj = "  " + book.getBookPrice();
				break;
			case 5:
				obj = " " + book.getBookCount();
				break;
			case 6:
				obj = " " + book.getBookState();
				break;
			case 7:
				obj = " " + book.getBookPress();
				break;
			case 8:
				obj = " " + book.getBookDate();
				break;
			case 9:
				obj = " " + book.getBookDiscuss();
				break;
			}
			if(i!=10){
			label[i] = new JLabel(Constant.TABLE_HEAD[i] + ":" + obj);
			label[i].setFont(new Font("华文楷体", Font.BOLD, 20));
			label[i].setForeground(Color.BLUE);
			panel1.add(label[i]);}
			else{
		  if(this.type == Constant.BOOK_DELETE){
        	panel2.add(ok);
        	}
        else
        	panel2.add(borrow);
			}
		}
		this.add(panel1, BorderLayout.CENTER);
		this.add(panel2,BorderLayout.SOUTH);
      
        
		panel1.setBorder(new TitledBorder("图书信息"));

	}
	private class ActionListenerImp implements ActionListener{
		int isDelete=0;
    	String str="delete from book where bookName='"+book.getBookName()+"';";
		public void actionPerformed(ActionEvent e) {
				if(e.getSource()==ok){
					isDelete=JOptionPane.showConfirmDialog(null, "你确定要删除该图书吗!",
								"提示......", JOptionPane.OK_CANCEL_OPTION);
				if(isDelete==JOptionPane.OK_OPTION){
					sql.deleteMessage(str);
					System.out.println("delete book success");
				}
			}
			isBorrowClick=false;
			if(e.getSource()==borrow){
				isBorrowClick=true;
				IsBorrowClick();
				IsBorrow();
			}	
		}
		
		
	}
	public boolean IsBorrowClick()
	{
		return isBorrowClick;
	}
	public void IsBorrow(){	
		if(book.getBookState().equals("可借")){ 
			
			String strsql="insert into Borrow values('"+user.getReaderNumber()
					+"','"+book.getBookNumber()+"',"+"'2013-10-3'"+",'1');";

			if(sql.insertMessage(strsql)){
				JOptionPane.showConfirmDialog(null, "借閱成功!",
						"提示......", JOptionPane.OK_CANCEL_OPTION);
				bookcount=book.Countdecrese();
		      String update="update book set bookCount = '"+bookcount+"' "+"where bookName='"+book.getBookName()+"';";
		      sql.insertMessage(update);
		      if(book.getBookCount()<=0)
		      {
		    	  String up="update book set bookState ='不可借' "+"where bookNumber='"+book.getBookNumber()+"';";
		    	  sql.updateMessage(up);
		    	  System.out.println(up);
		      }
			}else{
				JOptionPane.showConfirmDialog(null, "借閱失敗!",
						"提示......", JOptionPane.OK_CANCEL_OPTION);
			}
		}else{
		JOptionPane.showConfirmDialog(null, "该图书不可借!",
				"提示......", JOptionPane.OK_CANCEL_OPTION);
		} 
	}
	public void IfSameBook(){
		String issame="select bookNumber from borrow where bookNum='"+book.getBookNumber()+"';";
	   if(sql.insertMessage(issame)){
	     
	   }
	}
}
