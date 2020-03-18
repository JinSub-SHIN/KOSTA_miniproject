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
		
		SuccessView.successMessage("�α��α�!");
		
		}catch(NotFoundException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	public void showPersonalInfo(int id) {
		
		try {
			Student st = StudentService.getInstance().showPersonalInfo(id);
			SuccessView.successMessage("��ȸ�Ͻ�" +id+"�� ���� �������~");
			SuccessView.successMessage(st.toString());
		} catch (NotFoundException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public void changePwd(int id, String pwd) {
		try {
			StudentService.getInstance().changePwd(id, pwd);
			SuccessView.successMessage("��� ����̴ٱ�~");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public void resister(int id, String pwd) {
		try {
			StudentService.getInstance().resister(id, pwd);
			SuccessView.successMessage("ȸ�� ���Ե̴ٱ�~");
		} catch (Exception e) {			
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
}
