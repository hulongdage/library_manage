package com.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Borrowbook;
import com.library.entity.BorrowbookExample;
import com.library.entity.Reader;
import com.library.entity.ReaderExample;
import com.library.entity.ReaderExample.Criteria;
import com.library.entity.Readertype;
import com.library.entity.ReadertypeExample;
import com.library.mapper.BorrowbookMapper;
import com.library.mapper.ReaderMapper;
import com.library.mapper.ReadertypeMapper;
import com.library.service.ReaderService;
@Service
public class ReaderServiceImpl implements ReaderService {

	@Autowired
	private ReaderMapper readerMapper;
	
	@Autowired
	private ReadertypeMapper readertypeMapper;
	
	@Autowired
	private BorrowbookMapper borrowbookMapper;
	
	@Override
	public List<Reader> selectReaderList(Integer pageNum, Integer pageSize) {
		ReaderExample example = new ReaderExample();
		List<Reader> readerList = readerMapper.selectByExample(example );
		if(readerList != null && readerList.size()>0) {
			return readerList;
		}else {
			return null;
		}
	}

	@Override
	public String selectReaderTypeByTypeId(Integer id) {
		Readertype readertype = readertypeMapper.selectByPrimaryKey(id);
		return readertype.getReadertypename();
	}

	@Override
	public List<Reader> showReaderDetailPage(Integer pageNum, Integer pageSize,String readerkey) {
		ReaderExample example = new ReaderExample();
		Criteria criteria = example.createCriteria();
		criteria.andReaderkeyEqualTo(readerkey);
		List<Reader> list = readerMapper.selectByExample(example );
		if(list != null && list.size()>0) {
			return list;
		}else {
			return null;
		}	
	}
	@Override
	public Reader showReaderDetail(String readerkey) {
		ReaderExample example = new ReaderExample();
		Criteria criteria = example.createCriteria();
		criteria.andReaderkeyEqualTo(readerkey);
		List<Reader> list = readerMapper.selectByExample(example );
		if(list!=null && list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
			
	}

	@Override
	public void updateReader(Reader reader) {
		readerMapper.updateByPrimaryKey(reader);	
	}

	@Override
	public Integer selectReaderTypeIdByTypeName(String typename) {
		ReadertypeExample example = new ReadertypeExample();
		com.library.entity.ReadertypeExample.Criteria criteria = example.createCriteria();
		criteria.andReadertypenameEqualTo(typename);
		List<Readertype> list = readertypeMapper.selectByExample(example );
		if(list != null && list.size()>0) {
			return list.get(0).getReadertypeid();
		}else {
			return null;
		}	
	}

	@Override
	public void delReader(String readerkey) {
		ReaderExample example = new ReaderExample();
		Criteria criteria = example.createCriteria();
		criteria.andReaderkeyEqualTo(readerkey);
		readerMapper.deleteByExample(example );
		BorrowbookExample example1 = new BorrowbookExample();
		com.library.entity.BorrowbookExample.Criteria criteria2 = example1.createCriteria();
		criteria2.andReaderkeyEqualTo(readerkey);
		borrowbookMapper.deleteByExample(example1 );
		
	}

	@Override
	public void saveReader(Reader reader) {
		readerMapper.insert(reader);		
	}

	@Override
	public Integer getReaderLimit(Integer readerTypeId) {
		Readertype readertype = readertypeMapper.selectByPrimaryKey(readerTypeId);
		return readertype.getBooklimit();
	}

	@Override
	public List<Readertype> queryReaderTypeList(Integer pageNum, Integer pageSize) {
		ReadertypeExample example = new ReadertypeExample();
		List<Readertype> list = readertypeMapper.selectByExample(example );
		if(list != null && list.size()>0) {
			return list;
		}else {
			return null;
		}
	}

	@Override
	public void updateReaderType(Readertype readertype) {
		readertypeMapper.updateByPrimaryKey(readertype);
		
	}

	@Override
	public Readertype showReaderTypeDetail(Integer readertypeid) {
		Readertype readertype = readertypeMapper.selectByPrimaryKey(readertypeid);
		return readertype;
	}

	@Override
	public Boolean isExistReaderkey(String readerkey) {
		ReaderExample example = new ReaderExample();
		Criteria criteria = example.createCriteria();
		criteria.andReaderkeyEqualTo(readerkey);
		List<Reader> list = readerMapper.selectByExample(example );
		if(list != null && list.size()>0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Boolean isExistBook(String readerkey,String isbn) {
		BorrowbookExample example = new BorrowbookExample();
		com.library.entity.BorrowbookExample.Criteria criteria = example.createCriteria();
		criteria.andReaderkeyEqualTo(readerkey);
		criteria.andStateNotEqualTo(1);
		List<Borrowbook> list = borrowbookMapper.selectByExample(example );
		Integer i = 0;
		if(list != null && list.size()>0) {
			for(Borrowbook borrowbook : list) {
				if(borrowbook.getIsbn().equals(isbn)) {
					i++;
				}
			}
		}
		if(i!=0) {
			return true;
		}else {
			
			return false;
		}
		
	}

	@Override
	public Integer getBorrowNumByReaderKey(String readerkey) {
		ReaderExample example = new ReaderExample();
		Criteria criteria = example.createCriteria();
		criteria.andReaderkeyEqualTo(readerkey);
		List<Reader> list = readerMapper.selectByExample(example );
		if(list != null && list.size()>0) {
			return list.get(0).getBorrownum();
		}else {
			return null;
		}
		
	}


}
