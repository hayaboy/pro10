package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
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
		PrintWriter out = response.getWriter();
		String user_id =request.getParameter("user_id");
		
		System.out.println("로그아웃 한 가져온 id"  + user_id );
		
		//로그아웃 시 세션 소멸
		HttpSession  session=request.getSession();
		session.invalidate();
		
		List user_list=(List) context.getAttribute("user_list");
		user_list.remove(user_id);
		
		//컨텍스트에서 삭제후 다시 설정
		context.removeAttribute("user_list");
		context.setAttribute("user_list", user_list);
		
		for (int i = 0; i < user_list.size(); i++) {
			out.println(user_list.get(i) + "<br>");
		}
		
		
		out.println("<br>로그아웃 했습니다.");
	}
	

}
