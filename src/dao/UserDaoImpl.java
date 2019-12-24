package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import vo.UserVO;
import data.Database;


public class UserDaoImpl implements UserDao {
	
	private static UserDaoImpl instance;
	
	private UserDaoImpl(){}
	
	public static UserDao getInstance() {
		if (instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}
	/**
 	 * @author 김령환
 	 * @brief Database을 호출하여 데이터 베이스 안에 있는 각종 값들을 조회 및 반환 하기 위해서 선언한다.
 	 */
	Database database = Database.getInstance();

	@Override
	public UserVO selectUser(String key, String value) {
		for (int i = 0; i < database.userlist.size(); i++) {
			UserVO user = database.userlist.get(i);
			if (key.equals("ID")) {
				if (user.getUserId().equals(value)) {
					return user;
				}
			} else if (key.equals("NAME")) {
				if (user.getUserName().equals(value)) {
					return user;
				}
			}
		}
		return null;
	}

	@Override
	public void inserUser(UserVO user) {
		database.userlist.add(user);
	}

	@Override
	public UserVO selectUser(HashMap<String, String> param) {
		UserVO rtnUser = null;
		for (int i = 0; i < database.userlist.size(); i++) {
			UserVO user = database.userlist.get(i);
			boolean flag = true;
			Set<String> keys = param.keySet();
			for (String key : keys) {
				String value = param.get(key);
				if (key.equals("ID")) {
					if (!user.getUserId().equals(value)) flag = false; 
				}
				else if (key.equals("PASSWORD")) {
					if (!user.getUserPw().equals(value)) flag = false;
				}					
			}
			if (flag) {
				rtnUser = user;
			}
		}
		return rtnUser;
	}
	

}
