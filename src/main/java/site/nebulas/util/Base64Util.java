package site.nebulas.util;

import org.apache.commons.codec.binary.Base64;

public class Base64Util {
	/*
	 * 采用饿汉模式
	 * */
	//1.将构造方法私有化，不允许外部直接创造对象。
    private Base64Util(){
    }
    //2.创造类的唯一实例，使用private static修饰
    private static Base64Util base64Util = new Base64Util();
	
    //3.提供一个用于获取实例的方法，使用public static修饰
    public static Base64Util getBase64Util(){
        return base64Util;
    }
	private static Base64 base64 = new Base64();
	private static byte[] base64Byte;
	
	public  String encode(String str){
		base64Byte = base64.encode(str.getBytes());
		return new String(base64Byte);
	}
	public  String decode(String str){
		base64Byte = base64.decode(str.getBytes());
		return new String(base64Byte);
	}
	
	
	public static void main(String[] args) {
		//示例
		String enStr = "Nebula";
		String deStr = "TmVidWxh";
 		System.out.println(Base64Util.getBase64Util().encode(enStr));
		System.out.println(Base64Util.getBase64Util().decode(deStr));
	}
} 
