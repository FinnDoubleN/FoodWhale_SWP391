/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.FoodWhaleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;

/**
 *
 * @author ADMIN
 */
public class CategoryListDetailController extends HttpServlet {

    Category categorylistdetail = new Category();

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
        try {
            Cookie[] cookies = request.getCookies();
            String role = getCookieByName(cookies, "ROLE");
            if (role == null || role.equalsIgnoreCase("user") || role.equalsIgnoreCase("")) {
                response.sendRedirect(request.getContextPath() + "/Homepage");
            } else if (role.equalsIgnoreCase("staff") || role.equalsIgnoreCase("admin")) {
                int id = Integer.parseInt(request.getParameter("inID"));
                FoodWhaleDAO dao = new FoodWhaleDAO();
                categorylistdetail = dao.getCategoryDetailByID(id);
                request.setAttribute("categorylistdetail", categorylistdetail);
                request.getRequestDispatcher("/CategoryListDetail.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryListDetailController.class.getName()).log(Level.SEVERE, null, ex);
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
            Cookie[] cookies = request.getCookies();
            String ROLE = getCookieByName(cookies, "ROLE");
            FoodWhaleDAO dao = new FoodWhaleDAO();
            String submit = request.getParameter("submit");
            if (submit.equalsIgnoreCase("Update")) {
                int categoryID = Integer.parseInt(request.getParameter("categoryID"));
                String cName = request.getParameter("cName");
                String Status = request.getParameter("status");
                Category c = new Category(categoryID, cName, Status);
                dao.updateCategory(c);
                categorylistdetail = dao.getCategoryDetailByID(categoryID);
                request.setAttribute("categorylistdetail", categorylistdetail);
                request.getRequestDispatcher("/CategoryListDetail.jsp").forward(request, response);
            } else if (submit.equalsIgnoreCase("Delete") || submit.equalsIgnoreCase("Active")) {
                int categoryID = Integer.parseInt(request.getParameter("categoryID"));
                String status = "";
                if (submit.equalsIgnoreCase("Delete")) {
                    status = "Delete";
                } else {
                    status = "Active";
                }
                Category c = new Category(categoryID, status);
                //dao.CategoryDelete(c);
                response.sendRedirect(request.getContextPath() + "/Dashboard/CategoryList");
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryListDetailController.class.getName()).log(Level.SEVERE, null, ex);
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
