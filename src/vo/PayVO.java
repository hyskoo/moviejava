package vo;

import java.util.Date;

public class PayVO {
	private int payId;		// 결제 아이디
	private String payWay;	// 결제 수단
	private Date payDate;	// 결제 일자
	private String payInfo;	// 결제 정보
	
	
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

}
