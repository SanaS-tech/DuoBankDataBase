package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class JDBCTester {

	public static void main(String[] args) throws SQLException {

//		String url = "jdbc:mysql://dtdatabase.c6qqyddfk30u.us-east-2.rds.amazonaws.com/employees";
//		String user = "duotech";
//		String password = "duotech2020";
//			
//			
//		
//		Connection connection = DriverManager.getConnection(url, user, password);
//		
//		System.out.println("Connection established");
//		
//		
//		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//		
//		ResultSet resultSet = statement.executeQuery("select * from employees limit 10");
		
//		resultSet.next();
//		
//		System.out.println(resultSet.getObject(2)); //In JDBC indexes start from 1;
//		
//		resultSet.next();
//		
//		System.out.println(resultSet.getObject("birth_date"));
		
//		while(resultSet.next()) {
//			System.out.println(resultSet.getString("first_name"));
//		}
//		System.out.println(resultSet.getRow());
//		
//		resultSet.first();
//		
//		System.out.println(resultSet.getRow());
		
		
//		resultSet.last();
//		
//		int noOfRows = resultSet.getRow();
////		
//		
//		resultSet.absolute(4); 
//		
//		System.out.println(resultSet.getObject("first_name"));
//		
//		System.out.println(noOfRows);
		
		
		// to get no of column
		
		
//		
//		for (int i = 1; i <= noOFColumns; i++) {
//			System.out.println(metaData.getColumnName(i));
//		}
//		
//		
		
		//To update the data in the database we need to use executeUpdate() method on 
		
//		statement.executeUpdate("update employees  set  first_name='Furkan', last_name='Ozturk' where emp_no='10001'");
//		
//		resultSet = statement.executeQuery("select * from employees limit 10");
//		
//		
//		ResultSetMetaData metaData = resultSet.getMetaData();
//		
//		int noOFColumns = metaData.getColumnCount();
//		
//		
//		resultSet.beforeFirst();
//		
//		for (int i = 1; i <= noOfRows; i++) {
//			resultSet.next();
//			for (int j = 1; j <= noOFColumns; j++) {
//				System.out.print(resultSet.getObject(j) + "\t");
//			}
//			System.out.println();
//			
//		}
////		
////	
		
		
		DBUtils.createConnection();
		System.out.println("Connection success");
		
		String query = "select * from salaries limit 100";
		
		System.out.println(DBUtils.getColumnNames(query));
		
		System.out.println(DBUtils.getRowCount());
		
		String updateQ = "update employees  set  first_name='Barack', last_name='Obama' where emp_no='10002'";
		DBUtils.updateQuery(updateQ);
		
		
		List<List<Object>> queryResultList = DBUtils.getQueryResultList("select * from employees limit 15");
		
		for (List<Object> list : queryResultList) {
			System.out.println(list);
		}
		
		System.out.println("-----------------------------MAP-----------------------------------------");
		List<Map<String, Object>> queryResultMap = DBUtils.getQueryResultMap("select * from employees limit 15");
		
		for (Map<String, Object> map : queryResultMap) {
			
			System.out.println(map);
			
		}
		
		
		
		
////
	}

		
		
}
