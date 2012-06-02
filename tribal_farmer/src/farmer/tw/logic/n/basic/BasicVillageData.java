package farmer.tw.logic.n.basic;

public abstract class BasicVillageData {
	
	private Long mVillageId;
	
	public Long getID() {
		return null;
	}
	
	public BasicVillageData(Long aVillageId) {
		this.mVillageId = aVillageId;
	}
	
	public BasicVillageData(String aVillageId) {
		this.mVillageId = Long.parseLong(aVillageId);
	}

}
