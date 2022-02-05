package dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DOMUtil {
	public static Document parse(File file){
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
	
	//生成空白文档节点
	public static Document newDocument(){
		Document doc = null;
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = fac.newDocumentBuilder();
			doc = builder.newDocument();
		} catch (ParserConfigurationException e){
			e.printStackTrace();
		}

		return doc;
	}
	
	//保存成文件
	public static void save(Node node,File file) {
		TransformerFactory tfac = TransformerFactory.newInstance();
		try {
			Transformer tt = tfac.newTransformer();
			DOMSource source = new DOMSource(node);
			StreamResult result = new StreamResult(file);
			tt.transform(source,result);
		} catch (TransformerConfigurationException e){
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
