package farmer.tw.logic;

import java.util.HashMap;

public class bVillageTable extends bTable
{
	private static String TABLE_NAME = "VILLAGE";

	public HashMap<Long, bVillageItem> mVillages = new HashMap<Long, bVillageItem>();
	
	
	public bVillageTable()
	{
		super();
		new Parser_overview_villages(this);
	}
	
	public bVillageItem getVillage(long aVillageId)
	{
		return mVillages.get(aVillageId);
	}
	
	public void addVillage(bVillageItem aVillage)
	{
		mVillages.put(aVillage.mVillageId, aVillage);
	}
	

	/* (non-Javadoc)
	 * @see farmer.tw.logic.bTable#getTablename()
	 */
	

}
