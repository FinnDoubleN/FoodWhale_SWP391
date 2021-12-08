/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.FoodWhaleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * @author Asus
 */
public class AccountListController extends HttpServlet {

    ArrayList<User> userlist = new ArrayList<User>();
    User userdetail = new User();

    private String getCookieByName(Cookie[] cookies, String name) {
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase(name)) {
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
            throws ServletException, IOException {
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
        Cookie[] cookies = request.getCookies();
        String role = getCookieByName(cookies, "ROLE");
        if (role == null || role.equalsIgnoreCase("user") || role.equalsIgnoreCase("")) {
            response.sendRedirect(request.getContextPath() + "/Homepage");
        } else if (role.equalsIgnoreCase("staff")) {
            FoodWhaleDAO dao = new FoodWhaleDAO();
            userlist = (ArrayList<User>) dao.getAllCustomer();
            request.setAttribute("userlist", userlist);
            request.getRequestDispatcher("/AccountList.jsp").forward(request, response);
        } else if (role.equalsIgnoreCase("admin")) {
            FoodWhaleDAO dao = new FoodWhaleDAO();
            userlist = (ArrayList<User>) dao.getAllAccount();
            request.setAttribute("userlist", userlist);
            request.getRequestDispatcher("/AccountList.jsp").forward(request, response);
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
            int id = Integer.parseInt(request.getParameter("uID"));
            String submit = request.getParameter("submit");
            FoodWhaleDAO dao = new FoodWhaleDAO();
            if (submit.equalsIgnoreCase("View")) {
                userdetail = dao.getUserByID(id);
                request.setAttribute("userdetail", userdetail);
                request.getRequestDispatcher("/AccountDetail.jsp").forward(request, response);
            } else if (submit.equalsIgnoreCase("Delete")) {
                String status = "Delete";
                User u = new User(id, status);
                dao.updateStatus(u);
                userlist = (ArrayList<User>) dao.getAllAccount();
                request.setAttribute("userlist", userlist);
                request.getRequestDispatcher("/AccountList.jsp").forward(request, response);
            } else {
                userlist = (ArrayList<User>) dao.getAllAccount();
                request.setAttribute("userlist", userlist);
                request.getRequestDispatcher("/AccountList.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDetailController.class.getName()).log(Level.SEVERE, null, ex);
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
