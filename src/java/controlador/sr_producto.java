/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.producto;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 *
 * @author SistemasU
 */
public class sr_producto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    producto Producto;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("btn_agregar");
        producto p = new producto();
        switch (accion){
            case "guardar":
                ArrayList<String>lista=new ArrayList<>();
                try{
                    FileItemFactory file = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(file);
                    List items=fileUpload.parseRequest(request);
                        for (int i = 0; i < items.size(); i++){
                        FileItem fileItem=(FileItem)items.get(i);
                        if(!fileItem.isFormField()){
                            File f=new File("C:\\temp\\"+fileItem.getName());
                            fileItem.write(f);
                            p.setImagen(f.getAbsolutePath()); //ruta donde se almacena
                        }else{
                            lista.add(fileItem.getString());
                        }    
                            
                    }
                    p.setProducto(lista.get(0)); 
                    p.agregar();
                    
                    }catch(FileUploadException e){
                } catch (Exception ex) {
                Logger.getLogger(sr_producto.class.getName()).log(Level.SEVERE, null, ex);//se agrego por el f
            }
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

  
            default:
                throw new AssertionError();
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_producto</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //Boton agregar
            if("agregar".equals(request.getParameter("btn_agregar"))){
                Producto = new producto(request.getParameter("txt_producto"),Integer.valueOf(request.getParameter("drop_marcas")),Integer.valueOf(request.getParameter("txt_id")),Integer.valueOf(request.getParameter("txt_existencia")),request.getParameter("txt_descripcion"),request.getParameter("fileimagen"),request.getParameter("txt_fecha_ingreso"),Integer.valueOf(request.getParameter("txt_precio_costo")),Integer.valueOf(request.getParameter("txt_precio_venta")));
                if(Producto.agregar() > 0){
                    response.sendRedirect("index.jsp");
                }else{
                    out.println("<h1>Error al ingresar..............</h1>");
                    out.println("<h1><a href='index.jsp'>Regresar</a></h1>");
                }
            }
             //Boton modificar
            if("modificar".equals(request.getParameter("btn_modificar"))){
                Producto = new producto(request.getParameter("txt_producto"),Integer.valueOf(request.getParameter("drop_marcas")),Integer.valueOf(request.getParameter("txt_id")),Integer.valueOf(request.getParameter("txt_existencia")),request.getParameter("txt_descripcion"),request.getParameter("txt_imagen"),request.getParameter("txt_fecha_ingreso"),Integer.valueOf(request.getParameter("txt_precio_costo")),Integer.valueOf(request.getParameter("txt_precio_venta")));
                if(Producto.modificar() > 0){
                    response.sendRedirect("index.jsp");
                }else{
                    out.println("<h1>Error al modificar..............</h1>");
                    out.println("<h1><a href='index.jsp'>Regresar</a></h1>");
                }    
            }
                
            //Boton eliminar
            if("eliminar".equals(request.getParameter("btn_eliminar"))){
                Producto = new producto(request.getParameter("txt_producto"),Integer.valueOf(request.getParameter("drop_marcas")),Integer.valueOf(request.getParameter("txt_id")),Integer.valueOf(request.getParameter("txt_existencia")),request.getParameter("txt_descripcion"),request.getParameter("txt_imagen"),request.getParameter("txt_fecha_ingreso"),Integer.valueOf(request.getParameter("txt_precio_costo")),Integer.valueOf(request.getParameter("txt_precio_venta")));
                if(Producto.eliminar() > 0){
                    response.sendRedirect("index.jsp");
                }else{
                    out.println("<h1>NO fue eliminado..............</h1>");
                    out.println("<h1><a href='index.jsp'>Regresar</a></h1>");
                }    
            }   
            //Producto = new producto(request.getParameter("txt_producto"),Integer.valueOf(request.getParameter("drop_marcas")),Integer.valueOf(request.getParameter("txt_id")),request.getParameter("txt_descripcion"),0,float.valueOf(request.getParameter("txt_precio_costo")),float.valueOf(request.getParameter("txt_precio_venta")),Integer.valueOf(request.getParameter("txt_existencia")),request.getParameter("txt_fecha_ingreso"));
            //out.println("<h1>Servlet sr_producto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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