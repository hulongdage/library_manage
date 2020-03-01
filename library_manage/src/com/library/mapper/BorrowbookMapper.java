package com.library.mapper;

import com.library.entity.Borrowbook;
import com.library.entity.BorrowbookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowbookMapper {
    int countByExample(BorrowbookExample example);

    int deleteByExample(BorrowbookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Borrowbook record);

    int insertSelective(Borrowbook record);

    List<Borrowbook> selectByExample(BorrowbookExample example);

    Borrowbook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Borrowbook record, @Param("example") BorrowbookExample example);

    int updateByExample(@Param("record") Borrowbook record, @Param("example") BorrowbookExample example);

    int updateByPrimaryKeySelective(Borrowbook record);

    int updateByPrimaryKey(Borrowbook record);
}