package task8.sql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Employee 
{
    public static void main( String[] args )
    {
    	String url = "jdbc:mysql://localhost:3306/task8";
    	String username = "root";
    	String pass = "root";
    	
    	try {
    		Connection con = DriverManager.getConnection(url,username,pass);
    		if (con!=null) {
				System.out.println("Running");
			}else {
				System.out.println("Failed");
			}
    		Statement st = con.createStatement();
    		String create = "create table employee(empcode int primary key, empname varchar(255),empage int,empsalary int)";
    		String insert = """
    				   INSERT INTO employee (empcode, empname, empage, empsalary) VALUES
    				  (101, 'Jenny', 25, 10000),
    				  (102, 'Jacky', 30, 20000),
    				  (103, 'Joe', 20, 40000),
    				  (104, 'John', 40, 80000),
    				  (105, 'Shameer', 25, 90000)
    				  """;
    		st.execute(create);
    		st.execute(insert);
    		
    		String display = "select * from employee";
    		
    		ResultSet rs = st.executeQuery(display);
    	   while (rs.next()) {
			System.out.println(rs.getInt("empcode") +" "+ rs.getString("empname")+" "+rs.getInt("empage") +" "+rs.getInt("empsalary"));
		}
    	}catch (Exception e) {
			e.printStackTrace();
		}
    }
}
