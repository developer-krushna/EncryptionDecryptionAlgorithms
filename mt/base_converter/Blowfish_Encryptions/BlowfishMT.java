/*
Source from Modder Hub
*/

package mt.base_converter.Blowfish_Encryptions;

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;

public class BlowfishMT {
	
	/* Created by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 26-Oct-22.
	*/
	public static String encode(String text, String key) {
		
		try {
			SecretKeySpec sks = new SecretKeySpec(key.getBytes("UTF-8"), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, sks);
			
			byte[] enc = cipher.doFinal(text.getBytes());
			return android.util.Base64.encodeToString(enc,android.util.Base64.DEFAULT).trim();
		} catch (Exception e) {
			return "Error encrypting Blowfish";
			
		}
		
	}
	
	public static String decode(String text, String key) {
		
		try {
			
			SecretKeySpec sks = new SecretKeySpec(key.getBytes("UTF-8"), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, sks);
			
			byte[] dec = cipher.doFinal(android.util.Base64.decode(text,android.util.Base64.DEFAULT));
			return new String(dec).trim();
			
		} catch (Exception e) {
			return "Error Decrypting Blowfish.\n Plz check your password in preference manager then try again 👍";
			
		}
		
	}
	
}
