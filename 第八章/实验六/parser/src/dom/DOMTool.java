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
	//���ڽ���ָ���ļ�ΪDocument����ķ���
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
	
	//�������ָ���ڵ������
	public void printNode(Node node) {
		//�������Document�ڵ�
		if (node.getNodeType() == Node.DOCUMENT_NODE) {
			Document document = (Document)node;
			NodeList nl = document.getChildNodes();
			for (int i =0; i < nl.getLength();i++) {
				Node child = nl.item(i);
				printNode(child); //�ݹ����
			}
		}
	
		//�����������ָ��
		if (node.getNodeType() == Node.PROCESSING_INSTRUCTION_NODE) {
			System.out.println("����ָ� " + node);
		}
		
		//��������ı�����
		if (node.getNodeType() == Node.TEXT_NODE) {
			Text t = (Text)node;
			System.out.println("�ı��� " + t.getTextContent());
		}
		
		//�������ע��
		if (node.getNodeType() == Node.TEXT_NODE) {
			Text t = (Text)node;
			System.out.println("ע�ͣ� " + t.getTextContent());
		}
		
		//�������Ԫ�ؽڵ�
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element child = (Element)node;
			//����������
			System.out.print("<" + child.getTagName());
			//��������
			NamedNodeMap attMap = child.getAttributes();
			for (int i = 0;i < attMap.getLength();i++){
				Attr a = (Attr)attMap.item(i);
				printNode(a);
			}
			System.out.print(">");
			//������Ԫ��
			NodeList nl = child.getChildNodes();
			for (int i = 0;i < nl.getLength();i++){
				Node eChild = nl.item(i);
				printNode(eChild);   //�ݹ����
			}
			System.out.println("</" + child.getTagName() + ">");
		}
		
		//�����������
		if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
			Attr att = (Attr)node;
			System.out.println("���ԣ� " + att.getName() + "=" + att.getValue());
		}
	}
}
