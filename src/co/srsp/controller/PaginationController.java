
package co.srsp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import co.srsp.config.ConfigHandler;
import co.srsp.constants.SessionConstants;
import co.srsp.hibernate.orm.Employee;
import co.srsp.markup.handlers.HTMLHelper;
import co.srsp.viewmodel.EmployeeModel;
import co.srsp.viewmodel.EmployeeSkillsetDataModel;
import co.srsp.viewmodel.HTMLModel;
import co.srsp.viewmodel.HTMLModelSkillsets;


@Controller
@EnableWebMvc
public class PaginationController {

	private final static Logger log = Logger.getLogger(PaginationController.class); 
	

	@RequestMapping(value = { "/retrieveAgainLastViewedDataset"}, method = RequestMethod.GET)
	public @ResponseBody EmployeeModel[] retrieveAgainLastViewed(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getSession() == null){
			return null;
		}
		
		return deducePaginationRecordSet(request, response, 0);
	}
	
	
	@RequestMapping(value = { "/retrieveNextPaginatedResults"}, method = RequestMethod.GET)
	public @ResponseBody EmployeeModel[] retrieveNextPaginatedResults(HttpServletRequest request, HttpServletResponse response) {

		
		if(request.getSession() == null){
			return null;
		}
		
		int appPaginationValue = Integer.parseInt(ConfigHandler.getInstance().readApplicationProperty("paginationValue"));
		
		return deducePaginationRecordSet(request, response, appPaginationValue);
		
	
	}
	
	private EmployeeModel[] deducePaginationRecordSet(HttpServletRequest request, HttpServletResponse response, int amountToPaginate){
		log.info("we getting in here retrieveNextSegment?");
		
		Object obj = request.getSession().getAttribute(SessionConstants.EMPLOYEE_FULL_PROFILE_LIST);
		
		if(obj == null && amountToPaginate == 0){ //means user full paginated result set and is switching facet searching on and off in current search result set
			obj = request.getSession().getAttribute(SessionConstants.EMPLOYEE_FULL_PROFILE_LIST_FOR_FACET_SEARCHING);
			
			log.info(request.getSession().getId());
			log.info("obj was null so grab facet obj ::: "+obj);
		}
		
		
	   EmployeeModel [] model = null;
		
		if(obj == null){
			 model = null;
			//model.setViewName("searchPaginationPage"); //reviewsPaginationPage
			//model.addObject("booksLists2", new ArrayList<String>());
			log.info("returning empty model as list is null");
			return model;
			
		}else{
			
			List<EmployeeModel> completeList = (List<EmployeeModel>)obj;
			List<EmployeeModel> listToAlter = new ArrayList<EmployeeModel>();
			listToAlter.addAll(completeList);
		
			Object currentPaginationOffsetObj = request.getSession().getAttribute(SessionConstants.CURRENT_PAGINATION_OFFSET);
			
			int currentPaginationOffset = 0;
			
			if(currentPaginationOffsetObj == null){ //situation that occures when we are re-retrieving the data after the user has unchecked all facets and
				                                 //the user had paginated through all the results returned. Hence pagination offset would have been set to null.
				currentPaginationOffset = listToAlter.size();
			}else{
				currentPaginationOffset = Integer.parseInt(currentPaginationOffsetObj.toString());
			}
			
			
			log.info("currentPaginationOffset : "+currentPaginationOffset);
			log.info("appPaginationValue : "+amountToPaginate);
			log.info("employee model list size stored in session : "+listToAlter.size());
			
			
			
			int count = 0;
			
			int breakValue = -1;
			
			if(listToAlter.size() <= currentPaginationOffset + amountToPaginate){ //if we are in the last segment of the list we don't want an array index out of bounds exception
				
				if(amountToPaginate == 0){
				   listToAlter = listToAlter.subList(0, listToAlter.size());
				}else{
				   listToAlter = listToAlter.subList(currentPaginationOffset, listToAlter.size());
				}
				
				breakValue = listToAlter.size() - currentPaginationOffset;
			}else{
				if(amountToPaginate == 0){
					listToAlter = listToAlter.subList(0, currentPaginationOffset);
				}else{
					listToAlter = listToAlter.subList(currentPaginationOffset, currentPaginationOffset + amountToPaginate);
				}
		
				breakValue = amountToPaginate;
			}
			
			
			log.info("sublist size is : "+listToAlter.size());
			
			
			//request.getSession().setAttribute(SessionConstants.EMPLOYEE_FULL_PROFILE_LIST, list); //this would be setting the sublist which we don't wish to do
			request.getSession().setAttribute(SessionConstants.CURRENT_PAGINATION_OFFSET, currentPaginationOffset + amountToPaginate);
			if((currentPaginationOffset + amountToPaginate) >  completeList.size()){
				
				log.info("sticking complete list in facet list : "+completeList.size());
				log.info(request.getSession().getId());
				request.getSession().setAttribute(SessionConstants.EMPLOYEE_FULL_PROFILE_LIST_FOR_FACET_SEARCHING, completeList);
				request.getSession().setAttribute(SessionConstants.EMPLOYEE_FULL_PROFILE_LIST, null);
			}

			

			
			if(listToAlter != null){
				int iCount = 0;
				model = new EmployeeModel[listToAlter.size()];
				for(EmployeeModel empModel : listToAlter){
					model[iCount] = empModel;
					iCount ++;
					//booksLists2.add(formattedSearchListItem(empModel));
				}
			}	
			log.info("22222222222222 sticking complete list in facet list : "+completeList);
			log.info("22222222222222 sticking complete list in facet list : "+completeList.size());
			return model;
		}
	}
	
	
	private String formattedSearchListItem(EmployeeModel employeeModel){

		
		HTMLModel htmlModel = new HTMLModel();
		
		log.info("employeeModel.getEmployeeSurname() : "+employeeModel.getEmployeeSurname());
		
		htmlModel.setemployeeAge(employeeModel.getEmployeeAge());
		htmlModel.setemployeeSurname(employeeModel.getEmployeeSurname());
		htmlModel.setemployeeFirstName(employeeModel.getEmployeeFirstName());
		htmlModel.setemployeeGivenNames(employeeModel.getEmployeeGivenNames());
		htmlModel.setemployeeMaritalStatus(employeeModel.getEmployeeMaritalStatus());
		htmlModel.setemployeeGender(employeeModel.getEmployeeGender());
		htmlModel.setimageHeight(employeeModel.getImageHeight());
		htmlModel.setimageWidth(employeeModel.getImageWidth());
		htmlModel.setprofilePicURL(employeeModel.getProfilePicURL());
		htmlModel.setdepartmentName(employeeModel.getEmpSkillsetsDataModel().get(0).getDepartmentName());
		htmlModel.setcurrentPositionName(employeeModel.getEmpSkillsetsDataModel().get(0).getCurrentPostionName());
		
		HTMLModelSkillsets htmlModelSkillsets = null;
		
		List<HTMLModelSkillsets> skillsets = new ArrayList<HTMLModelSkillsets>();
		
		for(EmployeeSkillsetDataModel model : employeeModel.getEmpSkillsetsDataModel()){
			log.info("model.getSkillsetName() : "+model.getSkillsetName());
			htmlModelSkillsets = new HTMLModelSkillsets();
			htmlModelSkillsets.setskillSetProficiency(model.getSkillSetProficiency().toString());
			htmlModelSkillsets.setskillsetName(model.getSkillsetName());
			htmlModelSkillsets.setskillsetYearsExperience(model.getSkillsetYearsExperience().toString());
			htmlModelSkillsets.setskillsetToPositionRelevance(model.getSkillsetToPositionRelevance().toString());
			skillsets.add(htmlModelSkillsets);
		}
		
		htmlModel.setskillsetsList(skillsets);
		
		
  //profilePicURL,employeeFirstName,employeeGivenNames,employeeSurname,employeeAge,
		//employeeGender,employeeMaritalStatus,departmentName,skillsetName,skillSetProficiency,skillsetToPositionRelevance,skillsetYearsExperience
		
		HTMLHelper helper = new HTMLHelper();
		String formattedMarkup = helper.formatSearchHTML(htmlModel);
				
		log.info("formattedMarkup : "+formattedMarkup);
		
		return formattedMarkup;

	}
	
	private String getTrueThumbnailLocation(Employee employee){
		return null;
				//(employee.getThumbnailLocation() != null && employee.getThumbnailLocation().contains("http")) ? 
				//employee.getThumbnailLocation() : "./presentationResources/images/"+employee.getThumbnailLocation();
	
	}
	
	private HashMap getImageDimensions(String imageLocation, Employee employee){
		
//		HashMap<String, String> imageDimensionsMap = new HashMap<String, String>();
//		
//		try{
//			
//			String fileURLPath = (imageLocation.toLowerCase().contains("http")) ? imageLocation :
//						"../webapps/iFindit4U/presentationResources/images/"+employee.getThumbnailLocation();
//			
//			log.info( System.getProperty("user.dir"));
//			 
//			File file = new File(fileURLPath);
//			log.info("location for file is :::: "+fileURLPath);
//			log.info("does file exist : "+file.exists());
//			
//			Image image = new ImageIcon(fileURLPath).getImage();
//			
//			int imgWidth = image.getWidth(null);
//			int imgHeight = image.getHeight(null);
//			
//			log.info("imgWidth : "+imgWidth);
//			log.info("imgHeight : "+imgHeight);
//			
//			if(imgWidth > imgHeight){
//				double result = new Double(imgHeight)/ new Double(imgWidth);
//				log.info("result : "+result);
//				imgHeight = (int)(result * new Double(120));
//				imgWidth = 120;
//			}else if(imgWidth < imgHeight){
//				double result = new Double(imgWidth)/ new Double(imgHeight);
//				imgWidth = (int)(result * new Double(120));
//				imgHeight = 120;
//			}else{
//				imgHeight = 120;
//				imgWidth  = 120;
//			}
//			
//			imageDimensionsMap.put("imageWidth", String.valueOf(imgWidth));
//			imageDimensionsMap.put("imageHeight", String.valueOf(imgHeight));
//			
//		}catch(Exception e){
//			e.printStackTrace();
//			log.error(e.getMessage());
//		}
		
		return null;//imageDimensionsMap;
	}
	
	
}

