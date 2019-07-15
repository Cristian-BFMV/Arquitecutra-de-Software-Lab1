/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlet;

import com.udea.ejb.CartFacadeLocal;
import com.udea.ejb.VehicleFacadeLocal;
import com.udea.entity.Cart;
import com.udea.entity.Vehicle;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
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
 * @author osboxes
 */

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)

public class CartServlet extends HttpServlet {
    
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
                List<Cart> findAll= cartFacade.findAll();
                request.getSession().setAttribute("vehiclesCart", findAll);
                url="JSPS/shoppingCart.jsp";
            }              
             else if("insert".equals(action)){
                 
                 
                
                Cart v = new Cart();
                v.setLicense(request.getParameter("license"));
                v.setBrand(request.getParameter("brand"));
                v.setModel(request.getParameter("model"));
                v.setKm(Integer.parseInt(request.getParameter("km")));
                v.setPrice(Integer.parseInt(request.getParameter("price")));
                v.setState(request.getParameter("state"));
                cartFacade.create(v);
              
            } 
             else if("find".equals(action)){
                 Cart findC = cartFacade.find(request.getParameter("license"));
                 request.getSession().setAttribute("cart", findC);
                 url="JSPS/findVehicle.jsp";
            }
             else if("addVehicle".equals(action)){
                 
                 Vehicle findV = vehicleFacade.find(request.getParameter("license"));
                 
                 findV.setState("Carrito");
                 
                 vehicleFacade.edit(findV);
                 
                  Vehicle v = vehicleFacade.find(request.getParameter("license"));
                  Cart nuevo = new Cart();
                  nuevo.setLicense(v.getLicense());
                  nuevo.setBrand(v.getBrand());
                  nuevo.setModel(v.getModel());
                  nuevo.setKm(v.getKm());
                  nuevo.setPrice(v.getPrice());
                  nuevo.setState(v.getState());
                  cartFacade.create(nuevo);
            }
             else if ("delete".equals(action)){
                
                Cart v = cartFacade.find(request.getParameter("license"));
                 Vehicle findV = vehicleFacade.find(request.getParameter("license"));
                 findV.setState("Disponible");
                 vehicleFacade.edit(findV);
                cartFacade.remove(v);
                url="CartServlet?action=list";
            } 
            response.sendRedirect(url);
            
        } finally{
        out.close();
        }
      
    }

      public void storeImage(String aux, Part filePart, String imageName){
        File uploads = new File(aux + File.separator + "VehiclesImages");
                File file = new File(uploads, imageName);
                try (InputStream input = filePart.getInputStream()) {
                    Files.copy(input, file.toPath());
                } catch (Exception e) {
                    System.err.println("ERROR: " + e.getMessage());
                }
    }
    
    private String getExt(String nombreArchivo) {
        String extension = "";
        int i = nombreArchivo.lastIndexOf('.');
        if (i > 0) {
            extension = nombreArchivo.substring(i + 1);
        }
        return extension;
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
