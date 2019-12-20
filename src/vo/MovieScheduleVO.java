package vo;

import java.util.Date;

public class MovieScheduleVO {
	private int mScheduleId;	// 영화 시간 아이디
	private Date mScheduleTime; // 영화 상영 시간
	
	
	public int getmScheduleId() {
		return mScheduleId;
	}
	public void setmScheduleId(int mScheduleId) {
		this.mScheduleId = mScheduleId;
	}
	public Date getmScheduleTime() {
		return mScheduleTime;
	}
	public void setmScheduleTime(Date mScheduleTime) {
		this.mScheduleTime = mScheduleTime;
	}
}
