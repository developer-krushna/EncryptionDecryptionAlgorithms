/*
Source from Modder Hub
*/

package mt.base_converter;
import java.lang.Character;
import mt.base_converter.interfaces.BeaufortImpl;

/**
* ReCreated by @Maharna's Tech (Subscribe our YT Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 4-Dec-22.
*/


public class BeaufortMT implements BeaufortImpl {
	
	private char[][] table;
	private char[] cols;
	private char[] rows;
	
	
	private char[][] getTable() {
		if (this.table == null) {
			this.createTable();
		}
		return this.table;
	}
	
	
	public char[] getCols() {
		if (this.cols == null) {
			this.cols = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		}
		return this.cols;
	}
	
	
	public char[] getRows() {
		if (this.rows == null) {
			this.rows = "ZYXWVUTSRQPONMLKJIHGFEDCBA".toCharArray();
		}
		return this.rows;
	}
	
	
	private void createTable() {
		char[][] table = new char[26][26];
		table[0] = "ZYXWVUTSRQPONMLKJIHGFEDCBA".toCharArray();
		
		for (int i = 1; i < 26; i++) {
			for (int j = 1; j < 26; j++) {
				table[i][j - 1] = table[i - 1][j];
			}
			table[i][25] = table[i - 1][0];
		}
		
		this.table = table;
	}
	
	
	@Override
	public String removeInvalidCharacters(String s) {
		
		return null;
	}
	
	
	@Override
	public String encrypt(String key, String text) {
		
		// Init local variables
		char[] textArray = text.toCharArray();
		char[] keyArray = key.toCharArray();
		StringBuilder cipherStringBuilder = new StringBuilder(text.length());
		
		int inputStringIterator = 0;
		while (inputStringIterator < textArray.length) { // Iterates over the whole string
			
			// Init the column iterator
			int columnIterator = 0;
			
			// Iterates over the password/columns
			while (columnIterator < keyArray.length && inputStringIterator < textArray.length) {
				
				// Get indexes
				int rowIndex = this.getIndexOfColCharacter(textArray[inputStringIterator]);
				int colIndex = -1;
				if(rowIndex > -1) {
					colIndex = this.getIndexOfRowCharacter(keyArray[columnIterator]);
				}
				
				// Append to the ciphered text and iterate
				if (rowIndex > -1 && colIndex > -1) {
					cipherStringBuilder.append(this.getTable()[rowIndex][colIndex]);
					inputStringIterator++;
					columnIterator++;
				} else {
					inputStringIterator++;
				}
			}
		}
		
		return cipherStringBuilder.toString();
	}
	
	
	@Override
	public String decrypt(String key, String text) {
		
		char[] keyArray = key.toCharArray();
		char[] textArray = text.toCharArray();
		StringBuilder openStringBuilder = new StringBuilder(text.length());
		
		int inputStringIterator = 0;
		while (inputStringIterator < textArray.length) { // Iterates over the whole string
			
			// Init the column iterator
			int columnIterator = 0;
			
			// Iterates over the password/columns
			while (columnIterator < keyArray.length && inputStringIterator < textArray.length) {
				
				// Get indexes
				int rowIndex = this.getIndexOfRowCharacter(keyArray[columnIterator]);
				int colIndex = -1;
				if (rowIndex >= 0) {
					colIndex = this.getIndexOfTableCharacter(textArray[inputStringIterator], rowIndex);
				}
				
				// Append to the ciphered text and iterate
				if(rowIndex != -1 && colIndex != -1) {
					openStringBuilder.append(Character.toUpperCase(this.getCols()[colIndex]));
					inputStringIterator++;
					columnIterator++;
				} else {
					inputStringIterator++;
				}
			}
		}
		
		return openStringBuilder.toString();
	}
	
	/**
	* Returns row number of the given character.
	* Returns -1 if the character was not found.
	*
	* @param c The character.
	* @return The row number.
	*/
	private int getIndexOfRowCharacter(char c) {
		for (int i = 0; i < 26; i++) {
			if (this.getRows()[i] == Character.toUpperCase(c)) {
				return i;
			}
		}
		return -1; // Fallback
	}
	
	
	private int getIndexOfColCharacter(char c) {
		for (int i = 0; i < 26; i++) {
			if (this.getCols()[i] == Character.toLowerCase(c)) {
				return i;
			}
		}
		return -1; // Fallback
	}
	
	
	private int getIndexOfTableCharacter(char c, int row) {
		for (int i = 0; i < 26; i++) {
			if (this.getTable()[row][i] == Character.toUpperCase(c)) {
				return i;
			}
		}
		return -1; // Fallback
	}
}
