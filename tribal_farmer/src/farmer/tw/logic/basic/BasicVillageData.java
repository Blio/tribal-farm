package farmer.tw.logic.basic;

public abstract class BasicVillageData {
	
	protected Long mVillageId;
	
	public Long getID() {
		return mVillageId;
	}
	
	public BasicVillageData(Long aVillageId) {
		this.mVillageId = aVillageId;
	}
	
	public BasicVillageData(String aVillageId) {
		this.mVillageId = Long.parseLong(aVillageId);
	}

}
