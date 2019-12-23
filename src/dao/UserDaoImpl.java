package dao;

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
	
	/**
 	 * @author 김령환
 	 * @brief 회원 아이디 값을 비교하여 존재여부를 파악. 없을경우 null을 리턴. 있으면 해당 id값을 리턴
 	 */
	@Override
	public UserVO getUserId(String key, String userId) {
		for (int i = 0; i < database.userlist.size(); i++) {
			UserVO user = database.userlist.get(i);
			if (key.equals("ID")) {
				if (user.getUserId().equals(userId)) {
					return user;
				}
			} 
		}
		System.out.println();
		return null;
	}

}
