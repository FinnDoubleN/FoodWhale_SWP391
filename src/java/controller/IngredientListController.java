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
import model.Ingredient;

/**
 *
 * @author Asus
 */
public class IngredientListController extends HttpServlet {

    ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
    Ingredient ingredientlistdetail = new Ingredient();

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
        Cookie[] cookies = request.getCookies();
        String role = getCookieByName(cookies, "ROLE");
        if (role == null || role.equalsIgnoreCase("user") || role.equalsIgnoreCase("")) {
            response.sendRedirect(request.getContextPath() + "/Homepage");
        } else if (role.equalsIgnoreCase("staff") || role.equalsIgnoreCase("admin")) {
            FoodWhaleDAO dao = new FoodWhaleDAO();
            ingredientList = (ArrayList<Ingredient>) dao.getIngredientWithCategory();
            request.setAttribute("ingredientList", ingredientList);
            request.getRequestDispatcher("/IngredientList.jsp").forward(request, response);
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
            int inID = Integer.parseInt(request.getParameter("inID"));
            String submit = request.getParameter("submit");
            FoodWhaleDAO dao = new FoodWhaleDAO();
            if (submit.equalsIgnoreCase("View")) {
                int categorycount = dao.countCategory();
            request.setAttribute("categorycount", categorycount);
                ingredientlistdetail = dao.getIngredientDetailByID(inID);
                request.setAttribute("ingredientlistdetail", ingredientlistdetail);
                request.getRequestDispatcher("/IngredientListDetail.jsp").forward(request, response);
            } else if (submit.equalsIgnoreCase("Delete") || submit.equalsIgnoreCase("Active")) {
                String status = "";
                if (submit.equalsIgnoreCase("Delete")) {
                    status = "Delete";
                } else {
                    status = "Active";
                }
                Ingredient in = new Ingredient(inID, status);
                dao.IngredientDelete(in);
                response.sendRedirect(request.getContextPath() + "/Dashboard/IngredientList");
            } else {
               response.sendRedirect(request.getContextPath() + "/Dashboard/IngredientList");
            }
        } catch (Exception ex) {
            Logger.getLogger(IngredientListController.class.getName()).log(Level.SEVERE, null, ex);
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
