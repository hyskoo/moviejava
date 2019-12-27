package service;

import java.util.Map;
import java.util.Scanner;

import vo.PayVO;
import dao.payDao;
import dao.payDaoImpl;

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
	public void setPayInfo(Map<String, Object> param) {
		
		int way = (int) param.get("결제방법");
		switch (way) {
		case 1:
			param.replace("결제방법", "카드");
			break;
		case 2:
			param.replace("결제방법", "현금");
			break;
		case 3:
			param.replace("결제방법", "페이");
			break;
		}
		System.out.println("입력하신 방법이 " + param.get("결제방법") + "이 맞으십니까? (Y/N)");
		if (scan.nextLine().equalsIgnoreCase("Y")) {
			paydao.setPayInfo(param);
		} else {
			System.out.println("이전화면으로 돌아갑니다.");
		}
	}
	
	
	
}
