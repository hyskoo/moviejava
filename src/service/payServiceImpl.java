package service;

import java.util.Map;
import java.util.Scanner;

import dao.payDao;
import dao.payDaoImpl;
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
		do {
			System.out.println("입력하신 방법이 " + Sway + "이(가) 맞으십니까? (Y/N)   0 : 이전화면으로"); //null값이 입력되는 경우가 있음
			String yn = Except.exceptionString(scan.nextLine());
			if (yn.equalsIgnoreCase("Y")) {
				return paydao.setPayInfo(param, Sway); 
			} else if (yn.equalsIgnoreCase("N") || yn.equalsIgnoreCase("0")) {
				return 0;
			} else {
				System.out.println("값을 잘못입력하셨습니다.");
			}
		} while (true);
	}

	@Override
	public int getSeatPrice(Map<String, Object> param) {
		return paydao.getSeatPrice(param);
	}
	
	
	
}
