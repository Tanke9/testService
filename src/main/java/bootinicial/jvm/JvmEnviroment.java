package bootinicial.jvm;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;


/**
 * Environment constants.
 * @author planetmedia
 *
 */
public class JvmEnviroment {

	private static final String LOCAL = "http://localhost:8080/smbUsers/activate/";
	private static final String EQUAL = "=";
	private static JvmEnviroment INSTANCE = null;
	private static List<String> argumentList = null;
	
	private JvmEnviroment(){
		RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
		argumentList = bean.getInputArguments();
	}
	
	private synchronized static void createInstance(){
		if (INSTANCE == null){
			INSTANCE = new JvmEnviroment();
		}
	}
	
	public static JvmEnviroment getInstance(){
		if (INSTANCE == null ) createInstance();
		return INSTANCE;
	}
	
	public String getDBPasswordJVM(){
		return getParam(Constants.DB_PASSWORD_JVM);
	}
	
	public String getDBServerNameJVM(){
		return getParam(Constants.DB_SERVER_NAME_JVM);
	}
	
	public String getDBNameJVM(){
		return getParam(Constants.DB_NAME_JVM);
	}
	
	public String getDBUsernameJVM(){
		return getParam(Constants.DB_USERNAME_JVM);
	}
	
	public String getEnvironmentJVM(){
	return getParam(Constants.ENVIRONMENT_JVM)!=null?getParam(Constants.ENVIRONMENT_JVM)+"SmartBuy/smbUsers/activate/":LOCAL;
//		return getParam(Constants.ENVIRONMENT_JVM)+"SmartBuy/smbUsers/activate/";
	}
	
	public String getParam(String argument){
		
		  for (int i = 0; i < argumentList.size(); i++) {
			  if (argumentList.get(i).contains(argument)){
				  return argumentList.get(i).substring(argumentList.get(i).indexOf(EQUAL)+1);
			  }
		  }
		  return null;
	}
}
