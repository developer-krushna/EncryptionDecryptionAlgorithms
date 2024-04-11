/*
Source from Modder Hub
*/

package mt.base_converter.interfaces;

import android.support.annotation.NonNull;

/**
* ReCreated by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 26-Oct-22.
*/

public interface Decoder {
	@NonNull
	String decode(@NonNull String text);
	
	int getMax();
	
	int getConfident();
}
