/**
 * 
 */
package farmer.tw.logic;

import java.util.HashMap;
import java.util.List;


import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.StartTag;
import net.htmlparser.jericho.Tag;
import farmer.tw.HtmlObjectListener;
import farmer.tw.connection.url.HtmlObject;

/**
 * @author kkalisz
 *
 */
public class Parser_place extends Parser implements HtmlObjectListener
{

	/**
	 * @param aTable
	 */
	public Parser_place(bTable aTable)
	{
		super(aTable);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see farmer.tw.logic.Parser#parse(farmer.tw.connection.url.HtmlObject)
	 */
	@Override
	public void parse(HtmlObject aObject)
	{
		Source source=new Source(aObject.getHtml());
		HashMap<String, Integer> units = new HashMap<String, Integer>();
		List<? extends StartTag>  st = source.getAllStartTags("input");
		for(int i=0;i<st.size();i++)
		{
			StartTag a = st.get(i);
			String cls = a.getAttributeValue("class");
			if(cls!=null && cls.equals("unitsInput"))
			{
				System.out.println(a.getAttributeValue("name"));
				Tag b = a.getNextTag();
				String numberOf = b.getElement().getContent().toString().replace("(", "").replace(")", "");
				System.out.println(numberOf);
				units.put(a.getAttributeValue("name"), Integer.parseInt(a.getNextTag().getElement().getContent().toString().replace("(", "").replace(")", "")));
				
			}
		}
		((bUnitTable)mTable).addUnits(Long.parseLong(aObject.getUrl().getParameter("village")), new bUnitItem(units));
	}

}
