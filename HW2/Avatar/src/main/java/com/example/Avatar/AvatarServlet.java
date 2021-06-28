package com.example.Avatar;

        import com.talanlabs.avatargenerator.Avatar;
        import com.talanlabs.avatargenerator.SquareAvatar;


        import javax.imageio.ImageIO;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.awt.image.BufferedImage;
        import java.io.IOException;

@WebServlet(name = "avatarServlet", value = "/avatar-servlet")
public class AvatarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Avatar avatar =SquareAvatar.newAvatarBuilder().build();
        BufferedImage image = avatar.create(12345L);

        ImageIO.write(image,"png",resp.getOutputStream());

    }
}