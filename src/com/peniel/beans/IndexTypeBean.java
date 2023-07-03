package com.peniel.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import com.peniel.bus.vo.IndexType;
import com.peniel.bus.vo.SearchData;
import com.peniel.dao.IndexTypeDAO;
import com.peniel.dao.SearchDataDAO;


public class IndexTypeBean 
{
	IndexTypeDAO indexTypeDao = new IndexTypeDAO();
	 IndexType indexTypeData = new IndexType();
    // Vector indexTypeList = new Vector();
	@SuppressWarnings("unchecked")
	public String getIndexVals(String cId)
	 {
		 SearchDataDAO searchDataDao = new SearchDataDAO();
		 Vector indexValues = searchDataDao.findByIndexVals("Company_Id", cId);
		 SearchData searchData = new SearchData();
		 String indexValArr = "";

		 if(indexValues.size() > 0)
			{
				for(int i=0; i < indexValues.size(); i++ )
				{
					searchData = (SearchData) indexValues.get(i);
					indexValArr += searchData.getIndexData()+",";					

				}
			}
		 
		
		    // System.out.println(indexValArr);
		 
		 return indexValArr;
		 
		 
	 }
	public String getIndexType(String indexTypeId, String cId)
	{
		String indexType = "";
		indexTypeData = indexTypeDao.findByIdCompany(indexTypeId, cId);
		
	  	indexType = indexTypeData.getIndexType();
	  	return indexType;
	}
	public static String getIndexTypeGridHTML(String cId)
	{
		Vector indexTypeList = new Vector();
		StringBuffer htmlGrid = new StringBuffer();
		IndexTypeDAO indexTypeDAO = new IndexTypeDAO();
		IndexType indexType = new IndexType();
		//Get the projects from the database
		indexTypeList = indexTypeDAO.findByProperty2("Company_ID",cId,"INDEX_TYPE asc");
		
		
		if(indexTypeList.size() > 0)
		{
		     String funct = "";
			//Form the html markup
			for(int i=0; i < indexTypeList.size(); i++ )
			{
				
				indexType = (IndexType) indexTypeList.get(i);
				funct = "javascript:deleteRow('"+(i+1)+"','"+indexType.getIndexType()+"')";
				
				htmlGrid.append("\n <tr style=\"font-size:11px;font-family: Roboto;border-bottom: solid 1px #CCC;\">")
				
			    .append("\n <td  width='15%'  ><p>"+(i+1)+"</p></td>")
			    
				.append("\n <td  width='60%' id='indexType"+(i+1)+"'>"+indexType.getIndexType()+"</td>")	
				.append("\n <td  width='15%' id='deleteIndexType"+(i+1)+"' ><a href=\""+funct+"\" ><i class=\"zmdi_large zmdi-delete\"></i></a></td>")
				
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

