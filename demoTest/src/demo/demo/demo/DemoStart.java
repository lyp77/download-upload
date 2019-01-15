package demo;
import com.jfinal.core.JFinal;
	
public class DemoStart {

//	@SuppressWarnings("deprecation")
	
	public static void main(String[] args) {
		JFinal.start("WebRoot",8080, "/",5);	
	}

}	
	