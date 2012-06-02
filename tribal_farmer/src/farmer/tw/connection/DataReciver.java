package farmer.tw.connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import android.util.Log;

import farmer.tw.HtmlEvent;
import farmer.tw.HtmlObjectListener;
import farmer.tw.connection.url.HtmlObject;

/**
 * @author kkalisz
 *
 */
public class DataReciver
{
	private static String LOG_PREFIX = DataReciver.class.getName();
	

	private HashMap<HtmlObjectListener,String> mListeners = new HashMap<HtmlObjectListener,String>();

	
	/**
	 * @param aListener
	 * @param aRequiredScreen - wartosc parmetru "screen" urla, jesli wartoscisie zgadzaja listener dostanie callback
	 *  aRequiredScreen == null kazdy pakiet przechodzi
	 **/
	public synchronized void addHtmlObjectListener(HtmlObjectListener aListener, String aRequiredScreen)
	{
		mListeners.put(aListener,aRequiredScreen);
	}

	/**
	 * @param aListener
	 */
	public synchronized void removeHtmlObjectListener(
			HtmlObjectListener aListener)
	{
		mListeners.remove(aListener);
	}
	
	/**
	 * @param aObject
	 */
	public synchronized void fireEvent(HtmlObject aObject)
	{
		Log.d(LOG_PREFIX,""+"-------------------------------\n"+mListeners.size());
		String lScrren = aObject.getUrl().getScreen();
		if(lScrren == null) return;
		HtmlEvent lEvent = new HtmlEvent(this,aObject);
		
	    for (Map.Entry<HtmlObjectListener, String> entry : mListeners.entrySet())
	    {
	    	Log.d(LOG_PREFIX,"listener value "+entry.getValue()+" object value "+lScrren);
	        if(entry.getValue()==null || entry.getValue().equals(lScrren))
	        {
	        	entry.getKey().handleHtml(lEvent);
	        }
	        
	    }
	    Log.d(LOG_PREFIX,""+"-------------------------------\n");
	}

}
