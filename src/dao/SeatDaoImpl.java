package dao;

import data.Database;

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
							
//				if (database.seatlist.get(i).getSeatNum() <= totalCol) {
//					String seatNumber = database.seatlist.get(i).getSeatRownumber() + database.seatlist.get(i).getSeatNum();
//					System.out.print(seatNumber + "\t");
//					if(database.seatlist.get(i).getSeatNum() == totalCol) {
//						System.out.println();
//					}
//				}
//				for (int j = 0; j < totalCol; j++) {
//					if (database.seatlist.get(i).getBlankSeat() == 0) {
//						System.out.print("□ \t"); // 공석일 경우 □ 출력
//					} 
//					if (database.seatlist.get(i).getBlankSeat() == 1) {
//						System.out.print("■ \t"); // 예약석일 경우 ■ 출력
//					} 
//					if (database.seatlist.get(i).getBlankSeat() == 9) {
//						System.out.print("  \t"); // 없는 자리일 경우 빈칸으로 출력
//					} 
//				}
//				if(database.seatlist.get(i).getSeatNum() == totalCol) {
//					System.out.println();
//				}
			
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


}


