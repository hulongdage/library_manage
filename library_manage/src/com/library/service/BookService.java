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
	 * ���ͼ��
	 * @param book  ͼ����Ϣ
	 */
	public void addBook(Book book);
	public void insertBooktype(Booktype booktype);
	public List<Booktype> queryByBooktypeNamePage(Integer pageNum, Integer pageSize,String typename);
	public void insertFineByISBN(String isbn);
	/**
	 * ��ѯͼ�������б�
	 * @return  ͼ���б����ͼ���
	 */
	public List<Booktype> getBookTypeList();
	/**
	 * ����ͼ���������Ƶõ�ͼ������id
	 * @param bookTypeName  ͼ����������
	 * @return  ͼ������id
	 */
	public int getBookIdByTypeName(String bookTypeName);
	/**
	 * ����ͼ������id�õ�ͼ����������
	 * @param bookId  ͼ������id
	 * @return   ͼ����������
	 */
	public String getTypeNameByBookId(int bookId);
	/**
	 * ��ѯͼ���б�
	 * @param pageNum   ��ǰҳ
	 * @param pageSize  ÿҳ��ʾ����
	 * @return   ͼ���б�
	 */
	public List<Book> selectBookList(Integer pageNum, Integer pageSize);
	/**
	 * ��ѯ������Ϣ�б�
	 * @param pageNum ��ǰҳ
	 * @param pageSize ÿҳ��ʾ����
	 * @return ������Ϣ�б�
	 */
	public List<Fine> selectFineList(Integer pageNum, Integer pageSize);
	public List<Fine> queryFineListPage(Integer pageNum, Integer pageSize,String isbn);
	/**
	 * ����ͼ������ģ����ѯͼ��
	 * @param bookname  ͼ������
	 * @return   ͼ����Ϣ
	 */
	public List<Book> queryByBookName(String bookname);
	public List<Book> queryByBookNamePage(Integer pageNum, Integer pageSize,String bookname);
	/**
	 * ����ͼ����ɾ��ͼ��
	 * @param isbn  ͼ����
	 */
	public void deleteBookByISBN(String isbn);
	/**
	 * ���ݽ��Ĵ����õ�ͼ���б�
	 * @return  ͼ���б�
	 */
	public List<Book> getBookListByBorrowNum();
	/**
	 * ����isbn�õ�ͼ����Ϣ
	 * @param isbn  ͼ����
	 * @return  ͼ����Ϣ
	 */
	public Book getBookByISBN(String isbn);
	public Booktype getBooktypeByID(Integer id);
	/**
	 * �������ͼ���¼
	 * @param borrowbook  ����ͼ���¼��Ϣ
	 */
	public void insertBorrowBook(Borrowbook borrowbook);
	/**
	 * ����ͼ����Ϣ
	 * @param book  ͼ����Ϣ
	 */
	public void updateBook(Book book);
	public void updateBooktype(Booktype booktype);
	/**
	 * ��ѯδ�����볬�ڵĽ��ļ�¼
	 * @param pageNum   ��ǰҳ
	 * @param pageSize  ÿҳ��ʾ����
	 * @return  δ�����볬�ڵĽ��ļ�¼�б�
	 */
	public List<Borrowbook> queryBorrowBookList(Integer pageNum, Integer pageSize);	
	/**
	 * ��ѯδ����Ľ��ļ�¼
	 * @param pageNum  ��ǰҳ
	 * @param pageSize  ÿҳ��ʾ����
	 * @return  δ����Ľ��ļ�¼�б�
	 */
	public List<Borrowbook> querySafeBorrowBookList(Integer pageNum, Integer pageSize);
	/**
	 * ��ѯ���ڵĽ��ļ�¼
	 * @param pageNum  ��ǰҳ
	 * @param pageSize  ÿҳ��ʾ����
	 * @return  ���ڵĽ��ļ�¼�б�
	 */
	public List<Borrowbook> queryDangerBorrowBookList(Integer pageNum, Integer pageSize);
	/**
	 * ��ѯ�ѻ��Ľ��ļ�¼
	 * @param pageNum  ��ǰҳ
	 * @param pageSize  ÿҳ��ʾ����
	 * @return  �ѻ��Ľ��ļ�¼�б�
	 */
	public List<Borrowbook> queryReturnBorrowBookList(Integer pageNum, Integer pageSize);
	/**
	 * ��ѯ���еĽ��ļ�¼
	 * @param pageNum  ��ǰҳ
	 * @param pageSize  ÿҳ��ʾ����
	 * @return  ���еĽ��ļ�¼�б�
	 */
	public List<Borrowbook> queryAllBorrowBookList(Integer pageNum, Integer pageSize);
	/**
	 * ���ݽ���״̬id�õ�����״̬��Ϣ
	 * @param state  ����״̬id
	 * @return  ����״̬��Ϣ
	 */
	public Borrowstate getBorrowstateById(Integer state);
	/**
	 * ����ͼ���ŵõ�������Ϣ
	 * @param isbn  ͼ����
	 * @return  ������Ϣ
	 */
	public Fine getFineByISBN(String isbn);
	/**
	 * ���½��ļ�¼
	 * @param borrowbook  ������Ϣ
	 */
	public void updateBorrowbook(Borrowbook borrowbook);
	/**
	 * ����id�õ�ͼ�������Ϣ
	 * @param id  ͼ�������Ϣid
	 * @return  ͼ�������Ϣ
	 */
	public Borrowbook getBorrowbookById(Integer id);
	/**
	 * ���·�����Ϣ
	 * @param fine  ������Ϣ
	 */
	public void updateFine(Fine fine);
	/**
	 * ���ݽ����¼idɾ������id
	 * @param id  �����¼id
	 */
	public void delBorrowBookById(Integer id);
	/**
	 * ���ݶ��߱�ŵõ�ͼ����ļ�¼�б�
	 * @param readerkey  ���߱��
	 * @return  ͼ����ļ�¼�б�
	 */
	public List<Borrowbook> getBorrowBookListByReaderKey(Integer pageNum, Integer pageSize,String readerkey);
	/**
	 * ����ͼ������id�õ�ͼ��������Ϣ
	 * @param typeid  ͼ������id
	 * @return  ͼ��������Ϣ
	 */
	public Booktype getBookTypeByBookTypeId(Integer typeid);
	public List<Booktype> selectBookTypeList(Integer pageNum, Integer pageSize) ;
	public void deleteBookTypeByID(Integer id);
	public List<String> getBorrowbookListBetweenDay();


}
