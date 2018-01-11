package co.srsp.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.srsp.hibernate.EmployeeBusinessObject;
import co.srsp.hibernate.orm.CompanyPositions;
import co.srsp.hibernate.orm.Employee;
import co.srsp.hibernate.orm.EmployeeSkillset;
import co.srsp.hibernate.orm.OrgDepartment;
import co.srsp.viewmodel.EmployeeFacetWrapperModel;
import co.srsp.viewmodel.EmployeeModel;

public class EmployeeDataService {
	
	private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	private EmployeeBusinessObject employeeBusinessObject = (EmployeeBusinessObject) ctx.getBean("employeeBusinessObject");
	
	public List<Employee> getEmployeeRecord(String searchString, int startOffset, int numberOfRecords){
		
		return employeeBusinessObject.findEmployeePartialSurnameMatch("", startOffset, numberOfRecords);
	}
	
	public EmployeeFacetWrapperModel findEmployeesByAnyCriteriaLazyLoad(HashMap<String, String> searchCriteria, int offset, int numberOfRecords){
		return employeeBusinessObject.findEmployeesByAnyCriteriaLazyLoad(searchCriteria, offset, numberOfRecords);
	}
	
	public EmployeeModel findEmployeePerformanceDetails(EmployeeModel empModel){
		return employeeBusinessObject.findEmployeePerformanceDetails(empModel);
	}
	
	public boolean updateEmployee(String id, HashMap<String, String> fieldValuePairs){

		Employee employee = new Employee();
		
		for(String key : fieldValuePairs.keySet()){
			try{
				
				String s1 = String.valueOf(key.charAt(0)).toUpperCase();
                String capitalFirstChar = s1 + key.substring(1);
				System.out.println("capitalFirstChar  :::: " + capitalFirstChar);
				
				java.lang.reflect.Method method = employee.getClass().
					getDeclaredMethod("set"+capitalFirstChar, new Class[] {});
			
				String value = (fieldValuePairs.get(key) != null) ? fieldValuePairs.get(key) : "";
				Object obj = method.invoke(employee, value);
				
				System.out.println("emp surname : "+employee.getEmployeeSurname());
				
				
			}catch(Throwable t){
				t.printStackTrace();
				System.out.println("we in here ");
			}
		}
		
		
		
		return employeeBusinessObject.update(employee);
	}
	
	
	public List<Employee> getAllEmployeesPaginated(int startOffset, int numberOfRecords){
		
		return employeeBusinessObject.getAllEmployees(startOffset, numberOfRecords);
	}
	
	public  List<EmployeeModel> getAllEmployeesFullProfile(Integer empID, int offset, int numberOfRecords){
		return employeeBusinessObject.getAllEmployeesFullProfile(empID, offset, numberOfRecords);
	}
	
	public Employee getEmployeeById(String idEmployee){
		return employeeBusinessObject.getEmployeeById(idEmployee);
	}
	
	
	public  List<Employee> getEmployeesBySurname(String surnamePartial, int offset, int numberOfRecords){
		return employeeBusinessObject.findEmployeePartialSurnameMatch(surnamePartial, offset, numberOfRecords);
	}
	
	public  List<Employee> getEmployeesByFirstName(String firstNamePartial, int offset, int numberOfRecords){
		return employeeBusinessObject.findEmployeePartialFirstNameMatch(firstNamePartial, offset, numberOfRecords);
	}
	
	public  List<Employee> getEmployeesByGivenNames(String givenNamesPartial, int offset, int numberOfRecords){
		return employeeBusinessObject.findEmployeePartialGivenNamesMatch(givenNamesPartial, offset, numberOfRecords);
	}
	
	public List<EmployeeSkillset> getAllSkillsets(){
		return employeeBusinessObject.getAllSkillsets();
	}

	public List<CompanyPositions> getCompanyPositions(){
		return employeeBusinessObject.getCompanyPositions();
	}
	
	public List<OrgDepartment> getOrgDepts(){
		return employeeBusinessObject.getOrgDepts();
	}
	

}
