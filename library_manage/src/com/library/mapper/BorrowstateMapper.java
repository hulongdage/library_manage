package com.library.mapper;

import com.library.entity.Borrowstate;
import com.library.entity.BorrowstateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowstateMapper {
    int countByExample(BorrowstateExample example);

    int deleteByExample(BorrowstateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Borrowstate record);

    int insertSelective(Borrowstate record);

    List<Borrowstate> selectByExample(BorrowstateExample example);

    Borrowstate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Borrowstate record, @Param("example") BorrowstateExample example);

    int updateByExample(@Param("record") Borrowstate record, @Param("example") BorrowstateExample example);

    int updateByPrimaryKeySelective(Borrowstate record);

    int updateByPrimaryKey(Borrowstate record);
}