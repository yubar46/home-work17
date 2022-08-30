package presentation.web;

import context.ApplicationContext;
import domain.Travel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "searchTicket",urlPatterns = "/tickets")
public class SearchTicket extends HttpServlet {

 private List<Travel> travels;
 private String sortModel;
 private String orderModel;

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
      "           header {\n" +
      "        display: flex;\n" +
      "        padding: 20px;\n" +
      "      }\n" +
      "      \n" +
      "      .headerLinkWrapper {\n" +
      "        position: absolute;\n" +
      "        left: 21px;\n" +
      "      }\n"+

      " #table-ticket{\n" +
      "        position: absolute;\n" +
      "        text-align: center;\n" +
      "          width:25cm;\n" +
      "          margin-top: 4cm;\n" +
      "          margin-right: 8cm;\n" +
      "          margin-left: 15cm;\n" +
      "      }"+
      " #not-found{\n" +
      "        position: absolute;\n" +
      "        text-align: center;\n" +
      "          width:25cm;\n" +
      "          margin-top: 4cm;\n" +
      "          margin-right: 8cm;\n" +
      "          margin-left: 15cm;\n" +
      "      }"+
      " #firstTh{\n" +
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
      "    }\n " +
      "td, tr, table{\n" +
      "\n" +
      "        border: 1px solid black;\n" +
      "      }\n" +
      "        table{\n" +
      "          border-collapse: collapse;\n" +
      "        }\n" +
      "      "+
      "     \n" +
      "      #button {\n" +
      "        width: 12.5%;\n" +
      "        margin: 10px;\n" +
      "        margin-top: 20px;\n" +
      "        background: linear-gradient( to right,#000000, #1de5f9);\n" +
      "        color: #fff;\n" +
      "      }\n" +
      "      .container {\n" +
      "        margin-right: 200px;\n" +
      "        margin-top: 50px;\n" +
      "      }\n" +
      "      .search {\n" +
      "        display: flex;\n" +
      "        justify-content: space-around;\n" +
      "        align-items: center;\n" +
      "        background: linear-gradient(to right, #bfbec4, #6b6b6e);\n" +
      "\"        border-style: solid;\\n\" +\n" +
      "      \"        border-color: black;\\n\" +"+
      "      }\n" +
      "      \n" +
      "      .founded{\n" +
      "        position: absolute;\n" +
      "          \n" +
      "        margin-top: 100px;\n" +
      "        margin-right: 500px;\n" +
      "        left: 20cm;\n" +
      "    \n" +
      "\n" +
      "      }\n" +
      "     \n" +
      "\n" +
      "      .search{\n" +
      "        border-style: solid;\n" +
      "        border-color: black;\n" +
      "\n" +
      "      }\n" +
      "\n" +
      "      .origin, .des {\n" +
      "        width: 100%;\n" +
      "        height: auto;\n" +
      "      }\n" +
      "     \n" +
      "      .date{\n" +
      "        width: 100%;\n" +
      "      }\n" +
      "      .input-labal-container{\n" +
      "        width: 25%;\n" +
      "        display: flex;\n" +
      "        flex-direction: column;\n" +
      "        text-align: right;\n" +
      "      }\n" +
      "\n" +
      "    .date-container{\n" +
      "      text-align: right;\n" +
      "      width: 12.5%;\n" +
      "        display: flex;\n" +
      "        flex-direction: column;\n" +


      "\n" +
      "\n" +
      "\n" +
      "\n" +
      "    </style>\n" +
      "</head>\n" +
      "<body>\n" +
      "\n" +
      " <header class=\"header\">\n" +
      "        \n" +
      "            <div class=\"headerLinkWrapper\">\n" +
      "                <a href=\"/view-tickets\">مشاهده ی بلیط های خریداری شده </a>\n" +
      "           \n" +
      "            </div>\n" +
      "        </header>\n"+
      "   \n" +
      "\n" +
      "    <div class=\"container\">\n" +
      "        \n" +
      "        \n" +
      "\n" +
      " <form class=\"search\" action=\"/tickets\" method=\"post\">\n" +
      "          \n" +
      "          \n" +
      "        \n" +
      "        \n" +
      "\n" +
      "\n" +
      "        <div class= \"input-labal-container\">\n" +
      "          <label for=\"origin\">مبدا</label>\n" +
      "          <select class=\"origin\" type=\"text\" name=\"origin\" id=\"origin\">\n" +
      "            <option   value=\"\">مبدا را تایپ نمایید</option> \n" +
      "            <option value=\"tehran\">تهران</option>\n" +
      "            <option value=\"esfehan\"> اصفهان</option>\n" +
      "            <option value=\"mashhad\">مشهد</option>\n" +
      "            <option value=\"shiraz\">شیراز</option>\n" +
      "            <option value=\"tabriz\">تبریز</option>\n" +
      "            <option value=\"boushehr\">بوشهر</option>\n" +
      "\n" +
      "          </select>\n" +
      "        </div>\n" +
      "\n" +
      "        <div class=\"input-labal-container\">\n" +
      "          <label for=\"des\">مقصد</label>\n" +
      "          <select  class=\"des\" type=\"text\" name=\"des\" id=\"des\">\n" +
      "            <option  value=\"\">مقصد را انتخاب نمایید</option>\n" +
      "            <option value=\"tehran\">تهران</option>\n" +
      "            <option value=\"esfehan\"> اصفهان</option>\n" +
      "            <option value=\"mashhad\">مشهد</option>\n" +
      "            <option value=\"shiraz\">شیراز</option>\n" +
      "            <option value=\"tabriz\">تبریز</option>\n" +
      "            <option value=\"boushehr\">بوشهر</option>\n" +
      "\n" +
      "             </select>\n" +
      "\n" +
      "          \n" +
      "        </div>\n" +
      "\n" +
      "        <div class = \"date-container\">\n" +
      "          <label for=\"data\">تاریخ </label>\n" +
      "          <input   class=\"date\" type=\"date\" name=\"date\" id=\"date\" placeholder=\"تاریخ حرکت را انتخاب نمایید\">\n" +
      "        </div>\n" +
      "        <button id=\"button\" type=\"submit\">جستجو</button>\n" +
      "\n" +
      "        </form>\n" +
      "\n");
    if (!travels.isEmpty()){
      writer.write(
          "  </form> <table id=\"table-ticket\" >\n" +
        "          <thead>\n" +
        "            <tr id=\"firstTh\">\n" +
        "              <td style=\" text-align: right;\" colspan=\"2\" >مسیر:"+ travels.get(0).getSourceCity()+"-"+
        travels.get(0).getDestinationCity()+" </td>\n" +
        "              <td style=\" text-align: right ; width:33%; \">تاریخ حرکت:"+ travels.get(0).getTravelDate() +" </td>\n" +
        "            </tr>\n" +
        "            <tr id=\"secondTh\">\n" +
        "              <td> انتخاب </td>\n" +
        "              <td>ساعت حرکت</td>\n" +
        "              <td>شناسه سفر</td>\n" +
        "            </tr>\n" +
        "          </thead>\n");
      for (int i = 0;i<travels.size();i++) {
        String color;
        if (i%2==0){
          color="rgb(247, 247, 224) ";
        }else color="rgb(255, 255, 181) ";
        writer.write("    <tbody>\n" +
          "            <tr style=\"background-color:"+ color +" ;\" >\n" +
          "              <td><form action=\"/select-ticket\" method=\"post\"> <button  value=\""+travels.get(i).getId()+"\" name=\"travelId\" >خرید  </button> </form></td>\n" +
          "              <td>"+travels.get(i).getTravelTime() +" </td>\n" +
          "              <td>"+ travels.get(i).getId()+"</td>\n" +
          "            </tr>\n" );

      }
      writer.write("</tbody>\n" +
        "</table>" +
        " </div>");
    }else if (travels.isEmpty()){
      writer.write("<h1 id=\"not-found\" >در حال حاضر سفری با چنین مشخصات وجود ندارد</h1>");
    }
      writer.write("\n" +
        "    \n" +
        "</body>\n" +
        "</html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String originCity = req.getParameter("origin");
    String destination = req.getParameter("des");
    LocalDate date = LocalDate.parse(req.getParameter("date"));

    travels = ApplicationContext.
      getInstance().
      getTravelService().findByDateAndCity(date, originCity, destination);


    resp.sendRedirect("/tickets");

  }
}
