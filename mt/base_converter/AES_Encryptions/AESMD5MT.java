
package mt.base_converter.AES_Encryptions;

import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* Created by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 7-Aug-2023.
*/

public class AESMD5MT {
	private static final String HEX = "0123456789ABCDEF";
	
	private static void appendHex(StringBuffer stringBuffer, byte b) {
		stringBuffer.append(HEX.charAt((b >> 4) & 15));
		stringBuffer.append(HEX.charAt(b & 15));
	}
	
	public static String decrypt(String str, String str2) {
		return new String(decrypt(getRawKey(str.getBytes()), toByte(str2)));
	}
	
	public static String encrypt(String str, String str2) {
		return toHex(encrypt(getRawKey(str.getBytes()), str2.getBytes()));
	}
	
	public static String fromHex(String str) {
		return new String(toByte(str));
	}
	
	public static byte[] getRawKey(byte[] bArr) {
		
		try{
			return new SecretKeySpec(MessageDigest.getInstance("MD5").digest(bArr), "AES").getEncoded();
		}catch(Exception e){
			return null;
		}
		
	}
	
	public static byte[] toByte(String str) {
		int length = str.length() / 2;
		byte[] bArr = new byte[length];
		for (int i = 0; i < length; i++) {
			int i2 = i * 2;
			bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
		}
		return bArr;
	}
	
	public static String toHex(String str) {
		return toHex(str.getBytes());
	}
	
	public static String toHex(byte[] bArr) {
		if (bArr == null) {
			return "";
		}
		StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
		for (byte b : bArr) {
			appendHex(stringBuffer, b);
		}
		return stringBuffer.toString();
	}
	
	public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
		
		try{
			SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(1, secretKeySpec);
			return cipher.doFinal(bArr2);
		}catch(Exception e){
			return null;
		}
	}
	
	public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
		
		try {
			SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(2, secretKeySpec);
			return cipher.doFinal(bArr2);
			
		}catch (Exception e){
			return null;
		}
	}
}
