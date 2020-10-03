package bean;

public class Drug {
	private String drugId;//药品编码（唯一）
	private String drugName;//药品名称
	private String drugPingyin;//拼音助记码
	private String drugSpecification;//药品规格
	private String drugUnit;//药品包装单位
	private String drugType;//药品类型
	private Double drugPrice;//药品价格
	private String drugJX;//药品剂型
	private int drugAmount;//药品数量
	


	public Drug() {}
	
	public Drug(String drugId,String drugName,
			String drugPingyin,String drugSpecification,
			String drugUnit,String drugType,Double drugPrice,
			String drugJX,int drugAmount) {
		this.drugId = drugId;
		this.drugName = drugName;
		this.drugPingyin = drugPingyin;
		this.drugJX = drugJX;
		this.drugPrice = drugPrice;
		this.drugSpecification = drugSpecification;
		this.drugType = drugType;
		this.drugUnit = drugUnit;
		this.drugAmount=drugAmount;
	}

	
	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getDrugPingyin() {
		return drugPingyin;
	}

	public void setDrugPingyin(String drugPingyin) {
		this.drugPingyin = drugPingyin;
	}

	public String getDrugSpecification() {
		return drugSpecification;
	}

	public void setDrugSpecification(String drugSpecification) {
		this.drugSpecification = drugSpecification;
	}

	public String getDrugUnit() {
		return drugUnit;
	}

	public void setDrugUnit(String drugUnit) {
		this.drugUnit = drugUnit;
	}

	public String getDrugType() {
		return drugType;
	}

	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}

	public Double getDrugPrice() {
		return drugPrice;
	}

	public void setDrugPrice(Double drugPrice) {
		this.drugPrice = drugPrice;
	}

	public String getDrugJX() {
		return drugJX;
	}

	public void setDrugJX(String drugJX) {
		this.drugJX = drugJX;
	}

	public void setDrugPacking(String drugJX) {
		this.drugJX = drugJX;
	}

	public int getDrugAmount() {
		return drugAmount;
	}

	public void setDrugAmount(int drugAmount) {
		this.drugAmount = drugAmount;
	}
	
	
	
}
