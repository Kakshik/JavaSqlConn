import java.sql.*;

public class DBConnect {
    public static void main(String[] args) {

        try {
            String host = "jdbc:mysql://localhost:3306/employees";
            String uName = "root";
            String uPass = "root";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            Statement stat = con.createStatement();
            String sql = "select * from workers";
            ResultSet rs = stat.executeQuery(sql);

            while ( rs.next()) {
                int id_col = rs.getInt("ID");
                String first_name = rs.getString("First_Name");
                String last_name = rs.getString("Last_Name");
                String job = rs.getString("Designation");

                String p = id_col + " " + first_name + " " + last_name + " " + job;
                System.out.println(p);
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }

}