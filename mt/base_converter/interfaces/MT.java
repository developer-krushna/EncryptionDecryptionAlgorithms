/*
Source From Modder Hub
*/

package mt.base_converter.interfaces;

import android.content.Context;
import android.support.annotation.NonNull;

/**
* ReCreated by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 26-Oct-22.
*/
public interface MT extends Decoder, Encoder {
	@NonNull
	
	
	int getMax();
	
	int getConfident();
}
