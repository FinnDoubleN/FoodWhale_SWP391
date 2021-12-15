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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author This PC
 */
public class RegisterController extends HttpServlet {

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
        request.getRequestDispatcher("Register.jsp").forward(request, response);
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
        HttpSession session = request.getSession();       
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        String gender = request.getParameter("gender");
        if (gender == null) {
            gender = "";
        }
        String phonenumber = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        String image= request.getParameter("image");
        String address = request.getParameter("address");
        String dob = request.getParameter("age");
        if (!password.equalsIgnoreCase(confirm)) {
            request.setAttribute("mess1", "password khong khop");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else {
            User c = dao.CheckExistCustomer(username);
            if (c == null) {
                User cus = new User(  email, password, username,image, Date.valueOf(dob), gender, address, phonenumber);
                session.setAttribute("tempCus", cus);
                String code = dao.RanCode();
                dao.send(email, dao.RegisterNoti(), code);
                request.setAttribute(email, "email");
                session.setAttribute("code", code);
                request.getRequestDispatcher("enterCode.jsp").forward(request, response);
            } else {
                request.setAttribute("mess2", "Canh bao: username existed");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
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
