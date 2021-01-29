import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PlayerTest {
	public static void main(String args[]) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "kang", "kang");
			pstmt = conn.prepareStatement("select * from player where team_id = ?");
			pstmt.setString(1, "K09");
			rs = pstmt.executeQuery();
			System.out.println("team_ID" + "\t" + "이 름" + "\t" + "POSITION" + "\t" + "birth" + "\t" + "nation");
			System.out.println("====================================");
			while (rs.next()) {
				String team_id = rs.getString("team_id");
				String name = rs.getString("player_name");
				String position = rs.getString("position");
				java.sql.Date sqlDate = rs.getDate("birth_date");
				String nation = rs.getString("nation");
				if (nation != null)
					System.out.println(team_id + "\t" + name + "\t" + position + "\t" + sqlDate + "\t" + nation);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
	}
}
