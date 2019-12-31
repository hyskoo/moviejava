package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

import vo.MovieInfoVO;
import data.Database;
import data.Except;

public class AdminDaoImpl implements AdminDao {

		
		private static AdminDaoImpl instance;
		
		private AdminDaoImpl(){}
		
		public static AdminDao getInstance(){
			if (instance == null) {
				instance = new AdminDaoImpl();
			}
			return instance;
			
		}

	Database database = Database.getInstance();
	
	Scanner scan = new Scanner(System.in);
	


	@Override
	public void modifyMovieInfo() {
		System.out.println("영화의 정보를 추가 / 수정하시겠습니까?"
				+ "\n1. 추가\t2.수정");
			//추가할지 수정할지 선택 1이면 추가모드로 2번은 수정모드로 진입
		int selectMode = Except.exceptionInt(scan.nextLine());
		
		//추가
		if(selectMode == 1){
			MovieInfoVO movie = new MovieInfoVO();
			movie.setMovieId(database.mv_list.size() + 1);
			
			System.out.println("영화 제목을 입력해주세요.");
			String movieName = Except.exceptionString(scan.nextLine());
			movie.setMovieName(movieName);
			
			System.out.println("영화 정보를 입력해주세요.");
			String movieDetail =Except.exceptionString(scan.nextLine());
			movie.setMovieInfo(movieDetail);
			
			System.out.println("영화 런닝타임을 입력해주세요. (분단위로 입력해주세요)");
			int inputMinute = Except.exceptionInt(scan.nextLine());
			movie.setMovieRunningTime(inputMinute);
			
			System.out.println("영화의 개봉일자를 입력해주세요. 예) 2019년 12월 30일 → 2019-12-30");
			String movieOpenday = Except.exceptionString(scan.nextLine());
			SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				movie.setMovieOpenday(dateform.parse(movieOpenday));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			System.out.println("영화의 나이 제한을 입력해주세요.");
			int movieLimitAge = Except.exceptionInt(scan.nextLine());
			movie.setMovieLimitAge(movieLimitAge);
			
			database.mv_list.add(movie);
		}
		
		//수정메뉴
		else if(selectMode == 2){
			
			for(int i = 0 ; i < database.mv_list.size(); i++){		//영화 list를 출력해주는 부분
				System.out.println(database.mv_list.get(i).getMovieId() + ". " + database.mv_list.get(i).getMovieName());	
			}
			System.out.println("어느 영화를 수정하시겠습니까? 영화 ID 입력해주세요 : ");
			int movieNo = Except.exceptionInt(scan.nextLine());
			System.out.println(database.mv_list.get(movieNo - 1).getMovieName()+ "의 정보를 수정하시겠습니까? (Y/N)");
			if (Except.exceptionString(scan.nextLine()).equalsIgnoreCase("y")){
				boolean flag = true;
				do{
					System.out.println("어느 정보를 수정하시겠습니까? \n"
							+ "영화 제목 : 1번 \t 영화 정보 : 2번\t 영화 나이제한 : 3번\n"
							+ "영화 개봉일자 : 4번\t 영화 런닝타임 : 5번\t 완료 : 9번");
					
					int menu = Except.exceptionInt(scan.nextLine());
					switch (menu){
					case 1:
						System.out.println("영화 제목을 입력해주세요.");
						String movieName = Except.exceptionString(scan.nextLine());

						for (int j = 0; j < database.mv_list.size(); j++) {
							if (database.mv_list.get(j).getMovieId() == movieNo) {
								database.mv_list.get(j).setMovieName(movieName);
							}
						}
						
						break;
					case 2:
						System.out.println("영화 정보를 입력해주세요.");
						String movieDetail = Except.exceptionString(scan.nextLine());
						
						for (int j = 0; j < database.mv_list.size(); j++) {
							if (database.mv_list.get(j).getMovieId() == movieNo) {
								database.mv_list.get(j).setMovieInfo(movieDetail);
							}
						}
						break;
					case 3:
						System.out.println("영화의 나이 제한을 입력해주세요.");
						int movieLimitAge = Except.exceptionInt(scan.nextLine());
						
						for (int j = 0; j < database.mv_list.size(); j++) {
							if (database.mv_list.get(j).getMovieId() == movieNo) {
								database.mv_list.get(j).setMovieLimitAge(movieLimitAge);
							}
						}
						break;
					case 4:
						System.out.println("영화의 개봉일자를 입력해주세요. 예) 2019년 12월 30일 → 2019-12-30");
						SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
						String movieOpenday = Except.exceptionString(scan.nextLine());
						
						for (int j = 0; j < database.mv_list.size(); j++) {
							if (database.mv_list.get(j).getMovieId() == movieNo) {
								try {
									database.mv_list.get(j).setMovieOpenday(dateform.parse(movieOpenday));
								} catch (ParseException e) {
									e.printStackTrace();
								}
							}
						}
						
						break;
					case 5:
						System.out.println("영화 런닝타임을 입력해주세요. (분단위로 입력해주세요)");
						int inputMinute = Except.exceptionInt(scan.nextLine());
						
						for (int j = 0; j < database.mv_list.size(); j++) {
							if (database.mv_list.get(j).getMovieId() == movieNo) {
								database.mv_list.get(j).setMovieRunningTime(inputMinute);
							}
						}
						break;
					case 9:
						flag = false;
						break;
					default:
						System.out.println("잘못 입력하셨습니다.");
					}
				}while(flag);
			}
		}	
	}
}


