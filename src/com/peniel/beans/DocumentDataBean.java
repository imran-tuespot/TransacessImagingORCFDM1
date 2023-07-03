package com.peniel.beans;

import com.peniel.bus.vo.DocumentData;
import com.peniel.dao.DocumentDataDAO;

public class DocumentDataBean 
{
    public static String getFilenameByVersion(String documentId,long Version)
	{
        DocumentDataDAO documentDataDAO = new DocumentDataDAO();
    	DocumentData docData;
    	String fileName = "";
		docData = documentDataDAO.findFilenameByVersion(Long.parseLong(documentId), Version);
		if(docData != null)
		{
			fileName =docData.getFilename()+":::"+docData.getActualfilename()+":::"+ docData.getCreateDate() ;
		}
		
		return fileName;
	}
}
