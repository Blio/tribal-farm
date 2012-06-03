package farmer.tw.logic.concrete;

import java.util.HashMap;
import java.util.List;

import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.StartTag;
import net.htmlparser.jericho.Tag;
import farmer.tw.connection.url.HtmlObject;
import farmer.tw.logic.basic.BasicParser;

public class VillageUnitsActiveParser extends BasicParser<VillageUnitsActiveTable>{

	
	public VillageUnitsActiveParser(VillageUnitsActiveTable aTable) {
		super(aTable);
	}
	
	@Override
	public void parseHtml(HtmlObject aObject) {
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
		VillageUnitsActiveItem aVillageUnitsItem = new VillageUnitsActiveItem(aObject.getUrl().getParameter("village"), units);
		mTable.put(aVillageUnitsItem);
		//((bUnitTable)mTable).addUnits(Long.parseLong(aObject.getUrl().getParameter("village")), new bUnitItem(units));
		
	}

	@Override
	public String getRequiredScreen() {
		return "place";
	}

}
