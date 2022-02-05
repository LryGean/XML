package dom;


import entity.Student;

public class Test2 {
	public static void main(String[] args) {
		StudentUtil st = new StudentUtil();
		dom.Student s = st.getStu("105");
		if (s != null) {
			System.out.println(s);
		} else {
			System.out.println("查无此人");
		}
	}
}
