/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dal.FoodWhaleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author ADMIN
 */
public class EditProfileController extends HttpServlet {

    User userdetail = new User();

    private String getCookieByName(Cookie[] cookies, String check) {
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(check)) {
                return cookie.getValue();
            }
        }
        return null;
    }

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

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
        try {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                String role = getCookieByName(cookies, "ROLE");
                String username = getCookieByName(cookies, "USERNAME");
                if (username != null && !role.equals("admin")) {
                    FoodWhaleDAO DAO = new FoodWhaleDAO();
                    userdetail = DAO.getProfileByUsername(username);
                    request.setAttribute("userdetail", userdetail);
                    request.getRequestDispatcher("Profile.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("login").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("login").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat sd = new SimpleDateFormat(pattern);
        try {
            FoodWhaleDAO dao = new FoodWhaleDAO();
            int id = Integer.parseInt(request.getParameter("uid"));
            String image = request.getParameter("image");
            String email = request.getParameter("email");

            String dateUser = request.getParameter("date");
            Date date = sd.parse(dateUser);
            String username = request.getParameter("username");
            String gender = request.getParameter("gender");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            User u = new User(id, email, username, image, java.sql.Date.valueOf(dateUser), gender, address, phone);
            dao.EditUser(u);
            userdetail = dao.getUserByID(id);
            request.setAttribute("userdetail", userdetail);
            request.getRequestDispatcher("/Profile.jsp").forward(request, response);
//            request.getRequestDispatcher("Profile").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(EditProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
