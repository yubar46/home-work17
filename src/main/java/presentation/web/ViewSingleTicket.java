package presentation.web;

import context.ApplicationContext;
import domain.Ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(urlPatterns = "/single-ticket")
public class ViewSingleTicket extends HttpServlet {
Ticket ticket;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset=UTF-8");

    String ticketId = req.getParameter("ticketId");
    Long id = Long.valueOf(ticketId);
    if (ApplicationContext.getInstance().getTicketService().read(id)!=null){
      ticket = ApplicationContext.getInstance().getTicketService().read(id);
    }
    Writer writer = resp.getWriter();
    writer.write("<!DOCTYPE html>\n" +
      "<html dir=\"rtl\" lang=\"en\">\n" +
      "<head>\n" +
      "   <meta charset=\"UTF-8\">\n" +
      "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
      "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
      "    <title>Document</title>\n" +
      "    <style>\n" +
      "      #table-ticket{\n" +
      "        \n" +
      "        text-align: center;\n" +
      "          width:25cm;\n" +
      "          margin-top: 4cm;\n" +
      "          margin-right: 10cm;\n" +
      "          margin-left: 12cm;\n" +
      "      }\n" +
      "    \n" +
      "      td, tr, table{\n" +
      "\n" +
      "        border: 1px solid black;\n" +
      "        text-align: center;\n" +
      "        width: 500px;\n" +
      "        margin-top: 10cm;\n" +
      "        margin-left: 10cm;\n" +
      "        margin-right: 15cm;\n" +
      "      }\n" +
      "        table{\n" +
      "          border-collapse: collapse;\n" +
      "        }\n" +
      "      button {\n" +
      "        width: 12.5%;\n" +
      "        margin: 10px;\n" +
      "        margin-top: 20px;\n" +
      "        background: linear-gradient( to right,#000000, #1de5f9);\n" +
      "        color: #fff;\n" +
      "      }\n" +
      "      \n" +
      "      \n" +
      "      \n" +
      "    .date-container{\n" +
      "      text-align: right;\n" +
      "      width: 12.5%;\n" +
      "        display: flex;\n" +
      "        flex-direction: column;\n" +
      "    }\n" +
      "\n" +
      "    #firstTh{\n" +
      "      background-color: rgba(235, 203, 22, 0.884);\n" +
      "    }\n" +
      "    #secondTh{\n" +
      "      background-color: rgb(65, 37, 15);\n" +
      "      color: white;\n" +
      "    }\n" +
      "    tr:nth-child(odd){\n" +
      "      background-color: rgb(177, 155, 107);\n" +
      "    }\n" +
      "    tr:nth-child(even){\n" +
      "      background-color: rgb(247, 245, 244);\n" +
      "    }\n" +
      "\n" +
      "    \n" +
      "    \n" +
      "    \n" +
      "\n" +
      "    </style>\n" +
      "</head>\n" +
      "<body>\n" +
      "\n" +
      "\n" +
      "\n" +
      "\n" +
      "    <div>\n" +
      "      <table id=\"buught-tickets\">\n" +
      "          <thead>\n" +
      "            <tr>\n" +
      "              <td>بلیط اتوبوس</td>\n" +
      "            </tr>\n" +
      "\n" +
      "          </thead>\n" +
      "          <tbody>\n" +
      "            <tr>\n" +
      "              <td>شناسه ی بلیط</td>\n" +
      "              <td>"+ticket.getId()+"</td>\n" +
      "            </tr>\n" +
      "            <tr>\n" +
      "              <td>نام</td>\n" +
      "            <td>"+ticket.getPassengerFullName()+"</td>\n" +
      "            </tr>\n" +
      "            <tr>\n" +
      "              <td>جنیسیت</td>\n" +
      "              <td>"+ticket.getPassengerSex().toString()+"</td>\n" +
      "            </tr>\n" +
      "            <tr>\n" +
      "              <td>مبدا</td>\n" +
      "              <td>"+ticket.getTravel().getSourceCity()+"</td>\n" +
      "            </tr>\n" +
      "            <tr>\n" +
      "              <td>مصقد</td>\n" +
      "              <td>"+ticket.getTravel().getDestinationCity()+"</td>\n" +
      "              \n" +
      "            </tr>\n" +
      "            <tr>\n" +
      "              <td>تاریخ حرکت</td>\n" +
      "              <td>"+ticket.getTravel().getTravelDate()+"</td>\n" +
      "            </tr>\n" +
      "            <tr>\n" +
      "              <td>ساعت حرکت</td>\n" +
      "              <td>"+ticket.getTravel().getTravelTime()+"</td>\n" +
      "            </tr>\n" +
      "            <tr>\n" +
      "              <td>شناسه سفر</td>\n" +
      "              <td>"+ticket.getTravel().getId()+"</td>\n" +
      "            </tr>\n" +
      "            <tr>\n" +
      "              <td colspan=\"2\"> \n" +
      "                <div><form action=\"/single-ticket\" method=\"post\">\n" +
      "                  <button name=\" cancel\" id=\"cancel \" > لغو بلیط</button>\n" +
      "                </form></div>\n" +
      "              </td> "+
      "            </tr>\n" +
      "             </tbody>\n" +
      "      </table>\n" +
      "    </div>\n" +
      "</body>\n" +
      "</html>");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ApplicationContext.getInstance().getTicketService().delete(ticket.getId());
    resp.sendRedirect("/view-tickets");
  }
}
