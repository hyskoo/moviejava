package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import vo.UserVO;

public class Database {
	
	private static Database instance;

	private Database() { }

	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}
	
	/**
 	 * @author 김령환
 	 * @brief String타입을 Date형으로 넣기위한 형변환. 및 2차원 배열을 통한 DB화
 	 */
	SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
	public ArrayList<UserVO> userlist = new ArrayList<>();
	
	{
		UserVO user1 = new UserVO();
		user1.setUserId("a1");  //카드 번호가 아이디에 해당되는 형식이 된다.
		user1.setUserPhone("010-1111-1111"); //순수 전화번호를 통한 데이터확인 자바만을 이용해서는 방법이없다. (기본키 제약조건)
		user1.setUserLevel(0);
		user1.setUserPoint(1000);
		try {
			user1.setUserDate(dateform.parse("2019-01-20"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userlist.add(user1);
		
		UserVO user2 = new UserVO();
		user2.setUserId("a2");
		user2.setUserPhone("010-2222-2222");
		user2.setUserLevel(0);
		user2.setUserPoint(2000);
		try {
			user2.setUserDate(dateform.parse("2019-02-20"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userlist.add(user2);
		
		UserVO user3 = new UserVO();
		user3.setUserId("a3");
		user3.setUserPhone("010-3333-3333");
		user3.setUserLevel(0);
		user3.setUserPoint(3000);
		try {
			user3.setUserDate(dateform.parse("2019-03-20"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userlist.add(user3);
		
		UserVO user4 = new UserVO();
		user4.setUserId("a4");
		user4.setUserPhone("010-4444-4444");
		user4.setUserLevel(0);
		user4.setUserPoint(4000);
		try {
			user4.setUserDate(dateform.parse("2019-04-20"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userlist.add(user4);
		
		UserVO user5 = new UserVO();
		user5.setUserId("a5");
		user5.setUserPhone("010-5555-5555");
		user5.setUserLevel(0);
		user5.setUserPoint(5000);
		try {
			user5.setUserDate(dateform.parse("2019-05-20"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userlist.add(user5);
	
	}
}
