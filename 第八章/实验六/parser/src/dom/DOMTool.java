package dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class DOMTool {
	//用于解析指定文件为Document对象的方法
	public Document parse(File file){
		Document doc = null;
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = fac.newDocumentBuilder();
			doc = builder.parse(file);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	//用于输出指定节点的内容
	public void printNode(Node node) {
		//用来输出Document节点
		if (node.getNodeType() == Node.DOCUMENT_NODE) {
			Document document = (Document)node;
			NodeList nl = document.getChildNodes();
			for (int i =0; i < nl.getLength();i++) {
				Node child = nl.item(i);
				printNode(child); //递归调用
			}
		}
	
		//用于输出处理指令
		if (node.getNodeType() == Node.PROCESSING_INSTRUCTION_NODE) {
			System.out.println("处理指令： " + node);
		}
		
		//用于输出文本对象
		if (node.getNodeType() == Node.TEXT_NODE) {
			Text t = (Text)node;
			System.out.println("文本： " + t.getTextContent());
		}
		
		//用于输出注释
		if (node.getNodeType() == Node.TEXT_NODE) {
			Text t = (Text)node;
			System.out.println("注释： " + t.getTextContent());
		}
		
		//用于输出元素节点
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element child = (Element)node;
			//输出标记名称
			System.out.print("<" + child.getTagName());
			//处理属性
			NamedNodeMap attMap = child.getAttributes();
			for (int i = 0;i < attMap.getLength();i++){
				Attr a = (Attr)attMap.item(i);
				printNode(a);
			}
			System.out.print(">");
			//处理子元素
			NodeList nl = child.getChildNodes();
			for (int i = 0;i < nl.getLength();i++){
				Node eChild = nl.item(i);
				printNode(eChild);   //递归调用
			}
			System.out.println("</" + child.getTagName() + ">");
		}
		
		//用于输出属性
		if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
			Attr att = (Attr)node;
			System.out.println("属性： " + att.getName() + "=" + att.getValue());
		}
	}
}
