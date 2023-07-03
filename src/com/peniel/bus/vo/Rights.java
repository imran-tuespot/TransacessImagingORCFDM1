package com.peniel.bus.vo;

import java.util.List;

public class Rights {
   private int rightId;
   private String rightName;
   private String rightDesc;
   private String accessType;
   private List<String> folderPattern;
public int getRightId() {
	return rightId;
}
public void setRightId(int rightId) {
	this.rightId = rightId;
}
public String getRightName() {
	return rightName;
}
public void setRightName(String rightName) {
	this.rightName = rightName;
}
public String getRightDesc() {
	return rightDesc;
}
public void setRightDesc(String rightDesc) {
	this.rightDesc = rightDesc;
}
public String getAccessType() {
	return accessType;
}
public void setAccessType(String accessType) {
	this.accessType = accessType;
}
public List<String> getFolderPattern() {
	return folderPattern;
}
public void setFolderPattern(List<String> folderPattern) {
	this.folderPattern = folderPattern;
}
@Override
public String toString() {
	return "Rights [rightId=" + rightId + ", rightName=" + rightName + ", rightDesc=" + rightDesc + ", accessType="
			+ accessType + ", folderPattern=" + folderPattern + "]";
}
   
}
