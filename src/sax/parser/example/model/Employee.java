package sax.parser.example.model;

import java.util.List;

public class Employee {

	// for attribute example
	private int employeeNumber;
	private String documentId;
	private String name;
	private String departmentName;
	private String departmentCountry;
	private List<String> referralNameList;
	private String salaryCcy;
	private int salaryAmount;

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentCountry() {
		return departmentCountry;
	}

	public void setDepartmentCountry(String departmentCountry) {
		this.departmentCountry = departmentCountry;
	}

	public List<String> getReferralNameList() {
		return referralNameList;
	}

	public void setReferralNameList(List<String> referralNameList) {
		this.referralNameList = referralNameList;
	}

	public String getSalaryCcy() {
		return salaryCcy;
	}

	public void setSalaryCcy(String salaryCcy) {
		this.salaryCcy = salaryCcy;
	}

	public int getSalaryAmount() {
		return salaryAmount;
	}

	public void setSalaryAmount(int salaryAmount) {
		this.salaryAmount = salaryAmount;
	}

	@Override
	public String toString() {
		return "Employee --> [employeeNumber=" + employeeNumber + ", documentId=" + documentId + ", name=" + name
				+ ", departmentName=" + departmentName + ", departmentCountry=" + departmentCountry
				+ ", referralNameList=" + referralNameList + ", salaryCcy=" + salaryCcy + ", salaryAmount="
				+ salaryAmount + "]";
	}
}
