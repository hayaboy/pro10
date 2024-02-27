package sec04.ex02;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

//HttpSessionBindingListener 세션에 바인딩되거나 바인딩 해제될 때 개체에 알림이 표시되도록 합니다. 
//HttpSessionBindingListener로는 사용자 전체 접속자 현황이 확인이 안됨
public class LoginImpl implements HttpSessionBindingListener {
	
	String user_id;
	String user_pw;
	static int total_user=0;
	
	
	public LoginImpl() {
	System.out.println("LoginImpl 객체 만들어짐");
	}
	
	
	
	
	
	public LoginImpl(String user_id) {
		super();
		this.user_id = user_id;
	}





	public LoginImpl(String user_id, String user_pw) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
	}





	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("사용자 접속");
		++LoginImpl.total_user;
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("사용자 접속");
		total_user--;
	}
	
	
	
	@Override
	public String toString() {
		
		return user_id;
	}
	
	
	
	
}
