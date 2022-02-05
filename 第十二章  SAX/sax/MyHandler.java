package sax;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import entity.Student;

//�Զ�����¼��������ֻࣺ�����ȡstudentԪ�ص�����ID����Ԫ��name��sex
public class MyHandler extends DefaultHandler {
	//���ڱ�������student���ڵ��������ݣ�ÿһ���� Student��װ
	private ArrayList<Student> stus = new ArrayList<Student>();
	Student s = null;	//���ڱ���ÿһ��student����
	boolean stuFlag = false;
	boolean nameFlag = false;
	boolean sexFlag = false;
	
	public ArrayList<Student> getStus() {
		return this.stus;
	}
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("�ĵ���ʼ����");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("�ĵ��������");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("Ԫ�ؿ�ʼ��" + qName);
		if (qName.equals("student")) {
			stuFlag = true;
			s = new Student();
			//��ID����
			s.setId(attributes.getValue("ID"));
		}
		if (qName.equals("name")) {
			nameFlag = true;
		}
		if (qName.equals("sex")) {
			sexFlag = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("Ԫ�ؽ�����" + qName);
		if (qName.equals("student")) {
			stuFlag = false;
			stus.add(s);
		}
		if (qName.equals("name")) {
			nameFlag = false;
		}
		if (qName.equals("sex")) {
			sexFlag = false;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content = new String(ch, start, length);
		System.out.println("�ı���" + content);
		
		if (nameFlag) {
			s.setName(content);
		}
		
		if (sexFlag) {
			s.setSex(content);
		}
	}
	
}
