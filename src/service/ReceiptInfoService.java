package service;

import vo.PayVO;

public interface ReceiptInfoService {

	void getReceipt(String selectScreen, PayVO pay, int seatid, int payWay);
	
}
