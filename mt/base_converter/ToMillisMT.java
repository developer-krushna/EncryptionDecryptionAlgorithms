/*
Source from Modder Hub
*/

package mt.base_converter;

import android.content.Context;
import android.support.annotation.NonNull;
import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Scanner;   

/**
* Created by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 26-Oct-22.
*/
public class ToMillisMT  {
	
	
	
	@NonNull
	
	public static String encode(@NonNull String text) {
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(text.toString());
			int offsetFromUTC = Calendar.getInstance().getTimeZone().getOffset(date.getTime());
			Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
			gmtCal.setTime(date);
			gmtCal.add(14, offsetFromUTC);
			String result = new StringBuilder(String.valueOf(Long.toString(gmtCal.getTime().getTime() / 1000))).append("000").toString();
			Long i = Long.parseLong(result);
			String hexadecimal = Long.toHexString(i);
			return "Milliseconds = "+result+"\nSmali hex ID = "+"0x"+hexadecimal+"L" ;
		} catch (Exception e) {
			return e.toString();
			
		}
	}
	@NonNull
	
	public static String decode(@NonNull String text) {
		
		try {
			final byte[] utf16Bytes= text.getBytes("UTF-8");
			if(utf16Bytes.length == 13){
				
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				
				long milliSeconds= Long.parseLong(text.toString());
				System.out.println(milliSeconds);
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(milliSeconds);
				
				return formatter.format(calendar.getTime());
			} else{
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String decstr = Long.toString(Long.parseLong(text.toString().replace("L",""),16));
				long milliSeconds= Long.parseLong(decstr.toString());
				System.out.println(milliSeconds);
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(milliSeconds);
				return formatter.format(calendar.getTime());
			}
		}catch (Exception e){
			
			return e.toString();    
			
		}
		
		
	}
	
	
}
