/**
 * 
 */
package farmer.tw.logic;

import java.util.List;


import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;
import farmer.tw.HtmlEvent;
import farmer.tw.HtmlObjectListener;
import farmer.tw.connection.url.HtmlObject;

/**
 * @author kkalisz
 *
 */
public class Parser_overview_villages extends Parser implements HtmlObjectListener
{

	/**
	 * @param aTable
	 */
	public Parser_overview_villages(bTable aTable)
	{
		super(aTable);	}

	/* (non-Javadoc)
	 * @see farmer.tw.logic.Parser#parse(farmer.tw.connection.url.HtmlObject)
	 */
	@Override
	public void parse(HtmlObject aObject)
	{
		Source source=new Source(aObject.getHtml());
		Element el = source.getElementById("production_table");//source.getAllElements("table");
		if(el==null) return;
		List<Element> elements = el.getAllElements("tr");
		{
			for(int i=1;i<elements.size();i++)
			{
				List<Element> ell = elements.get(i).getAllElements("span");
				for(int j=0;j<ell.size();j++)
				{
					String atr = ell.get(j).getAttributeValue("id");
					if(atr!=null && atr.contains("label_text_"))
					{
						
						String aVillage_id = atr.replace("label_text_", "");
						String[] l1 =  ell.get(j).getContent().getTextExtractor().toString().split("\\(");
						String[] l2 = l1[1].split("\\)");
						String aVillage_name = l1[0];
						String []aVillage_coords = l2[0].split("\\|");
						
						//System.out.println("id "+aVillage_id+" nazwa: "+aVillage_name+" X: "+aVillage_coords[0]+" Y: "+aVillage_coords[1]);
						bVillageItem aVillageItem = new bVillageItem(aVillage_id, aVillage_coords[0], aVillage_coords[1], aVillage_name);
						((bVillageTable)mTable).addVillage(aVillageItem);
						
					}
				}
			}
		}
		
	}

}
