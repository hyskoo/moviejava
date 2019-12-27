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
	public void showScreenSeat(int screeenNo) {
		if(screeenNo == 1){
			for (int i = 0; i < database.screen1Seat.size(); i++) {
				String seatNumber = database.screen1Seat.get(i).getSeatRownumber() + database.screen1Seat.get(i).getSeatNum();
				System.out.print( seatNumber + "\t");
				if(database.screen1Seat.get(i).getSeatNum() == 6){
					System.out.println();
					for(int j = 0; j < 6; j++){
						if (database.screen1Seat.get(i).getBlankSeat() == 0){	// 공석일 경우 □ 출력
							System.out.print("□ \t");	
						}
						if (database.screen1Seat.get(i).getBlankSeat() == 1){	// 예약석일 경우 ■ 출력
							System.out.print("■ \t");
						}
						if(database.screen1Seat.get(i).getBlankSeat() == 9){	// 없는 자리일 경우 빈칸으로 출력
							System.out.print("  \t");
						}
					}
					System.out.println();
				}
			}System.out.println();

		}
		
		if(screeenNo == 2){
			for (int i = 0; i < database.screen2Seat.size(); i++) {
				String seatNumber = database.screen2Seat.get(i).getSeatRownumber() + database.screen2Seat.get(i).getSeatNum();
				System.out.print(seatNumber + "\t");
				if(database.screen2Seat.get(i).getSeatNum() == 15){
					System.out.println();
					for(int j = 0; j < 15; j++){
						if (database.screen2Seat.get(i).getBlankSeat() == 0){
							System.out.print("□ \t");	
						}
						if (database.screen2Seat.get(i).getBlankSeat() == 1){
							System.out.print("■ \t");
						}
						if(database.screen2Seat.get(i).getBlankSeat() == 9) {
							System.out.print(" \t");
						}
					}
					System.out.println();
				}
			}System.out.println();

		}
		
		if(screeenNo == 3){
			for (int i = 0; i < database.screen3Seat.size(); i++) {
				String seatNumber = database.screen3Seat.get(i).getSeatRownumber() + database.screen3Seat.get(i).getSeatNum();
				System.out.print(seatNumber + "\t");
				if(database.screen3Seat.get(i).getSeatNum() == 9){
					System.out.println();
					for(int j = 0; j < 9; j++){
						if (database.screen3Seat.get(i).getBlankSeat() == 0){
							System.out.print("□ \t");	
						}
						if (database.screen3Seat.get(i).getBlankSeat() == 1){
							System.out.print("■ \t");
						}
						if(database.screen3Seat.get(i).getBlankSeat() == 9) {
							System.out.print(" \t");
						}
					}
					System.out.println();
				}
			}System.out.println();

		}


	}
	

	//test
	public static void main(String[] args) {
		new SeatDaoImpl().getScreenSeat("B1");;
		
	}

	@Override
	public void getScreenSeat(String seatNum) {
		String checkSeatNumber = database.screen1Seat.get(0).getSeatRownumber() + database.screen1Seat.get(0).getSeatNum();
		for(int i = 0; i < database.screen1Seat.size(); i++){
			if (seatNum == checkSeatNumber){
				System.out.println("결제하시겠습니까?");
			}
			
		}
		
	}
}

