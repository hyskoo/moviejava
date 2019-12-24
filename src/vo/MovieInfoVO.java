package vo;

import java.util.Date;

public class MovieInfoVO {
	private int movieId;			// 영화 아이디
	private String movieName;		// 영화 이름
	private String movieInfo; 		// 영화정보
	private int movieLimitAge;		// 영화 나이 제한
	private Date movieOpenday;  	// 영화 개봉일자
	private Date movieCloseday; 	// 영화 종료일자
	private int movieRunningTime; 	//영화 런닝타임
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieInfo() {
		return movieInfo;
	}
	public void setMovieInfo(String movieInfo) {
		this.movieInfo = movieInfo;
	}
	public int getMovieLimitAge() {
		return movieLimitAge;
	}
	public void setMovieLimitAge(int movieLimitAge) {
		this.movieLimitAge = movieLimitAge;
	}
	public Date getMovieOpenday() {
		return movieOpenday;
	}
	public void setMovieOpenday(Date movieOpenday) {
		this.movieOpenday = movieOpenday;
	}
	public Date getMovieCloseday() {
		return movieCloseday;
	}
	public void setMovieCloseday(Date movieCloseday) {
		this.movieCloseday = movieCloseday;
	}
	public int getMovieRunningTime() {
		return movieRunningTime;
	}
	public void setMovieRunningTime(int movieRunningTime) {
		this.movieRunningTime = movieRunningTime;
	}
	
	
}
