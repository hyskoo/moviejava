package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import vo.PayVO;
import data.Database;
import data.Session;

public class payDaoImpl implements payDao {

	private static payDaoImpl instance;
	
	private payDaoImpl(){}
	
	public static payDao getInstance() {
		if (instance == null) {
			instance = new payDaoImpl();
		}
		return instance;
	}
	
	Database database = Database.getInstance();
	Date today = new Date();
	int paycnt = 1;

	@Override
	public int setPayInfo(Map<String, Object> param, String sway) {
		this.paycnt++;
		PayVO pay = new  PayVO();
		pay.setPayId(paycnt);
		pay.setPayWay(sway);
		pay.setPayDate(today);
		pay.setPayInfo("구매");
		pay.setPayAdultCnt(Integer.parseInt(String.valueOf(param.get("영화어른수"))));
		pay.setPayYoungCnt(Integer.parseInt(String.valueOf(param.get("영화청소년수"))));
		pay.setPayChildCnt(Integer.parseInt(String.valueOf(param.get("영화어린이수"))));
		
		// 외래키
		pay.setmScheduleId(Integer.parseInt(String.valueOf(param.get("영화 상영시간 아이디"))));
		pay.setUserId(Session.loginUser.getUserId());
		
		database.payList.add(pay);
		
		return paycnt;
	}

	@Override
	public int getSeatPrice(Map<String, Object> param) {
		int price = 0;
		double discount = 1;
		ArrayList<Integer> arr = (ArrayList<Integer>) param.get("좌석아이디");
		if ((int) param.get("영화청소년수") > 0) {
			discount = 0.8;
		} else if ((int) param.get("영화어린이수") > 0){
			discount = 0.6; 
		}
		for (int i = 0; i < database.seatlist.size(); i++) {
			for (int j = 0; j < arr.size(); j++) {
				if (database.seatlist.get(i).getSeatid() == arr.get(j)) {
					price += database.seatlist.get(i).getSeatPrice()*discount;
				}
			}
		}
		return price;
	}
	
	
}
