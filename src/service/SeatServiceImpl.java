
package service;


import dao.SeatDao;
import dao.SeatDaoImpl;

public class SeatServiceImpl implements SeatService {

	private static SeatServiceImpl instance;

	private SeatServiceImpl(){}

	public static SeatService getInstance(){
		if (instance == null) {
			instance = new SeatServiceImpl();
		}
		return instance;
	}


	SeatDao seatDao = SeatDaoImpl.getInstnace();
	private String seatNumber;



	@Override
	public String showSeat(int screenNo) {
		seatDao.showScreenSeat(screenNo);
		return seatNumber;
	}


	@Override
	public void selectSeat(String seatNum) {
		seatDao.getScreenSeat(seatNum);
	}



}
