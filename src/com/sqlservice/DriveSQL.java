package com.sqlservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.data.Book;
import com.data.BorrowRead;
import com.data.Reader;
import com.frame.panel.borrow.BorrowBook;

public class DriveSQL {
	private int isSuccess;
	private Connection conn = null;
	private String sql;
	private String url = "jdbc:mysql://127.0.0.1:3306/mysql?"
			+ "user=root&password=password&useUnicode=true&characterEncoding=UTF8"; // Create
																					// URL
	private Statement stmt;
	private List<Book> book = new ArrayList<Book>();
	private List<BorrowRead> borrowBook = new ArrayList<BorrowRead>();

	public DriveSQL() {
		
		createSQL();
		
	}

	public boolean createSQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // ��̬����mysql����
			// System.out.println("�ɹ�����MySQL��������"); // һ��Connection����һ�����ݿ�����
			conn = DriverManager.getConnection(url); // Statement������кܶ෽��������executeUpdate����ʵ�ֲ��룬���º�ɾ����
			stmt = conn.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�������ݿ�ʧ��!", "����......", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean creatTable(String sql) { // executeUpdate���᷵��һ����Ӱ����������������-1��û�гɹ�
		int isResult = -1;
		try {
			isResult = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (isResult != -1) {
			return true;
		}
		return false;
	}

	public boolean insertMessage(String stuMsg) { // Insert student message
		int isResult = -1;
		try {
			isResult = stmt.executeUpdate(stuMsg);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (isResult != -1) {
			return true;
		}
		return false;
	}

	public boolean deleteMessage(String delMsg) {
		int isResult = -1;
		try {
			isResult = stmt.executeUpdate(delMsg);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (isResult != -1) {
			return true;
		}
		return false;
	}

	public boolean updateMessage(String fixMsg) {
		int isResult = -1;
		try {
			isResult = stmt.executeUpdate(fixMsg);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (isResult != -1) {
			return true;
		}
		return false;
	}

	public void showBook(String showMsg) {
		ResultSet rs;
		removeShowBook();
		try {
			rs = stmt.executeQuery(showMsg);
			while (rs.next()) {
				Book obj = new Book(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),Float.parseFloat(rs.getString(5)),Integer.parseInt(rs.getString(6)),
						rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
				book.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} // executeQuery�᷵�ؽ���ļ��ϣ����򷵻ؿ�ֵ
	}
	
	public void showBorrowBook(String showMsg) {
		ResultSet rs;
		removeShowBorrow();
		try {
			rs = stmt.executeQuery(showMsg);
			while (rs.next()) {
				BorrowRead obj = new BorrowRead(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),
						Integer.parseInt(rs.getString(4)));
				borrowBook.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} // executeQuery�᷵�ؽ���ļ��ϣ����򷵻ؿ�ֵ
	}

	public void removeShowBook() {
		for (int i = 0; i < book.size();) {
			book.remove(0);
		}
	}
	
	public void removeShowBorrow() {
		for (int i = 0; i < borrowBook.size();) {
			borrowBook.remove(0);
		}
	}

	public Reader getReaderMsg(String sql) {
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				return new Reader(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),Integer.parseInt(rs.getString(5)),
						rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} // executeQuery�᷵�ؽ���ļ��ϣ����򷵻ؿ�ֵ
		return null;
	}
	
	public Book getBook(String sql) {
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				return new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
						Float.parseFloat(rs.getString(5)),Integer.parseInt(rs.getString(6)),
						rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} // executeQuery�᷵�ؽ���ļ��ϣ����򷵻ؿ�ֵ
		return null;
	}


	public void closeSQL() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}

	public List<Book> getBook() {
		return book;
	}
	

	public List<BorrowRead> getBorrowBook() {
		return borrowBook;
	}

}
