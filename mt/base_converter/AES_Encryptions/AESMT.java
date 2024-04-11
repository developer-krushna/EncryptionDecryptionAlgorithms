package mt.base_converter.AES_Encryptions;

import android.content.Context;
import android.support.annotation.NonNull;




/* Created by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 11-Nov-22.
*/

public class AESMT {
	
	
	public String encode (final String _string, final String _key) {
		try {
			
			javax.crypto.SecretKey key = generateKey(_key);
			
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES");
			
			c.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
			
			byte[] encVal = c.doFinal(_string.getBytes());
			
			String encrypted = android.util.Base64.encodeToString(encVal,android.util.Base64.DEFAULT);
			
			return encrypted.trim();
		} catch (Exception ex) {
			
			return "Error";
			
		}
	}
	
	
	
	public String decode (final String _string, final String _key) {
		try {
			
			javax.crypto.spec.SecretKeySpec key = (javax.crypto.spec.SecretKeySpec) generateKey(_key);
			
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES");
			
			c.init(javax.crypto.Cipher.DECRYPT_MODE,key);
			
			byte[] decode = android.util.Base64.decode(_string,android.util.Base64.DEFAULT);
			
			byte[] decval = c.doFinal(decode);
			
			String decrypted = new String(decval);
			
			return decrypted.trim();
		} catch (Exception ex) {
			return "Error in password \nMake sure you add your password in plug-in Preference Manager.. \n There is default password(MTManager) ....\nand this may not work here...\nSo change it to your password";
		}
	}
	
	
	private javax.crypto.SecretKey generateKey(String pwd) throws Exception {
		
		final java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
		
		byte[] b = pwd.getBytes("UTF-8");
		
		digest.update(b,0,b.length);
		
		byte[] key = digest.digest();
		
		javax.crypto.spec.SecretKeySpec sec = new javax.crypto.spec.SecretKeySpec(key, "AES");
		
		return sec;
	}
	
	
	
}
