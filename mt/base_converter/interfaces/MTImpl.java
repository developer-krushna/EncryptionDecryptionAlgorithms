/*
Source from Modder Hub
*/

package mt.base_converter.interfaces;
import bin.mt.plugin.api.MTPluginContext;
import android.content.Context;

/**
* ReCreated by @Maharna's Tech (Subscribe our Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 26-Oct-22.
*/

public abstract class MTImpl implements MT {
	
	protected int max = 0;
	protected int confident = 0;
	
	@Override
	public int getMax() {
		return max;
	}
	
	public void setMax(int max) {
		this.max = max;
	}
	
	protected void setMax(char[] arr) {
		setMax(arr.length);
	}
	
	protected void setMax(Object[] arr) {
		setMax(arr.length);
	}
	
	@Override
	public int getConfident() {
		return confident;
	}
	
	public void setConfident(int confident) {
		this.confident = confident;
	}
	
	public void incConfident() {
		confident++;
	}
	
	
}
