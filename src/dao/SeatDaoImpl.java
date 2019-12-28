package dao;


import javax.activation.MailcapCommandMap;

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
		for (int i = 0; i < database.seatlist.size(); i++) {
			if (screenId == database.seatlist.get(i).getScreenId()) {
				
			} else {
				System.out.println("잘못입력하셨습니다.");
			}
			if (screenId <= 3 && screenId >= 1) {	
				String seatNumber = database.seatlist.get(i).getSeatRownumber() + database.seatlist.get(i).getSeatNum();
				System.out.print( seatNumber + "\t");
				if(database.seatlist.get(i).getSeatNum() == 6){
					System.out.println();
					for(int j = 0; j < 6; j++){
						if (database.seatlist.get(i).getBlankSeat() == 0){	// 공석일 경우 □ 출력
							System.out.print("□ \t");	
						}
						if (database.seatlist.get(i).getBlankSeat() == 1){	// 예약석일 경우 ■ 출력
							System.out.print("■ \t");
						}
						if(database.seatlist.get(i).getBlankSeat() == 9){	// 없는 자리일 경우 빈칸으로 출력
							System.out.print("  \t");
						}
						
					}
					System.out.println();
				}
			}System.out.println();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new SeatDaoImpl().setBlankSeat("A", 8, 1));
	}
		

	@Override
	public int setBlankSeat(String seatChar, int seatNum, int screenId) {
		int seatid = 0;
		System.out.println(database.seatlist.get(0).getSeatRownumber());
		System.out.println(database.seatlist.get(7).getSeatNum());
		for (int i = 0; i < database.seatlist.size() - 1; i++) {
			if (database.seatlist.get(i).getSeatRownumber() == seatChar && database.seatlist.get(i).getSeatNum() == seatNum) {
				database.seatlist.get(i).setBlankSeat(1);  // 좌석이 예약된 형태로 변경
				seatid = database.seatlist.get(i).getSeatid();
			}
		}

		System.out.println(seatid);
		
		return seatid;
	}

}

