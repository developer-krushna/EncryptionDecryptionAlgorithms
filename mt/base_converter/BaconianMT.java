/*
Source from Modder Hub
*/

package mt.base_converter;


import java.util.Vector;
/**
* ReCreated by @Maharna's Tech (Subscribe our YT Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 4-Dec-22.
*/

public class BaconianMT {
	
	public static String encode(String text) {
		text = text.toLowerCase();
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			char character = text.charAt(i);
			if (character == 'a') { result += "aaaaa"; }
			else if (character == 'b') { result += "aaaab"; }
			else if (character == 'c') { result += "aaaba"; }
			else if (character == 'd') { result += "aaabb"; }
			else if (character == 'e') { result += "aabaa"; }
			else if (character == 'f') { result += "aabab"; }
			else if (character == 'g') { result += "aabba"; }
			else if (character == 'h') { result += "aabbb"; }
			else if (character == 'i') { result += "abaaa"; }
			else if (character == 'j') { result += "abaab"; }
			else if (character == 'k') { result += "ababa"; }
			else if (character == 'l') { result += "ababb"; }
			else if (character == 'm') { result += "abbaa"; }
			else if (character == 'n') { result += "abbab"; }
			else if (character == 'o') { result += "abbba"; }
			else if (character == 'p') { result += "abbbb"; }
			else if (character == 'q') { result += "baaaa"; }
			else if (character == 'r') { result += "baaab"; }
			else if (character == 's') { result += "baaba"; }
			else if (character == 't') { result += "baabb"; }
			else if (character == 'u') { result += "babaa"; }
			else if (character == 'v') { result += "babab"; }
			else if (character == 'w') { result += "babba"; }
			else if (character == 'x') { result += "babbb"; }
			else if (character == 'y') { result += "bbaaa"; }
			else if (character == 'z') { result += "bbaab"; }
			else { result = result + String.valueOf(character); }
			
		}
		return result;
	}
	
	public static String decode(String text) {
		String result = "";
		
		Vector<Integer> spaceIndex = new Vector<Integer>();
		int i = text.indexOf(' ');
		while (i >= 0) {
			spaceIndex.add(i / 5);
			i = text.indexOf(' ', i + 1);
		}
		
		String text2 = text.replaceAll("[^a-zA-Z]", "");
		String[] tokens = text2.split("(?<=\\G.{5})");
		for (i = 0; i < tokens.length; i++) {
			if (spaceIndex.contains(i)) {
				result += " ";
			}
			String token = tokens[i];
			System.out.println(token);
			if (token.equals("aaaaa")) { result += "a"; }
			else if (token.equals("aaaab")) { result += "b"; }
			else if (token.equals("aaaba")) { result += "c"; }
			else if (token.equals("aaabb")) { result += "d"; }
			else if (token.equals("aabaa")) { result += "e"; }
			else if (token.equals("aabab")) { result += "f"; }
			else if (token.equals("aabba")) { result += "g"; }
			else if (token.equals("aabbb")) { result += "h"; }
			else if (token.equals("abaaa")) { result += "i"; }
			else if (token.equals("abaab")) { result += "j"; }
			else if (token.equals("ababa")) { result += "k"; }
			else if (token.equals("ababb")) { result += "l"; }
			else if (token.equals("abbaa")) { result += "m"; }
			else if (token.equals("abbab")) { result += "n"; }
			else if (token.equals("abbba")) { result += "o"; }
			else if (token.equals("abbbb")) { result += "p"; }
			else if (token.equals("baaaa")) { result += "q"; }
			else if (token.equals("baaab")) { result += "r"; }
			else if (token.equals("baaba")) { result += "s"; }
			else if (token.equals("baabb")) { result += "t"; }
			else if (token.equals("babaa")) { result += "u"; }
			else if (token.equals("babab")) { result += "v"; }
			else if (token.equals("babba")) { result += "w"; }
			else if (token.equals("babbb")) { result += "x"; }
			else if (token.equals("bbaaa")) { result += "y"; }
			else if (token.equals("bbaab")) { result += "z"; }
		}
		return result;
	}
	
}
