package service;

import java.util.Scanner;

import vo.ScreenVO;
import dao.ScreenDao;
import dao.ScreenDaoImpl;

public class ScreenServiceImpl implements ScreenService {

	private static ScreenServiceImpl instance;
	
	public ScreenServiceImpl(){}
	
	public static ScreenService getInstance() {
		if (instance == null) {
			instance = new ScreenServiceImpl();
		}
		return instance;
	}
	public static void main(String[] args) {
		new ScreenServiceImpl().getScreenInfo();
	}

	/**
 	 * @author 정대석
 	 * @brief Screen DaoImpl을 호출하여 값, 객채들을 반환 받는다.
 	 */
	
	ScreenDao screenDao = ScreenDaoImpl.getInstance();
	@Override
	public void getScreenInfo() {
		Scanner s = new Scanner(System.in);	//상영관을 입력하여 영화관에 있는 상영관을 조회한다.
		
		System.out.println("상영관을 검색해 주세요.");
		String name = s.nextLine();
		
		ScreenVO screen = new ScreenVO();
		screen.setScreenName(name);
		
		ScreenVO screenNameCheck = screenDao.getScreenName("상영관",screen.getScreenName());
		
		if (screenNameCheck == null) {	//입력한 상영관의 결점 여부를 확인한다.
			System.out.println("올바른 상영관이 아닙니다. 다시 입력해주세요.");
			getScreenInfo();
			
		} else {
			System.out.println(screen.getScreenName());
			System.out.println("영화시간표로 넘어간다.");
			// 영화시간표로 넘어가는 메소드 추가
		}
		
	}
		
}
