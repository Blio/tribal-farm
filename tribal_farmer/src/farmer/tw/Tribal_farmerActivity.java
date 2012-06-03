package farmer.tw;

import java.io.Serializable;
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
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class Tribal_farmerActivity extends Activity {
    /** Called when the activity is first created. */
	WebView aWebView;
	
	
	private static final int MENU_FARM_SINGLE = 0;
	
	private static final int MENU_FARM_GROUP = 0;
	
	private static final int MENU_FARM_ALL = 0;
	
	private static final int MENU_EDIT_FARMS = 0;
	
	private static final int MENU_START_AUTO_FARM = 0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        aWebView = (WebView) findViewById(R.id.webView1);
        if(savedInstanceState!=null)
        {
        	aWebView.restoreState(savedInstanceState);
        	ComunicationController.create(this,aWebView);
        }
        else
        {
        	ComunicationController.create(this,aWebView);
        	String mServer = getIntent().getStringExtra("server");
    		ComunicationController.getComunicationController().loadUrl("http://"+mServer);
        }
        
        TableProvider.creator();
     
    }
    
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) 
    {
    	aWebView.saveState(savedInstanceState);
    	super.onSaveInstanceState(savedInstanceState);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "menu1");
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.vibrate:
//            case R.id.dont_vibrate:
//                if (item.isChecked()) item.setChecked(false);
//                else item.setChecked(true);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
    	return true;
    }
    
}