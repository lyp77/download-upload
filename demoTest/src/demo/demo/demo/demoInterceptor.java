package demo;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class demoInterceptor implements Interceptor {
	public void intercept(Invocation inv) {
		   Controller controller = inv.getController();
		   String username =  controller.getSessionAttr("");

			   inv.invoke();
		   
	}
}
