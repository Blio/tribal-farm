package farmer.tw.connection;

import farmer.tw.connection.url.HtmlObject;
import android.content.Context;
import android.util.Log;

public class JSBridge
{

	Context mContext;
	DataReciver mDataReciver;
	int l = 0;

	private static String LOG_PREFIX = "JSVridge";

	public JSBridge(DataReciver mDataReciver, Context ctx)
	{
		this.mDataReciver = mDataReciver;
		mContext = ctx;
	}

	public void execute(String javascript)
	{

	}

	// private void save(String h)
	// {
	// Log.d("Kkalisz","Save");
	//
	// try
	// {
	// File myFile = new
	// File(Environment.getExternalStorageDirectory(),""+l+".txt");
	// l++;
	// myFile.createNewFile();
	// FileOutputStream fOut = new FileOutputStream(myFile);
	// OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
	// myOutWriter.append(h);
	// myOutWriter.close();
	// fOut.close();
	// } catch (Exception e) {
	// Log.e("ERRR", "Could not create file",e);
	// }
	// }

	public void showHTML(String html, String url)
	{
		Log.d(LOG_PREFIX, url);
		HtmlObject lObj = new HtmlObject(html,url);
		mDataReciver.fireEvent(lObj);
		// save(html);
	}
}
