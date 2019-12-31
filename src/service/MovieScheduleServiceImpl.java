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
	public void getMovieSchedule(int movieNo) {

		// 해당영화의 시간표를 보여주는 기능
		movieSchDao.getMoiveScheduleInfo(movieNo);
		
		
		
	}

	@Override
	public String getOneMovieInfo(int movieId, int screenMoiveId) {
		
		return movieSchDao.getOneMovieInfo(movieId, screenMoiveId); 
	}

	@Override
	public int getMovieSchId(int movieId, int screenMoiveId) {
		
		return movieSchDao.getMovieSchId(movieId, screenMoiveId); 
	}

	@Override
	public int getScreenId(int movieId, int screenMoiveId) {

		return movieSchDao.getScreenId(movieId, screenMoiveId);
	}

}
