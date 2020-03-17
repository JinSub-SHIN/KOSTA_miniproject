package kosta.uni.vo;

import java.util.List;

public class Professor {
	private int Professor_id;
	private String name;
	private String pwd;
	private Major major;
	private List<ProfessorSubject> subjects;

	public Professor() {
		super();
	}

	public Professor(int professor_id, String name, String pwd, Major major, List<ProfessorSubject> subjects) {
		super();
		Professor_id = professor_id;
		this.name = name;
		this.pwd = pwd;
		this.major = major;
		this.subjects = subjects;
	}

	public int getProfessor_id() {
		return Professor_id;
	}

	public void setProfessor_id(int professor_id) {
		Professor_id = professor_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public List<ProfessorSubject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<ProfessorSubject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Professor [Professor_id=" + Professor_id + ", name=" + name + ", pwd=" + pwd + ", major=" + major
				+ ", subjects=" + subjects + "]";
	}

}
