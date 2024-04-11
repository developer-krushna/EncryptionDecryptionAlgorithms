/*
Source from Modder Hub
*/

package mt.base_converter;
/**
* ReCreated by @Maharna's Tech (Subscribe our YT Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 4-Dec-22.
*/

public class VigenereMT {
	public static String encode(String text, String key) {
		
		text = text.toUpperCase();
		key = key.toUpperCase();
		String result = "";
		int counter = 0;
		
		for (int i = 0; i < text.length(); i++) {
			
			char character = text.charAt(i);
			if (character < 'A' || character > 'Z') { continue; }
			result += (char)((character + key.charAt(counter) - 2 * 'A') % 26 + 'A');
			counter = ++counter % key.length();
			
		}
		
		return result;
		
	}
	
	public static String decode(String text, String key) {
		
		text = text.toUpperCase();
		key = key.toUpperCase();
		String result = "";
		int counter = 0;
		
		for (int i = 0; i < text.length(); i++) {
			
			char character = text.charAt(i);
			if (character < 'A' || character > 'Z') { continue; }
			result += (char)((character - key.charAt(counter) +26) % 26 + 'A');
			counter = ++counter % key.length();
			
		}
		
		return result;
	}
	
}
