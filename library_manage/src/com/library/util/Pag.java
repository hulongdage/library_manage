package com.library.util;

import java.util.List;


import com.library.entity.Book;
import com.library.entity.Booktype;
import com.library.entity.Borrowbook;
import com.library.entity.Fine;
import com.library.entity.Reader;
import com.library.entity.Readertype;
import com.library.entity.Users;

public class Pag {
	private int totalPage;
	private long totalData;
	private List<Book> tBook;
	private List<Booktype> tBooktype;
	private List<Reader> tReader;
	private List<Readertype> tReadertype;
	private List<Users> tUser;
	private List<Borrowbook> tBorrowbook;
	private List<Fine> tFine;
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public long getTotalData() {
		return totalData;
	}
	public void setTotalData(long totalData) {
		this.totalData = totalData;
	}
	public List<Book> gettBook() {
		return tBook;
	}
	public void settBook(List<Book> tBook) {
		this.tBook = tBook;
	}
	public List<Reader> gettReader() {
		return tReader;
	}
	public void settReader(List<Reader> tReader) {
		this.tReader = tReader;
	}
	public List<Users> gettUser() {
		return tUser;
	}
	public void settUser(List<Users> tUser) {
		this.tUser = tUser;
	}
	public List<Borrowbook> gettBorrowbook() {
		return tBorrowbook;
	}
	public void settBorrowbook(List<Borrowbook> tBorrowbook) {
		this.tBorrowbook = tBorrowbook;
	}
	public List<Fine> gettFine() {
		return tFine;
	}
	public void settFine(List<Fine> tFine) {
		this.tFine = tFine;
	}
	public List<Readertype> gettReadertype() {
		return tReadertype;
	}
	public void settReadertype(List<Readertype> tReadertype) {
		this.tReadertype = tReadertype;
	}
	public List<Booktype> gettBooktype() {
		return tBooktype;
	}
	public void settBooktype(List<Booktype> tBooktype) {
		this.tBooktype = tBooktype;
	}
	
	
	
	
}
