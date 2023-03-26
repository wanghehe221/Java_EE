package org.wl.servlet_train.jluee.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.http.HttpSession;
import org.wl.servlet_train.jluee.dao.UserDao;
import org.wl.servlet_train.jluee.entity.User;


@WebServlet("res")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao jd=new UserDao();
        User newUser=new User();
        req.setCharacterEncoding("UTF-8");

        String sname=req.getParameter("username");
        String spass=req.getParameter("password");
        newUser.setName1(sname);
        newUser.setPasswd1(spass);

        HttpSession session=req.getSession();
        session.setAttribute("Name", sname);
        session.setAttribute("Pass", spass);
        System.out.println(sname+"####"+spass);

        try{

            User nowUser=new User();
            nowUser=jd.UserLogin(newUser);
            if(nowUser!=null){
                req.getRequestDispatcher("success.jsp").forward(req,resp);
            }else{

                req.setAttribute("error","?");
                req.getRequestDispatcher("error.jsp").forward(req,resp);
            }
        }catch (Exception e){
            System.out.println("Login");
            System.out.println(e);
        }
    }
}



