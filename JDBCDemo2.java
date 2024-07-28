package jdbclearning;

import java.sql.*;

class DBUtil{
    public static Connection getcon() throws SQLException {
        String url="jdbc:mysql://localhost:3306/jdbcdemo";
        String username="root";
        String password="kabilan12@#";
        Connection connection=DriverManager.getConnection(url,username,password);
        return connection;
    }
}

public class JDBCDemo2 {
    private static Connection con;
    private static Statement st;
    private static ResultSet rs;
    private static PreparedStatement ps;
    public static void create() throws SQLException {
        con=DBUtil.getcon();
        st=con.createStatement();
        String query="create table student2(id int,name varchar(20),age int)";
        st.executeUpdate(query);
    }
    public static void insert() throws SQLException {
        con=DBUtil.getcon();
        int id=2;
        String name="vijay";
        int age=30;
        String query="insert into student2 values(?,?,?)";
        ps=con.prepareStatement(query);
        ps.setInt(1,id);
        ps.setString(2,name);
        ps.setInt(3,age);
       int rows=ps.executeUpdate();
        System.out.println("insert sucessfully");
    }
    public static void read() throws SQLException {
        con=DBUtil.getcon();
        st=con.createStatement();
        String query="select * from student2";
        rs=st.executeQuery(query);
        while (rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getInt(3));
        }
    }
    public static void update() throws SQLException {
        con=DBUtil.getcon();
        st=con.createStatement();
        String query="update student2 set id=3 where age=30";
        st.executeUpdate(query);
    }

    public static void main(String[] args) throws SQLException {
        read();
    }


}
