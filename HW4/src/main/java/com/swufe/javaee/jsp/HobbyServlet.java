package com.swufe.javaee.jsp;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@WebServlet(urlPatterns = "/hobbyFind")
@GwtCompatible
public class HobbyServlet extends HttpServlet {

    private final ListMultimap<String,String> userHobby= ArrayListMultimap.create();
    @Override
    public void init() {
        URL url=getClass().getClassLoader().getResource("/hobby.txt");
        try {
            assert url != null;
            try(Stream<String>lines=Files.lines(Paths.get(url.toURI()))){
                lines.forEach(line->{
                    String[] matchHobby=line.split(" ");
                    userHobby.put(matchHobby[0],matchHobby[1]);
                });
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String hobby = request.getParameter("hobby");
       List<String> names = new ArrayList<>();
       userHobby.asMap().forEach((k, v) -> {
            if (v.contains(hobby)){
                names.add(k);
            }
        });
       request.setAttribute("names", names);
       request.setAttribute("hobby", hobby);
       // Two JSPs have different UI styles.
       //  request.getRequestDispatcher("hobbyResult.jsp").forward(request, response);
       request.getRequestDispatcher("hobbyResult.jsp").forward(request, response);
    }

}
