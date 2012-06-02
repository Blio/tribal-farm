package farmer.tw.logic.n;

import farmer.tw.logic.n.basic.BasicVillageData;


public class bVillageItem extends BasicVillageData
{
	int mX;
	int mY;
	//int mK;
	String mName;
	
	public bVillageItem(String aVillageId, String aX, String aY, String aMname)
	{
		super(aVillageId);
		mX = Integer.parseInt(aX);
		mY = Integer.parseInt(aY);
		mName = aMname;
	}
	
	public bVillageItem(long aVillageId, int aX, int aY, String aMname)
	{
		super(aVillageId);
		mX = aX;
		mY = aY;
		mName = aMname;
	}

	public int getX()
	{
		return mX;
	}

	public void setX(int aX)
	{
		mX = aX;
	}

	public int getY()
	{
		return mY;
	}

	public void setY(int aY)
	{
		mY = aY;
	}

	public String getName()
	{
		return mName;
	}

	public void setName(String aName)
	{
		mName = aName;
	}
	
//	public static  URL getRequestUrl(String aVillageId)
//	{
//		URL retUrl = new URL();
//		retUrl.addParam("screen", "place");
//		return retUrl;
//	}
	
	
	
	

}
