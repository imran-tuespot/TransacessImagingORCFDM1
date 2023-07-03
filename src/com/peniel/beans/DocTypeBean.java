package com.peniel.beans;


import java.util.Vector;
import com.peniel.bus.vo.DocumentType;
import com.peniel.dao.DocumentTypeDAO;


public class DocTypeBean 
{
	DocumentTypeDAO documentTypeDao = new DocumentTypeDAO();
	DocumentType documentTypeData = new DocumentType();
	@SuppressWarnings("unchecked")
	
	public String getDocumentType(String documentTypeId, String cId)
	{
		String documentType = "";
		documentTypeData = documentTypeDao.findByIdCompany(documentTypeId, cId);
		
	  	documentType = documentTypeData.getDocumentType();
	  	return documentType;
	}
	public static String getDocumentTypeGridHTML(String cId)
	{
		Vector documentTypeList = new Vector();
		StringBuffer htmlGrid = new StringBuffer();
		DocumentTypeDAO documentTypeDAO = new DocumentTypeDAO();
		DocumentType documentType = new DocumentType();
		//Get the projects from the database
		documentTypeList = documentTypeDAO.findByProperty2("Company_ID",cId,"DOCUMENT_TYPE asc");
		
		
		if(documentTypeList.size() > 0)
		{
		     String funct = "";
			//Form the html markup
			for(int i=0; i < documentTypeList.size(); i++ )
			{
				
				documentType = (DocumentType) documentTypeList.get(i);
				//funct = "javascript:deleteRow('"+(i+1)+"','"+documentType.getDocumentType()+"')";
				funct = "javascript:deleteRow('delete','"+documentType.getDocumentType()+"')";
				
				htmlGrid.append("\n <tr style=\"font-size:11px;font-family: Roboto;border-bottom: solid 1px #CCC;\">")
				
			    .append("\n <td  width='15%'  ><p>"+(i+1)+"</p></td>")
			    
				.append("\n <td  width='60%' oncontextmenu=\"showContextMenu(\'documentType"+(i+1)+"',event,'contextMenu','"+documentType.getDocumentType()+"')\"  id='documentType"+(i+1)+"'>"+documentType.getDocumentType()+"</td>")	
				.append("\n <td  width='15%' id='deleteDocumentType"+(i+1)+"' ><a href=\""+funct+"\" ><i class=\"zmdi_large zmdi-delete\"></i></a></td>")
				
				.append("\n </tr>");
				
			}		
		}
		//System.out.println("htmlGrid in indexTypeBean....."+htmlGrid);
	return htmlGrid.toString();
	}
	
	
	public static String[] splitString(String list,String delimiter) 
	{
		String[] temp;		 
		temp = list.split(delimiter);
		return temp;
	}
	
}

