package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/login")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//접속한 사용자들을 저장하는 범위는 애플리케이션 범위이므로 컨텍스트에 저장
	ServletContext context=null;
	ArrayList userLists= new ArrayList();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	
protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter pw = response.getWriter();
	
	
	
	
	//접속한 사용자들을 저장하는 범위는 애플리케이션 범위이므로 컨텍스트에 저장
	
	context =getServletContext();
	
	
	String user_id=request.getParameter("user_id");
	String user_pw=request.getParameter("user_pw");
	System.out.println(user_id +user_pw );
	HttpSession  sess=request.getSession();
	
    LoginImpl loginUser= new LoginImpl(user_id,user_pw );
  
    
    
	
    
    System.out.println(sess.isNew());
	
	if(sess.isNew()) {	
		
		sess.setAttribute("loginUser", loginUser);
		userLists.add(loginUser);
		context.setAttribute("userLists", userLists);
	}
	

	
	
//	pw.write("<h6>hihihi</h6>");
	pw.write(loginUser.user_id + "접속합");
	pw.write("현재 접속자 수 " + LoginImpl.total_user + "명");
	
	for (Object login_User : userLists) {
		System.out.println(login_User);
	}
	
	
	pw.write("<a href='logout?user_id=" +user_id + "'> 로그아웃 </a>");
	
//	pw.write("<h1>안녕</h1>");
	
	}
}
