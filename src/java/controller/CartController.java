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
import model.Order_Detail;
import model.Recipe;
import model.User;

/**
 *
 * @author Asus
 */
public class CartController extends HttpServlet {

    ArrayList<Recipe> recipe = new ArrayList<>();
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
            String username = getCookieByName(cookies, "USERNAME");
            FoodWhaleDAO dao = new FoodWhaleDAO();
            if (role != null && !role.equalsIgnoreCase("") || username != null && !username.equalsIgnoreCase("")) {
                int oID = dao.checkUserOrder(username);
                ArrayList<Order_Detail> orderdetail = dao.getUserCart(oID);
                request.setAttribute("orderdetail", orderdetail);
                request.getRequestDispatcher("Cart.jsp").forward(request, response);
            } else {
                response.sendRedirect("Login");
            }
        } catch (IOException | ServletException ex) {
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
            FoodWhaleDAO dao = new FoodWhaleDAO();
            Cookie[] cookies = request.getCookies();
            String username = getCookieByName(cookies, "USERNAME");
            String action = request.getParameter("action");
            String total = request.getParameter("total");
            int oID = dao.checkUserOrder(username);
            String inID = request.getParameter("inID");
            User user = dao.getProfileByUsername(username);
            if (action != null) {
                if (action.equalsIgnoreCase("up")) {
                    dao.addQuantity(oID, Integer.parseInt(inID));
                    dao.updateTotal(oID, Integer.parseInt(total));
                } else if (action.equalsIgnoreCase("down")) {
                    dao.minusQuantity(oID, Integer.parseInt(inID));
                    dao.updateTotal(oID, Integer.parseInt(total));
                } else if (action.equalsIgnoreCase("delete")) {
                    dao.deleteIngredient(oID, Integer.parseInt(inID));
                } else if (action.equalsIgnoreCase("buy")) {
                    dao.updateTotal(oID, Integer.parseInt(total));
                    if (dao.checkOrderEmpty(oID)) {
                        try (PrintWriter out = response.getWriter()) {
                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('There is nothing to buy :(');");
                            out.println("location='"+request.getContextPath() +"/Cart';");
                            out.println("</script>");
                        }
                    } else {
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate localDate = LocalDate.now();
                        String date = dtf.format(localDate);
                        dao.updateOrderStatus(oID);
                        dao.createOrder(user.getuID(), date);
                        response.sendRedirect(request.getContextPath() + "/Cart");
                    }
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/Cart");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
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
