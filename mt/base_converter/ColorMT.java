package mt.base_converter;

import android.content.Context;
import android.support.annotation.NonNull;

import mt.base_converter.interfaces.MTImpl;
import mt.base_converter.MTUtil;
import android.graphics.Color;
import java.util.ArrayList;

/**
* Created by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 26-Oct-22.
*/
public class ColorMT extends MTImpl {
	
	public String encode(@NonNull String text) {
		setMax(1);
		try{
			int clrint = Color.parseColor(text);
			return String.valueOf(clrint);
		}catch(Exception e){
			String error = new String("It only can convert color hex (e.g #ff00ffff) to \ninteger (e.g -16711681)");
			return error;
			
		}
		
		
		
		
	}
	
	@NonNull
	@Override
	public String decode(@NonNull String text) {
		setMax(1);
		try{
			return "#"+Integer.toHexString(Integer.parseInt(text));
		}catch(Exception e){
			String error = new String("Error");
			return error;
			
		}
		
	}
	
	
}
