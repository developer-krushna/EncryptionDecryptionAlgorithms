/*
Source from Modder Hub.
*/

package mt.base_converter.Base_Encryptions;

import android.content.Context;
import android.support.annotation.NonNull;

import mt.base_converter.interfaces.MTImpl;

import org.apache.commons.codec.binary.Base32;

/**
@Author and @Creator  Mr Duy on Github on 06-Feb-17.
*/

/* ReCreated by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 26-Oct-22.
*/

public class Base32MT extends MTImpl {
	private Base32 base32 = new Base32();
	
	@NonNull
	@Override
	public String encode(@NonNull String text) {
		setMax(1);
		try {
			String result = new String(base32.encode(text.getBytes()));
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
			return new String(base32.decode(text.getBytes()));
		} catch (Exception e) {
			setConfident(0);
			return text;
		}
	}
	
	
}
