package kosta.uni.view;

import java.util.Scanner;

public class ExampleView {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		boolean result = true;
		
		while (result) {
			System.out.println("�й��Է�(����8�ڸ�) > :");
			String id = sc.next();
			if (canPassWord(id)) {
				result = true;
			} else {
				result = false;
			}

		}
		
		
	}

	public static boolean canPassWord(String id) {

		if (id.length() == 8) {
			try {
				Integer.parseInt(id);
			} catch (NumberFormatException e) {
				System.out.println("�й��� ���ڸ� �����մϴ�");
				return true;
			}
			return false;
		} else {

			System.out.println("�й��� 8�ڸ��Դϴ�");
			return true;
		}

	}

}
