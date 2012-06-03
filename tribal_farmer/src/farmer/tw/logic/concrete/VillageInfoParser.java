package farmer.tw.logic.concrete;

import java.util.List;

import android.util.Log;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;
import farmer.tw.connection.url.HtmlObject;
import farmer.tw.logic.basic.BasicParser;

public class VillageInfoParser extends BasicParser<VillageInfoTable>{

	public VillageInfoParser(VillageInfoTable aTable) {
		super(aTable);
	}

	@Override
	public void parseHtml(HtmlObject aObject) {
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
						VillageInfoItem aVillageItem = new VillageInfoItem(aVillage_id, aVillage_coords[0], aVillage_coords[1], aVillage_name);
						this.mTable.put(aVillageItem);
						Log.d(this.getClass().getName(),"dodano wioske");
						
					}
				}
			}
		}
		
	}

	@Override
	public String getRequiredScreen() {
		return "overview_villages";
	}

}
