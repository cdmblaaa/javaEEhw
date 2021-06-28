package com.example.UploadImage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UploadServlet", value = "/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Part filePart = request.getPart("file");
        // how to get the file name of Part in servlet
        // Class, Method
        String s1 = filePart.getSubmittedFileName();//Debug(调试）
        filePart.write("C:\\Users\\15726\\Desktop\\java\\" + s1);
        response.sendRedirect("ok.html");
    }
}
