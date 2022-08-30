
package presentation.web;
import context.ApplicationContext;
import domain.TravelCompany;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@WebFilter(urlPatterns = {"/tickets","/view-tickets","/single-ticket","/select-ticket"})
public class AuthenticationFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse resp = (HttpServletResponse) servletResponse;


    if (req.getSession().getAttribute("username")!=null ){
      filterChain.doFilter(servletRequest, servletResponse);
      return;
    }
    String authorization = req.getHeader("Authorization");
      if (authorization==null){
      send401(resp);
      return;
    }
    String[] spilt = authorization.split(" ");
    String base64EncodedUsernameAndPassword = spilt[1];
    String usernameAndPassword = new String(Base64.getDecoder().
      decode(base64EncodedUsernameAndPassword));
   spilt = usernameAndPassword.split(":");
    String username = spilt[0];
    String password = spilt[1];
    if (ApplicationContext.getInstance().getTravelCompanyService()
      .findByeCompanyName(username)!=null){
      TravelCompany travelCompany = ApplicationContext.getInstance().
        getTravelCompanyService().findByeCompanyName(username);
        if (travelCompany.getPassword().equals(password)){
          ApplicationContext.getInstance().setTravelCompany(travelCompany);
          filterChain.doFilter(servletRequest,servletResponse);
          return;
        }else {
          resp.sendRedirect("/login?error");
        }
    }else resp.sendRedirect("/login?error");


  }

  @Override
  public void destroy() {

  }
  private void send401(HttpServletResponse resp) throws IOException {
    resp.setHeader("www-Authenticate", "Basic realm=\"Access to the site\"");
    resp.sendError(401);
  }
}
