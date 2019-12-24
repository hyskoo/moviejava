package vo;

public class ScreenVO {
	private int ScreenId;  // 상영관 아이디
	private String ScreenName; // 상영관 이름 (제 1관, 제 2관)
	
	public int getScreenId() {
		return ScreenId;
	}
	public void setScreenId(int screenId) {
		ScreenId = screenId;
	}
	public String getScreenName() {
		return ScreenName;
	}
	public void setScreenName(String screenName) {
		ScreenName = screenName;
	}
	
	
}
