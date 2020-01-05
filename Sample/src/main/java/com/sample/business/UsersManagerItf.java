package com.sample.business;

import com.sample.commons.dto.Login;
import com.sample.commons.dto.UserInfo;

public interface UsersManagerItf {
	public boolean checkCredentials(Login loginInfo);
	public UserInfo getUserInfo(Login loginInfo);
}
