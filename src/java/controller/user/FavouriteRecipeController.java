/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dal.FoodWhaleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Recipe;
import model.Recipe_Like;
import model.User;

/**
 *
 * @author This PC
 */
public class FavouriteRecipeController extends HttpServlet {
    ArrayList<Recipe_Like> likelist = new ArrayList<>();
    FoodWhaleDAO DAO = new FoodWhaleDAO();
    User userdetail = new User();
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FavouriteRecipeController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FavouriteRecipeController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
                
                
            } else {
                response.sendRedirect("Login");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        likelist = DAO.getAllFavouriteRecipe(userdetail.uID);
        HashSet<Recipe> recipelist = new HashSet<>();
        for (Recipe_Like recipe_Like : likelist) {
            int i= recipe_Like.getrID();
            Recipe r = DAO.getRecipebyID(i);
            
            recipelist.add(r);  
           
        }
        request.setAttribute("recipelist", recipelist);
        request.getRequestDispatcher("FavouriteRecipe.jsp").forward(request, response);
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
        String rID= request.getParameter("rID");
        
        String username = getCookieByName(cookies, "USERNAME");
        try {
            userdetail = DAO.getProfileByUsername(username);
        } catch (SQLException ex) {
            Logger.getLogger(FavouriteRecipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        likelist = DAO.getAllFavouriteRecipe(userdetail.uID);
        if(!DAO.checkExistRecipe(Integer.parseInt(rID),userdetail.uID)){
            DAO.insertFavRecipe(Integer.parseInt(rID), userdetail.uID);
            
        }
        response.sendRedirect(request.getContextPath() + "/FavouriteRecipe");
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
