package sax.parser.example;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import sax.parser.example.model.Employee;
import sax.parser.example.util.IntegrationSaxHandler;

public class ResponseClass {

	public static void main(String[] args) {
		IntegrationSaxHandler handler = new IntegrationSaxHandler();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(new File("/Users/muhammediscan/dev/eclipse-workspace/EmplyeeProject/employee.xml"), handler);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Employee employee = handler.getEmployee();
		
		System.out.println(employee.toString());
	}
}
