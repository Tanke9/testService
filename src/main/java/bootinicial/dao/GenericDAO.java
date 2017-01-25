package bootinicial.dao;


import bootinicial.procedure.CallProcedure;

public class GenericDAO {

	CallProcedure procedure = new CallProcedure();
	
	public String test(){
		return procedure.call("{call JSON_TEST.TEST(?,?)}");
		
	}
}
