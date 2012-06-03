/**
 * 
 */
package farmer.tw.logic.basic;

import android.util.Log;
import farmer.tw.HtmlEvent;
import farmer.tw.HtmlObjectListener;
import farmer.tw.connection.ComunicationController;
import farmer.tw.connection.url.HtmlObject;

/**
 * @author kkalisz
 *
 */
public abstract class BasicParser<V extends BasicTable> implements HtmlObjectListener
{

	
	protected V mTable;
	
	
	/**
	 * 
	 */
	public BasicParser(V aTable)
	{
		this.mTable = aTable;
		ComunicationController.get().mDataReciver.addHtmlObjectListener(this, getRequiredScreen());
		Log.d(this.getClass().getName(),"utowrzono parser");
	}
	
	@Override
	public void handleHtml(HtmlEvent aObject)
	{
		Log.d(this.getClass().getName(),"zaczynam parsowanie");
		parseHtml(aObject.getHtmlObject());
		mTable.fire();
		
	}

	public abstract void parseHtml(HtmlObject aObject);
	public abstract String getRequiredScreen();
}
