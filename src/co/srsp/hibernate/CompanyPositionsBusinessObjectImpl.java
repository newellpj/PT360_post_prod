package co.srsp.hibernate;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import co.srsp.hibernate.orm.CompanyPositions;
import co.srsp.hibernate.orm.Employee;

@Configuration
@EnableAspectJAutoProxy
public class CompanyPositionsBusinessObjectImpl extends HibernateDaoSupport implements CompanyPositionsBusinessObject {

	private final static Logger log = Logger.getLogger(CompanyPositionsBusinessObjectImpl.class);

	@Override
	public void save(CompanyPositions companyPositions) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CompanyPositions companyPositions) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(List<CompanyPositions> companyPositions) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<CompanyPositions, List<Employee>> findEmployeesByPositionHeld(String position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyPositions> findCompanyPositionOfEmployee(String surname, String firstName) {
		// TODO Auto-generated method stub
		return null;
	} 
	

}