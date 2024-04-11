/*
Source from Modder Hub
*/

package mt.base_converter;

import android.content.Context;
import android.support.annotation.NonNull;

import mt.base_converter.interfaces.MTImpl;
import mt.base_converter.MTUtil;
import org.apache.commons.codec.binary.Hex;
import java.util.ArrayList;

/**
* Created by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 26-Oct-22.
*/

public class HexMT extends MTImpl {
	
	/**
	@Maharna's Tech
	* convert text to hex
	*/
	private String hexToTex(String text) {
		try{
			byte[] bytes = Hex.decodeHex(text.toCharArray());
			return new String(bytes, "UTF-8").toString();
		}catch(Exception e){
			return "Error";
			
		}
		
		
		
		
	}
	
	/**
	@Maharna's Tech
	* convert text to hex
	*/
	private String textToHex(String text) {
		StringBuffer hex = new StringBuffer();
		
		// loop chars one by one
		for (char temp : text.toCharArray()) {
			
			// convert char to int, for char `a` decimal 97
			int decimal = (int) temp;
			
			// convert int to hex, for decimal 97 hex 61
			hex.append(Integer.toHexString(decimal));
		}
		
		return hex.toString();
	}
	
	@NonNull
	@Override
	public String encode(@NonNull String text) {
		return textToHex(text);
	}
	
	@NonNull
	@Override
	public String decode(@NonNull String text) {
		return hexToTex(text);
	}
	
}
