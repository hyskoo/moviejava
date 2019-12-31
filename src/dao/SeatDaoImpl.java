package dao;

import java.util.ArrayList;
import java.util.Scanner;

import vo.Screen_seatVO;
import data.Database;
import data.Except;

public class SeatDaoImpl implements SeatDao {
	private static SeatDaoImpl instance;

	private SeatDaoImpl(){}

	public static SeatDao getInstnace(){
		if (instance == null) {
			instance = new SeatDaoImpl();
		}
		return instance;
	}

	Database database = Database.getInstance();
	Scanner scan = new Scanner(System.in);
	@Override
	public void showScreenSeat(int screenId) {
		int totalSeat = 0; // 해당 상영관의 좌석의 총갯수를 구하자 
		int totalRow = 0; // 좌석의 총 행의 갯수 초기화
		int totalCol = 0; // 좌석의 총 열의 갯수 초기화
		for (int i = 0; i < database.seatlist.size(); i++) {
			if (database.seatlist.get(i).getScreenId() == screenId) {
				totalSeat++;
			}
		}
		
		totalRow = 5; // 좌석의 총 행의 갯수 입력
		totalCol = (int) (totalSeat / totalRow); // 좌석의 총 열의 갯수 입력
		
		// 해당 상영관의 좌석을 출력하여 회원에게 보여주자
		for (int i = 0; i < database.seatlist.size(); i++) {
			if (database.seatlist.get(i).getScreenId() == screenId) {
				if (screenId == database.seatlist.get(i).getScreenId()) {
					
					String seatNumber = database.seatlist.get(i).getSeatRownumber() + database.seatlist.get(i).getSeatNum();
					System.out.print(seatNumber + " ");
					
					if (database.seatlist.get(i).getBlankSeat() == 0){	// 공석일 경우 □ 출력
						System.out.print("□ \t");	
					} else if (database.seatlist.get(i).getBlankSeat() == 1){	// 예약석일 경우 ■ 출력
						System.out.print("■ \t");
					} else {	// 없는 자리일 경우 빈칸으로 출력
						System.out.print("  \t");
					}
					if(database.seatlist.get(i).getSeatNum() == totalCol) System.out.println();
				}	
			}	
		}
	}
	
	@Override
	public int setBlankSeat(String seatChar, int seatNum, int screenId) {
		int seatid = 0;
		for (int i = 0; i < database.seatlist.size(); i++) {
			if (database.seatlist.get(i).getScreenId() == screenId
				&& database.seatlist.get(i).getSeatRownumber().equals(seatChar)
				&& database.seatlist.get(i).getSeatNum() == seatNum) {

				if (database.seatlist.get(i).getBlankSeat() == 0) {
					database.seatlist.get(i).setBlankSeat(1);  // 좌석이 예약된 형태로 변경
					seatid = database.seatlist.get(i).getSeatid();
				} else if(database.seatlist.get(i).getBlankSeat() == 1) {
					System.out.println("이미 예약된 좌석입니다.");
				} else {
					System.out.println("선택할 수 없는 좌석입니다.");
				}
			}
		}

		return seatid;
	}
	@Override
	public void InputPrice() {
		ArrayList<Integer> seatInfo = new ArrayList<>();
		ArrayList<Integer> seatPrice = new ArrayList<>();
		
		for(int i = 0; i < database.seatlist.size(); i++){
			Screen_seatVO seat = database.seatlist.get(i);	
			if(!seatInfo.contains(seat.getSeatLevel())){
				seatInfo.add(seat.getSeatLevel());
			}
			if(!seatPrice.contains(seat.getSeatPrice())){
				seatPrice.add(seat.getSeatPrice());
			}
		}
		System.out.println("좌석 LEVEL : "+seatInfo);   
		System.out.println("레벨당 가격 : "+seatPrice);
		System.out.println("수정할 좌석레벨을 선택하시오");
		int priceInfo = 0;
		int level = Except.exceptionInt(scan.nextLine());
		for(int i = 0; i < database.seatlist.size(); i++){
			Screen_seatVO seat = database.seatlist.get(i);	
			if(level == seat.getSeatLevel()){
				priceInfo = seat.getSeatPrice();
			}
		}
		System.out.println(priceInfo+"원");
		System.out.println("수정할 좌석의 가격을 입력하시오 ");
		
		int price = Except.exceptionInt(scan.nextLine());
		System.out.println("입력한 값을 저장하시겠습니까? y/n");
		String answer = Except.exceptionString(scan.nextLine());
		if(answer.equalsIgnoreCase("y")){
			for(int i = 0; i <database.seatlist.size(); i++){
				Screen_seatVO seat = database.seatlist.get(i);
				if(seat.getSeatLevel() == level){
					seat.setSeatPrice(price);
				}
			}
			System.out.println("업데이트되었습니다");
			
		}
	}

}


