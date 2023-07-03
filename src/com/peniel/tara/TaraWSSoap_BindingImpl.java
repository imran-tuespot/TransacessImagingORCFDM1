/**
 * TaraWSSoap_BindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.peniel.tara;

public class TaraWSSoap_BindingImpl implements com.peniel.tara.TaraWSSoap_PortType{
    public com.peniel.tara.CommentLikeDTO getCommentLikeBySubject(java.lang.String loginContextId, int commentId, int subjectId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.CommentLikeDTO[] listCommentLikes(java.lang.String loginContextId, int commentId) throws java.rmi.RemoteException {
        return null;
    }

    public boolean isFlightModeFeatureLicensed(java.lang.String loginContextId) throws java.rmi.RemoteException {
        return false;
    }

    public com.peniel.tara.UserTypeRuntimePermissionDTO getUserTypeRuntimePermission(int subjectId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.OfflineReviewCommentSyncError validateComment(java.lang.String loginContextId, com.peniel.tara.CommentDTO[] lstCommentDto) throws java.rmi.RemoteException {
        return null;
    }

    public void copyReviewComments(java.lang.String loginContextId, com.peniel.tara.ListCommentParamsDTO param, int toReviewId) throws java.rmi.RemoteException {
    }

    public void deleteComment(java.lang.String loginContextId, int commentId) throws java.rmi.RemoteException {
    }

    public com.peniel.tara.CommentDTO getComment(java.lang.String loginContextId, int commentId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.CommentStatsDTO[] getCommentStats(java.lang.String loginContextId, com.peniel.tara.CommentStatsParamsDTO commentStatsParamsDto) throws java.rmi.RemoteException {
        return null;
    }

    public boolean hasParticipantRight(java.lang.String loginContextId, int reviewId, int subjectId, int participantId, java.lang.String requiredPermission) throws java.rmi.RemoteException {
        return false;
    }

    public boolean isReviewOwner(java.lang.String loginContextId, int reviewId, int subjectId) throws java.rmi.RemoteException {
        return false;
    }

    public boolean hasRequiredPermission(java.lang.String loginContextId, java.lang.String permissionType, java.lang.String role, java.lang.String requiredRight) throws java.rmi.RemoteException {
        return false;
    }

    public boolean hasRequiredPermission1(java.lang.String loginContextId, int subjectId, int workgroupId, java.lang.String permissionType, java.lang.String role, java.lang.String requiredRight) throws java.rmi.RemoteException {
        return false;
    }

    public boolean subjectInWorkgroup(java.lang.String loginContextId, com.peniel.tara.SubjectDTO subjectDto, int workgroupid) throws java.rmi.RemoteException {
        return false;
    }

    public com.peniel.tara.WorkgroupDTO[] listWorkgroupsForSubject(java.lang.String loginContextId, int subjectId, java.lang.String workgroupPermission, boolean includeMember, boolean includeLicenseAdmin) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.WorkgroupDTO[] listWorkgroupsForSubject1(java.lang.String loginContextId, int subjectId, java.lang.String workgroupPermission, boolean includeMember, boolean includeLicenseAdmin, boolean includeTaskgroup) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.WorkgroupMemberDTO getWorkgroupMember(java.lang.String loginContextId, int workgroupMemberId) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String getWorkgroupRoleForSubject(java.lang.String loginContextId, int subjectId, int workgroupId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.WorkgroupMemberDTO[] listWorkgroupMembers(java.lang.String loginContextId, int workgroupId, boolean showInactiveUsers) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.WorkgroupMemberDTO[] listWorkgroupMembers1(java.lang.String loginContextId, int workgroupId, int ownerId, java.lang.String permissionType, java.lang.String requiredRight, boolean showInactiveUsers) throws java.rmi.RemoteException {
        return null;
    }

    public int saveWorkgroup(java.lang.String loginContextId, com.peniel.tara.WorkgroupDTO ddto) throws java.rmi.RemoteException {
        return -3;
    }

    public com.peniel.tara.WorkgroupDTO getWorkgroup(java.lang.String loginContextId, int workgroupid) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.WorkgroupDTO getWorkgroupByName(java.lang.String loginContextId, java.lang.String workgroupName) throws java.rmi.RemoteException {
        return null;
    }

    public void deleteWorkgroup(java.lang.String loginContextId, int workgroupid) throws java.rmi.RemoteException {
    }

    public com.peniel.tara.EmailQueueEntryDTO[] listReviewEmailQueue(java.lang.String loginContextId, int reviewId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.EmailQueueEntryDTO[] listAdminEmailQueue(java.lang.String loginContextId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.EmailQueueEntryDTO getEmailQueueEntry(java.lang.String loginContextId, int queueEntryId) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String checkReviewEmailStatus(java.lang.String loginContextId, int reviewId) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String checkAdminEmailStatus(java.lang.String loginContextId) throws java.rmi.RemoteException {
        return null;
    }

    public void deleteEmailQueueEntry(java.lang.String loginContextId, int queueEntryId) throws java.rmi.RemoteException {
    }

    public int saveEmailQueueEntry(java.lang.String loginContextId, com.peniel.tara.EmailQueueEntryDTO emailQueueEntryDto) throws java.rmi.RemoteException {
        return -3;
    }

    public void sendParagraphEmail(java.lang.String loginContextId, int reviewId, int documentId, java.lang.String paragraphId, int[] subjectIds, java.lang.String subjectLine, java.lang.String textblock) throws java.rmi.RemoteException {
    }

    public void sendReviewEmail(java.lang.String loginContextId, int reviewId, int[] subjectIds, java.lang.String subjectLine, java.lang.String textblock) throws java.rmi.RemoteException {
    }

    public void sendFolderEmail(java.lang.String loginContextId, int folderId, int[] subjectIds, java.lang.String subjectLine, java.lang.String textblock) throws java.rmi.RemoteException {
    }

    public com.peniel.tara.SettingsDTO[] listSettings(java.lang.String loginContextId, com.peniel.tara.SettingsDTO param, int minExpected, int maxExpected) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.SettingsDTO[] listSettings2(java.lang.String loginContextId, com.peniel.tara.SettingsDTO param, int minExpected, int maxExpected, boolean hasPermissionToLinkedReview) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.SettingsDTO getSettings(java.lang.String loginContextId, java.lang.String refObjectType, int refObjectId, java.lang.String entryName, boolean returnNewIfNone) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.SettingsDTO getSettings2(java.lang.String loginContextId, java.lang.String refObjectType, int refObjectId, java.lang.String entryName, boolean returnNewIfNone, boolean hasPermissionToLinkedReview) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.SettingsDTO findSetting(java.lang.String loginContextId, java.lang.String refObjectType, int refObjectId, java.lang.String entryName, java.lang.String stringParam1, boolean returnNewIfNone) throws java.rmi.RemoteException {
        return null;
    }

    public void saveSettings(java.lang.String loginContextId, com.peniel.tara.SettingsDTO dto) throws java.rmi.RemoteException {
    }

    public void saveSettings1(java.lang.String loginContextId, com.peniel.tara.SettingsDTO[] dtos, boolean replaceAll) throws java.rmi.RemoteException {
    }

    public void deleteSettings(java.lang.String loginContextId, int objectid) throws java.rmi.RemoteException {
    }

    public void deleteSettings1(java.lang.String loginContextId, java.lang.String refObjectType, int refObjectId, java.lang.String entryName) throws java.rmi.RemoteException {
    }

    public com.peniel.tara.SettingsDTO getOfflineSettings(java.lang.String loginContextId, int reviewId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.SettingsDTO getOfflineSettings2(java.lang.String loginContextId, int reviewId, boolean hasPermissionToLinkedReview) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.SettingsDTO getAutoRefreshSettings(java.lang.String loginContextId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.SettingsDTO[] listReviewActivity(java.lang.String loginContextId, int participantId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.SettingsDTO[] listReviewActivity2(java.lang.String loginContextId, int participantId, boolean hasPermissionToLinkedReview) throws java.rmi.RemoteException {
        return null;
    }

    public void updateReviewActivity(java.lang.String loginContextId, int participantId, int activityType, java.util.Calendar dateTime) throws java.rmi.RemoteException {
    }

    public com.peniel.tara.SettingsDTO[] listEmailOptions(java.lang.String loginContextId, int reviewId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.LicenseDTO[] listLicenses(java.lang.String loginContextId, boolean includeOwnerSubjectDTO) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.LicenseDTO getLicense(java.lang.String loginContextId, int licenseId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.LicenseCountDTO[] getLicenseCounts(java.lang.String loginContextId, int licenseId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.LicenseDTO getLicenseForSubject(java.lang.String loginContextId, int subjectId) throws java.rmi.RemoteException {
        return null;
    }

    public int saveLicense(java.lang.String loginContextId, com.peniel.tara.LicenseDTO ddto) throws java.rmi.RemoteException {
        return -3;
    }

    public void deleteLicense(java.lang.String loginContextId, int licenseid) throws java.rmi.RemoteException {
    }

    public boolean licenseHasContributorsEnabled(java.lang.String loginContextId) throws java.rmi.RemoteException {
        return false;
    }

    public boolean checkLicenseHasContributorsEnabled(int licenseId) throws java.rmi.RemoteException {
        return false;
    }

    public com.peniel.tara.TrustedClientDTO getTrustedClient(java.lang.String loginContextId, int trustedClientId) throws java.rmi.RemoteException {
        return null;
    }

    public void validateTrustedClient1(java.lang.String loginContextId, java.lang.String serviceRef) throws java.rmi.RemoteException {
    }

    public com.peniel.tara.TrustedClientDTO[] listTrustedClients(java.lang.String loginContextId) throws java.rmi.RemoteException {
        return null;
    }

    public int saveTrustedClient(java.lang.String loginContextId, com.peniel.tara.TrustedClientDTO dto) throws java.rmi.RemoteException {
        return -3;
    }

    public void deleteTrustedClient(java.lang.String loginContextId, int trustedClientId) throws java.rmi.RemoteException {
    }

    public byte[] makeOfflineDataPacket(java.lang.String loginContextId, int reviewId) throws java.rmi.RemoteException {
        return null;
    }

    public byte[] getOfflineClientWeb(java.lang.String loginContextId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.SystemConnectorDTO getSystemConnectorDTO(java.lang.String accessKey, java.lang.String sysconname) throws java.rmi.RemoteException {
        return null;
    }

    public boolean isLockedWorkgroup(java.lang.String accessKey, java.lang.String sysconname, java.lang.String extSource, java.lang.String extRef) throws java.rmi.RemoteException {
        return false;
    }

    public java.lang.String prettyPrintExtSource(java.lang.String accessKey, java.lang.String sysconname, java.lang.String extSource, java.lang.String extRef) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String displayIcons(java.lang.String accessKey, java.lang.String sysconname, java.lang.String objectType, java.lang.String textToDisplay, java.lang.String extSource, java.lang.String extRef, java.lang.String ownerExtRef) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.FileContentDTO getContent(java.lang.String loginContextId, java.lang.String extSource, java.lang.String extRef) throws java.rmi.RemoteException {
        return null;
    }

    public boolean cancelDocument(java.lang.String loginContextId, java.lang.String extref, java.lang.String extsource) throws java.rmi.RemoteException {
        return false;
    }

    public void syncWorkgroup(java.lang.String loginContextId, java.lang.String extSource, java.lang.String extRef, int workgroupid, com.peniel.tara.WorkgroupMemberDTO[] members, boolean neverSendInviteForSyscon) throws java.rmi.RemoteException {
    }

    public boolean isInOfflineMode(java.lang.String accessKey) throws java.rmi.RemoteException {
        return false;
    }

    public com.peniel.tara.WorkgroupMemberDTO getWorkgroupMember1(java.lang.String loginContextId, int subjectid, int workgroupid) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.WorkgroupDTO[] renderWorkgroupNames(java.lang.String loginContextId, com.peniel.tara.WorkgroupDTO[] workgroups) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.SubjectDTO[] findUsers(java.lang.String loginContextId, java.lang.String loginSource, java.lang.String emailAddress, java.lang.String userName, java.lang.String fullName, boolean showInactiveUsers) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.SubjectDTO getUser(java.lang.String loginContextId, java.lang.String extSource, java.lang.String extRef) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.Object loginSysadminIntoExternalSystem(java.lang.String loginContextId, java.lang.String extSource) throws java.rmi.RemoteException {
        return null;
    }

    public void logoutSysadminFromExternalSystem(java.lang.String loginContextId, java.lang.String extSource, java.lang.Object externalSession) throws java.rmi.RemoteException {
    }

    public com.peniel.tara.WorkgroupDTO[] findGroup(java.lang.String loginContextId, java.lang.String loginSource, java.lang.String groupName) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.WorkgroupMemberDTO[] getGroupMembers(java.lang.String loginContextId, java.lang.String extSource, java.lang.String extRef) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String getExternalFileSelectionPopupURL(java.lang.String loginContextId, java.lang.String extSource) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String getDocTypeMapping(java.lang.String loginContextId, java.lang.String extSource, java.lang.String docType, java.lang.String fileName) throws java.rmi.RemoteException {
        return null;
    }

    public boolean isPleaseApproveLicensed(java.lang.String accessKey) throws java.rmi.RemoteException {
        return false;
    }

    public boolean isPleaseApproveLicensedForUser(java.lang.String loginContextId) throws java.rmi.RemoteException {
        return false;
    }

    public boolean isPleaseReviewLicensed(java.lang.String accessKey) throws java.rmi.RemoteException {
        return false;
    }

    public boolean isPleaseReviewLicensedForUser(java.lang.String loginContextId) throws java.rmi.RemoteException {
        return false;
    }

    public java.lang.String checkinDocument(java.lang.String loginContextId, java.lang.String extSource, java.lang.String extRef, int checkinMode, com.peniel.tara.FileContentDTO contents, java.lang.String extraInfo, int reviewid, int documentid) throws java.rmi.RemoteException {
        return null;
    }

    public boolean isDocumentCheckedOut(java.lang.String loginContextId, java.lang.String extSource, java.lang.String extRef) throws java.rmi.RemoteException {
        return false;
    }

    public boolean isDocumentModified(java.lang.String loginContextId, java.lang.String extSource, java.lang.String extRef) throws java.rmi.RemoteException {
        return false;
    }

    public com.peniel.tara.CheckinOptionDTO[] getCheckinActions(java.lang.String loginContextId, java.lang.String extSource) throws java.rmi.RemoteException {
        return null;
    }

    public boolean isApprovalOpen(java.lang.String loginContextId, int participantid) throws java.rmi.RemoteException {
        return false;
    }

    public com.peniel.tara.SettingsDTO lockApproval(java.lang.String loginContextId, int sourceObjectId, java.util.Calendar expiryDate) throws java.rmi.RemoteException {
        return null;
    }

    public void releaseApprovalLock(java.lang.String loginContextId, int sourceObjectId) throws java.rmi.RemoteException {
    }

    public com.peniel.tara.SettingsDTO getApprovalLockInfo(java.lang.String loginContextId, int sourceObjectId) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String saveWordML(java.lang.String loginContextId, com.peniel.tara.SaveWordMLXdoc xdoc, java.lang.String status) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String saveWordML2(java.lang.String loginContextId, java.lang.String documentId, java.lang.String editId, com.peniel.tara.FileContentDTO fc, java.lang.String status) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.EditDTO getEdit(java.lang.String loginContextId, int editId, java.lang.String zoneType) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.EditDTO getSmartEditRange(java.lang.String loginContextId, int documentId, int modificationCount, java.lang.String paragraphId, boolean returnSection) throws java.rmi.RemoteException {
        return null;
    }

    public boolean validateSmartEditRange(java.lang.String loginContextId, int documentId, com.peniel.tara.EditDTO edit, com.peniel.tara.EditDTO[] editsDto) throws java.rmi.RemoteException {
        return false;
    }

    public com.peniel.tara.CellDTO getExcelResultText(java.lang.String loginContextId, int documentId, int modificationCount, java.lang.String paragraphId) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String[] getExistingRange(java.lang.String loginContextId, int documentId, com.peniel.tara.EditDTO edit) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.EditDTO[] listEdits(java.lang.String loginContextId, com.peniel.tara.ListEditDTO listEditDto) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.EditDTO[] listEditRole(java.lang.String loginContextId, com.peniel.tara.ListEditDTO listEditDto) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.EditVersionDTO[] listEditVersions(java.lang.String loginContextId, com.peniel.tara.ListEditVersionDTO listEditVersionDto) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.EditHistoryDTO[] listEditHistory(java.lang.String loginContextId, int reviewId, int documentId) throws java.rmi.RemoteException {
        return null;
    }

    public int saveEdit(java.lang.String loginContextId, com.peniel.tara.EditDTO editDto) throws java.rmi.RemoteException {
        return -3;
    }

    public int saveEdit1(java.lang.String loginContextId, com.peniel.tara.EditDTO editDto, boolean existingContributor) throws java.rmi.RemoteException {
        return -3;
    }

    public void saveEditVersion(java.lang.String loginContextId, com.peniel.tara.EditVersionDTO editVersionDto) throws java.rmi.RemoteException {
    }

    public void deleteEditVersion(java.lang.String loginContextId, int editVersionId) throws java.rmi.RemoteException {
    }

    public void deleteEdit(java.lang.String loginContextId, int editId, java.lang.String zoneType) throws java.rmi.RemoteException {
    }

    public void handleEditZoneStatusChange(java.lang.String loginContextId, int reviewId, java.lang.String zoneType, java.lang.String zoneStatus) throws java.rmi.RemoteException {
    }

    public int saveBookmark(java.lang.String loginContextId, com.peniel.tara.BookmarkDTO bookmarkDto) throws java.rmi.RemoteException {
        return -3;
    }

    public com.peniel.tara.BookmarkDTO getBookmark(java.lang.String loginContextId, int bookmarkId) throws java.rmi.RemoteException {
        return null;
    }

    public void deleteBookmark(java.lang.String loginContextId, int bookmarkId) throws java.rmi.RemoteException {
    }

    public com.peniel.tara.BookmarkDTO[] listBookmarks(java.lang.String loginContextId, com.peniel.tara.ListBookmarkParamsDTO listBookmarkParamsDto) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.BookmarkDTO[] listBookmarkHistory(java.lang.String loginContextId, com.peniel.tara.ListBookmarkParamsDTO listBookmarkParamsDto) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.CultureConfigDTO getCultureConfig(java.lang.String accessKey) throws java.rmi.RemoteException {
        return null;
    }

    public boolean embedReviewPane(java.lang.String loginContextId, java.lang.String extSource) throws java.rmi.RemoteException {
        return false;
    }

    public boolean embedReviewCanBeOverridden(java.lang.String loginContextId, java.lang.String extSource) throws java.rmi.RemoteException {
        return false;
    }

    public com.peniel.tara.ParticipantDTO[] searchReviews(java.lang.String loginContextId, java.lang.String filterBy, boolean searchAllWorkgroups, boolean searchDeleted) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String getWarnings(java.lang.String loginContextId, int warningType) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String getDefaultWorkgroupRole(java.lang.String loginContextId, java.lang.String extSource) throws java.rmi.RemoteException {
        return null;
    }

    public boolean usesSuperUserForCheckout(java.lang.String loginContextId, java.lang.String extSource) throws java.rmi.RemoteException {
        return false;
    }

    public java.lang.String transformMarkUpText(java.lang.String loginContextId, com.peniel.tara.TransformMarkUpTextXmlDiff xmlDiff) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String transformMarkUpText2(java.lang.String loginContextId, com.peniel.tara.TransformMarkUpText2XmlDiff xmlDiff, boolean showMerged) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String transformMarkUpText3(java.lang.String loginContextId, com.peniel.tara.TransformMarkUpText3XmlDiff xmlDiff, com.peniel.tara.TransformMarkUpText3ColorMap colorMap, java.lang.String paragraphColor, boolean isRecon, boolean showMerged) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.FeedbackTypeDTO getFeedbackType(java.lang.String loginContextId, int documentId, java.lang.String paragraphId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.FeedbackOptionDTO[] getFeedbackOptionList(java.lang.String loginContextId, int documentId, java.lang.String paragraphId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.CommentDTO[] getFeedbackResultList(java.lang.String loginContextId, int reviewId, int documentId, java.lang.String paragraphId) throws java.rmi.RemoteException {
        return null;
    }

    public int saveCommentLike(java.lang.String loginContextId, com.peniel.tara.CommentLikeDTO commentLikeDto) throws java.rmi.RemoteException {
        return -3;
    }

    public com.peniel.tara.CommentLikeDTO getCommentLike(java.lang.String loginContextId, int commentLikeId) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String login1(java.lang.String accessKey, java.lang.String connectorContext, java.lang.String username, java.lang.String password, java.lang.String userArg1, java.lang.String userArg2) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String login2(java.lang.String accessKey, java.lang.String token) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String loginAs(java.lang.String accessKey, java.lang.String loginContextId, int subjectid) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.LoginContextDTO getLoginContext(java.lang.String loginContextId) throws java.rmi.RemoteException {
        return null;
    }

    public void logout(java.lang.String loginContextId) throws java.rmi.RemoteException {
    }

    public java.lang.String getLoginToken(java.lang.String loginContextId, int expiryMinutes) throws java.rmi.RemoteException {
        return null;
    }

    public void changeWorkgroup(java.lang.String loginContextId, int workgroupId) throws java.rmi.RemoteException {
    }

    public void sendPasswordEmail(java.lang.String accessKey, java.lang.String emailAddress) throws java.rmi.RemoteException {
    }

    public java.lang.String changeEmailAddress(java.lang.String accessKey, java.lang.String token) throws java.rmi.RemoteException {
        return null;
    }

    public void changePassword(java.lang.String accessKey, java.lang.String token, java.lang.String newPassword) throws java.rmi.RemoteException {
    }

    public java.lang.String getServerVersion(java.lang.String accessKey) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String getServerRevision(java.lang.String accessKey) throws java.rmi.RemoteException {
        return null;
    }

    public boolean isValidVersion(java.lang.String accessKey, java.lang.String version) throws java.rmi.RemoteException {
        return false;
    }

    public com.peniel.tara.ConfigEntryDTO[] getServerConfig(java.lang.String accessKey) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.FeedbackConfigDTO getFeedbackConfig(java.lang.String accessKey) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String getPDFPluginCompatibilityConfig(java.lang.String accessKey) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.FileFormatDTO[] listFileFormats(java.lang.String accessKey) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.FileFormatDTO guessFileFormat(java.lang.String accessKey, java.lang.String fileExtension, java.lang.String contentType) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.StatusCodeDTO[] listStatusCodes(java.lang.String accessKey) throws java.rmi.RemoteException {
        return null;
    }

    public void sendGeneralEmail(java.lang.String accessKey, java.lang.String emailType, java.lang.String senderEmail, java.lang.String senderName, java.lang.String textblock1, java.lang.String textblock2, java.lang.String textblock3) throws java.rmi.RemoteException {
    }

    public boolean isExistingUser(java.lang.String accessKey, java.lang.String token) throws java.rmi.RemoteException {
        return false;
    }

    public void validateTrustedClient(java.lang.String accessKey, java.lang.String ipAddress, java.lang.String serviceRef) throws java.rmi.RemoteException {
    }

    public com.peniel.tara.SystemConnectorDTO[] listSystemConnectors(java.lang.String accessKey) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.FillParticipantColorResponseFillParticipantColorResult fillParticipantColor(java.lang.String accessKey, int reviewId) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String getParticipantColor(java.lang.String accessKey, int subjectId, com.peniel.tara.GetParticipantColorColorMap colorMap) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.PermissionSetDTO[] listPermissionSets(java.lang.String accessKey, java.lang.String permissionType) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String getDefaultExtSource(java.lang.String accessKey) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String generateReport(java.lang.String loginContextId, java.lang.String reportType, com.peniel.tara.ReportParamsDTO reportParams) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String reviewDefaultReason(java.lang.String reasonCode) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String encryptPassword(java.lang.String loginContextId, java.lang.String password) throws java.rmi.RemoteException {
        return null;
    }

    public void sendEmailChangeEmail(java.lang.String loginContextId, java.lang.String newEmailAddress) throws java.rmi.RemoteException {
    }

    public int saveSubject(java.lang.String loginContextId, com.peniel.tara.SubjectDTO dto) throws java.rmi.RemoteException {
        return -3;
    }

    public void deleteSubject(java.lang.String loginContextId, int subjectId) throws java.rmi.RemoteException {
    }

    public int saveSubjectExtSource(java.lang.String loginContextId, int subjectid, com.peniel.tara.SubjectExtSourceDTO subjectExtSourceDTO, java.lang.String password, boolean neverSendEmail) throws java.rmi.RemoteException {
        return -3;
    }

    public void deleteSubjectExtSource(java.lang.String loginContextId, int subjectExtSourceId) throws java.rmi.RemoteException {
    }

    public boolean isWorkgroupMonitor(java.lang.String loginContextId) throws java.rmi.RemoteException {
        return false;
    }

    public boolean isWorkgroupAdmin(java.lang.String loginContextId) throws java.rmi.RemoteException {
        return false;
    }

    public boolean isSysAdmin(java.lang.String loginContextId) throws java.rmi.RemoteException {
        return false;
    }

    public boolean isLicenseAdmin(java.lang.String loginContextId) throws java.rmi.RemoteException {
        return false;
    }

    public boolean isLicenseAdminForWorkgroup(java.lang.String loginContextId, int workgroupId) throws java.rmi.RemoteException {
        return false;
    }

    public boolean isAuthorForWorkgroup(java.lang.String loginContextId, int workgroupId) throws java.rmi.RemoteException {
        return false;
    }

    public boolean userNameExists(java.lang.String loginContextId, java.lang.String username) throws java.rmi.RemoteException {
        return false;
    }

    public void deleteWorkgroupMember(java.lang.String loginContextId, int workgroupMemberId) throws java.rmi.RemoteException {
    }

    public com.peniel.tara.SubjectDTO getSubject(java.lang.String loginContextId, int subjectId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.SubjectDTO getSubject1(java.lang.String loginContextId, int subjectId, boolean populateSubjectExtSources) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.SubjectDTO getSubjectByEmail(java.lang.String loginContextId, java.lang.String emailAddress) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.SubjectDTO getSubjectByEmail1(java.lang.String loginContextId, java.lang.String emailAddress, java.lang.String extSource) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.SubjectDTO getSubjectBySubjectRef(java.lang.String loginContextId, java.lang.String subjectRef) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.SubjectDTO getSubjectBySubjectRef1(java.lang.String loginContextId, java.lang.String subjectRef, java.lang.String extSource) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.SubjectDTO getSubjectBySubjectRef2(java.lang.String loginContextId, java.lang.String subjectRef, java.lang.String extSource, boolean populateSubjectExtSources) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.SystemPolicyDTO getSystemPolicyItem(java.lang.String loginContextId, java.lang.String object, java.lang.String principal, java.lang.String permission) throws java.rmi.RemoteException {
        return null;
    }

    public boolean isPermittedBySystemPolicy(java.lang.String loginContextId, java.lang.String object, java.lang.String principal, java.lang.String permission) throws java.rmi.RemoteException {
        return false;
    }

    public boolean isPermittedBySystemPolicy1(java.lang.String loginContextId, java.lang.String object, java.lang.String principal, java.lang.String permission, boolean defaultAction) throws java.rmi.RemoteException {
        return false;
    }

    public com.peniel.tara.SystemPolicyDTO[] listSystemPolicy(java.lang.String loginContextId, java.lang.String object, java.lang.String principal, java.lang.String permission) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String formatDateForDisplay(java.lang.String loginContextId, java.util.Calendar date, boolean showTime) throws java.rmi.RemoteException {
        return null;
    }

    public int saveWorkgroupMember(java.lang.String loginContextId, com.peniel.tara.WorkgroupMemberDTO ddto) throws java.rmi.RemoteException {
        return -3;
    }

    public com.peniel.tara.FolderDTO[] listFolders(java.lang.String loginContextId, int workgroupId, int folderId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.FolderDTO getFolder(java.lang.String loginContextId, int folderId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.FolderDTO[] getFolderPath(java.lang.String loginContextId, int folderId) throws java.rmi.RemoteException {
        return null;
    }

    public int saveFolder(java.lang.String loginContextId, com.peniel.tara.FolderDTO dto) throws java.rmi.RemoteException {
        return -3;
    }

    public void deleteFolder(java.lang.String loginContextId, int folderId) throws java.rmi.RemoteException {
    }

    public int saveReview(java.lang.String loginContextId, com.peniel.tara.ReviewDTO dto) throws java.rmi.RemoteException {
        return -3;
    }

    public com.peniel.tara.ReviewDTO getReviewForToolTip(java.lang.String loginContextId, int reviewId, boolean hasPermissionToLinkedReview) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.ReviewDTO getSearchReview(java.lang.String loginContextId, int reviewId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.ReviewDTO getReview(java.lang.String loginContextId, int reviewId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.ReviewDTO getReview2(java.lang.String loginContextId, int reviewId, boolean hasLinkedReviewPermission) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.ReviewDTO[] getLinkedReviews(java.lang.String loginContextId, int reviewId, java.lang.String compareLink, boolean hasLinkedReviewPermission) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.ReviewDTO[] listReviews(java.lang.String loginContextId, com.peniel.tara.ListReviewDTO listReviewDto) throws java.rmi.RemoteException {
        return null;
    }

    public void deleteReview(java.lang.String loginContextId, int reviewId) throws java.rmi.RemoteException {
    }

    public void restoreReview(java.lang.String loginContextId, int reviewId) throws java.rmi.RemoteException {
    }

    public void sendReconciliationEmails(java.lang.String loginContextId, int reviewId) throws java.rmi.RemoteException {
    }

    public java.lang.String changeReviewOwner(java.lang.String loginContextId, int reviewId, int newOwnerId) throws java.rmi.RemoteException {
        return null;
    }

    public int createDiffDocument(java.lang.String loginContextId, int oldDocumentId, int newDocumentId) throws java.rmi.RemoteException {
        return -3;
    }

    public void saveAutoLink(java.lang.String loginContextId, int reviewId, int linkedReviewId) throws java.rmi.RemoteException {
    }

    public int getAutoLink(java.lang.String loginContextId, int reviewId) throws java.rmi.RemoteException {
        return -3;
    }

    public int saveDocument(java.lang.String loginContextId, com.peniel.tara.DocumentDTO documentDto, com.peniel.tara.ReviewDocumentDTO reviewDocumentDto, com.peniel.tara.FileContentDTO[] fileContents) throws java.rmi.RemoteException {
        return -3;
    }

    public int saveCommentAttachment(java.lang.String loginContextId, com.peniel.tara.DocumentDTO documentDto, com.peniel.tara.FileContentDTO[] fileContents) throws java.rmi.RemoteException {
        return -3;
    }

    public void deleteDocument(java.lang.String loginContextId, int documentId) throws java.rmi.RemoteException {
    }

    public com.peniel.tara.DocumentDTO getDocument(java.lang.String loginContextId, int documentId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.DocumentDTO getDocument2(java.lang.String loginContextId, int documentId, boolean hasPermissionToLinkedReview) throws java.rmi.RemoteException {
        return null;
    }

    public byte[] getDocumentContents(java.lang.String loginContextId, com.peniel.tara.DocMarkUpParamsDTO docMarkUpParamsDTO) throws java.rmi.RemoteException {
        return null;
    }

    public boolean isPdfDocumentWithMap(java.lang.String loginContextId, java.lang.String formatName, int documentId, int modificationCount) throws java.rmi.RemoteException {
        return false;
    }

    public com.peniel.tara.EditVersionDTO getEditVersion(java.lang.String loginContextId, int editVersionId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.EditVersionDTO processEditVersion(java.lang.String loginContextId, int editId, int editVersionId, java.lang.String status, com.peniel.tara.ProcessEditVersionXdoc xdoc, java.lang.String fileName) throws java.rmi.RemoteException {
        return null;
    }

    public byte[] getReconReportAsWord(java.lang.String loginContextId, com.peniel.tara.GetReconReportAsWordCommentSelection commentSelection, int reviewId, boolean supportRichText, com.peniel.tara.DocMarkUpParamsDTO paramDto) throws java.rmi.RemoteException {
        return null;
    }

    public byte[] getReconReportAsWord2(java.lang.String loginContextId, com.peniel.tara.GetReconReportAsWord2CommentSelection commentSelection, int reviewId, boolean supportRichText, com.peniel.tara.DocMarkUpParamsDTO paramDto, boolean hasPermissionToLinkedReview) throws java.rmi.RemoteException {
        return null;
    }

    public byte[] getReconReportAsWordDocumentContents(java.lang.String loginContextId, com.peniel.tara.DocMarkUpParamsDTO docMarkUpParamsDTO, boolean supportRichText, com.peniel.tara.GetReconReportAsWordDocumentContentsSummaryEl summaryEl, com.peniel.tara.GetReconReportAsWordDocumentContentsReportParamEL reportParamEL) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.ReviewDocumentDTO[] listReviewDocuments(java.lang.String loginContextId, int reviewId, boolean includeReferenceOnly, boolean includeNonPrepared) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.ReviewDocumentDTO[] listReviewDocuments2(java.lang.String loginContextId, int reviewId, boolean includeReferenceOnly, boolean includeNonPrepared, boolean hasPermissionToLinkedReview) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.ReviewDocumentDTO[] listReviewDocumentsForDocument(java.lang.String loginContextId, int documentId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.DocumentDTO[] listDocuments2(java.lang.String loginContextId, int reviewId, boolean includeReferenceOnly, boolean includeNonPrepared, boolean hasPermissionToLinkedReview) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.DocumentDTO[] listDocuments(java.lang.String loginContextId, int reviewId, boolean includeReferenceOnly, boolean includeNonPrepared) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.DocumentDTO[] listDocuments1(java.lang.String loginContextId, int workgroupId, int folderId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.GetTableOfContentsResponseGetTableOfContentsResult getTableOfContents(java.lang.String loginContextId, int documentid) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.FileContentDTO getImageFromDocument(java.lang.String loginContextId, int documentId, int modificationCount, java.lang.String imageId) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String getParagraphText(java.lang.String loginContextId, int documentId, java.lang.String paragraphId) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String getHeaderText(java.lang.String loginContextId, int documentId, java.lang.String paragraphId) throws java.rmi.RemoteException {
        return null;
    }

    public java.lang.String getTitleText(java.lang.String loginContextId, int documentId, java.lang.String paragraphId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.GetReconcileReportResponseGetReconcileReportResult getReconcileReport(java.lang.String loginContextId, com.peniel.tara.ListCommentParamsDTO param, boolean showLinks, boolean unformatted) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.GenerateAuditReportResponseGenerateAuditReportResult generateAuditReport(java.lang.String loginContextId, int documentId, int reviewId, com.peniel.tara.GenerateAuditReportOptions options) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.ParticipantDTO getParticipant(java.lang.String loginContextId, int participantId, boolean includeReviewDto) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.ParticipantDTO getParticipant1(java.lang.String loginContextId, int reviewId, int subjectId, boolean includeReviewDto) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.ParticipantDTO[] listParticipants(java.lang.String loginContextId, int reviewId, boolean includeSubjectDto) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.ParticipantDTO[] listParticipantsBySubject(java.lang.String loginContextId, com.peniel.tara.ListParticipantParamsDTO listParticipantParamsDto) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.ParticipantDTO[] listParticipantsParagraphWatch(java.lang.String loginContextId, int reviewId, int documentId, java.lang.String paragraphId) throws java.rmi.RemoteException {
        return null;
    }

    public int saveParticipant(java.lang.String loginContextId, com.peniel.tara.ParticipantDTO participantDto) throws java.rmi.RemoteException {
        return -3;
    }

    public void deleteParticipant(java.lang.String loginContextId, int participantId) throws java.rmi.RemoteException {
    }

    public com.peniel.tara.DistListDTO[] listDistLists(java.lang.String loginContextId, int workgroupId, int subjectId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.DistListDTO[] listDistLists1(java.lang.String loginContextId, int workgroupId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.DistListDTO[] listAllDistLists(java.lang.String loginContextId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.DistListDTO getDistList(java.lang.String loginContextId, int distlistid) throws java.rmi.RemoteException {
        return null;
    }

    public int saveDistList(java.lang.String loginContextId, com.peniel.tara.DistListDTO dto) throws java.rmi.RemoteException {
        return -3;
    }

    public void deleteDistListEntry(java.lang.String loginContextId, int objectid) throws java.rmi.RemoteException {
    }

    public void deleteDistList(java.lang.String loginContextId, int objectid) throws java.rmi.RemoteException {
    }

    public com.peniel.tara.DistEntryDTO[] listDistEntries(java.lang.String loginContextId, int distListId, int workgroupId, boolean showInactiveUsers) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.DistEntryDTO[] listDistEntries1(java.lang.String loginContextId, java.lang.String searchString, int workgroupId) throws java.rmi.RemoteException {
        return null;
    }

    public void saveDistListEntries(java.lang.String loginContextId, int distListId, com.peniel.tara.DistEntryDTO[] dedto) throws java.rmi.RemoteException {
    }

    public com.peniel.tara.CommentDTO[] listComments(java.lang.String loginContextId, com.peniel.tara.ListCommentParamsDTO listCommentParamsDto) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.CommentHistoryDTO[] listCommentHistory(java.lang.String loginContextId, int commentId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.CommentHistoryDTO[] listCommentHistory2(java.lang.String loginContextId, int documentId, java.lang.String paragraphId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.CommentHistoryDTO[] listCommentHistoryForDocument(java.lang.String loginContextId, int documentId) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.CommentDTO[][] listCommentsByThreadForParagraph(java.lang.String loginContextId, com.peniel.tara.ListCommentParamsDTO listCommentParamsDto) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.CommentDTO[][][] listCommentsByThreadForDocument(java.lang.String loginContextId, com.peniel.tara.ListCommentParamsDTO listCommentParamsDto) throws java.rmi.RemoteException {
        return null;
    }

    public com.peniel.tara.ParagraphCommentDetailsDTO[] getParagraphCommentDetails(java.lang.String loginContextId, com.peniel.tara.ListCommentParamsDTO listCommentParamsDto, java.lang.String originalText) throws java.rmi.RemoteException {
        return null;
    }

    public int saveComment(java.lang.String loginContextId, com.peniel.tara.CommentDTO commentDto) throws java.rmi.RemoteException {
        return -3;
    }

    public boolean saveComment2(java.lang.String loginContextId, com.peniel.tara.CommentDTO[] lstCommentDto) throws java.rmi.RemoteException {
        return false;
    }

    public void enableTrustedClient(java.lang.String accessKey, java.lang.String loginContextId) throws java.rmi.RemoteException {
    }

}
