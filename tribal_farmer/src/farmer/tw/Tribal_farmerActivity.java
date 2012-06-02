package farmer.tw;

import farmer.tw.connection.ComunicationController;
import farmer.tw.logic.TableProvider;
import tribal.bng.farmer.R;
import android.app.Activity;
import android.os.Bundle;
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
		
		aWebView.loadUrl("http://www.plemiona.pl/");
        
        
    }
}