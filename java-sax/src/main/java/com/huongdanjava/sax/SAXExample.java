package com.huongdanjava.sax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXExample {

	public static void main(String[] args) {
		try {
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();

			final List<Student> students = new ArrayList<Student>();

			DefaultHandler defaultHandler = new DefaultHandler() {
				Student student = null;

				boolean isName = false;
				boolean isCode = false;
				boolean isAge = false;

				@Override
				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException {
					if (qName.equals("student")) {
						student = new Student();
					} else if (qName.equals("name")) {
						isName = true;
					} else if (qName.equals("code")) {
						isCode = true;
					} else if (qName.equals("age")) {
						isAge = true;
					}
				}

				@Override
				public void characters(char[] ch, int start, int length) throws SAXException {
					String value = new String(ch, start, length);

					if (isName) {
						student.setName(value);
						isName = false;
					} else if (isCode) {
						student.setCode(value);
						isCode = false;
					} else if (isAge) {
						student.setAge(value);
						isAge = false;
					}
				}

				@Override
				public void endElement(String uri, String localName, String qName) throws SAXException {
					if (qName.equals("student")) {
						students.add(student);
					}
				}
			};

			saxParser.parse("students.xml", defaultHandler);

			System.out.println(students.toString());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
