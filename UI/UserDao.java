package StudyCafe;

import StudyCafe.DB.DBConnection;

import java.sql.*;


public class UserDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    UserVO user = null;
    public UserVO getUser(String phone, String password) throws SQLException {

        conn = DBConnection.getConnection();
        String query = "SELECT user_idx, user_name, user_phone, report_count, admin FROM users WHERE user_phone = ? AND user_pw = ?";
        try {
                pstmt = conn.prepareStatement(query);

                pstmt.setString(1, phone);
                pstmt.setString(2, password);
                rs = pstmt.executeQuery();

            while (rs.next()) {
                user = new UserVO();
                user.setUserIdx(rs.getInt("user_idx"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPhone(rs.getString("user_phone"));
                user.setReportCount(rs.getInt("report_count"));
                user.setAdmin(rs.getString("admin"));
            }
        }
        finally {
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
//        System.out.println(user.getUserPhone()+" "+user.getUserName());
        return user;
    }
}

