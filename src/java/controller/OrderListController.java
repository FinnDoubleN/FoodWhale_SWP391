package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.Order;
import model.Order_Detail;

/**
 *
 * @author Asus
 */
public class OrderListController extends HttpServlet {

    FoodWhaleDAO dao = new FoodWhaleDAO();
    ArrayList<Order> orderlist = new ArrayList<Order>();
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
        Cookie[] cookies = request.getCookies();
        String role = getCookieByName(cookies, "ROLE");
        if (role == null || role.equalsIgnoreCase("user") || role.equalsIgnoreCase("")) {
            response.sendRedirect(request.getContextPath() + "/Homepage");
        } else if (role.equalsIgnoreCase("staff") || role.equalsIgnoreCase("admin")) {
            orderlist = (ArrayList<Order>) dao.getAllOrder();
            request.setAttribute("orderlist", orderlist);
            request.getRequestDispatcher("/OrderList.jsp").forward(request, response);
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
            int oID = Integer.parseInt(request.getParameter("oID"));
            String submit = request.getParameter("submit");
            if (submit.equalsIgnoreCase("View")) {
                ArrayList<Order_Detail> orderlistdetail = dao.getUserCart(oID);
                request.setAttribute("orderlistdetail", orderlistdetail);
                order = dao.getOrderByID(oID);
                request.setAttribute("order", order);
                request.getRequestDispatcher("/OrderDetail.jsp").forward(request, response);
            } else if (submit.equalsIgnoreCase("Denied") || submit.equalsIgnoreCase("Approved")) {
                String status = "";
                if (submit.equalsIgnoreCase("Denied")) {
                    status = "Denied";
                } else {
                    status = "Approved";
                }
                Order o = new Order(oID, status);
                dao.OrderDelete(o);
                response.sendRedirect(request.getContextPath() + "/Dashboard/OrderList");
            } else {
                response.sendRedirect(request.getContextPath() + "/Dashboard/OrderList");
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderListController.class.getName()).log(Level.SEVERE, null, ex);
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
