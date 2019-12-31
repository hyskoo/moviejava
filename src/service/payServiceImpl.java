package service;

import java.util.Map;
import java.util.Scanner;

import vo.PayVO;
import dao.payDao;
import dao.payDaoImpl;
import data.Database;
import data.Except;

public class payServiceImpl implements payService {

	private static payServiceImpl instance;
	
	private payServiceImpl(){}
	
	public static payService getInstance() {
		if (instance == null) {
			instance = new payServiceImpl();
		}
		return instance;
	}
	
	payDao paydao = payDaoImpl.getInstance();
	Scanner scan = new Scanner(System.in);
	@Override
	public int setPayInfo(Map<String, Object> param, int payWay) {
		String Sway = null;
		switch (payWay) {
		case 1:
			Sway = "카드";
			break;
		case 2:
			Sway = "현금";
			break;
		case 3:
			Sway = "페이";
			break;
		}
		System.out.println("입력하신 방법이 " + Sway + "이 맞으십니까? (Y/N)");
		if (Except.exceptionString(scan.nextLine()).equalsIgnoreCase("Y")) {
			return paydao.setPayInfo(param, Sway);
		} else {
			System.out.println("이전화면으로 돌아갑니다.");
		}
		return 0;
	}

	@Override
	public int getSeatPrice(Map<String, Object> param) {
		return paydao.getSeatPrice(param);
	}
	
	
	
}
