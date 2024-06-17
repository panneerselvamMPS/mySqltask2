import java.sql.*;


public class JdbcExample {
   public static void main(String[] args) {
      try {

         Class.forName("com.mysql.cj.jdbc.Driver");

         Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/task2", "root", "password");

         Statement stmt = con.createStatement();

         ResultSet rs = stmt.executeQuery("SELECT * FROM employee");


         final String[][] table = new String[5][];
         int j=0;
         while (rs.next()) {
        	table[j] = new String[] {String.valueOf(rs.getInt("empcode")),rs.getString("empname"),String.valueOf(rs.getInt("empage")),String.valueOf(rs.getInt("esalary"))};
        	j++;
         }
         System.out.println("********* JDBC CONNECTION SUCCESSFUL *********");
         System.out.println();
         System.out.printf("%-10s %-10s %-10s %-10s%n", "ID", "Name", "Age", "Salary");

         for (String[] employee : table) {
             System.out.printf("%-10s %-10s %-10s %-10s%n", employee[0], employee[1], employee[2], employee[3]);
         }

         // Close the result set, statement, and connection
         rs.close();
         stmt.close();
         con.close();
      } catch (Exception e) {
         System.out.println(e);
      }
   }
}