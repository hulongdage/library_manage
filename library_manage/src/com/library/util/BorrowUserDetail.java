package com.library.util;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class BorrowUserDetail {
	private String readerkey; //���߱��
	
	private String name; //��������
	
	private String typename; //��������
	
	@JSONField(format="yyyy-MM-dd")
	private Date borrowdate; //��������
	
	@JSONField(format="yyyy-MM-dd")
    private Date returndate; //��������
       
	public BorrowUserDetail() {
		super();
	}

	public BorrowUserDetail(String readerkey, String name, String typename, Date borrowdate, Date returndate) {
		super();
		this.readerkey = readerkey;
		this.name = name;
		this.typename = typename;
		this.borrowdate = borrowdate;
		this.returndate = returndate;
	}

	public String getReaderkey() {
		return readerkey;
	}

	public void setReaderkey(String readerkey) {
		this.readerkey = readerkey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Date getBorrowdate() {
		return borrowdate;
	}
    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setBorrowdate(Date borrowdate) {
		this.borrowdate = borrowdate;
	}

	public Date getReturndate() {
		return returndate;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}
    
    
}
