package dom;

import java.io.File;

import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class StudentBiz {
	
	//按照指定获取学生信息
	public Student getStuInfo(File file,String id) {
		Student s = new Student();
		Document d = DOMUtil.parse(file);
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

	//从指定文件获取所有学生
	public ArrayList<Student> getStus(File file) {
		ArrayList<Student> a = null;
		Student stu = null;
		Document doc = DOMUtil.parse(file);
		NodeList nl = doc.getElementsByTagName("student");
		
		if (nl.getLength() != 0) {
			a = new ArrayList<Student>();
		}
		
		for(int i=0;i<nl.getLength();i++){
			Element e = (Element)nl.item(i);
			stu = new Student();
			stu.setId(e.getAttribute("ID"));
			stu.setName(e.getElementsByTagName("name").item(0).getTextContent());
			a.add(stu);
		}
		return a;
	}
	
	//将指定学生对象转换为指定格式文档节点
	public Document transform(Student s) {
		Document doc = DOMUtil.newDocument();
		Element root = doc.createElement("roster");
		doc.appendChild(root);
		
		Element stuEle = doc.createElement("student");
		Element nameEle = doc.createElement("name");
		Text nameTxt = doc.createTextNode(s.getName());
		nameEle.appendChild(nameTxt);
		stuEle.appendChild(nameEle);
		
		Attr idAtt = doc.createAttribute("ID");
		idAtt.setNodeValue(s.getId());
		stuEle.setAttributeNode(idAtt);
		
		root.appendChild(stuEle);
		return doc;
	}
	
	//将指定学生对象集合转换成指定格式文档节点
	public Document transform(ArrayList<Student> a) {
		Document doc = DOMUtil.newDocument();
		Element root = doc.createElement("roster");
		doc.appendChild(root);
		
		for(int i = 0;i<a.size();i++ ) {
			Student s = a.get(i);
			Element stuEle = doc.createElement("student");
			
			Element nameEle = doc.createElement("name");
			Text nameTxt = doc.createTextNode(s.getName());
			nameEle.appendChild(nameTxt);
			stuEle.appendChild(nameEle);
			
			Attr idAtt = doc.createAttribute("ID");
			idAtt.setNodeValue(s.getId());
			stuEle.setAttributeNode(idAtt);
			
			root.appendChild(stuEle);
		}
		return doc;
	}
	
	//保存为文件 
	public void save(Node node,File file) {
		DOMUtil.save(node,file);
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		StudentBiz sbiz = new StudentBiz();
		File file = new File(scn.nextLine());
		String id = scn.nextLine();
		Student s = sbiz.getStuInfo(file,id);
		if (s != null) {
			System.out.println(s);
			Document d = sbiz.transform(s);
			sbiz.save(d, new File("a.xml"));
		} else {
			System.out.println("no student");
		}
	
		ArrayList<Student> a = sbiz.getStus(file);
		if (a != null) {
			Document d = sbiz.transform(a);
			sbiz.save(d, new File("b.xml"));
		}
		scn.close();
	}
}
