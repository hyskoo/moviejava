package dao;

public interface MovieScheduleDao {

	void getMoiveScheduleInfo(int movieNo);

	String getOneMovieInfo(int movieId, String screenMoiveId);

	int getMovieSchId(int movieId, String screenMoiveId);

}
