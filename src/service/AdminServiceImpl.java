package service;

import java.util.Scanner;

public class AdminServiceImpl implements AdminService{
	
	private static AdminServiceImpl instance;
	
	private AdminServiceImpl(){}
	
	public static AdminService getInstance() {
		if (instance == null) {
			instance = new AdminServiceImpl();
		}
		return instance;
	}

	@Override
	public void getList() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("관리자 페이지 입니다.  목록을 선택해주세요");
		System.out.println("1.회원 관리 \t 2. 영화 관리 \t 3.회원가입");

		int menu = Integer.parseInt(scan.nextLine());
		switch (menu) {
		case 1: //로그인 페이지
			System.out.println("로그인을 위해 로그인 페이지로 이동합니다.");
			userService.login();
			break;
		case 2: //비회원으로 예매
			System.out.println("비회원 예매를 선택하셨습니다.");
//			getMovieInfo();
			break;
		case 3: //회원가입 페이지로 이동
			userService.join();
			break;
		case 0: // 관리자 페이지로 이동
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
			break;
		}
		
	}
	
}
