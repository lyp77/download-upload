package demo;

import java.nio.channels.SelectableChannel;
import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
public class demoService extends Controller{
	public String findbookname(String bookname) {
		List<Record> list  = Db.use("adminopon").find("select * from bookmg where bookname = ?",bookname);
		String a = list.toString();
		String b = "f*** ur slv!!";
		if(a!=null){			
		return a ;
				}
		else{					
		return b ; 
				}
	}
	public String insertById(String name){
		Record  aRecord = new Record().set("bookname", "golang").set("username", name);
		Db.use("adminopon").save("bookmg", aRecord);
		List<Record> list = Db.use("adminopon").find("select * from bookmg");
		String bString= list.toString();
		return bString;
	}
	public void deletename(Integer id) {
		List<Record> list = Db.use("adminopon").find("select * from bookmg");
		System.out.println("delete before:"+list.toString());
		Db.use("adminopon").deleteById("bookmg", id);
		List<Record> aList =Db.use("adminopon").find("select * from bookmg");
		System.out.println("delete after:"+aList.toString());		
	}
	public void  updatename(String name) {
		List<Record> list = Db.use("adminopon").find("select * from bookmg");
		System.out.println("update before:"+list.toString());
		Record a = new Record();
		a = Db.use("adminopon").findById("bookmg", 1).set("username", name);
		Db.use("adminopon").update("bookmg", a);
		List<Record> aList =Db.use("adminopon").find("select * from bookmg");
		System.out.println("update after:"+aList.toString());
	}
}
