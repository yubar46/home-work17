package presentation.web;

import context.ApplicationContext;
import domain.Travel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet(name = "home",urlPatterns = "/home")
public class InsideAirLineMenu extends HttpServlet {
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
      "\n" +
      "        form{\n" +
      "\n" +
      "            width: 650px;\n" +
      "            height: 550px;\n" +
      "            margin: auto;\n" +
      "            position: relative;\n" +
      "        }\n" +
      "\n" +
      "        input{\n" +
      "\n" +
      "            margin-left: 2cm;\n" +
      "            width: 13cm;\n" +
      "            height: 1cm;\n" +
      "        }\n" +
      "        .register{\n" +
      "            position: absolute;\n" +
      "            background-color: beige;\n" +
      "            size: 20cm;\n" +
      "        }\n" +
      "        h1{\n" +
      "            margin-left: 5cm;\n" +
      "        }\n" +
      "        button{\n" +
      "            margin-left: 6cm;\n" +
      "            height: 1cm;\n" +
      "            width:5cm ;\n" +
      "        }\n" +
      "    </style>\n" +
      "</head>\n" +
      "<body>\n" +
      "\n" +
      "  \n" +
      "        <div class=\"register\">\n" +
      "            <h1>register a new fly</h1>\n" +
      "            <form action=\"/home_work_15_war_exploded/home\" method=\"post\">\n" +
      "            <input type=\"text\" name=\"airplane model\" id=\"airplane model\" placeholder= \"airplane model\"  ,required>\n" +
      "            <br>\n" +
      "            <input type=\"text\" name=\"origin city\" id=\" origin city\", placeholder=\"origin ciy\", required>\n" +
      "            <br>\n" +
      "            <input type=\"text\" name=\"destination city\" id=\" destination city\", placeholder=\"destination city\",required>\n" +
      "            <br>\n" +
      "            <input type=\"number\" name=\"fly cost\" id=\"fly cost\", id= \"fly cost\", placeholder=\"fly cost\", required>\n" +
      "            <br>\n" +
      "            <input type= \"time\" name=\"time\" id=\"time\", placeholder=\"time\",required>\n" +
      "            <br>\n" +
      "            <input type=\"date\" name=\"date\",id= \"time\", placeholder=\"time\",required>\n" +
      "            <br><br>\n" +
      "            <button type=\"submit\"> register </button>\n" +
      "\n" +
      "        </form>\n" +
      "\n" +
      "        </div>\n" +
      "   \n" +
      "    \n" +
      "</body>\n" +
      "</html>");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String airplaneModel = req.getParameter("airplane model");
    String originCity = req.getParameter("origin city");
    String destinationCity = req.getParameter("destination city");
    String cost = req.getParameter("fly cost");
    Integer flyCost =  Integer.parseInt(cost);
    LocalDate flyDate = LocalDate.parse(req.getParameter("date"));
    LocalTime flyTime = LocalTime.parse(req.getParameter("time"));
    Travel travel = new Travel(flyCost,airplaneModel,originCity,destinationCity,flyTime,flyDate);
    travel.setTravelCompany(ApplicationContext.getInstance().getTravelCompany());
    ApplicationContext.getInstance().getTravelService().create(travel);
    resp.sendRedirect("/home_work_15_war_exploded/main");

  }
}
