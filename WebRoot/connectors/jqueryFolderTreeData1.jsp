<!-- connector file for create new folders page -->

<%@ page
	import="java.io.File,java.io.FilenameFilter,java.util.Arrays,java.util.Map,java.util.HashMap,java.util.List,java.util.ArrayList,java.util.StringTokenizer,
	java.util.Collections,java.util.Comparator" %>
	  <jsp:useBean id="folderBean" scope="request" class="com.peniel.beans.FolderBean" />
	
<%
    String dir = request.getParameter("dir");
   	dir = java.net.URLDecoder.decode(dir, "UTF-8");
      int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());

 List<String> pathArraydata= new ArrayList<String>();
   	String propertyId = request.getParameter("propertyId");
   	
   //	propertyId="/800220949/143-10002";
   
   
   	   		pathArraydata.add(propertyId);
   	   		
   	   		if(!propertyId.startsWith("/"))
   	   		propertyId="/"+propertyId;
   	   		if(!propertyId.endsWith("/"))   	   			
   	   		propertyId=propertyId+"/";
   	   		
   	   		dir=propertyId;
   	   		
	
	List<String> pathArray = new ArrayList<String>();
	List<String> dirArray = new ArrayList<String>();
	
		pathArray = folderBean.getFolderNameGridHTML(""+cid,propertyId);
		 
	        
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
		
		for (String file : files) {
		    String dirId = "dir_"+ i++;
		    
			out.print("<li id=\'"+dirId+"\' class=\"directory collapsed\"><a href=\"#\"  style=\"text-align:left\" onclick=\"selectFolder(\'"+dir+file+"')\" oncontextmenu=\"showContextMenu(\'"+dir+file+"',event,'contextMenu',\'"+dirId+"')\"    rel=\"" 
			+ dir + file + "/\">"
					+ file + "</a></li>");
					
			//System.out.println(""+"<li class=\"directory collapsed\"><a href=\"#\"  style=\"text-align:left\" oncontextmenu=\"showContextMenu(\'"+dir+file+"',event,'contextMenu')\"   rel=\"" + dir + file + "/\">"
			//+ file + "</a></li>");
					
		}
		
		out.print("</ul>");
/* 		out.println("<script type='text/javascript'>$('#my_popup').popup('hide');</script>");
 */
%>
<script type="text/javascript">

function selectFolder(path)
{
	
	getFilesist(path);
	
}
</script>

<body>
<div style="display:none; "   id="contextMenu">
        <table id="contextMenu"  border="0" cellpadding="0" cellspacing="0" 
            style="font-family: Verdana, Arial, Helvetica, sans-serif;
				font-size: 11px;
				background: #EEE;
				padding: 5px;border: thin solid #808080; cursor: default;" width="100px" 
            bgcolor="White" >
            <tr>
                <td >
                    <a id="newFolder" class="ContextItem">New Folder</a>
                </td>
            </tr>
            <tr>
                <td >
                <a  id="editFolder" class="ContextItem">Edit Folder</a>
                </td>
            </tr>
            <tr>
                <td >
                    <a id="deleteFolder" class="ContextItem">Delete Folder</a>
                </td>
            </tr>
        </table>
  </div>

</body>
