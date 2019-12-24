package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import vo.UserVO;
import dao.UserDao;
import dao.UserDaoImpl;
import data.Session;

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
	AdminService adminService = AdminServiceImpl.getInstance();

	/** 회원가입
 	 * @author 김령환
 	 * @brief 사용자에게 개인정보를 입력받아 아이디 중복체크를 하고 가입을 시킨다. 
 	 * 			- 가입성공시 login()메소드를 통해서 로그인 페이지로 이동을 시킨다.
 	 * 		    - 가입 실패시 페이지를 다시 호출한다.
 	 */
	@Override
	public void join() {
		Scanner scan = new Scanner(System.in);
		Date today = new Date();
		
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		System.out.print("비밀번호 : ");
		String pw = scan.nextLine();
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("전화번호 : ");
		String phone = scan.nextLine();
		
		UserVO user = new UserVO();
		user.setUserId(id);
		user.setUserPw(pw);
		user.setUserName(name);
		user.setUserPhone(phone);
		user.setUserDate(today);
		
		UserVO userCheck = userDao.selectUser("ID", user.getUserId());
		
		if (userCheck == null) {
			userDao.inserUser(user);
			System.out.println("회원가입 성공.");
		} else {
			System.out.println("이미 사용하고 있는 아이디 입니다. 이전 페이지로 돌아갑니다.\n");
		}
	}
	
	/** 회원가입
 	 * @author 김령환
 	 * @brief 회원이 아이디와 비밀번호를 입력하면 그에 따라 작동하는 메소드. Session에 값을 저장하여 어디서든 이용가능한 형식을 사용하였다.
 	 * 			- Session을 통해 회원의 Level >= 90 이라면 관리자 페이지로 이동시킨다.
 	 */
	//로그인
	@Override
	public void login() {
		Scanner scan = new Scanner(System.in);

		System.out.print("아이디 : ");
		String id = scan.nextLine();
		System.out.print("비밀번호 : ");
		String pw = scan.nextLine();
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("ID", id);
		param.put("PASSWORD", pw);
		
		UserVO user = userDao.selectUser(param);
		
		if (user == null) {
			System.out.println("아이디 또는 비밀번호를 잘못입력하셨습니다. 다시 입력해주세요.");
			login();
		} else {
			Session.loginUser = user;  // Session에 user에 대한 값을 저장시킨뒤 후에 이것을 통해서 확인을 하면된다.
//			System.out.println(Session.loginUser.getUserLevel());
			System.out.println("로그인 성공");
			System.out.println(user.getUserName() + "회원님 확인되었습니다.");
			
			
			if (Session.loginUser.getUserLevel() >= 90) {
				System.out.println("관리자 페이지로 이동합니다.");
				adminService.getList();
			} else {
				// 결제페이지로 이동할 메소드를 구한한다.
			}

		}
	}
	
	
	

	
}
