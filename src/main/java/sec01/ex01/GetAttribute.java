package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletContext;    //웹애플리케이션(pro10)
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/get")
public class GetAttribute extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		ServletContext context=getServletContext();

		
		
		ServletContext context=getServletContext();
//		System.out.println(context.getServletContextName()); //pro10
		HttpSession sess=request.getSession();
		String ctxMsg=(String) context.getAttribute("context");
		String sessMsg = (String) sess.getAttribute("session");
		String requestMsg = (String) request.getAttribute("request");
		
		System.out.println(ctxMsg);
		System.out.println(sessMsg);
		System.out.println(requestMsg);
		
	}

}
