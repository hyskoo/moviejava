package vo;

public class ReceiptVO {
	int receiptId;	// 영수증 아이디
	
	// 외래키
	int payId;		// 결제 ID
	int seatId;		// 상영관 좌석 아이디
	
	
	
	
	public int getPayInfoId() {
		return receiptId;
	}
	public void setPayInfoId(int payInfoId) {
		this.receiptId = payInfoId;
	}
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
}
