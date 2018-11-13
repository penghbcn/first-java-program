package com.jt.sso.mapper;

import com.jt.common.mapper.MyMapper;
import com.jt.sso.pojo.User;

public interface UserMapper extends MyMapper<User> {

	int checkUsername(String param);

	int checkPhone(String param);

	int checkEmail(String param);

}
