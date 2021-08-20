/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.BookingDTO;
import dtos.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class BookingDAO {

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

    public boolean addBooking(BookingDTO dto) {
        try {
            String sql = "INSERT INTO [dbo].[tblBooking]\n"
                    + "           ([userID]\n"
                    + "           ,[totalPrice]\n"
                    + "           ,[status]\n"
                    + "           ,[duration])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?)";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getUserID());
            stm.setDouble(2, dto.getTotalPrice());
            stm.setString(3, dto.getStatus());
            stm.setString(4, dto.getDuration());

            stm.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
