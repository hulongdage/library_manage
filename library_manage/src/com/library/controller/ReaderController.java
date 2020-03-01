package com.library.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import com.library.entity.Borrowbook;
import com.library.entity.Borrowstate;
import com.library.entity.Dept;
import com.library.entity.Fine;
import com.library.entity.FineExample;
import com.library.entity.Reader;
import com.library.entity.Readertype;
import com.library.entity.Users;
import com.library.service.BookService;
import com.library.service.ReaderService;
import com.library.service.UserService;
import com.library.util.BorrowUserDetail;
import com.library.util.Pag;
import com.library.util.ResponseResult;

@Controller
@RequestMapping("/reader")
public class ReaderController {

	@Autowired
	private ReaderService readerService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/selectReaderList")
	@ResponseBody
	public String selectReaderList(@RequestParam(required=true,value="pagenum",defaultValue="1") Integer pagenum,
			@RequestParam(required=true,value="pageSize",defaultValue="5")  Integer pageSize){
		PageHelper.startPage(pagenum, pageSize);
		List<Reader> list = readerService.selectReaderList(pagenum, pageSize);
		PageInfo<Reader> pageInfo = new PageInfo<>(list);
		int totalPage = pageInfo.getPages();
		long totalData = pageInfo.getTotal();
		Pag pag = new Pag();
		pag.setTotalPage(totalPage);
		pag.setTotalData(totalData);
		pag.settReader(list);
		String jsonString = JSON.toJSONString(pag);	
		return jsonString;
	}
	
	@RequestMapping("/selectReaderByKey")
	@ResponseBody
	public String selectReaderByKey(@RequestParam(required=true,value="pagenum",defaultValue="1") Integer pagenum,
			@RequestParam(required=true,value="pageSize",defaultValue="5")  Integer pageSize,String readerkey){	
		PageHelper.startPage(pagenum, pageSize);
		List<Reader> list= readerService.showReaderDetailPage(pagenum, pageSize,readerkey);
		PageInfo<Reader> pageInfo = new PageInfo<>(list);
		int totalPage = pageInfo.getPages();
		long totalData = pageInfo.getTotal();
		Pag pag = new Pag();
		pag.setTotalPage(totalPage);
		pag.setTotalData(totalData);
		pag.settReader(list);
		String jsonString = JSON.toJSONString(pag);	
		return jsonString;
	}
	
	@RequestMapping("/queryReaderTypeList")
	@ResponseBody
	public String queryReaderTypeList(@RequestParam(required=true,value="pagenum",defaultValue="1") Integer pagenum,
			@RequestParam(required=true,value="pageSize",defaultValue="5")  Integer pageSize){
		PageHelper.startPage(pagenum, pageSize);
		List<Readertype> list = readerService.queryReaderTypeList(pagenum, pageSize);
		PageInfo<Readertype> pageInfo = new PageInfo<>(list);
		int totalPage = pageInfo.getPages();
		long totalData = pageInfo.getTotal();
		Pag pag = new Pag();
		pag.setTotalPage(totalPage);
		pag.setTotalData(totalData);
		pag.settReadertype(list);
		String jsonString = JSON.toJSONString(pag);	
		return jsonString;
	}
	
	@RequestMapping("/queryBorrowBookList")
	@ResponseBody
	public String queryBorrowBookList(@RequestParam(required=true,value="pagenum",defaultValue="1") Integer pagenum,
			@RequestParam(required=true,value="pageSize",defaultValue="5")  Integer pageSize){
		PageHelper.startPage(pagenum, pageSize);
		List<Borrowbook> list = bookService.queryBorrowBookList(pagenum, pageSize);	
		List<Borrowbook> borrowBookList = new ArrayList<>();
		for(Borrowbook borrowbook : list) {  //bookname,name,typename,statename
			Book book = bookService.getBookByISBN(borrowbook.getIsbn());
			borrowbook.setBookname(book.getBookname());
			Reader readerDetail = readerService.showReaderDetail(borrowbook.getReaderkey());
			borrowbook.setName(readerDetail.getName());
			borrowbook.setTypename(readerDetail.getTypename());
			Borrowstate borrowstate = bookService.getBorrowstateById(borrowbook.getState());
			borrowbook.setStatename(borrowstate.getName());
			Date borrowdate = new Date();			
			Date returndate = borrowbook.getReturndate();
			long daysBetween=(returndate.getTime()-borrowdate.getTime()+1000000)/(60*60*24*1000);
			if(daysBetween<0) {
				Fine fineByISBN = bookService.getFineByISBN(borrowbook.getIsbn());
				Long unitfine = fineByISBN.getFine();
				Long maxFine= unitfine*(-1)*daysBetween;
				if(maxFine>=book.getUnitprice()) {
					borrowbook.setFine(book.getUnitprice());
				}else {
					borrowbook.setFine(maxFine);
				}	
				borrowbook.setState(2);
				bookService.updateBorrowbook(borrowbook);
				borrowBookList.add(borrowbook);
			}else {
				borrowBookList.add(borrowbook);
			}
			
		}
		PageInfo<Borrowbook> pageInfo = new PageInfo<>(list);
		int totalPage = pageInfo.getPages();
		long totalData = pageInfo.getTotal();
		Pag pag = new Pag();
		pag.setTotalPage(totalPage);
		pag.setTotalData(totalData);
		pag.settBorrowbook(borrowBookList);
		String jsonString = JSON.toJSONString(pag);	
		return jsonString;
	}
	
	@RequestMapping("/queryAllBorrowBookList")
	@ResponseBody
	public String queryAllBorrowBookList(@RequestParam(required=true,value="pagenum",defaultValue="1") Integer pagenum,
			@RequestParam(required=true,value="pageSize",defaultValue="5")  Integer pageSize){
		PageHelper.startPage(pagenum, pageSize);
		List<Borrowbook> list = bookService.queryAllBorrowBookList(pagenum, pageSize);	
		List<Borrowbook> borrowBookList = new ArrayList<>();
		for(Borrowbook borrowbook : list) {  //bookname,name,typename,statename
			Book book = bookService.getBookByISBN(borrowbook.getIsbn());
			borrowbook.setBookname(book.getBookname());
			Reader readerDetail = readerService.showReaderDetail(borrowbook.getReaderkey());
			borrowbook.setName(readerDetail.getName());
			borrowbook.setTypename(readerDetail.getTypename());
			Borrowstate borrowstate = bookService.getBorrowstateById(borrowbook.getState());
			borrowbook.setStatename(borrowstate.getName());
			Date borrowdate = new Date();			
			Date returndate = borrowbook.getReturndate();
			long daysBetween=(returndate.getTime()-borrowdate.getTime()+1000000)/(60*60*24*1000);
			if(daysBetween<0) {
				Fine fineByISBN = bookService.getFineByISBN(borrowbook.getIsbn());				
				Long unitfine = fineByISBN.getFine();				
				Long maxFine= unitfine*(-1)*daysBetween;
				if(maxFine>=book.getUnitprice()) {
					borrowbook.setFine(book.getUnitprice());
				}else {
					borrowbook.setFine(maxFine);
				}				
				borrowbook.setState(2);
				bookService.updateBorrowbook(borrowbook);
				borrowBookList.add(borrowbook);
			}else {
				borrowBookList.add(borrowbook);
			}
			
		}
		PageInfo<Borrowbook> pageInfo = new PageInfo<>(list);
		int totalPage = pageInfo.getPages();
		long totalData = pageInfo.getTotal();
		Pag pag = new Pag();
		pag.setTotalPage(totalPage);
		pag.setTotalData(totalData);
		pag.settBorrowbook(borrowBookList);
		String jsonString = JSON.toJSONString(pag);	
		return jsonString;
	}
	
	@RequestMapping("/querySafeBorrowBookList")
	@ResponseBody
	public String querySafeBorrowBookList(@RequestParam(required=true,value="pagenum",defaultValue="1") Integer pagenum,
			@RequestParam(required=true,value="pageSize",defaultValue="5")  Integer pageSize){
		PageHelper.startPage(pagenum, pageSize);
		List<Borrowbook> list = bookService.querySafeBorrowBookList(pagenum, pageSize);	
		List<Borrowbook> borrowBookList = new ArrayList<>();
		for(Borrowbook borrowbook : list) {  //bookname,name,typename,statename
			Book book = bookService.getBookByISBN(borrowbook.getIsbn());
			borrowbook.setBookname(book.getBookname());
			Reader readerDetail = readerService.showReaderDetail(borrowbook.getReaderkey());
			borrowbook.setName(readerDetail.getName());
			borrowbook.setTypename(readerDetail.getTypename());
			Borrowstate borrowstate = bookService.getBorrowstateById(borrowbook.getState());
			borrowbook.setStatename(borrowstate.getName());
			borrowBookList.add(borrowbook);			
		}
		PageInfo<Borrowbook> pageInfo = new PageInfo<>(list);
		int totalPage = pageInfo.getPages();
		long totalData = pageInfo.getTotal();
		Pag pag = new Pag();
		pag.setTotalPage(totalPage);
		pag.setTotalData(totalData);
		pag.settBorrowbook(borrowBookList);
		String jsonString = JSON.toJSONString(pag);	
		return jsonString;
	}
	
	@RequestMapping("/queryDangerBorrowBookList")
	@ResponseBody
	public String queryDangerBorrowBookList(@RequestParam(required=true,value="pagenum",defaultValue="1") Integer pagenum,
			@RequestParam(required=true,value="pageSize",defaultValue="5")  Integer pageSize){
		PageHelper.startPage(pagenum, pageSize);
		List<Borrowbook> list = bookService.queryDangerBorrowBookList(pagenum, pageSize);	
		List<Borrowbook> borrowBookList = new ArrayList<>();
		for(Borrowbook borrowbook : list) {  //bookname,name,typename,statename
			Book book = bookService.getBookByISBN(borrowbook.getIsbn());
			borrowbook.setBookname(book.getBookname());
			Reader readerDetail = readerService.showReaderDetail(borrowbook.getReaderkey());
			borrowbook.setName(readerDetail.getName());
			borrowbook.setTypename(readerDetail.getTypename());
			Borrowstate borrowstate = bookService.getBorrowstateById(borrowbook.getState());
			borrowbook.setStatename(borrowstate.getName());
			borrowBookList.add(borrowbook);			
		}
		PageInfo<Borrowbook> pageInfo = new PageInfo<>(list);
		int totalPage = pageInfo.getPages();
		long totalData = pageInfo.getTotal();
		Pag pag = new Pag();
		pag.setTotalPage(totalPage);
		pag.setTotalData(totalData);
		pag.settBorrowbook(borrowBookList);
		String jsonString = JSON.toJSONString(pag);	
		return jsonString;
	}
	
	@RequestMapping("/queryReturnBorrowBookList")
	@ResponseBody
	public String queryReturnBorrowBookList(@RequestParam(required=true,value="pagenum",defaultValue="1") Integer pagenum,
			@RequestParam(required=true,value="pageSize",defaultValue="5")  Integer pageSize){
		PageHelper.startPage(pagenum, pageSize);
		List<Borrowbook> list = bookService.queryReturnBorrowBookList(pagenum, pageSize);	
		List<Borrowbook> borrowBookList = new ArrayList<>();
		for(Borrowbook borrowbook : list) {  //bookname,name,typename,statename
			Book book = bookService.getBookByISBN(borrowbook.getIsbn());
			borrowbook.setBookname(book.getBookname());
			Reader readerDetail = readerService.showReaderDetail(borrowbook.getReaderkey());
			borrowbook.setName(readerDetail.getName());
			borrowbook.setTypename(readerDetail.getTypename());
			Borrowstate borrowstate = bookService.getBorrowstateById(borrowbook.getState());
			borrowbook.setStatename(borrowstate.getName());
			borrowBookList.add(borrowbook);			
		}
		PageInfo<Borrowbook> pageInfo = new PageInfo<>(list);
		int totalPage = pageInfo.getPages();
		long totalData = pageInfo.getTotal();
		Pag pag = new Pag();
		pag.setTotalPage(totalPage);
		pag.setTotalData(totalData);
		pag.settBorrowbook(borrowBookList);
		String jsonString = JSON.toJSONString(pag);	
		return jsonString;
	}	
	
	@RequestMapping("/getBorrowBookListByReaderKey")
	@ResponseBody
	public String getBorrowBookListByReaderKey(@RequestParam(required=true,value="pagenum",defaultValue="1") Integer pagenum,
			@RequestParam(required=true,value="pageSize",defaultValue="5")  Integer pageSize,String readerkey){
		PageHelper.startPage(pagenum, pageSize);
		List<Borrowbook> list = bookService.getBorrowBookListByReaderKey(pagenum, pageSize,readerkey);	
		List<Borrowbook> borrowBookList = new ArrayList<>();
		for(Borrowbook borrowbook : list) {  //bookname,name,typename,statename
			Book book = bookService.getBookByISBN(borrowbook.getIsbn());
			borrowbook.setBookname(book.getBookname());
			Reader readerDetail = readerService.showReaderDetail(borrowbook.getReaderkey());
			borrowbook.setName(readerDetail.getName());
			borrowbook.setTypename(readerDetail.getTypename());
			Borrowstate borrowstate = bookService.getBorrowstateById(borrowbook.getState());
			borrowbook.setStatename(borrowstate.getName());
			borrowBookList.add(borrowbook);			
		}
		PageInfo<Borrowbook> pageInfo = new PageInfo<>(list);
		int totalPage = pageInfo.getPages();
		long totalData = pageInfo.getTotal();
		Pag pag = new Pag();
		pag.setTotalPage(totalPage);
		pag.setTotalData(totalData);
		pag.settBorrowbook(borrowBookList);
		String jsonString = JSON.toJSONString(pag);	
		return jsonString;
	}
	
	@RequestMapping("/showReaderDetail")
	public String showReaderDetail(String readerkey,Model model){
		Reader reader = readerService.showReaderDetail(readerkey);
		List<Dept> deptList = userService.selectDeptList();
		model.addAttribute("reader", reader);
		model.addAttribute("deptList", deptList);
		return "user/addAdmin";		
	}
	
	@RequestMapping("/showReaderTypeDetail")
	public String showReaderTypeDetail(Integer readertypeid,Model model){
		Readertype readertype = readerService.showReaderTypeDetail(readertypeid);
		model.addAttribute("readertype", readertype);	
		return "user/userType2";		
	}
	
	@RequestMapping("/updateReader")
	public String updateReader(Reader reader,Model model){
		Reader reader2 = readerService.showReaderDetail(reader.getReaderkey());
		reader.setRegdate(reader2.getRegdate());
		reader.setReaderid(reader2.getReaderid());
		reader.setBirthday(reader2.getBirthday());
		Integer readerTypeId = readerService.selectReaderTypeIdByTypeName(reader.getTypename());		
		reader.setType(readerTypeId);
		readerService.updateReader(reader);
		model.addAttribute("message", "读者信息修改成功");
		return "user/addAdmin2";		
	}
	
	@RequestMapping("/delReader")
	@ResponseBody
	public void delReader(String readerkey){	
		readerService.delReader(readerkey);
	}
	
	@RequestMapping("/queryDeptList")
	public String queryDeptList(Model model){
		List<Dept> deptList = userService.selectDeptList();
		model.addAttribute("deptList", deptList);
		return "user/addAdmin1" ;
	}
	@RequestMapping("/saveReader")
	public String saveReader(Reader reader){
		if(reader.getTypename().equals("高级读者")) {
			reader.setType(1);
		}else if (reader.getTypename().equals("普通读者")) {
			reader.setType(2);
		}else {
			reader.setType(3);
		}
		reader.setBirthday(new Date());
		reader.setRegdate(new Date());
		readerService.saveReader(reader);
		return "user/addAdmin2" ;
	}
	
	@RequestMapping("/borrowUserDetail")
	@ResponseBody
	public ResponseResult<Borrowbook> borrowUserDetail(String readerkey,String isbn) throws ParseException{	
		ResponseResult<Borrowbook> rr = new ResponseResult<>();
		if(readerkey != null) {			
			Borrowbook borrowbook = new Borrowbook();
			borrowbook.setReaderkey(readerkey);
			Reader reader = readerService.showReaderDetail(readerkey);
			borrowbook.setName(reader.getName());
			borrowbook.setTypename(reader.getTypename());		
			borrowbook.setBorrowdate(new Date());
			Integer limit = readerService.getReaderLimit(reader.getType());		
			Date date = new Date();
			borrowbook.setReturndate(new Date(date.getTime() + (long)limit * 24 * 60 * 60 * 1000));	
			Integer borrowNum = readerService.getBorrowNumByReaderKey(readerkey);		
			Integer maxborrownum = readerService.showReaderTypeDetail(reader.getType()).getMaxborrownum();
			if(borrowNum.equals(maxborrownum)) {
				rr.setMessage("已到最大数量");
			}else {
				rr.setMessage("未到最大数量");
			}
			rr.setBorrowNum(borrowNum+1);
			rr.setData(borrowbook);
			Boolean isExistBook = readerService.isExistBook(readerkey,isbn);	
			if(isExistBook) {
				rr.setState(1);
			}else {
				rr.setState(0);
			}					
		}
		return rr;
		
	}
	
	@RequestMapping("/borrowBook")
	public String borrowBook(Borrowbook borrowbook,Integer borrownum){
		Reader reader = readerService.showReaderDetail(borrowbook.getReaderkey());
		reader.setBorrownum(borrownum);
		readerService.updateReader(reader);
		Book book = bookService.getBookByISBN(borrowbook.getIsbn());
		book.setBorrownum(book.getBorrownum()+1);
		book.setNum(book.getNum()-1);
		bookService.updateBook(book);
		borrowbook.setBooktypeid(book.getTypeid());
		borrowbook.setFine(0L);
		borrowbook.setState(0);
		bookService.insertBorrowBook(borrowbook);
		return "user/borrowBook1" ;
	}
	
	@RequestMapping("/returnBook")
	@ResponseBody
	public ResponseResult<Void> returnBook(Integer id){	
		ResponseResult<Void> rr = new ResponseResult<>();
		Borrowbook borrowbook = bookService.getBorrowbookById(id);
		String readerkey = borrowbook.getReaderkey();
		Reader reader = readerService.showReaderDetail(readerkey);
		Integer borrownum = reader.getBorrownum();
		reader.setBorrownum(borrownum-1);
		readerService.updateReader(reader);
		Book book = bookService.getBookByISBN(borrowbook.getIsbn());		
		book.setNum(book.getNum()+1);
		bookService.updateBook(book);
		borrowbook.setState(1);
		borrowbook.setRealreturndate(new Date());
		bookService.updateBorrowbook(borrowbook);
		rr.setMessage("归还成功");
		return rr;
	}
	
	@RequestMapping("/modifyReaderType")
	@ResponseBody
	public String modifyReaderType(Readertype readertype){		
		readerService.updateReaderType(readertype);		
		return "user/userType1" ;
	}
	
	@RequestMapping("/isExistReaderkey")
	@ResponseBody
	public ResponseResult<Void> isExistReaderkey(String readerkey){		
		ResponseResult<Void> rr = new ResponseResult<>();		
		Boolean isExistReaderkey = readerService.isExistReaderkey(readerkey);	
		if(isExistReaderkey) {
			rr.setState(1);
		}else {
			rr.setState(0);
		}
		return rr ;
	}
	
	@RequestMapping("/isExistBook")
	@ResponseBody
	public ResponseResult<Void> isExistBook(String readerkey,String isbn){		
		ResponseResult<Void> rr = new ResponseResult<>();		
		Boolean isExistBook = readerService.isExistBook(readerkey,isbn);	
		if(isExistBook) {
			rr.setState(1);
		}else {
			rr.setState(0);
		}
		return rr ;
	}
}
