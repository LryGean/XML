package oo;

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
		
		public ArrayList<Student> getStus() {
			return this.stus;
		}
		
		@Override
		public void startDocument() throws SAXException {
			System.out.println("�ĵ���ʼ����");
		}

		@Override
		public void endDocument() throws SAXException {
			System.out.println("�ĵ��������\n");
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			System.out.println("Ԫ�ؿ�ʼ��" + qName);
			if (qName.equals("student")) {
				stuFlag = true;
				s = new Student();
				//��ID����
				s.setId(attributes.getValue("ID"));
				s.setSex(attributes.getValue("sex"));
			}
			if (qName.equals("name")) {
				nameFlag = true;
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
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			String content = new String(ch, start, length);
			System.out.println("�ı���" + content);
			
			if (nameFlag) {
				s.setName(content);
			}
		}
}
