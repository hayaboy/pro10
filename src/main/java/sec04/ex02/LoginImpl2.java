package sec04.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class LoginImpl2 implements  HttpSessionListener{  //HttpSessionlifecycle 변경에 대한 알림 이벤트를 수신하기 위한 인터페이스입니다.
	//이러한 알림 이벤트를 수신하려면 구현 클래스를 웹 애플리케이션의 배포 설명자에서 선언하거나 WebListener로 주석을 달거나 ServletContext에 정의된 addListener 메소드 중 하나를 통해 등록해야 합니다.

	//이 인터페이스의 구현은 선언된 순서대로 sessionCreated(javax.servlet.http.HttpSessionEvent) 메소드에서 호출되고, sessionDestroyed(javax.servlet.http.HttpSessionEvent) 메소드에서 역순으로 호출됩니다.
	String user_id;
	String user_pw;
	static int total_user = 0;

	public LoginImpl2() {
	}

	public LoginImpl2(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("사용자 접속");
		++total_user;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("사용자 접속 해제");
		--total_user;
	}
}
