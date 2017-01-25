package bootinicial.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import bootinicial.jvm.JvmEnviroment;

/**

* Database config

* @author: Alberto Ruiz

* @version: 15/10/2016/A

*/
public class DataSourceConfig {

	public DataSource dataSource() {
		
		oracle.jdbc.pool.OracleDataSource ds = null;
		try {
			ds = new oracle.jdbc.pool.OracleDataSource();
			ds.setDriverType("thin");
			ds.setPortNumber(1521);
			
			if (JvmEnviroment.getInstance().getDBServerNameJVM()!=null){
				ds.setServerName(JvmEnviroment.getInstance().getDBServerNameJVM());
				ds.setDatabaseName(JvmEnviroment.getInstance().getDBNameJVM()); // Oracle SID
				ds.setUser(JvmEnviroment.getInstance().getDBUsernameJVM());
				ds.setPassword(JvmEnviroment.getInstance().getDBPasswordJVM());
			}else{
				System.out.println("jvm no inicializada");
				ds.setDatabaseName("SMARTPRE_CON"); // Oracle SID			
				ds.setUser("smbowner");
				ds.setPassword("smbowner");
				ds.setServerName("10.6.0.109");
			}
		} catch (SQLException e) {
			System.out.println("Error sql: " +e);
			e.printStackTrace();
		}
	
		return ds;
	}

}