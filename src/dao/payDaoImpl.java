package dao;

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
	public void setPayInfo(Map<String, Object> param) {
		System.out.println(param.keySet());
		this.paycnt++;
		PayVO pay = new  PayVO();
		
		pay.setPayId(paycnt);
		pay.setPayWay(String.valueOf(param.get("결제방법")));
		pay.setPayDate(today);
		pay.setPayInfo("구매");
		pay.setPayAdultCnt(Integer.parseInt(String.valueOf(param.get("영화어른수"))));
		pay.setPayYoungCnt(Integer.parseInt(String.valueOf(param.get("영화청소년수"))));
		pay.setPayChildCnt(Integer.parseInt(String.valueOf(param.get("영화어린이수"))));
		
		// 외래키
		pay.setmScheduleId(Integer.parseInt(String.valueOf(param.get("영화 상영시간 아이디"))));
		pay.setUserId(Session.loginUser.getUserId());
		
		database.payList.add(pay);
		
	}
	
	
}
