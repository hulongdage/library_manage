package com.library.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class Borrowbook {
    private Integer id;

    private String readerkey;

    private String isbn;
    
    private String name; //读者姓名 
    
    private String typename; //读者类型
    
    private String bookname; //图书名称

    private Integer booktypeid;

    @JSONField(format="yyyy-MM-dd")
    private Date borrowdate;
    
    @JSONField(format="yyyy-MM-dd")
    private Date realreturndate;

    @JSONField(format="yyyy-MM-dd")
    private Date returndate;

    private Long fine;

    private Integer state;
    
    private String statename; //状态名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReaderkey() {
        return readerkey;
    }

    public void setReaderkey(String readerkey) {
        this.readerkey = readerkey == null ? null : readerkey.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public Integer getBooktypeid() {
        return booktypeid;
    }

    public void setBooktypeid(Integer booktypeid) {
        this.booktypeid = booktypeid;
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

    public Long getFine() {
        return fine;
    }

    public void setFine(Long fine) {
        this.fine = fine;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public Date getRealreturndate() {
		return realreturndate;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setRealreturndate(Date realreturndate) {
		this.realreturndate = realreturndate;
	}

	@Override
	public String toString() {
		return "Borrowbook [id=" + id + ", readerkey=" + readerkey + ", isbn=" + isbn + ", name=" + name + ", typename="
				+ typename + ", bookname=" + bookname + ", booktypeid=" + booktypeid + ", borrowdate=" + borrowdate
				+ ", realreturndate=" + realreturndate + ", returndate=" + returndate + ", fine=" + fine + ", state="
				+ state + ", statename=" + statename + "]";
	}

	
	
	
    
}