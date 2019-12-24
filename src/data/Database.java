package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import vo.MovieInfoVO;
import vo.ScreenVO;
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
		try {
			user.setUserDate(dateform.parse("2019-01-20"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userlist.add(user);
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

		//6. 쥬만지: 넥스트 레벨
		MovieInfoVO movie6 = new MovieInfoVO();
		movie6.setMovieId(6);
		movie6.setMovieName("쥬만지: 넥스트 레벨");
		movie6.setMovieInfo("진화된 게임, 주어진 목숨은 3개! 사라진 친구를 찾아 반드시 탈출하라!\n"
				+ "쥬만지 게임으로부터 가까스로 탈출해 평화로운 일상을 보내던 스펜서와 친구들.\n"
				+ " 어느 날, 스펜서는 망가진 쥬만지 게임 속으로 사라지고\n"
				+ " 마사와 베서니, 프리지 역시 그를 찾기 위해 다시 들어가기로 결심한다.\n"
				+ " 그리고 우연히 게임에 합류하게 된 새로운 멤버, 스펜서의 할아버지 에디와 마일로.\n"
				+ " 위험천만한 게임 속으로 들어가게 된 이들은 정글부터 설산, 사막까지\n"
				+ " 한층 진화된 예측 불가능한 게임 속에서 현실 세계로 돌아오기 위해 목숨을 건 미션을 시작하는데......");
		movie6.setMovieLimitAge(12);
		try {
			movie6.setMovieOpenday(dateform.parse("2019-12-11"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			movie6.setMovieCloseday(dateform.parse("2019-01-11"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		movie6.setMovieRunningTime(122);
		mv_list.add(movie6);

		//7. 나이브스 아웃
		MovieInfoVO movie7 = new MovieInfoVO();
		movie7.setMovieId(7);
		movie7.setMovieName("나이브스 아웃");
		movie7.setMovieInfo("베스트셀러 미스터리 작가가 85세 생일에 숨진 채 발견된다.\n"
				+ "그의 죽음의 원인을 파헤치기 위해 경찰과 함께 탐정 브누아 블랑이 파견 되는데…");
		movie7.setMovieLimitAge(12);
		try {
			movie7.setMovieOpenday(dateform.parse("2019-12-04"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			movie7.setMovieCloseday(dateform.parse("2019-01-04"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		movie7.setMovieRunningTime(130);
		mv_list.add(movie7);

		//8. 미안해요, 리키
		MovieInfoVO movie8 = new MovieInfoVO();
		movie8.setMovieId(8);
		movie8.setMovieName("미안해요, 리키");
		movie8.setMovieInfo("넉넉하지는 않지만 누구보다 행복한 가장 리키,\n"
				+ "안정적인 생활을 꿈꾸며 택배 회사에 취직하지만\n"
				+ "생각과는 다른 일상이 전개되고, 화목했던 가족은 뜻밖의 난관에 부딪히는데..\n"
				+ "성실하게 행복을 찾고 싶었던 리키의, 우리의 이야기가 찾아온다.");
		movie8.setMovieLimitAge(12);
		try {
			movie8.setMovieOpenday(dateform.parse("2019-12-19"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			movie8.setMovieCloseday(dateform.parse("2019-01-19"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		movie8.setMovieRunningTime(101);
		mv_list.add(movie8);

		//9. 프란치스코 교황: 맨 오브 히스 워드
		MovieInfoVO movie9 = new MovieInfoVO();
		movie9.setMovieId(9);
		movie9.setMovieName("프란치스코 교황: 맨 오브 히스 워드");
		movie9.setMovieInfo("화려한 바티칸궁을 마다하고 소박한 방 한 칸을 선택한 사람\n"
				+ "고급 리무진 대신 소형 승용차에 올라 손인사를 전하는 사람\n"
				+ "축구에 열광하고 탱고를 즐기며 유머를 사랑하는 사람\n"
				+ "이웃의 작은 고민을 제 일처럼 마음 쓰고 공감하는 사람\n"
				+ "그의 이름은 프란치스코, 온 세계의 친구 교황입니다.\n"
				+ "교황이 함께한 모두의 삶 속으로 한 걸음 더 가까이!\n"
				+ "세상에서 가장 따뜻한 공감의 여정이 시작됩니다");
		movie9.setMovieLimitAge(0);
		try {
			movie9.setMovieOpenday(dateform.parse("2019-11-21"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			movie9.setMovieCloseday(dateform.parse("2019-01-21"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		movie9.setMovieRunningTime(96);
		mv_list.add(movie9);

		//10. 파비안느에 관한 진실
		MovieInfoVO movie10 = new MovieInfoVO();
		movie10.setMovieId(10);
		movie10.setMovieName("파비안느에 관한 진실");
		movie10.setMovieInfo("자신의 회고록 발간을 앞둔 전설적인 여배우 파비안느(까뜨린느 드뇌브).\n"
				+ "이를 축하하기 위해 딸 뤼미르(줄리엣 비노쉬)가\n"
				+ "남편 행크(에단 호크), 어린 딸 샤를로트와 함께 오랜만에 파비안느의 집을 찾는다.\n"
				+ "반가운 재회도 잠시, 엄마의 회고록을 읽은 뤼미르는\n"
				+ "책 속 내용이 거짓으로 가득 찼음을 알게 되는데…\n"
				+ "“엄마, 이 책에는 진실이라고는 없네요”");
		movie10.setMovieLimitAge(12);
		try {
			movie10.setMovieOpenday(dateform.parse("2019-12-05"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			movie10.setMovieCloseday(dateform.parse("2019-01-05"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		movie10.setMovieRunningTime(107);
		mv_list.add(movie10);
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
		
		ScreenVO screen4 = new ScreenVO();
		screen4.setScreenId(4);  
		screen4.setScreenName("제 4상영관"); //스크린 영화관 이름(4상영관)
		screenlist.add(screen4);
		
		ScreenVO screen5 = new ScreenVO();
		screen5.setScreenId(5);  
		screen5.setScreenName("제 5상영관"); //스크린 영화관 이름(5상영관)
		screenlist.add(screen5);
		
		ScreenVO screen6 = new ScreenVO();
		screen6.setScreenId(6);  
		screen6.setScreenName("제 6상영관"); //스크린 영화관 이름(6상영관)
		screenlist.add(screen6);
		
		ScreenVO screen7 = new ScreenVO();
		screen7.setScreenId(7);  
		screen7.setScreenName("제 7상영관"); //스크린 영화관 이름(7상영관)
		screenlist.add(screen7);
		
	}
}
