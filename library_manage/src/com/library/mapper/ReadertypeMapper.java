package com.library.mapper;

import com.library.entity.Readertype;
import com.library.entity.ReadertypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReadertypeMapper {
    int countByExample(ReadertypeExample example);

    int deleteByExample(ReadertypeExample example);

    int deleteByPrimaryKey(Integer readertypeid);

    int insert(Readertype record);

    int insertSelective(Readertype record);

    List<Readertype> selectByExample(ReadertypeExample example);

    Readertype selectByPrimaryKey(Integer readertypeid);

    int updateByExampleSelective(@Param("record") Readertype record, @Param("example") ReadertypeExample example);

    int updateByExample(@Param("record") Readertype record, @Param("example") ReadertypeExample example);

    int updateByPrimaryKeySelective(Readertype record);

    int updateByPrimaryKey(Readertype record);
}