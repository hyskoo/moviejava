package dao;

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
	public void getMoiveScheduleInfo() {
		database.screenlist
		
	}
	
}
