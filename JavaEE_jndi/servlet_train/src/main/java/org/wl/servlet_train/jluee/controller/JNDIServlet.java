package org.wl.servlet_train.jluee.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.wl.servlet_train.jluee.biz.JNDIBiz;
import org.wl.servlet_train.jluee.dao.UserDao;
import org.wl.servlet_train.jluee.entity.User;

import javax.naming.NamingException;
import java.io.IOException;

@WebServlet(name = "jndiServlet", value = "jndi")
public class JNDIServlet extends HttpServlet {
    private JNDIBiz service = null;

    @Override
    public void init() {
        try {
            service = new JNDIBiz();
        }catch (NamingException e) {
            System.out.println("Error: Unable to initial Context");
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        String typet=req.getParameter("_method");
        if(typet.equals("delete")){
            req.setCharacterEncoding("UTF-8");
            String bindname=req.getParameter("bindname");
            try{

                System.out.println("delete@"+bindname);
                Object ob=service.lookup(bindname);
                service.unbind(bindname);
                String str=(String)ob;
                req.setAttribute("deletevalue",str);
                req.getRequestDispatcher("success.jsp").forward(req,resp);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else if(typet.equals("put")){
            req.setCharacterEncoding("UTF-8");
            String bindname=req.getParameter("bindname");
            String value=req.getParameter("bindvalue");
            System.out.println("@@@@@@@@@@@@@@@@@@@");
            System.out.println(bindname+"@@@@@@@@@@@@@@@@@@@"+value);
            try{
                System.out.println("rebind@"+bindname);
                service.rebind(bindname,value);
                req.setAttribute("revalue",value);
                req.getRequestDispatcher("success.jsp").forward(req,resp);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            req.setCharacterEncoding("UTF-8");
            String bindname=req.getParameter("bindname");
            String value=req.getParameter("bindvalue");
            System.out.println("@@@@@@@@@@@@@@@@@@@");
            System.out.println(bindname+"@@@@@@@@@@@@@@@@@@@"+value);
            try{
                service.bind(bindname,value);
                req.getRequestDispatcher("success.jsp").forward(req,resp);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        String bindname=req.getParameter("bindname");
        try{
            System.out.println("get@"+bindname);
            Object ob=service.lookup(bindname);
            String str=(String)ob;
            req.setAttribute("value",str);
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }
    }



}
