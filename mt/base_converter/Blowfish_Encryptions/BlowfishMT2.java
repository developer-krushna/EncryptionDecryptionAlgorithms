/*
Source from StackOverflow
*/

package mt.base_converter.Blowfish_Encryptions;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import android.util.Base64;

public class BlowfishMT2 {
	
	/* Created by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 2-Feb-23.
	*/
	public static  String encode(String value, String KEY )  {
		
		try {
			SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
			byte[] values = cipher.doFinal(value.getBytes());
			return Base64.encodeToString(values, Base64.DEFAULT).trim();
			
		}catch(Exception e){
			
			return "An error occurred\n\n "+e.toString();
		}
	}
	
	public static  String decode(String value, String KEY)  {
		try {
			byte[] values = Base64.decode(value, Base64.DEFAULT);
			SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
			return new String(cipher.doFinal(values)).trim();
			
		} catch(Exception e){
			
			return "Error in password \nMake sure you add your password in plug-in Preference Manager.. \n There is default password(MTManager) ....\nand this may not work here...\nSo change it to your password\n\n\n"+e.toString();
		}
	}
	
}
