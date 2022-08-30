package presentation.web;

import context.ApplicationContext;
import domain.Ticket;
import domain.Travel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;

@WebServlet(name = "selectTicket",urlPatterns ="/select-ticket" )
public class SelectTicket extends HttpServlet {
  Travel travel ;
  Ticket ticket;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset=UTF-8");
    Writer writer = resp.getWriter();
    writer.write("<!DOCTYPE html>\n" +
        "<html dir=\"rtl\" lang=\"en\">\n" +
        "<head>\n" +
        "    <meta charset=\"UTF-8\">\n" +
        "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
        "    <title>Document</title>\n" +
        "    <style>\n" +
      " \n" +
        "         #check{\n" +
        "      color: #fff;    \n" +
        "    text-align: center;\n" +
        "        margin-top: 20px;\n" +
        "        background-color: orange ;\n" +
        "        width: 80px;\n" +
        "        margin-top: 1%;\n" +
        "        margin-bottom:1% ;\n" +
        "        \n" +
        "\n" +
        "    }\n" +
        "    td, tr, table ,form{\n" +
        "        background-color: rgb(248, 248, 209);\n" +
        "\n" +
        "text-align: center;\n" +
        "border: 1px solid black;\n" +
        "}\n" +
        "table{\n" +
        "    background-color: rgb(248, 248, 209);\n" +
        "  border-collapse: collapse;\n" +
        "  width:25cm;\n" +
        "          margin-top: 4cm;\n" +
        "          margin-right: 10cm;\n" +
        "          margin-left: 12cm;\n" +
        "}\n" +
        "#full-name{\n" +
        "      border-style: none ;\n" +
        "      background-color: rgb(248, 248, 209);\n" +
        "    }\n" +
        "    #form{\n" +
        "        border-style: none ;\n" +
        "\n" +
        "    }\n" +
        "\n" +
        "\n" +
        "    </style>"+
      "</head>\n"+
      " <body>"+
    "\n" +
      "<div id=\"customer\">\n" +
        "  <table id=\"customer-input\">\n" +
        "    <tbody>\n" +
        "<form  id=\"form\" action=\"/accept\" method=\"post\">\n" +
        "      <tr style=\"background-color:#fff; width:50% ; height: 33%;\">\n" +
        "        <td style=\"width: 50%;\">نام و نام خانوادگی</td>\n" +
        "        <td> <input type=\"text\" id=\"full-name\" class=\"full-name\"name=\"full-name\" ></td>\n" +
        "     \n" +
        "      </tr>\n" +
        "      <tr>\n" +
        "        <td > جنسیت </td>\n" +
        "        <td>\n" +
        "            <input  type=\"radio\" name=\"sex\" id=\"male\" value=\"Male\" ><label for=\"male\"> مرد</label>\n" +
        "            <input type=\"radio\" name=\"sex\" id=\"female\" value=\"Female\"> <label for=\"female\"> زن</label>\n" +
        "          </td>\n" +
        "        </tr>\n" +
        "        <tr style=\"background-color:#fff; width:50% ; height: 33%;\">\n" +
        "          <td   colspan=\"2\"><button id=\"check\" >تایید</button></td>\n" +
        "        </tr>\n" +
        "          </form>\n" +
        "         \n" +
        "    </tbody>\n" +
        "  </table>\n" +
        "</div>"
      );
    writer.write("</body>\n" +
      "</html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Integer travelId =  Integer.parseInt(req.getParameter("travelId"));
    if(ApplicationContext.getInstance().getTravelService().read(travelId)!=null){
      travel =ApplicationContext.getInstance().getTravelService().read(travelId);
      ApplicationContext.getInstance().setTravel(travel);
      req.getSession().setAttribute("travel",travelId);
    }

    resp.sendRedirect("/select-ticket");
  }
}
