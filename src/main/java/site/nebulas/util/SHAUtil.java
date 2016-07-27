package site.nebulas.util;

import org.apache.commons.codec.digest.DigestUtils;

public class SHAUtil {
	private static String encode(String str) {
		return DigestUtils.sha256Hex(str);
	}
	
	
	public static void main(String[] args) {
		System.out.println(encode("Nebula"));
	}
}
