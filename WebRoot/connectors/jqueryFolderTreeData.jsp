<!-- connector file for create new folders page -->

<%@ page
	import="java.io.File,java.io.FilenameFilter,java.util.Arrays,java.util.Map,java.util.HashMap,java.util.List,java.util.ArrayList,java.util.StringTokenizer,
	java.util.Collections,java.util.Comparator,org.apache.commons.lang.StringUtils,java.util.*,java.util.Map.Entry" %>
	  <jsp:useBean id="folderBean" scope="request" class="com.peniel.beans.FolderBean" />
	
<%
    String dir = request.getParameter("dir");
   	dir = java.net.URLDecoder.decode(dir, "UTF-8");
      int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());

 List<String> pathArraydata= new ArrayList<String>();
   	String propertyId = request.getParameter("propertyId");
 	String flag = request.getParameter("flag");

   	
   //	propertyId="/800220949/143-10002";
     
   	   		pathArraydata.add(propertyId);
   	   		
   	   	if(!StringUtils.isEmpty(flag))
  		 {
  	if(!propertyId.startsWith("/"))
 	   		propertyId="/"+propertyId;
 	   		if(!propertyId.endsWith("/"))   	   			
 	   		propertyId=propertyId+"/";
 	   		
 	   		dir=propertyId;
  		 }
   	     // 	dir="/"+propertyId+"/";
	
	
	List<String> pathArray = new ArrayList<String>();
	List<String> dirArray = new ArrayList<String>();
	 Map<String,Integer> countMap=new HashMap<String,Integer>();
 	
 if(!StringUtils.isEmpty(propertyId)){
	 //	System.out.println("propertyId123455*****"+propertyId);	
	
		
	 pathArray = folderBean.getFolderNameGridHTML(""+cid,propertyId);
		
	
	// if(propertyId.split("/").length == 2 ){
      Map<String,Integer> countMapAttrb=(Map<String,Integer>)request.getSession().getAttribute("countMap");
     // System.out.println("countMapAttrb"+countMapAttrb);
     // System.out.println("pathArray123"+pathArray);
      if(countMapAttrb!=null  && countMapAttrb.containsKey(propertyId.split("/")[1]))
      {
    	  countMap = countMapAttrb;
       }
      else{
    	  request.getSession().removeAttribute("countMap");   
	   countMap=folderBean.findByDataDocFolderMap(""+cid,pathArray);		
		request.getSession().setAttribute("countMap", countMap);
    	  }
    
	 	
    //   }
		//System.out.println("pathArray"+pathArray);
		//System.out.println("countMap"+countMap);
		
	    //Display pathArray
	    for(int j=0; j<pathArray.size(); j++)
	    {
	    	String path = pathArray.get(j);
	    	//Get all children of dir from pathArray and add it to dirArray List if it does not exists
	    	String subdir = "";
	    	
	    	if(path.startsWith(dir))//Path contains dir 
	    	{
	    		//System.out.println("Path "+path + " starts with dir "+dir);
	    		int beginIndex = (path.indexOf(dir, 0)+(dir.length()-1));
	    		int endIndex = path.indexOf('/', (path.indexOf(dir, 0)+(dir.length()-1))+1);
	    			    		
	    		if(endIndex > 0)
	    		{
	    			subdir = path.substring(beginIndex+1,endIndex);    		
	    			//System.out.println("Subidr "+ subdir);
	    		}
	    		
	    	}
	    	if(!subdir.equalsIgnoreCase("") && !dirArray.contains(subdir))
	    	{   
	    		
	    		dirArray.add(subdir);
	    	}    	
	        
	    }    
	    
	    List<String> dirArrayData = new ArrayList<String>();
   		Set<String> pathData = new LinkedHashSet<String>();
       
        
        Map<String,Integer> map=new HashMap<String,Integer>();


        for(int j=0; j<pathArray.size(); j++)
	    {
	    	String[] path = pathArray.get(j).split("/");
	    
	    	for(int i=0;i<path.length;i++)
	    	{
	    		if(path[i]!="/" && !path[i].isEmpty())
	    		{    
	    			if(!dirArrayData.contains(path[i]))
	 		    	{  
	 		    	
	 		    	
	    				dirArrayData.add(path[i]);
	 		    	} 
	    			
	    			pathData.add(path[i-1]+"@@"+path[i]); 
	    			
	    			
	    		}
	    		  		
	    		
	    	}
	    
	    }
 		  
 		 // System.out.println("pathData"+pathData);
 		 // System.out.println("list"+dirArrayData);
 		  
 		  
 		 for(String data:dirArrayData){
 			int count=0;
 		  for(String path:pathData)
 		  {
 			 String newStr4 = path.split("@@")[0];
 			
 			if(data.startsWith(newStr4))
 			{ 		
 			  map.put(data, count++	);
 			}
 			 }
 		  }
 		   
	    
 		/* for (Entry<String, Integer> entry : map.entrySet()) {
 		    String key = entry.getKey();
 		    int value = entry.getValue();

 		    System.out.printf("%s : %s\n", key, value);
 		} */
	  
		
	
   		String[] files = new File(dir).list(new FilenameFilter() 
		{
		    public boolean accept(File dir, String name) {
				return name.charAt(0) != '.';
		    }
		});
		files = dirArray.toArray(new String[dirArray.size()]);
		Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
	
		out.print("<ul class=\"jqueryFileTree\" id=\"folderDetails\" style=\"display: none;\">");
		// All dirs
		int i = 0;
		int dataLen=0;
		for (String file : files) {
		    String dirId = "dir_"+ i++;
		    if (map.containsKey(file)) {
		    	//int dataLen=folderBean.findByDataDocFolder(""+cid,dir+file) + map.get(file);
		    	
		    	if(countMap != null && countMap.containsKey(file)){
		    		
		    	 dataLen= countMap.get(file)+ map.get(file);
		    	}else
		    	{
		    		
		    		dataLen=map.get(file);
		    	}
		    	
			out.print("<li id=\'"+dirId+"\' class=\"directory collapsed\"><a href=\"#\"  style=\"text-align:left\" onclick=\"selectFolder(\'"+dir+file+"')\"    rel=\"" 
			+ dir + file + "/\">"
					/* + file + "</a></li>"); */ + file + " ( "+ dataLen +" ) </a></li>");
					
		    }
		    else
		    {
		    	
		    //	int dataLen=folderBean.findByDataDocFolder(""+cid,dir+file) + map.get(file);
				out.print("<li id=\'"+dirId+"\' class=\"directory collapsed\"><a href=\"#\"  style=\"text-align:left\" onclick=\"selectFolder(\'"+dir+file+"')\" oncontextmenu=\"showContextMenu(\'"+dir+file+"',event,'contextMenu',\'"+dirId+"')\"    rel=\"" 
				+ dir + file + "/\">"
						/* + file + "</a></li>"); */ + file + " ( "+ 0 +" ) </a></li>");
				
		    }
			//System.out.println(""+"<li class=\"directory collapsed\"><a href=\"#\"  style=\"text-align:left\" oncontextmenu=\"showContextMenu(\'"+dir+file+"',event,'contextMenu')\"   rel=\"" + dir + file + "/\">"
			//+ file + "</a></li>");
					
		}
		
		out.print("</ul>");
 }
/* 		out.println("<script type='text/javascript'>$('#my_popup').popup('hide');</script>");
 */
%>
<script type="text/javascript">

function selectFolder(path)
{

	 displayTreefolderStructure(path);
	getFilesist(path);
	
}

</script>

<body>


</body>
