/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlet;

import com.udea.ejb.BillFacadeLocal;
import com.udea.ejb.CartFacadeLocal;
import com.udea.ejb.VehicleFacadeLocal;
import com.udea.entity.Bill;
import com.udea.entity.Cart;
import com.udea.entity.Vehicle;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author User
 */
public class BillServlet extends HttpServlet {

    @EJB
    private BillFacadeLocal billFacade;
    
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
            String url ="JSPS/index.jsp";
            if("list".equals(action)){
                List<Bill> findAll= billFacade.findAll();
                request.getSession().setAttribute("bills", findAll); //Lista?
                url="JSPS/listBills.jsp";
            }            
              else if("buy".equals(action)){
                 
                Bill b = new Bill();
                
                b.setCustomerDocumentNumber(request.getSession().getAttribute("login").toString());  
                b.setVehiclesLicenses(getVehiclesInCart());
                b.setTotal(getTotal());
                
                billFacade.create(b);
                changeStatusInVehicles();
                deleteVehiclesInCart();
                
                
                url="VehicleServlet?action=list";
      
                     
            } 
            
            
             
            
            response.sendRedirect(url);
            
        } finally{
        out.close();
        }
      
    }
    
    private String getVehiclesInCart(){
        String licenses = "";
        List<Cart> findAll= cartFacade.findAll();
        
        for(int i=0; i<findAll.size();i++){
            licenses = licenses + "  {" + findAll.get(i).getLicense() + " = " + String.valueOf(findAll.get(i).getPrice()) + " }";
            
        }
            
        return licenses;
    }
    
    private int getTotal(){
        int total=0;
        List<Cart> findAll= cartFacade.findAll();
        
        for(int i=0; i<findAll.size();i++){
            total = total + findAll.get(i).getPrice();
        }
        
        return total;
        
    }
    
    private void changeStatusInVehicles(){
        
        List<Cart> findAll= cartFacade.findAll();
        
        for(int i=0; i<findAll.size();i++){
            Vehicle findV = vehicleFacade.find(findAll.get(i).getLicense());
            findV.setState("Vendido");
            vehicleFacade.edit(findV);
        }
    }
    
    private void deleteVehiclesInCart(){
        List<Cart> findAll= cartFacade.findAll();
        
        for(int i=0; i<findAll.size();i++){
            Cart findV = cartFacade.find(findAll.get(i).getLicense());
            cartFacade.remove(findV);
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
