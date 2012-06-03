package farmer.tw.logic.basic;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import android.util.Log;

import farmer.tw.logic.OnUpdateListener;
import farmer.tw.logic.concrete.VillageInfoItem;


public class BasicTable <V extends BasicVillageData> extends TreeMap<Long, V>
{

	public String TABLE_NAME = "BASIC";
	

	// lista listeerów wywo³ywancyh jesli zostana wprowadzine zmiany w tabeli
	List<OnUpdateListener> mListeners = new ArrayList<OnUpdateListener>();
	
	

	// dodaje obiekt kluczem jest ID obiektu
	public void put(V aValue)
	{
		this.put(aValue.getID(), aValue);
	}
	
	
	
	// zwraca nazwe tabeli
	public static String getTableName()
	{
		return "BASIC";
	}

	
	/*
	 * Listenery
	 * 
	 */
	public synchronized void addNewDataListener(OnUpdateListener aListsner)
	{
		Log.d("KKALISZ","dodaje "+mListeners.size());
		mListeners.add(aListsner);
	}
	
	public synchronized void removeNewDataListener(OnUpdateListener aListsner)
	{
		mListeners.remove(aListsner);
	}
	
	public synchronized void fire()
	{
		Log.d("KKALISZ","FIRe "+mListeners.size());
		for (OnUpdateListener element : mListeners)
		{
			Log.d("KKALISZ","FIRe");
			element.OnUpdate();
		}
	}
	
	public java.util.Iterator<V> getIterator()
	{
		return this.values().iterator();	
	}
	
	
	public void showTable()
	{
		Log.d(getTableName(),"size "+this.size());
		Iterator<V> it = this.getIterator();
		while(it.hasNext())
		{
			Log.d(getTableName(),it.next().toString());
		}
	}

	
//	private static void main(String [] args)
//	{
//		BasicTable<BasicVillageData> cS = new BasicTable<BasicVillageData>();
////		cS.put((long) 1, "ww");
//		java.util.Iterator<BasicVillageData> itr = cS.values().iterator();
//	    while(itr.hasNext())
//	    {
//	        System.out.println(itr.next());
//	    }
//	}
};

