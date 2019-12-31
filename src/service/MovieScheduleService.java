package service;

public interface MovieScheduleService {
	
	void getMovieSchedule(int movieNo); // 영화 정보(영화이름, 나이제한, 영화 상영관(이름)가져와서 보여주는 역할

	String getOneMovieInfo(int movieId, int screenMoiveId);

	int getMovieSchId(int movieId, int screenMoiveId);

	int getScreenId(int movieId, int screenMoiveId);

}
