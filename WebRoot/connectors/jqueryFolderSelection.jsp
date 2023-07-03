<!-- connector file for displaying folder structure -->

<%@ page
	import="java.io.File,java.io.FilenameFilter,java.util.Arrays,java.util.Map,java.util.HashMap,java.util.List,java.util.ArrayList,java.util.StringTokenizer,
	java.util.Collections,java.util.Comparator" %>
	  <jsp:useBean id="folderBean" scope="request" class="com.peniel.beans.FolderBean" />
	
<%
    String dir = request.getParameter("dir");
   	dir = java.net.URLDecoder.decode(dir, "UTF-8");
   	//String data = request.getParameter("data");
   //	String data = (String)request.getSession().getAttribute("folderData");
 	List<String> pathArraydata = (List<String>)request.getSession().getAttribute("folderData");
    int cid	= Integer.parseInt(request.getSession().getAttribute("comid").toString());

   	//System.out.println("dir ***********"+dir);
   	//System.out.println("Folder data -----> "+data);
   	
   	   	
 	if (dir == null) {
    	return;
	}
	if (dir.charAt(dir.length()-1) == '\\') {
    	dir = dir.substring(0, dir.length()-1) + "/";
	} else if (dir.charAt(dir.length()-1) != '/') 
	{
	    dir += "/";
	}
	
	List<String> pathArray = new ArrayList<String>();
	List<String> dirArray = new ArrayList<String>();
	if(dir.equalsIgnoreCase("/"))
	{
		
		dirArray=pathArraydata;
	}
	else
	{
		pathArray = folderBean.getFolderNameGridHTML(""+cid,dir);
		
		
	}
	    //Get search data in pathArray
	  /*   StringTokenizer st = new StringTokenizer(data,",");
	    while (st.hasMoreElements()) {
	    	    pathArray.add((String)st.nextElement());	    
		} */
	    
	    //Sort pathArray
		//Collections.sort(pathArray);
       
         
	    //Display pathArray
	    for(int j=0; j<pathArray.size(); j++)
	    {
	    	String path = pathArray.get(j);
	    	//Get all children of dir from pathArray and add it to dirArray List if it does not exists
	    	String subdir = "";
	    	
	    	//System.out.println("Path " +path);
	    	//System.out.println("dir "+dir);
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
		//System.out.println("File array in jqueryFolderTree");
		out.print("<ul class=\"jqueryFileTree\" style=\"display: none;\">");
		// All dirs
		for (String file : files) {
		    
			out.print("<li class=\"directory collapsed\"><a href=\"#\"  style=\"text-align:left\" onclick=\"selectFolder(\'"+dir+file+"')\" rel=\"" 
			+ dir + file + "/\">"
					+ file + "</a></li>");
					
			//System.out.println(""+"<li class=\"directory collapsed\"><a href=\"#\"  style=\"text-align:left\" oncontextmenu=\"showContextMenu(\'"+dir+file+"',event,'contextMenu')\"   rel=\"" + dir + file + "/\">"
			//+ file + "</a></li>");
					
		}
		
		out.print("</ul>");
		out.println("<script type='text/javascript'>$('#my_popup').popup('hide');</script>");

%>
<script type="text/javascript">

function selectFolder(path)
{
	if(fView =="advView")
	{
		document.getElementById("folderName").value = path;
		document.getElementById('chkResetFolder1').checked = false;
	}
	else if(fView == "fView")
	{
		document.getElementById("folderNameFView").value = path;
		document.getElementById('chkResetFolder').checked = false;
	
		
	}
			getfiles();
	
}
function resetFolder(checkbox)
{
	if(document.getElementById('chkResetFolder').checked && fView =="advView" )
	{
		document.getElementById("folderName").value = "";
	}
	else if(document.getElementById('chkResetFolder1').checked && fView == "fView")
	{
		document.getElementById("folderNameFView").value = "";
		document.getElementById('fileTreeDemo_4FView').innerHTML = "";
	}
	
}
</script>
