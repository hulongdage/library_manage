package com.library.service;

import java.util.List;

import com.library.entity.Reader;
import com.library.entity.Readertype;

public interface ReaderService {
	
	/**
	 * ��ѯ�����б�
	 * @param pageNum  ��ǰҳ
	 * @param pageSize  ÿҳ��ʾ����
	 * @return  �����б�
	 */
	List<Reader> selectReaderList(Integer pageNum, Integer pageSize);
	/**
	 * ���ݶ�������id��ѯ������������
	 * @param id   ��������id
	 * @return   ������������
	 */
	public String selectReaderTypeByTypeId(Integer id);
	/**
	 * ���ݶ����������Ʋ�ѯ��������id
	 * @param typename   ������������
	 * @return  ��������id
	 */
	public Integer selectReaderTypeIdByTypeName(String typename);
	/**
	 * ���ݶ��߱�Ų�ѯ������Ϣ
	 * @param readerkey
	 * @return
	 */
	public List<Reader> showReaderDetailPage(Integer pageNum, Integer pageSize,String readerkey);
	public Reader showReaderDetail(String readerkey);
	/**
	 * ���¶�����Ϣ
	 * @param reader  ������Ϣ
	 */
	public void updateReader(Reader reader);
	/**
	 * ���ݶ��߱��ɾ������
	 * @param readerkey  ���߱��
	 */
	public void delReader(String readerkey);
	/**
	 * ��Ӷ�����Ϣ
	 * @param reader  ������Ϣ
	 */
	public void saveReader(Reader reader);
	/**
	 * ���ݶ�������id�õ���ɽ���ͼ������
	 * @param readerTypeId  ��������id
	 * @return  ��ɽ���ͼ������
	 */
	public Integer getReaderLimit(Integer readerTypeId);
	/**
	 * ��ѯ����������Ϣ�б�
	 * @return  ����������Ϣ�б�
	 */
	public List<Readertype> queryReaderTypeList(Integer pageNum, Integer pageSize);
	/**
	 * ���¶���������Ϣ
	 * @param readertype  ����������Ϣ
	 */
	public void updateReaderType(Readertype readertype);
	/**
	 * ���ݶ�������id��ѯ����������Ϣ
	 * @param readertypeid ��������id
	 * @return  ����������Ϣ
	 */
	public Readertype showReaderTypeDetail(Integer readertypeid);
	/**
	 * ���ݶ��߱�Ų�ѯ�ֽ�������
	 * @param readerkey  ���߱��
	 * @return  �ֽ�������
	 */
	public Integer getBorrowNumByReaderKey(String readerkey);
	/**
	 * ��ѯ�Ƿ�����ͬ�Ķ��߱��
	 * @param readerkey  ���߱��
	 * @return 
	 */
	public Boolean isExistReaderkey(String readerkey);
	public Boolean isExistBook(String readerkey,String isbn);

}
