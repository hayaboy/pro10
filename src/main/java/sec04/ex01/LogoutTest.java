package sec04.ex01;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/logout")
public class LogoutTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context=null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기는 로그아웃");
		context =getServletContext();
	
		String user_id =request.getParameter("user_id");
		
		System.out.println("로그아웃 한 가져온 id"  + user_id );
		
		//로그아웃 시 세션 소멸
		HttpSession  session=request.getSession();
		session.invalidate();
		
		ArrayList userLists2=(ArrayList) context.getAttribute("userLists");
		

		System.out.println(userLists2.remove(user_id));
//		System.out.println(userLists2.remove(new LoginImpl(user_id)));
		
		System.out.println("세션 소멸");
		
	
		
		//컨텍스트에서 다시 셋팅
		
		context.removeAttribute("userLists");
		
		context.setAttribute("userLists2",userLists2 );
		
		for(Object user : userLists2) {
			System.out.println(user);
		}
		
		
	}
	

}
