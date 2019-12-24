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
	public void getMoiveScheduleInfo(int movieNo) {
		System.out.println(movieNo);
			for (int i = 0; i < database.mv_list.size(); i++) {
				if (database.mv_list.get(i).getMovieId() == movieNo) {
					System.out.println(database.mv_list.get(i).getMovieName());
				}
			}
			for (int i = 0; i < database.mSchlist.size(); i++) {
				if (database.mSchlist.get(i).getMovieId() == movieNo) {
					System.out.println("제 " + database.mSchlist.get(i).getScreenId()+" 상영관 \t" + database.mSchlist.get(i).getmScheduleTime());					
				}
			}		
		
	}
	
}
