package farmer.tw;

import java.util.Iterator;

import farmer.tw.connection.ComunicationController;
import farmer.tw.logic.OnUpdateListener;
import farmer.tw.logic.TableProvider;
import farmer.tw.logic.basic.BasicTable;
import farmer.tw.logic.basic.BasicVillageData;
import farmer.tw.logic.concrete.VillageInfoItem;
import farmer.tw.logic.concrete.VillageInfoTable;
import farmer.tw.logic.concrete.VillageUnitsActiveParser;
import farmer.tw.logic.concrete.VillageUnitsActiveTable;
import tribal.bng.farmer.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class Tribal_farmerActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		WebView aWebView = (WebView) findViewById(R.id.webView1);
		
		ComunicationController.init(this, aWebView);
		
		TableProvider.creator();
		
		TableProvider.getTable(VillageInfoTable.getTableName()).addNewDataListener(new OnUpdateListener() {
			
			@Override
			public void OnUpdate() {
				VillageInfoTable vTable = (VillageInfoTable) TableProvider.getTable(VillageInfoTable.getTableName());
				vTable.showTable();

			}
		});
		
		TableProvider.getTable(VillageUnitsActiveTable.getTableName()).addNewDataListener(new OnUpdateListener() {
			
			@Override
			public void OnUpdate() {
				VillageUnitsActiveTable vTable = (VillageUnitsActiveTable) TableProvider.getTable(VillageUnitsActiveTable.getTableName());
				vTable.showTable();

			}
		});
		
		//VillageInfoTable vt = new VillageInfoTable();
		//vt.put(new VillageInfoItem((long)12, 12, 12, "ww"));
		
//		BasicTable<BasicVillageData> ff= new BasicTable<BasicVillageData>();
//		ff.put(new BasicVillageData((long) 123) {
//		});
		
		
		
		
		
		aWebView.loadUrl("http://www.plemiona.pl/");
        
        
    }
}