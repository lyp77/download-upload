package demo;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Config;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

public class testconfig extends JFinalConfig{
	public static String  localPath = PathKit.getWebRootPath()+"/downloadTest/" ;
	public static void main(String[] args) {
		JFinal.start("WebRoot",8080,"/",5);
	}
	
	public void configConstant(Constants me){
			me.setDevMode(true);
			me.setEncoding("UTF-8");
			me.setViewType(ViewType.JSP);
		}

	  public void configRoute(Routes me){
		 // me.setBaseViewPath("/view");
		  me.add("/web", HelloController.class);
	  }
	  public void configEngine(Engine me){
	  }
	  public void configHandler(Handlers me){}
	public void configInterceptor(Interceptors me){
			
	}@BeforeClass
	public void configPlugin(Plugins me) {			
		loadPropertyFile("adopconfig.txt");
		DruidPlugin  adop = new DruidPlugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password"));
		me.add(adop);
		ActiveRecordPlugin oppo = new ActiveRecordPlugin("adminopon",adop);
		me.add(oppo);
		
	}


}
