package com.revature;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JaxP {

	/*
	 * The Java API for XML processing allows us to process an XML file on the Java
	 * side. This means that we can grab information from an XML file on the Java
	 * and manipulate the XML using this API.
	 */

	/*
	 * In order to parse our XML, we'll need a document builder.
	 */
	public static void main(String[] args) {
		try {
			DocumentBuilder parser = DocumentBuilderFactory
					.newInstance()
					.newDocumentBuilder();
			
			/*
			 * We'll also need an object representation of the XML document itself.
			 */
			
			Document xmlFile = parser.parse(new File("pom.xml"));
			
			/*
			 * Let's try to access some of the tags in this XML file and their inner
			 * text.
			 */
			
			/*
			 * The getTextContent in this case will take the text context from each
			 * of the subnodes, but only from the first subnode of each type.
			 */
//			System.out.println(xmlFile.getFirstChild().getTextContent());
			System.out.println(xmlFile.getFirstChild().getNodeName());
			
			NodeList nodies = xmlFile.getElementsByTagName("properties");
			System.out.println(nodies.item(0));
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
