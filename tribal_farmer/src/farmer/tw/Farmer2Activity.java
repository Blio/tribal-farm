package farmer.tw;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import tribal.bng.farmer.R;

import farmer.tw.connection.ComunicationController;
import farmer.tw.logic.Parser_overview_villages;
import farmer.tw.logic.TableProvider;
import farmer.tw.logic.bUnitItem;
import farmer.tw.logic.bUnitTable;
import farmer.tw.logic.bVillageItem;
import farmer.tw.logic.bVillageTable;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class Farmer2Activity extends Activity
{
	/** Called when the activity is first created. */
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		WebView aWebView = (WebView) findViewById(R.id.webView1);
		
		ComunicationController.init(this, aWebView);
		
		TableProvider.creator();
		
//		TableProvider.getTable(bVillageTable.getTableName()).addNewDataListener(new newDataListener()
//		{
//			
//			@Override
//			public void OnNewData()
//			{
//				bVillageTable b = (bVillageTable) TableProvider.getTable(bVillageTable.getTableName());
//				
//				for (Entry<Long, bVillageItem> entry : b.mVillages.entrySet()) 
//				{
//				    
//					Log.d("KKALISZ","village id "+entry.getValue().getVillageId()+ "  "+entry.getValue().getX()+"|"+entry.getValue().getY());
//				}
//				
//			}
//		});
//		
//		TableProvider.getTable(bUnitTable.getTableName()).addNewDataListener(new newDataListener()
//		{
//
//			@Override
//			public void OnNewData()
//			{
//				bUnitTable but = (bUnitTable) TableProvider.getTable(bUnitTable.getTableName());
//				HashMap<Long, bUnitItem> bhm = but.getHashMap();
//				
//				for (Map.Entry<Long, bUnitItem> item : bhm.entrySet()) {
//					  //String key = item.getKey();
//					 bUnitItem value = item.getValue();
//					 
//					 for (Map.Entry<String, Integer> items : value.getUnits().entrySet()) {
//						  //String key = item.getKey();
//						  //String value = item.getValue();
//						 Log.d("KKALISZ",""+item.getKey()+" "+item.getValue());
//						}
//					}
//			}
//			
//		});
//		
		fTable<String> f = new fTable<String>();
		//TableProvider.
		//bVillageTable  bb= new bVillageTable();
		
		
		//ComunicationController.get().mDataReciver.addHtmlObjectListener(new Parser_overview_villages(),null);
		
//		TableProvider.getTable(bVillageTable.getTableName()).addNewDataListener(new newDataListener()
//		{
//			
//			@Override
//			public void OnNewData()
//			{
//				Log.d("KURWA", "NOWE DANE");
//				
//			}
//		});
//		
//		ComunicationController.get().mDataReciver.addHtmlObjectListener(new HtmlObjectListener()
//		{
//			
//			@Override
//			public void handleHtml(HtmlEvent aObject)
//			{
//				Log.d("LISTENER 1 ", aObject.getHtmlObject().getUrl().getUrlString());
//				
//			}
//		}, null);
//		
//		ComunicationController.get().mDataReciver.addHtmlObjectListener(new HtmlObjectListener()
//		{
//			
//			@Override
//			public void handleHtml(HtmlEvent aObject)
//			{
//				Log.d("LISTENER 2 report ", aObject.getHtmlObject().getUrl().getUrlString());
//				
//			}
//		}, "report");
		
		aWebView.loadUrl("http://www.plemiona.pl/");
		
		
	}
}