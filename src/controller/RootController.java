package controller;

import java.util.Scanner;

import Service.UserService;
import Service.UserServiceImpl;

public class RootController {
	
	/**
 	 * @param 자료형 $변수명 설명
 	 * @return 자료형 설명
 	 * @author 작성자
 	 * @brief 해당 코드에 대한 설명
 	 */
	
	/**
 	 * @author 김령환
 	 * @brief Service들을 모두 가져와서 객체인스턴스를 생성한다.
 	 */
	UserService userService = UserServiceImpl.getInstance();
	
	public static void main(String[] args) {
		RootController controller = new RootController();
		
		controller.userinfo();
	}

	
	private void userinfo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("적립하시겠습니까?");
		
		userService.getUserInfo(scan.nextLine());
	}
}
