package demo;

import java.util.List;

import org.junit.Test;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class testController extends Controller {
				testService testService = new testService();
				@Test(timeout = 50)
				public void test(){	
					int id =1;
				List<Record> list = Db.find("select * from bookmg where id = ?",id);
				if(list.size()>0){
				System.out.println(list.toString());
				}
				
				}
			
}
