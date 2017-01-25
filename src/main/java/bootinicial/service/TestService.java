package bootinicial.service;

import org.springframework.stereotype.Service;

import bootinicial.dao.GenericDAO;



@Service
public class TestService {

	private GenericDAO genericDAO = new GenericDAO();

	/**
	 * @param userRepository
	 */
	public TestService() {

	}
	
	public String test(){
		
		return genericDAO.test();
	}
	
}
