package dao;

import vo.ScreenVO;


public interface ScreenDao {


	ScreenVO getScreenName(String key,String screenName); // 검색값과 일치하는 상영관을 선택
	
}
