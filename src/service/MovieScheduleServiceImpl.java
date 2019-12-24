package service;

import dao.MovieScheduleDao;
import dao.MovieScheduleDaoImpl;

public class MovieScheduleServiceImpl implements MovieScheduleService {

	private static MovieScheduleServiceImpl instance;
	
	private MovieScheduleServiceImpl(){}
	
	public static MovieScheduleService getInstance() {
		if (instance == null) {
			instance = new MovieScheduleServiceImpl();
		}
		return instance;
	}
	
	MovieScheduleDao  movieSchDao = MovieScheduleDaoImpl.getInstance();

	@Override
	public void getMovieSchedule() {
		movieSchDao.getMoiveScheduleInfo();
		
		
	}
	
}
