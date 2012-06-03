package farmer.tw.connection;

import farmer.tw.connection.url.URL;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ComunicationController {
	
	public WebView mWebView;
	JSBridge mJsBridge;
	Context mContext;
	public DataReciver mDataReciver;
	
	private static ComunicationController mComunicationController = null;
	
	public static ComunicationController getComunicationController()
	{
		return mComunicationController;
		
	}
	
	public static void create(Context aContext, WebView aWebView)
	{
		if(mComunicationController == null) mComunicationController = new ComunicationController(aContext, aWebView);
		else
		{
			mComunicationController.mWebView = aWebView;
			mComunicationController.mWebView.getSettings().setJavaScriptEnabled(true);
			mComunicationController.mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
			
			mComunicationController.mWebView.setWebViewClient(new WebViewClient()
			{
				@Override
				public void onPageFinished(WebView view, String url)
				{
					// MainController.setHtmlObjectUrl(url);
					view.loadUrl("javascript:window.jsinterface.showHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>','"
							+ url + "');");
				}

			});
			mComunicationController.mWebView.addJavascriptInterface(mComunicationController.mJsBridge, "jsinterface");
		}
	}
	
	
	private ComunicationController(Context aContext, WebView aWebView) 
	{
		mWebView = aWebView;
		mDataReciver = new DataReciver();
		mJsBridge = new JSBridge(mDataReciver,aContext.getApplicationContext());
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
		

//	public static void init(Context context, WebView aWebView) {
//		mContext = context;
//		mWebView = aWebView;
//		mJsBridge = new JSBridge(mContext);
//		mWebView.getSettings().setJavaScriptEnabled(true);
//		mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//	      
//        mWebView.setWebViewClient(new WebViewClient()
//        {
//        	public void onPageFinished(WebView view, String url)
//        	{
//        		MainController.setHtmlObjectUrl(url);
//                view.loadUrl("javascript:window.jsinterface.showHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>','"+url+"');");
//        	}
//        	
//        });
//        mWebView.addJavascriptInterface(mJsBridge, "jsinterface");
//	}
	
	
	public void loadUrl(String url)
	{
		mWebView.loadUrl(url);
	}
	
	public void loadUrl(URL url)
	{
		loadUrl(url.getUrlString());
	}
	
	

	

}
