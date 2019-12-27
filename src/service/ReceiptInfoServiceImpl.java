package service;

import vo.PayVO;
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
	public void getReceipt(int movieId, String ScreenMoiveId, PayVO paycnt, int seatid, int payWay) {
		
		ReceiptDao.getReceipt(movieId, ScreenMoiveId, paycnt, seatid, payW);
	}
	
	
	
	
}
