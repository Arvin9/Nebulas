package site.nebulas.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TxtUtil {
	private static Logger logger = LoggerFactory.getLogger(TxtUtil.class);
	//读Txt
	public static String readTxtFile(String filename){
		//获取classpath
		String userDir = new File(TxtUtil.class.getResource("/").getPath()).toString();
		String filePath = userDir + File.separator + "data" + File.separator+ filename;
		logger.info("txt文件路径" + filePath);
		StringBuffer sb = new StringBuffer();
		try {
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
            	InputStreamReader read = new InputStreamReader(new FileInputStream(file),"utf-8");//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	sb.append(lineTxt);
                }
                read.close();
            }else{
            	logger.error("找不到"+ filename + "文件");
            	return null;
            }
        } catch (Exception e) {
            logger.error("读取"+ filename + "文件出错");
            e.printStackTrace();
            return null;
        }
		logger.info("获取:" + filename + "成功");
        return sb.toString();
    }
	//写Txt
	public static void writeTxtFile(String filename,String str){
		String userDir = new File(TxtUtil.class.getResource("/").getPath()).toString();
		String filePath = userDir + File.separator + "data" + File.separator+ filename;
		logger.info("txt文件路径" + filePath);
		try {      
	        File file = new File(filePath);      
	        if (!file.exists()){       
	        	file.createNewFile();      
	        }      
	        OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(file),"utf-8");      
	        BufferedWriter writer = new BufferedWriter(write);          
	        writer.write(str);      
	        writer.close();     
	    } catch (Exception e){      
	        e.printStackTrace();     
	    }  
	}
	
	public static void main(String[] args) {
		String filePath = "tag.txt";
		/*//System.out.println(readTxtFile(filePath));
		String str = readTxtFile(filePath).toString();
		Gson gson = new Gson();
		List<Map<String,Object>> list = gson.fromJson(str, List.class);
		for(Map<String,Object> map : list){
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
			}
		}*/
		//writeTxtFile("tag2.txt",str);
		//System.out.println(ReadWriteTxt.class.getClassLoader().getResource(""));
		System.out.println(new File(TxtUtil.class.getResource("/").getPath()));
		System.out.println(TxtUtil.readTxtFile("tag.txt"));
		System.out.println(File.separator);
	}
}
