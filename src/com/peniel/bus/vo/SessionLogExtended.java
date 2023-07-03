package com.peniel.bus.vo;

/**
 * Created by IntelliJ IDEA.
 * User: tsieland
 * Date: 12/10/11
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class SessionLogExtended extends SessionLog {
    private String documentNumber;
    private String documentType;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
}
