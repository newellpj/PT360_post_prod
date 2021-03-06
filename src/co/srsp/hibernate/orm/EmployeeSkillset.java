// default package
// Generated 24/12/2016 10:08:45 AM by Hibernate Tools 5.1.0.Alpha1
package co.srsp.hibernate.orm;

import java.util.HashSet;
import java.util.Set;

/**
 * EmployeeSkillset generated by hbm2java
 */
public class EmployeeSkillset implements java.io.Serializable {

	private Integer idemployeeSkillset;
	private String skillsetName;
	private String proficiency;
	private String currentPositionRelevance;
	private Integer yearsExperience;
	private Set employeeToSkillsetRatingses = new HashSet(0);

	public EmployeeSkillset() {
	}

	public EmployeeSkillset(String skillsetName, String proficiency, String currentPositionRelevance) {
		this.skillsetName = skillsetName;
		this.proficiency = proficiency;
		this.currentPositionRelevance = currentPositionRelevance;
	}

	public EmployeeSkillset(String skillsetName, String proficiency, String currentPositionRelevance,
			Integer yearsExperience, Set employeeToSkillsetRatingses) {
		this.skillsetName = skillsetName;
		this.proficiency = proficiency;
		this.currentPositionRelevance = currentPositionRelevance;
		this.yearsExperience = yearsExperience;
		this.employeeToSkillsetRatingses = employeeToSkillsetRatingses;
	}

	public Integer getIdemployeeSkillset() {
		return this.idemployeeSkillset;
	}

	public void setIdemployeeSkillset(Integer idemployeeSkillset) {
		this.idemployeeSkillset = idemployeeSkillset;
	}

	public String getSkillsetName() {
		return this.skillsetName;
	}

	public void setSkillsetName(String skillsetName) {
		this.skillsetName = skillsetName;
	}

	public String getProficiency() {
		return this.proficiency;
	}

	public void setProficiency(String proficiency) {
		this.proficiency = proficiency;
	}

	public String getCurrentPositionRelevance() {
		return this.currentPositionRelevance;
	}

	public void setCurrentPositionRelevance(String currentPositionRelevance) {
		this.currentPositionRelevance = currentPositionRelevance;
	}

	public Integer getYearsExperience() {
		return this.yearsExperience;
	}

	public void setYearsExperience(Integer yearsExperience) {
		this.yearsExperience = yearsExperience;
	}

	public Set getEmployeeToSkillsetRatingses() {
		return this.employeeToSkillsetRatingses;
	}

	public void setEmployeeToSkillsetRatingses(Set employeeToSkillsetRatingses) {
		this.employeeToSkillsetRatingses = employeeToSkillsetRatingses;
	}

}
