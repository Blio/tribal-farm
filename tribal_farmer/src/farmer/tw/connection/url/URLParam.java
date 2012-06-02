package farmer.tw.connection.url;

public class URLParam
{

	String mParamName;
	boolean mIsRequired;

	public URLParam(String mParamName, boolean mIsRequired)
	{
		super();
		this.mParamName = mParamName;
		this.mIsRequired = mIsRequired;
	}

	/**
	 * @return the mParamName
	 */
	public String getParamName()
	{
		return mParamName;
	}

	/**
	 * @return the mIsRequired
	 */
	public boolean isRequired()
	{
		return mIsRequired;
	}

	/**
	 * @param mParamName
	 *            the mParamName to set
	 */
	public void setParamName(String mParamName)
	{
		this.mParamName = mParamName;
	}

	/**
	 * @param mIsRequired
	 *            the mIsRequired to set
	 */
	public void setRequired(boolean mIsRequired)
	{
		this.mIsRequired = mIsRequired;
	}

}
