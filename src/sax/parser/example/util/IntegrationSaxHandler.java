package sax.parser.example.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import sax.parser.example.model.Employee;

public class IntegrationSaxHandler extends DefaultHandler{

	Employee employee = new Employee();
	
	public Employee getEmployee() {
		return employee;
	}

	// Stack for tag name
	Stack<String> elementStack = new Stack<>();
	
	List<String> referralList = new ArrayList<>();
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		elementStack.push(qName);
		
		if ("EmployeeNumber".equalsIgnoreCase(attributes.getLocalName(0))) {
			employee.setEmployeeNumber(Integer.parseInt(attributes.getValue(0)));
		}else if ("Currency".equalsIgnoreCase(attributes.getLocalName(0))) {
			employee.setSalaryCcy(attributes.getValue(0));
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		elementStack.pop();
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String value = new String(ch, start, length);
		String path = getElementStackPath();
		System.out.println(path);
		if ("Employee/DocumentId/".equalsIgnoreCase(path)) {
			employee.setDocumentId(value);
		}else if ("Employee/Name/".equalsIgnoreCase(path)) {
			employee.setName(value);
		} else if ("Employee/Department/Name/".equalsIgnoreCase(path)) {
			employee.setDepartmentName(value);
		}else if ("Employee/Department/Location/Country/".equalsIgnoreCase(path)) {
			employee.setDepartmentCountry(value);
		}else if ("Employee/Referrals/Name/".equalsIgnoreCase(path)) {
			referralList.add(value);
			employee.setReferralNameList(referralList);
		}else if ("Employee/Salary/".equalsIgnoreCase(path)) {
			employee.setSalaryAmount(Integer.parseInt(value));
		}

	}

	private String getElementStackPath() {
		String path = StringUtils.EMPTY;
		for (Object c : elementStack.toArray()) {
			path = path.concat((String)c).concat("/");
		}
		return path;
	}
	
	public String getElementStack() {
		return elementStack.peek();
	}
}
