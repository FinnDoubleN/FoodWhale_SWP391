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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Recipe;
import model.User;

/**
 *
 * @author This PC
 */
public class PostRecipeController extends HttpServlet {
    
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
        FoodWhaleDAO dao = new FoodWhaleDAO();
        ArrayList<Category> catelist = dao.getAllCategoryRecipe();
        request.setAttribute("catelist", catelist);
       Cookie[] cookies = request.getCookies();
        String role = getCookieByName(cookies, "ROLE");
        if (role == null ||  role.equalsIgnoreCase("")) {
            response.sendRedirect(request.getContextPath()+"/Homepage");
        } else if (role.equalsIgnoreCase("staff") || role.equalsIgnoreCase("admin")|| role.equalsIgnoreCase("user")) {
            request.getRequestDispatcher("/PostRecipe.jsp").forward(request, response);
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
        FoodWhaleDAO dao = new FoodWhaleDAO();
        
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
                
                
        String name = request.getParameter("rname");
        String image = request.getParameter("rimage");
        int cate = Integer.parseInt(request.getParameter("rcate"));
        int user = userdetail.uID;
        String diff = request.getParameter("rdiff");
        int time = Integer.parseInt(request.getParameter("rtime")) ;
        String des = request.getParameter("rdes");
        String gui = request.getParameter("rgui");
//        dao.createUser(email, password, username, image, startDate, gender, address, phone, role);
//        userlist = (ArrayList<User>) dao.getAllAccount();
//        request.setAttribute("userlist", userlist);
        Recipe recipe = new Recipe(name,cate,image,diff,time,user,des,gui);
        dao.addRecipe(recipe);
        request.getRequestDispatcher("/Recipe").forward(request, response);
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
