/*
Source from Modder Hub
*/

package mt.base_converter;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;

/**
* ReCreated by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 26-Oct-22.
*/

public class MTUtil {
	@NonNull
	public static Iterable<Integer> codePoints(final String string) {
		return new Iterable<Integer>() {
			@NonNull
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {
					int nextIndex = 0;
					
					public boolean hasNext() {
						return nextIndex < string.length();
					}
					
					public Integer next() {
						int result = string.codePointAt(nextIndex);
						nextIndex += Character.charCount(result);
						return result;
					}
					
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
	
	public static ArrayList<Integer> codePointsArr(String text) {
		Iterable<Integer> iterable = codePoints(text);
		ArrayList<Integer> codePoints = new ArrayList<>();
		for (Integer codePoint : iterable) {
			codePoints.add(codePoint);
		}
		return codePoints;
	}
}
