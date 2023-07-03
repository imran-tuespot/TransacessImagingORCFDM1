

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddRightsResponse {
	 @JsonInclude(Include.NON_DEFAULT)
	private int rightDetailId;
	private long rightId;
	private String rightName;
	private String rightDescription;
	private String acessType;
	private int createdBy;
	@JsonInclude(Include.NON_NULL)
	private String createdOn;
	 @JsonInclude(Include.NON_DEFAULT)
	private int modifiedBy;
	@JsonInclude(Include.NON_NULL)
	private String modifiedOn;
	 @JsonInclude(Include.NON_NULL)
	private String folderPattern;
	/* @JsonInclude(Include.NON_NULL)
	private int rightDetailId;*/
	 @JsonProperty
	 @JsonInclude(Include.NON_NULL)
	private List<RightsDetail> rightDetails =new ArrayList<RightsDetail>();
	
	
	
	public int getRightDetailId() {
		return rightDetailId;
	}
	public void setRightDetailId(int rightDetailId) {
		this.rightDetailId = rightDetailId;
	}
	public List<RightsDetail> getRightDetails() {
		return rightDetails;
	}
	public void setRightDetails(List<RightsDetail> rightDetails) {
		this.rightDetails = rightDetails;
	}
	public long getRightId() {
		return rightId;
	}
	public void setRightId(long rightId) {
		this.rightId = rightId;
	}
	public String getRightName() {
		return rightName;
	}
	public void setRightName(String rightName) {
		this.rightName = rightName;
	}
	public String getRightDescription() {
		return rightDescription;
	}
	public void setRightDescription(String rightDescription) {
		this.rightDescription = rightDescription;
	}
	public String getAcessType() {
		return acessType;
	}
	public void setAcessType(String acessType) {
		this.acessType = acessType;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getFolderPattern() {
		return folderPattern;
	}
	public void setFolderPattern(String folderPattern) {
		this.folderPattern = folderPattern;
	}
	
	/*public int getRightDetailId() {
		return rightDetailId;
	}
	public void setRightDetailId(int rightDetailId) {
		this.rightDetailId = rightDetailId;
	}*/
	
	
	
	
	

}
