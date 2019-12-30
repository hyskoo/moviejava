package service;

import java.util.Map;

import dao.ReceiptInfoDao;
import dao.ReceiptInfoDaoImpl;

public class ReceiptInfoServiceImpl implements ReceiptInfoService {
	private static ReceiptInfoServiceImpl instance;
	
	private ReceiptInfoServiceImpl(){}
	
	public static ReceiptInfoService getInstance() {
		if (instance == null) {
			instance = new ReceiptInfoServiceImpl();
		}
		return instance;
	}
	
	ReceiptInfoDao ReceiptDao = ReceiptInfoDaoImpl.getInstance();

	@Override
	public void getReceipt(Map<String, Object> param, int point, int payWay, int inputMoney) {
//		System.out.println("상영관 아이디 : " + param.get("영화 상영관 아이디"));
//		System.out.println("상영시간 아이디 : " + param.get("영화 상영시간 아이디"));
//		System.out.println("영화 아이디 : " + param.get("영화 아이디"));
//		System.out.println("결제 아이디 : " + param.get("결제 아이디"));
//		System.out.println("좌석 아이디 : " + param.get("좌석아이디"));
//		System.out.println("어른 : " + param.get("영화어른수"));
//		System.out.println("청소년 : " + param.get("영화청소년수"));
//		System.out.println("아이 : " + param.get("영화어린이수"));
//		System.out.println("----------------------------");
		
		ReceiptDao.getReceipt(param, point, payWay, inputMoney);
	}
}
