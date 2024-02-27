package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	
protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter pw = response.getWriter();
	
	String user_id=request.getParameter("user_id");
	String user_pw=request.getParameter("user_pw");
	System.out.println(user_id +user_pw );
	HttpSession  sess=request.getSession();
	
    LoginImpl loginUser= new LoginImpl(user_id,user_pw );
	
	System.out.println(sess.isNew());
	
	if(sess.isNew()) {
		sess.setAttribute("loginUser", loginUser);
	}
	
	
	
	
//	pw.write("<h6>hihihi</h6>");
	pw.write(loginUser.user_id + "접속합");
	pw.write("현재 접속자 수 " + LoginImpl.total_user + "명");
//	pw.write("<h1>안녕</h1>");
	
	}
}
