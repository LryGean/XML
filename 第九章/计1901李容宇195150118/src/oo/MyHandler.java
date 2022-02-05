package oo;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import entity.Student;

//自定义的事件处理器类：只负责获取student元素的属性ID和子元素name、sex
public class MyHandler extends DefaultHandler {
	//用于保存所有student对于的数据内容，每一个用 Student封装
		private ArrayList<Student> stus = new ArrayList<Student>();
		Student s = null;	//用于保存每一个student内容
		boolean stuFlag = false;
		boolean nameFlag = false;
		
		public ArrayList<Student> getStus() {
			return this.stus;
		}
		
		@Override
		public void startDocument() throws SAXException {
			System.out.println("文档开始解析");
		}

		@Override
		public void endDocument() throws SAXException {
			System.out.println("文档解析完成\n");
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			System.out.println("元素开始：" + qName);
			if (qName.equals("student")) {
				stuFlag = true;
				s = new Student();
				//找ID属性
				s.setId(attributes.getValue("ID"));
				s.setSex(attributes.getValue("sex"));
			}
			if (qName.equals("name")) {
				nameFlag = true;
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			System.out.println("元素结束：" + qName);
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
			System.out.println("文本：" + content);
			
			if (nameFlag) {
				s.setName(content);
			}
		}
}
