package bootinicial.procedure;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;

import bootinicial.config.DataSourceConfig;
import oracle.jdbc.OracleTypes;

public class CallProcedure {
	
	private DataSource dataSource = new DataSourceConfig().dataSource();

	public String call(String procedureName) {
			
			Connection dbConnection = null;
			CallableStatement callableStatement = null;
			ResultSet rs = null;
			String sClob = "";
			try {
				dbConnection = dataSource.getConnection();
				callableStatement = dbConnection.prepareCall(procedureName);
				
				callableStatement.registerOutParameter("P_RESULT", OracleTypes.CLOB);
				
				callableStatement.setObject("P_SELECT","");
				
				callableStatement.executeUpdate();
				Clob clob = (Clob) callableStatement.getObject("P_RESULT");

				InputStream in = clob.getAsciiStream();
				StringWriter w = new StringWriter();
				try {
					IOUtils.copy(in, w);
				} catch (IOException e) {
					e.printStackTrace();
				}
				sClob = w.toString();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				if (rs != null) {
					try {	rs.close();	} catch (SQLException e) {	}
				}
				if (callableStatement != null) {
					try {	callableStatement.close();	} catch (SQLException e) {	}
				}
				if (dbConnection != null) {
					try {	dbConnection.close();	} catch (SQLException e) { }
				}
			}
			return sClob;
		}
		
		
}
