/*
Source from Modder Hub
*/

package mt.base_converter;

public class AbtashMT {
	
	public static String encode(String text) {
		text = text.toLowerCase();
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			char character = text.charAt(i);
			if (character == 'a') { result = result + "z"; }
			else if (character == 'b') { result = result + "y"; }
			else if (character == 'c') { result = result + "x"; }
			else if (character == 'd') { result = result + "w"; }
			else if (character == 'e') { result = result + "v"; }
			else if (character == 'f') { result = result + "u"; }
			else if (character == 'g') { result = result + "t"; }
			else if (character == 'h') { result = result + "s"; }
			else if (character == 'i') { result = result + "r"; }
			else if (character == 'j') { result = result + "q"; }
			else if (character == 'k') { result = result + "p"; }
			else if (character == 'l') { result = result + "o"; }
			else if (character == 'm') { result = result + "n"; }
			else if (character == 'n') { result = result + "m"; }
			else if (character == 'o') { result = result + "l"; }
			else if (character == 'p') { result = result + "k"; }
			else if (character == 'q') { result = result + "j"; }
			else if (character == 'r') { result = result + "i"; }
			else if (character == 's') { result = result + "h"; }
			else if (character == 't') { result = result + "g"; }
			else if (character == 'u') { result = result + "f"; }
			else if (character == 'v') { result = result + "e"; }
			else if (character == 'w') { result = result + "d"; }
			else if (character == 'x') { result = result + "c"; }
			else if (character == 'y') { result = result + "b"; }
			else if (character == 'z') { result = result + "a"; }
			else { result = result + String.valueOf(character); }
			
		}
		return result;
	}
	
	public static String decode(String text) {
		text = text.toLowerCase();
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			char character = text.charAt(i);
			if (character == 'z') { result = result + "a"; }
			else if (character == 'y') { result = result + "b"; }
			else if (character == 'x') { result = result + "c"; }
			else if (character == 'w') { result = result + "d"; }
			else if (character == 'v') { result = result + "e"; }
			else if (character == 'u') { result = result + "f"; }
			else if (character == 't') { result = result + "g"; }
			else if (character == 's') { result = result + "h"; }
			else if (character == 'r') { result = result + "i"; }
			else if (character == 'q') { result = result + "j"; }
			else if (character == 'p') { result = result + "k"; }
			else if (character == 'o') { result = result + "l"; }
			else if (character == 'n') { result = result + "m"; }
			else if (character == 'm') { result = result + "n"; }
			else if (character == 'l') { result = result + "o"; }
			else if (character == 'k') { result = result + "p"; }
			else if (character == 'j') { result = result + "q"; }
			else if (character == 'i') { result = result + "r"; }
			else if (character == 'h') { result = result + "s"; }
			else if (character == 'g') { result = result + "t"; }
			else if (character == 'f') { result = result + "u"; }
			else if (character == 'e') { result = result + "v"; }
			else if (character == 'd') { result = result + "w"; }
			else if (character == 'c') { result = result + "x"; }
			else if (character == 'b') { result = result + "y"; }
			else if (character == 'a') { result = result + "z"; }
			else { result = result + String.valueOf(character); }
			
		}
		return result;
	}
	
}
