package kosta.uni.vo;

public class ProfessorSubject {
	private int professor_id;
	private Subject subject;

	public ProfessorSubject() {
		super();
	}

	public ProfessorSubject(int professor_id, Subject subject) {
		super();
		this.professor_id = professor_id;
		this.subject = subject;
	}

	public int getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(int professor_id) {
		this.professor_id = professor_id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "ProfessorSubject [professor_id=" + professor_id + ", subject=" + subject + "]";
	}

}
