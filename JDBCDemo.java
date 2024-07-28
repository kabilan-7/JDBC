package jdbclearning;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
      deleteRecords();
    }
    public static void readRecords() throws Exception{
        String url="jdbc:mysql://localhost:3306/jdbcdemo";
        String username="root";
        String password="kabilan12@#";
        String query="select * from employee";
        Connection connection=DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()) {
            System.out.println("Id is " + rs.getInt(1));
            System.out.println("Name is " + rs.getString(2));
            System.out.println("Salary is " + rs.getInt(3));
        }
        connection.close();
    }
    public static void insertRecords() throws Exception{
        String url="jdbc:mysql://localhost:3306/jdbcdemo";
        String username="root";
        String password="kabilan12@#";
        String query="insert into employee values (6,'daya',70000)";

        Connection connection = DriverManager.getConnection(url,username,password);
        Statement st=connection.createStatement();
        int rows = st.executeUpdate(query);
        System.out.println("number of rows affected:"+rows);
        connection.close();
    }
    public static void insertRecordsUsingPst() throws Exception{
        String url="jdbc:mysql://localhost:3306/jdbcdemo";
        String username="root";
        String password="kabilan12@#";
        int id=7;
        String name="vijay";
        int salary=5000;
        String query="insert into employee values (?,?,?)";

        Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);
        preparedStatement.setInt(3,salary);
       int rows=preparedStatement.executeUpdate();
        connection.close();
    }
    public static void deleteRecords() throws Exception{
        String url="jdbc:mysql://localhost:3306/jdbcdemo";
        String username="root";
        String password="kabilan12@#";
        String query="delete from employee where emp_id=6";

        Connection connection = DriverManager.getConnection(url,username,password);
        Statement st=connection.createStatement();
        int rows = st.executeUpdate(query);
        System.out.println("number of rows affected:"+rows);
        connection.close();
    }

}
