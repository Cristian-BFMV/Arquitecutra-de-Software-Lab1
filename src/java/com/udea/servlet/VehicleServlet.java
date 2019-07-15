/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlet;

import com.udea.ejb.VehicleFacadeLocal;
import com.udea.entity.Vehicle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;

/**
 *
 * @author User
 */


@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)

public class VehicleServlet extends HttpServlet {

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
                String available = "Disponible";
                List<Vehicle> findAll= vehicleFacade.availablesVehicles(available);
                request.getSession().setAttribute("vehicles", findAll); //Lista?
                url="JSPS/listVehicles.jsp";
            }              
             else if("insert".equals(action)){
                 
                
                Part filePart = request.getPart("image");
                String imageName = request.getParameter("license") + "." + getExt(Paths.get(filePart.getSubmittedFileName()).getFileName().toString());
                
                
                storeImage(aux, filePart, imageName);
    
                
                Vehicle v = new Vehicle();
                v.setImage(imageName);
                v.setLicense(request.getParameter("license"));
                v.setBrand(request.getParameter("brand"));
                v.setModel(request.getParameter("model"));
                v.setKm(Integer.parseInt(request.getParameter("km")));
                v.setPrice(Integer.parseInt(request.getParameter("price")));
                v.setState(request.getParameter("state"));
                vehicleFacade.create(v);              
            } 
             else if("find".equals(action)){
                 Vehicle findV = vehicleFacade.find(request.getParameter("license"));
                 request.getSession().setAttribute("vehicle", findV);
                 url="JSPS/findVehicle.jsp";
            }
             else if("formEdit".equals(action)){
                 Vehicle editV = vehicleFacade.find(request.getParameter("license"));
                 request.getSession().setAttribute("vehicle", editV);
                 url="JSPS/editVehicle.jsp";
            }
             else if("edit".equals(action)){
                 
                 Vehicle editedV = vehicleFacade.find(request.getParameter("license"));
                 
                 Part filePart = request.getPart("image");
                 String extension = getExt(Paths.get(filePart.getSubmittedFileName()).getFileName().toString());
                String imageName;
                
                if(extension != ""){
                imageName = request.getParameter("license") + "." + extension;
                storeImage(aux, filePart, imageName);
                }else{
                imageName = editedV.getImage();
                }
                
                 editedV.setBrand(request.getParameter("brand"));
                 editedV.setModel(request.getParameter("model"));
                 editedV.setKm(Integer.parseInt(request.getParameter("km")));
                 editedV.setPrice(Integer.parseInt(request.getParameter("price")));
                 editedV.setState(request.getParameter("state"));
                 editedV.setImage(imageName);
                 vehicleFacade.edit(editedV);
                 url="VehicleServlet?action=list";
            }
             else if ("delete".equals(action)){
                
                Vehicle v = vehicleFacade.find(request.getParameter("license"));
                String routeImageToDelete = aux + File.separator + "VehiclesImages"+File.separator+String.valueOf(v.getImage());
                File imageToDelete = new File(routeImageToDelete);
                imageToDelete.delete();
                vehicleFacade.remove(v);
                url="VehicleServlet?action=list";
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
