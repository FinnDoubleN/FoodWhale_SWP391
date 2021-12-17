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
import model.Order;
import model.Order_Detail;

/**
 *
 * @author ADMIN
 */
public class OrderDetailController extends HttpServlet {

    FoodWhaleDAO dao = new FoodWhaleDAO();
    ArrayList<Order> orderlist = new ArrayList<Order>();
    ArrayList<Order_Detail> orderlistdetail = new ArrayList<Order_Detail>();
    Order order = new Order();

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
            if (role == null || role.equalsIgnoreCase("user") || role.equalsIgnoreCase("")) {
                response.sendRedirect(request.getContextPath() + "/Homepage");
            } else if (role.equalsIgnoreCase("staff") || role.equalsIgnoreCase("admin")) {
                int id = Integer.parseInt(request.getParameter("id"));
                FoodWhaleDAO dao = new FoodWhaleDAO();
                order = dao.getOrderByID(id);
                orderlistdetail = dao.getUserCart(id);
                request.setAttribute("order", order);
                request.setAttribute("orderlistdetail", orderlistdetail);
                request.getRequestDispatcher("/OrderDetail.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDetailController.class.getName()).log(Level.SEVERE, null, ex);
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
            int oID = Integer.parseInt(request.getParameter("oid"));
            int inID = Integer.parseInt(request.getParameter("inID"));
            String fullname = request.getParameter("fullname");
            String date = request.getParameter("date");
            Date startDate = Date.valueOf(date);
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String note = request.getParameter("note");
            double total = Double.parseDouble(request.getParameter("total"));
            String status = request.getParameter("status");
            if (submit.equalsIgnoreCase("Approved")) {
                status = "Approved";
                Order o = new Order(oID, status);
                dao.OrderDelete(o);
            } else if (submit.equalsIgnoreCase("Denied")) {
                status = "Denied";
                Order o = new Order(oID, status);
                dao.OrderDelete(o);
            } else if (submit.equalsIgnoreCase("Delete")){
                dao.deleteIngredient(oID, oID);
            } else if (submit.equalsIgnoreCase("Update")){
                Order o = new Order(oID, fullname, address, phone,startDate, total, note, status);
                dao.updateOrder(o);
            }
            ArrayList<Order_Detail> orderlistdetail = dao.getUserCart(oID);
            request.setAttribute("orderlistdetail", orderlistdetail);
            order = dao.getOrderByID(oID);
            request.setAttribute("order", order);
            request.getRequestDispatcher("/OrderDetail.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(OrderDetailController.class.getName()).log(Level.SEVERE, null, ex);
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
