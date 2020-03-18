package kosta.uni.controller;

import kosta.uni.exception.NotFoundException;
import kosta.uni.service.StudentService;
import kosta.uni.session.Session;
import kosta.uni.session.SessionSet;
import kosta.uni.view.FailView;
import kosta.uni.view.SuccessView;
import kosta.uni.vo.Student;

public class StudentController {

	public void login(int id, String pwd) {
		
		try {
		Student st = StudentService.getInstance().login(id, pwd);
		SessionSet ss = SessionSet.getInstance();
		Session session = new Session();
		session.setSessionId(id);
		session.setAttribute("major", st.getMajor());
		ss.add(session);
		
		SuccessView.successMessage("로그인굳!");
		
		}catch(NotFoundException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	public void showPersonalInfo(int id) {
		
		try {
			Student st = StudentService.getInstance().showPersonalInfo(id);
			SuccessView.successMessage("조회하신" +id+"에 대한 정보라규~");
			SuccessView.successMessage(st.toString());
		} catch (NotFoundException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public void changePwd(int id, String pwd) {
		try {
			StudentService.getInstance().changePwd(id, pwd);
			SuccessView.successMessage("비번 번경됫다규~");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public void resister(int id, String pwd) {
		try {
			StudentService.getInstance().resister(id, pwd);
			SuccessView.successMessage("회원 가입됫다규~");
		} catch (Exception e) {			
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
}
