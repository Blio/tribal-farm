package farmer.tw.logic.n.basic;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import farmer.tw.logic.n.OnUpdateListener;


public class BasicTable <V extends BasicVillageData> extends TreeMap<Long, V>
{

	// Nazwa tabeli
	public static String TABLE_NAME = "VILLAGE";
	

	// lista listeerów wywo³ywancyh jesli zostana wprowadzine zmiany w tabeli
	List<OnUpdateListener> mListeners = new ArrayList<OnUpdateListener>();
	

	// dodaje obiekt kluczem jest ID obiektu
	public void put(V aValue)
	{
		super.put(aValue.getID(), aValue);
	}
	
	
	
	// zwraca nazwe tabeli
	public String getTableName()
	{
		return TABLE_NAME;
	}

	
	/*
	 * Listenery
	 * 
	 */
	public synchronized void addNewDataListener(OnUpdateListener aListsner)
	{
		mListeners.add(aListsner);
	}
	
	public synchronized void removeNewDataListener(OnUpdateListener aListsner)
	{
		mListeners.remove(aListsner);
	}
	
	public synchronized void fire()
	{
		for (OnUpdateListener element : mListeners)
		{
			element.OnUpdate();
		}
	}
	
	public java.util.Iterator<V> getIterator()
	{
		return this.values().iterator();	
	}

	
	private static void main(String [] args)
	{
		BasicTable<BasicVillageData> cS = new BasicTable<BasicVillageData>();
//		cS.put((long) 1, "ww");
		java.util.Iterator<BasicVillageData> itr = cS.values().iterator();
	    while(itr.hasNext())
	    {
	        System.out.println(itr.next());
	    }
	}
};

