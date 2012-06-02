package farmer.tw.connection.url;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class URL
{

	private static String LOG_PREFIX = "URL_CLASS";

	private static String mBaseUrl = "";
	private LinkedHashMap<String, String> mParams = new LinkedHashMap<String, String>();

	public URL()
	{

	}

	public URL(String url)
	{
		String tmpTab[] = url.split("\\?");
		System.out.println(tmpTab.length);
		mBaseUrl = tmpTab[0];
		if (tmpTab.length == 1)
		{
		}
		else
		{

			String paramPairs[] = tmpTab[1].split("&");

			String f = "key: %s  value: %s";
			for (int i = 0; i < paramPairs.length; i++)
			{
				String pa[] = paramPairs[i].split("=");
				if (pa.length == 2) mParams.put(pa[0], pa[1]);
				else mParams.put(pa[0], null);

				// Log.d(LOG_PREFIX,String.format(f, pa[0],
				// pa.length==2?pa[1]:"null"));
			}
		}

	}

	public void addParam(String paramName, String paramValue)
	{
		mParams.put(paramName, paramValue);
	}

	public boolean containsParameter(String paramName)
	{
		return mParams.containsKey(paramName);
	}

	public String getParameter(String param)
	{
		return mParams.get(param);
	}

	public String getScreen()
	{
		return mParams.get("screen");
	}

	public String getUrlString()
	{
		String url = mBaseUrl + "?";
		Iterator iterator = mParams.keySet().iterator();
		while (iterator.hasNext())
		{
			String key = (String) iterator.next();
			String value = mParams.get(key);
			url += key;
			if (value != null)
			{
				url += "=" + value;
			}
			if (iterator.hasNext()) url += "&";
		}
		return url;
	}

}