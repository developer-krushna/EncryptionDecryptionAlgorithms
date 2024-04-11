package mt.base_converter;

import android.content.Context;
import android.support.annotation.NonNull;


/**
* Created by Duy on 08-Aug-17.
*/

public class CaesarMT extends mt.base_converter.interfaces.MTImpl {
	private static final String NORMAL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toUpperCase();
	private int offset;
	
	public CaesarMT() {
		this(1);
	}
	
	public CaesarMT(int offset) {
		this.offset = offset;
	}
	
	
	@NonNull
	@Override
	public String decode(@NonNull String text) {
		return encode(text, 26 - offset);
	}
	
	@NonNull
	@Override
	public String encode(@NonNull String text) {
		return encode(text, offset);
	}
	
	private String encode(String text, int offset) {
		setMax(text.length());
		setConfident(0);
		
		//Take the offset mod 26 then add 26
		offset = offset % 26 + 26;
		//Declare a StringBuilder to access individual parts of the String
		StringBuilder encoded = new StringBuilder();
		//Iterate through all characters in String enc
		for (char i : text.toCharArray()) {
			//Nested ifs to shift individual elements of the character array
			if (Character.isLetter(i)) {
				//Check for upper case/lower case
				if (Character.isUpperCase(i)) {
					//Append character + offset (taking into account wraparound)
					encoded.append((char) ('A' + (i - 'A' + offset) % 26));
				}
				//Append character + offset (taking into account wraparound)
				else {
					encoded.append((char) ('a' + (i - 'a' + offset) % 26));
				}
				incConfident();
			} else {
				//Append characcter to StringBuilder object
				encoded.append(i);
			}
		}
		//Return encoded string
		return encoded.toString();
	}
	
	
	
	
}
