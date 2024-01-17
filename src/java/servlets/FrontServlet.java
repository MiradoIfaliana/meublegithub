/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import annotation.Scope;
import controller.Controller;
import controller.Utilitaire;

/**
 *
 * @author Mirado
 */
public class FrontServlet extends HttpServlet {
    Controller controller;
    Utilitaire utilitaire;
    String dispatch;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            dispatch="Acceuil.jsp";
            String url = request.getRequestURL().toString();
            String uri = request.getRequestURI();
            String[] uris=uri.split("/");
            String annotmethod=uris[uris.length-1];
            System.out.println("annotation method : "+annotmethod);
            if(controller==null){   controller=new Controller();    }
            if(utilitaire==null){   utilitaire=new Utilitaire();  }
            //trouver la methode du controller annotée par le url et l'invoquer
            Method method = utilitaire.getMethodByAnnotation(Controller.class, Scope.class, "name", annotmethod);
            if(method!=null){
                System.out.println("the method :"+method.getName());
                Object[] objs=new Object[1];
                objs[0]=request;
                if(method.getReturnType().getSimpleName().compareTo("String")==0){
                    dispatch=method.invoke(controller, objs).toString();
                    if(dispatch!=null){ 
                        if(dispatch.contains(".jsp")==false){ dispatch=dispatch+".jsp"; }
                    }
                }else{
                    method.invoke(controller, objs).toString();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        request.setAttribute("section",dispatch);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
