package dao;

public interface SeatDao {
	
	void showScreenSeat(int screenId);

	int setBlankSeat(String seatChar, int seatNum, int screenId);

	void InputPrice();
}
