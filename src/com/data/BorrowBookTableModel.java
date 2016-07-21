package com.data;

import javax.swing.table.AbstractTableModel;

import com.sqlservice.DriveSQL;

public class BorrowBookTableModel extends AbstractTableModel {
	
	private DriveSQL sql;
	private String[] head = {"读者编号","图书编号","借阅时间","借阅次数"};
	private Reader user;
	public BorrowBookTableModel(DriveSQL sql,Reader user) {
		this.sql = sql;
		this.user=user;
	}

	public void showAllBook() {
		String opSql = "select * from Borrow where authorNum='"+user.getReaderNumber()+"';";
		sql.showBorrowBook(opSql);
		this.fireTableStructureChanged();
	}

	public int getRowCount() {
		return sql.getBorrowBook().size();
	}

	public String getColumnName(int column) {
		return head[column];
	}

	public int getColumnCount() {
		return head.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		BorrowRead obj = sql.getBorrowBook().get(rowIndex);
		switch (columnIndex) {
		case 0:
			return obj.getAuthorNum();
		case 1:
			return obj.getBookNum();
		case 2:
			return obj.getBorrowTime();
		case 3:
			return obj.getBorrowCount();
		}
		return null;
	}

}
