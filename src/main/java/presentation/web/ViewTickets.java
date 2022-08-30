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
import java.util.List;

@WebServlet(urlPatterns = "/view-tickets")
public class ViewTickets extends HttpServlet {

  List<Ticket> tickets;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset=UTF-8");
    tickets = ApplicationContext.getInstance().getTicketService()
      .findAllUserTickets(ApplicationContext.getInstance().getUser());
    Writer writer = resp.getWriter();
    if (tickets.isEmpty()){
      writer.write("<!DOCTYPE html>\n" +
        "<html dir=\"rtl\" lang=\"en\">\n" +
        "<head>\n" +
        "    <meta charset=\"UTF-8\">\n" +
        "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
        "    <title>Document</title>\n" +
        "\"</head>\\n\" +\n" +
          "      \"<body>\\n\" +\n" +
          "      \"\\n\" +\n" +
          "              <h1 style=\"text-align: center; color: red; \" > شما تاکنون هیچ بلیطی خریداری نکرده اید</h1>     \n"+
        "</body>\n" +
        "</html>");
    }
    writer.write("<!DOCTYPE html>\n" +
      "<html dir=\"rtl\" lang=\"en\">\n" +
      "<head>\n" +
      "    <meta charset=\"UTF-8\">\n" +
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
      "    <div id=\"tickets\">\n" +
      "      <table  >\n" +
      "        <thead>\n" +
      "            <tr>\n" +
      "              <td  id=\"secondTh\" colspan=\"3\"> لیست بلیط های خریداری شده </td>\n" +
      "            </tr>\n" +
      "            <tr id=\"firstTh\">\n" +
      "              <td>انتخاب</td>\n" +
      "              <td>شناسه ی بلیط</td>\n" +
      "              <td>تاریخ</td>\n" +
      "             </tr>   \n" +
      "    \n" +
      "        \n" +
      "          </thead>\n" +
      "        <tbody>\n" +
      "         \n");
        for(int i = 0 ;i<tickets.size();i++){
          writer.write("         <tr>\n" +
            "                 <td ><a href=\"/single-ticket?ticketId="+ tickets.get(i).getId()+
            "\"  >  مشاهده ی بلیط</a> </td>\n" +
            "" +
            "          <td> \" " +tickets.get(i).getId()+ "\" </td>\n"+
            "          <td> \" "+tickets.get(i).getTravel().getTravelDate()+"\" </td>\n"+
            "         </tr>\n" );

    }
    writer.write("</tbody>\n" +
        "      </table>\n" +
        "    </div>\n"+
      "</body>\n" +
      "</html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }
}
