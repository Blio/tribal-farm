package farmer.tw;
import farmer.tw.connection.url.HtmlObject;

public class HtmlEvent extends java.util.EventObject
{

	private static final long serialVersionUID = 1L;

	private HtmlObject mObject = null;

	public HtmlEvent(Object source)
	{
		super(source);
	}

	public HtmlEvent(Object source, HtmlObject mObject)
	{
		super(source);
		this.mObject = mObject;
	}

	public HtmlObject getHtmlObject()
	{
		return mObject;
	}

	public void setmHtmlObject(HtmlObject mObject)
	{
		this.mObject = mObject;
	}

}
