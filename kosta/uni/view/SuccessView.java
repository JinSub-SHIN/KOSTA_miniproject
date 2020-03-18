package kosta.uni.view;

import java.util.List;

import kosta.uni.vo.CompleteSubject;

public class SuccessView {
	public static void successMessage(String message) {
		System.out.println(message);
	}
	
	public static void grademessage(List<CompleteSubject> list) {
		
		 String name = list.get(0).getStudent().getName();
		 int ac = list.get(0).getStudent().getAccumulated_grade();
		 
		 int a = 11;
		 int isum = 0;
		 String str = "";
		 Double dsum = 0.0;
		
		System.out.println("================================================");
		System.out.println("★☆★☆★☆★"+name+"학생성적표☆★☆★☆★☆★☆");
		System.out.println("================================================");
		for(CompleteSubject cs : list) {
			String subject_name = cs.getSubject().getSubject_name();
			String grade = cs.getGrade().getGrade_point();
			Double dou = cs.getGrade().getScore();
			int cre = cs.getSubject().getCredit();
			if(subject_name.length() !=a) {
				 int ab = a-(subject_name.length());
				 for(int t=0 ; t<=ab ; t++) {
					 str += "　";
				 }
			}
			dsum = dsum+dou;
			isum = isum+cre;
			String show = "    ["+subject_name + "]"+str+"            "+grade;
			System.out.println("------------------------------------------------");
			System.out.println(show);
			str = "";
		}
		Double avg = dsum/list.size();
		System.out.println("================================================");
		System.out.println("※신청학점:["+isum+"] 인정학점:["+ac+"] 총점평균:["+avg+"]※");
	}
}
