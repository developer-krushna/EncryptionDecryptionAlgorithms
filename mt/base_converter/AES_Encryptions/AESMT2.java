package mt.base_converter.AES_Encryptions;

import android.content.Context;
import android.support.annotation.NonNull;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import android.util.Base64;



 /* Created by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 2-Feb-23.
 */
 
 /* Answer got from StackOverflow (https://stackoverflow.com/questions/40123319/easy-way-to-encrypt-decrypt-string-in-android)
 */

public class AESMT2 {


public static String encode(String value, String key) {
		
		String initVector = "encryptionIntVec";
		try {
			IvParameterSpec iv2 = new IvParameterSpec(key.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			IvParameterSpec iv = new IvParameterSpec(new byte[cipher.getBlockSize()]);
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv2);

			byte[] encrypted = cipher.doFinal(value.getBytes());
			return Base64.encodeToString(encrypted, Base64.DEFAULT).trim();
		} catch (Exception ex) {
			return "An error occurred while encrypting the text\n\n"+ex.toString()+"\n\n Set your password in preference manager (Default key is MTManagerMTMange) .And your password should be 16 character";
		}
	
	}
	public static String decode(String value, String key) {
		
		String initVector = "encryptionIntVec";
		try {
			IvParameterSpec iv2 = new IvParameterSpec(key.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			IvParameterSpec iv = new IvParameterSpec(new byte[cipher.getBlockSize()]);
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv2);
			byte[] original = cipher.doFinal(Base64.decode(value.getBytes(), Base64.DEFAULT));

			return new String(original).trim();
		} catch (Exception ex) {
			return "An error occurred while encrypting the text\n\n"+ex.toString()+"\n\n Set your password in preference manager (Default key is MTManagerMTMange) .And your password should be 16 character";
		}

		
	}
	
	

}