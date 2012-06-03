package farmer.tw.logic.concrete;

import farmer.tw.logic.basic.BasicTable;

public class VillageUnitsActiveTable extends BasicTable<VillageUnitsActiveItem>{

	/**
	 * 
	 */
	public static String TABLE_NAME = "UNITS_ACTIVE";
	
	private static final long serialVersionUID = 1L;
	
	public VillageUnitsActiveTable()
	{
		super();
		new VillageUnitsActiveParser(this);
	}

	public static String getTableName()
	{
		return TABLE_NAME;
	}
}
