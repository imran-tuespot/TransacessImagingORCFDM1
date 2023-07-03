package com.peniel.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Vector;

/**
 * User: todds
 * Date: 11/13/11
 * Time: 12:19 PM
 */
public interface ProcessRecordSetList<T> {
    public Vector<T> processRecords(Vector<dbobject.dbrow> vRows);
}
