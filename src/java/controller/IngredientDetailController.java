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
public class IngredientDetailController extends HttpServlet {

    ArrayList<Ingredient> ingredientlist = new ArrayList<Ingredient>();
    FoodWhaleDAO DAO = new FoodWhaleDAO();

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
        String inID = request.getParameter("inID");
        String action = request.getParameter("action");
        String from = request.getParameter("from");
        if (action == null || action.equals("")) {
            if (inID != null || !inID.equals("")) {
                ingredientlist = DAO.getIngredientByID(Integer.parseInt(inID));
                request.setAttribute("ingredientlist", ingredientlist);
                request.getRequestDispatcher("/IngredientDetail.jsp").forward(request, response);
            } else {
                ingredientlist = DAO.getAllIngredient();
                request.setAttribute("ingredientlist", ingredientlist);
                request.getRequestDispatcher("Ingredient.jsp").forward(request, response);
            }
        } else {
            try {
                int oID = DAO.checkUserOrder(uName);
                if (oID == 0) {
                    User profile = DAO.getProfileByUsername(uName);
                    int uID = profile.getuID();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate localDate = LocalDate.now();
                    String date = dtf.format(localDate);
                    DAO.createOrder(uID, date);
                    oID++;
                    DAO.addToCart(oID, Integer.parseInt(inID));
                    if (from.equalsIgnoreCase("detail")) {
                        response.sendRedirect(request.getContextPath() + "/Ingredient");
                    } else {
                        response.sendRedirect(request.getContextPath());
                    }
                } else {
                    if (DAO.checkDuplicateIngredient(oID, Integer.parseInt(inID))) {
                        DAO.addQuantity(oID, Integer.parseInt(inID));
                    } else {
                        DAO.addToCart(oID, Integer.parseInt(inID));
                    }
                    if (from.equalsIgnoreCase("detail")) {
                        response.sendRedirect(request.getContextPath() + "/Ingredient");
                    } else {
                        response.sendRedirect(request.getContextPath());
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(IngredientDetailController.class.getName()).log(Level.SEVERE, null, ex);
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
