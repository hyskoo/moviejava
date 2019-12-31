package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import sun.java2d.pipe.SpanShapeRenderer.Simple;
import vo.PayVO;
import data.Database;
import data.Session;

public class ReceiptInfoDaoImpl implements ReceiptInfoDao {
	private static ReceiptInfoDaoImpl instance;
	
	private ReceiptInfoDaoImpl(){}
	
	public static ReceiptInfoDao getInstance() {
		if (instance == null) {
			instance = new ReceiptInfoDaoImpl();
		}
		return instance;
	}
	
	Database database = Database.getInstance();

	// 맵으로 값옮겨서하면 너무 힘드므로
	@Override
	public void getReceipt(Map<String, Object> param, int point, int payWay, int inputMoney) {
		// 영화 이름
		for (int i = 0; i < database.mv_list.size(); i++) {
			if (database.mv_list.get(i).getMovieId() == (int) param.get("영화 아이디")) {
				System.out.println(database.mv_list.get(i).getMovieName());			
			}
		}
		
		// 상영관 이름
		for (int i = 0; i < database.screenlist.size(); i++) {
			if (database.screenlist.get(i).getScreenId() == (int) param.get("영화 상영관 아이디")) {
				System.out.println(database.screenlist.get(i).getScreenName());		
			}
		}
		
		// 영화 상영시작시작
		for (int i = 0; i < database.mSchlist.size(); i++) {
			if (database.mSchlist.get(i).getmScheduleId() == (int) param.get("영화 상영시간 아이디")) {
				System.out.print(database.mSchlist.get(i).getmScheduleTime());	
			}
		}
		// 영화 상영종료 시간
		for (int i = 0; i < database.mv_list.size(); i++) {
			if (database.mv_list.get(i).getMovieId() == (int) param.get("영화 아이디")) {
				String minute = "0";
				if (database.mv_list.get(i).getMovieRunningTime() % 60 < 10) {
					minute += database.mv_list.get(i).getMovieRunningTime() % 60;
				} else {
					minute = ""+database.mv_list.get(i).getMovieRunningTime() % 60;
				}
				System.out.print(" ~ " + database.mv_list.get(i).getMovieRunningTime() / 60 + 9 + ":" + minute); 
				System.out.println("\t" + database.mv_list.get(i).getMovieRunningTime() + "분");
			}
		}
		
		//좌석의 위치 정보
		System.out.print("좌석번호 : ");
		for (int i = 0; i < database.seatlist.size(); i++) {
			ArrayList<Integer> arr = (ArrayList<Integer>) param.get("좌석아이디");
			for (int j = 0; j < arr.size(); j++) {
				if (database.seatlist.get(i).getSeatid() == arr.get(j)) {
					String SeatName = database.seatlist.get(i).getSeatRownumber() + database.seatlist.get(i).getSeatNum(); 
					System.out.print(SeatName + ", ");
				}
			}
		}
		System.out.println();
		System.out.println("어른 : " + param.get("영화어른수") + ", 청소년 : " + param.get("영화청소년수") +  ", 아이 : " + param.get("영화어린이수"));
		
		// 결제 형태
		for (int i = 0; i < database.payList.size(); i++) {
			if (database.payList.get(i).getPayId() == (int) param.get("결제 아이디")) {
				System.out.println("결제 형태 : " + database.payList.get(i).getPayInfo());
			}
		}
		
		int money = 0;
		if (payWay == 2) {
			if (inputMoney + Session.loginUser.getUserPoint() >= (int) param.get("총금액")) {
				money = inputMoney - (int) param.get("총금액") + point;
				Session.loginUser.setUserPoint(Session.loginUser.getUserPoint() - point);
				System.out.println("거스름돈 = " + money);
			} else {
				System.out.println("금액이 부족합니다.");
			}
		}else if (payWay != 2) {
			money = (int) param.get("총금액") + point ;
			System.out.println("결제 금액 : " + money);
		}  else {
			System.out.println("값을 잘못입력하셨습니다.");
		}
		
		System.out.println("사용후 남은 포인트 : " + Session.loginUser.getUserPoint() + "\n"
				+ " - 적립량  : " +  (int) param.get("총금액") / (100 - Session.loginUser.getUserLevel()) + "\n"
				+ " - 최종 포인트 : " + (Session.loginUser.getUserPoint() + (int) param.get("총금액") / (100 - Session.loginUser.getUserLevel())));
		Session.loginUser.setUserPoint(Session.loginUser.getUserPoint() + (int) param.get("총금액") / (100 - Session.loginUser.getUserLevel()));

		
	}
}

