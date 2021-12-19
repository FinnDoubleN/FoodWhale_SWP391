/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import dal.FoodWhaleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class AddIngredientController extends HttpServlet {

    FoodWhaleDAO dao = new FoodWhaleDAO();
    ArrayList<Category> ingrecate = new ArrayList<>();

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
        int categorycount = dao.countCategoryIngredient();
        request.setAttribute("categorycount", categorycount);
        if (role == null || role.equalsIgnoreCase("user") || role.equalsIgnoreCase("")) {
            response.sendRedirect(request.getContextPath() + "/Homepage");
        } else if (role.equalsIgnoreCase("staff") || role.equalsIgnoreCase("admin")) {
            ingrecate = dao.getAllCategoryIngredient();
            request.setAttribute("ingrecate", ingrecate);
            request.getRequestDispatcher("/AddIngredient.jsp").forward(request, response);
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
        String image = request.getParameter("image");
        String inName = request.getParameter("inName");
        int cID = Integer.parseInt(request.getParameter("cID"));
        String Type = request.getParameter("Type");
        double Price = Double.parseDouble(request.getParameter("Money"));
        String Description = request.getParameter("Description");
        String Guideline = request.getParameter("Guideline");
        if (image == null || image.equalsIgnoreCase("")) {
            image = "https://media.istockphoto.com/vectors/profile-placeholder-image-gray-silhouette-no-photo-vector-id1016744004?b=1&k=20&m=1016744004&s=612x612&w=0&h=lsnLrde_RztsCmr0SyYMOxj8JqzF8qvDmPDWWILR1ys=";
        }
        dao.createIngredient(inName, image, Type, Price, cID, Description, Guideline);
        response.sendRedirect(request.getContextPath() + "/Dashboard/IngredientList");
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
