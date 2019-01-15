package demo;



import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class testService {
			int a = 1;
			int b= 0;
		
		public int testid() {
			List<Record> list = Db.find("select * from bookmg where id = 1");
			if(list.size()>0){
				return a;
			}else{
				return b;
			}
		}
}
