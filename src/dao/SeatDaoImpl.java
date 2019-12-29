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
				String seatNumber = database.seatlist.get(i).getSeatRownumber() + database.seatlist.get(i).getSeatNum();
				System.out.print( seatNumber + "\t");
			}
			// 해당상영관 + 열의 최대값을 조건으로 준다.
			if (database.seatlist.get(i).getScreenId() == screenId && database.seatlist.get(i).getSeatNum() == totalCol) {
				System.out.println();
					for (int j = 0; j < totalCol; j++) {
						if (database.seatlist.get(i).getBlankSeat() == 0) {
							System.out.print("□ \t" + database.seatlist.get(i).getBlankSeat()); // 공석일 경우 □ 출력
						} 
						if (database.seatlist.get(i).getBlankSeat() == 1) {
							System.out.print("■ \t" + database.seatlist.get(i).getBlankSeat()); // 예약석일 경우 ■ 출력
						} 
						if (database.seatlist.get(i).getBlankSeat() == 9) {
							System.out.print("  \t"); // 없는 자리일 경우 빈칸으로 출력
						} 
					}
				System.out.println();
			}
		}	
	}
	
	@Override
	public int setBlankSeat(String seatChar, int seatNum, int screenId) {
		int seatid = 0;
		for (int i = 0; i < database.seatlist.size(); i++) {
			if (database.seatlist.get(i).getSeatRownumber().equals(seatChar)
				&& database.seatlist.get(i).getSeatNum() == seatNum  
				&& database.seatlist.get(i).getScreenId() == screenId) {
				
				System.out.println("setBlankSeat = " + database.seatlist.get(i).getBlankSeat());
				
				database.seatlist.get(i).setBlankSeat(1);  // 좌석이 예약된 형태로 변경
				seatid = database.seatlist.get(i).getSeatid();
				System.out.println("seatid = " + seatid);
				System.out.println("setBlankSeat = " + database.seatlist.get(i).getBlankSeat());
			}
		}

		return seatid;
	}

}

