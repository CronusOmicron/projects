package xmlParser;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class xmlParse {
	private File file;
	public void DefaultParser(File file) throws ParserConfigurationException, SAXException, IOException
	{
		this.file = file;
		
		
		FileInputStream fileIS = new FileInputStream(file.getAbsolutePath());
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document xmlDocument = builder.parse(fileIS);
		XPath xPath = XPathFactory.newInstance().newXPath();
		String expression = ""
		
		
		
		
	}

}
