package Service;

import java.util.Scanner;

import vo.UserVO;
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
		Scanner scan = new Scanner(System.in);
		
		System.out.println("회원의 회원번호를 입력해주세요");
		String id = scan.nextLine();
		
		UserVO user = new UserVO();
		user.setUserId(id);
		
		UserVO userIdCheck = userDao.getUserId("ID", user.getUserId());
		
		if (userIdCheck == null) {
			System.out.println("회원이 아닙니다. 다시 입력하시겠습니까? (Y/N)");
			if (scan.nextLine().equals("Y")) {
				getUserInfo();
			} else {
				// 비회원 결제메소드를 실행하는 구문 추가
				System.out.println("비회원 결제");
			}
		} else {
			// 회원 결제메소드를 실행하는 구문 추가
			System.out.println("회원결제로 넘어간다.");
		}
	}
	
}
