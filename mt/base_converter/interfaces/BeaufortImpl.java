/*
Source from Modder Hub
*/

package mt.base_converter.interfaces;

public interface BeaufortImpl {
	
	
	String removeInvalidCharacters(String s);
	
	
	String encrypt(String key, String text);
	
	
	String decrypt(String key, String text);
	
}
