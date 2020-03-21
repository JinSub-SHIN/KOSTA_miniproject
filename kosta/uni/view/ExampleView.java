package kosta.uni.view;

import java.util.Scanner;

public class ExampleView {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		boolean result = true;
		
		while (result) {
			System.out.println("학번입력(숫자8자리) > :");
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
				System.out.println("학번은 숫자만 가능합니다");
				return true;
			}
			return false;
		} else {

			System.out.println("학번은 8자리입니다");
			return true;
		}

	}

}
