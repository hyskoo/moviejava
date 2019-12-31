package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import vo.MovieInfoVO;
import vo.MovieScheduleVO;
import vo.PayVO;
import vo.ReceiptVO;
import vo.ScreenVO;
import vo.Screen_seatVO;
import vo.UserVO;

public class Database {
	
	private static Database instance;

	private Database() { }

	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}
	Date today = new Date();
	/**
 	 * @author 김령환
 	 * @brief String타입을 Date형으로 넣기위한 형변환. 및 2차원 배열을 통한 DB화 및 초기화 블럭을 통한 초기 관리자 설정
 	 */
	SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
	public ArrayList<UserVO> userlist = new ArrayList<>();
	
	{
		UserVO user = new UserVO();
		user.setUserId("admin_id");
		user.setUserPw("admin_pw");
		user.setUserName("admin_name");
		user.setUserPhone("010-1234-5678");
		user.setUserLevel(90);			//90이상은 관리자
		user.setUserPoint(1000);
		user.setUserDate(today);
		userlist.add(user);
		
		UserVO user2 = new UserVO();
		user2.setUserId("1");
		user2.setUserPw("1");
		user2.setUserName("user1");
		user2.setUserPhone("010-1234-5678");
		user2.setUserLevel(0);			//90이상은 관리자
		user2.setUserPoint(1000);
		user2.setUserDate(today);
		userlist.add(user2);
	} // userList END
	
	/**
	 * @author 	정재영
	 * @brief 	Movieinfo DB
	 */
	public ArrayList<MovieInfoVO> mv_list = new ArrayList<>();
	{
		//1. 영화 백두산
		MovieInfoVO movie1 = new MovieInfoVO();
		movie1.setMovieId(1);  //영화 번호가 아이디에 해당되는 형식이 된다.
		movie1.setMovieName("백두산"); //영화 제목
		movie1.setMovieInfo("대한민국 관측 역사상 최대 규모의 백두산 폭발 발생.\n"
				+ "갑작스러운 재난에 한반도는 순식간에 아비규환이 되고, \n"
				+ "남과 북 모두를 집어삼킬 추가 폭발이 예측된다.");	//영화 설명
		movie1.setMovieLimitAge(12);	//12세 이상 관람가
		try {
			movie1.setMovieOpenday(dateform.parse("2019-12-19"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			movie1.setMovieCloseday(dateform.parse("2019-01-19"));
			//종료일자는 일단 1달 뒤로 잡았습니다. 나중에 수정해도 될것 같습니다.
		} catch (ParseException e) {
			e.printStackTrace();
		}
		movie1.setMovieRunningTime(128);
		//영화 포스터 이미지 인터넷 주소(네이버 기준)
		mv_list.add(movie1);

		//2. 영화 시동
		MovieInfoVO movie2 = new MovieInfoVO();
		movie2.setMovieId(2);
		movie2.setMovieName("시동");
		movie2.setMovieInfo("학교도 싫고 집도 싫고 공부는 더더욱 싫다며\n"
				+ "'엄마'(염정아)에게 1일 1강스파이크를 버는 반항아 '택일'(박정민).\n"
				+ " 절친 '상필'(정해인)이 빨리 돈을 벌고 싶다며 사회로 뛰어들 때,\n"
				+ "무작정 집을 뛰쳐나간 '택일'은\n"
				+ "우연히 찾은 장품반점에서 남다른 포스의 주방장 '거석이형'(마동석)을 만나게 된다.\n"
				+ "강렬한 첫 인사를 나누자마자 인생 최대 적수가 된 '거석이형'과 '택일'.\n"
				+ "세상 무서울 것 없던 '택일'은 장품반점에서 상상도 못한 이들을 만나\n"
				+ "진짜 세상을 맛보게 되는데?");
		movie2.setMovieLimitAge(15);
		try {
			movie2.setMovieOpenday(dateform.parse("2019-12-18"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			movie2.setMovieCloseday(dateform.parse("2019-01-18"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		movie2.setMovieRunningTime(102);
		mv_list.add(movie2);

		//3. 겨울왕국 2
		MovieInfoVO movie3 = new MovieInfoVO();
		movie3.setMovieId(3);
		movie3.setMovieName("겨울 왕국 2");
		movie3.setMovieInfo("내 마법의 힘은 어디서 왔을까?"
				+ "나를 부르는 저 목소리는 누구지?"
				+ "어느 날 부턴가 의문의 목소리가 엘사를 부르고, 평화로운 아렌델 왕국을 위협한다.\n"
				+ "트롤은 모든 것은 과거에서 시작되었음을 알려주며 엘사의 힘의 비밀과 진실을 찾아 떠나야한다고 조언한다.\n"
				+ "위험에 빠진 아렌델 왕국을 구해야만 하는 엘사와 안나는 숨겨진 과거의 진실을 찾아크리스토프, \n"
				+ "올라프 그리고 스벤과 함께 위험천만한 놀라운 모험을 떠나게 된다.\n"
				+ "자신의 힘을 두려워했던 엘사는 이제 이 모험을 헤쳐나가기에 자신의 힘이 충분하다고 믿어야만 하는데…\n"
				+ " 두려움을 깨고 새로운 운명을 만나다!");
		movie3.setMovieLimitAge(0);	//전체 관람가는 0로 입력했습니다.
		try {
			movie3.setMovieOpenday(dateform.parse("2019-11-21"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			movie3.setMovieCloseday(dateform.parse("2019-01-21"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		movie3.setMovieRunningTime(103);
		mv_list.add(movie3);
		
		//4. 신비아파트 극장판 하늘도깨비 대 요르문간드
		MovieInfoVO movie4 = new MovieInfoVO();
		movie4.setMovieId(4);
		movie4.setMovieName("신비아파트 극장판 하늘도깨비 대 요르문간드");
		movie4.setMovieInfo("겨울방학을 맞아 가족여행을 떠난 ‘하리’와 ‘두리’ 남매는 \n "
				+ "비행기 날개에 쓰러진 하늘도깨비 ‘주비’를 발견하고 ‘신비’와 ‘금비’를 소환한다.\n"
				+ "‘주비’를 구해준 순간, 정체를 알 수 없는 ‘스큐트’들의 공격이 시작되고,\n"
				+ "깊은 바닷속 관에서 부활한 전설의 괴수 ‘요르문간드’는 비행기를 집어 삼키려 한다.\n"
				+ "한편 창공의 퇴마사로 선택된 ‘강림’이 친구들을 구하기 위해 합류하지만\n"
				+ "세상을 파괴하려는 ‘요르문간드’는 하늘도깨비들의 왕국까지 거세게 공격하고\n"
				+ "‘하리’와 친구들의 피할 수 없는 하늘 위 모험이 시작되는데...");
		movie4.setMovieLimitAge(0);
		try {
			movie4.setMovieOpenday(dateform.parse("2019-12-19"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			movie4.setMovieCloseday(dateform.parse("2019-01-19"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		movie4.setMovieRunningTime(97);
		mv_list.add(movie4);

		//5. 포드 V 페라리
		MovieInfoVO movie5 = new MovieInfoVO();
		movie5.setMovieId(5);
		movie5.setMovieName("포드 V 페라리");
		movie5.setMovieInfo("자존심을 건 대결의 시작!\n"
				+ "1960년대, 매출 감소에 빠진 ‘포드’는 판매 활로를 찾기 위해\n"
				+ "스포츠카 레이스를 장악한 절대적 1위 ‘페라리’와의 인수 합병을 추진한다.\n"
				+ "막대한 자금력에도 불구, 계약에 실패하고 엔초 페라리로부터 모욕까지 당한 헨리 포드 2세는\n"
				+ "르망 24시간 레이스에서 페라리를 박살 낼 차를 만들 것을 지시한다.\n\n"
				+ "불가능을 즐기는 두 남자를 주목하라!\n\n"
				+ "세계 3대 자동차 레이싱 대회이자 ‘지옥의 레이스’로 불리는 르망 24시간 레이스.\n"
				+ "출전 경험조차 없는 ‘포드’는 대회 6연패를 차지한 ‘페라리’에 대항하기 위해\n"
				+ "르망 레이스 우승자 출신 자동차 디자이너 ‘캐롤 셸비’(맷 데이먼)를 고용하고,\n"
				+ "그는 누구와도 타협하지 않지만 열정과 실력만큼은 최고인\n"
				+ "레이서 ‘켄 마일스’(크리스찬 베일)를 자신의 파트너로 영입한다.\n\n"
				+ "포드의 경영진은 제 멋대로인 ‘켄 마일스’를 눈엣가시처럼 여기며\n"
				+ "자신들의 입맛에 맞춘 레이스를 펼치기를 강요하지만\n"
				+ "두 사람은 어떤 간섭에도 굴하지 않고 불가능을 뛰어넘기 위한 질주를 시작하는데…\n\n"
				+ "그 어떤 각본보다 놀라운 실화가 펼쳐진다!");
		movie5.setMovieLimitAge(12);
		try {
			movie5.setMovieOpenday(dateform.parse("2019-12-04"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			movie5.setMovieCloseday(dateform.parse("2019-01-04"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		movie5.setMovieRunningTime(152);
		mv_list.add(movie5);
		
	}
	
	/**
 	 * @author 정대석
 	 * @brief int 타입으로 스크린 id 및 스크린 넘버 지정,  2차원 배열을 통한 스크린 정보  DB화
 	 */
	public ArrayList<ScreenVO> screenlist = new ArrayList<>();	
	
	{
		ScreenVO screen1 = new ScreenVO();
		screen1.setScreenId(1);  //스크린 숫자는 7관까지
		screen1.setScreenName("제 1상영관"); //스크린 영화관 이름(1상영관)
		screenlist.add(screen1);
		
		ScreenVO screen2 = new ScreenVO();
		screen2.setScreenId(2);  
		screen2.setScreenName("제 2상영관"); //스크린 영화관 이름(2상영관)
		screenlist.add(screen2);
		
		ScreenVO screen3 = new ScreenVO();
		screen3.setScreenId(3);  
		screen3.setScreenName("제 3상영관"); //스크린 영화관 이름(3상영관)
		screenlist.add(screen3);
		
	}
	
	/**
 	 * @author 구한나
 	 * @brief 
 	 */
	public ArrayList<MovieScheduleVO> mSchlist = new ArrayList<>();
	
	{
		MovieScheduleVO msd1 = new MovieScheduleVO();
		msd1.setmScheduleId(1);
		msd1.setmScheduleTime("9:00");
		msd1.setMovieId(1);
		msd1.setScreenId(1);
		mSchlist.add(msd1);
		
		MovieScheduleVO msd2 = new MovieScheduleVO();
		msd2.setmScheduleId(2);
		msd2.setmScheduleTime("12:00");
		msd2.setMovieId(1);
		msd2.setScreenId(1);
		mSchlist.add(msd2);
		
		MovieScheduleVO msd3 = new MovieScheduleVO();
		msd3.setmScheduleId(3);
		msd3.setmScheduleTime("15:00");
		msd3.setMovieId(1);
		msd3.setScreenId(1);
		mSchlist.add(msd3);
		
		MovieScheduleVO msd4 = new MovieScheduleVO();
		msd4.setmScheduleId(4);
		msd4.setmScheduleTime("18:00");
		msd4.setMovieId(4);
		msd4.setScreenId(1);
		mSchlist.add(msd4);
		
		MovieScheduleVO msd5 = new MovieScheduleVO();
		msd5.setmScheduleId(5);
		msd5.setmScheduleTime("21:00");
		msd5.setMovieId(5);
		msd5.setScreenId(1);
		mSchlist.add(msd5);
		
		MovieScheduleVO msd6 = new MovieScheduleVO();
		msd6.setmScheduleId(6);
		msd6.setmScheduleTime("09:00");
		msd6.setMovieId(3);
		msd6.setScreenId(2);
		mSchlist.add(msd6);
		
		MovieScheduleVO msd7 = new MovieScheduleVO();
		msd7.setmScheduleId(7);
		msd7.setmScheduleTime("12:00");
		msd7.setMovieId(4);
		msd7.setScreenId(2);
		mSchlist.add(msd7);
		
		MovieScheduleVO msd8 = new MovieScheduleVO();
		msd8.setmScheduleId(8);
		msd8.setmScheduleTime("15:00");
		msd8.setMovieId(5);
		msd8.setScreenId(2);
		mSchlist.add(msd8);
		
		MovieScheduleVO msd9 = new MovieScheduleVO();
		msd9.setmScheduleId(9);
		msd9.setmScheduleTime("18:00");
		msd9.setMovieId(1);
		msd9.setScreenId(2);
		mSchlist.add(msd9);
		
		MovieScheduleVO msd10 = new MovieScheduleVO();
		msd10.setmScheduleId(10);
		msd10.setmScheduleTime("21:00");
		msd10.setMovieId(2);
		msd10.setScreenId(2);
		mSchlist.add(msd10);
		
		MovieScheduleVO msd11 = new MovieScheduleVO();
		msd11.setmScheduleId(11);
		msd11.setmScheduleTime("09:00");
		msd11.setMovieId(5);
		msd11.setScreenId(3);
		mSchlist.add(msd11);
		
		MovieScheduleVO msd12 = new MovieScheduleVO();
		msd12.setmScheduleId(12);
		msd12.setmScheduleTime("12:00");
		msd12.setMovieId(3);
		msd12.setScreenId(3);
		mSchlist.add(msd12);
		
		MovieScheduleVO msd13 = new MovieScheduleVO();
		msd13.setmScheduleId(13);
		msd13.setmScheduleTime("15:00");
		msd13.setMovieId(2);
		msd13.setScreenId(3);
		mSchlist.add(msd13);
		
		MovieScheduleVO msd14 = new MovieScheduleVO();
		msd14.setmScheduleId(14);
		msd14.setmScheduleTime("18:00");
		msd14.setMovieId(4);
		msd14.setScreenId(3);
		mSchlist.add(msd14);
		
		MovieScheduleVO msd15 = new MovieScheduleVO();
		msd15.setmScheduleId(15);
		msd15.setmScheduleTime("21:00");
		msd15.setMovieId(1);
		msd15.setScreenId(3);
		mSchlist.add(msd15);
	}

	public ArrayList<PayVO> payList = new ArrayList<>();
	
	{	
		PayVO pay = new PayVO();
		pay.setPayId(1);
		pay.setPayWay("현금");
		pay.setPayDate(today);
		pay.setPayInfo("구매");
		pay.setmScheduleId(1);
		pay.setUserId("admin");
		payList.add(pay);
	}
	
	public ArrayList<Screen_seatVO> seatlist = new ArrayList<>();
	{
		int num = 0;
		int col = 0;
		for(int i = 1; i <= screenlist.size(); i++) {
			for(int j = 0; j < 5; j ++) {
				if(i == 1) {
					col = 7;
				} else if (i == 2) {
					col = 8;
				} else if (i == 3){
					col = 9;
				}
				for(int k = 1; k <= col; k++) {
					Screen_seatVO seat = new Screen_seatVO();
					num++;
					seat.setSeatid(num);
					seat.setScreenId(i);
					seat.setSeatNum(k);
					seat.setBlankSeat(0);
					switch(j) {
					case 0:
						seat.setSeatLevel(1);
						seat.setSeatPrice(8000);
						seat.setSeatRownumber("A");
						break;
					case 1:
						seat.setSeatLevel(1);
						seat.setSeatPrice(8000);
						seat.setSeatRownumber("B");
						break;
					case 2:
						seat.setSeatLevel(2);
						seat.setSeatPrice(10000);
						seat.setSeatRownumber("C");
						break;
					case 3:
						seat.setSeatLevel(2);
						seat.setSeatPrice(10000);
						seat.setSeatRownumber("D");
						break;
					case 4:
						seat.setSeatLevel(3);
						seat.setSeatPrice(12000);
						seat.setSeatRownumber("E");
						break;	
					}
					seatlist.add(seat);
				}
			}
		}
	}
	
	public ArrayList<PayVO> receipt = new ArrayList<>();
	{	
		
	}
	
	
}
