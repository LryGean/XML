package entity;

//��װѧ����ʵ����Student������ѧ�š��������Ա�
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
	
	//��Student����ת��Ϊ�ı�����
	public String toString(){
		return "This is a student:\n id=" + this.getId() +"\n" 
				+ "name=" + this.getName() + "\n" + "sex=" + this.getSex();
	}
}
