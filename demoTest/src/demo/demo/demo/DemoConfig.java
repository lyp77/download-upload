package demo;

import com.jfinal.config.*;
import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
public class DemoConfig extends JFinalConfig {
	public static String  localPath = PathKit.getWebRootPath()+"/downloadTest/" ;
	
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
@Override
public void configInterceptor(Interceptors me){
		
}
@Override
public void configPlugin(Plugins me) {
	loadPropertyFile("config.properties");
	DruidPlugin adlg = new DruidPlugin(getProperty("jdbcUrl"),
	getProperty("user"), getProperty("password"));
	me.add(adlg);
	ActiveRecordPlugin arp = new ActiveRecordPlugin("adminlogin",adlg);
	me.add(arp);	
	loadPropertyFile("adopconfig.txt");
	DruidPlugin  adop = new DruidPlugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password"));
	me.add(adop);
	ActiveRecordPlugin oppo = new ActiveRecordPlugin("adminopon",adop);
	me.add(oppo);
	
} 
}
