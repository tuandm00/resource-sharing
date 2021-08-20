/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.UserDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

/**
 *
 * @author ASUS
 */
public class UserDAO {

    private Connection conn;
    private PreparedStatement stm;
    private ResultSet rs;

    private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }

    }

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select userID,name, roleID from tblUsers where userID = ? and password= ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    user = new UserDTO(rs.getString(1), rs.getString(2),rs.getString(3));
                }
                //closeConnection();
                return user;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public UserDTO loginGooogle(String userID) throws SQLException {
        UserDTO result = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT [name]\n"
                    + "      ,[roleID]\n"
                    + "  FROM [dbo].[Users]"
                    + " WHERE [userID] = ?";

            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, userID);
            rs = stm.executeQuery();
            if (rs.next()) {
                String fullname = rs.getString("name");
                String role = rs.getString("roleID");
                Date date = rs.getDate("");
                result = new UserDTO(userID, "", fullname, role, "", "", date);
            }
        } catch (Exception e) {
            closeConnection();
        }
        return result;
    }

    public boolean createGoogle(UserDTO dto) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO [dbo].[tblUsers]\n"
                    + "           ([userID]\n"
                    + "           ,[name]\n"
                    + "           ,[roleID])\n"
                    + "     VALUES\n"
                    + "           (?,?,?)";
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getUserID());
            stm.setString(2, dto.getName());
            stm.setString(3, dto.getRoleID());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            closeConnection();
        }
        return false;
    }

    public int register(UserDTO user) throws SQLException {
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO [dbo].[tblUsers]\n"
                        + "           ([userID]\n"
                        + "           ,[password]\n"
                        + "           ,[name]\n"
                        + "           ,[roleID]\n"
                        + "           ,[phone]\n"
                        + "           ,[address]\n"
                        + "           ,[captcha]\n"
                        + "           ,[email]\n"
                        + "           ,[status])\n"
                        + "     VALUES\n"
                        + "           (?,?,?,?,?,?,?,?,?)";

                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getUserID());
                stm.setString(2, user.getPassword());
                stm.setString(3, user.getName());
                stm.setString(4, user.getRoleID());
                stm.setString(5, user.getPhone());
                stm.setString(6, user.getAddress());
                stm.setString(7, user.getCaptcha());
                stm.setString(8, user.getEmail());
                stm.setString(9, user.getStatus());
                return stm.executeUpdate();

                // closeConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public UserDTO getUserByEmail(String email) {
        UserDTO user1 = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select userID, name, roleID from tblUsers where email = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    user1 = new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3));
                }
                //closeConnection();
                return user1;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public UserDTO getUserByID(String userID) {
        UserDTO user1 = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select userID, name, roleID, status, captcha, email from tblUsers where userID = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    user1 = new UserDTO(rs.getString(1), 
                            rs.getString(2), 
                            rs.getString(3), 
                            rs.getString(4), 
                            rs.getString(5), 
                            rs.getString(6));
                }
                //closeConnection();
                return user1;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public boolean updateStatus(String userID, String status) throws SQLException {
        try {
            String sql = "UPDATE [dbo].[tblUsers]\n"
                    + "   SET [status] = ? \n"
                    + " WHERE userID = ?";
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, status);
            stm.setString(2, userID);

            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            closeConnection();
        }
        return false;
    }
}
