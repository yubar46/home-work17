package presentation.web;

import context.ApplicationContext;
import domain.TravelCompany;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="login",urlPatterns = "/login")
public class Login extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter writer = resp.getWriter();
    writer.write("<!DOCTYPE html>\n" +
      "<html lang=\"en\">\n" +
      "<head>\n" +
      "    <meta charset=\"UTF-8\">\n" +
      "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
      "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
      "    <title>Document</title>\n" +
      "    <style>\n" +
      "        .login{\n" +
      "            position: absolute;\n" +
      "            margin-right: 10cm;\n" +
      "            margin-left: 22cm;\n" +
      "             margin-top: 10cm;\n" +
      "\n" +
      "\n" +
      "        }\n" +
      "        input{\n" +
      "            padding: 12px 20px;\n" +
      "            border-radius: 1px;\n" +
      "             background-color: #f2f2f2;\n" +
      "             \n" +
      "        }\n" +
      "        button{\n" +
      "            padding: 12px 20px;\n" +
      "            background-color: #3dfd0d;\n" +
      "\n" +
      "\n" +
      "        }\n" +
      "    </style>\n" +
      "</head>\n" +
      "<body>\n" +
      "\n" +
      "    <div class=\"login\"> \n" +
      "        <div>\n" +
      "            <h2><strong>login</strong> </h2>\n" +
      "            <form method=\"post\" action=\"/login\">\n" +
      "              <input name=\"username\" type=\"text\" id=\"username\" placeholder=\"username\" required >\n" +
      "              <br><br>\n" +
      "              <input name=\"password\" type=\"password\" id=\"password\" placeholder=\"password\" required >\n" +
      "          <br>\n" +
      "          <button type=\"submit\"> login </button>\n" +
      "            </form>  \n" +
      "          </div>\n" +
      "          <br>\n" +

      "    </div>\n" +
      "    \n" +
      "</body>\n" +
      "</html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    if (    ApplicationContext.getInstance().
      getUserService().findByUsername(username)!=null){
      User user =ApplicationContext.getInstance()
        .getUserService().findByUsername(username);
      if (user.getPassword().equals(password)){
        ApplicationContext.getInstance().setUser(user);
        req.getSession().setAttribute("username",username);

        resp.sendRedirect("/tickets");
      }else resp.sendRedirect("/login?error");
    }else resp.sendRedirect("/login?error");

  }
}
