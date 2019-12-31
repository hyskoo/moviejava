package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import vo.UserVO;
import dao.UserDao;
import dao.UserDaoImpl;
import data.Except;
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
 	 * @brief DaoImpl을 호출하여 값, 객채들을 반환 받는다. Scanner로 사용자에게 값을 입력받는다. today는 현재 날짜를 구하기 위한 것
 	 */
	UserDao userDao = UserDaoImpl.getInstance();
	Scanner scan = new Scanner(System.in);
	Date today = new Date();
	/** 회원가입
 	 * @author 김령환
 	 * @brief 사용자에게 개인정보를 입력받아 아이디 중복체크를 하고 가입을 시킨다. 
 	 * 			- 가입성공시 login()메소드를 통해서 로그인 페이지로 이동을 시킨다.
 	 * 		    - 가입 실패시 페이지를 다시 호출한다.
 	 */
	@Override
	public void join() {
		System.out.print("아이디 : ");
		String id = Except.exceptionString(scan.nextLine());
		System.out.print("비밀번호 : ");
		String pw = Except.exceptionString(scan.nextLine());
		System.out.print("이름 : ");
		String name = Except.exceptionString(scan.nextLine());
		System.out.print("전화번호 : ");
		String phone = Except.exceptionString(scan.nextLine());
		System.out.print("나이 : ");
		String age = Except.exceptionString(scan.nextLine());
		
		UserVO user = new UserVO();
		user.setUserId(id);
		user.setUserPw(pw);
		user.setUserName(name);
		user.setUserPhone(phone);
		user.setUserPhone(age);
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
		System.out.print("아이디 : ");
		String id = Except.exceptionString(scan.nextLine());
		System.out.print("비밀번호 : ");
		String pw = Except.exceptionString(scan.nextLine());
		
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
				System.out.println("관리자님 환영합니다.");
			}
		}
	}
	
	@Override
	public void info() { //회원 관리 페이지
		boolean flag = true;
		do{	
			System.out.println("회원 관리 페이지 입니다. 원하시는 항목을 선택해 주세요.\r\n1.회원 목록\r\n2.회원 정보 관리\r\n9.관리자 기능으로 돌아가기");
			int sel = Except.exceptionInt(scan.nextLine());
			
			switch(sel){
			case 9:
				flag = false;
				break;
			case 1:	//회원 목록 출력 메서드
				userDao.showUser();

				break;
			case 2: //회원 정보 수정 메서드
				System.out.println("회원 정보 관리 페이지 입니다. ID를 검색해 주세요.");
				HashMap<String, String> param = new HashMap<String, String>();
				boolean roll = false;
				do {
					String id = Except.exceptionString(scan.nextLine());
					param.put("ID", id);
					UserVO user = userDao.choiceUser(param);
					if(user == null){
						System.out.println("없는 유저입니다.다시 검색해 주세요.");

						roll = true;

					}else{
						System.out.println(id + " 님을 관리하는 페이지로 이동합니다.");
						System.out.println("1.회원 정보 수정\t2.회원 삭제\r\n9.회원 관리 페이지로 돌아가기");
						int select = Except.exceptionInt(scan.nextLine());
						if(select == 1){
							userDao.changeUser(param);
							break;
						}else if(select == 2){
							userDao.deleteUser(param);
							break;
						}else if(select == 9){
							break;
							}
						}
					} while(roll);
					break;
				}
		
			}while(flag);	
		}
	

	
}
