import java.sql.*;

public class EmpPreparedTest {
       public static void main (String args []) {
      Connection conn=null;
      PreparedStatement pstmt=null;
      ResultSet rs = null;
      try{
      Class.forName ("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","kim","kim");
      String sql="SELECT * from EMP Order by EMPNO";
      pstmt = conn.prepareStatement(sql);
      rs=pstmt.executeQuery();
      System.out.println("사번"+ "\t\t" + "이  름" + "\t\t" + "직업" + "\t" + "급여"+ "\t" + "보너스"+"\t"+"실 지급액");
      while (rs.next ()) {
         String id=rs.getString("EMPNO");
         String name=rs.getString("ENAME");
         String job=rs.getString("JOB");
         double salary=rs.getDouble("SAL");
         System.out.println(id+ "\t\t" +name+ "\t\t" +job+ "\t\t" +(int)salary+ "\t\t" +String.format("%.1f",(salary*0.1))+ "\t"+(int)(salary+salary*0.1));
      }
      }catch(Exception e){
          e.printStackTrace();
          } finally {
             try{
        	 	if(rs!=null) rs.close();
        	 	if(pstmt !=null) pstmt.close();
        	 	if(conn !=null) conn.close();
         } catch(SQLException e) {e.printStackTrace(); }
         }
        }
       }