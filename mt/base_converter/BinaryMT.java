/*
Source from MODDER HUB
*/

package mt.base_converter;

import android.content.Context;
import android.support.annotation.NonNull;

import mt.base_converter.interfaces.MTImpl;
import mt.base_converter.MTUtil;

import java.util.ArrayList;

/**
@Author and @Creator  Mr Duy on Github on 06-Feb-17.
*/
/* ReCreated by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 26-Oct-22.
*/

public class BinaryMT extends MTImpl {
	
	/**
	@Maharna's Tech
	* convert text to binary
	* text ->  01100110 01101111 01101111
	*/
	private String textToBinary(String text) {
		ArrayList<Integer> codePoints = MTUtil.codePointsArr(text);
		setMax(codePoints.size());
		
		StringBuilder binary = new StringBuilder();
		for (int i = 0; i < codePoints.size(); i++) {
			Integer codePoint = codePoints.get(i);
			try {
				String bin = Integer.toBinaryString(codePoint);
				bin = appendZero(bin);
				binary.append(bin);
				if (i != codePoints.size() - 1) {
					binary.append(' ');
				}
				incConfident();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return binary.toString();
	}
	
	private String appendZero(String binary) {
		int length = binary.length();
		int count = 8;
		while (count < length) count += 8;
		StringBuilder binBuilder = new StringBuilder(binary);
		while (binBuilder.length() < count) binBuilder.insert(0, "0");
		return binBuilder.toString();
	}
	
	
	/**
	@Maharna's Tech
	* convert binary to text
	* 01100110 01101111 01101111 -> text..
	*
	* @param text input
	* @return unicode text from binary
	*/
	private String binaryToText(String text) {
		StringBuilder builder = new StringBuilder();
		String[] arr = text.split(" ");
		setMax(arr);
		for (String arg : arr) {
			try {
				int codePoint = Integer.parseInt(arg, 2);
				builder.append(Character.toChars(codePoint));
				incConfident();
			} catch (Exception e) {
				builder.append(" ").append(arg).append(" ");
			}
		}
		return builder.toString();
	}
	
	
	@NonNull
	@Override
	public String encode(@NonNull String text) {
		return textToBinary(text);
	}
	
	@NonNull
	@Override
	public String decode(@NonNull String text) {
		return binaryToText(text);
	}
	
}
