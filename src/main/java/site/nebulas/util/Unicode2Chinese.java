package site.nebulas.util;

public class Unicode2Chinese {
	public String convert(String utfString){  
	    StringBuilder sb = new StringBuilder();  
	    int i = -1;  
	    int pos = 0;  
	      
	    while((i=utfString.indexOf("\\u", pos)) != -1){  
	        sb.append(utfString.substring(pos, i));  
	        if(i+5 < utfString.length()){  
	            pos = i+6;  
	            sb.append((char)Integer.parseInt(utfString.substring(i+2, i+6), 16));  
	        }  
	    }  
	      
	    return sb.toString();  
	}  
	
	public static void main(String[] args) {
		Unicode2Chinese uc = new Unicode2Chinese();
		System.out.println("hello");
		System.out.println(uc.convert("\\u4f60\\u597d"));
	}
}
