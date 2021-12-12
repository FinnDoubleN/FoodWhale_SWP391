/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.FoodWhaleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class ChangePassword extends HttpServlet {
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
                    request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("login").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("login").forward(request, response);
            }
    } catch (SQLException ex) {
        Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
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
       try{   /* TODO output your page here. You may use following sample code. */
          FoodWhaleDAO dao = new FoodWhaleDAO();
            String submit = request.getParameter("submit");
            if (submit.equalsIgnoreCase("Submit")) {
                int id = Integer.parseInt(request.getParameter("uid"));
                String password = request.getParameter("Password");
                User u = new User(id, password);
                dao.changePassword(u);
                userdetail = dao.getUserByID(id);
                request.setAttribute("userdetail", userdetail);
                request.getRequestDispatcher("Profile.jsp").forward(request, response);
            }
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
