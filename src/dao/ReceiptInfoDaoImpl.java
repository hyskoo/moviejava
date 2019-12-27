package dao;

import java.util.Map;

import vo.PayVO;
import data.Database;

public class ReceiptInfoDaoImpl implements ReceiptInfoDao {
	private static ReceiptInfoDaoImpl instance;
	
	private ReceiptInfoDaoImpl(){}
	
	public static ReceiptInfoDao getInstance() {
		if (instance == null) {
			instance = new ReceiptInfoDaoImpl();
		}
		return instance;
	}
	
	Database database = Database.getInstance();

	@Override
	public void getReceipt(Map<String, Object> param) {
		
		/* 
		 * 좌석 정보 추가
		 */
	}
}
