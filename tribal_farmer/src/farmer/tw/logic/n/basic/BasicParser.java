/**
 * 
 */
package farmer.tw.logic.n.basic;

import farmer.tw.HtmlEvent;
import farmer.tw.HtmlObjectListener;
import farmer.tw.connection.ComunicationController;
import farmer.tw.connection.url.HtmlObject;
import farmer.tw.logic.bTable;

/**
 * @author kkalisz
 *
 */
public abstract class BasicParser<V extends BasicTable<BasicVillageData>> implements HtmlObjectListener
{

	
	V mTable;
	
	
	/**
	 * 
	 */
	public BasicParser(V aTable)
	{
		this.mTable = aTable;
		ComunicationController.get().mDataReciver.addHtmlObjectListener(this, getRequiredScreen());
	}
	
	@Override
	public void handleHtml(HtmlEvent aObject)
	{
		parseHtml(aObject.getHtmlObject());
		mTable.fire();
		
	}

	public abstract void parseHtml(HtmlObject aObject);
	public abstract String getRequiredScreen();
}
