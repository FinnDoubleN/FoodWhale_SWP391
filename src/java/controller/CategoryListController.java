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
import model.Category;

/**
 *
 * @author Asus
 */
public class CategoryListController extends HttpServlet {

    FoodWhaleDAO dao = new FoodWhaleDAO();
    ArrayList<Category> categoryList = new ArrayList<Category>();
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
        Cookie[] cookies = request.getCookies();
        String role = getCookieByName(cookies, "ROLE");
        if (role == null || role.equalsIgnoreCase("user") || role.equalsIgnoreCase("")) {
            response.sendRedirect(request.getContextPath() + "/Homepage");
        } else if (role.equalsIgnoreCase("staff") || role.equalsIgnoreCase("admin")) {

//            categoryList = (ArrayList<Category>) dao.getAllCategory();
//            request.setAttribute("categoryList", categoryList);
//            request.getRequestDispatcher("/CategoryList.jsp").forward(request, response);
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
            String id = request.getParameter("categoryID");
            String submitR = request.getParameter("submitR");
            String submitI = request.getParameter("submitI");
            String Recipe = request.getParameter("Recipe");
            String Ingredient = request.getParameter("Ingredient");
            if (Recipe != null && Recipe.equalsIgnoreCase("")) {
                categoryList = (ArrayList<Category>) dao.getAllCategoryRecipe();
                request.setAttribute("categoryList", categoryList);
                request.getRequestDispatcher("/CategoryRecipe.jsp").forward(request, response);
            } else if (Ingredient != null && Ingredient.equalsIgnoreCase("")) {
                categoryList = (ArrayList<Category>) dao.getAllCategoryIngredient();
                request.setAttribute("categoryList", categoryList);
                request.getRequestDispatcher("/CategoryIngredient.jsp").forward(request, response);
            }
            if (submitR != null && submitR.equalsIgnoreCase("View") || submitI != null && submitI.equalsIgnoreCase("View")) {
                if (submitR != null) {
                    categorylistdetail = dao.getCategoryRecipeByID(Integer.parseInt(id));
                    request.setAttribute("From", "Recipe");
                    request.setAttribute("categorylistdetail", categorylistdetail);
                    request.getRequestDispatcher("/CategoryListDetail.jsp").forward(request, response);
                } else if (submitI != null) {
                    categorylistdetail = dao.getCategoryIngredientByID(Integer.parseInt(id));
                    request.setAttribute("From", "Ingredient");
                    request.setAttribute("categorylistdetail", categorylistdetail);
                    request.getRequestDispatcher("/CategoryListDetail.jsp").forward(request, response);
                }
            }
            if (submitR != null && submitR.equalsIgnoreCase("Delete") || submitI != null && submitI.equalsIgnoreCase("Delete")) {
                String status = "Delete";
                Category c = new Category(Integer.parseInt(id), status);
                if (submitR != null) {
                    dao.CategoryRecipeDelete(c);
                    categoryList = (ArrayList<Category>) dao.getAllCategoryRecipe();
                    request.setAttribute("categoryList", categoryList);
                    request.getRequestDispatcher("/CategoryRecipe.jsp").forward(request, response);
                } else if (submitI != null) {
                    dao.CategoryIngredientDelete(c);
                    categoryList = (ArrayList<Category>) dao.getAllCategoryIngredient();
                    request.setAttribute("categoryList", categoryList);
                    request.getRequestDispatcher("/CategoryIngredient.jsp").forward(request, response);
                }
            } else {
                if (submitR != null) {
                    categoryList = (ArrayList<Category>) dao.getAllCategoryRecipe();
                    request.setAttribute("categoryList", categoryList);
                    request.getRequestDispatcher("/CategoryRecipe.jsp").forward(request, response);
                } else if (submitI != null) {
                    categoryList = (ArrayList<Category>) dao.getAllCategoryIngredient();
                    request.setAttribute("categoryList", categoryList);
                    request.getRequestDispatcher("/CategoryIngredient.jsp").forward(request, response);
                }
            }
            if (submitR != null && submitR.equalsIgnoreCase("Active") || submitI != null && submitI.equalsIgnoreCase("Active")) {
                String status = "Active";
                Category c = new Category(Integer.parseInt(id), status);
                if (submitR != null) {
                    dao.CategoryRecipeDelete(c);
                    categoryList = (ArrayList<Category>) dao.getAllCategoryRecipe();
                    request.setAttribute("categoryList", categoryList);
                    request.getRequestDispatcher("/CategoryRecipe.jsp").forward(request, response);
                } else if (submitI != null) {
                    dao.CategoryIngredientDelete(c);
                    categoryList = (ArrayList<Category>) dao.getAllCategoryIngredient();
                    request.setAttribute("categoryList", categoryList);
                    request.getRequestDispatcher("/CategoryIngredient.jsp").forward(request, response);
                }
            } else {
                if (submitR != null) {
                    categoryList = (ArrayList<Category>) dao.getAllCategoryRecipe();
                    request.setAttribute("categoryList", categoryList);
                    request.getRequestDispatcher("/CategoryRecipe.jsp").forward(request, response);
                } else if (submitI != null) {
                    categoryList = (ArrayList<Category>) dao.getAllCategoryIngredient();
                    request.setAttribute("categoryList", categoryList);
                    request.getRequestDispatcher("/CategoryIngredient.jsp").forward(request, response);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryListController.class.getName()).log(Level.SEVERE, null, ex);
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
