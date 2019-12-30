package service;

import java.util.Map;

public interface ReceiptInfoService {

	void getReceipt(Map<String, Object> param, int point, int payWay, int inputMoney);
	
}
