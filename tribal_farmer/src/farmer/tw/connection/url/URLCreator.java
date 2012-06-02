package farmer.tw.connection.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;

public class URLCreator
{

	public static List<URLParam> mStandardLink = new ArrayList<URLParam>();
	public static HashMap<String, List<URLParam>> mExtendedLink = new HashMap<String, List<URLParam>>();

	public static URL create(URLType uType, Bundle bund)
			throws UrlParamException
	{
		switch (uType)
		{
		case OVERVIEW_VILLAGE:
			return fromParamLst("overview", bund);
		case OVERWIEV_VILLAGES:
			return fromParamLst("overview_villages", bund);
		case PLACE:
			return fromParamLst("place", bund);
		case MAP:
			return fromParamLst("map", bund);
		case BUILDING:
			return fromParamLst("main", bund);
		case INFO_PLAYER:
			return fromParamLst("info_player", bund);
		case INFO_VILLAGE:
			return fromParamLst("info_village", bund);
		default:
			break;
		}
		return fromParamLst("overview_villages", bund);
	}

	private static URL fromParamLst(String screen, Bundle bund)
			throws UrlParamException
	{
		URL rUrl = new URL();
		List<URLParam> extended = mExtendedLink.get(screen);
		for (int i = 0; i < mStandardLink.size(); i++)
		{
			URLParam up = mStandardLink.get(i);

			String param = up.getParamName();
			if (bund.containsKey(param))
			{
				rUrl.addParam(param, bund.getString(param));
			}
			else
			{
				if (up.isRequired()) { throw new UrlParamException(
						"Parameter: " + param + " is required"); }
			}
		}

		if (extended == null) return rUrl;

		for (int i = 0; i < extended.size(); i++)
		{
			URLParam up = extended.get(i);

			String param = up.getParamName();
			if (bund.containsKey(param))
			{
				rUrl.addParam(param, bund.getString(param));
			}
			else
			{
				if (up.isRequired()) { throw new UrlParamException(
						"Parameter: " + param + " is required"); }
			}
		}
		return rUrl;
	}

	public static void init()
	{
		mStandardLink.add(new URLParam("village", true));
		mStandardLink.add(new URLParam("screen", true));

		List<URLParam> miv = new ArrayList<URLParam>();
		miv.add(new URLParam("id", true));
		mExtendedLink.put("info_village", miv);
		mExtendedLink.put("info_player", miv);
		mExtendedLink.put("info_ally", miv);

		List<URLParam> mip = new ArrayList<URLParam>();
		mip.add(new URLParam("target", false));
		mip.add(new URLParam("mode", false));
		mExtendedLink.put("place", mip);

		List<URLParam> mir = new ArrayList<URLParam>();
		mir.add(new URLParam("mode", false));
		mir.add(new URLParam("view", false));
		mir.add(new URLParam("from", false));
		mExtendedLink.put("report", mir);
	}

}
