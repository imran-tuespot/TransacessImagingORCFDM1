<%@ page
	import="java.io.File,java.io.FilenameFilter,java.util.Arrays,java.util.Map,java.util.HashMap,java.util.List,java.util.ArrayList,java.util.StringTokenizer,
	java.util.Collections,java.util.Comparator" %>
<%
    String dir = request.getParameter("dir");
   	dir = java.net.URLDecoder.decode(dir, "UTF-8");
   	//String data = request.getParameter("data");
   	String data = (String)request.getSession().getAttribute("data");   	
    //System.out.println("Inside jqueryFileTree1.jsp data "+data);
   
    
 	if (dir == null) {
    	return;
	}
	if (dir.charAt(dir.length()-1) == '\\') {
    	dir = dir.substring(0, dir.length()-1) + "/";
	} else if (dir.charAt(dir.length()-1) != '/') 
	{
	    dir += "/";
	}
	
	dir = java.net.URLDecoder.decode(dir, "UTF-8");
	
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
	    	//Get all children of dir from pathArray and add it to fileArray List if it does not exists
	    	String subdir = "";
	    	
	    	//System.out.println("Path " +path);
	    	//System.out.println("dir "+dir);
	    	if(path.startsWith(dir))//If Path contains dir 
	    	{
	    		int beginIndex = (path.indexOf(dir, 0)+(dir.length()-1));
	    		int endIndex = path.indexOf('/', (path.indexOf(dir, 0)+(dir.length()-1))+1);
	    		
	    		//System.out.println("Begin index "+(path.indexOf(dir, 0)+(dir.length()-1)));
	    		//System.out.println("End index "+ path.indexOf('/', (path.indexOf(dir, 0)+(dir.length()-1))+1));
	    		if(endIndex > 0)
	    		{
	    			subdir = path.substring(beginIndex+1,endIndex);    
	    			if(subdir.contains("."))
	    			{
	    				subdir = path.substring(beginIndex+1,path.length());
	    			}		
	    			//System.out.println("Subdir "+ subdir);
	    		}
	    		
	    	}
	    	if(!subdir.equalsIgnoreCase("") && !dirArray.contains(subdir) && subdir.contains("."))
	    	{
	    		//int count = StringUtils.countMatches(subdir, ".");
	    		//if(count == 1)
	    		   		dirArray.add(subdir);
	    	}
	    	
	        
	    }
       
    	//Display dirArray
	    for(int k=0; k< dirArray.size(); k++)
	    {
	    	//System.out.println("dirArray "+k+" " + dirArray.get(k));
	    }			
   
	
		
   		String[] files = new File(dir).list(new FilenameFilter() 
		{
		    public boolean accept(File dir, String name) {
				return name.charAt(0) != '.';
		    }
		});
		files = dirArray.toArray(new String[dirArray.size()]);
		Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
		//System.out.println("File array in jqueryFileTree1");
		
		for(int i=0; i< files.length; i++)
		{
			//System.out.println("files "+files[i]);
		}
		if(files.length > 0)
		{
			out.print("<ul class=\"jqueryFileTree\" style=\"display: none;\">");
			// All Files
			for (String file : files) {
			    String[] f = file.split("#");
			    //file = f[0].toString().substring(0,f[0].toString().length()-1)		    
			    file = f[0].toString();
			    String filePath = f[1].toString();
			    //System.out.println("file "+file + " filePath "+filePath);
			    int dotIndex = f[0].lastIndexOf('.');
					String ext = dotIndex > 0 ? file.substring(dotIndex + 1) : "";
					out.print("<li class=\"file ext_" + ext + "\"><a href=\"#\"  onclick=\"javascript:getDocumentData(\'"+filePath+"')\" style=\"text-align:left\"  rel=\"" + dir + file + "\">"
					+ file + "</a></li>");
			}
				out.print("</ul>");
		}
		else{
			out.print("<div><h5>This folder is empty.</h5></div>");
		}
			
    
%>


<body>
<div style="display:none; "   id="fileMenu">
        <table   border="0" cellpadding="0" cellspacing="0" 
            style="font-family: Verdana, Arial, Helvetica, sans-serif;
				font-size: 11px;
				background: #EEE;
				padding: 5px;border: thin solid #808080; cursor: default;" width="140px" 
            bgcolor="White" >
           
            <tr>
                <td >
                    <a id="openDetails" style="padding:0px;" class="ContextItem">File Properties</a>
                </td>
            </tr>
        </table>
  </div>

</body>
