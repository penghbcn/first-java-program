package cn.tedu.dao;

import cn.tedu.domain.User;

public interface UserDao
{
	/**
	 * �����û����������ѯ�û����ݵķ���
	 * 
	 * @param username
	 *            �û���
	 * @param password
	 *            ����
	 * @return null--�����ڸ��û���User--��װ�˶�Ӧ�û����ݵĶ���
	 */
	User getUserByUAndP(String username, String password);

	/**
	 * �����û�����ѯ�����Ƿ����
	 * 
	 * @param username
	 *            �û���
	 * @return true--�û����ڣ�false--�û�������
	 */
	User getUserByUsername(String username);

	/**
	 * �����û��ķ���
	 * 
	 * @param user
	 *            ��װ���û���Ϣ��JavaBean
	 * @return true--����ɹ��� false-- ����ʧ��
	 */
	boolean saveUser(User user);
}
