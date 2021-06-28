package com.example.Cookies;

import javafx.scene.shape.Path;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@WebServlet(name = "SignInServlet", value = "/sign-in")
public class SignInServlet extends HttpServlet {

    private Map<String, String> m;

    @Override
    public void init() throws ServletException {
        try (Stream<String> lines = Files.lines(Paths.get("fd"))) {

        } catch (IOException e) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("sign-in.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("inputName");
        String password = req.getParameter("inputPassword");


             //  List<String> lines2=Files.readAllLines(Paths.get(""));
                        //Lines.forEach(System.out ::print);
                        //for(String line:lines2)
                        //for(int i=0;i<lines2.size();i++）


        // read file, load data into hashmap
       // URL url=getClass().getClassLoader().getResource("information");

        //try (Stream<String> lines = Files.lines(Path.of(url.toURI()))) {
          //  lines.forEach(System.out::println);


        Stream<String> lines = Files.lines(Paths.get("C:\\Users\\15726\\Desktop\\information.txt"));
        HashMap<String, String> m = new HashMap<>();
        lines.forEach(line -> {
            String[] name_pwd = line.split(" ");
            m.put(name_pwd[0], name_pwd[1]);
        });     //the easiest way to read the file!!!


        if (!m.containsKey(name)) {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            // no such user
            // redirect to error page
        } else {
            if (m.get(name).equals(password)) {
                req.getSession().setAttribute("user", name);
                resp.sendRedirect("home");
                // ok
                // put user into session
            } else {
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                // wrong password
                // redirect to error page


            }
        }

    }


    }
