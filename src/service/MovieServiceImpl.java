package service;

import java.util.ArrayList;

import dao.MovieDao;
import dao.MovieDaoImpl;
import vo.MovieInfoVO;

public class MovieServiceImpl implements MovieService {

	private static MovieServiceImpl instance;
	
	private MovieServiceImpl(){}
	
	public static MovieService getInstance() {
		if (instance == null) {
			instance = new MovieServiceImpl();
		}
		return instance;
	}
	/**
 	 * @author 정재영
 	 * @brief MovieDaoImpl을 호출하여 값, 객체들을 반환 받는다.
 	 */
	MovieDao movieDao = MovieDaoImpl.getInstance();
	
	/**
 	 * @author 정재영
 	 * @param int movieNo(moiveInfoVO.movieId)
 	 * @brief MovieDaoImpl 호출하여 영화 getMovieName으로 이름을 반환 getMoiveInfo로 전체 정보를 반환
 	 */
	@Override
	public void getMovieName() {
		movieDao.getMovieName();
		
	}

	@Override
	public void getMovieInfo(int movieNo) {
		ArrayList<MovieInfoVO> movieInfo = movieDao.selectMovieInfo();				//영화 정보 
		
		System.out.println("영화 제목 : \t" + movieInfo.get(movieNo - 1).getMovieName());	//영화 제목 출력
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
		
		System.out.println("영화 정보 : \t" + movieInfo.get(movieNo - 1).getMovieInfo());	//영화 정보 출력
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
		
		if (movieInfo.get(movieNo - 1).getMovieLimitAge() == 0) {						//영화 등급 출력
			System.out.println("영화 등급 : \t전체 관람가");								//전체 관람가는 0세로 지정
		}else {
			System.out.println("영화 등급 : \t" + movieInfo.get(movieNo - 1).getMovieLimitAge() + "세 관람가");			
		}
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
		
		System.out.println("영화 개봉일자 : \t" + movieInfo.get(movieNo - 1).getMovieOpenday());	//영화 개봉일 출력
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
		
		System.out.println("영화관 폐막일자 : \t" + movieInfo.get(movieNo - 1).getMovieCloseday());
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
		
		System.out.println("영화 런닝타임 : \t" + movieInfo.get(movieNo - 1).getMovieRunningTime() + "분");//영화 RunningTime 출력
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
	}

}
