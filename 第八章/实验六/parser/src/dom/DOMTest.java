package dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class DOMTest {
	public static void main(String[] args){
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance(); //获取工厂实例
		try {
			DocumentBuilder builder = fac.newDocumentBuilder();            //获取解析器
			Document doc = builder.parse(new File("student.xml"));         //解析文件
			System.out.println("<?xml version=\"1.0\" encoding=\"" + doc.getXmlEncoding() + "\"?>");
			System.out.println(doc.getNodeName() + ":" + doc.getNodeValue());
			Element root = doc.getDocumentElement();                       //获取根元素
			System.out.println("root name:" + root.getNodeName());
			System.out.println(root.getNodeValue());
		}catch(ParserConfigurationException e) {
			e.printStackTrace();
		}catch(SAXException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
