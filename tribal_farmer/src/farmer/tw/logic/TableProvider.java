/**
 * 
 */
package farmer.tw.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import farmer.tw.logic.basic.BasicTable;
import farmer.tw.logic.basic.BasicVillageData;
import farmer.tw.logic.concrete.VillageInfoTable;
import farmer.tw.logic.concrete.VillageUnitsActiveTable;

import android.util.Log;

/**
 * @author kkalisz
 *
 */
public class TableProvider
{
	private static HashMap<String, BasicTable> mTables = new HashMap<String, BasicTable>();
	
	public static void creator()
	{
		//List <Class<? implements bTable>> mClassList = new ArrayList<Class<bTable>>();
		List<Class<? extends BasicTable>> mClassList = new ArrayList<Class<? extends BasicTable>>();
		
		mTables.put(VillageInfoTable.getTableName(), new VillageInfoTable());
		mTables.put(VillageUnitsActiveTable.getTableName(), new VillageUnitsActiveTable());
		//mClassList.add(VillageInfoTable.class);
//		mClassList.add(VillageInfoTable.class);
//		mClassList.add(VillageUnitsActiveTable.class);
//		
//		for(int i=0;i<mClassList.size();i++)
//		{
//			BasicTable b;
//			try
//			{
//				b = mClassList.get(i).newInstance();
//				Log.d("KKALISZ   ",""+b.getTableName()+" "+ mClassList.get(i).newInstance().TABLE_NAME);
//				mTables.put(b.getTableName(),b);
//			}
//			catch (IllegalAccessException e)
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			catch (InstantiationException e)
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
		
	}
	
	
	public static BasicTable getTable(String aTableName)
	{
		return mTables.get(aTableName);
	}
	
	public static boolean containsTable(String aTableName)
	{
		return mTables.containsKey(aTableName);
	}
}
