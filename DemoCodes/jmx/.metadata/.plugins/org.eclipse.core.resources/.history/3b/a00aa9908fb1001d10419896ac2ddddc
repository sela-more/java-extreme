import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class HelloWorld extends HttpServlet {

  protected void doGet (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException  {

	resp.setContentType("text/html");   
	PrintWriter out = resp.getWriter();  
	out.println("<HTML><BODY><H2>Hello World !</H2</BODY></HTML>");
	out.close();
  }
  
  public void init() throws ServletException {
   	System.out.println("init...");
  }

  public void destroy()  {
  	System.out.println("destroy...");
  }
}
