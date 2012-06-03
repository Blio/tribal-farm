package farmer.tw.logic.concrete;

import java.util.HashMap;
import java.util.Map;

import farmer.tw.logic.basic.BasicVillageData;

public class VillageUnitsActiveItem extends BasicVillageData
{
	public static final String UNIT_SPEAR = "spear";
	public static final String UNIT_SWORD = "sword";
	public static final String UNIT_AXE = "axe";
	public static final String UNIT_ARCHER = "archer";
	public static final String UNIT_SPY = "spy";
	public static final String UNIT_LIGHT = "light";
	public static final String UNIT_MACRHER = "marcher";
	public static final String UNIT_HEAVY = "heavy";
	public static final String UNIT_RAM = "ram";
	public static final String UNIT_CATAPULT = "catapult";
	public static final String UNIT_KNIGHT = "knight";
	public static final String UNIT_SNOB = "snob";
	
	private HashMap<String, Integer> mUnits;
	
	public VillageUnitsActiveItem(Long aVillageId, HashMap<String, Integer> aUnits)
	{
		super(aVillageId);
		mUnits = aUnits;
	}
	
	public VillageUnitsActiveItem(String aVillageId, HashMap<String, Integer> aUnits)
	{
		super(aVillageId);
		mUnits = aUnits;
	}
	
	public VillageUnitsActiveItem(Long aVillageId)
	{
		super(aVillageId);
	}
	
	public VillageUnitsActiveItem(String aVillageId)
	{
		super(aVillageId);
	}

	public HashMap<String, Integer> getUnits() {
		return mUnits;
	}

	public void setUnits(HashMap<String, Integer> units) {
		mUnits = units;
	}
	
	public void setUnit(String aUnitName, Integer aUnitsNnumber)
	{
		mUnits.put(aUnitName, aUnitsNnumber);
	}
	
	public int getUnit(String aUnitName)
	{
		if(mUnits.containsKey(aUnitName)) return mUnits.get(aUnitName);
		else return 0;
	}
	
	@Override
	public String toString() {
		String aReturn="";
		
		for (Map.Entry<String, Integer> entry : mUnits.entrySet()) {
		    aReturn += entry.getKey()+": ";
		    aReturn += entry.getValue()+", ";
		   
		}
		return aReturn;
		
	}
	
	

};
