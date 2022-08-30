package presentation.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "mainPage", urlPatterns = "/main")
public class MainPage extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Writer writer = resp.getWriter();
    writer.write("<!DOCTYPE html>\n" +
      "<html dir=\"rtl\" lang=\"fa\" lang=\"en\">\n" +
      "<head>\n" +
      "    <meta charset=\"UTF-8\">\n" +
      "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
      "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
      "    <title>maktab travel</title>\n" +
      "    <link rel=\"stylesheet\" href=\"./styles.css\">\n" +
      "    <style>\n" +
      "           header {\n" +
      "        display: flex;\n" +
      "        padding: 20px;\n" +
      "      }\n" +
      "      \n" +
      "      .headerLinkWrapper {\n" +
      "        position: absolute;\n" +
      "        left: 21px;\n" +
      "      }\n" +
      "      \n" +
      "      a {\n" +
      "        margin: 10px;\n" +
      "        text-decoration: none;\n" +
      "      }\n" +
      "      \n" +
      "      nav {\n" +
      "        display: flex;\n" +
      "      }\n" +
      "      form {\n" +
      "        display: flex;\n" +
      "        flex-direction: column;\n" +
      "      }\n" +
      "      \n" +
      "      ul {\n" +
      "        position: absolute;\n" +
      "        left: 40px;\n" +
      "        display: flex;\n" +
      "        list-style: none;\n" +
      "      }\n" +
      "      li {\n" +
      "        margin: 15px;\n" +
      "      }\n" +
      "      \n" +
      "      input,\n" +
      "      button {\n" +
      "        width: 190px;\n" +
      "        height: 30px;\n" +
      "        margin: 10px;\n" +
      "      }\n" +
      "      \n" +
      "      .container {\n" +
      "        margin-right: 200px;\n" +
      "        margin-top: 50px;\n" +
      "      }\n" +
      "      \n" +
      "      .cardTicket {\n" +
      "        display: flex;\n" +
      "      }\n" +
      "      \n" +
      "      .card {\n" +
      "        margin: 10px;\n" +
      "        padding: 5px;\n" +
      "      }\n" +
      "      \n" +
      "      .headerTicket {\n" +
      "        display: flex;\n" +
      "        flex-direction: column;\n" +
      "        justify-content: center;\n" +
      "        align-items: center;\n" +
      "      }\n" +
      "    </style>\n" +
      "      \n" +
      "\n" +
      "</head>\n" +
      "<body>\n" +
      "\n" +
      "        <header class=\"header\">\n" +
      "            <div class=\"headerLinkWrapper\">\n" +
      "                <a href=\"/home_work_15_war_exploded/login\"> airline login</a>\n" +
      "                <a href=\"/home_work_15_war_exploded/signup\">airline sign up</a>\n" +
      "            </div>\n" +
      "        </header>\n" +
      "\n" +
      "\n" +
      "      \n" +
      "\n" +
      "        <div class=\"container\">\n" +
      "            <h1> ticket search</h1>\n" +
      "            \n" +
      "\n" +
      "            <form method= \"post\" action=\" /home_work_15_war_exploded/tickets\">\n" +
      "                <input type=\"text\" name=\"origin\" id=\"origin\" placeholder=\"origin\" required>\n" +
      "                <input type=\"text\" name=\"destination\" id=\"destination\" placeholder=\"destination\" required>\n" +
      "                <input type=\"date\" name= \"date\" >\n" +
      " <div class=\"sort\">\n" +
      "            <p><strong> sorting by</strong></p>\n" +
      "            <input name=\"sort\" type=\"radio\" id=\"cost\" value= \"cost\"> <label for=\"cost\" checked> cost</label>\n" +
      "            <input name=\"sort\" type=\"radio\" id=\"origin\" value= \"origin\"> <label for=\"origin \">origin</label>\n" +
      "            <br>\n" +
      "            <input name=\"sort\" type=\"radio\" id=\"destination\" value= \"destination\" > <label for=\"destination\">destination</label>\n" +
      "            <input name=\"sort\" type=\"radio\" id=\"airline\" value= \"airline\" > <label for=\"airline\">airline</label>\n" +
      "            <p><strong> order by</strong></p>\n" +
      "\n" +
      "            <input name=\"ad\" type=\"radio\" id=\"ascending\" value= \"ascending\" checked><label for=\"ascending\"> ascending</label>\n" +
      "            <input name=\"ad\" type=\"radio\" id=\"descending\" value= \"descending\"><label for=\"descending\"> descending</label>\n" +
      "\n" +
      "\n" +
      "           </div>" +
      "                <button type=\"submit\">search</button>\n" +

      "            </form>\n" +
      "        </div>\n" +
      "\n" +
      "       \n" +
      "\n" +
      "\n" +
      "            </div>\n" +
      "        </div>\n" +
      "\n" +
      "\n" +
      "\n" +
      "    \n" +
      "</body>\n" +
      "</html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
