package vo;

public class Screen_seatVO {
	private int Seatid;		// 좌석 아이디
	private int SeatLevel;  // 좌석 등급
	private int SeatNum;	// 좌석 번호
	private int SeatPrice;	// 좌석 가격
	
	//외래키
	private int screenId;  // 영화 상영관 아이디

	
	
	
	public int getSeatid() {
		return Seatid;
	}
	public void setSeatid(int seatid) {
		Seatid = seatid;
	}
	public int getSeatLevel() {
		return SeatLevel;
	}
	public void setSeatLevel(int seatLevel) {
		SeatLevel = seatLevel;
	}
	public int getSeatNum() {
		return SeatNum;
	}
	public void setSeatNum(int seatNum) {
		SeatNum = seatNum;
	}
	public int getSeatPrice() {
		return SeatPrice;
	}
	public void setSeatPrice(int seatPrice) {
		SeatPrice = seatPrice;
	}
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
}
