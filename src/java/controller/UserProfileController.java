/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.Cookie;
import dal.FoodWhaleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Order;
import model.Order_Detail;
import model.User;

/**
 *
 * @author ADMIN
 */
public class UserProfileController extends HttpServlet {

    User userdetail = new User();
    ArrayList<Order> orderdetail = new ArrayList<>();

    private String getCookieByName(Cookie[] cookies, String check) {
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase(check)) {
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
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            String role = getCookieByName(cookies, "ROLE");
            String username = getCookieByName(cookies, "USERNAME");
            if (role != null && !role.equalsIgnoreCase("") || username != null && !username.equalsIgnoreCase("")) {
                FoodWhaleDAO DAO = new FoodWhaleDAO();
                userdetail = DAO.getProfileByUsername(username);
                orderdetail = (ArrayList<Order>) DAO.getAllOrderbyUser(userdetail.uID);
                request.setAttribute("orderdetail", orderdetail);
                request.setAttribute("userdetail", userdetail);
                request.getRequestDispatcher("Profile.jsp").forward(request, response);
            } else {
                response.sendRedirect("Login");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            FoodWhaleDAO dao = new FoodWhaleDAO();
            String action = request.getParameter("Action");
            String username = request.getParameter("username");
            if (action != null && action.equalsIgnoreCase("Update")) {
                int id = Integer.parseInt(request.getParameter("uID"));
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String fullname = request.getParameter("fullname");
                String address = request.getParameter("address");
                String gender = request.getParameter("gender");
                String date = request.getParameter("date");
                Date startDate = Date.valueOf(date);
                User u = new User(id, email, username, fullname, startDate, gender, address, phone);
                dao.updateUserProfile(u);
                userdetail = dao.getProfileByUsername(username);
                orderdetail = (ArrayList<Order>) dao.getAllOrderbyUser(userdetail.uID);
                request.setAttribute("orderdetail", orderdetail);
                request.setAttribute("userdetail", userdetail);
                request.getRequestDispatcher("Profile.jsp").forward(request, response);
            }
            if (action != null && action.equalsIgnoreCase("ChangePW")) {
                String newPass = request.getParameter("newPass");
                String confirmPass = request.getParameter("confirmPass");
                if (newPass != null && confirmPass != null) {
                    if (newPass.equals(confirmPass)) {
                        dao.updatePassword(newPass, username);
                    }
                }
                userdetail = dao.getProfileByUsername(username);
                orderdetail = (ArrayList<Order>) dao.getAllOrderbyUser(userdetail.uID);
                request.setAttribute("orderdetail", orderdetail);
                request.setAttribute("userdetail", userdetail);
                request.getRequestDispatcher("Profile.jsp").forward(request, response);
            }
            if (action != null && action.equalsIgnoreCase("checkPW")) {
                String password = request.getParameter("curr");
                User u = dao.getProfileByUsername(username);
                if (password.equals(u.getPassword())) {
                    response.setContentType("text/html;charset=UTF-8");
                    response.getWriter().write("Success");
                } else {
                    response.setContentType("text/html;charset=UTF-8");
                    response.getWriter().write("Error");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
