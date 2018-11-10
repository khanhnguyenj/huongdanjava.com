package com.huongdanjava.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMExample {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File f = new File("students.xml");

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder buider = factory.newDocumentBuilder();
		Document doc = buider.parse(f);

		Element students = doc.getDocumentElement();

		NodeList studentList = students.getElementsByTagName("student");
		for (int i = 0; i < studentList.getLength(); i++) {
			Node node = studentList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element student = (Element) node;

				System.out.println("n0: " + student.getAttribute("n0"));
				System.out.println("name: " + student.getElementsByTagName("name").item(0).getTextContent());
				System.out.println("code: " + student.getElementsByTagName("code").item(0).getTextContent());
				System.out.println("age: " + student.getElementsByTagName("age").item(0).getTextContent());

				System.out.println("\n");
			}
		}
	}
}
