package com.peniel.utilities;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: todds
 * Date: 11/7/11
 * Time: 6:32 PM
 */
public class FileNameProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileNameProcessor.class);

    public static final int OTHER_FILE = 0;
    public static final int PDF_FILE = 1;
    public static final int EXCEL_FILE = 2;
    public static final int WORD_FILE = 3;
    public static final int JPG_FILE = 4;
    public static final int TIFF_FILE = 5;
    public static final int ZIP_FILE = 6;

    public static final String[] pdfValues = {"pdf","PDF"};
    public static final String[] excelValues = {"xls", "xlsx"};
    public static final String[] wordValues = {"doc", "docx"};
    public static final String[] jpgValues = {"jpg", "jpeg"};
    public static final String[] tiffValues = {"tiff", "tif"};
    public static final String[] zipValues = {"zip", "zipx"};

    public static int fileType(String filename) {
        String ext = fileExtension(filename);

        if (ext == null) {
            return OTHER_FILE;
        }
        for (String val : pdfValues)
            if (StringUtils.equalsIgnoreCase(ext, val))
                return PDF_FILE;

        for (String val : excelValues)
            if (StringUtils.equalsIgnoreCase(ext, val))
                return EXCEL_FILE;

        for (String val : wordValues)
            if (StringUtils.equalsIgnoreCase(ext, val))
                return WORD_FILE;

        for (String val : jpgValues)
            if (StringUtils.equalsIgnoreCase(ext, val))
                return JPG_FILE;

        for (String val : tiffValues)
            if (StringUtils.equalsIgnoreCase(ext, val))
                return TIFF_FILE;
        
        for (String val : zipValues)
            if (StringUtils.equalsIgnoreCase(ext, val))
                return ZIP_FILE;

        return OTHER_FILE;
    }

    public static String fileExtension(String filename) {
        if (filename == null) return null;
        int loc = filename.lastIndexOf(".");

        if (loc < 1) return null;

        return filename.substring(loc + 1);
    }
}
