package dao;

import vo.MovieScheduleVO;
import dao.MovieScheduleDao;
import data.Database;

public class MovieScheduleDaoImpl implements MovieScheduleDao {
	
	private static MovieScheduleDaoImpl instance;
	
	private MovieScheduleDaoImpl(){}
	
	public static MovieScheduleDao getInstance() {
		if (instance == null) {
			instance = new MovieScheduleDaoImpl();
		}
		return instance;
	}

	Database database = Database.getInstance();

	@Override
	public void getMoiveScheduleInfo(int movieId) {
		int num = 0;
			for (int i = 0; i < database.mv_list.size(); i++) {
				if (database.mv_list.get(i).getMovieId() == movieId) {
					System.out.println(database.mv_list.get(i).getMovieName());
				}
			}
			for (int i = 0; i < database.mSchlist.size(); i++) {
				if (database.mSchlist.get(i).getMovieId() == movieId) {
					num++;
					System.out.println(num + ". 제 " + database.mSchlist.get(i).getScreenId()+" 상영관 \t" + database.mSchlist.get(i).getmScheduleTime());
				}
			}		
	}
	
	
	@Override
	public String getOneMovieInfo(int movieId, String screenMoiveId) {
		int num = 0;
		String info = null;
		for (int i = 0; i < database.mSchlist.size(); i++) {
			if (database.mSchlist.get(i).getMovieId() == movieId) {
				num++;
				if (Integer.parseInt(screenMoiveId) == num) {
					info = num + ". 제 " + database.mSchlist.get(i).getScreenId()+" 상영관 " + database.mSchlist.get(i).getmScheduleTime();
				}
			}
		}		
		
		return info;
	}

	@Override
	public int getMovieSchId(int movieId, String screenMoiveId) {
		
		int num = 0;
		int id = 0;
		for (int i = 0; i < database.mSchlist.size(); i++) {
			if (database.mSchlist.get(i).getMovieId() == movieId) {
				num++;
				if (Integer.parseInt(screenMoiveId) == num) {
					id= database.mSchlist.get(i).getScreenId();
				}
			}
		}		
		return id;
	}
	
}
