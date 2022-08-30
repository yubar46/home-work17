package presentation.web;

import context.ApplicationContext;
import domain.Gender;
import domain.Ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(name = "accept",urlPatterns = "/accept")
public class Accept extends HttpServlet {
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
      "    <title>Document</title>\n"+
      "<style>"+
      "#accept{\n" +
      "      text-align: center;\n" +
      "          width:25cm;\n" +
      "          margin-top: 15cm;\n" +
      "          margin-right: 10cm;\n" +
      "          margin-left: 12cm;\n" +
      "          background-color: rgb(96, 163, 96);\n" +
      "          color: white;\n" +
      "      }\n" +
      "</style> "+
      "</head>\n"+
      " <body>");
      String gender;
      if (ticket.getPassengerSex().equals(Gender.Male)){
        gender ="آقای";
      }else gender="خانم";
      writer.write(" <h1  id=\"accept\">"+" خرید بلیط شما با موفقیت انجام شد"+ ticket.getPassengerFullName() +gender +"</h1>\n"
        );

      writer.write("</body>"+
        "</html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String gender = req.getParameter("sex") ;
    String fullName = req.getParameter("full-name");
    Integer travelId =  (Integer)req.getSession().getAttribute("travel");

    ticket = new Ticket();
    ticket.setPassengerFullName(fullName);
    if (gender.equals("Male")){
      ticket.setPassengerSex(Gender.Male);

    }else ticket.setPassengerSex(Gender.Female);
    ticket.setTravel(ApplicationContext.getInstance().getTravel());
    ticket.setUser(ApplicationContext.getInstance().getUser());
    ApplicationContext.getInstance().getTicketService().create(ticket);

    resp.sendRedirect("/accept");
  }
}
