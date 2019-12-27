package dao;

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
	public void getReceipt() {
		System.out.println("---------------------------");
		System.out.println(database.mv_list.get(Integer.parseInt(ScreenMoiveId)).getMovieName());
		int num = 0;
		String info = null;
		for (int i = 0; i < database.mSchlist.size(); i++) {
			if (database.mSchlist.get(i).getMovieId() == movieId) {
				num++;
				if (Integer.parseInt(ScreenMoiveId) == num) {
					info = "제 " + database.mSchlist.get(i).getScreenId()+" 상영관 " + database.mSchlist.get(i).getmScheduleTime();
				}
			}
		}		
		System.out.println(info);
		System.out.println("총 상영시간 : "+database.mv_list.get(Integer.parseInt(ScreenMoiveId)).getMovieRunningTime()+"분");
		
		/* 
		 * 좌석 정보 추가
		 */
	}
}
