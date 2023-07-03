package com.peniel.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: todds
 * Date: 11/16/11
 * Time: 6:39 PM
 */
public class IndexHolder {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexHolder.class);

    private String docid;
    private String indexid;
    private String indexval;

    public IndexHolder(String indexid, String docid, String indexval) {
        this.indexid = indexid;
        this.docid = docid;
        this.indexval = indexval;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getIndexid() {
        return indexid;
    }

    public void setIndexid(String indexid) {
        this.indexid = indexid;
    }

    public String getIndexval() {
        return indexval;
    }

    public void setIndexval(String indexval) {
        this.indexval = indexval;
    }
}
