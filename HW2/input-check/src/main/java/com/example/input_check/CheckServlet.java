package com.example.input_check;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "avatarServlet", value = "/avatar-servlet")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a = req.getParameter("firstname");
        String b = req.getParameter("lastname");
        String c = req.getParameter("age");
        String d = req.getParameter("email");
        String e= req.getParameter("password");

        if (a.length()==0)
            req.getRequestDispatcher("wrong.jsp").forward(req,resp);
        if (b.length()==0)
            req.getRequestDispatcher("wrong2.jsp").forward(req,resp);

        try{
           int g=Integer.parseInt(c);
        }catch(NumberFormatException ignored){
            req.getRequestDispatcher("wrong4.jsp").forward(req,resp);
        }
        if (d.length()==0)
            req.getRequestDispatcher("wrong3.jsp").forward(req,resp);
        if (e.length()==0)
            req.getRequestDispatcher("wrong5.jsp").forward(req,resp);
        else{
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }



                }

            }
