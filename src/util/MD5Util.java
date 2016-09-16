package util;

import java.security.MessageDigest;

public class MD5Util {

	/**
	 * 
	 * @param inStr
	 * @return
	 * @throws Exception
	 */
	public static String MD5Encrypt(String inStr) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5"); 
		byte[] digest = md.digest(inStr.getBytes()); 
		String outStr = byteToString(digest);
		return outStr;
	}

	/**
	 * byteToString
	 * @param digest
	 * @return
	 * @throws Exception
	 */
	private static String byteToString(byte[] digest) throws Exception {
		String str = "";
		String tempStr = "";
		StringBuffer sb = new StringBuffer("");
		for (int i = 1; i < digest.length; i++) {
			tempStr = (Integer.toHexString(digest[i] & 0xff));
			if (tempStr.length()== 1) {
				sb.append("0");
				sb.append(tempStr);
			} else {
				sb.append(tempStr);
			}
		}
		str = sb.toString().toUpperCase();
		return str;
	}
}
