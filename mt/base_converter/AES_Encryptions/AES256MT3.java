package mt.base_converter.AES_Encryptions;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import android.util.Base64;



 /* Created by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 10-Apr-23.
 */
 
 /* Answer got from HowToDoInJava (https://howtodoinjava.com/java/java-security/aes-256-encryption-decryption/)
 */

public class AES256MT3 {


public static String encode(String value, String key, String salt) {
		
		
  
 
    try {
      
 
      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
      KeySpec spec = new PBEKeySpec(key.trim().toCharArray(), salt.getBytes(), 65536, 256);
      SecretKey tmp = factory.generateSecret(spec);
      SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
 
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      IvParameterSpec iv = new IvParameterSpec(new byte[cipher.getBlockSize()]);
      cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
      return Base64.encodeToString(cipher.doFinal(value.getBytes("UTF-8")), Base64.DEFAULT).replaceAll("\n","");
          
          
    } catch (Exception e) {
      return "Error while encrypting: " + e.toString();
    }
    
}
	public static String decode(String value, String key, String salt) {
		
  try {
      
 
      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
      KeySpec spec = new PBEKeySpec(key.toCharArray(), salt.getBytes(), 65536, 256);
      SecretKey tmp = factory.generateSecret(spec);
      SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
 
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      IvParameterSpec iv = new IvParameterSpec(new byte[cipher.getBlockSize()]);
      cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
      return new String(cipher.doFinal(Base64.decode(value.getBytes(), Base64.DEFAULT))).replaceAll("\n","");
    } catch (Exception e) {
      return "Error in password \nMake sure you add your password and salt key for AES-256 in plug-in Preference Manager.. \n The default password and salt key is (MTManager) ....\nand this may not work here...\nSo change it to your password";
    }
    

		
}
	
	

}