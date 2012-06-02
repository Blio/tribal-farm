/**
 * 
 */
package farmer.tw.logic;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;


import android.util.Log;
import android.widget.MultiAutoCompleteTextView.CommaTokenizer;

import farmer.tw.newDataListener;
import farmer.tw.connection.ComunicationController;

/**
 * @author kkalisz
 *
 */
public abstract class bTable 
{

	public static String TABLE_NAME = "VILLAGE";
	List<newDataListener> mListeners = new ArrayList<newDataListener>();
	
	//Parser mParser;
	
	@SuppressWarnings("unchecked")
	public bTable()
	{
		
	}
	
	public void setParser(Parser aParser)
	{
		//mParser = aParser;
		init();
	}
	
	public static String getTableName()
	{
		return TABLE_NAME;
	}
	
	public synchronized void addNewDataListener(newDataListener aListsner)
	{
		mListeners.add(aListsner);
	}
	
	public synchronized void removeNewDataListener(newDataListener aListsner)
	{
		mListeners.remove(aListsner);
	}
	
	public synchronized void fire()
	{
		Log.d("KKALISZ","fire "+TABLE_NAME);
		for (newDataListener element : mListeners)
		{
			element.OnNewData();
		}
	}
	
	public void init()
	{
		//ComunicationController.get().mDataReciver.addHtmlObjectListener(mParser, mParser.mReqScreen);
	}
	

	
}
