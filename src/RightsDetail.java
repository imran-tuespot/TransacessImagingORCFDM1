

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class RightsDetail {
	private int rightDetailId;
	private int rightId;
	private String folderPattern;
	@JsonInclude(Include.NON_DEFAULT)
	 private int createdBy;
	 @JsonInclude(Include.NON_NULL)
	 private String createdOn;
	 @JsonInclude(Include.NON_DEFAULT)
	 private int modifiedBy;
	 @JsonInclude(Include.NON_NULL)
	 private String modifiedOn;
	public int getRightDetailId() {
		return rightDetailId;
	}
	public void setRightDetailId(int rightDetailId) {
		this.rightDetailId = rightDetailId;
	}
	public int getRightId() {
		return rightId;
	}
	public void setRightId(int rightId) {
		this.rightId = rightId;
	}
	public String getFolderPattern() {
		return folderPattern;
	}
	public void setFolderPattern(String folderPattern) {
		this.folderPattern = folderPattern;
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
	@Override
	public String toString() {
		return "RightsDetail [rightDetailId=" + rightDetailId + ", rightId=" + rightId + ", folderPattern="
				+ folderPattern + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy
				+ ", modifiedOn=" + modifiedOn + "]";
	}
     
}
