package com.library.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.entity.BookExample;
import com.library.entity.Booktype;
import com.library.entity.BooktypeExample;
import com.library.entity.BooktypeExample.Criteria;
import com.library.entity.Borrowbook;
import com.library.entity.BorrowbookExample;
import com.library.entity.Borrowstate;
import com.library.entity.Fine;
import com.library.entity.FineExample;
import com.library.mapper.BookMapper;
import com.library.mapper.BooktypeMapper;
import com.library.mapper.BorrowbookMapper;
import com.library.mapper.BorrowstateMapper;
import com.library.mapper.FineMapper;
import com.library.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper bookMapper;
	
	@Autowired
	private BooktypeMapper booktypeMapper;
	
	@Autowired
	private BorrowbookMapper borrowbookMapper;
	
	@Autowired
	private BorrowstateMapper borrowstateMapper;
	
	@Autowired
	private FineMapper fineMapper;

	@Override
	public void addBook(Book book) {
		bookMapper.insert(book);
	}

	@Override
	public List<Booktype> getBookTypeList() {
	    BooktypeExample example = new BooktypeExample();
		List<Booktype> bookTypeList = booktypeMapper.selectByExample(example);
		return bookTypeList;
	}

	@Override
	public int getBookIdByTypeName(String bookTypeName) {
		BooktypeExample example = new BooktypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andTypenameEqualTo(bookTypeName);
		List<Booktype> bookTypeList = booktypeMapper.selectByExample(example );
		if(bookTypeList != null) {
			return bookTypeList.get(0).getId();
		}else {
			return 0;
		}
	}
	
	@Override
	public List<Book> selectBookList(Integer pageNum, Integer pageSize) {		
			BookExample example = new BookExample();
			List<Book> list = bookMapper.selectByExample(example);
			return list;
	}
	
	@Override
	public List<Booktype> selectBookTypeList(Integer pageNum, Integer pageSize) {		
		 BooktypeExample example = new BooktypeExample();
			List<Booktype> bookTypeList = booktypeMapper.selectByExample(example);
			return bookTypeList;
	}

	@Override
	public List<Book> queryByBookName(String bookname) {
		BookExample example = new BookExample();
		com.library.entity.BookExample.Criteria criteria = example.createCriteria();
		criteria.andBooknameLike("%"+bookname+"%");
		List<Book> bookList = bookMapper.selectByExample(example );
        return bookList;
	}
	
	@Override
	public List<Book> queryByBookNamePage(Integer pageNum, Integer pageSize,String bookname) {
		BookExample example = new BookExample();
		com.library.entity.BookExample.Criteria criteria = example.createCriteria();
		criteria.andBooknameLike("%"+bookname+"%");
		List<Book> bookList = bookMapper.selectByExample(example );
        return bookList;
	}
	
	@Override
	public List<Booktype> queryByBooktypeNamePage(Integer pageNum, Integer pageSize,String typename) {
		BooktypeExample example = new BooktypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andTypenameLike("%"+typename+"%");
		List<Booktype> list = booktypeMapper.selectByExample(example );
		if(list != null || list.size()>0) {
			return list;
		}else {
			return null;
		}		
	}

	@Override
	public void deleteBookByISBN(String isbn) {
		bookMapper.deleteByPrimaryKey(isbn);		
	}
	
	@Override
	public void deleteBookTypeByID(Integer id) {
		booktypeMapper.deleteByPrimaryKey(id);	
	}

	@Override
	public String getTypeNameByBookId(int bookId) {
		Booktype booktype = booktypeMapper.selectByPrimaryKey(bookId);
		return booktype.getTypename();
	}

	@Override
	public List<Book> getBookListByBorrowNum() {
		BookExample example = new BookExample();
		example.setOrderByClause("borrownum DESC");
		List<Book> bookList1 = bookMapper.selectByExample(example );
		List<Book> bookList = new ArrayList<>();
		bookList=bookList1.subList(0, 5);
		return bookList;
	}

	@Override
	public List<String> getBorrowbookListBetweenDay() {
		BooktypeExample example1 = new BooktypeExample();
		List<Booktype> list2 = booktypeMapper.selectByExample(example1 );
		List<String> list = new ArrayList<>();
		for(int i=1;i<=list2.size();i++) {
			//获取七天前的date
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			c.add(Calendar.DATE,-7);
			BorrowbookExample example = new BorrowbookExample();
			com.library.entity.BorrowbookExample.Criteria criteria = example.createCriteria();
			//数据库筛选加入时间控制在7天内
			criteria.andBorrowdateBetween(c.getTime(),new Date());
			criteria.andBooktypeidEqualTo(i);
			List<Borrowbook> boList = borrowbookMapper.selectByExample(example );
			list.add(String.valueOf(boList.size()));
		}
		
		return list;
	}

	@Override
	public Book getBookByISBN(String isbn) {
		Book book = bookMapper.selectByPrimaryKey(isbn);
		return book;
	}
	@Override
	public Booktype getBooktypeByID(Integer id){
		Booktype booktype = booktypeMapper.selectByPrimaryKey(id);
		return booktype;
	}

	@Override
	public void insertBorrowBook(Borrowbook borrowbook) {
		borrowbookMapper.insert(borrowbook);		
	}

	@Override
	public void updateBook(Book book) {
		bookMapper.updateByPrimaryKey(book);		
	}
	
	@Override
	public void updateBooktype(Booktype booktype) {
		booktypeMapper.updateByPrimaryKey(booktype);		
	}

	@Override
	public List<Borrowbook> queryBorrowBookList(Integer pageNum, Integer pageSize) {
		BorrowbookExample example = new BorrowbookExample();
		com.library.entity.BorrowbookExample.Criteria criteria = example.createCriteria();
		criteria.andRealreturndateIsNull();
		List<Borrowbook> list = borrowbookMapper.selectByExample(example );
		return list;
	}

	@Override
	public Borrowstate getBorrowstateById(Integer state) {
		Borrowstate borrowstate = borrowstateMapper.selectByPrimaryKey(state);
		return borrowstate;
	}

	@Override
	public Fine getFineByISBN(String isbn) {
		FineExample example = new FineExample();
		com.library.entity.FineExample.Criteria criteria = example.createCriteria();
		criteria.andIsbnEqualTo(isbn);
		List<Fine> list = fineMapper.selectByExample(example );
		if(list != null && list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
		
	}

	@Override
	public void updateBorrowbook(Borrowbook borrowbook) {		
		borrowbookMapper.updateByPrimaryKey(borrowbook);		
	}

	@Override
	public Borrowbook getBorrowbookById(Integer id) {
		Borrowbook borrowbook = borrowbookMapper.selectByPrimaryKey(id);
		return borrowbook;
	}

	@Override
	public List<Fine> selectFineList(Integer pageNum, Integer pageSize) {
		FineExample example = new FineExample();		
		List<Fine> list = fineMapper.selectByExample(example );
		if(list != null && list.size()>0) {
			return list;
		}else {
			return null;
		}
	}


	@Override
	public void updateFine(Fine fine) {
		fineMapper.updateByPrimaryKey(fine);
		
	}

	@Override
	public List<Borrowbook> querySafeBorrowBookList(Integer pageNum, Integer pageSize) {
		BorrowbookExample example = new BorrowbookExample();
		com.library.entity.BorrowbookExample.Criteria criteria = example.createCriteria();
		criteria.andStateEqualTo(0);
		List<Borrowbook> list = borrowbookMapper.selectByExample(example );
		if(list != null && list.size()>0) {
			return list;
		}else {
			return null;
		}
		
	}

	@Override
	public List<Borrowbook> queryAllBorrowBookList(Integer pageNum, Integer pageSize) {
		BorrowbookExample example = new BorrowbookExample();		
		List<Borrowbook> list = borrowbookMapper.selectByExample(example );
		if(list != null && list.size()>0) {
			return list;
		}else {
			return null;
		}
	}

	@Override
	public List<Borrowbook> queryDangerBorrowBookList(Integer pageNum, Integer pageSize) {
		BorrowbookExample example = new BorrowbookExample();
		com.library.entity.BorrowbookExample.Criteria criteria = example.createCriteria();
		criteria.andStateEqualTo(2);
		criteria.andRealreturndateIsNull();
		List<Borrowbook> list = borrowbookMapper.selectByExample(example );
		if(list != null && list.size()>0) {
			return list;
		}else {
			return null;
		}
	}

	@Override
	public List<Borrowbook> queryReturnBorrowBookList(Integer pageNum, Integer pageSize) {
		BorrowbookExample example = new BorrowbookExample();
		com.library.entity.BorrowbookExample.Criteria criteria = example.createCriteria();
		criteria.andRealreturndateIsNotNull();
		List<Borrowbook> list = borrowbookMapper.selectByExample(example );
		if(list != null && list.size()>0) {
			return list;
		}else {
			return null;
		}
	}

	@Override
	public void delBorrowBookById(Integer id) {
		borrowbookMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public List<Borrowbook> getBorrowBookListByReaderKey(Integer pageNum, Integer pageSize,String readerkey) {
		BorrowbookExample example = new BorrowbookExample();
		com.library.entity.BorrowbookExample.Criteria criteria = example.createCriteria();
		criteria.andReaderkeyEqualTo(readerkey);
		criteria.andStateNotEqualTo(1);
		List<Borrowbook> list = borrowbookMapper.selectByExample(example );
		if(list != null && list.size()>0) {
			return list;
		}else {
			return null;
		}
	}

	@Override
	public List<Fine> queryFineListPage(Integer pageNum, Integer pageSize, String isbn) {
		FineExample example = new FineExample();	
		com.library.entity.FineExample.Criteria criteria = example.createCriteria();
		criteria.andIsbnEqualTo(isbn);
		List<Fine> list = fineMapper.selectByExample(example );
		if(list != null && list.size()>0) {
			return list;
		}else {
			return null;
		}
	}

	@Override
	public Booktype getBookTypeByBookTypeId(Integer typeid) {
		Booktype booktype = booktypeMapper.selectByPrimaryKey(typeid);
		return booktype;
	}

	@Override
	public void insertBooktype(Booktype booktype) {
		booktypeMapper.insert(booktype);		
	}

	@Override
	public void insertFineByISBN(String isbn) {
		Fine fine = new Fine();
		fine.setFine(1L);
		fine.setIsbn(isbn);
		fineMapper.insert(fine);		
	}

	
	

}
