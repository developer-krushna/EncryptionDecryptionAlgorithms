package mt.base_converter;

import android.content.Context;
import android.support.annotation.NonNull;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;



import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;




/* Created by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 11-Nov-22.
*/

public class DESMT {
	
	
	public String encode(String encrypt, String KEY) {
		
		try {
			SecretKeySpec secretKeySpec = createKey(KEY);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
			
			byte[] charac = encrypt.getBytes("UTF-8");
			byte[] encrypted = cipher.doFinal(charac);
			String encrypted_charac = android.util.Base64.encodeToString(encrypted,android.util.Base64.DEFAULT);
			return encrypted_charac.replaceAll("\n","");
			
		} catch (Exception e) {
			return e.toString();
		}
	}
	
	
	
	public String decode(String decrypt, String KEY) {
		
		try {
			SecretKeySpec secretKeySpec = createKey(KEY);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			
			byte[] charac = android.util.Base64.decode(decrypt,android.util.Base64.DEFAULT);
			byte[] decryption = cipher.doFinal(charac);
			String decrypted_charac = new String(decryption);
			return decrypted_charac.replaceAll("\n","");
			
		} catch (Exception e) {
			return e.toString();
		}
	}
	
	
	public SecretKeySpec createKey(String chave) {
		try {
			byte[] charac = chave.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			charac = md.digest(charac);
			charac = Arrays.copyOf(charac, 8);
			SecretKeySpec secretKeySpec = new SecretKeySpec(charac, "DES");
			return secretKeySpec;
		} catch (Exception e) {
			return null;
		}
		
	}
	
}
