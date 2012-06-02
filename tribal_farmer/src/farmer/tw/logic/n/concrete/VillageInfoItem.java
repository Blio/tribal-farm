package farmer.tw.logic.n.concrete;

import farmer.tw.logic.n.basic.BasicVillageData;

public class VillageInfoItem extends BasicVillageData{
	
	int mX;
	int mY;
	String mName;

	

	public VillageInfoItem(String aVillageId, String x, String y, String name) {
		super(aVillageId);
		mX = Integer.parseInt(x);
		mY = Integer.parseInt(y);
		mName = name;
	}

	public VillageInfoItem(Long aVillageId, int x, int y, String name) {
		super(aVillageId);
		mX = x;
		mY = y;
		mName = name;
	}


	public int getX() {
		return mX;
	}


	public void setX(int x) {
		mX = x;
	}


	public int getY() {
		return mY;
	}


	public void setY(int y) {
		mY = y;
	}


	public String getName() {
		return mName;
	}


	public void setName(String name) {
		mName = name;
	}
	
	
	

}
