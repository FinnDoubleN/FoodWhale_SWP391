/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.FoodWhaleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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

/**
 *
 * @author ADMIN
 */
public class RecipeListDetailController extends HttpServlet {

    FoodWhaleDAO dao = new FoodWhaleDAO();
    Recipe recipelistdetail = new Recipe();
    ArrayList<Ingredient> ingreByrec = new ArrayList<>();
    ArrayList<Ingredient> ingredient = new ArrayList<>();

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
            int categorycount = dao.countCategoryRecipe();
            request.setAttribute("categorycount", categorycount);
            int usercount = dao.countUser();
            request.setAttribute("usercount", usercount);
            if (role == null || role.equalsIgnoreCase("user") || role.equalsIgnoreCase("")) {
                response.sendRedirect(request.getContextPath() + "/Homepage");
            } else if (role.equalsIgnoreCase("staff") || role.equalsIgnoreCase("admin")) {
                int id = Integer.parseInt(request.getParameter("rID"));
                FoodWhaleDAO dao = new FoodWhaleDAO();
                recipelistdetail = dao.getRecipeDetailByID(id);
                request.setAttribute("recipelistdetail", recipelistdetail);
                request.getRequestDispatcher("/RecipeListDetail.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(RecipeListDetailController.class.getName()).log(Level.SEVERE, null, ex);
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
            String submit = request.getParameter("submit");
            String inID[] = request.getParameterValues("inID");
            if (submit.equalsIgnoreCase("Update")) {
                int rid = Integer.parseInt(request.getParameter("rID"));
                String image = request.getParameter("image");
                String rName = request.getParameter("rName");
                int cID = Integer.parseInt(request.getParameter("cID"));
                String Difficulty = request.getParameter("Difficulty");
                int Time = Integer.parseInt(request.getParameter("Time"));
                int uID = Integer.parseInt(request.getParameter("uID"));
                String Description = request.getParameter("Description");
                String Guideline = request.getParameter("Guideline");
                String Status = request.getParameter("Status");
                Recipe r = new Recipe(rid, rName, cID, image, Difficulty, Time, uID, Description, Guideline, Status);
                dao.updateRecipe(r);
                dao.deleteIngredientRecipe(rid);
                for (int i = 0; i < inID.length; i++) {
                    dao.addIngredientRecipe(rid, Integer.parseInt(inID[i]));
                }
                ingreByrec = dao.getIngredientByRecipeId(rid);
                request.setAttribute("ingreByrec", ingreByrec);
                ingredient = dao.getIngredientList();
                request.setAttribute("ingredient", ingredient);
                int categorycount = dao.countCategoryRecipe();
                request.setAttribute("categorycount", categorycount);
                int usercount = dao.countUser();
                request.setAttribute("usercount", usercount);
                recipelistdetail = dao.getRecipeDetailByID(rid);
                request.setAttribute("recipelistdetail", recipelistdetail);
                request.getRequestDispatcher("/RecipeListDetail.jsp").forward(request, response);
            } else if (submit.equalsIgnoreCase("Delete") || submit.equalsIgnoreCase("Active")) {
                int rid = Integer.parseInt(request.getParameter("rID"));
                String status = "";
                if (submit.equalsIgnoreCase("Delete")) {
                    status = "Delete";
                } else {
                    status = "Active";
                }
                Recipe r = new Recipe(rid, status);
                dao.RecipeDelete(r);
                response.sendRedirect(request.getContextPath() + "/Dashboard/RecipeList");
            }
        } catch (Exception ex) {
            Logger.getLogger(RecipeListDetailController.class.getName()).log(Level.SEVERE, null, ex);
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
