package farmer.tw.connection.url;

public class HtmlObject
{

	String mHtml = null;
	URL mUrl = null;
	
	

	public HtmlObject(String aHtml, URL aUrl)
	{
		super();
		mHtml = aHtml;
		mUrl = aUrl;
	}
	
	public HtmlObject(String aHtml, String aUrl)
	{
		super();
		mHtml = aHtml;
		mUrl = new URL(aUrl);
	}

	public String getHtml()
	{
		return mHtml;
	}

	public URL getUrl()
	{
		return mUrl;
	}

	public void setHtml(String mHtml)
	{
		this.mHtml = mHtml;
	}

	public void setUrl(String aUrl)
	{
		this.mUrl = new URL(aUrl);
	}

	public void setUrl(URL aUrl)
	{
		this.mUrl = aUrl;
	}

}
