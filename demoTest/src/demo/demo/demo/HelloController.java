package demo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Random;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;
@Before(demoInterceptor.class)
public class HelloController extends Controller {
	DemoConfig demoConfig;
	demoService demoTest = new demoService();
	public void index(){	
		render("index.html");
	}
	public void fileDown() {
		File file =new File(DemoConfig.localPath+"blood.jpg");
		System.out.println(file);
		if (file.exists()){
			renderFile(file);
		}else{
			renderJson();	
}
}/*****************/
	public void finD() {
		String aString =getPara("bookname");
		String bString = demoTest.findbookname(aString);
		renderText(bString+"<a href=\"./\"></a>");

	}
	public void  add() {
		String aString =getPara("bookname");
		String a = demoTest.insertById(aString);
		renderText(a);
	}
	public void deletE() {
		Integer aInteger = getParaToInt("id");
		demoTest.deletename(aInteger);
		renderHtml("delete Succeed!!!<a href=\"./\">back</a>");
	}
	public void updatename(){
		String aString =getPara("name");
		demoTest.updatename(aString);
		renderHtml("update Succeed!!<a href= \"./\">back</a>");	
	}
	
	
/********************/
	public void uploadFile(){
		int max = 500;
		UploadFile uploadFile = this.getFile();
		String fileName = "桥本ssni-" + new Random().nextInt(max);
		File file = uploadFile.getFile();
		System.out.println(file+"|*****|"+uploadFile);
		String path = DemoConfig.localPath+fileName+file.getName().substring(file.getName().lastIndexOf("."));
		System.out.println(fileName);
		File getFile =new File(path);
		try{
			getFile.createNewFile();
		}catch (IOException e) {
			e.printStackTrace();
			
		}
		fileChannelCopy(file, getFile);
		file.delete();
		renderText("upload Succeed!");
//		this.renderHtml("success,<a href=\"./\">back</a>");
	}
	public void fileChannelCopy(File org,File cre){
		RandomAccessFile ip = null;
		RandomAccessFile op = null;
		FileChannel in = null;
		FileChannel ou =null ;
		try {
			ip =new RandomAccessFile(org,"rw");
			op =new RandomAccessFile(cre,"rw");
			in =ip.getChannel();
			ou = op.getChannel();
			in.transferTo(0, in.size(), ou);
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try{
				ip.close();
				op.close();
				in.close();
				ou.close();
			}catch (IOException e) {
				
			}
		}
		
		
	}
	public void test1(){
		List<Record> list =Db.use("adminopon").find("select * from bookmg");
		renderText(list.toString());
	}
	public void  test2() {
		List<Record> list = Db.find("select * from adminlogin");
		renderText(list.toString());
	}
	public void test() {
		List<Record>list = Db.find("select * from mage_user ");
		for(int i=0;i<list.size();i++){
			list.get(i).getColumns().replace("password", 1);
		}
		String aString =list.toString();
		renderText(aString);
	}
		
	}
	

