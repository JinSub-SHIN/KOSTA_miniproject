package kosta.uni.view;

import java.util.Scanner;

import kosta.uni.controller.ProfessorController;
import kosta.uni.session.SessionSet;

public class MenuView {
	private ProfessorController proController = ProfessorController.getInstance();
	Scanner sc = new Scanner(System.in);
	String select = null;
	
	public void menu() {
		while(!"9".equals(select)) {
			System.out.println("1. 로그인  2. 회원가입  9. 종료");
			System.out.print("입력 >> ");
			select = sc.nextLine();
			switch(select) {
			case "1" : 
				login();
				break;
				
			case "2" : 
				resister();
				break;
			case "9" :
				break;
			default :
				break;
			}
		}
	}
	
	public void login() {
		System.out.println("==로그인==");
		System.out.println("1. 학생 로그인  2. 교수 로그인  9. 나가기");
		System.out.print("입력 >> ");
		switch(sc.nextLine()) {
		case "1" :
			stuLogin();
			break;
		case "2" : 
			proLogin();
			break;
		case "9" : 
			System.out.println("나가기");
			break;
		}
	}
	
	public void resister() {
		System.out.println("==회원가입==");
		System.out.println("1. 교수  2. 학생  9. 나가기");
		System.out.print("입력 >> ");
		switch(sc.nextLine()){
		case "1" :
			stuResister();
			break;
		case "2" : 
			proResister();
			break;
		case "9" : 
			System.out.println("나가기");
			break;
		}
	}
	
	public void stuLogin() {
		System.out.println("==학생모드 로그인==");
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("Password : ");
		String pwd = sc.nextLine();
		//기달
	}
	
	public void proLogin() {
		System.out.println("==교수모드 로그인==");
		System.out.print("ID : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("Password : ");
		String pwd = sc.nextLine();
		
		proController.login(id,pwd);
		SessionSet ss = SessionSet.getInstance();
		if(ss.get(id) == null)
			return;
		while(true) {
			System.out.println("1. 성적부여");
			System.out.println("2. 맡은 강의 성적 조회");
			System.out.println("3. 맡은 강의 목록 출력");
			System.out.println("4. 강의 출석부");
			System.out.println("5. 시간표");
			System.out.println("6. 비밀번호 변경");
			System.out.println("9. 로그아웃");
			System.out.print("입력 >> ");
			switch(sc.nextLine()) {
			case "1" :
				break;
			case "2" :
				break;
			case "3" :
				
				break;
			case "4" :
				break;
			case "5" :
				break;
			case "6" :
				System.out.println("==비밀번호 변경==");
				System.out.println("현재 비밀번호를 입력하세요.");
				System.out.print("입력 >> ");
				String newpwd = sc.nextLine();
				if(pwd.equals(newpwd)) {
					System.out.println("비밀번호가 올바르지 않습니다.");
					break;
				}
				System.out.println("변경하실 비밀번호를 입력하세요.");
				System.out.println("입력 >> ");
				proController.changePwd(id, pwd);
				break;
			case "9":
				return;
			default : 
				break;
			}
		}
	}
	
		
	public void stuResister() {
		
	}
	
	public void proResister() {
		
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 진섭작성
	 */
	
	public void applyChangeSubject(String id) {
		while(true) {
			System.out.println("================할기능 입력하라규=================");
			System.out.println("===1.과목조회 2.신청 3.신청 내역 삭제 9.나가기====");
			System.out.println("================할기능 입력하라규=================");
		}
	}
	
	
	
	
	
}
