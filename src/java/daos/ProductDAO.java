/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class ProductDAO {

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

    public List<ProductDTO> getAllProducts() throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT productID, productName, price, quantity, color, categoryID "
                        + "FROM tblProducts ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    String color = rs.getString("color");
                    String categoryID = rs.getString("categoryID");
                    list.add(new ProductDTO(productID, productName, price, quantity, color, categoryID));
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return list;
    }

    public static void main(String[] args) throws SQLException {
        // check load du lieu len web
        ProductDAO dao = new ProductDAO();
        List<ProductDTO> list = dao.getAllProducts();
        for (ProductDTO productDTO : list) {
            System.out.println("Check load du lieu len web: " + productDTO);
        }

        //check ham count
        int count = dao.count("a");
        System.out.println("count: " + count);


    }

    public List<ProductDTO> searchProduct(String search) throws SQLException{
        List<ProductDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn!=null) {
                String sql = "SELECT [productID]\n" +
                            "      ,[productName]\n" +
                            "      ,[price]\n" +
                            "      ,[quantity]\n" +
                            "      ,[color]\n" +
                            "      ,[categoryID]\n" +
                            " FROM [dbo].[tblProducts]\n" +
                            " WHERE [productName] LIKE ? OR [categoryID] = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%"+search+"%");
                stm.setString(2, search);
                rs = stm.executeQuery();
                while (rs.next()) {                    
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    String color = rs.getString("color");
                    String categoryID = rs.getString("categoryID");
                    list.add(new ProductDTO(productID, productName, price, quantity, color, categoryID));
                }
            }
        } catch (Exception e) {
        }finally{
            closeConnection();
        }
        return list;
    }
    public int count(String search) throws SQLException {
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select count(*) from tblProducts where productName like ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return 0;
    }


    public ProductDTO getProductByID(String productID) {
        try {
            String sql = "SELECT [productID]\n"
                    + "      ,[productName]\n"
                    + "      ,[price]\n"
                    + "      ,[quantity]\n"
                    + "      ,[color]\n"
                    + "      ,[categoryID]\n"
                    + "  FROM [dbo].[tblProducts]\n"
                    + "  WHERE productID = ?";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, productID);
            rs = stm.executeQuery();
            if (rs.next()) {
                ProductDTO dto = new ProductDTO(rs.getString(1), 
                        rs.getString(2), 
                        rs.getDouble(3), 
                        rs.getInt(4), 
                        rs.getString(5), rs.getString(6));

                return dto;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
