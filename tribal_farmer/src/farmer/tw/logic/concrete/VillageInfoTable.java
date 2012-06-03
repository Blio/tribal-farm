package farmer.tw.logic.concrete;

import farmer.tw.logic.basic.BasicTable;

public class VillageInfoTable extends BasicTable<VillageInfoItem>{
	
	public static String TABLE_NAME = "VILLAGE";
	
	public VillageInfoTable()
	{
		super();
		new VillageInfoParser(this);
	}
	
	public static String getTableName()
	{
		return TABLE_NAME;
	}

}
