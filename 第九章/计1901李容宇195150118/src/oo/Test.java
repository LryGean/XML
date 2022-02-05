package oo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import entity.Student;

public class Test {
	
	//将指定学生对象转换为指定格式文档节点
	public Document transform(Student s) {
		Document doc = SAXDOM.newDocument();
		Element root = doc.createElement("学生");
		doc.appendChild(root);
		
		Element nameEle = doc.createElement("姓名");
		Text nameTxt = doc.createTextNode(s.getName());
		nameEle.appendChild(nameTxt);
		
		Attr idAtt = doc.createAttribute("学号");
		idAtt.setNodeValue(s.getId());
		nameEle.setAttributeNode(idAtt);
		
		Attr sex = doc.createAttribute("性别");
		sex.setNodeValue(s.getSex());
		nameEle.setAttributeNode(sex);
		
		root.appendChild(nameEle);
		return doc;
	}
	
	//将指定学生对象集合转换成指定格式文档节点
	public static Document transform(ArrayList<Student> a) {
		Document doc = SAXDOM.newDocument();
		Element root = doc.createElement("学生");
		doc.appendChild(root);
		
		for(int i = 0;i<a.size();i++ ) {
			Student s = a.get(i);
			Element nameEle = doc.createElement("姓名");
			
			Text nameTxt = doc.createTextNode(s.getName());
			nameEle.appendChild(nameTxt);
			
			Attr idAtt = doc.createAttribute("学号");
			idAtt.setNodeValue(s.getId());
			nameEle.setAttributeNode(idAtt);
			
			Attr sex = doc.createAttribute("性别");
			sex.setNodeValue(s.getSex());
			nameEle.setAttributeNode(sex);
			
			root.appendChild(nameEle);
		}
		return doc;
	}
	//保存为文件 
	public static void save(Node node,File file) {
		DOMUtil.save(node,file);
	}

	public static void main(String args[]) {
		try {
			//解析器
			XMLReader reader = XMLReaderFactory.createXMLReader();
			//处理器
			MyHandler handler = new MyHandler();
			
			//文件
			File file = new File("stu.xml");
			InputSource source = new InputSource(new FileInputStream(file));
			
			//解析
			reader.setContentHandler(handler); 		//注册
			reader.parse(source);
			
			ArrayList<Student> al = handler.getStus();
			
			Document d = transform(al);
			save(d, new File("c.xml"));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
