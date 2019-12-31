
package service;


import java.util.Scanner;

import dao.SeatDao;
import dao.SeatDaoImpl;
import data.Except;

public class SeatServiceImpl implements SeatService {

	private static SeatServiceImpl instance;

	private SeatServiceImpl(){}

	public static SeatService getInstance(){
		if (instance == null) {
			instance = new SeatServiceImpl();
		}
		return instance;
	}


	SeatDao seatDao = SeatDaoImpl.getInstnace();
	Scanner scan = new Scanner(System.in);

	@Override
	public void showSeat(int screenId) {
		seatDao.showScreenSeat(screenId);
		
	}
	

	@Override
	public int selectSeat(String SeatName, int screenId) {
		// 사용자가 입력한 값은 String형태의 좌석의 위치이다. 그것을 우리는 id값으로 변환을 해야한다.
		System.out.println(SeatName.toUpperCase()+" 좌석이 맞습니까? (Y/N)");
		String SeatChar = SeatName.substring(0,1).toUpperCase();				// A, B, C와 같은 행의 정보
		int SeatNum = Except.exceptionInt(SeatName.substring(1,2));  // 1 ,2, 3과 같은 열의 정보
		String yn = Except.exceptionString(scan.nextLine());
		if (SeatName.length() == 2 && yn.equalsIgnoreCase("Y")) {

			return seatDao.setBlankSeat(SeatChar, SeatNum, screenId);
			
		} else if (SeatName.length() != 2) {
			System.out.println("좌석을 잘못입력하셨습니다. \n 다시 ");
		} else {
			System.out.print("다시 ");
		}
		return 0;
	}
	
	@Override
	public void seatLevelPrice() {
		do{
			System.out.println("상영관 관리 페이지 입니다.");
			System.out.println("접속하시려면 아무 숫자나 입력해 주세요.\n9.돌아가기");
			int i = Except.exceptionInt(scan.nextLine());
			if(i == 9){
				break;
			}else{
				seatDao.InputPrice();	
			}
		}while(true);	
	}



}
