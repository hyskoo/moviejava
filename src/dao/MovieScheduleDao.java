package dao;

public interface MovieScheduleDao {

	void getMoiveScheduleInfo(int movieNo);

	String getOneMovieInfo(int movieId, int screenMoiveId);

	int getMovieSchId(int movieId, int screenMoiveId);

	int getScreenId(int movieId, int screenMoiveId);

}
