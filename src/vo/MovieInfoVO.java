package vo;

import java.util.Date;

public class MovieInfoVO {
	private int movie_id;		 // 영화 아이디
	private String movie_name;	 // 영화 이름
	private String movie_info;   // 영화정보
	private int movie_limit_age; // 영화 나이 제한
	private Date movie_openday;  // 영화 개봉일자
	private Date movie_closeday; // 영화 종료일자
	private String movie_poster; // 영화 포스터 사진
	
	
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getMovie_info() {
		return movie_info;
	}
	public void setMovie_info(String movie_info) {
		this.movie_info = movie_info;
	}
	public int getMovie_limit_age() {
		return movie_limit_age;
	}
	public void setMovie_limit_age(int movie_limit_age) {
		this.movie_limit_age = movie_limit_age;
	}
	public Date getMovie_openday() {
		return movie_openday;
	}
	public void setMovie_openday(Date movie_openday) {
		this.movie_openday = movie_openday;
	}
	public Date getMovie_closeday() {
		return movie_closeday;
	}
	public void setMovie_closeday(Date movie_closeday) {
		this.movie_closeday = movie_closeday;
	}
	public String getMovie_poster() {
		return movie_poster;
	}
	public void setMovie_poster(String movie_poster) {
		this.movie_poster = movie_poster;
	}
}
