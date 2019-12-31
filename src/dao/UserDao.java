package dao;

import java.util.ArrayList;
import java.util.HashMap;

import vo.UserVO;

public interface UserDao {

	UserVO selectUser(String string, String userId);

	void inserUser(UserVO user);

	UserVO selectUser(HashMap<String, String> param);

	UserVO choiceUser(HashMap<String, String> param);
	
	void changeUser(HashMap<String, String> param);

	void deleteUser(HashMap<String, String> param);
	
	void showUser();
	
	
	



	
}
