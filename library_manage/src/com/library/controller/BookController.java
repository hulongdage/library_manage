package com.library.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.library.entity.Book;
import com.library.entity.Booktype;
import com.library.entity.Dept;
import com.library.entity.Fine;
import com.library.entity.Reader;
import com.library.entity.Readertype;
import com.library.entity.Users;
import com.library.service.BookService;
import com.library.service.UserService;
import com.library.util.BorrowBookResult;
import com.library.util.EchartsEntitys;
import com.library.util.Pag;
import com.library.util.ResponseResult;


@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/queryBookTypeList")
	public String queryBookTypeList(Model model) {
		String name=SecurityContextHolder.getContext().getAuthentication().getName();
		Users user = userService.queryByUserName(name);
		List<Booktype> bookTypeList = bookService.getBookTypeList();
		model.addAttribute("bookTypeList", bookTypeList);
		model.addAttribute("user", user);
		return "admin/addBook2";
	}
	
	@RequestMapping("/addBook")
	public String addBook(Book book,RedirectAttributes attr) {		
		int bookTypeId = bookService.getBookIdByTypeName(book.getTypename());
		book.setTypeid(bookTypeId);
		bookService.addBook(book);
		attr.addAttribute("message","添加图书成功" );
		return "redirect:../book/queryBookTypeList.do";
	}
	
	@RequestMapping("/addBookDetail")
	public String addBookDetail(Book book) {		
		int bookTypeId = bookService.getBookIdByTypeName(book.getTypename());
		book.setTypeid(bookTypeId);
		book.setBorrownum(0);
		bookService.addBook(book);
		bookService.insertFineByISBN(book.getIsbn());
		return "admin/addBook1";
	}
	
	@RequestMapping("/updateBookDetail")
	public String updateBookDetail(Book book) {			
		book.setBorrownum(0);
		int bookTypeId = bookService.getBookIdByTypeName(book.getTypename());
		book.setTypeid(bookTypeId);
		bookService.updateBook(book);
		return "admin/searchBook1";
	}
	
	@RequestMapping("/updateBooktypeDetail")
	public String updateBooktypeDetail(Booktype booktype) {			
		bookService.updateBooktype(booktype);
		return "admin/addBookType1";
	}
	
	@RequestMapping("/addBooktypeDetail")
	public String addBooktypeDetail(Booktype booktype) {			
		bookService.insertBooktype(booktype);
		return "admin/addBookType1";
	}
	
	@RequestMapping("/deleteBook")
	@ResponseBody
	public ResponseResult<Void> deleteBook(String isbn){
		ResponseResult<Void> rr = new ResponseResult<>();		
		bookService.deleteBookByISBN(isbn);
		rr.setMessage("删除成功");
		return rr;		
	}
	
	@RequestMapping("/deleteBookType")
	@ResponseBody
	public ResponseResult<Void> deleteBookType(Integer id){
		ResponseResult<Void> rr = new ResponseResult<>();		
		bookService.deleteBookTypeByID(id);
		rr.setMessage("删除成功");
		return rr;		
	}
	
	@RequestMapping("/delBorrowBookById")
	@ResponseBody
	public ResponseResult<Void> delBorrowBookById(Integer id){
		ResponseResult<Void> rr = new ResponseResult<>();		
		bookService.delBorrowBookById(id);
		rr.setMessage("删除成功");
		return rr;		
	}
	
	@RequestMapping("/showFineDetail")
	public String showFineDetail(String isbn,Model model){
		Fine fineDetail = bookService.getFineByISBN(isbn);
		Book book = bookService.getBookByISBN(isbn);
		fineDetail.setBookname(book.getBookname());
		fineDetail.setNum(book.getNum());
		model.addAttribute("fineDetail", fineDetail);	
		return "user/fine2";		
	}
	
	@RequestMapping("/showBooktypeDetail")
	public String showBooktypeDetail(Integer id,Model model) throws ParseException{
		Booktype booktype = bookService.getBooktypeByID(id);
		model.addAttribute("booktype", booktype);
		return "admin/addBookType2";		
	}
	
	@RequestMapping("/showBookDetail")
	public String showBookDetail(String isbn,Model model) throws ParseException{
		Book book = bookService.getBookByISBN(isbn);
		Booktype booktype = bookService.getBookTypeByBookTypeId(book.getTypeid());
		book.setTypename(booktype.getTypename());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");		
		String dateStr = sdf.format(book.getPublishdate());
		Date mydate = sdf.parse(dateStr);
		book.setPublishdate(mydate);
		model.addAttribute("book", book);
		List<Booktype> bookTypeList = bookService.getBookTypeList();
		model.addAttribute("bookTypeList", bookTypeList);
		return "admin/searchBook2";		
	}
	
	@RequestMapping("/modifyFine")
	@ResponseBody
	public String modifyFine(Fine fine){		
		bookService.updateFine(fine);
		return "user/fine1";		
	}
	
	@RequestMapping("/queryByBookName")
	@ResponseBody
	public String queryByBookName(@RequestParam(required=true,value="pagenum",defaultValue="1") Integer pagenum,
			@RequestParam(required=true,value="pageSize",defaultValue="5")  Integer pageSize,String bookname) {
		PageHelper.startPage(pagenum, pageSize);
		List<Book> list = bookService.queryByBookNamePage(pagenum, pageSize,bookname);
		List<Book> bookList=new ArrayList<>();
		for(Book book : list) {
			String bookTypeName = bookService.getTypeNameByBookId(book.getTypeid());
			book.setTypename(bookTypeName);
			bookList.add(book);
		}		
		PageInfo<Book> pageInfo = new PageInfo<>(list);
		int totalPage = pageInfo.getPages();
		long totalData = pageInfo.getTotal();
		Pag pag = new Pag();
		pag.setTotalPage(totalPage);
		pag.setTotalData(totalData);
		pag.settBook(bookList);
		String jsonString = JSON.toJSONString(pag);	
		return jsonString;
	}
	
	@RequestMapping("/queryByBooktypeName")
	@ResponseBody
	public String queryByBooktypeName(@RequestParam(required=true,value="pagenum",defaultValue="1") Integer pagenum,
			@RequestParam(required=true,value="pageSize",defaultValue="5")  Integer pageSize,String typename) {
		PageHelper.startPage(pagenum, pageSize);
		List<Booktype> list = bookService.queryByBooktypeNamePage(pagenum, pageSize,typename);
		PageInfo<Booktype> pageInfo = new PageInfo<>(list);
		int totalPage = pageInfo.getPages();
		long totalData = pageInfo.getTotal();
		Pag pag = new Pag();
		pag.setTotalPage(totalPage);
		pag.setTotalData(totalData);
		pag.settBooktype(list);
		String jsonString = JSON.toJSONString(pag);	
		return jsonString;
	}
	
	@RequestMapping("/getBookTypeList")
	@ResponseBody
	public String getBookTypeList(@RequestParam(required=true,value="pagenum",defaultValue="1") Integer pagenum,
			@RequestParam(required=true,value="pageSize",defaultValue="5")  Integer pageSize){
		PageHelper.startPage(pagenum, pageSize);
		List<Booktype> list = bookService.selectBookTypeList(pagenum, pageSize);
		PageInfo<Booktype> pageInfo = new PageInfo<>(list);
		int totalPage = pageInfo.getPages();
		long totalData = pageInfo.getTotal();
		Pag pag = new Pag();
		pag.setTotalPage(totalPage);
		pag.setTotalData(totalData);
		pag.settBooktype(list);
		String jsonString = JSON.toJSONString(pag);	
		return jsonString;
	}
	
	@RequestMapping("/queryBookList")
	@ResponseBody
	public String selectUsersList(@RequestParam(required=true,value="pagenum",defaultValue="1") Integer pagenum,
			@RequestParam(required=true,value="pageSize",defaultValue="5")  Integer pageSize, Model model){
		PageHelper.startPage(pagenum, pageSize);
		List<Book> list = bookService.selectBookList(pagenum, pageSize);
		List<Book> bookList = new ArrayList<>();
		for(Book book : list) {
			String bookTypeName = bookService.getTypeNameByBookId(book.getTypeid());
			book.setTypename(bookTypeName);
			bookList.add(book);
		}
		PageInfo<Book> pageInfo = new PageInfo<>(list);
		int totalPage = pageInfo.getPages();
		long totalData = pageInfo.getTotal();
		Pag pag = new Pag();
		pag.setTotalPage(totalPage);
		pag.setTotalData(totalData);
		pag.settBook(bookList);
		String jsonString = JSON.toJSONString(pag);	
		return jsonString;
	}
	
	@RequestMapping("/queryFineList")
	@ResponseBody
	public String queryFineList(@RequestParam(required=true,value="pagenum",defaultValue="1") Integer pagenum,
			@RequestParam(required=true,value="pageSize",defaultValue="5")  Integer pageSize){
		PageHelper.startPage(pagenum, pageSize);
		List<Fine> list = bookService.selectFineList(pagenum, pageSize);
		List<Fine> fineList = new ArrayList<>();
		for(Fine fine : list) {  //bookname,num
			Book book = bookService.getBookByISBN(fine.getIsbn());
			fine.setBookname(book.getBookname());
			fine.setNum(book.getNum());
			fineList.add(fine);
		}
		PageInfo<Fine> pageInfo = new PageInfo<>(list);
		int totalPage = pageInfo.getPages();
		long totalData = pageInfo.getTotal();
		Pag pag = new Pag();
		pag.setTotalPage(totalPage);
		pag.setTotalData(totalData);
		pag.settFine(fineList);
		String jsonString = JSON.toJSONString(pag);	
		return jsonString;
	}
	
	@RequestMapping("/queryFineListPage")
	@ResponseBody
	public String queryFineListPage(@RequestParam(required=true,value="pagenum",defaultValue="1") Integer pagenum,
			@RequestParam(required=true,value="pageSize",defaultValue="5")  Integer pageSize,String isbn){
		PageHelper.startPage(pagenum, pageSize);
		List<Fine> list = bookService.queryFineListPage(pagenum, pageSize,isbn);
		List<Fine> fineList = new ArrayList<>();
		for(Fine fine : list) {  //bookname,num
			Book book = bookService.getBookByISBN(fine.getIsbn());
			fine.setBookname(book.getBookname());
			fine.setNum(book.getNum());
			fineList.add(fine);
		}
		PageInfo<Fine> pageInfo = new PageInfo<>(list);
		int totalPage = pageInfo.getPages();
		long totalData = pageInfo.getTotal();
		Pag pag = new Pag();
		pag.setTotalPage(totalPage);
		pag.setTotalData(totalData);
		pag.settFine(fineList);
		String jsonString = JSON.toJSONString(pag);	
		return jsonString;
	}
	
	@RequestMapping("/getBookListByBorrowNum")
	@ResponseBody
	public BorrowBookResult getBookListByBorrowNum() {
		BorrowBookResult borrowBookResult = new BorrowBookResult();
		List<Book> bookList = bookService.getBookListByBorrowNum();
		List<String> bookName = new ArrayList<>();
		List<Integer> borrownum = new ArrayList<>();
		for(Book book : bookList) {
			String bookTypeName = bookService.getTypeNameByBookId(book.getTypeid());
			book.setTypename(bookTypeName);
			bookName.add(book.getBookname());
			borrownum.add(book.getBorrownum());
		}	
		borrowBookResult.setBookName(bookName);
		borrowBookResult.setBorrownum(borrownum);
		return borrowBookResult;
	}
	
	@RequestMapping("/getBorrowbookListBetweenDay")
	@ResponseBody
	public Map getBorrowbookListBetweenDay() {
		List<String> listSize = bookService.getBorrowbookListBetweenDay();	
		List<String> listName=new ArrayList<>();
		for(int i=1;i<=listSize.size();i++) {
			String bookTypeName = bookService.getTypeNameByBookId(i);
			listName.add(bookTypeName);
		}	
		List<EchartsEntitys> EchartsEntitys = new ArrayList<>();
		for(int i=0;i<listSize.size();i++) {
			EchartsEntitys.add(new EchartsEntitys(listSize.get(i), listName.get(i)));
		}
		Map map = new HashMap<>();
        map.put("EchartsEntitys", EchartsEntitys);
        map.put("name", listName);
		return map;
	}
	
}
