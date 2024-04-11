/**
Source from Modder Hub
*/
package mt.base_converter.ASCII_Encryptions;

import android.content.Context;
import android.support.annotation.NonNull;

import mt.base_converter.interfaces.MTImpl;
import mt.base_converter.MTUtil;

import java.util.Iterator;

/**
* @Author and @Creator  Mr Duy on Github on 06-Feb-17.
*/

/* ReCreated by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 26-Oct-22.
*/

public class AsciiMT extends MTImpl {
	private String asciiToText(String text) {
		String[] arr = text.split(" ");
		setMax(arr.length);
		StringBuilder result = new StringBuilder();
		for (String codePoint : arr) {
			try {
				result.append(Character.toChars(Integer.parseInt(codePoint)));
				incConfident();
			} catch (Exception e) {
				result.append(codePoint);
			}
		}
		return result.toString();
	}
	
	private String textToAscii(String text) {
		setMax(text.length());
		setConfident(text.length());
		
		StringBuilder result = new StringBuilder();
		Iterator<Integer> codePoints = MTUtil.codePoints(text).iterator();
		while (codePoints.hasNext()) {
			result.append(codePoints.next());
			if (codePoints.hasNext()) {
				result.append(" ");
			}
		}
		return result.toString();
	}
	
	@NonNull
	@Override
	public String encode(@NonNull String text) {
		return textToAscii(text);
	}
	
	@NonNull
	@Override
	public String decode(@NonNull String text) {
		return asciiToText(text);
	}
	
}
