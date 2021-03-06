// default package
// Generated 24/12/2016 10:08:45 AM by Hibernate Tools 5.1.0.Alpha1
package co.srsp.hibernate.orm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

/**
 * Employee generated by hbm2java
 */
@Entity
public class Employee implements java.io.Serializable {

	private Integer idemployee;
	private CompanyPositions companyPositions;
	private OrgDepartment orgDepartment;
	private String employeeSurname;
	private String employeeFirstName;
	private String employeeGivenNames;
	private String employeeAddress;
	private String employeeAge;
	private String employeeGender;
	private String employeeMaritalStatus;
	private String employeecol;
	private Set employeeToSkillsetRatingses = new HashSet(0);

	public Employee() {
	}

	public Employee(CompanyPositions companyPositions, OrgDepartment orgDepartment, String employeeSurname,
			String employeeFirstName, String employeeAge, String employeeGender, String employeecol) {
		this.companyPositions = companyPositions;
		this.orgDepartment = orgDepartment;
		this.employeeSurname = employeeSurname;
		this.employeeFirstName = employeeFirstName;
		this.employeeAge = employeeAge;
		this.employeeGender = employeeGender;
		this.employeecol = employeecol;
	}

	public Employee(CompanyPositions companyPositions, OrgDepartment orgDepartment, String employeeSurname,
			String employeeFirstName, String employeeGivenNames, String employeeAddress, String employeeAge,
			String employeeGender, String employeeMaritalStatus, String employeecol, Set employeeToSkillsetRatingses) {
		this.companyPositions = companyPositions;
		this.orgDepartment = orgDepartment;
		this.employeeSurname = employeeSurname;
		this.employeeFirstName = employeeFirstName;
		this.employeeGivenNames = employeeGivenNames;
		this.employeeAddress = employeeAddress;
		this.employeeAge = employeeAge;
		this.employeeGender = employeeGender;
		this.employeeMaritalStatus = employeeMaritalStatus;
		this.employeecol = employeecol;
		this.employeeToSkillsetRatingses = employeeToSkillsetRatingses;
	}

	public Integer getIdemployee() {
		return this.idemployee;
	}

	public void setIdemployee(Integer idemployee) {
		this.idemployee = idemployee;
	}

	public CompanyPositions getCompanyPositions() {
		return this.companyPositions;
	}

	public void setCompanyPositions(CompanyPositions companyPositions) {
		this.companyPositions = companyPositions;
	}

	public OrgDepartment getOrgDepartment() {
		return this.orgDepartment;
	}

	public void setOrgDepartment(OrgDepartment orgDepartment) {
		this.orgDepartment = orgDepartment;
	}

	public String getEmployeeSurname() {
		return this.employeeSurname;
	}

	public void setEmployeeSurname(String employeeSurname) {
		this.employeeSurname = employeeSurname;
	}

	public String getEmployeeFirstName() {
		return this.employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeGivenNames() {
		return this.employeeGivenNames;
	}

	public void setEmployeeGivenNames(String employeeGivenNames) {
		this.employeeGivenNames = employeeGivenNames;
	}

	public String getEmployeeAddress() {
		return this.employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeAge() {
		return this.employeeAge;
	}

	public void setEmployeeAge(String employeeAge) {
		this.employeeAge = employeeAge;
	}

	public String getEmployeeGender() {
		return this.employeeGender;
	}

	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}

	public String getEmployeeMaritalStatus() {
		return this.employeeMaritalStatus;
	}

	public void setEmployeeMaritalStatus(String employeeMaritalStatus) {
		this.employeeMaritalStatus = employeeMaritalStatus;
	}

	public String getEmployeecol() {
		return this.employeecol;
	}

	public void setEmployeecol(String employeecol) {
		this.employeecol = employeecol;
	}

	public Set getEmployeeToSkillsetRatingses() {
		return this.employeeToSkillsetRatingses;
	}

	public void setEmployeeToSkillsetRatingses(Set employeeToSkillsetRatingses) {
		this.employeeToSkillsetRatingses = employeeToSkillsetRatingses;
	}
	
	@Override
	public String toString(){
		return this.getEmployeeSurname() +" : "+
		this.getIdemployee() + " : "+this.getEmployeeSurname();	
	}

}
