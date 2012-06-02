package farmer.tw.connection;

import java.io.IOException;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import farmer.tw.connection.url.URL;

public class ComunicationController
{

	private static ComunicationController mCmc;
	
	
	public static void init(Context context, WebView aWebView)
	{
		mCmc = new ComunicationController(context, aWebView);
	}
	
	public static ComunicationController get()
	{
		if(mCmc!=null) return mCmc;
		else return null;
	}
	
	WebView mWebView;
	JSBridge mJsBridge;
	Context mContext;
	public DataReciver mDataReciver;

	public ComunicationController(Context context, WebView aWebView)
	{
		mContext = context;
		mWebView = aWebView;
		mDataReciver = new DataReciver();
		mJsBridge = new JSBridge(mDataReciver,mContext);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

		mWebView.setWebViewClient(new WebViewClient()
		{
			@Override
			public void onPageFinished(WebView view, String url)
			{
				// MainController.setHtmlObjectUrl(url);
				view.loadUrl("javascript:window.jsinterface.showHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>','"
						+ url + "');");
			}

		});
		mWebView.addJavascriptInterface(mJsBridge, "jsinterface");
	}

	public void loadUrl(String url)
	{
		mWebView.loadUrl(url);
	}

	public void loadUrl(URL url)
	{
		loadUrl(url.getUrlString());
	}

}
