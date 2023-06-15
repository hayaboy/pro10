package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/set")
public class SetAttribute extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ctxMsg="컨텍스트 범위에 바인딩 됨";
		String sessionMsg="세션 범위에 바인딩 됨";
		String requestMsg="리퀙스트 범위에 바인딩 됨";
		
		
		ServletContext context=getServletContext();		
		System.out.println(context.getServletContextName()); //pro10		
		HttpSession sess=request.getSession();
		
		
		context.setAttribute("context", ctxMsg);
		sess.setAttribute("session", sessionMsg);
		request.setAttribute("request", requestMsg);
		System.out.println("바인딩 됨");
		
	}

}
