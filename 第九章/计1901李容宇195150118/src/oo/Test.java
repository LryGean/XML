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
	
	//��ָ��ѧ������ת��Ϊָ����ʽ�ĵ��ڵ�
	public Document transform(Student s) {
		Document doc = SAXDOM.newDocument();
		Element root = doc.createElement("ѧ��");
		doc.appendChild(root);
		
		Element nameEle = doc.createElement("����");
		Text nameTxt = doc.createTextNode(s.getName());
		nameEle.appendChild(nameTxt);
		
		Attr idAtt = doc.createAttribute("ѧ��");
		idAtt.setNodeValue(s.getId());
		nameEle.setAttributeNode(idAtt);
		
		Attr sex = doc.createAttribute("�Ա�");
		sex.setNodeValue(s.getSex());
		nameEle.setAttributeNode(sex);
		
		root.appendChild(nameEle);
		return doc;
	}
	
	//��ָ��ѧ�����󼯺�ת����ָ����ʽ�ĵ��ڵ�
	public static Document transform(ArrayList<Student> a) {
		Document doc = SAXDOM.newDocument();
		Element root = doc.createElement("ѧ��");
		doc.appendChild(root);
		
		for(int i = 0;i<a.size();i++ ) {
			Student s = a.get(i);
			Element nameEle = doc.createElement("����");
			
			Text nameTxt = doc.createTextNode(s.getName());
			nameEle.appendChild(nameTxt);
			
			Attr idAtt = doc.createAttribute("ѧ��");
			idAtt.setNodeValue(s.getId());
			nameEle.setAttributeNode(idAtt);
			
			Attr sex = doc.createAttribute("�Ա�");
			sex.setNodeValue(s.getSex());
			nameEle.setAttributeNode(sex);
			
			root.appendChild(nameEle);
		}
		return doc;
	}
	//����Ϊ�ļ� 
	public static void save(Node node,File file) {
		DOMUtil.save(node,file);
	}

	public static void main(String args[]) {
		try {
			//������
			XMLReader reader = XMLReaderFactory.createXMLReader();
			//������
			MyHandler handler = new MyHandler();
			
			//�ļ�
			File file = new File("stu.xml");
			InputSource source = new InputSource(new FileInputStream(file));
			
			//����
			reader.setContentHandler(handler); 		//ע��
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
