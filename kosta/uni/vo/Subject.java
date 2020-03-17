package kosta.uni.vo;

public class Subject {
	private String subject_code;
	private String subject_name;
	private int credit;
	private int limit;
	private String start_time;
	private int subject_major;
	private int run_time;

	public Subject() {
		super();
	}

	public Subject(String subject_code, String subject_name, int credit, int limit, String start_time,
			int subject_major, int run_time) {
		super();
		this.subject_code = subject_code;
		this.subject_name = subject_name;
		this.credit = credit;
		this.limit = limit;
		this.start_time = start_time;
		this.subject_major = subject_major;
		this.run_time = run_time;
	}

	public String getSubject_code() {
		return subject_code;
	}

	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public int getSubject_major() {
		return subject_major;
	}

	public void setSubject_major(int subject_major) {
		this.subject_major = subject_major;
	}

	public int getRun_time() {
		return run_time;
	}

	public void setRun_time(int run_time) {
		this.run_time = run_time;
	}

	@Override
	public String toString() {
		return "Subject [subject_code=" + subject_code + ", subject_name=" + subject_name + ", credit=" + credit
				+ ", limit=" + limit + ", start_time=" + start_time + ", subject_major=" + subject_major + ", run_time="
				+ run_time + "]";
	}

}
