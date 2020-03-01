package com.library.mapper;

import com.library.entity.Fine;
import com.library.entity.FineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FineMapper {
    int countByExample(FineExample example);

    int deleteByExample(FineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Fine record);

    int insertSelective(Fine record);

    List<Fine> selectByExample(FineExample example);

    Fine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Fine record, @Param("example") FineExample example);

    int updateByExample(@Param("record") Fine record, @Param("example") FineExample example);

    int updateByPrimaryKeySelective(Fine record);

    int updateByPrimaryKey(Fine record);
}