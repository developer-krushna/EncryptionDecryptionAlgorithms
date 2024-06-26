/*
Source from Modder Hub
*/

package mt.base_converter.Base_Encryptions;

import android.content.Context;
import android.support.annotation.NonNull;

import mt.base_converter.interfaces.MTImpl;

import org.apache.commons.codec.binary.Base16;

/**
@Author and @Creator  Mr Duy on Github on 06-Feb-17.
*/
/* Created by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 26-Oct-22.
*/
public class Base16MT extends MTImpl {
	private Base16 base16 = new Base16();
	
	@NonNull
	@Override
	public String encode(@NonNull String text) {
		setMax(1);
		try {
			String result = new String(base16.encode(text.getBytes()));
			setConfident(1);
			return result;
		} catch (Exception e) {
			setConfident(0);
			return text;
		}
	}
	
	@NonNull
	@Override
	public String decode(@NonNull String text) {
		setMax(1);
		try {
			setConfident(1);
			return new String(base16.decode(text.getBytes()));
		} catch (Exception e) {
			setConfident(0);
			return text;
		}
	}
	
	
}
