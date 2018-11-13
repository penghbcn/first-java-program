package cn.tedu.service;

import cn.tedu.domain.User;
import cn.tedu.exception.MsgException;

public interface UserService
{
	/**
	 * ִ�е�¼�ķ���
	 * 
	 * @param username
	 *            �û���
	 * @param password
	 *            ����
	 * @return ��װ���û����ݵ�JavaBean
	 * @throws MsgException
	 *             ��װ�˴�����Ϣ���쳣����
	 */
	User login(String username, String password) throws MsgException;

	/**
	 * ��ѯ�û��Ƿ���ڵķ���
	 * 
	 * @param username
	 *            �û���
	 * @return true--�û������� false--�û���������
	 */
	boolean hasUsername(String username);

	/**
	 * ִ��ע���û��ķ���
	 * 
	 * @param user
	 *            ��װ���û����ݵ�JavaBean
	 * @throws MsgException
	 *             ��װ�˴�����Ϣ���쳣����
	 */
	void registUser(User user) throws MsgException;
}
