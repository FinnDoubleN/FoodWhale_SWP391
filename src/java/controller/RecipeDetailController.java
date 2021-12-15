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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ingredient;
import model.Recipe;
import model.User;

/**
 *
 * @author Asus
 */
public class RecipeDetailController extends HttpServlet {

    ArrayList<Recipe> recipelist = new ArrayList<Recipe>();
    ArrayList<Ingredient> ingredientlist = new ArrayList<Ingredient>();
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
        Cookie[] cookies = request.getCookies();
        String uName = getCookieByName(cookies, "USERNAME");
        String recID = request.getParameter("recID");
        String action = request.getParameter("action");
        String from = request.getParameter("from");
        if (action == null) {
            if (recID != null) {
                recipelist = DAO.getRecipeByID(Integer.parseInt(recID));
                ingredientlist = DAO.getIngredientByRecipeId(Integer.parseInt(recID));
                request.setAttribute("recipelist", recipelist);
                request.setAttribute("ingredientlist", ingredientlist);
                request.getRequestDispatcher("/RecipeDetail.jsp").forward(request, response);
            } else {
                recipelist = DAO.getAllRecipe();
                request.setAttribute("recipelist", recipelist);
                request.getRequestDispatcher("Recipe.jsp").forward(request, response);
            }
        } else {
            try {
                int oID = DAO.checkUserOrder(uName);
                ArrayList<Ingredient> ingredient = DAO.getIngredientByRecipeId(Integer.parseInt(recID));
                if (oID == 0) {
                    User profile = DAO.getProfileByUsername(uName);
                    int uID = profile.getuID();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate localDate = LocalDate.now();
                    String date = dtf.format(localDate);
                    DAO.createOrder(uID, date);
                    oID++;
                    for (Ingredient in : ingredient) {
                        DAO.addToCart(oID, in.getInID());
                    }
                    if (from.equalsIgnoreCase("detail")) {
                        if (action.equalsIgnoreCase("add")) {
                            response.sendRedirect(request.getContextPath() + "/Recipe");
                        } else {
                            response.sendRedirect(request.getContextPath() + "/Cart");
                        }
                    } else {
                        response.sendRedirect(request.getContextPath());
                    }
                } else {
                    for (Ingredient in : ingredient) {
                        if (DAO.checkDuplicateIngredient(oID, in.getInID())) {
                            DAO.addQuantity(oID, in.getInID());
                        } else {
                            DAO.addToCart(oID, in.getInID());
                        }
                    }
                    if (from.equalsIgnoreCase("detail")) {
                        if (action.equalsIgnoreCase("add")) {
                            response.sendRedirect(request.getContextPath() + "/Recipe");
                        } else {
                            response.sendRedirect(request.getContextPath() + "/Cart");
                        }
                    } else {
                        response.sendRedirect(request.getContextPath());
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(RecipeDetailController.class.getName()).log(Level.SEVERE, null, ex);
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
