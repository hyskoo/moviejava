package vo;

import java.util.Date;

public class MovieScheduleVO {
	private int mScheduleId;	// 영화 시간 아이디
	private String mScheduleTime; // 영화 상영 시간
	
	// 외래키 
	private int movieId;	// 영화 아이디
	private int screenId;  // 영화 상영관 아이디
	
	
	
	public int getmScheduleId() {
		return mScheduleId;
	}
	public void setmScheduleId(int mScheduleId) {
		this.mScheduleId = mScheduleId;
	}
	public String getmScheduleTime() {
		return mScheduleTime;
	}
	public void setmScheduleTime(String mScheduleTime) {
		this.mScheduleTime = mScheduleTime;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	
	
}
