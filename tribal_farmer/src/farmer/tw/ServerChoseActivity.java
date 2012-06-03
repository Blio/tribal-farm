package farmer.tw;


import java.util.List;

import tribal.bng.farmer.R;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ServerChoseActivity extends Activity{
	
	private Context mContext;
	String[] mServers = {
			"die-staemme.de"
			,"staemme.ch"
			,"tribalwars.net"
			,"tribalwars.nl"
			,"plemiona.pl"
			,"tribalwars.se"
			,"tribalwars.com.br"
			,"tribos.com.pt"
			,"divokekmeny.cz"
			,"bujokjeonjaeng.org"
			,"triburile.ro"
			,"voyna-plemyon.ru"
			,"fyletikesmaxes.gr"
			,"tribalwars.no.com"
			,"divoke-kmene.sk"
			,"klanhaboru.hu"
			,"tribalwars.dk"
			,"plemena.net"
			,"tribals.it"
			,"klanlar.org"
			,"guerretribale.fr"
			,"guerrastribales.es"
			,"tribalwars.fi"
			,"tribalwars.ae"
			,"tribalwars.co.uk"
			,"vojnaplemen.si"
			,"genciukarai.lt"
			,"wartribes.co.il"
			,"plemena.com.hr"
			,"perangkaum.net"
			,"tribalwars.jp"
			,"tribalwars.bg"
			,"tribalwars.asia"
			,"tribalwars.us"
			,"tribalwarsmasters.net"};
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		mContext = this;
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.server_choose_layout);
		// <color name="background">#dfcca6</color>
		ArrayAdapter<String> a = new ArrayAdapter<String>(this, R.layout.one_line_item, mServers);
		
		ListView aLv = (ListView) findViewById(R.id.server_list);
		aLv.setAdapter(a);
		aLv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				//Toast.makeText(mContext, ""+arg1+" "+arg2, Toast.LENGTH_LONG).show();
				//Log.d("KKALISZ","ble");
				Intent action = new Intent(ServerChoseActivity.this, Tribal_farmerActivity.class);
				action.putExtra("server", mServers[arg2]);
				startActivity(action);
			}
		});
		
		

	}
	
	


}
