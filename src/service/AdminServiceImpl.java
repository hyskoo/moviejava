package service;


import dao.AdminDao;
import dao.AdminDaoImpl;
import dao.MovieDao;
import dao.MovieDaoImpl;


public class AdminServiceImpl implements AdminService{

	private static AdminServiceImpl instance;

	private AdminServiceImpl(){}

	public static AdminService getInstance() {
		if (instance == null) {
			instance = new AdminServiceImpl();
		}
		return instance;
	}

	AdminDao adminDao = AdminDaoImpl.getInstance();
	MovieDao movieDao = MovieDaoImpl.getInstance();




	@Override
	public void adminPage() {
		System.out.println("관리자 모드로 진입했습니다. "); 
		adminDao.modifyMovieInfo();
	}
}
