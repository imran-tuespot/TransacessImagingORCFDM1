package com.peniel.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Vector;

/**
 * User: todds
 * Date: 11/16/11
 * Time: 11:47 PM
 */
public class FileProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileProcessor.class);

    public Vector<String> getTempDownloadFilNameList(String tempdir, int userId) {
        String dir = tempdir + File.pathSeparator + userId + File.pathSeparator + "documents" + File.pathSeparator;
        File directory = new File(dir + "*");
        Vector<String> retval = new Vector<String>();

        for (String fileName : directory.list()) {
            retval.add(fileName);
        }

        return retval;
    }


}
