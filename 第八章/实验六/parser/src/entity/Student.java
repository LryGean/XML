package entity;

//封装学生的实体类Student，包括学号、姓名和性别
public class Student {
	
	private String id;
	private String name;
	private String sex;
	
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
	
	//将Student对象转换为文本描述
	public String toString(){
		return "This is a student:\n id=" + this.getId() +"\n" 
				+ "name=" + this.getName() + "\n" + "sex=" + this.getSex();
	}
}
