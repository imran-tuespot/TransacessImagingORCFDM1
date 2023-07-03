<%@ page
	import="java.io.File,java.io.FilenameFilter,java.util.Arrays,java.util.Map,java.util.HashMap,java.util.List,java.util.ArrayList,java.util.StringTokenizer,
	java.util.Collections,java.util.Comparator" %>
<%
    //System.out.println("Inside jqueryFileTree.jsp");
    String dir = request.getParameter("dir");
   	dir = java.net.URLDecoder.decode(dir, "UTF-8");
    String data = (String)request.getSession().getAttribute("data");
   	//System.out.println("dir ***********"+dir);
   	//System.out.println("data -----> "+data);
   	
   	if(data.isEmpty()){
   	%>   
<script type="text/javascript">  
	if(fView == "fView")
	{
		document.getElementById("folderView").style.display = 'none';
		document.getElementById("fileView").style.display = 'none';
		document.getElementById("noResults").style.display = 'block';
	}
	else{
	
    	document.getElementById("folderView").style.display = 'none';
		document.getElementById("fileView").style.display = 'none';
		document.getElementById("noResults").style.display = 'block';
	}
   
</script >  
<%}	

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
		
	
	    //Get search data in pathArray
	    StringTokenizer st = new StringTokenizer(data,",");
	    while (st.hasMoreElements()) {
	    	    pathArray.add((String)st.nextElement());	    
		}
	    
	    //Sort pathArray
		Collections.sort(pathArray);
       
         
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
	    		int beginIndex = (path.indexOf(dir, 0)+(dir.length()-1));
	    		int endIndex = path.indexOf('/', (path.indexOf(dir, 0)+(dir.length()-1))+1);
	    		
	    		//System.out.println("Begin index "+(path.indexOf(dir, 0)+(dir.length()-1)));
	    		//System.out.println("End index "+ path.indexOf('/', (path.indexOf(dir, 0)+(dir.length()-1))+1));
	    		if(endIndex > 0)
	    		{
	    			subdir = path.substring(beginIndex+1,endIndex);    		
	    			//System.out.println("Subidr "+ subdir);
	    		}
	    		
	    	}
	    	if(!subdir.equalsIgnoreCase("") && !dirArray.contains(subdir) && !subdir.contains("."))
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
		//System.out.println("File array in jqueryFileTree");
		out.print("<ul class=\"jqueryFileTree\" style=\"display: none;\">");
		// All dirs
		for (String file : files) {
		    
			out.print("<li class=\"directory collapsed\"><a href=\"#\" onclick=\"showFiles(\'"+dir+file+"','"+data+"')\" style=\"text-align:left\"  rel=\"" + dir + file + "/\">"
					+ file + "</a></li>");
				
		}
		// All files
		/*for (String file : files) {
				int dotIndex = file.lastIndexOf('.');
				String ext = dotIndex > 0 ? file.substring(dotIndex + 1) : "";
				System.out.println("rel "+dir+file);		
				out.print("<li class=\"file ext_" + ext + "\"><a href=\"#\" rel=\"" + dir + file + "\">"
					+ file + "</a></li>");
		    	}*/
		out.print("</ul>");
    //}
%>
<script language="javascript">
function showFiles(rootDir,data)
{
    //alert("rootdir "+rootDir + " "+fView);
    if(fView == "advView")
    {
		$('#fileTreeDemo_4').fileTree({ root: rootDir, script: 'connectors/jqueryFileTree1User.jsp', folderEvent: 'click', expandSpeed: 750, collapseSpeed: 750, expandEasing: 'easeOutBounce', collapseEasing: 'easeOutBounce', loadMessage: 'Un momento...' }, function(file) { 
		});
	}
	else if(fView = "fView")
	{
		$('#fileTreeDemo_4FView').fileTree({ root: rootDir, script: 'connectors/jqueryFileTree1User.jsp', folderEvent: 'click', expandSpeed: 750, collapseSpeed: 750, expandEasing: 'easeOutBounce', collapseEasing: 'easeOutBounce', loadMessage: 'Un momento...' }, function(file) { 
							//alert(file);
		});
	}
}
</script>