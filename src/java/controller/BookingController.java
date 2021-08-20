/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.BookingDAO;
import daos.ProductDAO;
import dtos.BookingDTO;
import dtos.ProductDTO;
import dtos.UserDTO;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class BookingController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "GetListAllProduct";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            UserDTO user = (UserDTO) request.getSession().getAttribute("LOGIN_USER");
            String userID = user.getUserID();
            
            String productID = request.getParameter("productID");
            String duration = request.getParameter("duration");

//            DateFormat df = new SimpleDateFormat("dd/MM/yyy");
//            java.util.Date bbDate = df.parse(dateback);;
//            java.sql.Date bDate = new java.sql.Date(bbDate.getTime());

//            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//            String date = formatter.format(duration);
            
            ProductDAO dao = new ProductDAO();
            ProductDTO product = dao.getProductByID(productID);
            BookingDAO bookingDAO = new BookingDAO();

            BookingDTO bookingDTO = new BookingDTO();

            bookingDTO.setDuration(duration);
            bookingDTO.setTotalPrice(product.getPrice());
            bookingDTO.setUserID(userID);

            boolean add = bookingDAO.addBooking(bookingDTO);
            url = SUCCESS;
        } catch (Exception e) {
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
