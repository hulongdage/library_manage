package com.library.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.library.entity.Borrowbook;
import com.library.entity.Users;
import com.library.entity.UsersExample;
import com.library.mapper.UsersMapper;
import com.library.service.BookService;
import com.library.service.impl.BookServiceImpl;

public class TestPageHelper {
	
	@Test
	public void testPageHelper() throws Exception {
		//1、获得mapper代理对象
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	    BookService bookService = applicationContext.getBean(BookService.class);
	    List<Borrowbook> list = bookService.queryBorrowBookList(1, 5);
	    System.out.println(list);
	}

}
