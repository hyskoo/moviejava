package dao;

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

}
