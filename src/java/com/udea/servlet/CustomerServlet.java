/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlet;

import com.udea.ejb.CartFacadeLocal;
import com.udea.ejb.CustomerFacadeLocal;
import com.udea.ejb.VehicleFacadeLocal;
import com.udea.entity.Customer;
import com.udea.entity.Vehicle;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author camiloa.mejia
 */

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)


public class CustomerServlet extends HttpServlet {

    @EJB
    private CustomerFacadeLocal customerFacade;
    
    @EJB
    private CartFacadeLocal cartFacade;
    
     @EJB
    private VehicleFacadeLocal vehicleFacade;
    
    
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
        PrintWriter out = response.getWriter();
        String aux = getServletContext().getRealPath("/");
       
        try{
            String action = request.getParameter("action");
            String url ="JSPS/indexUser.jsp";
                       
             if("register".equals(action)){
                 
                 Customer c = new Customer();
                c.setDocumentNumber(request.getParameter("documentNumber"));
                c.setName(request.getParameter("name"));
                c.setEmail(request.getParameter("email"));
                c.setPassword(request.getParameter("password"));
               
                 customerFacade.create(c);
                          
            } 
             else if("login".equals(action)){
            
                  String id = request.getParameter("documentNumber");
                  String p = request.getParameter("password");
                  
                  if(id.equalsIgnoreCase("admin") && p.equalsIgnoreCase("admin")){
                      int rol = 1;                      
                      request.getSession().setAttribute("rol", rol);                      
                      url="JSPS/index.jsp";                       
                  }
                   else{
                  
                  boolean checklogin = customerFacade.checkLogin(id, p);
                  
                   if(checklogin){
                      request.getSession().setAttribute("login", id);
                      String available = "Disponible";
                      List<Vehicle> findAll= vehicleFacade.availablesVehicles(available);
                      request.getSession().setAttribute("vehicles", findAll);
                      int rol = 0;                      
                      request.getSession().setAttribute("rol", rol);  
                      url="JSPS/listVehicles.jsp";
                  }
                   
                   else{
                      url= "JSPS/login.jsp?error=1";
                     
                  }
                }
            }
             
             else if("logout".equals(action)){
                 request.getSession().removeAttribute("login");
                 url= "JSPS/indexUser.jsp";
             }
          
            response.sendRedirect(url);
            
        } finally{
        out.close();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
