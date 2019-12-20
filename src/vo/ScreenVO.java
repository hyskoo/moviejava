package vo;

public class ScreenVO {
	private int ScreenId;  // 상영관 아이디
	private int ScreenNum; // 상영관 번호 (제 1관, 제 2관)
	
	public int getScreenId() {
		return ScreenId;
	}
	public void setScreenId(int screenId) {
		ScreenId = screenId;
	}
	public int getScreenNum() {
		return ScreenNum;
	}
	public void setScreenNum(int screenNum) {
		ScreenNum = screenNum;
	}
}
