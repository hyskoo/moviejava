package service;

import vo.PayVO;

public interface ReceiptInfoService {

	void getReceipt(int movieId, String ScreenMoiveId, PayVO paycnt, int seatid, int payWay);
	
}
