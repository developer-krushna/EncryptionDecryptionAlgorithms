/*
Source from Modder Hub
*/

package mt.base_converter;

import android.content.Context;
import android.support.annotation.NonNull;

import mt.base_converter.interfaces.MTImpl;
import mt.base_converter.MTUtil;

import java.util.ArrayList;

/**
* Created by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 26-Oct-22.
*/
public class OctalMT extends MTImpl {
	
	
	private String octalToText(String text) {
		String[] arr = text.split(" ");
		setMax(arr);
		StringBuilder result = new StringBuilder();
		for (String arg : arr) {
			try {
				int codePoint = Integer.parseInt(arg, 8);
				result.append(Character.toChars(codePoint));
				incConfident();
			} catch (Exception e) {
				result.append(" ").append(arg).append(" ");
			}
		}
		
		
		return result.toString();
		
		
		
	}
	
	@NonNull
	@Override
	public String encode(@NonNull final String text) {
		final ArrayList<Integer> chars = MTUtil.codePointsArr(text);
		setMax(chars.size());
		setConfident(chars.size());
		
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < chars.size(); i++) {
			Integer c = chars.get(i);
			result.append(Integer.toOctalString(c));
			if (i != chars.size() - 1) {
				result.append(" ");
			}
		}
		
		return result.toString();
		
	}
	
	@NonNull
	@Override
	public String decode(@NonNull String text) {
		
		return octalToText(text);
		
		
	}
	
	
}
