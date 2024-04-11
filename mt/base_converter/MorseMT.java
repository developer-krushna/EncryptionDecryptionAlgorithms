/*
Source from Modder Hub
*/

package mt.base_converter;

import android.content.Context;
import android.support.annotation.NonNull;

import mt.base_converter.interfaces.MTImpl;

import java.util.HashMap;

/**
* Created by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 26-Oct-22.
*/

public class MorseMT extends MTImpl {
	private static final char ALPHABET[] = {
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
		'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	
	private static final String MORSE_CODE[] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
		"....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",
		"-", "..-", "...-", ".--", "-..-", "-.--", "--..", "/",
		"-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----."};
	
	private static final HashMap<Character, String> TEXT_TO_MORSE_CODES;
	private static final HashMap<String, Character> MORSE_CODE_TO_TEXT;
	
	static {
		TEXT_TO_MORSE_CODES = new HashMap<>();
		MORSE_CODE_TO_TEXT = new HashMap<>();
		for (int i = 0; i < ALPHABET.length; i++) {
			TEXT_TO_MORSE_CODES.put(ALPHABET[i], MORSE_CODE[i]);
			MORSE_CODE_TO_TEXT.put(MORSE_CODE[i], ALPHABET[i]);
		}
		if (TEXT_TO_MORSE_CODES.size() != MORSE_CODE_TO_TEXT.size()) {
			throw new RuntimeException("Wrong size");
		}
	}
	
	private String textToMorse(String text) {
		text = text.toLowerCase();
		StringBuilder result = new StringBuilder();
		char[] chars = text.toCharArray();
		setMax(chars.length);
		for (int i = 0; i < chars.length; i++) {
			if (TEXT_TO_MORSE_CODES.get(chars[i]) != null) {
				result.append(TEXT_TO_MORSE_CODES.get(chars[i]));
				if (i != chars.length - 1) result.append(" ");
				incConfident();
			} else {
				result.append(chars[i]);
			}
		}
		return result.toString();
	}
	
	private String morseToText(String text) {
		text = text.toLowerCase();
		String[] chars = text.split("\\s+");
		StringBuilder converted = new StringBuilder();
		setMax(chars);
		for (String aChar : chars) {
			if (MORSE_CODE_TO_TEXT.get(aChar) != null) {
				converted.append(MORSE_CODE_TO_TEXT.get(aChar));
				incConfident();
			} else {
				converted.append(aChar);
			}
		}
		return converted.toString();
	}
	
	@NonNull
	@Override
	public String encode(@NonNull String text) {
		try{
			return textToMorse(text);
		}catch(Exception e){
			return "Error while encoding text (╥﹏╥)";
		}
	}
	
	@NonNull
	@Override
	public String decode(@NonNull String text) {
		try{
			return morseToText(text);
		}catch(Exception e){
			return "Error while decoding text (╥﹏╥)";
		}
	}
	
	
	
}
