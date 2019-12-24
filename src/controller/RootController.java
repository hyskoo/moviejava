package controller;

import java.util.Scanner;

import data.Session;
import Service.AdminService;
import Service.AdminServiceImpl;
import Service.MovieService;
import Service.MovieServiceImpl;
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
 	 * @brief Service들을 모두 가져와서 객체인스턴스를 생성한다. main 메소드에서 관리자 페이지를 호출하는 메소드의 선택을 특정 단어를 입력함으로써 가능하도록 설치
 	 */
	UserService userService = UserServiceImpl.getInstance();
	MovieService movieService = MovieServiceImpl.getInstance();
	public static void main(String[] args) {
		// 회원정보 확인 ->  영화 선택 -> 시간 선택 -> 좌석 선택 -> 결제창 -> 영수증 출력
		
		new RootController().start();
	}


	void start(){
		int menu;
		System.out.println("해당서비스는 로그인이 필요한 서비스 입니다.");
		do{
			Scanner scan = new Scanner(System.in);
			
			if (Session.loginUser == null){
				System.out.println("1.로그인 \t 2. 회원가입 \t ");
			} else if (Session.loginUser != null) {
				
				mainPage();		//영화 선택 페이지 보여주기
				
			} else if (Session.loginUser.getUserLevel() >= 90) {
				System.out.println("관리자 기능입니다.");
			} 
			
	
			menu = Integer.parseInt(scan.nextLine());
			switch (menu) {
			case 1: //로그인 페이지
				System.out.println("로그인 페이지 입니다.");
				userService.login();
				break;
			case 2: //회원가입 페이지
				System.out.println("회원가입 페이지 입니다. 화면에 나오는 순서대로 입력해주세요.");
				userService.join();
				break;
			case 0: // 프로그램종료
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
				break;
			}
		}while(menu != 0);
	}
	
	private void mainPage() {
		do {
			System.out.println("☆★☆★☆★☆★영화 목록☆★☆★☆★☆★");
			System.out.println("☆★☆★☆★영화를 선택해 주세요☆★☆★");
			movieService.getMovieName();
			
			Scanner s = new Scanner(System.in);
			int movieNo = Integer.parseInt(s.nextLine());
			movieService.getMovieInfo(movieNo);
		} while(true);
		
	}
}










