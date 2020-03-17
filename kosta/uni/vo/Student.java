package kosta.uni.vo;

import java.util.List;

public class Student {
	private int Student_id;
	private String name;
	private String pwd;
	private Major major;
	private int accumulated_grade;
	private int class_level;
	private List<CompleteSubject> subjects;

	public Student() {
		super();
	}

	public Student(int student_id, String name, String pwd, Major major, int accumulated_grade, int class_level,
			List<CompleteSubject> subjects) {
		super();
		Student_id = student_id;
		this.name = name;
		this.pwd = pwd;
		this.major = major;
		this.accumulated_grade = accumulated_grade;
		this.class_level = class_level;
		this.subjects = subjects;
	}

	public int getStudent_id() {
		return Student_id;
	}

	public void setStudent_id(int student_id) {
		Student_id = student_id;
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

	public int getAccumulated_grade() {
		return accumulated_grade;
	}

	public void setAccumulated_grade(int accumulated_grade) {
		this.accumulated_grade = accumulated_grade;
	}

	public int getClass_level() {
		return class_level;
	}

	public void setClass_level(int class_level) {
		this.class_level = class_level;
	}

	public List<CompleteSubject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<CompleteSubject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [Student_id=" + Student_id + ", name=" + name + ", pwd=" + pwd + ", major=" + major
				+ ", accumulated_grade=" + accumulated_grade + ", class_level=" + class_level + ", subjects=" + subjects
				+ "]";
	}

}
