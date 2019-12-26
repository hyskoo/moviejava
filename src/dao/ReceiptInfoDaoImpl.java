package dao;

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
	
	
	
	
	
	
	
	
	
}
