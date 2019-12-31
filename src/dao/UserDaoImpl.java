package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import vo.UserVO;
import data.Database;
import data.Except;


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
	Scanner scan = new Scanner(System.in);
	@Override
	public UserVO selectUser(String key, String value) {
		for (int i = 0; i < database.userlist.size(); i++) {
			UserVO user = database.userlist.get(i);
			if (key.equals("ID")) {
				if (user.getUserId().equals(value)) {
					return user;
				}
			} else if (key.equals("NAME")) {
				if (user.getUserName().equals(value)) {
					return user;
				}
			}
		}
		return null;
	}

	@Override
	public void inserUser(UserVO user) {
		database.userlist.add(user);
	}

	@Override
	public UserVO selectUser(HashMap<String, String> param) {
		UserVO rtnUser = null;
		for (int i = 0; i < database.userlist.size(); i++) {
			UserVO user = database.userlist.get(i);
			boolean flag = true;
			Set<String> keys = param.keySet();
			for (String key : keys) {
				String value = param.get(key);
				if (key.equals("ID")) {
					if (!user.getUserId().equals(value)) flag = false; 
				}
				else if (key.equals("PASSWORD")) {
					if (!user.getUserPw().equals(value)) flag = false;
				}					
			}
			if (flag) {
				rtnUser = user;
			}
		}
		return rtnUser;
	}
	@Override
	public void changeUser(HashMap<String, String> param) {
		for (int i = 0; i < database.userlist.size(); i++) {
			UserVO user = database.userlist.get(i);
			Set<String> keys = param.keySet();
			for (String key : keys) {
				String value = param.get(key);
				if (key.equals("ID")) {
					if (user.getUserId().equals(value)){
						System.out.println(user.getUserId()+" 님의 정보입니다. 수정하실 항목을 선택해주세요.\r\n단, 아이디와 등록 일자는 수정 할 수 없습니다.");
					boolean flag = true;
					do {
						System.out.println("----------------회원 정보------------");
						System.out.println("1. 회원 ID : " + user.getUserId());
						System.out.println("2. 회원 이름 : "+user.getUserName());
						System.out.println("3. 회원 등록일 : "+user.getUserDate());
						System.out.println("4. 회원 나이 : "+user.getUserAge());
						System.out.println("5. 회원 전화번호 : "+user.getUserPhone());
						System.out.println("6. 회원 등급 : "+user.getUserLevel());
						System.out.println("7. 회원 소지 포인트 : "+user.getUserPoint());
						System.out.println("9. 회원 관리 페이지로 돌아가기");
						int choice = Except.exceptionInt(scan.nextLine());
						switch (choice) {
						case 1:
							System.out.println("수정할 수 없는 항목입니다.");
							break;
						case 2:
							System.out.println("수정할 내용을 입력해주세요.");
							String name = Except.exceptionString(scan.nextLine());
							user.setUserName(name);
							System.out.println("수정되었습니다.");
							break;
						case 3:
							System.out.println("수정할 수 없는 항목입니다.");	
							break;
						case 4:
							System.out.println("수정 할 내용을 입력해주세요.");
							int userAge = Except.exceptionInt(scan.nextLine());
							user.setUserAge(userAge);
							System.out.println("수정되었습니다.");
							break;
						case 5:
							System.out.println("수정 할 내용을 입력해주세요.");
							String userPhone =Except.exceptionString(scan.nextLine());
							user.setUserPhone(userPhone);
							break;
						case 6:
							System.out.println("수정 할 내용을 입력해주세요.");
							int userLevel = Except.exceptionInt(scan.nextLine());
							user.setUserLevel(userLevel);
							System.out.println("수정되었습니다.");
							if(userLevel >= 90) {
							System.out.println("관리자 권한이 부여되었습니다.");
							}
							break;
						case 7:
							System.out.println("수정 할 내용을 입력해주세요.");
							int userPoint = Except.exceptionInt(scan.nextLine());
							user.setUserPoint(userPoint);
							System.out.println("수정되었습니다.");
							break;

						case 9:
							flag = false;
							break;
						default:
							System.out.println("잘못 입력하셨습니다.");
						}
					} while (flag);
					
					}
				}
			}
		 
		}
		
	}

	@Override
	public void showUser() { //등록된 모든 회원 정보(pw 제외)를 출력하는 메서드
		for(int i = 0; i< database.userlist.size(); i++){
			System.out.println("-------------------------------------------");
			System.out.println("회원 아이디 : "+database.userlist.get(i).getUserId());
			System.out.println("회원 이름 : "+database.userlist.get(i).getUserName());
			System.out.println("회원 나이 : "+database.userlist.get(i).getUserAge());
			System.out.println("회원 전화번호 : "+database.userlist.get(i).getUserPhone());
			System.out.println("회원 가입일시 : "+database.userlist.get(i).getUserDate());
			System.out.println("회원 소지 포인트 : "+database.userlist.get(i).getUserPoint());
			if(database.userlist.get(i).getUserLevel() >= 90){
				System.out.println("회원 등급 : 관리자");
			} else {				
				System.out.println("회원 등급 : "+database.userlist.get(i).getUserLevel());
			}
			
		}	
		System.out.println("-------------------------------------------");
		System.out.println("회원 관리 페이지로 돌아갑니다.\r\n");
	}
	
	@Override
	public UserVO choiceUser(HashMap<String, String> param) { //검색한 유저가 있는지 없는지 판단
		UserVO rtnUser = null;
		for (int i = 0; i < database.userlist.size(); i++) {
			UserVO user = database.userlist.get(i);
			boolean flag = true;
			Set<String> keys = param.keySet();
			for (String key : keys) {
				String value = param.get(key);
				if (key.equals("ID")) {
					if (!user.getUserId().equals(value)) flag = false; 
					
					}
				}
			if (flag) {
				rtnUser = user;
			}
		}
		return rtnUser;
	}

	@Override
	public void deleteUser(HashMap<String, String> param) {
		for (int i = 0; i < database.userlist.size(); i++) {
			UserVO user = database.userlist.get(i);
			Set<String> keys = param.keySet();
			for (String key : keys) {
				String value = param.get(key);
				if (key.equals("ID")) {
					if (user.getUserId().equals(value)){
						System.out.println(user.getUserId()+" 님을 삭제하시겠습니까?(Y/N)");
						String Yes = Except.exceptionString(scan.nextLine());
						if(Yes.equalsIgnoreCase("Y")) {
						database.userlist.remove(i);
						System.out.println("삭제 되었습니다. 회원 관리 페이지로 돌아갑니다.");
						} else {
						System.out.println("삭제를 취소했습니다. 회원 관리 페이지로 돌아갑니다.");	
						}
					}
				}
			}
		}
	}

}
