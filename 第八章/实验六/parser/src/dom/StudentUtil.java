package dom;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class StudentUtil {
	//用于学生学号查找学生姓名
	public String getStuName(String id) {
		String name = null;
		DOMTool tool = new DOMTool();
		Document d = tool.parse(new File("student.xml"));
		Element root = d.getDocumentElement();
		NodeList nl = root.getElementsByTagName("student");
		for(int i = 0;i<nl.getLength();i++) {
			Element e = (Element)nl.item(i);
			if(e.getAttribute("ID").equals(id)) {
				name = e.getElementsByTagName("name").item(0).getTextContent();
			}
		}
		return name;
	}
	
	public String getStuID(String id) {
		DOMTool tool = new DOMTool();
		Document d = tool.parse(new File("student.xml"));
		Element root = d.getDocumentElement();
		NodeList nl = root.getElementsByTagName("student");
		for(int i = 0;i<nl.getLength();i++) {
			Element e = (Element)nl.item(i);
			if(e.getAttribute("ID").equals(id)) {
				id = e.getAttribute("ID");
			}
		}
		return id;
	}
	
	
	public String getStuSex(String id) {
		String sex = null;
		DOMTool tool = new DOMTool();
		Document d = tool.parse(new File("student.xml"));
		Element root = d.getDocumentElement();
		NodeList nl = root.getElementsByTagName("student");
		for(int i = 0;i<nl.getLength();i++) {
			Element e = (Element)nl.item(i);
			if(e.getAttribute("ID").equals(id)) {
				sex = e.getElementsByTagName("sex").item(0).getTextContent();
			}
		}
		return sex;
	}
	
	
	public Student getStu(String id) {
		Student s = new Student();
		DOMTool tool = new DOMTool();
		Document d = tool.parse(new File("student.xml"));
		NodeList nl = d.getElementsByTagName("student");
		for(int i = 0;i<nl.getLength();i++) {
			Element e = (Element)nl.item(i);
			if(e.getAttribute("ID").equals(id)) {
				s.setId(id);
				s.setName(e.getElementsByTagName("name").item(0).getTextContent());
				s.setSex(e.getElementsByTagName("sex").item(0).getTextContent());
				s.setBirthday(e.getElementsByTagName("birthday").item(0).getTextContent());
				s.setScore(Integer.parseInt(e.getElementsByTagName("score").item(0).getTextContent()));
			}
		}
		return s;
	}
	
}
