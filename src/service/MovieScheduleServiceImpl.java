package service;

import java.util.Scanner;

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

		// 해당영화를 보여주는 기능
		movieSchDao.getMoiveScheduleInfo(movieNo);
		
		
	}

}
