package service;

import javax.servlet.ServletContext;

import dao.UserDao;
import dto.User;

public class UserService {
	private ServletContext application;
	
	public UserService(ServletContext application) {
		this.application = application;
	}
	public void join(User user) {
		
		System.out.println("회원 가입을 합니다.");
		System.out.println(user.getUserAge());
		UserDao userDao = (UserDao) application.getAttribute("userDao");
		userDao.insert(user);
	}

}
