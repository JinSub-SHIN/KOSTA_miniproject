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
			System.out.println("1. �α���  2. ȸ������  9. ����");
			System.out.print("�Է� >> ");
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
		System.out.println("==�α���==");
		System.out.println("1. �л� �α���  2. ���� �α���  9. ������");
		System.out.print("�Է� >> ");
		switch(sc.nextLine()) {
		case "1" :
			stuLogin();
			break;
		case "2" : 
			proLogin();
			break;
		case "9" : 
			System.out.println("������");
			break;
		}
	}
	
	public void resister() {
		System.out.println("==ȸ������==");
		System.out.println("1. ����  2. �л�  9. ������");
		System.out.print("�Է� >> ");
		switch(sc.nextLine()){
		case "1" :
			stuResister();
			break;
		case "2" : 
			proResister();
			break;
		case "9" : 
			System.out.println("������");
			break;
		}
	}
	
	public void stuLogin() {
		System.out.println("==�л���� �α���==");
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("Password : ");
		String pwd = sc.nextLine();
		//���
	}
	
	public void proLogin() {
		System.out.println("==������� �α���==");
		System.out.print("ID : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("Password : ");
		String pwd = sc.nextLine();
		
		proController.login(id,pwd);
		SessionSet ss = SessionSet.getInstance();
		if(ss.get(id) == null)
			return;
		while(true) {
			System.out.println("1. �����ο�");
			System.out.println("2. ���� ���� ���� ��ȸ");
			System.out.println("3. ���� ���� ��� ���");
			System.out.println("4. ���� �⼮��");
			System.out.println("5. �ð�ǥ");
			System.out.println("6. ��й�ȣ ����");
			System.out.println("9. �α׾ƿ�");
			System.out.print("�Է� >> ");
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
				System.out.println("==��й�ȣ ����==");
				System.out.println("���� ��й�ȣ�� �Է��ϼ���.");
				System.out.print("�Է� >> ");
				String newpwd = sc.nextLine();
				if(pwd.equals(newpwd)) {
					System.out.println("��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
					break;
				}
				System.out.println("�����Ͻ� ��й�ȣ�� �Է��ϼ���.");
				System.out.println("�Է� >> ");
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
	 * �����ۼ�
	 */
	
	public void applyChangeSubject(String id) {
		while(true) {
			System.out.println("================�ұ�� �Է��϶��=================");
			System.out.println("===1.������ȸ 2.��û 3.��û ���� ���� 9.������====");
			System.out.println("================�ұ�� �Է��϶��=================");
		}
	}
	
	
	
	
	
}
