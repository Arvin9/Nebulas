package site.nebulas.util;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Tess4jUtil {
	public static void main(String[] args) {  
        File root = new File(System.getProperty("user.dir") + "/imgs");
        System.out.println(root.getAbsolutePath());
        
        ITesseract instance = new Tesseract();  
        instance.setDatapath(System.getProperty("user.dir"));
        try {  
            File[] files = root.listFiles();  
            for (File file : files) {  
                String result = instance.doOCR(file);  
                String fileName = file.toString().substring(file.toString().lastIndexOf("\\")+1);  
                System.out.println("图片名：" + fileName +" 识别结果："+result);  
            }  
        } catch (TesseractException e) {  
            System.err.println(e.getMessage());  
        }
        
    }  
}
