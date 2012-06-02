/**
 * 
 */
package farmer.tw.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import farmer.tw.logic.n.basic.BasicTable;
import farmer.tw.logic.n.basic.BasicVillageData;

import android.util.Log;

/**
 * @author kkalisz
 *
 */
public class TableProvider
{
	private static HashMap<String,  BasicTable<BasicVillageData>> mTables = new HashMap<String, BasicTable<BasicVillageData>>();
	
	public static void creator()
	{
		//List <Class<? implements bTable>> mClassList = new ArrayList<Class<bTable>>();
		List<Class<? extends BasicTable<BasicVillageData>>> mClassList = new ArrayList<Class<? extends BasicTable<BasicVillageData>>>();
		//mClassList.add(bVillageTable.class);
		
		
		for(int i=0;i<mClassList.size();i++)
		{
			BasicTable<BasicVillageData> b;
			try
			{
				b = mClassList.get(i).newInstance();
				mTables.put(b.getTableName(),b);
			}
			catch (IllegalAccessException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (InstantiationException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	public static BasicTable<BasicVillageData> getTable(String aTableName)
	{
		return mTables.get(aTableName);
	}
	
	public static boolean containsTable(String aTableName)
	{
		return mTables.containsKey(aTableName);
	}
}
