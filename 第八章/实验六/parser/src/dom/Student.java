package dom;

public class Student {
	private String id;
	private String name;
	private String sex;
	private String birthday;
	private int score;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getBirthday() {
		return birthday;
	}
	
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	

	public String toString() {
		return "student:" + this.id + ";" + this.name + ";" + this.sex + ";" + this.birthday + ";" + this.score;
	}
	/*
	public Student() {
		super();
	}
	public Student(String id, String name, String sex, int score) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.score = score;
	}
	*/
	
}
