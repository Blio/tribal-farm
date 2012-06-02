/**
 * 
 */
package farmer.tw.logic;

import java.util.HashMap;

/**
 * @author kkalisz
 *
 */
public class bUnitTable extends bTable
{

	private static String TABLE_NAME = "UNIT";

	public HashMap<Long, bUnitItem> mUnits = new HashMap<Long, bUnitItem>();
	
	
	public void addUnits(long aVillageId, bUnitItem aUnits)
	{
		mUnits.put(aVillageId,aUnits);
	}
	
	public bUnitItem getUnits(long aVillageId)
	{
		return mUnits.get(aVillageId);
	}
	
	public HashMap<Long, bUnitItem> getHashMap()
	{
		return mUnits;
	}
	
	
}
