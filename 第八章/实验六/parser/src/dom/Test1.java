package dom;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class Test1 {
	public static void main(String[] args) {
		StudentUtil st = new StudentUtil();
		Student s = st.getStu("105");
		if (s != null) {
			System.out.println(s);
		} else {
			System.out.println("查无此人");
		}
	}
}
