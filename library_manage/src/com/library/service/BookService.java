package com.library.service;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.library.entity.Book;
import com.library.entity.Booktype;
import com.library.entity.Borrowbook;
import com.library.entity.Borrowstate;
import com.library.entity.Dept;
import com.library.entity.Fine;
import com.library.entity.Users;

public interface BookService {
   
	/**
	 * 添加图书
	 * @param book  图书信息
	 */
	public void addBook(Book book);
	public void insertBooktype(Booktype booktype);
	public List<Booktype> queryByBooktypeNamePage(Integer pageNum, Integer pageSize,String typename);
	public void insertFineByISBN(String isbn);
	/**
	 * 查询图书类型列表
	 * @return  图书列表类型集合
	 */
	public List<Booktype> getBookTypeList();
	/**
	 * 根据图书类型名称得到图书类型id
	 * @param bookTypeName  图书类型名称
	 * @return  图书类型id
	 */
	public int getBookIdByTypeName(String bookTypeName);
	/**
	 * 根据图书类型id得到图书类型名称
	 * @param bookId  图书类型id
	 * @return   图书类型名称
	 */
	public String getTypeNameByBookId(int bookId);
	/**
	 * 查询图书列表
	 * @param pageNum   当前页
	 * @param pageSize  每页显示条数
	 * @return   图书列表
	 */
	public List<Book> selectBookList(Integer pageNum, Integer pageSize);
	/**
	 * 查询罚款信息列表
	 * @param pageNum 当前页
	 * @param pageSize 每页显示条数
	 * @return 罚款信息列表
	 */
	public List<Fine> selectFineList(Integer pageNum, Integer pageSize);
	public List<Fine> queryFineListPage(Integer pageNum, Integer pageSize,String isbn);
	/**
	 * 根据图书名称模糊查询图书
	 * @param bookname  图书名称
	 * @return   图书信息
	 */
	public List<Book> queryByBookName(String bookname);
	public List<Book> queryByBookNamePage(Integer pageNum, Integer pageSize,String bookname);
	/**
	 * 根据图书编号删除图书
	 * @param isbn  图书编号
	 */
	public void deleteBookByISBN(String isbn);
	/**
	 * 根据借阅次数得到图书列表
	 * @return  图书列表
	 */
	public List<Book> getBookListByBorrowNum();
	/**
	 * 根据isbn得到图书信息
	 * @param isbn  图书编号
	 * @return  图书信息
	 */
	public Book getBookByISBN(String isbn);
	public Booktype getBooktypeByID(Integer id);
	/**
	 * 插入借阅图书记录
	 * @param borrowbook  借阅图书记录信息
	 */
	public void insertBorrowBook(Borrowbook borrowbook);
	/**
	 * 更新图书信息
	 * @param book  图书信息
	 */
	public void updateBook(Book book);
	public void updateBooktype(Booktype booktype);
	/**
	 * 查询未还书与超期的借阅记录
	 * @param pageNum   当前页
	 * @param pageSize  每页显示条数
	 * @return  未还书与超期的借阅记录列表
	 */
	public List<Borrowbook> queryBorrowBookList(Integer pageNum, Integer pageSize);	
	/**
	 * 查询未还书的借阅记录
	 * @param pageNum  当前页
	 * @param pageSize  每页显示条数
	 * @return  未还书的借阅记录列表
	 */
	public List<Borrowbook> querySafeBorrowBookList(Integer pageNum, Integer pageSize);
	/**
	 * 查询超期的借阅记录
	 * @param pageNum  当前页
	 * @param pageSize  每页显示条数
	 * @return  超期的借阅记录列表
	 */
	public List<Borrowbook> queryDangerBorrowBookList(Integer pageNum, Integer pageSize);
	/**
	 * 查询已还的借阅记录
	 * @param pageNum  当前页
	 * @param pageSize  每页显示条数
	 * @return  已还的借阅记录列表
	 */
	public List<Borrowbook> queryReturnBorrowBookList(Integer pageNum, Integer pageSize);
	/**
	 * 查询所有的借阅记录
	 * @param pageNum  当前页
	 * @param pageSize  每页显示条数
	 * @return  所有的借阅记录列表
	 */
	public List<Borrowbook> queryAllBorrowBookList(Integer pageNum, Integer pageSize);
	/**
	 * 根据借书状态id得到借书状态信息
	 * @param state  借书状态id
	 * @return  借书状态信息
	 */
	public Borrowstate getBorrowstateById(Integer state);
	/**
	 * 根据图书编号得到罚金信息
	 * @param isbn  图书编号
	 * @return  罚金信息
	 */
	public Fine getFineByISBN(String isbn);
	/**
	 * 更新借阅记录
	 * @param borrowbook  借阅信息
	 */
	public void updateBorrowbook(Borrowbook borrowbook);
	/**
	 * 根据id得到图书借阅信息
	 * @param id  图书借阅信息id
	 * @return  图书借阅信息
	 */
	public Borrowbook getBorrowbookById(Integer id);
	/**
	 * 更新罚款信息
	 * @param fine  罚款信息
	 */
	public void updateFine(Fine fine);
	/**
	 * 根据借书记录id删除借书id
	 * @param id  借书记录id
	 */
	public void delBorrowBookById(Integer id);
	/**
	 * 根据读者编号得到图书借阅记录列表
	 * @param readerkey  读者编号
	 * @return  图书借阅记录列表
	 */
	public List<Borrowbook> getBorrowBookListByReaderKey(Integer pageNum, Integer pageSize,String readerkey);
	/**
	 * 根据图书类型id得到图书类型信息
	 * @param typeid  图书类型id
	 * @return  图书类型信息
	 */
	public Booktype getBookTypeByBookTypeId(Integer typeid);
	public List<Booktype> selectBookTypeList(Integer pageNum, Integer pageSize) ;
	public void deleteBookTypeByID(Integer id);
	public List<String> getBorrowbookListBetweenDay();


}
