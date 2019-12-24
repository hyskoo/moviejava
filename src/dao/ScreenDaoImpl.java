package dao;

import data.Database;
import vo.ScreenVO;
import vo.UserVO;

public class ScreenDaoImpl implements ScreenDao {

private static ScreenDaoImpl instance;
	
	private ScreenDaoImpl(){}
	
	public static ScreenDao getInstance() {
		if (instance == null) {
			instance = new ScreenDaoImpl();
		}
		return instance;
	}
	/**
 	 * @author 정대석
 	 * @brief Database을 호출하여 데이터 베이스 안에 있는 각종 값들을 조회 및 반환 하기 위해서 선언한다.
 	 */
	Database database = Database.getInstance();
	
	/**
 	 * @author 정대석
 	 * @brief 상영관 이름 값을 비교하여 존재여부를 파악. 없을경우 null을 리턴. 있으면 해당 상영관 값을 리턴
 	 */
	@Override
	public ScreenVO getScreenName(String key, String ScreenName) {
		for (int i = 0; i < database.screenlist.size(); i++) {
			ScreenVO screen = database.screenlist.get(i);
			if (key.equals("상영관")) {
				if (screen.getScreenName().equals(ScreenName)) {
					return screen;
				}
			} 
		}
		return null;

	}
}
