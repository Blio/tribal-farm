/**
 * 
 */
package farmer.tw.logic;

import java.lang.reflect.ParameterizedType;


import android.util.Log;
import android.widget.MultiAutoCompleteTextView.CommaTokenizer;
import farmer.tw.HtmlEvent;
import farmer.tw.HtmlObjectListener;
import farmer.tw.connection.ComunicationController;
import farmer.tw.connection.url.HtmlObject;
import net.htmlparser.jericho.Source;

/**
 * @author kkalisz
 *
 */
public abstract class Parser implements HtmlObjectListener
{

	public static String mReqScreen = null;
	
	bTable mTable;
	/* (non-Javadoc)
	 * @see farmer.tw.HtmlObjectListener#handleHtml(farmer.tw.HtmlEvent)
	 */
	
	public Parser(bTable aTable)
	{
		this.mTable = aTable;
		ComunicationController.get().mDataReciver.addHtmlObjectListener(this, mReqScreen);
	}
	
	@Override
	public void handleHtml(HtmlEvent aObject)
	{
		parse(aObject.getHtmlObject());
		mTable.fire();
	}
	
	public abstract void parse (HtmlObject aObject);
	
	public void setParentTable(bTable aTable)
	{
		mTable = aTable;
	}
}

