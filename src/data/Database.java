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
		UserVO user = new UserVO();
		user.setUserId("a1");  //카드 번호가 아이디에 해당되는 형식이 된다.
		user.setUserPhone("010-1111-1111"); //순수 전화번호를 통한 데이터확인 자바만을 이용해서는 방법이없다. (기본키 제약조건)
		user.setUserLevel(0);
		user.setUserPoint(1000);
		try {
			user.setUserDate(dateform.parse("2019-01-20"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userlist.add(user);
		
		user.setUserId("a2");
		user.setUserPhone("010-2222-2222");
		user.setUserLevel(0);
		user.setUserPoint(2000);
		try {
			user.setUserDate(dateform.parse("2019-02-20"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userlist.add(user);
		
		user.setUserId("a3");
		user.setUserPhone("010-3333-3333");
		user.setUserLevel(0);
		user.setUserPoint(3000);
		try {
			user.setUserDate(dateform.parse("2019-03-20"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userlist.add(user);
		
		user.setUserId("a4");
		user.setUserPhone("010-4444-4444");
		user.setUserLevel(0);
		user.setUserPoint(4000);
		try {
			user.setUserDate(dateform.parse("2019-04-20"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userlist.add(user);
		
		user.setUserId("a5");
		user.setUserPhone("010-5555-5555");
		user.setUserLevel(0);
		user.setUserPoint(5000);
		try {
			user.setUserDate(dateform.parse("2019-05-20"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userlist.add(user);
	
	}
}
