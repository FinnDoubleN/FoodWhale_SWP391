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
public class IngredientController extends HttpServlet {

    ArrayList<Ingredient> ingredientlist = new ArrayList<>();
    Ingredient ingredient = new Ingredient();
    FoodWhaleDAO DAO = new FoodWhaleDAO();

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
        ingredientlist = DAO.getAllIngredient();
        request.setAttribute("ingredientlist", ingredientlist);
        request.getRequestDispatcher("Ingredient.jsp").forward(request, response);
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
        String searchData = request.getParameter("searchData");
        String option = request.getParameter("option");
        request.setAttribute("searchData", searchData);
        request.setAttribute("option", option);
        if (searchData == null || searchData.equalsIgnoreCase("") || option == null || option.equalsIgnoreCase("")) {
            ingredientlist = DAO.getAllIngredient();
            request.setAttribute("ingredientlist", ingredientlist);
            request.getRequestDispatcher("Ingredient.jsp").forward(request, response);
        } else {
            if (option.equalsIgnoreCase("byRecipe")) {
                ingredientlist = DAO.searchIngredientByRecipe(searchData);
                request.setAttribute("ingredientlist", ingredientlist);
                request.getRequestDispatcher("Ingredient.jsp").forward(request, response);
            } else if (option.equalsIgnoreCase("byIngredient")) {
                ingredientlist = DAO.searchIngredientByIngredient(searchData);
                request.setAttribute("ingredientlist", ingredientlist);
                request.getRequestDispatcher("Ingredient.jsp").forward(request, response);
            }
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
