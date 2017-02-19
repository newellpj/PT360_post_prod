package co.srsp.hibernate;

import java.util.HashMap;
import java.util.List;

import co.srsp.hibernate.orm.CompanyPositions;
import co.srsp.hibernate.orm.Employee;


public interface CompanyPositionsBusinessObject {
	public void save(CompanyPositions companyPositions);
	public void update(CompanyPositions companyPositions);
	public void delete(List<CompanyPositions> companyPositions);
	
	/**
	 * gets book by title and/or author. If author is null it will just search on title.
	 * @param title
	 * @param author
	 * @return Books ORM object
	 */
	public HashMap<CompanyPositions, List<Employee>> findEmployeesByPositionHeld(String position);
	
	public List<CompanyPositions> findCompanyPositionOfEmployee(String surname, String firstName);
	
	
}
