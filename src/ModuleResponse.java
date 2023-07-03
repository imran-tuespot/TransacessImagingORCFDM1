

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ModuleResponse {
	private int moduleId;
	@JsonInclude(Include.NON_DEFAULT)
	private int roleModuleId;
	private String moduleName;
	@JsonInclude(Include.NON_DEFAULT)
	private int createdBy;
	@JsonInclude(Include.NON_NULL)
	private String createdName;
	@JsonInclude(Include.NON_NULL)
	private String createdOn;
	@JsonInclude(Include.NON_DEFAULT)
	private int modifiedBy;
	@JsonInclude(Include.NON_NULL)
	private String modifiedOn;
	@JsonInclude(Include.NON_DEFAULT)
	private int companyId;
	@JsonInclude(Include.NON_DEFAULT)
	private int moduleHistoryId;
	
	@JsonInclude(Include.NON_DEFAULT)
	private int subModuleId;
	@JsonInclude(Include.NON_NULL)
	private String subModuleName;
	
	
	public int getRoleModuleId() {
		return roleModuleId;
	}
	public void setRoleModuleId(int roleModuleId) {
		this.roleModuleId = roleModuleId;
	}
	public int getModuleHistoryId() {
		return moduleHistoryId;
	}
	public void setModuleHistoryId(int moduleHistoryId) {
		this.moduleHistoryId = moduleHistoryId;
	}
	public String getCreatedName() {
		return createdName;
	}
	public void setCreatedName(String createdName) {
		this.createdName = createdName;
	}
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
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
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getSubModuleId() {
		return subModuleId;
	}
	public void setSubModuleId(int subModuleId) {
		this.subModuleId = subModuleId;
	}
	public String getSubModuleName() {
		return subModuleName;
	}
	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}
	@Override
	public String toString() {
		return "ModuleResponse [moduleId=" + moduleId + ", roleModuleId="
				+ roleModuleId + ", moduleName=" + moduleName + ", createdBy="
				+ createdBy + ", createdName=" + createdName + ", createdOn="
				+ createdOn + ", modifiedBy=" + modifiedBy + ", modifiedOn="
				+ modifiedOn + ", companyId=" + companyId
				+ ", moduleHistoryId=" + moduleHistoryId + ", subModuleId="
				+ subModuleId + ", subModuleName=" + subModuleName + "]";
	}
	

}
