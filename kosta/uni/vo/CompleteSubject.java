package kosta.uni.vo;

public class CompleteSubject {
	private int student_id;
	private Subject subject;
	private Grade grade;
	private String term;

	public CompleteSubject() {
		super();
	}

	public CompleteSubject(int student_id, Subject subject, Grade grade, String term) {
		super();
		this.student_id = student_id;
		this.subject = subject;
		this.grade = grade;
		this.term = term;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return "CompleteSubject [student_id=" + student_id + ", subject=" + subject + ", grade=" + grade + ", term="
				+ term + "]";
	}

}
