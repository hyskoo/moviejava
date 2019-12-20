package vo;

public class Screen_seatVO {
	int Seatid;		// 좌석 아이디
	int SeatLevel;  // 좌석 등급
	int SeatNum;	// 좌석 번호
	int SeatPrice;	// 좌석 가격
	
	
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

}
