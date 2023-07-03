package com.peniel.common;

import java.util.Vector;

/**
 * User: todds
 * Date: 11/13/11
 * Time: 12:13 PM
 */
public interface ProcessRecordSet<T> {
    public T processRecords(Vector<dbobject.dbrow> vRows);
}
