package co.srsp.rest;

import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

import co.srsp.hibernate.orm.Employee;
import co.srsp.service.EmployeeDataService;
import co.srsp.viewmodel.EmployeeModel;

@Path("/pt360_service")
@Provider
public class PublicService {

	private final static Logger log = Logger.getLogger(PublicService.class); 
	
	@GET
	@Path("/getMsg/{param}")
	public String getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;

		return output;

	}
	
	@GET
	@Path("/getEmployees")
	public EmployeeModel[] getEmployees(){
		
		EmployeeDataService eds = new EmployeeDataService();
		
		List<Employee> employees = eds.getAllEmployeesPaginated(0, 1000);
		log.info("employees list returned : "+employees.size());
		EmployeeModel[] employeeModelArray = new EmployeeModel[employees.size()];
		int count = 0;
		
		EmployeeModel model = null;
		
		for(Employee employee : employees){
		
			model = new EmployeeModel();
			model.setEmployeeSurname(employee.getEmployeeSurname());
			model.setEmployeeFirstName(employee.getEmployeeFirstName());			
			model.setEmployeeGivenNames(employee.getEmployeeGivenNames());
			model.setEmployeeAge(employee.getEmployeeAge());
			model.setEmployeeAddress(employee.getEmployeeAddress());
			model.setEmployeeGender(employee.getEmployeeGender());
			model.setEmployeeMaritalStatus(employee.getEmployeeMaritalStatus());
			model.setIdemployee(employee.getIdemployee());
			employeeModelArray[count] = model;
			count++;
		}
		log.info("employees ARRAY length returned : "+employeeModelArray.length);
		return employeeModelArray;
		
		
//		for(Employee employee : employees){
//			log.info("we in here : "+count);
//			vnp = new ValueNamePair();
//			vnp.setName(skills.getSkillsetName());
//			vnp.setValue(skills.getSkillsetName());
//			returnArray[count] = vnp;
//			count++;
//		}
		
	//	EmployeeModel[]
	}
	
	@GET
	@Path("/searchEmployeeById/{param}")
	public EmployeeModel searchEmployeeById(@PathParam("param") String idemployee){
		
		EmployeeDataService eds = new EmployeeDataService();
		Employee employee = eds.getEmployeeById(idemployee);
		log.info("employee surname returned : "+employee.getEmployeeSurname());
		log.info("employee ID returned : "+employee.getIdemployee());
		EmployeeModel model = new EmployeeModel();
		model.setEmployeeSurname(employee.getEmployeeSurname());
		model.setEmployeeFirstName(employee.getEmployeeFirstName());			
		model.setEmployeeGivenNames(employee.getEmployeeGivenNames());
		model.setEmployeeAge(employee.getEmployeeAge());
		model.setEmployeeAddress(employee.getEmployeeAddress());
		model.setEmployeeGender(employee.getEmployeeGender());
		model.setEmployeeMaritalStatus(employee.getEmployeeMaritalStatus());
		model.setIdemployee(employee.getIdemployee());
		return model;
	}
	
	
	@GET
	@Path("/updateEmployee/{param}")
	public boolean updateEmployee(@PathParam("param") String nameValuePairs){
		EmployeeDataService eds = new EmployeeDataService();	
		StringTokenizer st = new StringTokenizer("-");
			
		int count = 1;	
		HashMap<String, String> nameValuesToUpdate = new HashMap<String, String>();
		
		String fieldName = "";
		String value = "";
		
		while(st.hasMoreElements()){
				
			if(count % 2 == 0){ //if the even value get the odd value as well and put in hashmap
				
				//even numbered value
				value = st.nextElement().toString();
				nameValuesToUpdate.put(fieldName, value);
			}else{
				//the odd numbered value
				fieldName = st.nextElement().toString();
			}
			count++;
			
		}
			
			eds.updateEmployee(nameValuesToUpdate.get("idemployee"), nameValuesToUpdate);
		
		
		return true;
	}
	
	@GET
	@Path("/searchEmployee/{param}")
	public EmployeeModel searchEmployee(@PathParam("param") String searchCriteria){
		EmployeeModel model = new EmployeeModel();
		model.setEmployeeAddress("that one");
		model.setEmployeeSurname("Newell");
		model.setEmployeeAge("27");
		model.setEmployeeFirstName("Paul : "+searchCriteria);
		
		return model;
	}
}
