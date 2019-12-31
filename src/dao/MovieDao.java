package dao;

import java.util.ArrayList;

import vo.MovieInfoVO;

public interface MovieDao {

	void getMovieInfo(int movieNo);
	
	ArrayList<MovieInfoVO> selectMovieInfo();

	void getMovieName();

	int getMovieCnt();

}
