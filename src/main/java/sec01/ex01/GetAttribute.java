package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/get")
public class GetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
//		ServletContext  context=getServletContext();
//		System.out.println(context.getContextPath());
//		String str=(String) context.getAttribute("contxt");
//		System.out.println(str);
//		
//		
//		HttpSession session = request.getSession();
//		String str2=(String) session.getAttribute("sess");
//		System.out.println(str2);
		
		String str3=(String) request.getAttribute("request");
		System.out.println(str3);
	}

}
