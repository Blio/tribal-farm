/**
 * 
 */
package farmer.tw.logic.basic;

import android.util.Log;
import farmer.tw.HtmlEvent;
import farmer.tw.connection.ComunicationController;
import farmer.tw.connection.url.HtmlObject;
import farmer.tw.logic.HtmlObjectListener;

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
		ComunicationController.getComunicationController().mDataReciver.addHtmlObjectListener(this, getRequiredScreen());
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
