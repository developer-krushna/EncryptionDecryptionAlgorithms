/*
Source from Modder Hub
*/

package mt.base_converter.Base_Encryptions;

import android.content.Context;
import android.support.annotation.NonNull;

import mt.base_converter.interfaces.MTImpl;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.Charset;
/**
@Author and @OriginalCreator  Mr Duy(Codec) on Github on 06-Feb-17.
*/
/* ReCreated by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 26-Oct-22.
*/

public class Base64MT extends MTImpl {
	@NonNull
	@Override
	public String encode(@NonNull String token) {
		setMax(1);
		try {
			byte[] encodedBytes = new Base64().encode(token.getBytes());
			String result = new String(encodedBytes, Charset.forName("UTF-8"));
			setConfident(1);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			setConfident(0);
			return token;
		}
	}
	
	@NonNull
	@Override
	public String decode(@NonNull String token) {
		setMax(1);
		try {
			byte[] decodedBytes = new Base64().decode(token.getBytes());
			String result = new String(decodedBytes, Charset.forName("UTF-8"));
			setConfident(1);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			setConfident(0);
			return token;
		}
	}
	
}
