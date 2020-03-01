package com.library.util;

import java.util.List;

public class BorrowBookResult {
	private List<String> bookName;
	private List<Integer> borrownum;
	public BorrowBookResult() {
		super();
	}
	public BorrowBookResult(List<String> bookName, List<Integer> borrownum) {
		super();
		this.bookName = bookName;
		this.borrownum = borrownum;
	}
	public List<String> getBookName() {
		return bookName;
	}
	public void setBookName(List<String> bookName) {
		this.bookName = bookName;
	}
	public List<Integer> getBorrownum() {
		return borrownum;
	}
	public void setBorrownum(List<Integer> borrownum) {
		this.borrownum = borrownum;
	}
	
}
