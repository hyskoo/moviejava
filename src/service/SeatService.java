package service;

import java.util.Map;

public interface SeatService {
	
	void showSeat(int screenId);

	int selectSeat(String SeatName, int screenId);
	
	void seatLevelPrice();

}
