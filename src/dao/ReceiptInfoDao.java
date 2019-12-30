package dao;

import java.util.Map;

public interface ReceiptInfoDao {

	void getReceipt(Map<String, Object> param, int point, int payWay, int inputMoney);

	
}
