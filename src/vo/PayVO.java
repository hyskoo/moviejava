package vo;

import java.util.Date;

public class PayVO {
	private int payId;		// 결제 아이디
	private String payWay;	// 결제 수단
	private Date payDate;	// 결제 일자
	private String payInfo;	// 결제 내용 
	private int payAdultCnt; // 결제 어른 갯수
	private int payYoungCnt; // 결제 청소년 갯수
	private int payChildCnt; // 결제 어린이 갯수
	
	//외래키
	private String userId;		// 회원 아이디
	private int mScheduleId;	// 영화 시간 아이디
	
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public String getPayWay() {
		return payWay;
	}
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public String getPayInfo() {
		return payInfo;
	}
	public void setPayInfo(String payInfo) {
		this.payInfo = payInfo;
	}
	public int getPayAdultCnt() {
		return payAdultCnt;
	}
	public void setPayAdultCnt(int payAdultCnt) {
		this.payAdultCnt = payAdultCnt;
	}
	public int getPayYoungCnt() {
		return payYoungCnt;
	}
	public void setPayYoungCnt(int payYoungCnt) {
		this.payYoungCnt = payYoungCnt;
	}
	public int getPayChildCnt() {
		return payChildCnt;
	}
	public void setPayChildCnt(int payChildCnt) {
		this.payChildCnt = payChildCnt;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getmScheduleId() {
		return mScheduleId;
	}
	public void setmScheduleId(int mScheduleId) {
		this.mScheduleId = mScheduleId;
	}

}
