/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.UserDAO;
import dtos.SendMail;
import dtos.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class RegisterController extends HttpServlet {

    String user_email = "dominhtuan23102000@gmail.com";
    String pass_email = "dominhtuan";
    String SUB = "Here is your active code";

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "captcha.jsp";
    private static final String REGISTER = "register.jsp";

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
        String url = ERROR;
        try {
            String userID = request.getParameter("userID");
            String password = request.getParameter("password");
            String name = request.getParameter("name");

            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String email = request.getParameter("email");

            UserDAO dao = new UserDAO();
            UserDTO user = new UserDTO();

            UserDTO userEmail = dao.getUserByEmail(email);

            user.setUserID(userID);
            user.setPassword(password);
            user.setName(name);
            user.setRoleID("US");
            user.setPhone(phone);
            user.setAddress(address);
            user.setStatus("New");
            user.setEmail(email);

            Random rd = new Random();
            String root = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";
            String capcha = "";
            for (int i = 0; i < 5; i++) {
                int index = rd.nextInt(root.length() - 1);
                capcha = capcha + root.charAt(index);
            }
            user.setCaptcha(capcha);

            if (userEmail == null) {
                int count = dao.register(user);
                if (count > 0) {
                    request.getSession().setAttribute("LOGIN_USER", user);
                    url = SUCCESS;
                    SendMail.send(user.getEmail(), SUB, user.getCaptcha(), user_email, pass_email);
                } else {
                    url = ERROR;
                }

            } else {
                request.setAttribute("err", "Email allready existed");
                url = REGISTER;
            }

        } catch (Exception e) {
            log("ERROR at RegisterController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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
