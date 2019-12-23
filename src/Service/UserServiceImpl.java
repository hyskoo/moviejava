package Service;

import dao.UserDao;
import dao.UserDaoImpl;

public class UserServiceImpl implements UserService {

	private static UserServiceImpl instance;
	
	private UserServiceImpl(){}
	
	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}
	/**
 	 * @author 김령환
 	 * @brief DaoImpl을 호출하여 값, 객채들을 반환 받는다.
 	 */
	UserDao userDao = UserDaoImpl.getInstance();

	@Override
	public void getUserInfo() {
		
	}
	
}
