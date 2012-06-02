/**
 * 
 */
package farmer.tw.logic;

import java.util.HashMap;

import farmer.tw.connection.url.URL;

/**
 * @author kkalisz
 *
 */
public class bUnitItem extends bItem
{
	public static String UNIT_SPEAR = "spear";
	public static String UNIT_SWORD = "sword";
	public static String UNIT_AXE = "axe";
	public static String UNIT_ARCHER = "archer";
	public static String UNIT_SPY = "spy";
	public static String UNIT_LIGHT = "light";
	public static String UNIT_MACRHER = "marcher";
	public static String UNIT_HEAVY = "heavy";
	public static String UNIT_RAM = "ram";
	public static String UNIT_CATAPULT = "catapult";
	public static String UNIT_KNIGHT = "knight";
	public static String UNIT_SNOB = "snob";
	
	private HashMap<String, Integer> mUnits;
	
	/**
	 * 
	 */
	public bUnitItem(HashMap<String, Integer> aUnits)
	{
		mUnits = aUnits;
	}

	public HashMap<String, Integer> getUnits()
	{
		return mUnits;
	}

	public void setUnits(HashMap<String, Integer> aUnits)
	{
		mUnits = aUnits;
	}
	
	
	public static URL getRequestUrl(String aVillageId)
	{
		URL retUrl = new URL();
		retUrl.addParam("screen", "place");
		retUrl.addParam("village", aVillageId);
		
		return retUrl;
		
	}
	
	

}
