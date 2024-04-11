package mt.base_converter;

import java.io.ByteArrayOutputStream;

public class NPFogNormal {
	/**
	* Created by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 02-Feb-23.
	*/
	
	private static final String hexString = "0123456789ABCDEF";
	
	public static String decode(String str, String KEY) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream(str.length() / 2);
		for (int i = 0; i < str.length(); i += 2) {
			baos.write((hexString.indexOf(str.charAt(i)) << 4) | hexString.indexOf(str.charAt(i + 1)));
		}
		byte[] b = baos.toByteArray();
		int len = b.length;
		int keyLen = KEY.length();
		for (int i2 = 0; i2 < len; i2++) {
			b[i2] = (byte) (b[i2] ^ KEY.charAt(i2 % keyLen));
		}
		return new String(b);
	}
	public static String encode(String str, String KEY) {
		int i = 0;
		byte[] bytes = str.getBytes();
		int length = bytes.length;
		int length2 = KEY.length();
		for (int i2 = 0; i2 < length; i2++) {
			bytes[i2] = (byte) (bytes[i2] ^ KEY.charAt(i2 % length2));
		}
		StringBuilder encode = new StringBuilder(bytes.length * 2);
		while (i < bytes.length) {
			encode.append(hexString.charAt((bytes[i] & 240) >> 4));
			encode.append(hexString.charAt((bytes[i] & 15) >> 0));
			i++;
		}
		return encode.toString();
	}
}
