package sax;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import entity.Student;

public class SAXTest {
	
	public static void main(String[] args) {
		try {
			//������
			XMLReader reader = XMLReaderFactory.createXMLReader();
			
			//������
			MyHandler handler = new MyHandler();
			
			//�ļ�
			File file = new File("student.xml");
			InputSource source = new InputSource(new FileInputStream(file));
			
			//����
			reader.setContentHandler(handler);    //ע��
			reader.parse(source);
			
			ArrayList<Student> al = handler.getStus();
			for(Student s : al) {
				System.out.println(s);
			}
			
		} catch (SAXException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
