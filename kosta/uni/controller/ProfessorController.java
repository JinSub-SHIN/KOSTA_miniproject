package kosta.uni.controller;

import kosta.uni.service.ProfessorService;
import kosta.uni.session.Session;
import kosta.uni.session.SessionSet;
import kosta.uni.view.FailView;
import kosta.uni.view.SuccessView;

public class ProfessorController {
	private static ProfessorController controller = new ProfessorController();
	private ProfessorService service = ProfessorService.getInstance();
	private ProfessorController() {}
	
	public static ProfessorController getInstance() {
		return controller;
	}
	
	public void login(int id, String pwd) {
		try {
			service.login(id, pwd);
			SessionSet ss = SessionSet.getInstance();
			Session session = new Session();
			session.setSessionId(id);
			
			ss.add(session);
			
			SuccessView.successMessage("로그인 성공!");
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	public void changePwd(int id, String pwd){
		try {
			service.changePwd(id, pwd);
			SuccessView.successMessage("비밀번호 변경 성공!");
			
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	
	public void resister(int id, String pwd){
		try {
			service.resister(id, pwd);
			SuccessView.successMessage("회원가입 성공!");
			
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

}
