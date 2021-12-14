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
import model.Recipe;

/**
 *
 * @author Asus
 */
public class RecipeListController extends HttpServlet {

    ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    Recipe recipelistdetail = new Recipe();

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
        Cookie[] cookies = request.getCookies();
        String role = getCookieByName(cookies, "ROLE");
        if (role == null || role.equalsIgnoreCase("user") || role.equalsIgnoreCase("")) {
            response.sendRedirect(request.getContextPath() + "/Homepage");
        } else if (role.equalsIgnoreCase("staff") || role.equalsIgnoreCase("admin")) {
            FoodWhaleDAO dao = new FoodWhaleDAO();
            recipeList = (ArrayList<Recipe>) dao.getRecipeWithCategory();
            request.setAttribute("recipeList", recipeList);
            request.getRequestDispatcher("/RecipeList.jsp").forward(request, response);
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
            int id = Integer.parseInt(request.getParameter("rID"));
            String submit = request.getParameter("submit");
            FoodWhaleDAO dao = new FoodWhaleDAO();
            if (submit.equalsIgnoreCase("View")) {
                int categorycount = dao.countCategoryRecipe();
                request.setAttribute("categorycount", categorycount);
                int usercount = dao.countUser();
                request.setAttribute("usercount", usercount);
                recipelistdetail = dao.getRecipeDetailByID(id);
                request.setAttribute("recipelistdetail", recipelistdetail);
                request.getRequestDispatcher("/RecipeListDetail.jsp").forward(request, response);

            } else if (submit.equalsIgnoreCase("Delete") || submit.equalsIgnoreCase("Active")) {
                String status = "";
                if (submit.equalsIgnoreCase("Delete")) {
                    status = "Delete";
                } else {
                    status = "Active";
                }
                Recipe r = new Recipe(id, status);
                dao.RecipeDelete(r);
                recipeList = (ArrayList<Recipe>) dao.getRecipeWithCategory();
                request.setAttribute("recipeList", recipeList);
                request.getRequestDispatcher("/RecipeList.jsp").forward(request, response);
            } else {
                recipeList = (ArrayList<Recipe>) dao.getRecipeWithCategory();
                request.setAttribute("recipeList", recipeList);
                request.getRequestDispatcher("/RecipeList.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(RecipeListController.class.getName()).log(Level.SEVERE, null, ex);
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
