package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import data.Database;
import vo.MovieInfoVO;

public class MovieDaoImpl implements MovieDao {

	private static MovieDaoImpl instance;

	private MovieDaoImpl(){}

	public static MovieDao getInstance(){
		if (instance == null) {
			instance = new MovieDaoImpl();
		}
		return instance;
	}

	/**
	 * @author 정재영
	 * @param <MovieVO>
	 * 
	 * @brief Database_movieinfo를 호출하여 데이터 베이스 안에 있는 영화 제목을 조회 및 반환 하기 위해서 선언한다.
	 */ 
	Database database = Database.getInstance();


	@Override
	public void getMovieName() {
		for (int i = 0; i < database.mv_list.size(); i++) {
			System.out.println(database.mv_list.get(i).getMovieId() + ". " + database.mv_list.get(i).getMovieName());
		}
	}

	@Override
	public void getMovieInfo(int movieNo) {
		for (int i = 0; i < database.mv_list.size(); i++) {
			if (movieNo == i) {
				System.out.println(database.mv_list);
			}			
		}
	}

	@Override
	public ArrayList<MovieInfoVO> selectMovieInfo() {
		return database.mv_list;
	}

	@Override
	public int getMovieCnt() {
		return database.mv_list.size();
	}
}
