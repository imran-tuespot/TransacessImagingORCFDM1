package com.peniel.beans;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.Set;
import java.util.Map;

import com.peniel.bus.vo.ProjectDocument;
import com.peniel.dao.DropDownDAO;

import javax.servlet.http.HttpServletRequest;


import com.peniel.dao.ProjectDocumentDAO;


public class ProjectDocumentBean 
{
	private static Calendar getCalendarForLastMonth() //Get calendar for last month
	{     
		Calendar calendar = GregorianCalendar.getInstance();     
		calendar.add(Calendar.MONTH, -1);		
		return calendar; 
	} 
	
	//Get 1st date of last month
	public static Date getStartDate()  
	{     
		Date begining;      
		         
		Calendar calendar = getCalendarForLastMonth();         
		calendar.set(Calendar.DAY_OF_MONTH,                 
		calendar.getActualMinimum(Calendar.DAY_OF_MONTH));         
		setTimeToBeginningOfDay(calendar);         
		begining = calendar.getTime();    
		return begining;
	}
	private static void setTimeToBeginningOfDay(Calendar calendar) 
	{     
		calendar.set(Calendar.HOUR_OF_DAY, 0);     
		calendar.set(Calendar.MINUTE, 0);     
		calendar.set(Calendar.SECOND, 0);     
		calendar.set(Calendar.MILLISECOND, 0); 
	} 
	//end date - 42 days(6 Weeks) before current date
	public static Date getEndDate() 
	{     
		Date end; 
		Calendar calendar = GregorianCalendar.getInstance();     
		calendar.setTime(new Date());         
		calendar.add(Calendar.DATE, -42);	    
		end = calendar.getTime(); 
		return end;
	} 
	
	public static String getProjectDocumentHTML(int cId,String beginDate, String endDate)
	{
		HashMap hashMap = new HashMap();
		StringBuffer htmlGrid = new StringBuffer();
		ProjectDocumentDAO projectDocumentDAO = new ProjectDocumentDAO();
		
		//Get the projects from the database
		hashMap = ProjectDocumentDAO.getProjectDocuments(cId,beginDate,endDate);
		Set set = hashMap.entrySet();
		String strProjectDocumentLists = "";
		
		// Get an iterator
		Iterator it = set.iterator();
		
		while(it.hasNext()) 
		{
			Map.Entry me = (Map.Entry)it.next();			
			strProjectDocumentLists = ""+ me.getValue();
		} 	
		
		if(strProjectDocumentLists.length() > 0)
		{
			//Parse the string
			String[] strProjectlist;			
			
			strProjectlist = splitString(strProjectDocumentLists,":");
			
			//Form the html markup
			for(int i=0; i < strProjectlist.length; i++ )
			{
				
				System.out.println("project num ----->  "+strProjectlist[i]);
				SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd");
				
				//Get data associated with project num
				ProjectDocument projectDocument = ProjectDocumentDAO.findById(strProjectlist[i],cId,beginDate,endDate);
				
				String entryDate = projectDocument.getEntry_date();
				if(entryDate != null)
				{
					entryDate = entryDate.substring(0,10);
				}
				String dueDate = projectDocument.getDue_Date();
				if(dueDate != null)
				{
					dueDate = dueDate.substring(0,10);
				}	
				String emails = projectDocument.getEmails();
				String[] emailList = new String[1];
				if(emails != null)
				{
					 emailList = splitString(emails,",");
				}	
				
								
				htmlGrid.append("\n <tr style=\"font-size:11px;font-family: Verdana;\">")
				
			    .append("\n <td width='5%'>")
				.append("\n <input type=\"checkbox\" id='checkbox"+(i+1)+"' name=\"ckbox\" onclick=\"javascript:checkBoxValidate("+(i+1)+");\">")
				.append("\n </td>")
				
			    .append("\n <td width='5%' >"+(i+1)+"</td>")
			    
				.append("\n <td width='15%' id='projectNumber"+(i+1)+"'>"+strProjectlist[i]+"</td>")
				
				.append("\n <td width='15%' id='entryDate"+(i+1)+"'>"+entryDate+"</td>")
				.append("\n <td width='15%' id='dueDate"+(i+1)+"'>"+dueDate+"</td>")
				
				.append("\n <td width='15%'>")
				.append("\n <div id= 'divEmail"+(i+1)+"'>")
				.append("\n <a href=\"javascript:toggle_visibility('divEmail"+(i+1)+"','lnkEmail"+(i+1)+"');\">")
				.append("\n <div id='lnkEmail"+(i+1)+"'>[+] Expand </div>")
				.append("\n </a>");
				for(int k=0; k < emailList.length; k++ )
				{		
					 htmlGrid.append("\n <div id='emailTbl"+k+"' style=\"display:none\">"+emailList[k]+"</div>");				
				}
				htmlGrid.append("\n </div>");
				htmlGrid.append("\n </td>");
				
				/*htmlGrid.append("\n <td width='25%'>")
				.append("\n <div id= 'div"+(i+1)+"'>")
				.append("\n <a href=\"javascript:toggle_visibility('div"+(i+1)+"','lnk"+(i+1)+"');\">")
				.append("\n <div id='lnk"+(i+1)+"'>[+] Expand </div>")
				.append("\n </a>");			
				for(int j=1; j < documentList.length; j++ )
				{		
					 htmlGrid.append("\n <div style=\"display:none\">"+getDocType(documentList[j],Integer.toString(cId))+"</div>");				
				}
				htmlGrid.append("\n </div>");
				htmlGrid.append("\n </td>");*/
				htmlGrid.append("\n </tr>");			
			}
			
		}
		else
		{
			htmlGrid.append("\n <tr style=\"font-size:13px;font-family: Verdana;\">")
			.append("\n <td align='right' width='5%'></td>")
			.append("\n <td align='right' width='5%'></td>")
			.append("\n <td align='right' width='15%'></td>")
		    .append("\n <td align='right' width='15%'>")
			.append("\n <span>No Records Found!</span>")
			.append("\n </td>")			
			.append("\n <td align='right' width='15%'></td>")
			.append("\n <td align='right' width='15%'></td>")
			.append("\n </tr>");	
			
			
		}
	return htmlGrid.toString();
	}
	
	public static String[] splitString(String list,String delimiter) 
	{
		String[] temp;		 
		temp = list.split(delimiter);
		return temp;
	}
	public static String getDocType(String docTypeId, String compid) {
		
		String select = "select document_type from document_type where company_id = '"+compid+"' and document_type_id = '"+docTypeId+"' ";
		String outputstr = "";
		
		try {
			DropDownDAO dropDownDAO = new DropDownDAO();
			
			outputstr = dropDownDAO.findByQuery("document_type1",select);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			//logger.info("Error :"+e.getMessage());
        }
		return outputstr;
	}
	
}

