package site.nebulas.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class RuntimeUtil {
	public static void main(String[] args) {
		String gcc = "cmd + /c C:\\MinGW\\bin\\gcc -o test test.c";
		String exe = "E:\\test";
		String[] command = new String[]{"cmd","/C","C:\\MinGW\\bin\\gcc","E:\\test.c","-o","E:\\test"};
		execute(command);
	}
	
	public static void execute(String[] command){
		Runtime rt=Runtime.getRuntime();
		Process p = null;
		try {
			p = rt.exec(command);
			int exitVal = p.waitFor(); // 阻塞当前线程，并等待外部程序中止后获取结果码
			System.out.println(exitVal == 0 ? "成功" : "失败");
			String s;
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getErrorStream(),"GB2312"));
			System.out.println('1'+bufferedReader.readLine());
			while((s=bufferedReader.readLine()) != null)
				System.out.println(s);
			
			bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream(),"GB2312"));
			System.out.println('2'+bufferedReader.readLine());
			while((s=bufferedReader.readLine()) != null)
				System.out.println(s);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	public static void execute(String command){
		Runtime rt=Runtime.getRuntime();
		Process p = null;
		try {
			p = rt.exec(command, null, new File("e:"));
			int exitVal = p.waitFor(); // 阻塞当前线程，并等待外部程序中止后获取结果码
			System.out.println(exitVal == 0 ? "成功" : "失败");
			String s;
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getErrorStream(),"GB2312"));
			System.out.println('1'+bufferedReader.readLine());
			while((s=bufferedReader.readLine()) != null)
				System.out.println(s);
			
			bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream(),"GB2312"));
			System.out.println('2'+bufferedReader.readLine());
			while((s=bufferedReader.readLine()) != null)
				System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
