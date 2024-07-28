package jdbclearning;

import java.sql.*;

class DBUtil2 {
    public static Connection getcon() throws SQLException {
        String url="jdbc:mysql://localhost:3306/jdbcdemo";
        String username="root";
        String password="kabilan12@#";
        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }
}
public class JDBCDemo3 {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static PreparedStatement ps;
    public static void createStatement() throws SQLException{
        connection= DBUtil2.getcon();
        statement=connection.createStatement();
        String query="create table employee2(id int,name varchar(28))";
        statement.executeUpdate(query);
    }
    public static void insert() throws SQLException{
        connection= DBUtil2.getcon();
        String query="insert into employee2 values(?,?)";
        int id=2;
        String name="kabilan";
        ps=connection.prepareStatement(query);
        ps.setInt(1,id);
        ps.setString(2,name);
       int rows= ps.executeUpdate();
        System.out.println("inserted successfully..");
    }
    public static void read() throws SQLException{
        connection=DBUtil2.getcon();
        statement=connection.createStatement();
        String query="select * from employee2";
        resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
        }
    }
    public static void update() throws SQLException {
        connection=DBUtil2.getcon();
        statement=connection.createStatement();
        String query="update employee2 set id=10 where name='kabilan' ";
        statement.executeUpdate(query);
        System.out.println("update successfully");
    }

    public static void main(String[] args) throws SQLException {
       read();
    }
}
