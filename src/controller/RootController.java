package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import service.AdminService;
import service.AdminServiceImpl;
import service.MovieScheduleService;
import service.MovieScheduleServiceImpl;
import service.MovieService;
import service.MovieServiceImpl;
import service.ReceiptInfoService;
import service.ReceiptInfoServiceImpl;
import service.ScreenService;
import service.ScreenServiceImpl;
import service.SeatService;
import service.SeatServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import service.payService;
import service.payServiceImpl;
import data.Except;
import data.Session;

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
	ScreenService screenService = ScreenServiceImpl.getInstance();
	MovieScheduleService movieSchService = MovieScheduleServiceImpl.getInstance();
	SeatService seatService = SeatServiceImpl.getInstance();//좌석관련 서비스 호출
	payService payservice = payServiceImpl.getInstance();
	ReceiptInfoService receiptService = ReceiptInfoServiceImpl.getInstance();
	AdminService adminService = AdminServiceImpl.getInstance();
	
	// 파라미터를 담기 위한 맵
	Map<String, Object> paramMap = new HashMap<>();
	Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// 회원정보 확인 ->  영화 선택 -> 시간 선택 -> 인원수 선택 -> 좌석 선택 -> 결제창 -> 영수증 출력
		new RootController().start() ;

	}

	void start(){
		int menu;
		System.out.println("해당서비스는 로그인이 필요한 서비스 입니다.");
		do{
			if (Session.loginUser == null){
				System.out.println("1.로그인 \t 2. 회원가입 \t ");
				menu = Except.exceptionInt(scan.nextLine());
				if (menu == 0) {
					System.out.println("잘못된 값입니다. 값을 다시 입력해주세요");
				} else if (menu == 1 || menu == 2) {
					switch (menu) {
					case 1: //로그인 페이지
						System.out.println("로그인 페이지 입니다.");
						userService.login();
						break;				// switch의 break로 do{ }while 반복문을 break하는것이 아니다.
					case 2: //회원가입 페이지
						System.out.println("회원가입 페이지 입니다. 화면에 나오는 순서대로 입력해주세요.");
						userService.join();
						break;
					}
				} else {
					System.out.println("잘못된 값입니다.");
				}
			} else if (Session.loginUser.getUserLevel() >= 90) {
				adminPerfom();
			} else if (Session.loginUser != null) {
				movieInfo(); //  2. 영화 선택 페이지 보여주기
			} 
		}while(true);
	}
	private void adminPerfom() {
			
		do{
			System.out.println("----------관리자 기능----------");
			System.out.println("수행하실 기능을 선택해 주세요.\r\n1.회원 관리\r\n2.영화 관리\r\n3.상영관 관리\r\n4.영화 예매\r\n9.로그 아웃");
			int	choice = Except.exceptionInt(scan.nextLine());
			switch (choice){
			case 9://로그아웃
			Session.loginUser = null;
			System.out.println("처음 화면으로 돌아갑니다.");
			break;
			case 1:// 회원 관리
			userService.info();
			break;
			case 2:// 영화 관리
				adminService.adminPage();
			break;
			case 3://상영관 관리
				seatService.seatLevelPrice();	
			break;
			case 4://관리자도 영화 예매 할 수 있도록 설정
			movieInfo();
			break;
			default:
				System.out.println("잘못 입력하셨습니다. 선택창으로 다시 돌아갑니다.\r");
			}
			if(Session.loginUser == null) break;
		}while (true);	
	}
	
	private void movieInfo() {	
		do {
			if (Session.loginUser != null) {
				System.out.println("☆★☆★☆★☆★영화 목록☆★☆★☆★☆★");
				System.out.println("☆★☆★☆★영화를 선택해 주세요☆★☆★");
				movieService.getMovieName();
				System.out.println("로그 아웃을 원하시면 9을 입력해주세요");
				int movieId = Except.exceptionInt(scan.nextLine());
				if (movieId == 9) {
					Session.loginUser = null;
					break;
				} else if (movieId != 0 && movieId > 0 && movieId <= movieService.getMoviecnt()){
					do {
						movieService.getMovieInfo(movieId);
						System.out.println("이 영화를 선택하시겠습니까? (Y/N)");
						String yn = Except.exceptionString(scan.nextLine());
						if (yn.equalsIgnoreCase("Y")) {
							getMovieSchedule(movieId);
							break;
						} else if (yn.equalsIgnoreCase("N")) {
							System.out.println("영화선택을 취소하셨습니다. \n");
							break;
						} else {
							System.out.println("값을 잘못입력하셨습니다. 다시 입력해주세요 \n");
						} 
					} while (true);
				} else {
					System.out.println("값을 잘못입력하셨습니다. 다시 입력해주세요 \n");
				}
			} else {
				System.out.println("로그인이 필요한 기능입니다.");
				break;
			}
		} while(true);
	}
	
	private void getMovieSchedule(int movieId) {
		do {
			System.out.println("영화의 상영관을 선택해주세요.  0 : 이전으로 돌아가기 9: 로그아웃");
			// 해당영화의 시간 전체 출력
			movieSchService.getMovieSchedule(movieId);
			int screenMoiveId = Except.exceptionInt(scan.nextLine());
			//상영관 아이디 일치여부 확인 필요
			if (screenMoiveId == 0) {
				break;
			} else if (screenMoiveId == 9) {
				Session.loginUser = null;
				break;
			} 
			System.out.println(movieSchService.getOneMovieInfo(movieId, screenMoiveId) + "(이)가 맞습니까? (Y/N)  0 : 이전으로 돌아가기");
			
			
			// 해당 영화의 상영시간 아이디를 뽑아온다. 
			int movieSchId= movieSchService.getMovieSchId(movieId, screenMoiveId);
			// 영화의 상영관 아이디를 뽑아온다.
			int screenId = movieSchService.getScreenId(movieId, screenMoiveId);
			
			String yn = Except.exceptionString(scan.nextLine());
			if (yn.equalsIgnoreCase("y")) {
				paramMap.put("영화 아이디", movieId);
				paramMap.put("영화 상영시간 아이디", movieSchId);
				paramMap.put("영화 상영관 아이디", screenId);
				
				System.out.println("관람을 할 인원을 선택해주세요.");
				System.out.println("성인은 몇명 입니까?");
				paramMap.put("영화어른수", Except.exceptionInt(scan.nextLine()));
				
				System.out.println("청소년은 몇명 입니까?");
				paramMap.put("영화청소년수", Except.exceptionInt(scan.nextLine()));
				
				System.out.println("어린이는 몇명 입니까?");
				paramMap.put("영화어린이수", Except.exceptionInt(scan.nextLine()));

				getScreenSeat(paramMap);
				break;
			} else if (Except.exceptionInt(yn) == 0) {
				System.out.println("이전으로 돌아갑니다.");
			}
		} while (true);
	}
	
	// 자리 출력 및 입력 메소드 이전것
	private void getScreenSeat(Map<String, Object> param) {
		int cnt = (int) param.get("영화어른수") + (int) param.get("영화청소년수") + (int) param.get("영화어린이수");
		ArrayList<Integer> seatIdList = new ArrayList<>();
		do {
			if (cnt > 0) {
				System.out.println("좌석을 선택해주세요");
				//사용자가 선택한 상영관의 좌석들을 보여준다.
				seatService.showSeat((int) param.get("영화 상영관 아이디"));
				
				// 사용자가 좌석을 선택한곳의  아이디 값을 가져온다.
				
				int seatid = seatService.selectSeat(Except.exceptionString(scan.nextLine()), (int) param.get("영화 상영관 아이디"));
				seatIdList.add(seatid);
				if (seatid != 0) {
					cnt--;
				}
			}
			// 결제를 해야한다. 결제정보를 저장한다. 저장은 유저의 아이디 값을 세션에서 가져와서 저장한다.
			
			if (cnt == 0) {
				seatService.showSeat((int) param.get("영화 상영관 아이디"));
				System.out.println("결제를 하시겠습니까? (Y/N)  0 : 이전으로 돌아가기");
				String yn = Except.exceptionString(scan.nextLine());
				if (yn.equalsIgnoreCase("Y")) {
					paramMap.put("좌석아이디", seatIdList);
					payMovie(paramMap);
					break;
				} else if(yn.equalsIgnoreCase("N")) {
					System.out.println("결제를 취소합니다. 영화 선택 화면으로 돌아갑니다.");
					break;
				} else if (yn.equalsIgnoreCase("0")) {
					System.out.println("영화 선택으로 돌아갑니다.");
					break;
				} else {
					System.out.println("값을 잘못입력하셨습니다.");
				}
			}
		} while (true);
	}

	
	private void payMovie(Map<String, Object> param) {
		do{	
			System.out.println("총 결제 금액은 " + payservice.getSeatPrice(param) + "입니다.");
			param.put("총금액", payservice.getSeatPrice(param));
			System.out.println("결제 방식을 선택해주세요 \n"
					+ "1. 카드 2. 현금 3. 페이  0.이전화면으로");
			int payWay = Except.exceptionInt(scan.nextLine());
			if (payWay == 0) {
				System.out.println("영화 선택 화면으로 돌아갑니다.");
				break;
			} else if (payWay <= 3 && payWay >= 1) {
				int payId = payservice.setPayInfo(paramMap, payWay);
				if (payId != 0) {
					param.put("결제 아이디", payId);
					getReceiptInfo(param, payWay);
					break;
				} else {
					System.out.println("이전화면으로 돌아갑니다.");
				}
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}while(true);
	}


	
	
	// 영수증 출력용 메소드
	private void getReceiptInfo(Map<String, Object> param, int payWay) {
		int point = 0;
		String yn = null;
		int inputMoney = 0;
		do {
			if (payWay == 2) {
				System.out.println("금액을 투입해주세요.");
				inputMoney = Except.exceptionInt(scan.nextLine()); // 사용자가 입력한 금액
				if (inputMoney < (int) param.get("총금액")) {
					System.out.println("금액이 부족합니다.");
					break;
				}
			}
			System.out.println("회원의 현재포인트는 " + Session.loginUser.getUserPoint() + "입니다.");
			System.out.println("포인트를 사용하시겠습니까? (Y/N)");
			yn = Except.exceptionString(scan.nextLine());
			if (yn.equalsIgnoreCase("y")) {
				System.out.println("포인트를 얼마 사용하시겠습니까?");
				point = Except.exceptionInt(scan.nextLine());
				receiptService.getReceipt(param, point, payWay,inputMoney);
				Session.loginUser = null;
				break;
			} else if (yn.equalsIgnoreCase("N")) {
				point = 0;
				receiptService.getReceipt(param, point, payWay,inputMoney);
				System.out.println("\n 이용해주셔서 감사합니다. \n");
				Session.loginUser = null;
				break;
			} else {
				System.out.println("잘못된 값을 입력하셨습니다.");
			}
		} while (true);
	}






}










