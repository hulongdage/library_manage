package com.library.service;

import java.util.List;

import com.library.entity.Reader;
import com.library.entity.Readertype;

public interface ReaderService {
	
	/**
	 * 查询读者列表
	 * @param pageNum  当前页
	 * @param pageSize  每页显示条数
	 * @return  读者列表
	 */
	List<Reader> selectReaderList(Integer pageNum, Integer pageSize);
	/**
	 * 根据读者类型id查询读者类型名称
	 * @param id   读者类型id
	 * @return   读者类型名称
	 */
	public String selectReaderTypeByTypeId(Integer id);
	/**
	 * 根据读者类型名称查询读者类型id
	 * @param typename   读者类型名称
	 * @return  读者类型id
	 */
	public Integer selectReaderTypeIdByTypeName(String typename);
	/**
	 * 根据读者编号查询读者信息
	 * @param readerkey
	 * @return
	 */
	public List<Reader> showReaderDetailPage(Integer pageNum, Integer pageSize,String readerkey);
	public Reader showReaderDetail(String readerkey);
	/**
	 * 更新读者信息
	 * @param reader  读者信息
	 */
	public void updateReader(Reader reader);
	/**
	 * 根据读者编号删除读者
	 * @param readerkey  读者编号
	 */
	public void delReader(String readerkey);
	/**
	 * 添加读者信息
	 * @param reader  读者信息
	 */
	public void saveReader(Reader reader);
	/**
	 * 根据读者类型id得到最长可借阅图书天数
	 * @param readerTypeId  读者类型id
	 * @return  最长可借阅图书天数
	 */
	public Integer getReaderLimit(Integer readerTypeId);
	/**
	 * 查询读者类型信息列表
	 * @return  读者类型信息列表
	 */
	public List<Readertype> queryReaderTypeList(Integer pageNum, Integer pageSize);
	/**
	 * 更新读者类型信息
	 * @param readertype  读者类型信息
	 */
	public void updateReaderType(Readertype readertype);
	/**
	 * 根据读者类型id查询读者类型信息
	 * @param readertypeid 读者类型id
	 * @return  读者类型信息
	 */
	public Readertype showReaderTypeDetail(Integer readertypeid);
	/**
	 * 根据读者编号查询现借书数量
	 * @param readerkey  读者编号
	 * @return  现借书数量
	 */
	public Integer getBorrowNumByReaderKey(String readerkey);
	/**
	 * 查询是否有相同的读者编号
	 * @param readerkey  读者编号
	 * @return 
	 */
	public Boolean isExistReaderkey(String readerkey);
	public Boolean isExistBook(String readerkey,String isbn);

}
